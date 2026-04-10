// Generated from C:/Users/iafil/OneDrive/Документы/course3/TK/DemoLang.java.antlr(ast)/src/main/java/ru/vsu/cs/demolang/antlr/KotlinLang.g4 by ANTLR 4.13.2
package ru.vsu.cs.demolang.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link KotlinLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface KotlinLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link KotlinLangParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(KotlinLangParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinLangParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(KotlinLangParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinLangParser#propertyDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyDecl(KotlinLangParser.PropertyDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinLangParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(KotlinLangParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinLangParser#funcParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncParam(KotlinLangParser.FuncParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinLangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(KotlinLangParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinLangParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(KotlinLangParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinLangParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(KotlinLangParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinLangParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(KotlinLangParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinLangParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(KotlinLangParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinLangParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(KotlinLangParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinLangParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(KotlinLangParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinLangParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(KotlinLangParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(KotlinLangParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinLangParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(KotlinLangParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinLangParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(KotlinLangParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinLangParser#prefixOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixOp(KotlinLangParser.PrefixOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinLangParser#postfixOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixOp(KotlinLangParser.PostfixOpContext ctx);
}