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
 * Java Basics 5
 * Tests for all Java Basics 5 classes
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
    public void testLambdaOdd() {
        // test the Lambda isOdd() function
        Lambdas Lambdas = new Lambdas();
        Assert.assertFalse(Lambdas.isOdd.mathTest(0));   // check 0
        Assert.assertTrue(Lambdas.isOdd.mathTest(1));    // check 1
        Assert.assertTrue(Lambdas.isOdd.mathTest(155));  // check large number
        Assert.assertFalse(Lambdas.isOdd.mathTest(-11)); // check negative number
    }

    @Test
    public void testLambdaPrime() {
        // test the Lambda isPrime() function
        Lambdas Lambdas = new Lambdas();
        Assert.assertTrue(Lambdas.isPrime.mathTest(2));    // check 2 (special case)
        Assert.assertTrue(Lambdas.isPrime.mathTest(5));    // check small prime
        Assert.assertTrue(Lambdas.isPrime.mathTest(101));  // check larger prime
        Assert.assertFalse(Lambdas.isPrime.mathTest(1));   // check 1 (special case)
        Assert.assertFalse(Lambdas.isPrime.mathTest(102)); // check not-a-prime
    }

    @Test
    public void testLambdaPalindrome() {
        // test the Lambda isPalindrome() function
        Lambdas Lambdas = new Lambdas();
        Assert.assertTrue(Lambdas.isPalindrome.mathTest(1221));   // check even-length palindrome
        Assert.assertTrue(Lambdas.isPalindrome.mathTest(1));      // check small palindrome
        Assert.assertTrue(Lambdas.isPalindrome.mathTest(12321));  // check odd-length palindrome
        Assert.assertFalse(Lambdas.isPalindrome.mathTest(1122));  // check not-a-palindrome
    }

    @Test
    public void testLambdaGetInput() {
        // test the Lambda getInput() function
        Lambdas Lambdas = new Lambdas();
        overrideInput("5\n1 5\n2 7\n3 51155115\n5 101\na b\n");
        List<Pair> inputPairs = Lambdas.getInput();
        List<Pair> testPairs = new ArrayList<>(Arrays.asList(new Pair(1, 5), new Pair(2, 7), new Pair(3, 51155115), new Pair(5, 101), new Pair(null, null)));
        Assert.assertEquals(testPairs.size(), inputPairs.size());
        // check each pair matches
        for (int i = 0; i < testPairs.size(); i++)
            Assert.assertEquals(testPairs.get(i), inputPairs.get(i));

        // System.in cleanup
        restoreInput();
    }

    @Test
    public void testLambdaRunTests() {
        // test the Lambda runTests() function
        Lambdas Lambdas = new Lambdas();
        overrideInput("5\n1 5\n2 7\n3 51155115\n5 101\na b\n");
        List<Pair> inputPairs = Lambdas.getInput();
        String testOutput = Lambdas.runTests(inputPairs);
        String correctOutput = "ODD\n" +
            "PRIME\n" +
            "PALINDROME\n" +
            "Cannot parse test case: 5\n" +
            "Cannot parse test case: null\n";
        Assert.assertEquals(testOutput, correctOutput);

        // System.in cleanup
        restoreInput();
    }

    @Test
    public void testFunctionalI() {
        // test Assignment 2: Functional assignment (return last digits)
        Assignment2 functional = new Assignment2();

        // test regular input
        List<Integer> testOutput = functional.modulo(new ArrayList<>(Arrays.asList(5, 0, 50, 10102, 59)));
        List<Integer> correctOutput = new ArrayList<>(Arrays.asList(5, 0, 0, 2, 9));
        Assert.assertEquals(testOutput.size(), correctOutput.size());
        for (int i = 0; i < testOutput.size(); i++)
            Assert.assertEquals(testOutput.get(i), correctOutput.get(i));

        // test problematic input
        Assert.assertThrows(AssertionError.class, () -> functional.modulo(new ArrayList<>(Arrays.asList(5, -1, 5004))));
    }

    @Test
    public void testFunctionalII() {
        // test Assignment 3: Functional Assignment (double all)
        Assignment3 functional = new Assignment3();

        // test input
        List<Integer> testOutput = functional.doubleAll(new ArrayList<>(Arrays.asList(4, 6, 0, -10, 40404)));
        List<Integer> correctOutput = new ArrayList<>(Arrays.asList(8, 12, 0, -20, 80808));
        Assert.assertEquals(testOutput.size(), correctOutput.size());
        for (int i = 0; i < testOutput.size(); i++)
            Assert.assertEquals(testOutput.get(i), correctOutput.get(i));
    }

    @Test
    public void testFunctionalIII() {
        // test Assignment 4: Functional Assignment (remove x's from strings)
        Assignment4 functional = new Assignment4();

        // test input
        List<String> testOutput = functional.removeX(new ArrayList<>(Arrays.asList("", "ab", "xabfsx", "xx", "axa")));
        List<String> correctOutput = new ArrayList<>(Arrays.asList("", "ab", "abfs", "", "aa"));
        Assert.assertEquals(testOutput.size(), correctOutput.size());
        for (int i = 0; i < testOutput.size(); i++)
            Assert.assertEquals(testOutput.get(i), correctOutput.get(i));
    }

    @Test
    public void testRecursiveCondenser() {
        // test Assignment 5: Recursive integer sums
        Assignment5 recursive = new Assignment5();

        // test the helper method for condensing and removing values
        Integer[] testOutput = recursive.condenseArray(new Integer[] { 6, 2, 2, 2, 1, 0, 0, 1, 1, -15, 5, 5 });
        Integer[] correctOutput = new Integer[] { 6, 6, 1, 2, -15, 10 };
        Assert.assertEquals(testOutput.length, correctOutput.length);
        for (int i = 0; i < testOutput.length; i++)
            Assert.assertEquals(testOutput[i], correctOutput[i]);
    }

    @Test
    public void testRecursiveGrouping() {
        // test Assignment 5: Recursive integer sums
        Assignment5 recursive = new Assignment5();

        // test the actual recursive method
        Integer[] testArr = new Integer[] { 6, 2, 2, 2, 1, 0, 0, 1, 1, -15, 5, 5 };
        Assert.assertTrue(recursive.groupSumClump(testArr, 14));  // test possible with positives
        Assert.assertFalse(recursive.groupSumClump(testArr, 5));  // test impossible with positives
        Assert.assertFalse(recursive.groupSumClump(testArr, 26)); // test impossible with positives (large)
        Assert.assertTrue(recursive.groupSumClump(testArr, -15)); // test possible with negatives (solo value)
        Assert.assertTrue(recursive.groupSumClump(testArr, -14)); // test possible with negatives (combined value)
    }
}
