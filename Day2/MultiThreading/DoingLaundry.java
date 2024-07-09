package Java.Day2.MultiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DoingLaundry {

    public static Lock washerLock = new ReentrantLock();
    public static Lock dryerLock = new ReentrantLock();
    public static Lock folderLock = new ReentrantLock();

    public static void main(String[] args) {
        ArrayList<Laundry> laundryToDo = new ArrayList<>(3);
        laundryToDo.add(new Laundry("white", "dirty"));
        laundryToDo.add(new Laundry("delicates", "dirty"));
        laundryToDo.add(new Laundry("bedding", "dirty"));

        Thread washer;
        Thread dryer;
        Thread folder;

        for (Laundry laundry : laundryToDo) {
            washer = new Thread(new WashingMachine(laundry));
            dryer = new Thread(new Dryer(laundry));
            folder = new Thread(new FoldingMachine(laundry));

            washer.start();
            dryer.start();
            folder.start();
        }
    }

    class Laundry {
        String type;
        String status;

        public Laundry(String type, String status) {
            this.type = type;
            this.status = status;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    class WashingMachine implements Runnable {

        Laundry currentLoad;

        public WashingMachine(Laundry currentLoad) {
            this.currentLoad = currentLoad;
        }

        public void run() {
            // Loop until the current load has been set to clean
            while (!currentLoad.getStatus().equals("clean")) {
                try {
                    Thread.sleep(1000);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }

            // will lock the washer
            System.out.println("The washer has started: " + currentLoad.getStatus());
            washerLock.lock();

            try {
                Thread.sleep(2000);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

            System.out.println("The washer has finished: " + currentLoad.getType());
            currentLoad.setStatus("washed");

            washerLock.unlock();
        }
    }

    class Dryer implements Runnable {

        Laundry currentLoad;

        public Dryer(Laundry currentLoad) {
            this.currentLoad = currentLoad;
        }

        public void run() {
            // Loop until the current load has been set to clean
            while (!currentLoad.getStatus().equals("dry")) {
                try {
                    Thread.sleep(3000);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }

            System.out.println("The dryer has started: " + currentLoad.getType());

            // will lock the dryer
            dryerLock.lock();

            try {
                Thread.sleep(5000);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

            System.out.println("The dryer has finished: " + currentLoad.getType());
            dryerLock.unlock();
        }

    }

    class FoldingMachine implements Runnable {

        Laundry currentLoad;

        public FoldingMachine(Laundry currentLoad) {
            this.currentLoad = currentLoad;
        }

        public void run() {

            // Loop until the current load has been set to clean
            while (!currentLoad.getStatus().equals("folded")) {
                try {
                    Thread.sleep(7000);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }

            System.out.println("The folding machine has started: " + currentLoad.getType());

            // will lock the folding machine
            folderLock.lock();

            try {
                Thread.sleep(9000);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

            System.out.println("The folding machine has finished: " + currentLoad.getType());
            folderLock.unlock();
        }

    }
}
