import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.function.*;

public final class Functions {

    public static IntSupplier randomNumberSupplier() {
        return () -> (int) (Math.random() * 10);
    }

    public static Consumer<String> stringWriter(final Writer writer) {
        return (String s) -> {
            try {
                writer.write(s);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static BiFunction<String, Integer, String> stringRepeater() {
        return String::repeat;
    }

    public static BiPredicate<Double, Double> isPassing() {
        return  (Double a, Double b) -> a >= 5 && b >= 5 && (a + b) / 2.0 >= 5.8;
    }

}
