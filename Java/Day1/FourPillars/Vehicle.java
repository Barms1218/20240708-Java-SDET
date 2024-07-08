


/**
 * ABSTRACTION
 *  -> a class that can have abstract methods
 * -> can NOT be initialized
 * -> uses a different keyword - extends
 */

public abstract class Vehicle implements Driveable // Abstract classes are exempt from implementing interfaces
{
    private String type;
    private int numWheels;

    // Constructors
    public Vehicle(String type, int numWheels) 
    {
        this.type = type;
        this.numWheels = numWheels;
    }

    public Vehicle() {
    }
    
    // Getters and Setters
    public String getType() 
    {
        return type;
    }

    public void setType(String type) 
    {
        this.type = type;
    }

    public int getNumWheels() 
    {
        return numWheels;
    }

    public void setNumWheels(int numWheels) 
    {

        if (numWheels >= 0) {
            this.numWheels = numWheels;
        }
    }

    public abstract void drive();
    public abstract void start();
}
