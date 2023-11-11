import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MachineTest {
    Machine machine = new Machine();

    @BeforeEach // How should I use this one???
    void setup() {
//        Machine machine = new Machine();
        machine.read();
    }

//    @Test
//    void read() {
//        machine.read();
//    }

    @Test
    void printAllBalls() {
        machine.printAllBalls();
    }

    @Test
    void showChance() {
        machine.showChance(); // should print 1
    }

    @Test
    void drawBall() {
        machine.drawBall();
    }

    @Test
    void write() {
        machine.drawBall();
        machine.drawBall();
        machine.drawBall();
        machine.drawBall();
        machine.drawBall();
        machine.drawBall();
        machine.drawBall();
        machine.drawBall();
        machine.drawBall();
        machine.drawBall();
        machine.drawBall();
        machine.write();
    }

    @Test
    void testEquals() {
        assertEquals(machine, machine);
        assertNotEquals(machine, null);

        Machine machine1 = new Machine();
        machine1.read();
        assertEquals(machine1, machine);

        Machine machine2 = new Machine();
        machine2.read();
        machine2.drawBall();
        assertNotEquals(machine, machine2);
    }

    @Test // How to test HashCode ???
    void testHashCode() {
        System.out.println(machine.hashCode());
    }
}