package Java.Day2.FileIO;

import java.io.PrintWriter;
import java.util.Scanner;

public class CmdLineIO {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Scanner scanner = new Scanner(System.in);

        /**
         * SCANNER all data has to stored into a variable Specifically a primitive type
         * or a string
         * 
         */

        System.out.println("Enter a string: ");

        String response = scanner.nextLine();

        System.out.println("You entered: " + response);

        System.out.println("Enter a number: ");
        double numInput = scanner.nextDouble();

        System.out.println("You entered: " + numInput);

        scanner.close(); // Close scanners to prevent memory leaks

        /**
         * PRINT WRITER Allows for better formatting for our print statements. Also
         * allows you to queue up several prints and flush them out at once.
         */

        String name = "Anthony";
        int age = 22;
        double height = 162.5;

        PrintWriter consoleOut = new PrintWriter(System.out);

        consoleOut.printf("%s is %d years old and is %.1f cm tall.\n", name, age, height);

        consoleOut.flush();

        consoleOut.print("This is a string.\n");
        consoleOut.append("This string is appended to the previous.");

        // Need to flush out printwriter buffer to be able to print to terminal
        consoleOut.flush();

        // close() will automatically invoke flush()
        consoleOut.close();
    }
}
