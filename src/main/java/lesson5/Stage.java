package lesson5;

import java.util.concurrent.CountDownLatch;

public abstract class Stage {
    protected int length;
    protected String description;
    public static CountDownLatch stageLatch;

    public String getDescription() {
        return description;
    }

    public abstract void go(Car c);
}
