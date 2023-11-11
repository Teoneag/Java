import java.util.Objects;

public abstract class  Product {
    private final String brand;
    private final int price;

    public Product(String brand, int price) {
        this.brand = brand;
        this.price = price;
    }

    public String toWrite() {
        if (this instanceof ProteinShake proteinShake) {
            return proteinShake.toWrite();
        } else if (this instanceof HomeTrainerBike homeTrainerBike) {
            return  homeTrainerBike.toWrite();
        } else {
            SpinningBike spinningBike = (SpinningBike) this;
            return spinningBike.toWrite();
        }
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return getPrice() == product.getPrice() && Objects.equals(getBrand(), product.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getPrice());
    }

    @Override
    public String toString() {
        return "Product{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
