package Variant1.Assembler;

import Variant1.CfgModels.*;
import java.io.*;
import java.util.*;

public class AsmGenerator {
    private final ControlFlowGraph cfg;
    private final StringBuilder asm = new StringBuilder();
    private final Map<String, Integer> symbolStack = new LinkedHashMap<String, Integer>();
    private int dataPointer = 0x4000;

    public AsmGenerator(ControlFlowGraph cfg) { this.cfg = cfg; }

    public void generateToFile(String filePath) throws IOException {
        asm.setLength(0);
        buildSymbolTable();
        asm.append("; --- RISC COMPILER OUTPUT ---\nORG 0x0000\n\n");
        
        Map<String, List<CfgNode>> funcMap = cfg.getNodesByFunction();
        for (Map.Entry<String, List<CfgNode>> entry : funcMap.entrySet()) {
            asm.append("; --- Function: ").append(entry.getKey()).append(" ---\n");
            for (CfgNode node : entry.getValue()) {
                asm.append(node.getId()).append(":\n");
                for (String stmt : node.getStatements()) {
                    String clean = stmt.trim();
                    if (clean.isEmpty() || clean.startsWith("START") || clean.startsWith("END")) continue;
                    processStatement(clean);
                }
                processEdges(node);
            }
        }

        FileWriter writer = null;
        try {
            writer = new FileWriter(filePath);
            writer.write(asm.toString());
        } finally {
            if (writer != null) writer.close();
        }
        System.out.println("Компиляция завершена. Файл: " + filePath);
    }

    private void buildSymbolTable() {
        for (CfgNode node : cfg.getNodes()) {
            for (String stmt : node.getStatements()) {
                if (stmt.contains("scan(")) registerVar(extractArg(stmt, "scan("));
                else if (stmt.contains("print(")) registerVar(extractArg(stmt, "print("));
                else if (stmt.contains("=")) {
                    String left = stmt.split("=")[0].trim().replaceAll(".* ", "");
                    if (!left.matches("-?\\d+")) registerVar(left);
                }
            }
        }
    }

    private void registerVar(String name) {
        if (!name.matches("-?\\d+") && !symbolStack.containsKey(name)) {
            symbolStack.put(name, dataPointer);
            dataPointer += 4;
        }
    }

    private void processStatement(String stmt) {
        asm.append("    ; ").append(stmt).append("\n");

        if (stmt.startsWith("scan(")) {
            asm.append("    SCAN R1\n    STW R1, R0, ").append(getAddress(extractArg(stmt, "scan("))).append("\n");
        } 
        else if (stmt.startsWith("print(")) {
            asm.append("    LDW R1, R0, ").append(getAddress(extractArg(stmt, "print("))).append("\n    PRINT R1\n");
        } 
        else if (stmt.startsWith("if") || stmt.startsWith("IF") || stmt.startsWith("while")) {
            String cond = stmt.substring(stmt.indexOf('(') + 1, stmt.lastIndexOf(')')).trim();
            handleExpression(cond, "R3"); 
        } 
        else if (stmt.contains("=")) {
            String[] parts = stmt.split("=");
            String target = parts[0].trim();
            if (target.contains(" ")) target = target.substring(target.lastIndexOf(' ') + 1);
            handleExpression(parts[1].trim().replace(";", ""), "R3");
            asm.append("    STW R3, R0, ").append(getAddress(target)).append("\n");
        }
    }

    private void handleExpression(String expr, String targetReg) {
        String[] ops = {"||", "&&", "==", "!=", "<=", ">=", "<<", ">>", "<", ">", "+", "-", "*", "/", "%", "&", "|", "^"};
        
        for (String op : ops) {
            if (expr.contains(op)) {
                String regex = "\\Q" + op + "\\E";
                String[] parts = expr.split(regex);
                if (parts.length == 2) {
                    loadOperand(parts[0].trim(), "R1");
                    loadOperand(parts[1].trim(), "R2");
                    
                    // Мат. операции
                    switch (op) {
                        case "+":   asm.append("    ADD ").append(targetReg).append(", R1, R2\n"); break;
                        case "-":   asm.append("    SUB ").append(targetReg).append(", R1, R2\n"); break;
                        case "*":   asm.append("    MUL ").append(targetReg).append(", R1, R2\n"); break;
                        case "/":   asm.append("    DIV ").append(targetReg).append(", R1, R2\n"); break;
                        case "&":   asm.append("    AND ").append(targetReg).append(", R1, R2\n"); break;
                        case "|":   asm.append("    OR ").append(targetReg).append(", R1, R2\n"); break;
                        case "^":   asm.append("    XOR ").append(targetReg).append(", R1, R2\n"); break;
                        case "<<":  asm.append("    SHL ").append(targetReg).append(", R1, R2\n"); break;
                        case ">>":  asm.append("    SHR ").append(targetReg).append(", R1, R2\n"); break;
                        case "==":  asm.append("    SUB ").append(targetReg).append(", R1, R2\n"); break;
                        case "!=":  asm.append("    SUB ").append(targetReg).append(", R1, R2\n"); break;
                        case "<":   asm.append("    SLT ").append(targetReg).append(", R1, R2\n"); break;
                        default:    asm.append("    ADD ").append(targetReg).append(", R1, R2\n"); break;
                    }
                    return;
                }
            }
        }
        loadOperand(expr, targetReg);
    }

    private void loadOperand(String val, String reg) {
        val = val.replace("'", "").replace("\"", "");
        
        // 1. ПЕРВЫМ ДЕЛОМ: проверяем, переменная ли это?
        if (symbolStack.containsKey(val)) {
            asm.append("    LDW ").append(reg).append(", R0, ").append(getAddress(val))
               .append(" ; Загрузка переменной ").append(val).append("\n");
        } 
        // 2. Это число?
        else if (val.matches("-?\\d+")) {
            asm.append("    ADDI ").append(reg).append(", R0, ").append(val).append("\n");
        } 
        // 3. Это булево?
        else if (val.equals("true")) {
            asm.append("    ADDI ").append(reg).append(", R0, 1\n");
        } else if (val.equals("false")) {
            asm.append("    ADDI ").append(reg).append(", R0, 0\n");
        } 
        // 4. Это литерал-символ (только если не нашли в переменных)?
        else if (val.length() == 1) {
            int ascii = (int) val.charAt(0);
            asm.append("    ADDI ").append(reg).append(", R0, ").append(ascii)
               .append(" ; ASCII-константа '").append(val).append("'\n");
        }
    }

    private void processEdges(CfgNode node) {
        List<CfgEdge> out = new ArrayList<CfgEdge>();
        for (CfgEdge e : cfg.getEdges()) {
            if (e.getSource().equals(node)) out.add(e);
        }

        if (node.getType().equalsIgnoreCase("condition")) {
            CfgEdge t = null, f = null;
            for (CfgEdge e : out) {
                if (e.getLabel().equalsIgnoreCase("True")) t = e;
                if (e.getLabel().equalsIgnoreCase("False")) f = e;
            }
            if (f != null) asm.append("    BNE R3, R0, ").append(f.getTarget().getId()).append("\n");
            if (t != null) asm.append("    JMP ").append(t.getTarget().getId()).append("\n");
        } else if (!out.isEmpty()) {
            asm.append("    JMP ").append(out.get(0).getTarget().getId()).append("\n");
        }
    }

    private String getAddress(String v) { 
        Integer addr = symbolStack.get(v);
        return (addr != null) ? addr.toString() : "0"; 
    }
    
    private String extractArg(String s, String p) { return s.substring(s.indexOf(p) + p.length(), s.indexOf(')')).trim(); }
}