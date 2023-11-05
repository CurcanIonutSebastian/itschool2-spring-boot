package ro.itschool.project.utils.multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            executorService.execute(() -> System.out.println("Executing task " + taskId + " on thread " + Thread.currentThread().getName()));
        }
        executorService.shutdown();
    }
}