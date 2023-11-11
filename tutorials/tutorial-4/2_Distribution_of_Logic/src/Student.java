public class Student extends Person{

    private boolean livesInDelft;

    public Student(String name, double height, boolean livesInDelft) {
        super(name, height);
        this.livesInDelft = livesInDelft;
    }

    public boolean getLivesInDelft() {
        return livesInDelft;
    }

    public void setLivesInDelft(boolean livesInDelft) {
        this.livesInDelft = livesInDelft;
    }

}
