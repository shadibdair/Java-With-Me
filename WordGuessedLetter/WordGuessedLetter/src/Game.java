// Import required classes for user input and list handling
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        // Initialize a scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Flag to check if the user wants to play again
        boolean playAgain = true;

        // Game loop starts here
        while (playAgain) {
            // Get a random word for the user to guess
            ChosenWord chosenWord = new ChosenWord(WordBank.getRandomWord());

            // Create a list of available letters for the user to guess
            List<Character> availableLetters = new ArrayList<>();
            for (char c = 'a'; c <= 'z'; c++) {
                availableLetters.add(c);
            }

            // Counter for the number of user guesses
            int guesses = 0;

            // Continue prompting the user until the word is fully guessed
            while (!chosenWord.isFullyGuessed()) {
                System.out.println("Word: " + chosenWord);
                System.out.println("Available letters: " + availableLetters);
                System.out.print("Guess a letter: ");
                char guessedLetter = scanner.next().toLowerCase().charAt(0);

                // Check if the guessed letter is not in the list of available letters
                if (!availableLetters.contains(guessedLetter)) {
                    System.out.println("Invalid input or letter already guessed. Try again.");
                    continue;
                }

                // Remove the guessed letter from the available letters
                availableLetters.remove(Character.valueOf(guessedLetter));

                // Check if the guessed letter is in the word
                if (chosenWord.guessLetter(guessedLetter)) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Wrong guess.");
                }

                guesses++;
            }

            // Inform the user that they guessed the word and show the number of attempts
            System.out.println("Congratulations! You guessed the word in " + guesses + " guesses.");

            // Ask if the user wants to play again
            System.out.print("Play again? (y/n): ");
            playAgain = scanner.next().toLowerCase().charAt(0) == 'y';
        }

        // Exit message
        System.out.println("Thank you for playing!");
    }
}
