package JavaBasics2.Assignment3;

public class Rectangle implements Shape{

    // shape vars
    private final Double width, height;

    /**
     * Set the initial dimensions of the rectangle
     * @param width width of the rectangle
     * @param height height of the rectangle
     */
    Rectangle(Double width, Double height) {
        this.width = width;
        this.height = height;
    }

    /**
     * calculate and save the area of the shape
     * @return value of the area
     */
    public Double calculateArea() {
        try {
            return height * width;
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
            System.out.println("Unable to calculate Rectangle area using \'" + width + "\' and \'" + height + "\'");
        else {
            System.out.print("Area of Rectangle: ");
            System.out.println(width + " * " + height + " = " + area);
        }
    }
}
