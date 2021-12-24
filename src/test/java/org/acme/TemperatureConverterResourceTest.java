package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class TemperatureConverterResourceTest {

    @Test
    public void convertCelsiusToFahrenheitTest() {
        given()
                .when().get("/convert/celsius/100")
                .then()
                .statusCode(200)
                .body(is("212"));
    }

    @Test
    public void convertFahrenheitToCelsiusTest() {
        given()
                .when().get("/convert/fahrenheit/100")
                .then()
                .statusCode(200)
                .body(is("37.78"));
    }
}