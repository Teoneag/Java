import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoffeeVariationTest {

    @Test
    void readVariation() {
        Scanner scanner = new Scanner("VARIATION,large,1.50");

        CoffeeVariation large = new CoffeeVariation("large", 1.50);

        assertEquals(large, CoffeeVariation.read(scanner));
    }

}
