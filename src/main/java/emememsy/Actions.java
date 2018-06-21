package emememsy;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Actions {

    private Random randomGenerator;

    public String pickRandomLearnMode (List<SingleWord> listOfWords){
        for (SingleWord word: listOfWords) {
            randomGenerator = new Random();
            int random = randomGenerator.nextInt(listOfWords.size());
            SingleWord singleWord = listOfWords.get(random);
            if (singleWord.getCounter() == 0) {
                System.out.println(singleWord);
                singleWord.setCounter(singleWord.getCounter() + 1);
                System.out.println(singleWord); //weryfikacja inkrementacji licznika
                return singleWord.toString();
            }
        }
            String message = "Nie ma więcej słów do nauki. Przejdź do trybu testu.";
            System.out.println(message);
            return message;

    }
}
