

/**
 * INHERITANCE
 * When a child class is given access to the variables and methods in the parent class
 * extends keyword for classes, can only extend one class
 * implements keyword is for interfaces, can implement multiple interfaces.
 */


public class Segway extends Vehicle 
{
    private String battery;
    
    public Segway(String type, int numWheels, String battery) 
    {
        super(type, numWheels);
        this.battery = battery;
    }

    public Segway() 
    {
        super(); // calls the no-arg constructor of a parent
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    @Override
    public void drive() {
        // TODO Auto-generated method stub
        System.out.println(battery + " is used to drive");
        System.out.println();
    }

    public void start()
    {
        System.out.println("A button is pressed to start a the segway");
        System.out.println();
    }

    @Override
    public String toString() {
        return "Segway [battery=" + battery + ", getNumWheels()=" + getNumWheels() + "]";
    }
}
