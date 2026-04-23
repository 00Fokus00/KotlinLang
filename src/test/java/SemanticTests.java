import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.vsu.cs.demolang.SemanticAnalyzer;
import ru.vsu.cs.demolang.SemanticException;
import ru.vsu.cs.demolang.*;

import static org.junit.jupiter.api.Assertions.*;

public class SemanticTests {

    private void assertSemanticError(String code, String expectedMessagePart) {
        try {
            StmtListNode ast = Parser.parse(code);

            SemanticAnalyzer analyzer = new SemanticAnalyzer();

            analyzer.analyze(ast);

            fail("Ожидалась ошибка семантики: " + expectedMessagePart);
        } catch (SemanticException e) {
            assertTrue(e.getMessage().contains(expectedMessagePart),
                    "Текст ошибки '" + e.getMessage() + "' должен содержать: " + expectedMessagePart);
        }
    }

    @Test
    void testInvalidUnaryNot() {
        assertSemanticError("val x = !10;", "Оператор '!' нельзя применить к типу int");
    }

    @Test
    void testInvalidArithmetic() {
        assertSemanticError("""
        val s = "hi";
        val n = 1;
        val res = s + n;
    """, "Нельзя применить + к string и int");
    }

    @Test
    void testFunctionReturn() {
        assertSemanticError("""
        fun test(): Int {
            return true
        }
    """, "Функция должна возвращать int, но возвращает bool");
    }

    @Test
    void testVoidReturn() {
        assertSemanticError("""
        fun doNothing() {
            return 10
        }
    """, "Неизвестный тип: Unit");
    }

    @Test
    void testVal() {
        assertSemanticError("""
        val x = 10;
        x = 20;
    """, "Нельзя изменить 'val' переменную x");
    }

    @Test
    void testUndefinedVariable() {
        assertSemanticError("y = 10;", "Переменная y не найдена.");
    }
}
