public class SunnyDay extends DailyWeather {

    private int sunHours;

    /**
     * Creates a sunny day.
     *
     * @param date The date of the weather
     * @param temperature The temperature in C
     * @param windSpeed The wind speed in BFT
     * @param sunHours The amount of hours the sun shone
     */
    public SunnyDay(Date date, double temperature, int windSpeed, int sunHours) {
        super(date, temperature, windSpeed);
        this.sunHours = sunHours;
    }

    /**
     * Gets the amount of sun hours.
     *
     * @return The amount of hours the sun shone
     */
    public int getSunHours() {
        return sunHours;
    }

}
