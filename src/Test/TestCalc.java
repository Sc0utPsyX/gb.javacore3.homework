import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class TestCalc {
    Calculator calc = new Calculator();

    @Test
    public void testCalc(){
        Assertions.assertEquals(Float.parseFloat(new String("Hello!")), 1, 2);
    }
}
