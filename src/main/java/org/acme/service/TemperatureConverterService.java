package org.acme.service;

import org.acme.model.Temperature;
import org.acme.model.TemperatureScale;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * A service bean that converts temperature between Celsius and Fahrenheit and
 * vive-versa.
 *
 * @author Owen Charles
 * @version 1.1
 */
@ApplicationScoped
public class TemperatureConverterService {

    private static final DecimalFormat df = new DecimalFormat("#.##");

    @PostConstruct
    void init() {
        df.setRoundingMode(RoundingMode.HALF_UP);
    }

    /**
     * Returns the {@param celsiusTemp} as Fahrenheit via a
     * {@link Temperature} instance.
     *
     * @param celsiusTemp The temperature in Celsius that will be converted to
     *                    Fahrenheit.
     *
     * @return The equivalent {@link Temperature} in Fahrenheit.
     */
    public Temperature celsiusToFahrenheit(final String celsiusTemp) {

        final double celsiusTempDouble =
                Double.parseDouble(celsiusTemp);

        return new Temperature(df.format((celsiusTempDouble * 1.8) + 32.0),
                TemperatureScale.FAHRENHEIT);

    }

    /**
     * Returns the {@param fahrenheitTemp} as Celsius via a
     * {@link Temperature} instance.
     *
     * @param fahrenheitTemp The temperature in Fahrenheit that will be
     *                       converted to Celsius.
     *
     * @return The equivalent {@link Temperature} in Celsius.
     */
    public Temperature fahrenheitToCelsius(final String fahrenheitTemp) {

        final double fahrenheitTempDouble = Double.parseDouble(fahrenheitTemp);

        return new Temperature(df.format((fahrenheitTempDouble - 32) * (5 / 9.0)),
                TemperatureScale.CELSIUS);
    }
}
