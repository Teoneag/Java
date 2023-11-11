import java.util.ArrayList;
import java.util.List;

public class ApplianceGroup {

    private final String name;
    private final List<Appliance> appliances;

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
     * Adds an appliance
     * @param appliance the appliance to be added
     */
    public void addAppliance(Appliance appliance) {
        appliances.add(appliance);
    }

    /**
     * Method to toggle lights
     */

    public void toggleLights() {
        for (Appliance appliance : appliances) {
            if (appliance instanceof Lamp l) {
                l.toggle();
            }
        }
    }

    /**
     * Plays a song on all speakers in a group
     *
     * @param songToPlay the song to be played
     */
    public void playSong(String songToPlay) {
        for (Appliance appliance : appliances) {
            if (appliance instanceof Speaker s) {
                s.setPlaying(songToPlay);
            }
        }
    }

    /**
     * Sets the lights colors
     *
     * @param red   The red component
     * @param green The green component
     * @param blue  The blue component
     */
    public void setLightColour(int red, int green, int blue) {
        for (Appliance appliance : appliances) {
            if (appliance instanceof Lamp l) {
                l.setColour(new Colour(red, green, blue));
            }
        }
    }

    /**
     * Gets the status
     * @return the status
     */
    public String getStatus() {
        StringBuilder status = new StringBuilder("Group " + name + ":\n");
        for (Appliance appliance : appliances) {
            status.append(" - ").append(appliance.getDescription()).append("\n");
        }
        return status.toString();
    }

}
