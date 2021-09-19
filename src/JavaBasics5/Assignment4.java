package JavaBasics5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author aidan.mattson
 * Java Basics 5
 * Assignment 4: Functional III (remove all x's)
 */
public class Assignment4 {
    // modify each value to be itself in modulo 10, to get the rightmost digits
    public List<String> removeX(List<String> input) {
        List<String> output = new ArrayList<>();
        for (String item : input)
            output.add(item.replace("x", ""));
        return output;
    }

    public static void main(String[] args) {
        Assignment4 functional = new Assignment4();

        // calculate results
        List<String> testInput = new ArrayList<>(Arrays.asList("ax", "xx", "blah", ""));
        List<String> testResult = functional.removeX(testInput);

        // make results pretty
        StringBuilder output = new StringBuilder("Result Array:\n[ '");
        for (int i = 0; i < testResult.size(); i++) {
            output.append(testResult.get(i));
            if (i < testResult.size() - 1) output.append("', '");
            else output.append("' ]");
        }
        System.out.println(output.toString());
    }
}
