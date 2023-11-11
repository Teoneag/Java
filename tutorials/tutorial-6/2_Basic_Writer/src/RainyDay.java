public class RainyDay extends DailyWeather {

    private int millimetersRained;

    /**
     * Creates a rainy day.
     *
     * @param date The date of the weather
     * @param temperature The temperature in C
     * @param windSpeed The wind speed in BFT
     * @param millimetersRained The amount of mm rain that fell
     */
    public RainyDay(Date date, double temperature, int windSpeed, int millimetersRained) {
        super(date, temperature, windSpeed);
        this.millimetersRained = millimetersRained;
    }

    /**
     * Gets the amount of rain that fell.
     *
     * @return The total millimetres of rain.
     */
    public int getMillimetersRained() {
        return millimetersRained;
    }

}
