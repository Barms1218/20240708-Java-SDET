package Java.Day1.Collections;

import Java.Day1.FourPillars.Car;
import Java.Day1.FourPillars.Segway;
import Java.Day1.FourPillars.Vehicle;

public class ArrayPractice {
    public static void main(String[] args) {
        /**
         * ARRAYS store data in consecutive memory addresses access through each address
         * using indexes use square brackets to access an index
         */

        int[] numbers1 = { 1, 2, 3 }; // reach element creates a consecutive memory address
        int numbers2[] = new int[3]; // creates an array of 3 memory addresses with no values attached

        System.out.println(numbers1);
        System.out.println(numbers2);

        Vehicle[] vehicles = new Vehicle[2];
        vehicles[0] = new Car();
        vehicles[1] = new Segway();

        System.out.println("FOR LOOP");
        for (int i = 0; i < 3; i++) {
            // numbers2[i] = numbers1[i];

            System.out.println("\t" + numbers2[i]);
        }

        System.out.println("FOREACH LOOP");
        for (int x : numbers1) {
            System.out.println("\t" + x);
        }

        System.out.println("WHILE LOOP");
        int i = 2;
        while (i >= 0) {
            System.out.println("\t" + numbers2[i]);

            i--;
        }

        System.out.println("DO-WHILE LOOP");
        int j = 2;
        do {
            System.out.println("\t" + numbers2[j]);
            j--;
        }
        while (j >= 0);
    }
}
