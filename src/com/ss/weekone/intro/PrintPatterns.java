package com.ss.weekone.intro;

/**
 * @author amattson-sm
 */
public class PrintPatterns {

    // setup
    private PrintPatterns() {
        // 1
        System.out.println("1)");
        for (int i = 1; i <= 4; i++) {
            // print asterisks
            for (int j = 0; j < i; j++)
                System.out.print("*");

            System.out.print("\n");
        }
        System.out.println("---------\n");

        //2
        System.out.println("2)\n----------");
        for (int i = 4; i >= 1; i--) {
            // print asterisks
            for (int j = 0; j < i; j++)
                System.out.print("*");

            System.out.print("\n");
        }

        //3
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

        //4
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

    public static void main(String[] args) {
        PrintPatterns print = new PrintPatterns();
    }
}
