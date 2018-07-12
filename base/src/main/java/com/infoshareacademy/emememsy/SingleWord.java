package com.infoshareacademy.emememsy;

import com.opencsv.bean.CsvBindByName;

import javax.enterprise.context.RequestScoped;
import java.util.Objects;

@RequestScoped
public class SingleWord implements Comparable {

    @CsvBindByName(column = "word")
    private String word;
    @CsvBindByName(column = "translation")
    private String translation;
    @CsvBindByName(column = "category")
    private String category;
    @CsvBindByName(column = "counter")
    private int counter;

    public SingleWord() {
    }

    public SingleWord(String word, String translation, String category, int counter) {
        this.word = word;
        this.translation = translation;
        this.counter = counter;
        this.category = category;
    }

    public void good() {
        setCounter(this.counter + 3);
    }

    public void soso() {
        setCounter(this.counter + 1);
    }

    public void bad() {
        setCounter(this.counter);
    }

    public void increaseCounterByOne() {
        setCounter(this.counter + 1);
    }

    public void exclude() {
        setCounter(this.counter + 100);
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public String getCorrectTranslation() {
        return "Correct translation: " + translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "SingleWord{" +
                "word='" + word + '\'' +
                ", translation='" + translation + '\'' +
                ", category='" + category + '\'' +
                ", counter=" + counter +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SingleWord)) return false;
        SingleWord that = (SingleWord) o;
        return counter == that.counter &&
                Objects.equals(word, that.word) &&
                Objects.equals(translation, that.translation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, translation, counter);
    }

    @Override
    public int compareTo(Object o) {
        return this.getWord().compareTo(((SingleWord) o).getWord());
    }

    public void toLowerCase() {
        this.category = this.category.toLowerCase();
        this.word = this.word.toLowerCase();
        this.translation = this.translation.toLowerCase();
    }

    public void toUpperCase() {
        this.category = this.category.toUpperCase();
        this.word = this.word.toUpperCase();
        this.translation = this.translation.toUpperCase();
    }
}
