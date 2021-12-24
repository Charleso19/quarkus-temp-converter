package org.acme.service;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.math.RoundingMode;
import java.text.DecimalFormat;

@ApplicationScoped
public class TemperatureConverterService {

    private static final DecimalFormat df = new DecimalFormat("#.##");

    @PostConstruct
    void init() {
        df.setRoundingMode(RoundingMode.HALF_UP);
    }

    public String celsiusToFahrenheit(final String celsiusTemp) {

        final double celsiusTempDouble =
                Double.parseDouble(celsiusTemp);

        // Convert celsius to fahrenheit.
        return df.format((celsiusTempDouble * 1.8) + 32.0);

    }

    public String fahrenheitToCelsius(final String fahrenheitTemp) {

        final double fahrenheitTempDouble = Double.parseDouble(fahrenheitTemp);

        // Convert fahrenheit to celsius.
        return df.format((fahrenheitTempDouble - 32) * (5 / 9.0));
    }
}
