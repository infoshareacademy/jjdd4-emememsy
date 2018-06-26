package com.infoshareacademy.emememsy;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {

    //this is another main fot testing purposes - please don't assess - WILL BE REMOVED after merging all modules

    public static void main(String[] args) {
        new Test().run();
    }

    private void run() {




        List<SingleWord> myList = new ArrayList<>();
        //test wczytania pliku i stworenia tablicy
        try {
            myList = InputOutput.createListOfWords();
        } catch (IOException e) {
            System.out.println("Wystąpił problem z wczytaniem Twojego pliku. Sprawdź czy podałeś poprawną ścieżkę w pliku properties");
        }
        //symulacja trybu nauki
        String singleWord = new Actions().pickRandomLearnMode(myList);
        try {
            InputOutput.writeToCSV(myList);
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            System.out.println("Wystąpił problem z zapisaniem zmian. Skontaktuj się z administratorem.");
        }
        //weryfikacja stanu listy
        //myList.stream().forEach(System.out::println);


    }
}
