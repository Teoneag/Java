import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseTest {

    @Test
    void isMathematics() {
        assertTrue(new Course("Calculus", "Calc", "CSE1200").isMathematics());
    }

    @Test
    void isNotMathematics() {
        assertFalse(new Course("Algorithms and Data Structures", "ADS", "CSE1305").isMathematics());
    }

}
