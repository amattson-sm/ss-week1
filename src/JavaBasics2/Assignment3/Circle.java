package JavaBasics2.Assignment3;

public class Circle {

    // shape vars
    private final Double radius;

    /**
     * Set the initial dimensions of the circle
     * @param radius radius of the circle
     */
    Circle(Double radius) {
        this.radius = radius;
    }

    /**
     * calculate and save the area of the shape
     * @return value of the area
     */
    public Double calculateArea() {
        try {
            return Math.pow(radius, 2) * Math.PI;
        } catch (NullPointerException e) {
            return null;
        }
    }

    /**
     * Displays area or calculates if needed
     */
    public void display() {
        Double area = calculateArea();
        if (area == null)
            System.out.println("Unable to calculate Circle area using \'" + radius + "\'");
        else {
            System.out.print("Area of Circle: ");
            System.out.println("π * (" + radius + ")^2 = " + calculateArea());
        }
    }
}
