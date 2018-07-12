package com.infoshareacademy.emememsy;

import javax.enterprise.context.RequestScoped;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RequestScoped
public class Actions {

    private Random randomGenerator = new Random();

    public SingleWord pickRandomBrowserMode(List<SingleWord> listOfWords) {
        for (SingleWord word : listOfWords) {
            int random = randomGenerator.nextInt(listOfWords.size());
            SingleWord singleWord = listOfWords.get(random);
            if (singleWord.getCounter() == 0) {
                System.out.println("Słowo: " + singleWord.getWord() + ", Tłumaczenie: " + singleWord.getTranslation());
                return singleWord;
            }
        }
        return null;
    }

    public static void setAllCountersToZero(List<SingleWord> listOfWords) {
        listOfWords.forEach(o -> o.setCounter(0));
    }

    private SingleWord pickWord(List<SingleWord> listOfWords, int min, int max, String msg) {
        List<SingleWord> testWords = listOfWords.stream()
                .filter(o -> o.getCounter() > min && o.getCounter() < max)
                .collect(Collectors.toList());
        if (testWords.size() > 0) {
            int random = randomGenerator.nextInt(testWords.size());
            SingleWord singleWord = testWords.get(random);
            System.out.println("Czy znasz tłumaczenie słowa: " + "\"" + singleWord.getWord() + "\"" + "?");
            return singleWord;
        }
        System.out.println(msg);
        return null;
    }

    public SingleWord pickRandomLearnMode(List<SingleWord> listOfWords) {
        return pickWord(listOfWords, 0, 4,
                "Nie ma dostępnych słów w tym trybie. Przejdź do trybu nauki aby poznać nowe słowa lub wróć za jakiś czas do trybu powrótek aby utrwalić materiał");
    }

    public SingleWord pickRandomRepeatMode(List<SingleWord> listOfWords) {
        return pickWord(listOfWords, 3, 99,
                "Nie ma dostępnych słów w tym trybie. Przejdź do trybu nauki aby poznać nowe słowa");
    }

    public String showCorrectTranslation(SingleWord pickedWord) {
        return "Poprawne tłumaczenie to: " + pickedWord.getTranslation();
    }
}
