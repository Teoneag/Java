package sounds;

import java.util.Objects;
import java.util.Scanner;

/**
 * Represents an instance of a note playing.
 */
public class PlayNote {

    private final String note;
    private final double loudness;
    private final double start;
    private final double end;

    public PlayNote(String note, double loudness, double start, double end) {
        this.note = note;
        this.loudness = loudness;
        this.start = start;
        this.end = end;
    }

    public static PlayNote read(Scanner input) {
        String note = input.next();

        input.next(); // skip -
        input.next(); // skip loudness

        double loudness = input.nextDouble();

        input.next(); // skip START
        input.useDelimiter(":");
        double start = 60.0 * Integer.parseInt(input.next().trim());
        input.skip(":");
        start += Double.parseDouble(input.nextLine());

        input.skip("");
        input.useDelimiter(" ");
        input.next(); // skip END
        input.useDelimiter(":");
        double end = 60.0 * Integer.parseInt(input.next().trim());
        input.skip(":");
        end += Double.parseDouble(input.nextLine());

        return new PlayNote(note, loudness, start, end);
    }

    public String getNote() {
        return note;
    }

    public double getLoudness() {
        return loudness;
    }

    public double getStart() {
        return start;
    }

    public double getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayNote playNote = (PlayNote) o;
        return Double.compare(loudness, playNote.loudness) == 0 &&
                Double.compare(start, playNote.start) == 0 &&
                Double.compare(end, playNote.end) == 0 &&
                Objects.equals(note, playNote.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(note, loudness, start, end);
    }
}
