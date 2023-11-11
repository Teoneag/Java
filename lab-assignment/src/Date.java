import java.util.Scanner;

public record Date(int day, int month, int year) implements Comparable {
    /**
     * The constructor
     *
     * @param day   The day
     * @param month The month
     * @param year  The year
     */
    public Date {
    }

    /**
     * Reads the input into a Date
     *
     * @param input A scanner with the following format
     *              24-10-2021
     * @return The date
     */
    public static Date read(Scanner input) {
        input.useDelimiter("-");
        int day = input.nextInt();
        int month = input.nextInt();
        int year = input.nextInt();
        return new Date(day, month, year);
    }

    /**
     * Getter for the day
     *
     * @return the day
     */
    @Override
    public int day() {
        return day;
    }

    /**
     * Getter for the month
     *
     * @return the month
     */
    @Override
    public int month() {
        return month;
    }

    /**
     * Getter for the year
     *
     * @return the year
     */
    @Override
    public int year() {
        return year;
    }

    /**
     * The equals method
     *
     * @param o the other objects
     * @return whether they are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Date that)) return false;
        return day() == that.day() && month() == that.month()
                && year() == that.year();
    }

    /**
     * The toString method
     *
     * @return The string
     */
    @Override
    public String toString() {
        return day + "-" + month + "-" + year;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Date d)) {
            System.out.println("Wrong Object");
            return -2;
        }
        int yearComparison = Integer.compare(this.year, d.year);
        if (yearComparison != 0) return yearComparison;

        int monthComparison = Integer.compare(this.month, d.month);
        if (monthComparison != 0) return monthComparison;

        return Integer.compare(this.day, d.day);
    }
}
