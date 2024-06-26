import org.junit.Test;

import static StringCalculator.StringCal.add;
import static org.junit.Assert.*;


public class StringCalTest {
    @Test
    public void returnZeroOnEmptyInput(){
        assertEquals(0, add(""));
    }
}
