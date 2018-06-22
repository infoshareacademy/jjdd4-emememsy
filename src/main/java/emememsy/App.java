package emememsy;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args ) {
        new App().run();
    }

    private void run() {

        List<SingleWord> myList = new ArrayList<>();

        //test wczytania pliku i stworenia tablicy
        try {
          myList =  InputOutput.createListOfWords();
        } catch (IOException e) {
            System.out.println("Wystąpił problem z wczytaniem Twojego pliku. Sprawdź czy podałeś poprawną ścieżkę w pliku properties");
        }

        //symulacja trybu nauki
       String singleWord = new Actions().pickRandomLearnMode(myList);
        try {
            InputOutput.writeToCSV(myList);
        } catch (IOException e) {
            System.out.println("Wystąpił problem z zapisaniem zmian. Skontaktuj się z administratorem.");
        } catch (CsvDataTypeMismatchException e) {
            System.out.println("Wystąpił problem z zapisaniem zmian. Skontaktuj się z administratorem.");
        } catch (CsvRequiredFieldEmptyException e) {
            System.out.println("Wystąpił problem z zapisaniem zmian. Skontaktuj się z administratorem.");
        }

        //weryfikacja stanu listy
        //myList.stream().forEach(System.out::println);


    }
}
