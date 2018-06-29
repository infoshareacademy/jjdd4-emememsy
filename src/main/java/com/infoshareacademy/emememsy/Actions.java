package com.infoshareacademy.emememsy;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Actions {

    private Random randomGenerator = new Random();

    public SingleWord pickRandomLearnMode(List<SingleWord> listOfWords) {
        for (SingleWord word : listOfWords) {
            int random = randomGenerator.nextInt(listOfWords.size());
            SingleWord singleWord = listOfWords.get(random);
            if (singleWord.getCounter() == 0) {
                //System.out.println(singleWord); //weryfikacja, że wylosowano liczbę z przedziału 1
                return singleWord;
            }
        }
        String message = "Nie ma więcej słów do nauki. Przejdź do trybu testu.";
        System.out.println(message);
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
            System.out.println("Podaj tłumaczenie słowa: " + singleWord.getWord());
            return singleWord;
        }
        System.out.println(msg);
        return null;
    }

    public SingleWord pickRandomTestMode(List<SingleWord> listOfWords) {
        return pickWord(listOfWords, 0, 4,
                "Nie ma dostępnych słów w tym trybie. Przejdź do trybu nauki aby poznać nowe słowa lub wróć za jakiś czas do trybu powrótek aby utrwalić materiał");
    }

    public SingleWord pickRandomReviewMode(List<SingleWord> listOfWords) {
        return pickWord(listOfWords, 5, 10,
                "Nie ma dostępnych słów w tym trybie. Przejdź do trybu nauki aby poznać nowe słowa");
    }

    public String showCorrectTranslation(SingleWord pickedWord) {
        return "Correct translation: " + pickedWord.getTranslation();
    }
}
