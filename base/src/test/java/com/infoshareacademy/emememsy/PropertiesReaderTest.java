package com.infoshareacademy.emememsy;

import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class PropertiesReaderTest {

    @Test
    public void read() {
        //GIVEN
        PropertiesReader propertiesReader = new PropertiesReader();

        Map<String, String> testProperties = new HashMap<>();
        testProperties.put("testKey1", "testValue1");
        testProperties.put("testKey2", "testValue2");

        String filePath = new File("").getAbsolutePath() + "/src/test/config-test1.properties";

        //WHEN
        Map<String, String> result = propertiesReader.read(filePath);

        //THEN
        assertTrue(testProperties.equals(result));

    }
}