package Java.Day2.MultiThreading;

public class MultiThreadingIntro {
    /*
     * MULTI-THREADING
     * 
     * Splitting different tasks into multiple threads to be done concurrently.
     * Default we have a single main thread
     * 
     * Sacrifices performance speed or power usage
     * 
     *  Thread States
     * - NEW - Created but not started (new Thread())
     * - RUNNABLE - Thread has started (thread.start())
     * - BLOCKED - thread is waiting on some lock before continuing
     * - WAITING - thread waiting indefinitely (thread.join() or thread.wait())
     * - TIMED-WAITING - thread waiting for a specified amount of time (thread.join(3000))
     * - TERMINATED - thread is finished.
     * 
     */

    public static void main(String[] args) {

        RunnableTask task1 = new RunnableTask("task1");
        RunnableTask task2 = new RunnableTask("task2");
        RunnableTask task3 = new RunnableTask("task3");

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

/*
 * RUNNABLE INTERFACE
 * A functional interface for defining how a thread will run
 *      A functional interface is just an interface with one method
 * 
 * Why would you want to use the Runnable Interface over the Thread Class?
 *      Runnable interface allows you to implement multiple and extend any other class
 */

class RunnableTask implements Runnable {
    private String taskName;

    public RunnableTask(String taskname) {
        this.taskName = taskname;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskName + " is running in the Thread " + Thread.currentThread().getName());

        try {
            Thread.sleep(2000);
            System.out.println(taskName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
