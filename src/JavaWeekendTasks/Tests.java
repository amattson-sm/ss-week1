package JavaWeekendTasks;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author aidan.mattson
 * Java Basics 5
 * Tests for all weekend assignments
 */
public class Tests {

    @Test
    public void testBasicLambdas() {
        // Assignment 1: test all cases of the method for sorting 'e' first
        Assert.assertEquals(Assignment1.myMethod("e", "a"), Integer.valueOf(-2));
        Assert.assertEquals(Assignment1.myMethod("blah", "ew"), Integer.valueOf(2));
        Assert.assertEquals(Assignment1.myMethod("e1", "e2"), Integer.valueOf(0));
    }





    @Test
    public void testStringFilterStreams() {
        // Assignment 3: test all cases of the method for filtering a string by length and first character
        Assignment3 filterStrings = new Assignment3();

        // test cases: empty string, 'a' but too short, 'a' but too long, 'A' but correct length, correct string, extras
        List<String> testOutput = filterStrings.getCorrectStrings(new ArrayList<>(Arrays.asList("", "a", "App", "adam", "app", "aAa")));
        List<String> correctOutput = new ArrayList<>(Arrays.asList("app", "aAa"));
        Assert.assertEquals(testOutput.size(), correctOutput.size());
        for (int i = 0; i < correctOutput.size(); i++)
            Assert.assertEquals(testOutput.get(i), correctOutput.get(i));
    }
}
