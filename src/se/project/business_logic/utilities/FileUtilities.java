/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package se.project.business_logic.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author Giorgio
 */
public class FileUtilities
{
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