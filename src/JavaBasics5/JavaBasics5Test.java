package JavaBasics5;

import JavaBasics5.Assignment1.Lambdas;
import JavaBasics5.Assignment1.Pair;
import org.junit.Test;
import org.junit.Assert;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.System;

/**
 * @author aidan.mattson
 * Java Basics 4
 * Assignment 4: Test all methods in Line.java
 */
public class JavaBasics5Test {
    InputStream sysInBack = System.in;

    // used to override System.in with some other value for testing user input
    private void overrideInput(String in) {
        ByteArrayInputStream newInput = new ByteArrayInputStream(in.getBytes());
        System.setIn(newInput);
    }

    // used to restore System.in to its proper state
    private void restoreInput() {
        System.setIn(sysInBack);
    }

    @Test
    public void testLambdas() {
        Lambdas Lambdas = new Lambdas();

        // test isOdd
        Assert.assertFalse(Lambdas.isOdd.mathTest(0));   // check 0
        Assert.assertTrue(Lambdas.isOdd.mathTest(1));    // check 1
        Assert.assertTrue(Lambdas.isOdd.mathTest(155));  // check large number
        Assert.assertFalse(Lambdas.isOdd.mathTest(-11)); // check negative number

        // test isPrime
        Assert.assertTrue(Lambdas.isPrime.mathTest(2));    // check 2 (special case)
        Assert.assertTrue(Lambdas.isPrime.mathTest(5));    // check small prime
        Assert.assertTrue(Lambdas.isPrime.mathTest(101));  // check larger prime
        Assert.assertFalse(Lambdas.isPrime.mathTest(1));   // check 1 (special case)
        Assert.assertFalse(Lambdas.isPrime.mathTest(102)); // check not-a-prime

        // test isPalindrome
        Assert.assertTrue(Lambdas.isPalindrome.mathTest(1221));   // check even-length palindrome
        Assert.assertTrue(Lambdas.isPalindrome.mathTest(1));      // check small palindrome
        Assert.assertTrue(Lambdas.isPalindrome.mathTest(12321));  // check odd-length palindrome
        Assert.assertFalse(Lambdas.isPalindrome.mathTest(1122));  // check not-a-palindrome

        // test inputGrabber
        overrideInput("5\n1 5\n2 7\n3 51155115\n5 101\na b\n");
        List<Pair> inputPairs = Lambdas.getInput();
        List<Pair> testPairs = new ArrayList<>(Arrays.asList(new Pair(1, 5), new Pair(2, 7), new Pair(3, 51155115), new Pair(5, 101), new Pair(null, null)));
        Assert.assertEquals(testPairs.size(), inputPairs.size());
        // check each pair matches
        for (int i = 0; i < testPairs.size(); i++)
            Assert.assertEquals(testPairs.get(i), inputPairs.get(i));

        // test running the lambdas for results
        String testOutput = Lambdas.runTests(inputPairs);
        String correctOutput = "ODD\n" +
            "PRIME\n" +
            "PALINDROME\n" +
            "Cannot parse test case: 5\n" +
            "Cannot parse test case: null\n";
        Assert.assertEquals(testOutput, correctOutput);

        // cleanup
        restoreInput();
    }


}
