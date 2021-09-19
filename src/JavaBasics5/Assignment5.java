package JavaBasics5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author aidan.mattson
 * Java Basics 5
 * Assignment 2: Recursive (return last digits of array values)
 */
public class Assignment5 {

    /**
     * non-recursive method to simplify an array into easier values
     *   - condenses consecutive sequences into single values
     *   - ignores values equal to 0
     * @param testArray array to simplify to a list
     * @return the simplified array
     */
    protected Integer[] condenseArray(Integer[] testArray) {
        // set up a new list
        List<Integer> updatedItems = new ArrayList<>();
        if (testArray.length == 0) return new Integer[]{};

        // condense list items
        Integer runningTotal = testArray[0], previous = testArray[0];
        for (int i = 1; i < testArray.length; i++) {
            // continue adding consecutive values
            if (testArray[i].equals(previous))
                runningTotal += previous;
            // save added values
            else {
                if (runningTotal != 0)
                    updatedItems.add(runningTotal);
                runningTotal = testArray[i];
                previous = runningTotal;
            }
        }
        if (runningTotal != 0)
            updatedItems.add(runningTotal);
        return updatedItems.toArray(Integer[]::new);
    }


    /**
     * converts input to values for the recursive worker to parse
     * @param testArray array of integers to test against testValue
     * @param testValue value to check for the sum of
     * @return boolean representing whether testValue can be summed within testArray
     */
    public Boolean groupSumClump(Integer[] testArray, Integer testValue) {
        return recursiveWorker(0, condenseArray(testArray), testValue);
    }

    private Boolean recursiveWorker(Integer currentValue, Integer[] testArray, Integer testValue) {
        // base cases for exiting the array
        if (currentValue.equals(testValue)) return Boolean.TRUE;
        else if (testArray.length == 0) return Boolean.FALSE;

        // recursively check each value combination
        for (int i = 0; i < testArray.length; i++) {
            if (recursiveWorker(testArray[i] + currentValue, truncateArray(testArray, i), testValue))
                return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * helper function to return an array clone without the specified index
     * @param input the array to truncate
     * @param ignoreIndex the index to ignore
     * @return the array without the truncated value
     */
    private Integer[] truncateArray(Integer[] input, Integer ignoreIndex) {
        Integer[] newArray = new Integer[input.length - 1];
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            if (i != ignoreIndex)
                newArray[count++] = input[i];
        }
        return newArray;
    }

    public static void main(String[] args) {
        // create values
        Assignment5 recursive = new Assignment5();
        Scanner in = new Scanner(System.in);

        // scan for array input
        System.out.print("Enter array values, separated by spaces, and hit enter:\n - ");
        String[] pieces = in.nextLine().split(" ");
        List<Integer> testValues = new ArrayList<>();
        try {
            for (int i = 0; i < pieces.length; i++) {
                testValues.add(Integer.parseInt(pieces[i]));
            }
        } catch (Exception e) {
            System.out.println("Unable to read input. Exiting...");
            return;
        }

        // scan for item to scan for
        Integer testValue = null;
        System.out.print("Enter value to test for ability to sum:\n - ");
        while (testValue == null) {
            try {
                testValue = in.nextInt();
            } catch (Exception e) {
                System.out.print("Invalid test value. Enter a new one:\n - ");
            }
        }

        // get final values
        System.out.println("Able to add to " + testValue + ": " + recursive.groupSumClump(testValues.toArray(Integer[]::new), testValue));
    }
}
