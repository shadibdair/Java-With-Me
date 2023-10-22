import java.util.Arrays;

public class ChosenWord {
    private final String word;
    private char[] revealedLetters;

    public ChosenWord(String word) {
        this.word = word;
        this.revealedLetters = new char[word.length()];
        Arrays.fill(this.revealedLetters, '_');
    }

    public boolean guessLetter(char letter) {
        boolean isLetterInWord = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                revealedLetters[i] = letter;
                isLetterInWord = true;
            }
        }
        return isLetterInWord;
    }

    public boolean isFullyGuessed() {
        for (char c : revealedLetters) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return new String(revealedLetters);
    }
}
