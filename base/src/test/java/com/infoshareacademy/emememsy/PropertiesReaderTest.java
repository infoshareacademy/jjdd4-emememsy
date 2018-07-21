package com.infoshareacademy.emememsy;

import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;


public class PropertiesReaderTest {

    @Test
    public void ifCorrectMappingPropertiesConfigToMap() {
        //GIVEN
        PropertiesReader propertiesReader = new PropertiesReader();

        Map<String, String> expected = new HashMap<>();
        expected.put("testKey1", "testValue1");
        expected.put("testKey2", "testValue2");

        //WHEN
        Map<String, String> result = propertiesReader.read("../base/src/test/config-test1.properties");

        //THEN
        assertTrue(expected.equals(result));

    }
}