package ro.itschool.project.utils.multithreading.executors;

import java.util.concurrent.Callable;

public class CallableExample {

    public static void main(String[] args) throws Exception {
        Callable<String> callableTask = () -> {
            System.out.println("Executing on thread: " + Thread.currentThread().getName());
            return "Task was executed";
        };
        callableTask.call();
    }
}