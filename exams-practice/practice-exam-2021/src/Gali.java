import java.util.List;
import java.util.Objects;

public class Gali {
    private int age;
    private String name;
    private List<String> bitches;

    public Gali(int age, String name, List<String> bitches) {
        this.age = age;
        this.name = name;
        this.bitches = bitches;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<String> getBitches() {
        return bitches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gali gali)) return false;
        return getAge() == gali.getAge() && Objects.equals(getName(), gali.getName()) && Objects.equals(getBitches(), gali.getBitches());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getName(), getBitches());
    }

    @Override
    public String toString() {
        return "Gali{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", bitches=" + bitches +
                '}';
    }
}
