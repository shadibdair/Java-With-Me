import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        while (playAgain) {
            ChosenWord chosenWord = new ChosenWord(WordBank.getRandomWord());
            List<Character> availableLetters = new ArrayList<>();
            for (char c = 'a'; c <= 'z'; c++) {
                availableLetters.add(c);
            }

            int guesses = 0;
            while (!chosenWord.isFullyGuessed()) {
                System.out.println("Word: " + chosenWord);
                System.out.println("Available letters: " + availableLetters);
                System.out.print("Guess a letter: ");
                char guessedLetter = scanner.next().toLowerCase().charAt(0);

                if (!availableLetters.contains(guessedLetter)) {
                    System.out.println("Invalid input or letter already guessed. Try again.");
                    continue;
                }

                availableLetters.remove(Character.valueOf(guessedLetter));

                if (chosenWord.guessLetter(guessedLetter)) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Wrong guess.");
                }

                guesses++;
            }

            System.out.println("Congratulations! You guessed the word in " + guesses + " guesses.");
            System.out.print("Play again? (y/n): ");
            playAgain = scanner.next().toLowerCase().charAt(0) == 'y';
        }

        System.out.println("Thank you for playing!");
    }
}
