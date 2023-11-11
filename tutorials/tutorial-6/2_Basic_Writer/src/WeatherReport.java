import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

public class WeatherReport {

    public static void main(String[] args) {
        StringWriter writer = new StringWriter();
        RainyDay rainy = new RainyDay(new Date(3, 8, 2020), 20  , 1, 20);
        SunnyDay sunny = new SunnyDay(new Date(4, 8, 2020), 25  , 2, 12);
        WeatherReport report = new WeatherReport(List.of(rainy, sunny));
        report.write(writer);
        System.out.println(writer);
    }

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
        for (int i = 0; i < dailyReports.size(); i++) {
            DailyWeather dailyWeather = dailyReports.get(i);
            try {
                // THe long version
//                if (i == 0) {
//                    writer.write("Here on ");
//                } else {
//                    writer.write("On ");
//                }
//
//                String[] months = {"January", "February", "March", "April", "May", "June",
//                                      "July", "August", "September", "October", "November", "December"};
//                Date date = dailyWeather.getDate();
//                writer.write(months[date.getMonth() - 1] + " ");
//
//                int day = date.getDay();
//                writer.write(Integer.toString(day));
//                switch (day) {
//                    case 1 -> writer.write("st");
//                    case 2 -> writer.write("nd");
//                    case 3 -> writer.write("rd");
//                    default -> writer.write("th");
//                }
//                writer.write(" ");
//
//
//                if (i == 0) {
//                    writer.write(Integer.toString(date.getYear()) + " ");
//                }
//
//                writer.write("it was a ");
//
//                if (dailyWeather instanceof SunnyDay) {
//                    writer.write("sunny ");
//                } else {
//                    writer.write("rainy ");
//                }
//
//                writer.write("day. It was ");
//
//                writer.write(Double.toString(dailyWeather.getTemperature()) + " ");
//
//                writer.write("degrees, there was a wind speed of ");
//
//                writer.write(Integer.toString(dailyWeather.getWindSpeed()) + " ");
//
//                writer.write("beaufort and ");
//
//                if (dailyWeather instanceof SunnyDay sunnyDay) {
//                    writer.write("there were ");
//                    writer.write(Integer.toString(sunnyDay.getSunHours()) + " ");
//                    writer.write("hours of sun. ");
//                } else if (dailyWeather instanceof  RainyDay rainyDay) {
//                    writer.write(Integer.toString(rainyDay.getMillimetersRained()) + " ");
//                    writer.write("millimeters of rain fell.");
//                }

                Date date = dailyWeather.getDate();
                writer.write(Integer.toString(date.getDay()) + "/");
                writer.write(Integer.toString(date.getMonth()) + "/");
                writer.write(Integer.toString(date.getYear()));

                writer.write(",");

                if (dailyWeather instanceof RainyDay) {
                    writer.write("RAIN,");
                } else {
                    writer.write("SUN,");
                }

                writer.write(Double.toString(dailyWeather.getTemperature()) + "C,");

                writer.write(Integer.toString(dailyWeather.getWindSpeed()) + "BFT,");

                if (dailyWeather instanceof RainyDay rainyDay) {
                    writer.write(Integer.toString(rainyDay.getMillimetersRained()) + "mm");
                } else if (dailyWeather instanceof  SunnyDay sunnyDay) {
                    writer.write(Integer.toString(sunnyDay.getSunHours()) + "h");
                }
                writer.write(System.lineSeparator());
            } catch (IOException e) {
                System.out.println("Writing error!");
            }
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
