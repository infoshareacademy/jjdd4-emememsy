package emememsy;

import java.util.Set;

public class SetOfWords {

    public SetOfWords(Set<SingleWord> words) {
        this.words = words;
    }

    Set<SingleWord> words;

    public Set<SingleWord> getWords() {
        return words;
    }

    public void setWords(Set<SingleWord> words) {
        this.words = words;
    }

    public void addWord(SingleWord singleWord) {
        singleWord.setSetOfWords(this);
        words.add(singleWord);
    }


}
