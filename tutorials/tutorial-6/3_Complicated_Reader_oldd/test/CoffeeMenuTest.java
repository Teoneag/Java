import static org.junit.jupiter.api.Assertions.*;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.Scanner;

import java.io.File;
import java.util.Scanner;

class CoffeeMenuTest {

    @org.junit.jupiter.api.Test
    void read() throws FileNotFoundException {
        CoffeeMenu coffeeMenu = CoffeeMenu.read(new Scanner("COFFEES\n" +
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
                "ADDITION,milk,0.10,lactose"));
    }
}