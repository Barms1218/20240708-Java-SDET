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

        List<Laundry> laundryToDo = new ArrayList<>(3);
        laundryToDo.add(new Laundry("whites", "dirty"));
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
}

/*
 * The laundry object that the machines use
 */
class Laundry {
    String type;
    String status;

    public Laundry() {
    }

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

/*
 * The washer
 */
class WashingMachine implements Runnable {

    Laundry currentLoad;

    public WashingMachine(Laundry currentLoad) {
        this.currentLoad = currentLoad;
    }

    @Override
    public void run() {
        // Loop until the current load has been set to clean
        while (!currentLoad.getStatus().equals("dirty")) {
            try {
                Thread.sleep(1000);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        // will lock the washer
        DoingLaundry.washerLock.lock();
        System.out.println("The washer has started: " + currentLoad.getStatus());

        try {
            Thread.sleep(2000);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        System.out.println("The washer has finished: " + currentLoad.getType());
        currentLoad.setStatus("washed");

        DoingLaundry.washerLock.unlock();
    }
}

class Dryer implements Runnable {

    Laundry currentLoad;

    public Dryer(Laundry currentLoad) {
        this.currentLoad = currentLoad;
    }

    @Override
    public void run() {
        // Loop until the current load has been set to clean
        while (!currentLoad.getStatus().equals("washed")) {
            try {
                Thread.sleep(3000);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        System.out.println("The dryer has started: " + currentLoad.getType());

        // will lock the dryer
        DoingLaundry.dryerLock.lock();

        try {
            Thread.sleep(5000);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        System.out.println("The dryer has finished: " + currentLoad.getType());
        currentLoad.setStatus("dry");

        // Unlock dryer so others can use it
        DoingLaundry.dryerLock.unlock();
    }

}

class FoldingMachine implements Runnable {

    Laundry currentLoad;

    public FoldingMachine(Laundry currentLoad) {
        this.currentLoad = currentLoad;
    }

    public void run() {

        // Loop until the current load has been set to clean
        while (!currentLoad.getStatus().equals("dry")) {
            try {
                Thread.sleep(7000);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        System.out.println("The folding machine has started: " + currentLoad.getType());

        // will lock the folding machine
        DoingLaundry.folderLock.lock();

        try {
            Thread.sleep(9000);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        System.out.println("The folding machine has finished: " + currentLoad.getType());
        currentLoad.setStatus("folded");

        // Unlocked folder so others can use it
        DoingLaundry.folderLock.unlock();
    }

}
