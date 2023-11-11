import java.util.Locale;
import java.util.Scanner;

public class Product {

    public static Product read(String line) {
        Scanner scanner = new Scanner(line).useDelimiter(",");

        /*
         * By default, Scanner uses your OS' locale to parse numbers.
         * For European locales in general, this means that doubles have to be entered with a comma (,)
         * Since the file stores doubles with a full stop (.), we can change the locale of the Scanner to US.
         * Alternatively, we could use Double.parseDouble(scanner.next())).
         */
        scanner.useLocale(Locale.US);

        return new Product(scanner.next(), scanner.next(), scanner.nextDouble());
    }

    private String name;
    private String category;
    private double price;

    /**
     * Creates a product.
     *
     * @param name The name of the product
     * @param category The category of the product
     * @param price The price of the product
     */
    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    /**
     * Gets the name of the product.
     *
     * @return This product's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the category of the product.
     *
     * @return This product's category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Gets the price of the product.
     *
     * @return This product's price
     */
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product(name=" + name + ", category=" + category + ", price=" + price + ")";
    }
}
