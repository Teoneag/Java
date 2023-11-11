public abstract class Audio {
    private final String name;
    private final Time time;

    public Audio(String name, Time time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public Time getTime() {
        return time;
    }
}
