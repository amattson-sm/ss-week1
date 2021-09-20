package JavaBasics5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author aidan.mattson
 * Java Basics 5
 * Assignment 3: Functional II (double all array values)
 */
public class Assignment3 {
    // modify each value to be itself in modulo 10, to get the rightmost digits
    public List<Integer> doubleAll(List<Integer> input) {
        List<Integer> output = new ArrayList<>();
        for (Integer item : input)
            output.add(item * 2);
        return output;
    }

    public static void main(String[] args) {
        Assignment3 functional = new Assignment3();

        // calculate results
        List<Integer> testInput = new ArrayList<>(Arrays.asList(4, 6, 0, -10, 40404));
        List<Integer> testResult = functional.doubleAll(testInput);
        System.out.println("Result Array:\n" + testResult);
    }
}
