package Java.Day2.DesignPatterns.Singleton;

public class SingletonMain {

    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        instance1.increment();
        instance1.increment();
        instance1.increment();
        instance1.decrement();
        instance2.increment();
        instance2.increment();
        instance2.decrement();
        instance2.decrement();

        System.out.println("Intance1 count: " + instance1.getCount());
        System.out.println("Intance2 count: " + instance2.getCount());
        
        System.out.println(instance1);
        System.out.println(instance2);
    }
}
