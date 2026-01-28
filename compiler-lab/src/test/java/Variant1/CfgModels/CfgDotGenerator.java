package Variant1.CfgModels;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * Генерирует DOT-файл, представляя каждый Базовый Блок как кластер
 * (подграф) с отдельными узлами для каждого оператора.
 */
public class CfgDotGenerator {

    public static void generateDotFile(ControlFlowGraph cfg, String outputFileName) throws IOException {
        try (PrintWriter writer = new PrintWriter(outputFileName)) {
            writer.println("digraph G {");
            writer.println("    rankdir=TB;");
            writer.println("    fontname=\"Courier\";");
            writer.println("    graph [fontname=\"Courier\"];");
            writer.println("    node [fontname=\"Courier\", fontsize=10, height=0.3, shape=box, style=\"rounded, filled\"];");
            writer.println("    edge [fontname=\"Courier\", arrowsize=0.7];");
            writer.println("");

            Map<String, List<CfgNode>> functions = cfg.getNodesByFunction();

            int funcClusterId = 0;
            for (Map.Entry<String, List<CfgNode>> entry : functions.entrySet()) {
                String funcName = entry.getKey();
                
                // Начинаем КЛАСТЕР ФУНКЦИИ
                writer.printf("    subgraph cluster_func_%d { %n", funcClusterId++);
                writer.printf("        label = \"CFG: %s\";%n", funcName);
                writer.println("        style = \"rounded, filled\";"); 
                writer.println("        color = darkgrey;");
                writer.println("        bgcolor = \"#fafafa\";");
                writer.println("");

                // 2.1 Генерация КЛАСТЕРОВ БАЗОВЫХ БЛОКОВ
                for (CfgNode node : entry.getValue()) {
                    generateBlockCluster(writer, node);
                }
                
                // 2.2 Генерация ребер CFG (между кластерами)
                for (CfgEdge edge : cfg.getEdges()) {
                    if (edge.getSource().getFunctionName().equals(funcName)) {
                        generateCfgEdge(writer, edge);
                    }
                }

                writer.println("    }"); 
                writer.println("");
            }

            writer.println("}");
        }
    }

    /**
     * Генерирует подграф (кластер) для Базового Блока, содержащий узлы для операторов.
     */
    private static void generateBlockCluster(PrintWriter writer, CfgNode node) {
        String bbId = node.getId().substring(1); 
        List<String> statements = node.getStatements();
        
        // Начинаем КЛАСТЕР БАЗОВОГО БЛОКА
        writer.printf("        subgraph cluster_%s { %n", node.getId());
        writer.printf("            label = \"BB%s\";%n", bbId);
        writer.println("            style = \"rounded\";"); 
        
        String lastNodeId = null;

        for (int i = 0; i < statements.size(); i++) {
            String stmt = statements.get(i);
            String stmtId = node.getStatementId(i);
            String shape = "box";
            String fillcolor = "white";
            
            // Специальные типы узлов
            if (node.getType().equals("start") || node.getType().equals("end")) {
                shape = "oval";
                fillcolor = "lightgrey";
            } else if (node.getType().equals("condition") && i == statements.size() - 1) {
                // Только последний оператор в условном BB (само условие) становится ромбом
                shape = "diamond";
                fillcolor = "grey";
            }

            // Генерируем узел для оператора
            String cleanLabel = stmt.replace("\"", "\\\"");
            writer.printf("            %s [label=\"%s\", shape=%s, fillcolor=%s];%n", 
                          stmtId, cleanLabel, shape, fillcolor);

            // Соединяем операторы внутри BB последовательно
            if (lastNodeId != null) {
                writer.printf("            %s -> %s [style=dotted];%n", lastNodeId, stmtId);
            }
            lastNodeId = stmtId;
        }

        writer.println("        }"); // Закрываем кластер BB
    }
    
    /**
     * Генерирует ребра CFG между кластерами BB (от последнего узла в BB до первого в Target BB).
     */
    private static void generateCfgEdge(PrintWriter writer, CfgEdge edge) {
        CfgNode source = edge.getSource();
        CfgNode target = edge.getTarget();
        String label = edge.getLabel();
        
        // 1. Исходный узел: Последний оператор в Source BB
        int sourceStatementCount = source.getStatements().size();
        if (sourceStatementCount == 0) return; 
        String sourceNodeId = source.getStatementId(sourceStatementCount - 1);

        // 2. Целевой узел: Первый оператор в Target BB
        int targetStatementCount = target.getStatements().size();
        if (targetStatementCount == 0) return;
        String targetNodeId = target.getStatementId(0);
        
        String attributes = "";
        
        if (!label.isEmpty()) {
            attributes += "label=\"" + label + "\"";
        }

        // Стиль для True/False
        if (label.equalsIgnoreCase("True")) {
            if (!attributes.isEmpty()) attributes += ", ";
            attributes += "style=bold"; 
        } else if (label.equalsIgnoreCase("False")) {
            if (!attributes.isEmpty()) attributes += ", ";
            attributes += "style=dashed"; 
        }
        
        // Вывод ребра CFG
        if (!attributes.isEmpty()) {
            writer.printf("    %s -> %s [%s];%n", 
                          sourceNodeId, 
                          targetNodeId, 
                          attributes);
        } else {
            writer.printf("    %s -> %s;%n", 
                          sourceNodeId, 
                          targetNodeId);
        }
    }
}