// Import required classes for array handling
import java.util.Arrays;

public class ChosenWord {
    // The actual word that the player needs to guess
    private final String word;

    // An array to represent the letters of the word that have been revealed so far
    private char[] revealedLetters;

    // Constructor initializes the word and the revealedLetters array
    public ChosenWord(String word) {
        this.word = word;

        // Initialize the revealedLetters array with underscores
        this.revealedLetters = new char[word.length()];
        Arrays.fill(this.revealedLetters, '_');
    }

    // This method checks if the guessed letter is in the word
    // and updates the revealedLetters array accordingly
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

    // This method checks if the entire word has been guessed
    public boolean isFullyGuessed() {
        for (char c : revealedLetters) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    // Convert the revealedLetters array to a string for display
    @Override
    public String toString() {
        return new String(revealedLetters);
    }
}
