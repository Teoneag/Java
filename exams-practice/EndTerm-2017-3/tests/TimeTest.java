import org.junit.jupiter.api.BeforeEach;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TimeTest {
    private Time time1;
    @BeforeEach
    void setup() {
        time1 = new Time(10, 25);
    }

    @org.junit.jupiter.api.Test
    void read() {
        Time time = Time.read(new Scanner("10:25"));
        assertEquals(time.min(),10);
        assertEquals(time.sec(),25);
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        assertEquals(time1.toString(), "10:25");
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        Time time2 = new Time(10, 25);
        Time time3 = new Time(10, 20);
        Time time4 = new Time(1, 25);
        assertEquals(time2, time1);
        assertEquals(time1, time1);
        assertNotEquals(time1, null);
        assertNotEquals(time1, "yes");
        assertNotEquals(time1, time3);
        assertNotEquals(time1, time4);
    }

    @org.junit.jupiter.api.Test
    void testHashCode() {
        Time time2 = new Time(10, 25);
        assertEquals(time2.hashCode(), time2.hashCode());
    }

//    @org.junit.jupiter.api.Test
//    void min() {
//    }
//
//    @org.junit.jupiter.api.Test
//    void sec() {
//    }
}