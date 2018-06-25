package emememsy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class PropertiesReader {

    static Map<String, String> read(String fileName) {

        Map<String, String> properties = new HashMap<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(
                    x -> {
                        String[] splittedLine = x.split(":");
                        properties.put(splittedLine[0], splittedLine[1]);
                    }
            );

        } catch (IOException e) {
            System.out.println("Błąd pobrania pliku");
        }

        return properties;
    }



}
