package se.project.business_logic.utilities;

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static se.project.business_logic.utilities.FileUtilities.*;


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

    
    /**
     * Try to find a file in a wrong path.
     * @Result Path is not found and exceptions are thrown.
     * @throws IOException 
     */
    @Test(expected = NullPointerException.class)
    public void testFileNotFound() throws IOException
    {
        String text = getStringFromFile("wrong/path.txt");
    }
    
    /**
     * Get a string from a one-line file.
     * @Result The string in the path is correctly found and checked.
     * @throws IOException 
     */
    @Test
    public void testReadingFromOneLineFile() throws IOException
    {
        String text = getStringFromFile("/se/project/business_logic/utilities/test_files/testOneLineFile.sql");
        assertEquals("create user group;\n", text);
    }
    
    /**
     * Get a string from a more-line file.
     * @Result The string in the path is correctly found and checked.
     * @throws IOException 
     */
    @Test
    public void testReadingFromMoreLineFile() throws IOException
    {
        String text = getStringFromFile("/se/project/business_logic/utilities/test_files/testMoreLineFile.sql");
        assertEquals("create user;\ndelete table;\ncascade;\n", text);
    }
    
    /**
     * Get a string from a void file.
     * @Result The empty string in the path is correctly found and checked.
     * @throws IOException 
     */
    @Test
    public void testVoidFile() throws IOException
    {
        String text = getStringFromFile("/se/project/business_logic/utilities/test_files/testVoidFile.sql");
        assertEquals("", text);
    }
    
}