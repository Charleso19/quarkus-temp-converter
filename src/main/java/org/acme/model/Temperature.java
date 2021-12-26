package org.acme.model;

/**
 * Temperature class to store the value and type of {@link TemperatureScale}
 *
 * @author Owen Charles
 * @version 1.0
 */
public class Temperature {

    private String degrees;
    private TemperatureScale temperatureScale;

    /**
     * Default no-args constructor is required by the JSON serialization layer.
     */
    public Temperature() {}

    /**
     * Standard constructor for the initialisation of Temperature.
     *
     * @param degrees - The temperature in degrees.
     * @param temperatureScale - The {@link TemperatureScale}, such as Celsius
     *                         or Fahrenheit.
     */
    public Temperature(final String degrees, TemperatureScale temperatureScale) {
        this.degrees = degrees;
        this.temperatureScale = temperatureScale;
    }

    /**
     * Standard getter method.
     *
     * @return the degrees of the {@link Temperature} instance.
     */
    public String getDegrees() {
        return degrees;
    }

    /**
     * Builder setter method.
     *
     * @param degrees - The degrees of temperature.
     * @return this with the degrees set.
     */
    public Temperature setDegrees(final String degrees) {
        this.degrees = degrees;
        return this;
    }

    /**
     * Standard getter method.
     *
     * @return The {@link TemperatureScale} associated with the
     *         {@link Temperature} instance.
     */
    public TemperatureScale getTemperatureScale() {
        return temperatureScale;
    }

    /**
     * Builder setter method.
     *
     * @param temperatureScale - The {@link TemperatureScale} of the
     *                           {@link Temperature}.
     *
     * @return this with the {@link TemperatureScale} set.
     */
    public Temperature setTemperatureScale(final TemperatureScale temperatureScale) {
        this.temperatureScale = temperatureScale;
        return this;
    }
}
