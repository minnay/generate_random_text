package exercise;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

public class FileHelperTest {

    private FileHelper fileHelper;

    @Before
    public void setUp() {
        fileHelper = new FileHelper();
    }
    
    @Test
    public void shouldReturnTextWithoutPunctuation() {
        String source = "this is, a 'sample'. text with ? punctuation\n" + "here is another one";
        Scanner scanner = new Scanner(source);
        String output = fileHelper.getTextWithoutPunctuation(scanner);
        String expected = "this is a sample text with  punctuation here is another one";
        Assert.assertEquals(expected, output);
    }

}