import lesson6.ArrayHomework;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class TestArray {

    @Test
    public void testAdd(){
        int[] array = new int[]{1, 7};
        Assertions.assertArrayEquals(array, ArrayHomework.arrayAfter4(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}));
    }
    @Test
    public void testAdd2(){
        int[] array = new int[]{5, 2, 3, 9, 1, 7};
        Assertions.assertArrayEquals(array, ArrayHomework.arrayAfter4(new int[]{1, 7, 4, 5, 2, 3, 9, 1, 7}));
    }
    @Test
    public void testAdd3(){
        int[] array = new int[]{3, 1, 7, 17, 12, 22};
        Assertions.assertArrayEquals(array, ArrayHomework.arrayAfter4(new int[]{4, 1, 17, 4, 3, 1, 7, 17, 12, 22}));
    }
    @Test
    public void testAdd4(){
        int[] array = new int[]{22, 14, 54, 23, 32, 42, 13, 71};
        Assertions.assertArrayEquals(array, ArrayHomework.arrayAfter4(new int[]{4, 22, 14, 54, 23, 32, 42, 13, 71}));
    }
    @Test
    public void testAdd5(){
        int[] array = new int[0];
        try{
            Assertions.assertArrayEquals(array, ArrayHomework.arrayAfter4(new int[]{22, 14, 54, 23, 32, 42, 13, 71}));
        }catch (RuntimeException e){
            Assertions.assertTrue(true);
        }
    }

}
