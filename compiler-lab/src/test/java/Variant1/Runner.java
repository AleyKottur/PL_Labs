package Variant1;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import Variant1.CfgModels.*;
import Variant1.CfgModels.Builder.*;
import Variant1.Assembler.*;

import java.io.*;
import java.nio.file.*;

public class Runner {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Usage: java Variant1.Runner <input_file> <output_ast_dot_file> <output_cfg_dot_file>");
            return;
        }

        try {
            // 1. Читаем входной файл
            String inputCode = new String(Files.readAllBytes(Paths.get(args[0])));

            // 2. Создаём лексер и парсер
            ANTLRInputStream input = new ANTLRInputStream(inputCode);
            Variant1Lexer lexer = new Variant1Lexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            Variant1Parser parser = new Variant1Parser(tokens);

            // 3. Настраиваем вывод ошибок в stderr
            parser.removeErrorListeners();
            parser.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                        int line, int charPositionInLine, String msg,
                                        RecognitionException e) {
                    System.err.println("Line " + line + ":" + charPositionInLine + " — " + msg);
                }
            });

            // 4. Запускаем парсинг — ПОЛУЧАЕМ ДЕРЕВО!
            ParseTree tree = parser.source();

            // 5. Проверяем, были ли ошибки
            if (parser.getNumberOfSyntaxErrors() > 0) {
                System.exit(1);
            }

            // 6. ГЕНЕРИРУЕМ DOT-ФАЙЛ AST дерева
            AstDotGenerator.generateDotFile(tree, args[1]);
            System.out.println("AST DOT file successfully saved to: " + args[1]);

            // 7. Строим модель графа потока управления
            ControlFlowGraph cfg = new ControlFlowGraph();

            BasicBlockAnalyzer analyzer = new BasicBlockAnalyzer(cfg);
            analyzer.build(tree);

            // 8. ГЕНЕРИРУЕМ DOT-ФАЙЛ ДИАГРАММЫ ПОТОКА УПРАВЛЕНИЯ
            CfgDotGenerator.generateDotFile(cfg, args[2]);
            System.out.println("CFG DOT file successfully saved to: " + args[2]);

            // 9. ГЕНЕРИРУЕМ АССЕМБЛЕРНЫЙ КОД
            String asmPath = args[0].replace(".txt", ".asm");
            AsmGenerator asmGen = new AsmGenerator(cfg);
            asmGen.generateToFile(asmPath);
            System.out.println("Assembly code saved to: " + asmPath);
            
        } catch (IOException e) {
            System.err.println("IO error: " + e.getMessage());
            System.exit(1);
        }
    }
}