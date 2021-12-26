package org.acme.api;

import io.smallrye.mutiny.Uni;
import org.acme.model.Temperature;
import org.acme.service.TemperatureConverterService;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * A resource class to convert temperature from Celsius to Fahrenheit and
 * vice-versa.
 *
 * @author Owen Charles
 * @version 1.1
 */
@Path("/convert")
public class TemperatureConverterResource {

    private static final Logger LOGGER =
            Logger.getLogger(TemperatureConverterResource.class);

    @Inject
    TemperatureConverterService temperatureConverterService;

    /**
     * Resource method that converts {@param degrees} from Celsius to
     * Fahrenheit.
     *
     * @param degrees The temperature in Celsius.
     * @return The equivalent {@link Temperature} in Fahrenheit.
     */
    @Path("/celsius/{degrees}")
    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Temperature> celsiusToFahrenheit(
            @PathParam(value = "degrees") final String degrees) {

        LOGGER.infof("Degrees in Celsius: %s\u00B0C", degrees);

        return Uni.createFrom().item(degrees)
                .onItem()
                .transform(item ->
                        temperatureConverterService.celsiusToFahrenheit(item));
    }

    /**
     * Resource method that converts {@param degrees} from Fahrenheit to
     * Celsius.
     *
     * @param degrees The temperature in Fahrenheit.
     * @return The equivalent {@link Temperature} in Celsius.
     */
    @Path("/fahrenheit/{degrees}")
    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Temperature> fahrenheitToCelsius(
            @PathParam(value = "degrees") final String degrees) {

        LOGGER.infof("Degrees in Fahrenheit: %s\u00B0F", degrees);

        return Uni.createFrom().item(degrees)
                .onItem()
                .transform(item ->
                        temperatureConverterService.fahrenheitToCelsius(item));
    }
}