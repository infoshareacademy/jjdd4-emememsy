package emememsy;


import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args)  {
        String fileName = "/home/sebastianbieluga/slowka.txt";
        Map<String, String> properties = PropertiesReader.read(fileName);
        System.out.printf(properties.get("pathToWordsFile"));
    }

}