import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestTest {
    @Test
    void test() {
        TestGay test1 = new TestGay(69);
        TestGay test2 = new TestGay(69);
        assertEquals(test1, test2);
    }


}