package JavaBasics5.Assignment1;

// basic Integer pair class that can be compared with .equals safely when containing null values
public class Pair {
    public Pair(Integer n1, Integer n2) {
        num1 = n1;
        num2 = n2;
    }
    public Integer num1;
    public Integer num2;

    // change comparables
    @Override
    public boolean equals(Object o) {
        if (getClass() != o.getClass()) return false;
        Pair other = (Pair) o;

        // null pairs are always null for both values, so if both contain a null, return true
        if (this.num1 == null && other.num1 == null) return Boolean.TRUE;
        return this.num1.equals(other.num1) && this.num2.equals(other.num2);
    }
}
