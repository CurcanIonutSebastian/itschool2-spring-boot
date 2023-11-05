package ro.itschool.project.utils.multithreading;

public class ThreadLifecycle extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("The tread is running and going to sleep for 2 seconds");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Threat was interrupted");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLifecycle thread = new ThreadLifecycle();
        System.out.println("Thread state after creation: " + thread.getState());
        thread.start();
        System.out.println("Thread state after was started: " + thread.getState());

        Thread.sleep(1000);
        System.out.println("Thread state while is on sleep: " + thread.getState());

        thread.join();
        System.out.println("Thread state after finishing: " + thread.getState());
    }
}