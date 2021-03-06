package JavaBasics1;

import java.util.Random;
import java.util.Scanner;

/**
 * @author amattson-sm
 * Java Basics 1
 * Assignment 2: Guess a Number
 */
public class Assignment2 {

    /**
     * Setup phase
     */
    final boolean debug = true;
    int target, chances;
    public Assignment2() {
        // initialize vars
        Random r = new Random();
        chances = 5;
        target = Math.abs(r.ints(1).findFirst().getAsInt() % 101);
        if (debug) System.out.println("Number to guess (debug): " + target);
    }

    /**
     * Scan the input and interpret results
     */
    public void scanInput() {
        // get user input
        Scanner userInput = new Scanner(System.in);
        for (int i = 0; i < chances; i++) {
            // accept guesses
            System.out.println("Enter a Guess:");
            int guess = Integer.parseInt(userInput.nextLine());
            int offset = Math.abs(guess - target);

            // interpret guesses
            if (guess < 0 || guess > 100) {
                // invalid input
                i--;
                System.out.println("Invalid input. Please enter a number between 0 and 100.");
            }
            else if (offset <= 10) {
                // correct
                if (offset == 0) System.out.println("Your guess was spot-on!");
                else System.out.println("Your guess was " + offset + " away from the answer!");
                System.out.println("Your Guess: " + guess + "\nAnswer: " + target);
                return;
            }
            else {
                // incorrect
                System.out.println("Your guess is incorrect. Tries remaining: " + (4 - i));
            }
        }
        System.out.println("You have run out of guesses. The number was: " + target + ". Better luck next time!");
    }

    /**
     * Create and call the problem
     */
    public static void main(String[] args) {
        Assignment2 guesser = new Assignment2();
        guesser.scanInput();
    }
}
