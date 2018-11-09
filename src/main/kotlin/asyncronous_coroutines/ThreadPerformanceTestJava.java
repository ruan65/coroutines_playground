package asyncronous_coroutines;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import static asyncronous_coroutines.CvKt.SIZE;
import static asyncronous_coroutines.CvKt.TIMEOUT;

public class ThreadPerformanceTestJava {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        ArrayList<Thread> threads = new ArrayList<>(SIZE);
        CountDownLatch latch = new CountDownLatch(SIZE);


        for (int i = 0; i < SIZE; i++) {
            threads.add(new Thread(() -> {
                try {
                    Thread.sleep(TIMEOUT);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print("+");
                latch.countDown();

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

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("time millis: " + (System.currentTimeMillis() - start));
    }
}
