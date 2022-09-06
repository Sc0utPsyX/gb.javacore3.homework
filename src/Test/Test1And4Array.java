import lesson6.ArrayHomework;
import lesson6.OneAndFourthArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test1And4Array {

    @Test
    public void testAdd(){
        Assertions.assertTrue(OneAndFourthArray.validCheck(new int[]{1, 1, 1, 1, 1, 4}));
    }
    @Test
    public void testAdd2(){
        Assertions.assertFalse(OneAndFourthArray.validCheck(new int[]{1, 1, 1, 1, 1}));
    }
    @Test
    public void testAdd3(){
        Assertions.assertTrue(OneAndFourthArray.validCheck(new int[]{1, 1, 4, 1, 1, 4}));
    }
    @Test
    public void testAdd4(){
        Assertions.assertFalse(OneAndFourthArray.validCheck(new int[]{1, 1, 1, 3, 1, 4}));
    }
    @Test
    public void testAdd5(){
        Assertions.assertFalse(OneAndFourthArray.validCheck(new int[]{28, 1, 1, 1, 1, 4}));
    }
    @Test
    public void testAdd6(){
        Assertions.assertTrue(OneAndFourthArray.validCheck(new int[]{4, 1, 1, 1, 1}));
    }
}
