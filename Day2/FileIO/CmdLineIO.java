package Java.Day2.FileIO;

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

        System.out.println(response);
    }
}
