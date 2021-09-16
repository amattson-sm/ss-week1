package JavaBasics3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author aidan.mattson
 * Java Basics 3
 * Assignment 3: Count instances of a character in a file
 */
public class Assignment3 {

    /**
     * function to scan the specified file for a given character
     * @param path path to the file to read
     * @param c character to count iterations of
     */
    public void scan(String path, Character c) {
        int count = 0;
        try (BufferedReader bufRead = new BufferedReader(new FileReader(path))) {
            while (bufRead.ready()) {
                if (c.equals((char) bufRead.read()))
                    count++;
            }
            System.out.println("Total of char '" + c + "' found: " + count);
        } catch (IOException e) {
            System.out.println("Unable to open '" + path + "' for reading.");
        }
    }

    /**
     * create and initialize the program
     */
    public static void main(String[] args) {
        Assignment3 counter = new Assignment3();
        //counter.scan("resources/append.txt", 'S');

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a path to a file to read:\n - ");
        String path = in.nextLine();
        System.out.print("Enter a character to count (uses first character):\n - ");
        StringBuilder search = new StringBuilder(in.nextLine());
        in.close();

        counter.scan(path, search.charAt(0));
    }
}
