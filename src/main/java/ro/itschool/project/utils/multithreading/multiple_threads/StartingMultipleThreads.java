package ro.itschool.project.utils.multithreading.multiple_threads;

public class StartingMultipleThreads implements Runnable {

    private String name;

    public StartingMultipleThreads(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " is running");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new StartingMultipleThreads("Thread 1"));
        Thread thread2 = new Thread(new StartingMultipleThreads("Thread 2"));

        thread1.start();
        thread2.start();
    }
}