public class Song extends Audio{
    private final int nr;

    public Song(String name, Time time, int nr) {
        super(name, time);
        this.nr = nr;
    }

    public int getNr() {
        return nr;
    }
}
