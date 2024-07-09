package Java.Day2.DesignPatterns.Singleton;

public class Singleton {
    /**
     * SINGLETON When you only want ONE instance of an object. Useful for when
     * working with threads - every thread will be using the same object
     * 
     * EAGER vs LAZY LOADING
     * 
     * Eager - Instantiate an object as soon as possible
     * 
     * - Can result in unnecessary memory allocation
     * 
     * Lazy - Only instantiate the object when it is asked for.
     */

    private static Singleton instance; // This is an object;
    private static Singleton ins = new Singleton();

    private int count = 0;

    public Singleton() {

    }

    public static Singleton getInstance() {

        // lazy loading
        // if (instance == null) {
        // instance = new Singleton();
        // }

        return ins;
    }

    public void increment() {
        this.count++;
    }

    public void decrement() {
        this.count--;
    }

    public int getCount() {
        return this.count;
    }
}
