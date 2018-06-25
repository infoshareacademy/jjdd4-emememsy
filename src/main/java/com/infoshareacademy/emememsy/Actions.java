package com.infoshareacademy.emememsy;

import java.util.List;
import java.util.Random;

public class Actions {

    private Random randomGenerator = new Random();

    public String pickRandomLearnMode(List<SingleWord> listOfWords) {
        for (SingleWord word : listOfWords) {
            int random = randomGenerator.nextInt(listOfWords.size());
            SingleWord singleWord = listOfWords.get(random);
            if (singleWord.getCounter() == 0) {
                System.out.println(singleWord); //weryfikacja, że wylosowano liczbę z przedziału 1
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
