import org.junit.Test;
import static org.junit.Assert.*;

public class HorribleSteve {

    @Test
    public void testFlik(){
        int a = 1;
        int b = 1;
        assertTrue(Flik.isSameNumber(a, b));
    }

    public static void main(String [] args) {
        int i = 0;
        for (int j = 0; i < 500; ++i, ++j) {
            if (!Flik.isSameNumber(i, j)) {
                break; // break exits the for loop!
            }
        }
        System.out.println("i is " + i);
    }
}
