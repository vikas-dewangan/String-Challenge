import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestCalculator {

    private final Main calculator = new Main();

    @Test
    void testEmptyString() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    void testSingleNumber() {
        assertEquals(1, calculator.add("1"));
    }

    @Test
    void testTwoNumbers() {
        assertEquals(3, calculator.add("1,2"));
    }

    @Test
    void testNewLineDelimiter() {
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    void testCustomDelimiter() {
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Test
    void testNegativeNumbersException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.add("1,-2,-3"));
        assertEquals("Negative numbers not allowed: -2, -3", exception.getMessage());
    }
}
