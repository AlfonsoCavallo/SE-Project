/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.business_logic.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Giorgio
 */
public class ReadFile
{
    
    public static String getStringFromFile(String file) throws FileNotFoundException, IOException
    {
        // Get the String from the file
        FileReader fileReader;
        fileReader = new FileReader(file);
        BufferedReader bufferedReader;
        bufferedReader = new BufferedReader(fileReader);
        String string = null;
        while(true){
            String nextString = bufferedReader.readLine();
            if(nextString == null)
                break;
            string = string.concat(nextString);
        }
        fileReader.close();
        return string;
    }
}
