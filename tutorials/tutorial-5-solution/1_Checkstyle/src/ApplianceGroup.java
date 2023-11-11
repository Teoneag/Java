import java.util.ArrayList;
import java.util.List;

public class ApplianceGroup {

    private String name;
    private List<Appliance> appliances;

    /**
     * Creates an appliance group.
     *
     * @param name The name
     */
    public ApplianceGroup(String name) {
        this.name = name;
        this.appliances = new ArrayList<>();
    }

    /**
     * Gets the name.
     *
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * Adds an appliance to the group.
     *
     * @param appliance The appliance to add
     */
    public void addAppliance(Appliance appliance) {
        appliances.add(appliance);
    }

    /**
     * Toggles all lights in the group.
     */
    public void toggleLights() {
        for (Appliance appliance : appliances) {
            if (appliance instanceof Lamp l) {
                l.toggle();
            }
        }
    }

    /**
     * Plays a song on all speakers in the group.
     *
     * @param songToPlay The song to play
     */
    public void playSong(String songToPlay) {
        for (Appliance appliance : appliances) {
            if (appliance instanceof Speaker s) {
                s.setPlaying(songToPlay);
            }
        }
    }

    /**
     * Sets the light colour for all lights in the group.
     *
     * @param red The red component
     * @param green The green component
     * @param blue The blue component
     */
    public void setLightColour(int red, int green, int blue) {
        for (Appliance appliance : appliances) {
            if (appliance instanceof Lamp l) {
                l.setColour(new Colour(red, green, blue));
            }
        }
    }

    /**
     * Gets the status of all the appliances in the group.
     *
     * @return A string with the status of the group
     */
    public String getStatus() {
        String status = "Group " + name + ":\n";
        for (Appliance appliance : appliances) {
            status += " - " + appliance.getDescription() + "\n";
        }
        return status;
    }

}
