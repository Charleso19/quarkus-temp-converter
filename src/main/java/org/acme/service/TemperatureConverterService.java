package org.acme.service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TemperatureConverterService {

    public double celsiusToFahrenheit(final String celsiusTemp) {

        final double celsiusTempDouble =
                Double.parseDouble(celsiusTemp);

        // Convert celsius to fahrenheit.
        return (celsiusTempDouble * 1.8) + 32.0;

    }

    public double fahrenheitToCelsius(final String fahrenheitTemp) {

        final double fahrenheitTempDouble = Double.parseDouble(fahrenheitTemp);

        return (fahrenheitTempDouble - 32) * (5 / 9.0);

    }
}
