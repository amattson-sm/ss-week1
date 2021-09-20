package JavaWeekendTasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author aidan.mattson
 * Java Weekend 1
 * Part 3: Filter a list of Strings
 */
public class Assignment3 {

    // return a filtered version using a stream and a lambda
    public List<String> getCorrectStrings(List<String> input) {
        return input.stream().filter((String s) -> s.length() == 3 && s.charAt(0) == 'a').collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Assignment3 filter = new Assignment3();
        List<String> updatedList = filter.getCorrectStrings(new ArrayList<>(Arrays.asList("", "a", "App", "adam", "app", "aAa")));
        System.out.println(updatedList);
    }
}
