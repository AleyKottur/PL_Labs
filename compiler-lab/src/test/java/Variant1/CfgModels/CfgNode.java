package Variant1.CfgModels;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Узел графа потока управления - представляет собой Базовый Блок,
 * привязанный к конкретной функции.
 */
public class CfgNode {
    private static final AtomicInteger ID_COUNTER = new AtomicInteger(0);
    private final String id;
    
    private final List<String> statements = new ArrayList<>(); 
    private String type; 
    private final String functionName; 

    // Основной конструктор
    public CfgNode(String type, String functionName) { 
        this.id = "n" + ID_COUNTER.getAndIncrement();
        this.type = type;
        this.functionName = (functionName != null) ? functionName : "GLOBAL_CODE"; 
    }
    
    // Вспомогательный конструктор
    public CfgNode(String type) {
        this(type, "GLOBAL_CODE");
    }
    
    public String getStatementId(int index) {
        // Уникальный ID: Идентификатор узла (nX) + Индекс оператора (sY)
        return this.id + "s" + index; 
    }
    
    public void addStatement(String stmt) {
        statements.add(stmt);
    }
    
    public String getLabel() {
        return String.join("\\n", statements); 
    }

    public List<String> getStatements() { 
        return statements;
    }

    public String getId() { return id; }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getType() { return type; }
    
    public String getFunctionName() { 
        return functionName;
    }
}