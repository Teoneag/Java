public class Torch extends Equipment implements PowerSupply{
    /**
     * Constructor
     *
     * @param requirements a textual description that indicates any special requirements the
     *                     piece of equipment should meet for this particular job
     */
    public Torch(String requirements) {
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
        if (!(o instanceof Torch that)) return false;
        return super.equals(that);
    }

    /**
     * Converts the Torch to String
     *
     * @return the String
     */
    @Override
    public String toString() {
        return "Torch, " + requirements;
    }

    /**
     * The getter for the power supply
     * @return The power supply
     */
    @Override
    public String getPowerSupply() {
        return butaneGasString;
    }
}
