import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    private Student s;

    @BeforeEach
    void setup() {
        s = new Student("Dorel",1.69, true);
        s.study();
        s.study();
        s.study();
        s.study();
    }

    @Test
    void willNotPassExam() {
        assertFalse(s.willPassExam());
    }

    @Test
    void willPassExam() {
        s.study();
        assertTrue(s.willPassExam());
    }
}