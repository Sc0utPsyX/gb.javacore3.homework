import java.util.ArrayList;

public class Box<T extends Fruit>{
    private ArrayList<T> box;

    public Box(ArrayList<T> box) {
        this.box = box;
    }

    public void addFruitToBox(T fruit){
        box.add(fruit);
    }

    public float getWeight(){
        float weight = 0;
        for (T fruit : box) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<? extends Fruit> comparedBox){
        return Math.abs(this.getWeight() - comparedBox.getWeight()) < 0.0001;
    }

    public void pourIntoBox(Box<T> box){
        for (T fruit : this.box) {
            box.addFruitToBox(fruit);
        }
        this.box.clear();
    }
}