// Generated from C:/Users/iafil/OneDrive/Документы/course3/TK/DemoLang.java.antlr(ast)/src/main/java/ru/vsu/cs/demolang/antlr/KotlinLang.g4 by ANTLR 4.13.2
package ru.vsu.cs.demolang.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link KotlinLangParser}.
 */
public interface KotlinLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link KotlinLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(KotlinLangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(KotlinLangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinLangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(KotlinLangParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(KotlinLangParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinLangParser#propertyDecl}.
	 * @param ctx the parse tree
	 */
	void enterPropertyDecl(KotlinLangParser.PropertyDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLangParser#propertyDecl}.
	 * @param ctx the parse tree
	 */
	void exitPropertyDecl(KotlinLangParser.PropertyDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinLangParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(KotlinLangParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLangParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(KotlinLangParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinLangParser#funcParam}.
	 * @param ctx the parse tree
	 */
	void enterFuncParam(KotlinLangParser.FuncParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLangParser#funcParam}.
	 * @param ctx the parse tree
	 */
	void exitFuncParam(KotlinLangParser.FuncParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinLangParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(KotlinLangParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLangParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(KotlinLangParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinLangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(KotlinLangParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(KotlinLangParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinLangParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(KotlinLangParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLangParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(KotlinLangParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinLangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(KotlinLangParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(KotlinLangParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinLangParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(KotlinLangParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLangParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(KotlinLangParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinLangParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(KotlinLangParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLangParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(KotlinLangParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinLangParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(KotlinLangParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLangParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(KotlinLangParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinLangParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(KotlinLangParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLangParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(KotlinLangParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(KotlinLangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(KotlinLangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinLangParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(KotlinLangParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLangParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(KotlinLangParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinLangParser#prefixOp}.
	 * @param ctx the parse tree
	 */
	void enterPrefixOp(KotlinLangParser.PrefixOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLangParser#prefixOp}.
	 * @param ctx the parse tree
	 */
	void exitPrefixOp(KotlinLangParser.PrefixOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinLangParser#postfixOp}.
	 * @param ctx the parse tree
	 */
	void enterPostfixOp(KotlinLangParser.PostfixOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLangParser#postfixOp}.
	 * @param ctx the parse tree
	 */
	void exitPostfixOp(KotlinLangParser.PostfixOpContext ctx);
}