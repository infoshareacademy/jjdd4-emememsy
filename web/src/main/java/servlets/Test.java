package servlets;

import com.infoshareacademy.emememsy.InputOutput;
import com.infoshareacademy.emememsy.SingleWord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

        List<SingleWord> tempList = new ArrayList<>();
        tempList = InputOutput.createListOfWordsOmmitProperties();
        InputOutput.writeToCSV(tempList);
        List<String> categories = tempList.stream()
                .map(o -> o.getCategory())
                .distinct()
                .collect(Collectors.toList());

        System.out.println(categories);
    }
}
