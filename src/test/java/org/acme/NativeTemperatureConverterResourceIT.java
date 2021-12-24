package org.acme;

import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeTemperatureConverterResourceIT extends TemperatureConverterResourceTest {

    // Execute the same tests but in native mode.
}