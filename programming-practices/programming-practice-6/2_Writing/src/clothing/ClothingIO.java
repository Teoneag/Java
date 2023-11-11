package clothing;

import clothing.data.ClothingItem;
import clothing.data.Dress;
import clothing.data.Shirt;
import clothing.data.Shoes;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ClothingIO {

    /**
     * Writes a list of clothing items to a given output stream.
     *
     * @param catalogueStream The output stream
     * @param items           The list of clothing items
     */
    public static void writeCatalogue(OutputStream catalogueStream, List<ClothingItem> items) {
        StringBuilder res = new StringBuilder();
        for (var item : items) {
            if (item instanceof Dress dress) {
                res.append(dress);
            } else if (item instanceof Shirt shirt) {
                res.append(shirt);
            } else if (item instanceof Shoes shoes) {
                res.append(shoes);
            }
            res.append("\n");
        }
        byte[] bytes = res.toString().getBytes();
        try {
            catalogueStream.write(bytes);
        } catch (Exception e) {
            System.out.println("Error writing");
        }
    }


    /**
     * Reads all clothing items in a given input stream.
     *
     * @param catalogueStream The input stream
     * @return The list of clothing items
     */
    public static List<ClothingItem> readCatalogue(InputStream catalogueStream) {
        Scanner input = new Scanner(catalogueStream);
        List<ClothingItem> items = new ArrayList<>();
        while (input.hasNextLine()) {
            var line = new Scanner(input.nextLine());
            String itemType = line.next();

            String color = line.next();
            color = color.substring(1, color.length() - 1);

            line.next(); // skip -
            int price = Integer.parseInt(line.next().substring(1)
                    .replace(".", ""));
            line.next(); // skip -

            switch (itemType) {
                case "Dress" -> {
                    String lengthM = line.next();
                    double length = Double.parseDouble(lengthM.substring(0, lengthM.length() - 1));
                    items.add(new Dress(color, price, length));
                }
                case "Shirt" -> {
                    line.next();
                    char size = line.next().charAt(0);
                    items.add(new Shirt(color, price, size));
                }
                case "Shoes" -> {
                    line.next();
                    int size = Integer.parseInt(line.next());
                    items.add(new Shoes(color, price, size));
                }
            }
        }
        return items;
    }
}
