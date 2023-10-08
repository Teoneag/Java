public class Office extends Building {
    private  int numberOfWorkers;

    public Office(String street, int value, int numberOfWorkers) {
        super(street, value);
        this.numberOfWorkers = numberOfWorkers;
    }

    public int getNumberOfWorkers() {
        return numberOfWorkers;
    }

    public void setNumberOfWorkers(int numberOfWorkers) {
        this.numberOfWorkers = numberOfWorkers;
    }
}
