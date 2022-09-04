package lesson6;

import java.util.Arrays;

public class ArrayHomework {

    public static int[] arrayAfter4(int[] array){
        boolean readyToCopy = false;
        int lastFourth = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 4) {
                readyToCopy = true;
                lastFourth = i;
                break;
            }
        }
        if (!readyToCopy) {
            throw new RuntimeException();
        }
        return Arrays.copyOfRange(array, lastFourth + 1, array.length);
    }

}
