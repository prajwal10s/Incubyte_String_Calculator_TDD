import org.junit.Test;

import static StringCalculator.StringCal.add;
import static org.junit.Assert.*;


public class StringCalTest {

    //test for empty string
    @Test
    public void returnZeroOnEmptyInput(){
        assertEquals(0, add(""));
    }
    //test for string with two numbers separated by comma
    @Test
    public void returnSumOfTwoNumberCommaSeparated(){
        assertEquals(5, add("2,3"));
    }
    //test for string with a single number
    //for single number it should return the same number
    @Test
    public void returnSameNumberForSingleNumber(){
        assertEquals(2,add("2"));
    }
}
