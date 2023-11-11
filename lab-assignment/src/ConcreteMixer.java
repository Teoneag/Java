public class ConcreteMixer extends Equipment {

    /**
     * Constructor
     *
     * @param requirements a textual description that indicates any special requirements the
     *                     piece of equipment should meet for this particular job
     */
    public ConcreteMixer(String requirements) {
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
        if (!(o instanceof ConcreteMixer that)) return false;
        return super.equals(that);
    }

    /**
     * Converts the ConcreteMixer to String
     *
     * @return the String
     */
    @Override
    public String toString() {
        return "ConcreteMixer, " + requirements;
    }
}
