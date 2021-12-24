package org.acme;

import org.acme.service.TemperatureConverterService;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/convert")
public class TemperatureConverterResource {

    private static final Logger LOGGER =
            Logger.getLogger(TemperatureConverterResource.class);

    @Inject
    TemperatureConverterService temperatureConverterService;

    @Path("/celsius/{degrees}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String celsiusToFahrenheit(
            @PathParam(value = "degrees") final String degrees) {

        LOGGER.infof("Degrees in Celsius: %s\u00B0C", degrees);

        return String.valueOf(temperatureConverterService.celsiusToFahrenheit(degrees));
    }

    @Path("/fahrenheit/{degrees}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String fahrenheitToCelsius(
            @PathParam(value = "degrees") final String degrees) {

        LOGGER.infof("Degrees in Fahrenheit: %s\u00B0F", degrees);

        return String.valueOf(temperatureConverterService.fahrenheitToCelsius(degrees));

    }
}