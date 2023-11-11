import java.util.List;

public class Job {
    private int jobNumber;
    private Address location;
    private String description;
    private List<Equipment> requireEquipment;
    private Date plannedDate;

    private static int jobTotal = 0;

    /**
     * Constructor
     *
     * @param location         The location
     * @param description      The description
     * @param requireEquipment The required equipment
     * @param plannedDate      The planned Date
     */
    public Job(Address location, String description,
               List<Equipment> requireEquipment, Date plannedDate) {
        jobNumber = ++jobTotal;
        this.location = location;
        this.description = description;
        this.requireEquipment = requireEquipment;
        this.plannedDate = plannedDate;
    }

    /**
     * The getter for the job number
     *
     * @return the job number
     */
    public int getJobNumber() {
        return jobNumber;
    }

    /**
     * The getter for the location
     *
     * @return the location
     */
    public Address getLocation() {
        return location;
    }

    /**
     * The getter for the description
     *
     * @return the job description
     */
    public String getDescription() {
        return description;
    }

    /**
     * The getter for the RequireEquipment
     *
     * @return the RequireEquipment
     */
    public List<Equipment> getRequireEquipment() {
        return requireEquipment;
    }

    /**
     * The getter for the getPlannedDate
     *
     * @return the getPlannedDate
     */
    public Date getPlannedDate() {
        return plannedDate;
    }

    /**
     * The getter for the job total
     *
     * @return the job total
     */
    public static int getJobTotal() {
        return jobTotal;
    }

    /**
     * Converts the Job to a String
     *
     * @return The string
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(location).append("\n").append(description).append("\n");
        for (Equipment equipment : requireEquipment) {
            res.append(equipment).append("; ");
        }
        res.append("\n").append(plannedDate).append("\n");
        return res.toString();
    }

    /**
     * The equals method
     *
     * @param o the object to compare with
     * @return whether they are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job that)) return false;
        // Should I compare all the elements in the requireEquimpent, like make them a set?
        return that.location.equals(location) && that.description.equals(description)
                && that.requireEquipment.equals(requireEquipment)
                && that.plannedDate.equals(plannedDate);
    }
}
