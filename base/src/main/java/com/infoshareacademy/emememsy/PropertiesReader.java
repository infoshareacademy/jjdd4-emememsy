package com.infoshareacademy.emememsy;

import javax.enterprise.context.RequestScoped;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@RequestScoped
public class PropertiesReader {

    public static final String PATH_KEY = "path";
    public static final String FORMATTING_KEY = "formatting";
    public static final String FROMEMAIL_KEY = "fromEmail";
    public static final String USERNAME_KEY = "username";
    public static final String PASSWORD_KEY = "password";
    public static final String SUBJECT_KEY = "subject";

    public static Map<String, String> read(String fileName) {
        Map<String, String> properties = new HashMap<>();
        Properties p = new Properties();
        try {
            p.load(new FileReader(fileName));
            p.forEach((key, value) -> properties.put((String) key, (String) value));
        } catch (IOException e) {
            System.out.println("Błąd wczytania pliku: " + e.getMessage());
        }
        return properties;
    }
}
