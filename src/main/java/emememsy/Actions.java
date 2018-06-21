package emememsy;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Actions {

    private Random randomGenerator;

    public String pickRandomLearnMode (List<SingleWord> listOfWords){
        randomGenerator = new Random();
        int random = randomGenerator.nextInt(listOfWords.size());
        SingleWord singleWord = listOfWords.get(random);
        System.out.println(singleWord);
        return singleWord.toString();

    }
}
