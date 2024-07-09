package Java.Day2.DesignPatterns.ProducerConsumer;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ProducerConsumer {

    /**
     * PRODUCER CONSUMER
     * 
     * One entity produces data while another consumes the data. Producing can be
     * generating, recieving and reading
     * 
     * The producer is usually a thread and the consumer is usually a thread.
     * Consuming is processing, managing and manipulating.
     * 
     * Used in multithreading in Java.
     * 
     */

    /**
     * CONCURRENT COLLECTIONS
     * 
     * java.util.concurrent
     * 
     * thread safe collections - they will handle synchronization for us.
     * 
     * @param args
     */

    public static void main(String[] args) {
        final Queue<Integer> buffer = new ConcurrentLinkedQueue<>();
        final int CAPACITY = 5;

        Thread producThread = new Thread(new Runnable() {

            /**
             * ANONYMOUS INNER CLASS -> A class that isn't declared or defined -> only
             * created with functional interfaces.
             * 
             */

            @Override
            public void run() {
                int value = 0;

                // Simulating grabbing values from somewhere and putting them in the queue
                while (true) {
                    if (buffer.size() < CAPACITY) {
                        System.out.println("Producer produces: " + value);
                        buffer.add(value++);
                    }
                }
            }
        });

        /**
         * LAMBDA FUNCTIONS -> Shorthand way to implement the method of a functional
         * interface
         */

        /*
         * THIS IS THE RUN METHOD
         */
        Thread consumerThread = new Thread((/* Any parameter for the method */) -> {
            while (true) {
                if (!buffer.isEmpty()) {
                    int value = buffer.poll(); // retrieves the value from the front of the queue and removes it
                    System.out.println("Consumer consumes: " + value);
                }
            }
        });

        producThread.start();
        consumerThread.start();

    }
}
