import java.util.Random;
import java.util.Scanner;

public class numbergame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        int totalAttempts = 0;
        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 6;
            boolean guessed = false;

            System.out.println("Welcome to the number guessing game!");
            System.out.println("I'm thinking of a number between 1 and 100.");
            System.out.println("You have 6 attempts to guess the number.");

            while (attempts < maxAttempts && !guessed) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score++;
                    guessed = true;
                }
            }

            if (!guessed) {
                System.out.println("Sorry, you didn't guess the number. The number was " + numberToGuess);
            }

            totalAttempts += attempts;

            System.out.print("Do you want to play again? (yes/no): ");
            String input = scanner.next();
            playAgain = input.equalsIgnoreCase("yes");
        }

        System.out.println("Game over! Your final score is " + score + " wins out of " + (totalAttempts / 6) + " rounds.");
        System.out.println("Your average attempts per round is " + (totalAttempts / (score + (totalAttempts / 6))));
    }
} 