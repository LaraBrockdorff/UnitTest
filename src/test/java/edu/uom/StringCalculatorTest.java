package edu.uom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class StringCalculatorTest {
    StringCalculator calc ;

    @Before
    public void setup(){
        calc = new StringCalculator();
    }

    @After
    public void teardown (){
        calc = null;
    }

    @Test
    public void add_withEmptyString(){

        //exercise
        int result = calc.add("");
        assertEquals(0,result);
    }

    @Test
    public void add_withNull(){

        //exercise
        int result = calc.add(null);
        assertEquals(0,result);
    }

    @Test
    public void add_withWhiteSpcae(){

        //exercise
        int result = calc.add("   \t \n \n");
        assertEquals(0,result);
    }

    @Test
    public void add_withOneNumber(){

        //exercise
        int result = calc.add("123");
        assertEquals(123,result);
    }

    @Test
    public void add_withOneNumber_Negative(){

        //exercise
        int result = calc.add("-123");
        assertEquals(-123,result);
    }

    @Test
    public void add_withNonNumeric(){

        //exercise
        int result = calc.add("boop");
        assertEquals(-1,result);
    }

}
