package JavaBasics5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author aidan.mattson
 * Java Basics 5
 * Assignment 2: Functional I (return last digits of array values)
 */
public class Assignment2 {
    // modify each value to be itself in modulo 10, to get the rightmost digits
    public List<Integer> modulo(List<Integer> input) {
        List<Integer> output = new ArrayList<>();
        for (Integer item : input) {
            assert item >= 0;
            output.add(item % 10);
        }
        return output;
    }

    // create and run the assignment
    public static void main(String[] args) {
        Assignment2 functional = new Assignment2();

        // calculate results
        List<Integer> testInput = new ArrayList<>(Arrays.asList(0, 1, 50, 30303, 90));
        List<Integer> testResult = functional.modulo(testInput);
        System.out.println("Result Array:\n" + testResult);
    }
}
