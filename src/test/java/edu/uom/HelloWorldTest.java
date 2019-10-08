package edu.uom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HelloWorldTest {

    HelloWorld helloWorld;
    @Before
    public void setup(){
        //Setup
        helloWorld= new HelloWorld();
    }

    @After
    public void teardown(){
        //Teardown
        helloWorld = null; // will actually be done automatically by garbage collector (just here to show teardown example)

    }

    @Test
    public void testStandardMessage(){

        //Exercise
        String msg = helloWorld.getMessage();

        //Verify
        assertEquals("Hello World!!", msg);

    }

    @Test
    public void testStandardMessage_withName(){

        //Exercise
        String msg = helloWorld.getMessage("Lara");

        //Verify
        assertEquals("Hello Lara!!", msg);

    }


    @Test
    public void testStandardMessage_withNameNull(){
        
        //Exercise
        String msg = helloWorld.getMessage(null);

        //Verify
        assertEquals("Hello World!!", msg);

    }


    @Test
    public void testStandardMessage_withNameEmpty(){

        //Exercise
        String msg = helloWorld.getMessage("");

        //Verify
        assertEquals("Hello World!!", msg);

 }
}