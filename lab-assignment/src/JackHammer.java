public class JackHammer extends Equipment implements PowerSupply {
    /**
     * Constructor
     *
     * @param requirements a textual description that indicates any special requirements the
     *                     piece of equipment should meet for this particular job
     */
    public JackHammer(String requirements) {
        super(requirements);
    }



    /**
     * Equals
     *
     * @param o the object to compare with
     * @return if they are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JackHammer that)) return false;
        return super.equals(that);
    }

    /**
     * Converts the JackHammer to String
     *
     * @return the String
     */
    @Override
    public String toString() {
        return "JackHammer, " + requirements;
    }

    /**
     * Getter for the power supply
     * @return The type of power supply
     */
    @Override
    public String getPowerSupply() {
        return airCompressorString;
    }
}
