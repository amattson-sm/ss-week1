package JavaBasics2;

/**
 * @author aidan.mattson
 * Java Basics 2
 * Assignment 2: Max number in a 2D array and its position
 */
public class ArrayMaxPosition {

    /**
     * initialize array and trackers
     */
    Integer[][] nums;
    Integer largest;
    ArrayMaxPosition() {
        nums = new Integer[][]{ {5, 10, 15, 20}, {25, 60, 45, 70}, {2, 1, -99, 0} };
        largest = nums[0][0];
    }

    /**
     * scan all array indices and save the value/position of the largest.
     */
    public void findLargest() {
        int x = 0, y = 0;
        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < nums[0].length; j++)
                if (nums[i][j] > largest) {
                    largest = nums[i][j];
                    x = i; y = j;
                }
        System.out.println("Largest num: " + largest);
        System.out.println("Position in array: array["+x+"]["+y+"]");
    }

    /**
     * Create and start the problem
     */
    public static void main(String[] args) {
        ArrayMaxPosition arr = new ArrayMaxPosition();
        arr.findLargest();
    }
}
