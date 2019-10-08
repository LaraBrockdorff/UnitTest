package edu.uom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    int a, b, c ,d;
    Calculator calculator;


    @Before
    public void setUp() throws Exception {
        a = 1;
        b = 2;
        c = 3;
        d = 0;

        calculator= new Calculator();

    }



    @Test
    public void add() {
        int expected = 1+2;
        assertEquals(calculator.add(a,b), expected);
    }

    @Test
    public void subtract() {

        int expected = 1-2;
        assertEquals(calculator.subtract(a,b), expected);
    }

    @Test
    public void multiply() {
        int expected = 1*2;
        assertEquals(calculator.multiply(a,b), expected);
    }

    @Test
    public void divide() {
        int expected = 2/1;
        assertEquals(calculator.divide(b,a), expected);
    }

    @Test
    public void divide_Zero() {
        int expected = -999;
        assertEquals(calculator.divide(b,d), expected);
    }
}