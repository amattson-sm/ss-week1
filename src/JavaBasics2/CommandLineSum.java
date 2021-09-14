package JavaBasics2;

/**
 * @author aidan.mattson
 * Java Basics 2
 * Assignment 1: Add runtime arguments together
 */
public class CommandLineSum {

    /**
     * Create and start problem
     */
    public static void main(String[] args) {
        float sum = 0.0f;
        for (String arg : args) {
            // test each command line argument for number compatibility
            try {
                sum += Float.parseFloat(arg);
            } catch (NumberFormatException e) {
                System.out.println("Argument \'" + arg +"\' is not a number. Skipping...");
            }
        }
        System.out.println("Sum of arguments: " + sum);
    }
}
