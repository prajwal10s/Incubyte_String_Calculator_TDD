import org.junit.Test;

import static StringCalculator.StringCal.add;
import static org.junit.Assert.*;


public class StringCalTest {
    //TASK 1
    //TODO: test for empty string
    @Test
    public void returnZeroOnEmptyInput(){
        assertEquals(0, add(""));
    }
    //TODO: test for string with two numbers separated by comma
    @Test
    public void returnSumOfTwoNumberCommaSeparated(){
        assertEquals(5, add("2,3"));
    }
    //TODO: test for string with a single number
    //for single number it should return the same number
    @Test
    public void returnSameNumberForSingleNumber(){
        assertEquals(2,add("2"));
    }

    //TASK2
    //TODO:test for multiple strings separated by comma
    //output should be sum of all
    @Test
    public void returnSumOfAllNumbers(){
        assertEquals(14, add("2,3,4,5"));
    }

    //TASK3
    //TODO:Allow the Add method to handle new lines between numbers instead of commas
    @Test
    public void allowNewlineAndCommaAsDelim(){
        assertEquals(6,add("1\n2,3"));
    }

    //TASK 4
    //TODO: Support different delimiters
    //allow custom delimiters
    @Test
    public void allowCustomDelims(){
        assertEquals(3,add("//;\n1;2"));
        assertEquals(6,add("//;\n1;2;3"));
    }

    //TASK 5
    //TODO: throw an exception if add is called with negative numbers
    @Test
    public void shouldThrowExceptionForNegative(){
        try{
            add("1,-2,3");
            fail("Exception");
        }
        catch(RuntimeException rne){
            assertEquals("Negative values are not allowed -2", rne.getMessage());
        }

    }
    @Test
    public void shouldThrowExceptionForNegatives(){
        try{
            add("-1,-2,-3");
            fail("Exception");
        }
        catch(RuntimeException rne){
            assertEquals("Negative values are not allowed -1, -2, -3", rne.getMessage());
        }

    }
}
