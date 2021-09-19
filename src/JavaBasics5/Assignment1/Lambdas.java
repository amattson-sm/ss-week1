package JavaBasics5.Assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author aidan.mattson
 * Java Basics 5
 * Assignment 1: Implement lambdas
 */
public class Lambdas {

    // lambda function for checking odd
    public PerformOperation isOdd = (x) -> x % 2 == 1;

    // lambda function for checking prime
    public PerformOperation isPrime = (x) -> {
        if (x < 2) return Boolean.FALSE;
        for (int i = 2; i <= Math.sqrt(x); i++)
            if (x % i == 0)
                return Boolean.FALSE;
        return Boolean.TRUE;
    };

    // lambda function for checking palindrome
    public PerformOperation isPalindrome = (x) -> {
        char[] input = String.valueOf(x).toCharArray();
        for (int i = 0; i < input.length / 2; i++)
            if (input[i] != input[(input.length - 1) - i])
                return Boolean.FALSE;
        return Boolean.TRUE;
    };

    // callable input collector
    public List<Pair> getInput() {
        // setup
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of test cases:");
        Integer testCount = null;

        // get number of test cases
        while (testCount == null) {
            try {
                testCount = input.nextInt();
            } catch (Exception e) {
                System.out.println("Not a valid input. Please try again: ");
                input.nextLine();
            }
        }

        // get cases
        System.out.println("Using " + testCount + " cases. Enter test cases:");
        String[] cases = new String[testCount];
        input.nextLine();
        for (int i = 0; i < testCount; i++)
            cases[i] = input.nextLine();

        // deal with cases
        List<Pair> testCases = new ArrayList<>();
        for (String test : cases) {
            String[] split = test.split(" ", 2);
            Integer testNum = null, testVar = null;
            try {
                testNum = Integer.parseInt(split[0]);
                testVar = Integer.parseInt(split[1]);
                testCases.add(new Pair(testNum, testVar));
            } catch (Exception e) {
                System.out.println("Error: Cannot parse input from: '" + test + "' (out of bounds)");
                testCases.add(new Pair(null, null));
            }
        }
        return testCases;
    }

    // callable test runner
    public String runTests(List<Pair> testCases) {
        StringBuilder output = new StringBuilder("");
        System.out.println("Collected " + testCases.size() + " cases. RESULTS:\n");
        for (Pair testCase : testCases) {
            if (testCase.num1 == null) {
                output.append("Cannot parse test case: null\n");
                continue;
            }
            switch (testCase.num1) {
                case 1:
                    // isOdd
                    output.append(isOdd.mathTest(testCase.num2) ? "ODD" : "EVEN");
                    break;
                case 2:
                    // isPrime
                    output.append(isPrime.mathTest(testCase.num2) ? "PRIME" : "COMPOSITE");
                    break;
                case 3:
                    // isPalindrome
                    output.append(isPalindrome.mathTest(testCase.num2) ? "PALINDROME" : "NOT PALINDROME");
                    break;
                default:
                    // not a correct input
                    output.append("Cannot parse test case: ").append(testCase.num1);
            }
            output.append('\n');
        }
        return output.toString();
    }

    // malleable input - JavaBasics5Test.java contains a sample input for testing.
    public static void main(String[] args) {
        Lambdas lambdas = new Lambdas();
        List<Pair> testCases = lambdas.getInput();
        String output = lambdas.runTests(testCases);
        System.out.println(output);
    }
}
