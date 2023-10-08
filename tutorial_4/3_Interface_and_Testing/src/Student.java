import java.util.Objects;

public class Student extends Person implements HasToStudy{
    private int nrTimesStudid;
    private boolean livesInDelft;

    public Student(String name, double height, boolean livesInDelft) {
        super(name, height);
        this.livesInDelft = livesInDelft;
        this.nrTimesStudid = 0;
    }

    public boolean getLivesInDelft() {
        return livesInDelft;
    }

    public void setLivesInDelft(boolean livesInDelft) {
        this.livesInDelft = livesInDelft;
    }

    @Override
    public void study() {
        nrTimesStudid++;
    }

    @Override
    public boolean willPassExam() {
        return nrTimesStudid >= 5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return nrTimesStudid == student.nrTimesStudid && getLivesInDelft() == student.getLivesInDelft();
    }

    @Override
    public int hashCode() {
        return Objects.hash(nrTimesStudid, getLivesInDelft());
    }
}
