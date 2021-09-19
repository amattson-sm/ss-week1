package JavaBasics5.Assignment6;

/** don't need some import statements (currently) **/
import java.sql.Connection;

/** remove static keyword from class definition **/
public class SampleSingleton {

    /** conn shouldn't be static **/
    private Connection conn = null;

    private static SampleSingleton instance = null;

    /** add a base private constructor **/
    private SampleSingleton() {}

    public static SampleSingleton getInstance() {
        /** add a call to create an instance **/
        if (instance == null) instance = new SampleSingleton();

        return instance;
    }

    /** sample main function creating a singleton **/
    public static void main(String[] args) {
        SampleSingleton sample = SampleSingleton.getInstance();
    }
}
