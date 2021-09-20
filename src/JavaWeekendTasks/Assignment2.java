package JavaWeekendTasks;

import java.util.Arrays;
import java.util.List;

/**
 * @author aidan.mattson
 * Java Weekend 1
 * Part 2: Use Java 8 features to modify a list of integers into a string
 */
public class Assignment2 {

    /**
     * Use Java 8 features to get a formatted string form an array of Integers
     * @param input list of integers to convert
     * @return a string containing desired output
     */
    public String getValues(List<Integer> input) {
        // Java 8 features: conversion is done in a stream with a lambda
        StringBuilder base = new StringBuilder();
        input.stream().forEach((val) -> {
            if (val % 2 == 0) base.append('e');
            else base.append('o');
            base.append(val).append(',');
        });
        if (input.size() > 0) base.deleteCharAt(base.length() - 1);
        return base.toString();
    }

    public static void main(String[] args) {
        Assignment2 converter = new Assignment2();
        System.out.println(converter.getValues(Arrays.asList(1, 2, 3, 4, 10, 60, -50, 0)));
    }
}
