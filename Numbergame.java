package abc;
import java.util.Scanner;
import java.util.Random;
public class GuesstheNumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minValue = 1;
        int maxValue = 100;
        int totalScore = 0; 
        System.out.println("Welcome to the Number Guessing Game!");       
        boolean playAgain = true;
        while (playAgain) {
            int randomNumber = random.nextInt(maxValue - minValue + 1) + minValue;            
            int maxAttempts = 7; 
            int guess;
            int attempts = 0;
            boolean guessedCorrectly = false;           
            System.out.println("I've choosed a number between " + minValue + " and " + maxValue + ". Can you guess it?");           
            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++;                
                if (guess == randomNumber) {
                    guessedCorrectly = true;
                    int roundScore = maxAttempts - attempts + 1; 
                    totalScore += roundScore; 
                    System.out.println("Congratulations! You've guessed the number " + randomNumber + " correctly in " + attempts + " attempts.");
                    System.out.println("Your score for this round: " + roundScore);
                } else if (guess < randomNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }          if (!guessedCorrectly) {         
                System.out.println("Sorry, you've run out of attempts. The number was: " + randomNumber);
            }            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next();
            playAgain = playAgainResponse.equalsIgnoreCase("yes");
        }      System.out.println("Thanks for playing! Your total score across all rounds: " + totalScore);       
        scanner.close();    } }


