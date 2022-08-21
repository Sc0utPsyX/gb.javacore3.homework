import java.util.ArrayList;
import java.util.Arrays;

public class Homework {

    public static <T extends Fruit> void main(String[] args) {
        Integer[] intArr = {1,2,3,4};
        ArrayList intArrList = arrayToArrayList(intArr);
        Double[] doubleArr = {1.0, 2.0, 3.0, 4.0};
        ArrayList doubleArrList = arrayToArrayList(doubleArr);
        changeElements(doubleArr, 2, 1);
        changeElements(intArr, 1, 3);
        System.out.println(Arrays.toString(doubleArr));
        System.out.println(Arrays.toString(intArr));
        System.out.println(doubleArrList.toString());
        System.out.println(intArrList.toString());
        Box<Orange> orangeBox = new Box<>(new ArrayList<>());
        Box<Apple> appleBox = new Box<>(new ArrayList<>());
        Box<Orange> orangeBox2 = new Box<>(new ArrayList<>());
        orangeBox.addFruitToBox(new Orange());
        orangeBox.addFruitToBox(new Orange());
        orangeBox2.addFruitToBox(new Orange());
        orangeBox2.addFruitToBox(new Orange());
        appleBox.addFruitToBox(new Apple());
        appleBox.addFruitToBox(new Apple());
        appleBox.addFruitToBox(new Apple());
        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());
        System.out.println(orangeBox.compare(appleBox));
        orangeBox.pourIntoBox(orangeBox2);
        System.out.println(orangeBox.getWeight());
        System.out.println(orangeBox2.getWeight());
    }


    public static <T> ArrayList arrayToArrayList(T[] array){
        ArrayList<T> arrayList = new ArrayList<T>();
//        arrayList.addAll(Arrays.asList(array)); Тут простой вариант :)
        for (T arr: array) {
            arrayList.add(arr);
        }
        return arrayList;
    }

    public static <T> void changeElements(T[] arr, int startElement, int finalElement){
        T tmp = arr[startElement];
        arr[startElement] = arr[finalElement];
        arr[finalElement] = tmp;
    }

}