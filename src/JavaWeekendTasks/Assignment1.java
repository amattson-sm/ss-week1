package JavaWeekendTasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author aidan.mattson
 * Java Weekend 1
 * Part 1: Sort string array with lambdas
 */
public class Assignment1 {

    /**
     * personal method to sort by strings containing 'e'
     * @param s1 string to compare (1)
     * @param s2 string to compare (2)
     * @return comparable value relating the two strings
     */
    public static Integer myMethod(String s1, String s2) {
        // 0 for same, -2 for s1 has e but not s2, 2 for s2 has e but not s1
        Integer[] first = new Integer[2];
        first[0] = s1.charAt(0) == 'e' ? -1 : 1;
        first[1] = s2.charAt(0) == 'e' ? -1 : 1;
        return first[0] - first[1];
    }

    public static void main(String[] args) {
        // array capable of testing all cases
        String[] basicStrings = new String[] { "one", "two", "elf", "eels", "oak", "other", "ap", "e" };

        // sort by length
        //   using line suggested by IDE, original code here:
        //   - Arrays.sort(basicStrings, (String s1, String s2) -> s1.length() - s2.length());
        Arrays.sort(basicStrings, Comparator.comparingInt(String::length));
        System.out.println("Length: " + Arrays.asList(basicStrings));

        // sort by reversed length
        Arrays.sort(basicStrings, Comparator.comparingInt(String::length).reversed());
        System.out.println("Reversed Length: " + Arrays.asList(basicStrings));

        // sort alphabetically by first character
        Arrays.sort(basicStrings, Comparator.comparingInt((String s) -> s.charAt(0)));
        System.out.println("First Character: " + Arrays.asList(basicStrings));

        // sort with 'e' first
        Arrays.sort(basicStrings, (String s1, String s2) -> {
            Integer[] first = new Integer[2];
            first[0] = s1.charAt(0) == 'e' ? -1 : 1;
            first[1] = s2.charAt(0) == 'e' ? -1 : 1;
            return first[0] - first[1];
        });
        System.out.println("'e' First pt1: " + Arrays.asList(basicStrings));

        // sort with 'e' first but formatted differently
        Arrays.sort(basicStrings, Assignment1::myMethod);
        System.out.println("'e' First pt2: " + Arrays.asList(basicStrings));
    }
}
