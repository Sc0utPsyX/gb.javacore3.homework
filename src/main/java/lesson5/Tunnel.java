package lesson5;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    Semaphore semaphore = new Semaphore(MainClass.CARS_COUNT / 2); // ограничение на половину машин
    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                semaphore.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                semaphore.release();
                c.setWinLatch();
                stageLatch.countDown();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
