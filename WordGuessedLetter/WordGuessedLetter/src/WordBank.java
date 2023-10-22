// Import required classes for list handling and random number generation
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WordBank {
    // A static list of words from which a random word will be chosen for the game
    private static final List<String> WORDS = Arrays.asList("programming", "java", "eclipse", "object", "inheritance");

    // Method to fetch a random word from the WORDS list
    public static String getRandomWord() {
        // Create a new Random object
        Random rand = new Random();

        // Return a random word from the WORDS list
        return WORDS.get(rand.nextInt(WORDS.size()));
    }
}
