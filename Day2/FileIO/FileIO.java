package Java.Day2.FileIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileIO {
    public static void main(String[] args) {
        // Relative path used whenever you are within the same project
        String inputFile = "20240708-Java-SDET\\Java\\Day2\\FileIO\\fileInput.txt";
        String outputFile = "20240708-Java-SDET\\Java\\Day2\\FileIO\\fileOutput.txt";

        // Full Path - Used whenever you're not within the same project
        String inputFilePath = "C:\\Users\\brand\\Documents\\SkillStorm Coursework\\20240708-Java-SDET\\Java\\Day2\\FileIO\\fileInput.txt";

        /**
         * TRY-CATCH Put risky code in try block, handle errors in the catch block. Can
         * only catch one at a time, but can do multiple catch blocks. Put most specific
         * exception first
         */

        try {
            /**
             * FILE INPUT and OUTPUT STREAMS have to work with streams to have your data
             * flow between files
             * 
             */

            InputStream inputStream = new FileInputStream(inputFile); // creates a new input stream to read from input
                                                                      // file
            OutputStream outputStream = new FileOutputStream(outputFile); // creates a new output stream to read from
                                                                          // output file

            // Read in data from a file
            int byteData; // Data is read in a stream of bytes

            // Loops until the end of the file
            while ((byteData = inputStream.read()) != -1) {
                System.out.println(byteData);

                // Write to the output file
                outputStream.write(byteData);
            }

            // Close files so that others can access them
            inputStream.close();
            outputStream.close();

        } catch (IOException ioException) {
            System.out.println("Error with opening and closing files");
            ioException.printStackTrace(); // prints error message to console
        } catch (Exception exception) {
            System.out.println("Something else is wrong"); // prints error message to console
            exception.printStackTrace();
        }
        /**
        * CLASS LOADER and RESOURCE STREAM
        * works similarly to FileInputStream
        * the difference:
        * getResourceAsStream() grabs a static resoure from yoru class path (within the project)
        * very useful for apps not running on your local machine
        */
        String resourcePath = "20240708-Java-SDET\\Java\\Day2\\FileIO\\fileInput.txt";

        try
        {
            // grabbing a static resource from our project and converting it into a stream
            InputStream inputStream = FileIO.class.getClassLoader().getResourceAsStream(resourcePath);

            if (inputStream != null)
            {
                int byteData;
                while ((byteData = inputStream.read()) != -1)
                {

                }
            }
        }
        catch ()
        {

        }
    }
}
