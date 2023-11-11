import java.util.Scanner;

public record Address(String street, int number, String zipCode, String city) {
    /**
     * Constructor
     *
     * @param street  The street
     * @param number  The nr
     * @param zipCode The zipCode
     * @param city    The city
     */
    public Address {
    }

    /**
     * Reads the input into an Address
     *
     * @param input A scanner with the following format
     *              van Mourik Broekmanweg; 6; 2628XE; Delft
     * @return The address
     */
    public static Address read(Scanner input) {
        input.useDelimiter("; ");
        String street = input.next();
        int nr = input.nextInt();
        String zipCode = input.next();
        String city = input.next();
        return new Address(street, nr, zipCode, city);
    }

    /**
     * Getter for the street
     *
     * @return the street
     */
    @Override
    public String street() {
        return street;
    }

    /**
     * Getter for the nr
     *
     * @return the nr
     */
    @Override
    public int number() {
        return number;
    }

    /**
     * Getter for the zipCode
     *
     * @return the zipCode
     */
    @Override
    public String zipCode() {
        return zipCode;
    }

    /**
     * Getter for the city
     *
     * @return the city
     */
    @Override
    public String city() {
        return city;
    }

    /**
     * ToString
     *
     * @return String
     */
    @Override
    public String toString() {
        return street + "; " + number + "; " + zipCode + "; " + city;
    }

    /**
     * Equals
     *
     * @param o The object
     * @return Whether the object is equal to this
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address that)) return false;
        return this.street.equals(that.street) && this.number == that.number
                && this.zipCode.equals(that.zipCode) && this.city.equals(that.city);
    }

}
