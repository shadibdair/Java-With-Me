import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WordBank {
    private static final List<String> WORDS = Arrays.asList("programming", "java", "eclipse", "object", "inheritance");

    public static String getRandomWord() {
        Random rand = new Random();
        return WORDS.get(rand.nextInt(WORDS.size()));
    }
}
