package Variant1.CfgModels;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import Variant1.*;
import java.util.*;

/**
 * Анализатор для построения графа потока управления.
 * Реализует логику разбиения кода на базовые блоки и расстановку переходов.
 */
public class BasicBlockAnalyzer extends Variant1BaseVisitor<Void> {
    private final ControlFlowGraph cfg;
    private final List<ProgramPoint> programPoints = new ArrayList<>();
    private final Set<Integer> leaderIndices = new HashSet<>();
    private int currentPointIndex = 0; 
    private String currentFunctionName; 

    public BasicBlockAnalyzer(ControlFlowGraph cfg) {
        this.cfg = cfg;
    }

    /**
     * Запускает процесс анализа AST и формирования CFG.
     */
    public void build(ParseTree tree) {
        if (tree == null) return;
        currentPointIndex = 0;
        leaderIndices.clear();
        programPoints.clear();
        
        visit(tree);
        
        // Помечаем лидеров (начала базовых блоков)
        for (int index : leaderIndices) {
            if (index >= 0 && index < programPoints.size()) {
                programPoints.get(index).isLeader = true;
            }
        }
        
        if (!programPoints.isEmpty()) {
            buildControlFlowGraph();
        }
    }

    // Вспомогательные методы для работы с точками программы

    private void addProgramPoint(ProgramPoint pp) {
        programPoints.add(pp);
        currentPointIndex++;
    }

    private void addProgramPoint(String text, ProgramPoint.ProgramPointType type) {
        addProgramPoint(new ProgramPoint(text, type));
    }

    private void declareLeader(int index) {
        if (index >= 0) {
            leaderIndices.add(index);
        }
    }

    
    //  Рекурсивно собирает текст узла, добавляя необходимые пробелы.
    private String getFullText(ParseTree tree) {
        if (tree instanceof TerminalNode) {
            return tree.getText();
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < tree.getChildCount(); i++) {
            ParseTree child = tree.getChild(i);
            String text = getFullText(child);
            builder.append(text);
            
            // Добавляем пробел после типов данных и запятых
            if (child instanceof Variant1Parser.TypeRefContext || text.equals(",")) {
                builder.append(" ");
            }
            // Добавляем пробелы вокруг операторов сравнения и присваивания для читаемости
            if (text.equals("=") || text.equals("==") || text.equals(">") || text.equals("<")) {
                builder.insert(builder.length() - text.length(), " ");
                builder.append(" ");
            }
        }
        return builder.toString().trim().replace("  ", " ");
    }

    // Реализация визитов для конструкций языка

    @Override
    public Void visitFuncDef(Variant1Parser.FuncDefContext ctx) {
        currentFunctionName = ctx.funcSignature().Identifier().getText(); 
        
        int startOfFunc = currentPointIndex;
        addProgramPoint("START: " + currentFunctionName, ProgramPoint.ProgramPointType.NORMAL);
        declareLeader(startOfFunc); 

        if (ctx.block() != null) {
            visit(ctx.block());
        }

        addProgramPoint("END: " + currentFunctionName, ProgramPoint.ProgramPointType.NORMAL);
        declareLeader(currentPointIndex - 1); 
        return null;
    }

    @Override
    public Void visitVarDecl(Variant1Parser.VarDeclContext ctx) {
        String type = getFullText(ctx.typeRef());
        String vars = getFullText(ctx.varInitList());
        addProgramPoint(type + " " + vars, ProgramPoint.ProgramPointType.NORMAL);
        return null;
    }

    @Override
    public Void visitExprStmt(Variant1Parser.ExprStmtContext ctx) {
        addProgramPoint(getFullText(ctx.expr()), ProgramPoint.ProgramPointType.NORMAL);
        return null;
    }

    @Override
    public Void visitIfStmt(Variant1Parser.IfStmtContext ctx) {
        int condIdx = currentPointIndex;
        ProgramPoint conditionalPP = new ProgramPoint("IF (" + getFullText(ctx.expr()) + ")", ProgramPoint.ProgramPointType.CONDITIONAL);
        addProgramPoint(conditionalPP);
        declareLeader(condIdx);
        
        int thenIdx = currentPointIndex;
        declareLeader(thenIdx);
        visit(ctx.statement(0));
        int endThenIdx = currentPointIndex - 1;

        if (ctx.statement().size() > 1) { // есть else
            int elseIdx = currentPointIndex;
            declareLeader(elseIdx);
            conditionalPP.trueTargetIndex = thenIdx;
            conditionalPP.falseTargetIndex = elseIdx;
            
            visit(ctx.statement(1));
            int endElseIdx = currentPointIndex - 1;
            
            int mergeIdx = currentPointIndex;
            programPoints.get(endThenIdx).jumpTargetIndex = mergeIdx;
            programPoints.get(endElseIdx).jumpTargetIndex = mergeIdx;
            declareLeader(mergeIdx);
        } else { // Только if
            int mergeIdx = currentPointIndex;
            conditionalPP.trueTargetIndex = thenIdx;
            conditionalPP.falseTargetIndex = mergeIdx;
            programPoints.get(endThenIdx).jumpTargetIndex = mergeIdx;
            declareLeader(mergeIdx);
        }
        return null;
    }

    @Override
    public Void visitWhileStmt(Variant1Parser.WhileStmtContext ctx) {
        int conditionalIndex = currentPointIndex;
        ProgramPoint conditionalPP = new ProgramPoint("WHILE (" + getFullText(ctx.expr()) + ")", ProgramPoint.ProgramPointType.CONDITIONAL);
        addProgramPoint(conditionalPP);
        declareLeader(conditionalIndex); 

        int bodyStartIndex = currentPointIndex;
        declareLeader(bodyStartIndex);
        visit(ctx.statement()); 

        // обратная к условию
        programPoints.get(currentPointIndex - 1).jumpTargetIndex = conditionalIndex;

        int exitIndex = currentPointIndex;
        declareLeader(exitIndex);

        conditionalPP.trueTargetIndex = bodyStartIndex;
        conditionalPP.falseTargetIndex = exitIndex; 
        return null;
    }

    @Override
    public Void visitDoWhileStmt(Variant1Parser.DoWhileStmtContext ctx) {
        int bodyStartIndex = currentPointIndex;
        declareLeader(bodyStartIndex); 

        if (ctx.block() != null) {
            visit(ctx.block());
        }

        int conditionalIndex = currentPointIndex;
        ProgramPoint conditionalPP = new ProgramPoint("DO_WHILE_CHECK (" + getFullText(ctx.expr()) + ")", ProgramPoint.ProgramPointType.CONDITIONAL);
        addProgramPoint(conditionalPP);
        declareLeader(conditionalIndex);

        int exitIndex = currentPointIndex;
        declareLeader(exitIndex);

        conditionalPP.trueTargetIndex = bodyStartIndex;
        conditionalPP.falseTargetIndex = exitIndex; 
        return null;
    }

    // Построение итогового графа

    private void buildControlFlowGraph() {
        Map<Integer, CfgNode> bbMap = new HashMap<>();
        List<Integer> sortedLeaders = new ArrayList<>(leaderIndices);
        Collections.sort(sortedLeaders);
        
        for (int i = 0; i < sortedLeaders.size(); i++) {
            int leaderIdx = sortedLeaders.get(i);
            int nextLeaderIdx = (i + 1 < sortedLeaders.size()) ? sortedLeaders.get(i + 1) : programPoints.size();
            
            CfgNode bb = new CfgNode("statement", currentFunctionName); 
            for (int j = leaderIdx; j < nextLeaderIdx; j++) {
                bb.addStatement(programPoints.get(j).statementText);
            }
            
            ProgramPoint last = programPoints.get(nextLeaderIdx - 1);
            if (last.statementText.startsWith("START:")) bb.setType("start");
            else if (last.statementText.startsWith("END:")) bb.setType("end");
            else if (last.type == ProgramPoint.ProgramPointType.CONDITIONAL) bb.setType("condition");

            cfg.addNode(bb);
            bbMap.put(leaderIdx, bb);
        }

        for (int i = 0; i < sortedLeaders.size(); i++) {
            int curIdx = sortedLeaders.get(i);
            CfgNode src = bbMap.get(curIdx);
            int nextIdx = (i + 1 < sortedLeaders.size()) ? sortedLeaders.get(i + 1) : -1;
            if (nextIdx == -1) continue; 

            ProgramPoint last = programPoints.get(nextIdx - 1);
            if (last.type == ProgramPoint.ProgramPointType.CONDITIONAL) {
                cfg.addEdge(src, bbMap.get(last.trueTargetIndex), "True");
                cfg.addEdge(src, bbMap.get(last.falseTargetIndex), "False");
            } else if (last.jumpTargetIndex != -1) {
                cfg.addEdge(src, bbMap.get(last.jumpTargetIndex));
            } else if (!last.statementText.startsWith("END:")) {
                cfg.addEdge(src, bbMap.get(nextIdx));
            }
        }
    }
}