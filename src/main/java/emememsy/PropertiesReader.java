package emememsy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class CSVfileReader {

    static List<Word> read(String fileName) {

        Map<String, String> properies = new HashMap<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(
                    x -> {
                        String[] splittedLine = x.split(":");


                        result.put(splittedLine[0], splittedLine[1]);
                    }
            );

        } catch (IOException e) {
            System.out.println("Błąd pobrania pliku");
        }

        return result;
    }



}
