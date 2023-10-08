import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testEqualsSameMemoryLoc() {
        Person p1 = new Person("Dorel", 1.69);
        Person p2 = p1;
        assertEquals(p1, p2);
    }

    @Test
    void testEqualsDiferentMemoryLoc() {
        Person p1 = new Person("Dorel", 1.69);
        Person p2 = new Person("Dorel", 1.69);
        assertEquals(p1, p2);
    }

    @Test
    void testNotEquals() {
        Person p1 = new Person("Dorel", 1.69);
        Person p2 = new Person("Dorelina", 1.69);
        assertNotEquals(p1, p2);
    }
}