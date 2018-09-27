package syncronous;

import java.util.ArrayList;

import static syncronous.CvKt.SIZE;

public class ThreadPerformanceTest {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        ArrayList<Thread> threads = new ArrayList<>(SIZE);

        for (int i = 0; i < SIZE; i++) {
            threads.add(new Thread(() -> {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print("+");

            }));
        }

        threads.forEach(thread -> {
            try {
                thread.join();
                thread.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("time millis: " + (System.currentTimeMillis() - start));
    }
}
