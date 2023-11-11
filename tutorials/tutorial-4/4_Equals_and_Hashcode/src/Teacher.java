import java.util.Objects;

public class Teacher extends Person {

    private int amountOfCourses;

    public String toString() {
        return "A teacher with " + super.toString() + "which teaches" + amountOfCourses + "courses.";
    }

    public Teacher(String name, double height, int amountOfCourses) {
        super(name, height);
        this.amountOfCourses = amountOfCourses;
    }

    public int getAmountOfCourses() {
        return amountOfCourses;
    }

    public void setAmountOfCourses(int amountOfCourses) {
        this.amountOfCourses = amountOfCourses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher teacher)) return false;
        return getAmountOfCourses() == teacher.getAmountOfCourses();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAmountOfCourses());
    }
}
