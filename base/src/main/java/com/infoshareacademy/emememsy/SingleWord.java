package com.infoshareacademy.emememsy;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "WORDS")
public class SingleWord{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @CsvBindByName(column = "word")
    @Column(name = "word")
    @NotNull
    private String word;

    @CsvBindByName(column = "translation")
    @Column(name = "translation")
    @NotNull
    private String translation;

    @CsvBindByName(column = "category")
    @Column(name = "category")
    @NotNull
    private String category;

    @CsvBindByName(column = "counter")
    @Column(name = "counter")
    @NotNull
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
