package emememsy;

import java.util.Objects;

public class SingleWord {

    private String word;
    private String translation;
    private int counter;
    private SetOfWords setOfWords;

    public SingleWord(String word, String translation, int counter) {
        this.word = word;
        this.translation = translation;
        this.counter = counter;
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

    public SetOfWords getSetOfWords() {
        return setOfWords;
    }

    public void setSetOfWords(SetOfWords setOfWords) {
        this.setOfWords = setOfWords;
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


}
