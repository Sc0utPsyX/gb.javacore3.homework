package lesson5;

import javax.management.MBeanAttributeInfo;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.*;


public class Car implements Runnable {
    private static int CARS_COUNT;
    private static AtomicBoolean win = new AtomicBoolean(true);

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;

    private int winLatch;

    public void setWinLatch() {
        this.winLatch++;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
    public static CyclicBarrier cyclicBarrier = new CyclicBarrier(MainClass.CARS_COUNT);


    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.winLatch = 0;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            cyclicBarrier.await();
            System.out.println(this.name + " готов");
            MainClass.countDownLatch.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        while (win.get()){
            if (this.winLatch == race.getStages().size()) {
                win.set(false);
                System.out.printf("%s победил\n", this.name);
            }
        }
    }
}
