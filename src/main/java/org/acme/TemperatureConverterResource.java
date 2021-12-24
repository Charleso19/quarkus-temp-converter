package org.acme;

import io.smallrye.mutiny.Uni;
import org.acme.service.TemperatureConverterService;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
    public Uni<String> celsiusToFahrenheit(
            @PathParam(value = "degrees") final String degrees) {

        LOGGER.infof("Degrees in Celsius: %s\u00B0C", degrees);

        return Uni.createFrom().item(degrees)
                .onItem()
                .transform(item ->
                        temperatureConverterService.celsiusToFahrenheit(item));
    }

    @Path("/fahrenheit/{degrees}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> fahrenheitToCelsius(
            @PathParam(value = "degrees") final String degrees) {

        LOGGER.infof("Degrees in Fahrenheit: %s\u00B0F", degrees);

        return Uni.createFrom().item(degrees)
                .onItem()
                .transform(item ->
                        temperatureConverterService.fahrenheitToCelsius(item));
    }
}