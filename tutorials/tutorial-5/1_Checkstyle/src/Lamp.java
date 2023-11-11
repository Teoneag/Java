public class Lamp extends Appliance implements Togglable {

    private boolean on;
    private Colour colour;
    private double power;
    private boolean hasLightSwitch;

    /**
     * Creates a lamp.
     *
     * @param name The name
     * @param on Whether the lamp is on
     * @param colour The colour
     * @param power The power (between 0 and 1)
     * @param hasLightSwitch Whether the lamp has a light switch
     */
    public Lamp(String name, boolean on, Colour colour, double power, boolean hasLightSwitch) {
        super(name);
        this.on = on;
        this.colour = colour;
        this.power = power;
        this.hasLightSwitch = hasLightSwitch;
    }

    /**
     * Sets the color of the lamp
     * @param colour the color
     */
    public void setColour(Colour colour) {
        this.colour = colour;
    }

    /**
     * Gets the power.
     *
     * @return The power
     */
    public double getPower() {
        return power;
    }

    /**
     * Sets the power.
     *
     * @param power The new power
     */
    public void setPower(double power) {
        this.power = power;
    }

    /**
     * Gets whether the lamp has a light switch.
     *
     * @return True iff this lamp has a light switch
     */
    public boolean hasLightSwitch() {
        return hasLightSwitch;
    }

    /**
     * @inheritDoc
     */
    @Override
    public void turnOff() {
        on = false;
        System.out.println(getName() + " is now off");
    }

    /**
     * @inheritDoc
     */
    @Override
    public void turnOn() {
        on = true;
        System.out.println(getName() + " is now on");
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean isOn() {
        return on;
    }

    /**
     * @inheritDoc
     */
    @Override
    public String getDescription() {
        String desc = "Lamp " + getName() + " with power " + power + " and " + colour;
        if (hasLightSwitch) desc += "with a light switch ";
        if (on) desc += "is turned on";
        else desc += "is turned off";
        return desc;
    }
}
