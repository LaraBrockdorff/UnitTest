package edu.uom;

import org.junit.Test;

import static org.junit.Assert.*;

public class HelloWorldTest {

    @Test
    public void testStandardMessage(){
        //Setup
        HelloWorld helloWorld = new HelloWorld();


        //Exercise
        String msg = helloWorld.getMessgage();

        //Verify
        assertEquals("Hello World!!", msg);

        //Teardown
        helloWorld = null; // will actually be done automatically by garbage collector (just here to show teardown example)
    }

}