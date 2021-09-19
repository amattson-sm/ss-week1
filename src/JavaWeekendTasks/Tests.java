package JavaWeekendTasks;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author aidan.mattson
 * Java Basics 5
 * Tests for all weekend assignments
 */
public class Tests {

    @Test
    public void testBasicLambdas() {
        // test all cases of the method for sorting 'e' first
        Assert.assertEquals(Assignment1.myMethod("e", "a"), Integer.valueOf(-2));
        Assert.assertEquals(Assignment1.myMethod("blah", "ew"), Integer.valueOf(2));
        Assert.assertEquals(Assignment1.myMethod("e1", "e2"), Integer.valueOf(0));
    }
}
