package Variant1;
// Generated from Variant1.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Variant1Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Variant1Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Variant1Parser#source}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSource(@NotNull Variant1Parser.SourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link Variant1Parser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(@NotNull Variant1Parser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link Variant1Parser#exprStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStmt(@NotNull Variant1Parser.ExprStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Indexer}
	 * labeled alternative in {@link Variant1Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexer(@NotNull Variant1Parser.IndexerContext ctx);
	/**
	 * Visit a parse tree produced by {@link Variant1Parser#funcSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncSignature(@NotNull Variant1Parser.FuncSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link Variant1Parser#doWhileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileStmt(@NotNull Variant1Parser.DoWhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link Variant1Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull Variant1Parser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Variant1Parser#varInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarInit(@NotNull Variant1Parser.VarInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link Variant1Parser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull Variant1Parser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link Variant1Parser#varInitList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarInitList(@NotNull Variant1Parser.VarInitListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Variant1Parser#builtinType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltinType(@NotNull Variant1Parser.BuiltinTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Variant1Parser#binOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinOp(@NotNull Variant1Parser.BinOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link Variant1Parser#typeRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeRef(@NotNull Variant1Parser.TypeRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Call}
	 * labeled alternative in {@link Variant1Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(@NotNull Variant1Parser.CallContext ctx);
	/**
	 * Visit a parse tree produced by {@link Variant1Parser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(@NotNull Variant1Parser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link Variant1Parser#argDefList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgDefList(@NotNull Variant1Parser.ArgDefListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Variant1Parser#unOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnOp(@NotNull Variant1Parser.UnOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link Variant1Parser#varInitAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarInitAssign(@NotNull Variant1Parser.VarInitAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link Variant1Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary(@NotNull Variant1Parser.UnaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link Variant1Parser#argDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgDef(@NotNull Variant1Parser.ArgDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link Variant1Parser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(@NotNull Variant1Parser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link Variant1Parser#sourceItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSourceItem(@NotNull Variant1Parser.SourceItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Lit}
	 * labeled alternative in {@link Variant1Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLit(@NotNull Variant1Parser.LitContext ctx);
	/**
	 * Visit a parse tree produced by {@link Variant1Parser#varDeclAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclAssign(@NotNull Variant1Parser.VarDeclAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link Variant1Parser#breakStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStmt(@NotNull Variant1Parser.BreakStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link Variant1Parser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(@NotNull Variant1Parser.ExprListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Variant1Parser#varInitListAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarInitListAssign(@NotNull Variant1Parser.VarInitListAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link Variant1Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(@NotNull Variant1Parser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Id}
	 * labeled alternative in {@link Variant1Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(@NotNull Variant1Parser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Binary}
	 * labeled alternative in {@link Variant1Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary(@NotNull Variant1Parser.BinaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link Variant1Parser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(@NotNull Variant1Parser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link Variant1Parser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(@NotNull Variant1Parser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Paren}
	 * labeled alternative in {@link Variant1Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen(@NotNull Variant1Parser.ParenContext ctx);
}