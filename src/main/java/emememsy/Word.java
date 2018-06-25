package emememsy;

public class Word {
    private String polishWord;
    private String englishWord;
    private Integer counter;


    public Word(String polishWord, String englishWord, Integer counter) {
        this.polishWord = polishWord;
        this.englishWord = englishWord;
        this.counter = counter;
    }

    @Override
    public String toString() {
        return "Word{" +
                "polishWord='" + polishWord + '\'' +
                ", englishWord='" + englishWord + '\'' +
                ", counter=" + counter +
                '}';
    }
}