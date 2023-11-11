import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoffeeMenuTest {

    @Test
    void readMenu() {
        Scanner scanner = new Scanner("COFFEES\n" +
                "COFFEE,espresso,1.99\n" +
                "VARIATION,lungo,1.00\n" +
                "VARIATION,ristretto,0.50\n" +
                "VARIATION,double,1.50\n" +
                "COFFEE,cappuccino,3.49,lactose\n" +
                "VARIATION,large,1.50\n" +
                "VARIATION,iced,0.50\n" +
                "COFFEE,latte,2.99,lactose\n" +
                "VARIATION,large,1.40\n" +
                "VARIATION,iced,0.40\n" +
                "COFFEE,chococcino,3.99,lactose,chocolate\n" +
                "VARIATION,large,1.60\n" +
                "ADDITIONS\n" +
                "ADDITION,vanilla,1.00\n" +
                "ADDITION,hazelnut,1.00,nuts\n" +
                "ADDITION,soy milk,1.00,soy\n" +
                "ADDITION,lactose free,1.00\n" +
                "ADDITION,sugar,0.10\n" +
                "ADDITION,milk,0.10,lactose");

        CoffeeVariation espresso_lungo = new CoffeeVariation("lungo", 1.00);
        CoffeeVariation espresso_ristretto = new CoffeeVariation("ristretto", 0.50);
        CoffeeVariation espresso_double = new CoffeeVariation("double", 1.50);
        CoffeeItem espresso = new CoffeeItem("espresso", 1.99, emptyList(), List.of(espresso_lungo, espresso_ristretto, espresso_double));

        CoffeeVariation cappuccino_large = new CoffeeVariation("large", 1.50);
        CoffeeVariation cappuccino_iced = new CoffeeVariation("iced", 0.50);
        CoffeeItem cappuccino = new CoffeeItem("cappuccino", 3.49, List.of("lactose"), List.of(cappuccino_large, cappuccino_iced));

        CoffeeVariation latte_large = new CoffeeVariation("large", 1.40);
        CoffeeVariation latte_iced = new CoffeeVariation("iced", 0.40);
        CoffeeItem latte = new CoffeeItem("latte", 2.99, List.of("lactose"), List.of(latte_large, latte_iced));

        CoffeeVariation chococcino_large = new CoffeeVariation("large", 1.60);
        CoffeeItem chococcino = new CoffeeItem("chococcino", 3.99, List.of("lactose", "chocolate"), List.of(chococcino_large));

        Addition vanilla = new Addition("vanilla", 1.00, emptyList());
        Addition hazelnut = new Addition("hazelnut", 1.00, List.of("nuts"));
        Addition soy = new Addition("soy milk", 1.00, List.of("soy"));
        Addition lactose_free = new Addition("lactose free", 1.00, emptyList());
        Addition sugar = new Addition("sugar", 0.10, emptyList());
        Addition milk = new Addition("milk", 0.10, List.of("lactose"));

        CoffeeMenu menu = new CoffeeMenu(List.of(espresso, cappuccino, latte, chococcino), List.of(vanilla, hazelnut, soy, lactose_free, sugar, milk));
        CoffeeMenu read = CoffeeMenu.read(scanner);

        assertEquals(menu, read);
    }

}
