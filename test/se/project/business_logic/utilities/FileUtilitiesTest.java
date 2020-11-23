/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.business_logic.utilities;

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static se.project.business_logic.utilities.FileUtilities.*;

/**
 *
 * @author Giorgio
 */
public class FileUtilitiesTest
{
    
    public FileUtilitiesTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    // TEST FOR READING FROM FILE
    
    @Test(expected = NullPointerException.class)
    public void testFileNotFound() throws IOException
    {
        // try to find a file in a wrong path
        String text = getStringFromFile("wrong/path.txt");
    }
    
    @Test
    public void testReadingFromOneLineFile() throws IOException
    {
        // test getStringFromFile from a one-line file
        String text = getStringFromFile("/se/project/business_logic/utilities/testFile/testOneLineFile.sql");
        assertEquals("create user group;\n", text);
    }
    
    @Test
    public void testReadingFromMoreLineFile() throws IOException
    {
        // test getStringFromFile from a more-line file
        String text = getStringFromFile("/se/project/business_logic/utilities/testFile/testMoreLineFile.sql");
        assertEquals("create user;\ndelete table;\ncascade;\n", text);
    }
    
    @Test
    public void testVoidFile() throws IOException
    {
        // test getStringFromFile from a void file
        String text = getStringFromFile("/se/project/business_logic/utilities/testFile/testVoidFile.sql");
        assertEquals("", text);
    }
    
}