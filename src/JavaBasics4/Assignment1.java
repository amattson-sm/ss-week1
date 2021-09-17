package JavaBasics4;

/**
 * @author aidan.mattson
 * Java Basics 4
 * Assignment 1: Create a singleton with double-checking
 */
public class Assignment1 {

    // singleton vars
    private static volatile Assignment1 inst = null;
    public Integer testVar = null;

    /**
     * Perform on-creation checking
     */
    private Assignment1() {}

    /**
     * generate single instance for creation
     */
    public static Assignment1 getInstance() {
        // check before synchronization
        if (inst == null)
            synchronized (Assignment1 .class) {
                // check after synchronization (double lock)
                if (inst == null)
                    inst = new Assignment1();
            }
        return inst;
    }

    /**
     * testing variable changes
     */
    public void setTestVar(Integer set) {
        testVar = set;
    }

    /**
     * create and implement the singleton class.
     */
    public static void main(String[] args) {
        Assignment1 singleton1 = Assignment1.getInstance();
        Assignment1 singleton2 = Assignment1.getInstance();

        if (singleton1 == singleton2)
            System.out.println("\n== test: The two classes are identical.");

        System.out.println("\nBefore changing singleton1 value: \n singleton1.testVar = " + singleton1.testVar + "\n singleton2.testVar: " + singleton2.testVar);
        singleton1.setTestVar(5);
        System.out.println("\nAfter changing singleton1 value: \n singleton1.testVar = " + singleton1.testVar + "\n singleton2.testVar: " + singleton2.testVar);
    }
}
