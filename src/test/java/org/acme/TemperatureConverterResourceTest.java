package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class TemperatureConverterResourceTest {

    @Test
    public void convertCelsiusToFahrenheitTest() {
        given()
                /*
                 * This sets the Content-Type header for the client as plain
                 * text. This header is sent to the endpoint as part of the
                 * client request, meaning it is sending some plain text to the
                 * endpoint, which links to the @Consume annotation on the
                 * endpoint.
                 */
                .header("Content-Type", MediaType.TEXT_PLAIN)
                .when().get("/convert/celsius/100")
                .then()
                .statusCode(200)
                .body("value", is("212"),
                        "temperatureScale", is("FAHRENHEIT"));
    }

    @Test
    public void convertFahrenheitToCelsiusTest() {
        given()
                .header("Content-Type", MediaType.TEXT_PLAIN)
                .when().get("/convert/fahrenheit/100")
                .then()
                .statusCode(200)
                .body("value", is("37.78"),
                        "temperatureScale", is("CELSIUS"));
    }
}