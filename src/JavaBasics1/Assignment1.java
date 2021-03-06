package JavaBasics1;

/**
 * @author amattson-sm
 * Java Basics 1
 * Assignment 1: Print shapes using loops
 */
public class Assignment1 {

    /**
     * Print out the patterns
     *      I interpreted the numbering [ 1) etc... ] and the hyphens as separators, and not
     *      relevant to the code, so they are hardcoded between each problem.
     */
    public void startPrint() {
        // 1
        System.out.println("1)");
        for (int i = 1; i <= 4; i++) {
            // print asterisks
            for (int j = 0; j < i; j++)
                System.out.print("*");

            System.out.print("\n");
        }
        System.out.println("---------\n");

        // 2
        System.out.println("2)\n----------");
        for (int i = 4; i >= 1; i--) {
            // print asterisks
            for (int j = 0; j < i; j++)
                System.out.print("*");

            System.out.print("\n");
        }

        // 3
        System.out.println("\n3)");
        for (int i = 0; i < 4; i++) {
            //print spaces
            for (int j = 0; j < 5 - i; j++)
                System.out.print(" ");
            //print asterisks
            for (int j = 0; j < 1 + (2 * i); j++)
                System.out.print("*");

            System.out.print("\n");
        }
        System.out.println("-----------");

        // 4
        System.out.println("\n4)\n------------");
        for (int i = 0; i < 4; i++) {
            //print spaces
            for (int j = 0; j < 2 + i; j++)
                System.out.print(" ");
            //print asterisks
            for (int j = 0; j < 1 + (2 * (3 - i)); j++)
                System.out.print("*");

            System.out.print("\n");
        }
    }

    /**
     * Create and call the problem
     */
    public static void main(String[] args) {
        Assignment1 print = new Assignment1();
        print.startPrint();
    }
}
