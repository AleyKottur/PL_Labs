package Variant1.CfgModels;

/**
 * Ребро графа потока управления.
 * Представляет связь между двумя узлами, указывая на возможный переход.
 */
public class CfgEdge {
    /** Исходный узел */
    private final CfgNode source;

    /** Целевой узел */
    private final CfgNode target;

    /** Метка для ребра (например, "True", "False", "" - для безусловного перехода) */
    private final String label;

    public CfgEdge(CfgNode source, CfgNode target, String label) {
        this.source = source;
        this.target = target;
        this.label = label;
    }

    // Getters

    public CfgNode getSource() {
        return source;
    }

    public CfgNode getTarget() {
        return target;
    }

    public String getLabel() {
        return label;
    }
}