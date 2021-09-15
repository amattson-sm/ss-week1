package JavaBasics2.Assignment3;

/**
 * @author aidan.mattson
 * Java Basics 2
 * Assignment 3: Create a shape interface and some shapes
 */
public class Main {
    public static void main(String[] args) {
        // Create sample shapes
        Rectangle rect = new Rectangle(17d, 7d);
        Circle circ = new Circle(6d);
        Triangle tri = new Triangle(4d, 6d);
        Rectangle nullCatch = new Rectangle(null, 5d);

        // Run calculations
        System.out.println("\n - calculateArea()");
        System.out.println("Rectangle area: " + rect.calculateArea());
        System.out.println("Circle area: " + circ.calculateArea());
        System.out.println("Triangle area: " + tri.calculateArea());
        System.out.println("Rectangle area: " + nullCatch.calculateArea());

        // Display results
        System.out.println("\n - display()");
        rect.display();
        circ.display();
        tri.display();
        nullCatch.display();
    }
}
