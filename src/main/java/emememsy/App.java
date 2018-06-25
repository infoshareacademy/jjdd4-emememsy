package emememsy;


import java.util.List;

public class App {

    public static void main(String[] args)  {
        String fileName = "/home/sebastianbieluga/slowka.txt";
        List<Word> words = CSVfileReader.read(fileName);
        System.out.println(words);
    }

}