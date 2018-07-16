package com.infoshareacademy.emememsy;

import javax.enterprise.context.RequestScoped;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RequestScoped
public class ActionsWeb {
    private Random randomGenerator = new Random();

    public SingleWord pickRandomBrowserMode(List<SingleWord> listOfWords, String category) {
        if (category.equalsIgnoreCase("wszystkie")) {
            return pickRandomBrowserModeNoCategory(listOfWords);
        } else {
            return pickRandomBrowserModeCategory(listOfWords, category);
        }
    }


    public SingleWord pickRandomBrowserModeCategory(List<SingleWord> listOfWords, String category) {
            for (SingleWord word : listOfWords) {
                int random = randomGenerator.nextInt(listOfWords.size());
                SingleWord singleWord = listOfWords.get(random);
                if (singleWord.getCounter() == 0 && singleWord.getCategory().equalsIgnoreCase(category)) {
                    return singleWord;
                }
            }
        return null;
    }

    public SingleWord pickRandomBrowserModeNoCategory(List<SingleWord> listOfWords) {
        for (SingleWord word : listOfWords) {
            int random = randomGenerator.nextInt(listOfWords.size());
            SingleWord singleWord = listOfWords.get(random);
            if (singleWord.getCounter() == 0) {
                return singleWord;
            }
        }
        return null;
    }

    public static void setAllCountersToZero(List<SingleWord> listOfWords) {
        listOfWords.forEach(o -> o.setCounter(0));
    }

    private SingleWord pickWordCategory(List<SingleWord> listOfWords, int min, int max, String category) {
        List<SingleWord> testWords = listOfWords.stream()
                .filter(o -> o.getCounter() > min && o.getCounter() < max && o.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
            if (testWords.size() > 0) {
                int random = randomGenerator.nextInt(testWords.size());
                SingleWord singleWord = testWords.get(random);
                return singleWord;
            }
        return null;
    }

    private SingleWord pickWordNoCategory(List<SingleWord> listOfWords, int min, int max) {
        List<SingleWord> testWords = listOfWords.stream()
                .filter(o -> o.getCounter() > min && o.getCounter() < max)
                .collect(Collectors.toList());
            if (testWords.size() > 0) {
                int random = randomGenerator.nextInt(testWords.size());
                SingleWord singleWord = testWords.get(random);
                return singleWord;
            }
        return null;
    }

    public SingleWord pickRandomLearnMode(List<SingleWord> listOfWords, String category) {
        if (category.equalsIgnoreCase("wszystkie")) {
            return pickWordNoCategory(listOfWords, 0, 4);
        } else {
            return pickWordCategory(listOfWords,0, 4, category);
        }
    };

    public SingleWord pickRandomRepeatMode(List<SingleWord> listOfWords, String category) {
        if (category.equalsIgnoreCase("wszystkie")) {
            return pickWordNoCategory(listOfWords, 3, 99);
        } else {
            return pickWordCategory(listOfWords,3, 99, category);
        }
    };

}
