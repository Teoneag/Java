import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdditionTest {

    @Test
    void readMenu() {
        Scanner scanner = new Scanner("ADDITION,vanilla,1.00");

        Addition vanilla = new Addition("vanilla", 1.00, emptyList());

        assertEquals(vanilla, Addition.read(scanner));
    }

}
