import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TimeTest {
    private Time time;

    @BeforeEach
    void setup() {
        time = new Time(10, 20);
    }


    @org.junit.jupiter.api.Test
    void read() {
        Random r = new Random(42);
        Time time2 = null;
        time2 = new Time(11, 20);
        assertNotEquals(time2, null);
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        System.out.println(time);
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        assertNotEquals(time, null);
        assertEquals(time, time);
        Time time3 = new Time(10, 20);
        assertEquals(time, time3);
        assertNotEquals(time, "yes");
        Time time4 = new Time(10, 21);
        assertNotEquals(time, time4);
        Time time5 = new Time(11, 20);
        assertNotEquals(time, time5);
    }

    @org.junit.jupiter.api.Test
    void testHashCode() {
        Time time2 = new Time(10, 20);
        assertEquals(time.hashCode(), time2.hashCode());
    }

    @org.junit.jupiter.api.Test
    void min() {
        assertEquals(time.min(), 10);
    }

    @org.junit.jupiter.api.Test
    void sec() {
        assertEquals(time.sec(), 20);
    }
}