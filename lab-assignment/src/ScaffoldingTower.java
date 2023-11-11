public class ScaffoldingTower extends Equipment{

    /**
     * Constructor
     *
     * @param requirements a textual description that indicates any special requirements the
     *                     piece of equipment should meet for this particular job
     */
    public ScaffoldingTower(String requirements) {
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
        if (!(o instanceof ScaffoldingTower that)) return false;
        return super.equals(that);
    }

    /**
     * Converts the ScaffoldingTower to String
     *
     * @return the String
     */
    @Override
    public String toString() {
        return "Scaffolding, " + requirements;
    }
}
