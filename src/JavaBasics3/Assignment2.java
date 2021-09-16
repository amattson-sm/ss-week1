package JavaBasics3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author aidan.mattson
 * Java Basics 3
 * Assignment 2: Append text to a file
 */
public class Assignment2 {

    /**
     * function to get write path and message from the user
     */
    public void append() {
        System.out.print("Please enter a file to append to: \n - ");
        Scanner scan = new Scanner(System.in);
        String path = scan.nextLine();
        scan.close();
        append(path);
    }

    /**
     * function to get only the message from user
     * @param path path to write to
     */
    public void append(String path) {
        System.out.print("Please enter a message to append: \n - ");
        Scanner scan = new Scanner(System.in);
        String message = scan.nextLine();
        scan.close();
        append(path, message);
    }

    /**
     * function to perform the text append
     * @param path path of the file to write to
     * @param message message to append to the file
     */
    public void append(String path, String message) {
        try (FileOutputStream fos = new FileOutputStream(path, true)) {
            fos.write(message.getBytes());
            System.out.println("Appended '" + message + "' to file at: " + path);
        } catch (IOException e) {
            System.out.println("Unable to write to the path specified.");
        }
    }

    /**
     * Create and start the program
     */
    public static void main(String[] args) {
        //appender methods - can be called individually, or function as a cascading infograb
        Assignment2 appender = new Assignment2();

        // append method accepting user input for both file and message
        appender.append();

        // append method accepting user input for message only
        //appender.append("resources/append.txt");

        // append method accepting a normalized string
        //appender.append("resources/append.txt", "ProjectileWordVomit");
    }
}
