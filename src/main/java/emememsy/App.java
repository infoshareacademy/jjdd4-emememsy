package emememsy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        new App().run();
    }

    private void run() {

        List<SingleWord> myList = new ArrayList<>();

        try {
          myList =  InputOutput.createListOfWords();
        } catch (IOException e) {
            e.printStackTrace();
        }


        String singleWord = new Actions().pickRandomLearnMode(myList);


    }
}
