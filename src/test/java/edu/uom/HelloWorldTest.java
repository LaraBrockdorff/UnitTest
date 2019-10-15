package edu.uom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

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

    @Test
    public void testTimedMessageMorning(){

        //setup
        TimeProvider timeProvider = Mockito.mock(TimeProvider.class);
        Mockito.when(timeProvider.getTimeSegment()).thenReturn(TimeProvider.MORNING);

        //Exercise
        String msg = helloWorld.getTimedMessage(timeProvider);

        //verify
        assertEquals("Hello World!! Good morning!", msg);

    }
    @Test
    public void testTimedMessageAfternoon(){

        //setup
        TimeProvider timeProvider = Mockito.mock(TimeProvider.class);
        Mockito.when(timeProvider.getTimeSegment()).thenReturn(TimeProvider.AFTERNOON);

        //Exercise
        String msg = helloWorld.getTimedMessage(timeProvider);

        //verify
        assertEquals("Hello World!! Good afternoon!", msg);

    }

    @Test
    public void testTimedMessageEvening(){

        //setup
        TimeProvider timeProvider = Mockito.mock(TimeProvider.class);
        Mockito.when(timeProvider.getTimeSegment()).thenReturn(TimeProvider.EVENING);

        //Exercise
        String msg = helloWorld.getTimedMessage(timeProvider);

        //verify
        assertEquals("Hello World!! Good evening!", msg);

    }

    @Test
    public void testTimedMessageUnkownSegment(){

        //setup
        TimeProvider timeProvider = Mockito.mock(TimeProvider.class);
        Mockito.when(timeProvider.getTimeSegment()).thenReturn(999);

        //Exercise
        String msg = helloWorld.getTimedMessage(timeProvider);

        //verify
        assertEquals("Hello world", msg);

    }



}