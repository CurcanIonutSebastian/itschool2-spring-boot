package ro.itschool.project.utils.multithreading.executors;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorExample {

    public static void main(String[] args) throws InterruptedException {
        int threadCount = Runtime.getRuntime().availableProcessors();
        int loopIterations = 20;
        int partSile = loopIterations/threadCount;

        System.out.println("Available threads: " + threadCount);
        System.out.println("Part size: " + partSile);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3, //core pool size
                4, //maximum pool size
                50, //keep alive
                TimeUnit.MILLISECONDS, //units for keep alive propriety
                new ArrayBlockingQueue<>(16));

        long start = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            final int taskId = i;
            threadPoolExecutor.execute(() -> System.out.println("Executing task " + taskId + " on thread " + Thread.currentThread().getName()));
        }
        long end = System.currentTimeMillis();
        Thread.sleep(2000);
        System.out.println("Total time: " + (end - start));

        threadPoolExecutor.shutdown();
    }
}