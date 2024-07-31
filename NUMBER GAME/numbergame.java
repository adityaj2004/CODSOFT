package Task;

import java.util.Random;
import java.util.Scanner;

public class numbergame {

    public static void main(String[] args) {
        guessTheNumber();
    }

    public static void guessTheNumber() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("Welcome to the Guess the Number Game!");
        System.out.print("Enter the number of rounds you want to play: ");
        int rounds = scanner.nextInt();
        int score = 0;
        
        for (int round = 1; round <= rounds; round++) {
            System.out.println("\nRound " + round);
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            boolean guessedCorrectly = false;
            
            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + " - Guess the number (1-100): ");
                int guess = scanner.nextInt();
                attempts++;
                
                if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Correct! You've guessed the number.");
                    score++;
                    guessedCorrectly = true;
                    break;
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("Out of attempts! The number was " + numberToGuess + ".");
            }
        }
        
        System.out.println("\nGame over! Your score: " + score + "/" + rounds);
        
        System.out.print("Do you want to play again? (yes/no): ");
        scanner.nextLine();  // consume newline
        String playAgain = scanner.nextLine().toLowerCase();
        if (playAgain.equals("yes")) {
            guessTheNumber();
        } else {
            System.out.println("Thank you for playing! Goodbye!");
        }
        
        scanner.close();
    }
}
