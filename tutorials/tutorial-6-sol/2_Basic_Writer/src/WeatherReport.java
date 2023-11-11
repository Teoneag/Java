import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

public class WeatherReport {

    private List<DailyWeather> dailyReports;

    /**
     * Creates a weather report.
     *
     * @param dailyReports The list of daily reports in the weather report
     */
    public WeatherReport(List<DailyWeather> dailyReports) {
        this.dailyReports = dailyReports;
    }

    /**
     * Writes this weather report to the given writer.
     *
     * @param writer The writer to write to
     */
    public void write(Writer writer) {
        PrintWriter pw = new PrintWriter(writer);
        for (DailyWeather weather : dailyReports) {
            pw.println(weather);
        }
    }

    /**
     * Gets the list of daily reports.
     *
     * @return The list of daily reports in this weather report
     */
    public List<DailyWeather> getDailyReports() {
        return dailyReports;
    }

}
