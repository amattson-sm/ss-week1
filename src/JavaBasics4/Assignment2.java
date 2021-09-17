package JavaBasics4;

/**
 * @author aidan.mattson
 * Java Basics 4
 * Assignment 2: Create a deadlock between 2 threads
 */
public class Assignment2 {

    /**
     * create and deadlock the threads.
     */
    public static void main(String[] args) {
        Boolean fileAccess = true;
        final Boolean[] finishedWriting = {false};

        // first thread
        Runnable writeThread = () -> {
            System.out.println("Writing some stuff...");
            try {
                Thread.sleep(1000);
                synchronized (fileAccess) {
                    finishedWriting[0] = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        // second thread;
        Runnable saveThread = () -> {
            synchronized (fileAccess) {
                while (!finishedWriting[0]) {}
                System.out.println("Finished writing.");
            }
        };

        // write thread tries to write and then save
        new Thread(writeThread).start();
        // save thread foolishly waits for its (synchronized) variable to change
        new Thread(saveThread).start();
    }
}
