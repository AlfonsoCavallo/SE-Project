package se.project.business_logic.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Provides utility static method for file system management.
 * 
 */
public class FileUtilities
{
    /**
     * Gets the content of a file at a given path as a String.
     * @param path is the path of the file from which take the content.
     * @return a String that contains the string in the file.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String getStringFromFile(String path) throws FileNotFoundException, IOException
    {
        // Get the String from the file
        Scanner scanner;
        InputStream input = FileUtilities.class.getResourceAsStream(path);

        scanner = new Scanner(input);

        String output = "";
        while (scanner.hasNextLine())
        {
            output += scanner.nextLine() + "\n";
        }
        return output;
    }
}