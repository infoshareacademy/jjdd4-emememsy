package com.infoshareacademy.emememsy;

import com.opencsv.bean.CsvBindByName;

import java.util.Objects;

public class SingleWord implements Comparable {

    @CsvBindByName
    private String word;
    @CsvBindByName
    private String translation;
    @CsvBindByName
    private int counter;


    public SingleWord(String word, String translation, int counter) {
        this.word = word;
        this.translation = translation;
        this.counter = counter;
    }

    public void good () {
        setCounter(this.counter +3);
    }

    public void soso () {
        setCounter(this.counter);
    }

    public void bad () {
        setCounter(this.counter +1);
    }

    public void exclude() {setCounter(this.counter + 100);}

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
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


    @Override
    public String toString() {
        return "SingleWord{" +
                "word='" + word + '\'' +
                ", translation='" + translation + '\'' +
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
}
