import org.junit.jupiter.api.Test;

import java.io.StringWriter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherTest {

    @Test
    public void testSunnyDay() {
        StringWriter writer = new StringWriter();
        SunnyDay sunny = new SunnyDay(new Date(1, 9, 2020), 20.1, 2, 10);
        WeatherReport report = new WeatherReport(List.of(sunny));

        report.write(writer);

        assertEquals("1/9/2020,SUN,20.1C,2BFT,10h" + System.lineSeparator(), writer.toString());
    }

}
