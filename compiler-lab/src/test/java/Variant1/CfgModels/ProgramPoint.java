package Variant1.CfgModels;

/**
 * Представляет одну точку в программе (один оператор или условное выражение).
 * Используется в Проходе 1 BasicBlockAnalyzer.
 */
public class ProgramPoint {
    public enum ProgramPointType {
        NORMAL, CONDITIONAL, UNCONDITIONAL
    }

    public String statementText;
    public ProgramPointType type;
    public boolean isLeader = false;
    
    // Поля для хранения целей переходов (Jumps)
    public int trueTargetIndex = -1;  // Цель для True-ветки (для IF/WHILE)
    public int falseTargetIndex = -1; // Цель для False-ветки (для IF/WHILE)
    public int jumpTargetIndex = -1;  // Цель для безусловного перехода (JUMP/BREAK/конец THEN/ELSE)

    public ProgramPoint(String statementText, ProgramPointType type) {
        this.statementText = statementText;
        this.type = type;
    }
}