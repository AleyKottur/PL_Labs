package Variant1.CfgModels.Builder;

import Variant1.CfgModels.*;

/**
 * Вспомогательный класс для возврата результата обхода AST:
 * Узел, с которого начинается CFG для данного узла AST (entryNode),
 * и Узел, которым заканчивается CFG для данного узла AST (exitNode).
 */
public class CfgResult {
    public final CfgNode entryNode;
    public final CfgNode exitNode;

    /**
     * Создает CfgResult для простого оператора (один узел).
     */
    public CfgResult(CfgNode singleNode) {
        this.entryNode = singleNode;
        this.exitNode = singleNode;
    }

    /**
     * Создает CfgResult для блока с явными началом и концом.
     */
    public CfgResult(CfgNode entryNode, CfgNode exitNode) {
        this.entryNode = entryNode;
        this.exitNode = exitNode;
    }
}