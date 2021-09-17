package JavaBasics4;

/**
 * @author aidan.mattson
 * Java Basics 4
 * Assignment 2: Create a deadlock between 2 threads
 */
public class Assignment2 extends Thread {

    volatile private static Integer extraValue = 10;

    synchronized public Integer addition(Integer a, Integer b) {

        return a+b+extraValue;
    }

    /**
     * create and deadlock the threads.
     */
    public static void main(String[] args) {
        Assignment2 thread1 = new Assignment2();
        Assignment2 thread2 = new Assignment2();

    }
}
