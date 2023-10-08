import java.util.Objects;

public class Person {
    protected String name;
    protected double height;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", height=" + height +
                '}';
    }

    public Person(String name, double height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Double.compare(getHeight(), person.getHeight()) == 0 && Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        int nameNotNull = name != null ? name.hashCode() : 0;
        long heinghtLong = Double.doubleToLongBits(height);
        return 31 * nameNotNull + (int) (heinghtLong ^ (heinghtLong >>> 32));
//        return Objects.hash(getName(), getHeight());
    }
}
