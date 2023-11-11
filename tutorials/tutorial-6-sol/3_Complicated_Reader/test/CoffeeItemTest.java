import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoffeeItemTest {

    @Test
    void readCoffee() {
        Scanner scanner = new Scanner("cappuccino,3.49,lactose\n" +
                "VARIATION,large,1.50\n" +
                "VARIATION,iced,0.50\n");

        CoffeeVariation cappuccino_large = new CoffeeVariation("large", 1.50);
        CoffeeVariation cappuccino_iced = new CoffeeVariation("iced", 0.50);
        CoffeeItem cappuccino = new CoffeeItem("cappuccino", 3.49, List.of("lactose"), List.of(cappuccino_large, cappuccino_iced));

        assertEquals(cappuccino, CoffeeItem.read(scanner));
    }

}
