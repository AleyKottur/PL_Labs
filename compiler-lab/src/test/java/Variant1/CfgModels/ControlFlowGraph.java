package Variant1.CfgModels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Основная модель графа потока управления
 */
public class ControlFlowGraph {
    private final List<CfgNode> nodes = new ArrayList<>();
    private final List<CfgEdge> edges = new ArrayList<>();

    public void addNode(CfgNode node) {
        nodes.add(node);
    }

    public void addEdge(CfgNode source, CfgNode target) {
        edges.add(new CfgEdge(source, target, ""));
    }

    public void addEdge(CfgNode source, CfgNode target, String label) {
        edges.add(new CfgEdge(source, target, label));
    }

    public List<CfgNode> getNodes() {
        return Collections.unmodifiableList(nodes);
    }

    public List<CfgEdge> getEdges() {
        return Collections.unmodifiableList(edges);
    }
    
    
    //  Группирует узлы по имени функции для создания кластеров в DOT.
     
    public Map<String, List<CfgNode>> getNodesByFunction() {
        return nodes.stream()
                    .collect(Collectors.groupingBy(CfgNode::getFunctionName));
    }
}