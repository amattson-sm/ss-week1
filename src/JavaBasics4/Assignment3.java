package JavaBasics4;

import java.util.Random;
import java.util.Stack;

/**
 * @author aidan.mattson
 * Java Basics 4
 * Assignment 3: Create a deadlock between 2 threads
 */
public class Assignment3 {


    public static void main(String[] args) {

        // buffer
        Stack<Integer> buffer = new Stack<>();
        final Boolean[] finishedProduction = { false };

        // consumer object
        Runnable consumer = () -> {
            while (Boolean.TRUE) {
                synchronized (buffer) {
                    synchronized (finishedProduction) {
                        if (finishedProduction[0] && buffer.empty())
                            break;
                    }
                    if (!buffer.empty()) {
                        Integer get = buffer.pop();
                        System.out.println("Consumer: Consumed " + get);
                    } else
                        System.out.println("Consumer: Nothing to Consume.");
                }
            }
            System.out.println("Consumer: Finished consuming.");
        };

        // producer object
        Runnable producer = () -> {
            Random r = new Random();
            for (int i = 0; i < 100; i++) {
                Integer rand = Math.abs(r.ints(1).findFirst().getAsInt() % 101);
                synchronized (buffer) {
                    buffer.push(rand);
                    System.out.println("Producer: Produced " + rand);
                }
            }
            // after finished with production, mark as done
            synchronized (finishedProduction) {
                System.out.println("Producer: Finished Production.");
                finishedProduction[0] = true;
            }
        };

        new Thread(consumer).start();
        new Thread(producer).start();
    }
}
