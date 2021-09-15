package JavaBasics2.Assignment3;

public class Triangle {

    // shape vars
    private final Double base, height;

    /**
     * Set the initial dimensions of the triangle
     * @param base base of the triangle
     * @param height height of the triangle
     */
    Triangle(Double base, Double height) {
        this.base = base;
        this.height = height;
    }

    /**
     * calculate and save the area of the shape
     * @return value of the area
     */
    public Double calculateArea() {
        try {
            return (height * base) / 2;
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
            System.out.println("Unable to calculate Triangle area using \'" + base + "\' and \'" + height + "\'");
        else {
            System.out.print("Area of Triangle: ");
            System.out.println("(" + base + " * " + height + ") / 2 = " + calculateArea());
        }
    }
}
