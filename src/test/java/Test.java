import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Test {

    private final Main calculator = new Main();

    @Test
    void testEmptyString() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    void testSingleNumber() {
        assertEquals(1, calculator.add("1"));
    }
}
