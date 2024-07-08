


// Packages wrap up your project and the scope of certain classes

public class FourPillarsMain
{
    // Main is the entry point of your code
    public static void main(String[] args)
    {
        // Print out to the commmand line
        System.out.println("Hello World!");
        

        /**
         * 
         * POLYMORPHISM
         * Covariance allows a child class to act in place of a parent class
         */
        
        Vehicle car = new Car("four-cylinder", "Toyota", "Tacoma");
         
        //print out our car using the overriden toString() method
        System.out.println(car.toString());
        car.start();
        car.drive();

        Vehicle segway = new Segway("segway", 2, "lithium-ion");

        System.out.println(segway.toString());
    }
}