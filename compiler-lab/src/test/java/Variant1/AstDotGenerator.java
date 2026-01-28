package Variant1;

import org.antlr.v4.runtime.tree.ParseTree;
import java.io.IOException;
import java.io.PrintWriter;


// Генератор AST.
public class AstDotGenerator extends Variant1BaseVisitor<String> {

    private final PrintWriter writer;
    private int nodeCounter = 0;

    // --- Public API ---

    public static void generateDotFile(ParseTree tree, String outputFileName) throws IOException {
        try (PrintWriter writer = new PrintWriter(outputFileName)) {
            AstDotGenerator generator = new AstDotGenerator(writer);
            generator.writeHeader();
            if (tree != null) {
                tree.accept(generator);
            }
            generator.writeFooter();
        }
    }

    private AstDotGenerator(PrintWriter writer) {
        this.writer = writer;
    }

    // --- DOT Helpers ---

    private void writeHeader() {
        writer.println("digraph AST {");
        writer.println("  rankdir=TB;"); // Сверху вниз
        // Устанавливаем единый стиль для всех узлов: прямоугольник, шрифт Courier
        writer.println("  node [shape=box, fontname=\"Courier\", fontsize=11, height=0.3];");
        writer.println("  edge [arrowsize=0.7];");
    }

    private void writeFooter() {
        writer.println("}");
    }

    /**
     * Создает простой прямоугольный узел.
     * @param label Текст внутри прямоугольника
     * @return ID узла для связывания
     */
    private String writeNode(String label) {
        String id = "n" + nodeCounter++;
        // Экранируем кавычки и переносы строк для DOT формата
        String cleanLabel = label.replace("\"", "\\\"").replace("\n", "\\n");
        writer.printf("  %s [label=\"%s\"];%n", id, cleanLabel);
        return id;
    }

    private void writeEdge(String parentId, String childId) {
        if (parentId != null && childId != null) {
            writer.printf("  %s -> %s;%n", parentId, childId);
        }
    }

    // Visitor Implementation

    @Override
    public String visitSource(Variant1Parser.SourceContext ctx) {
        String rootId = writeNode("Program");
        for (Variant1Parser.SourceItemContext item : ctx.sourceItem()) {
            String childId = visit(item);
            writeEdge(rootId, childId);
        }
        return rootId;
    }

    @Override
    public String visitFuncDef(Variant1Parser.FuncDefContext ctx) {
        String funcName = ctx.funcSignature().Identifier().getText();
        String returnType = (ctx.funcSignature().typeRef() != null) 
                            ? ctx.funcSignature().typeRef().getText() 
                            : "void";

        // Один прямоугольник с описанием функции
        String nodeId = writeNode("Func: " + funcName + "\\nType: " + returnType);

        // Ветка аргументов
        if (ctx.funcSignature().argDefList() != null) {
            String argsId = visit(ctx.funcSignature().argDefList());
            writeEdge(nodeId, argsId);
        }

        // Ветка тела функции
        if (ctx.block() != null) {
            String blockId = visit(ctx.block());
            writeEdge(nodeId, blockId);
        }
        
        return nodeId;
    }

    @Override
    public String visitArgDefList(Variant1Parser.ArgDefListContext ctx) {
        String listNode = writeNode("Arguments");
        for (Variant1Parser.ArgDefContext arg : ctx.argDef()) {
            String argId = visit(arg);
            writeEdge(listNode, argId);
        }
        return listNode;
    }

    @Override
    public String visitArgDef(Variant1Parser.ArgDefContext ctx) {
        String type = (ctx.typeRef() != null) ? ctx.typeRef().getText() : "var";
        String name = ctx.Identifier().getText();
        return writeNode(type + " " + name);
    }

    @Override
    public String visitBlock(Variant1Parser.BlockContext ctx) {
        String blockId = writeNode("Block { ... }");
        for (Variant1Parser.StatementContext stmt : ctx.statement()) {
            String stmtId = visit(stmt);
            writeEdge(blockId, stmtId);
        }
        return blockId;
    }

    // Statements

    @Override
    public String visitVarDecl(Variant1Parser.VarDeclContext ctx) {
        String type = ctx.typeRef().getText();
        String declId = writeNode("VarDecl: " + type);
        
        for (Variant1Parser.VarInitContext init : ctx.varInitList().varInit()) {
            String initId = visit(init);
            writeEdge(declId, initId);
        }
        return declId;
    }

    @Override
    public String visitVarInit(Variant1Parser.VarInitContext ctx) {
        String name = ctx.Identifier().getText();
        String initId = writeNode(name);
        
        if (ctx.expr() != null) {
            String exprId = visit(ctx.expr());
            writeEdge(initId, exprId); // Если есть инициализация, рисуем стрелку к значению
        }
        return initId;
    }

    @Override
    public String visitIfStmt(Variant1Parser.IfStmtContext ctx) {
        String ifId = writeNode("IF");
        
        // Состояние
        String condId = visit(ctx.expr());
        writeEdge(ifId, condId);
        
        // then ветка
        String thenLabel = writeNode("Then");
        writeEdge(ifId, thenLabel);
        String thenStmt = visit(ctx.statement(0));
        writeEdge(thenLabel, thenStmt);
        
        // Else ветка
        if (ctx.statement().size() > 1) {
            String elseLabel = writeNode("Else");
            writeEdge(ifId, elseLabel);
            String elseStmt = visit(ctx.statement(1));
            writeEdge(elseLabel, elseStmt);
        }
        
        return ifId;
    }

    @Override
    public String visitWhileStmt(Variant1Parser.WhileStmtContext ctx) {
        String whileId = writeNode("WHILE");
        
        String condId = visit(ctx.expr());
        writeEdge(whileId, condId);
        
        String bodyId = visit(ctx.statement());
        writeEdge(whileId, bodyId);
        
        return whileId;
    }

    @Override
    public String visitDoWhileStmt(Variant1Parser.DoWhileStmtContext ctx) {
        String doId = writeNode("DO-WHILE");
        
        String bodyId = visit(ctx.block());
        writeEdge(doId, bodyId);

        String condId = visit(ctx.expr());
        writeEdge(doId, condId);
        
        return doId;
    }

    @Override
    public String visitBreakStmt(Variant1Parser.BreakStmtContext ctx) {
        return writeNode("break");
    }

    @Override
    public String visitExprStmt(Variant1Parser.ExprStmtContext ctx) {
        // Пропускаем создание узла "ExprStmt", сразу возвращаем само выражение
        return visit(ctx.expr());
    }

    // Expressions

    @Override
    public String visitAssign(Variant1Parser.AssignContext ctx) {
        String opId = writeNode("="); // <-- Создаем узел '='
        
        String leftId = visit(ctx.expr(0));
        writeEdge(opId, leftId);
        
        String rightId = visit(ctx.expr(1));
        writeEdge(opId, rightId);
        
        return opId;
    }

    @Override
    public String visitBinary(Variant1Parser.BinaryContext ctx) {
        String opSymbol = ctx.binOp().getText();
        String opId = writeNode(opSymbol); // <-- Создаем узел '+'

        String left = visit(ctx.expr(0));
        String right = visit(ctx.expr(1));
        
        writeEdge(opId, left);
        writeEdge(opId, right);
        
        return opId;
    }

    @Override
    public String visitUnary(Variant1Parser.UnaryContext ctx) {
        String opId = writeNode(ctx.unOp().getText()); // Унарный оператор (!, -)
        String child = visit(ctx.expr());
        writeEdge(opId, child);
        return opId;
    }

    @Override
    public String visitParen(Variant1Parser.ParenContext ctx) {
        // Пропускаем скобки, возвращаем внутреннее выражение
        return visit(ctx.expr());
    }

    @Override
    public String visitCall(Variant1Parser.CallContext ctx) {
        String callId = writeNode("Call");
        
        String funcId = visit(ctx.expr());
        writeEdge(callId, funcId);
        
        if (ctx.exprList() != null) {
            String argsId = visit(ctx.exprList());
            writeEdge(callId, argsId);
        }
        
        return callId;
    }
    
    @Override
    public String visitIndexer(Variant1Parser.IndexerContext ctx) {
        String idxId = writeNode("Index []");
        
        String arrayId = visit(ctx.expr());
        writeEdge(idxId, arrayId);
        
        if (ctx.exprList() != null) {
            String indexVal = visit(ctx.exprList());
            writeEdge(idxId, indexVal);
        }
        return idxId;
    }

    @Override
    public String visitExprList(Variant1Parser.ExprListContext ctx) {
        String listId = writeNode("List");
        for (Variant1Parser.ExprContext expr : ctx.expr()) {
            String exprId = visit(expr);
            writeEdge(listId, exprId);
        }
        return listId;
    }

    // Листья

    @Override
    public String visitId(Variant1Parser.IdContext ctx) {
        return writeNode(ctx.Identifier().getText());
    }

    @Override
    public String visitLit(Variant1Parser.LitContext ctx) {
        return writeNode(ctx.literal().getText());
    }
}