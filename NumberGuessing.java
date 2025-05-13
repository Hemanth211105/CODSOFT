import java.util.Scanner;
import java.util.Random;

public class NumberGuessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        boolean playAgain;

        do {
            int numberToGuess = random.nextInt(100) + 1; // range 1 to 100
            int attemptsLeft = 5; // Limiting to 5 attempts
            boolean guessedCorrectly = false;

            System.out.println("Guess the number between 1 and 100. You have " + attemptsLeft + " attempts.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    guessedCorrectly = true;
                    totalScore += 10; // Award 10 points for a correct guess
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low.");
                } else {
                    System.out.println("Too high.");
                }

                attemptsLeft--;
                System.out.println("Attempts remaining: " + attemptsLeft);
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess);
            }

            System.out.println("Current score: " + totalScore);

            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Game over. Final score: " + totalScore);
        scanner.close();
    }
}
/*
Guess the number between 1 and 100. You have 5 attempts.
Enter your guess: 50
Too low.
Attempts remaining: 4
Enter your guess: 75
Too high.
Attempts remaining: 3
Enter your guess: 65
Too low.
Attempts remaining: 2
Enter your guess: 70
Congratulations! You guessed the number correctly.
Current score: 10
Do you want to play another round? (yes/no): yes

Guess the number between 1 and 100. You have 5 attempts.
Enter your guess: 40
Too high.
Attempts remaining: 4
Enter your guess: 30
Too low.
Attempts remaining: 3
Enter your guess: 35
Too low.
Attempts remaining: 2
Enter your guess: 38
Too high.
Attempts remaining: 1
Enter your guess: 37
Sorry, you've used all your attempts. The correct number was 36
Current score: 10
Do you want to play another round? (yes/no): no

Game over. Final score: 10
*/