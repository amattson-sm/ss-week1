package JavaBasics4.Assignment4;

import org.junit.Test;
import org.junit.Assert;

/**
 * @author aidan.mattson
 * Java Basics 4
 * Assignment 4: Test all methods in Line.java
 */
public class LineTest {
    Line line1 = new Line(0, 0, 2, 3);
    Line line2 = new Line(0, 0, 5, 10);
    Line line3 = new Line(0, 0, 0, 1);
    Line line4 = new Line(5, 4, 11, 13);

    @Test
    public void testSlope() {
        // test normal slope get
        Assert.assertEquals(line1.getSlope(), 1.5, 0.001);
        Assert.assertEquals(line2.getSlope(), 2, 0.001);

        // test failed slope get
        Assert.assertThrows(ArithmeticException.class, () -> {
            line3.getSlope();
        });
    }

    @Test
    public void testDistance() {
        // test correct distance
        Assert.assertEquals(line1.getDistance(), Math.sqrt(13), 0.001);
        Assert.assertEquals(line2.getDistance(), Math.sqrt(125), 0.001);
    }

    @Test
    public void testParallel() {
        // test correct return values
        Assert.assertTrue(line1.parallelTo(line4));
        Assert.assertFalse(line1.parallelTo(line2));

        // test failed slope get
        Assert.assertThrows(ArithmeticException.class, () -> {
            line3.parallelTo(line4);
        });
    }
}
