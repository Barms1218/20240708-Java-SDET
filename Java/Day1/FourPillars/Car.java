

public class Car  extends Vehicle
{
    
    /**
     * ENCAPSULATION
     * 
     * Used for wrapping up related state and behavior into a single class
     * Then we can control how that state and ehavior is modified and accessed
     */


    /**
     * POLYMORPHISM
     * 
     * Means "many forms"
     * A way to help with code reusability
     * 
     */

    private String engine;
    private String make;
    private String model;

    public void setEngine(String engine) 
    {
        this.engine = engine;
    }

    public void setMake(String make) 
    {
        this.make = make;
    }

    public void setModel(String model) 
    {
        this.model = model;
    }

    public String getEngine() 
    {
        return engine;
    }

    public String getMake() 
    {
        return make;
    }

    public String getModel() 
    {
        return model;
    }

    @Override
    public String toString() {
        return "Car [engine=" + engine + ", make=" + make + ", model=" + model + "]";
    }

    // Constructor with no arguments
    public Car()
    {

    }

    // Constructor with parameters
    public Car(String engine, String make, String model)
    {
        this.engine = engine;
        this.make = make;
        this.model = model;
    }

    @Override
    public void drive()
    {
        System.out.println(engine + " is used to drive");
        System.out.println();
    }

    @Override
    public void start()
    {
        System.out.println("A key is used to start the car");
        System.out.println();
    }
}
