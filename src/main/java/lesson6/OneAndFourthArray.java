package lesson6;

public class OneAndFourthArray {

    public static boolean validCheck(int[] array){
        boolean one = false;
        boolean four = false;
        for (int i : array) {
            if (i == 1) {
                one = true;
            } else if (i == 4) {
                four = true;
            } else {
                return false;
            }
        }
        return one && four;
    }
}
