import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AddTest {
    private Add add1;

    @BeforeEach
    void setup() {
        add1 = new Add("name", new Time(10, 20));
    }

    @Test
    void read() {
        Add add = Add.read(new Scanner("Bol.com, 0:15"));
        assertEquals(add.getName(), "Bol.com");
        assertEquals(add.getTime(), new Time(0, 15));
    }

    @Test
    void testToString() {
        assertEquals(add1.toString(), "Next add: name (10:20)");
    }

    @Test
    void toWrite() {
        assertEquals(add1.toWrite(), "ADD name, 10:20");
    }
}