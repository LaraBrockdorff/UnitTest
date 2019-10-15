package edu.uom.studentdb;

import edu.uom.studentdb.spies.StudentDBConnectionSuccessSpy;
import edu.uom.studentdb.stubs.StubDBConnectionFail;
import edu.uom.studentdb.stubs.StubDBConnectionSuccess;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import static org.junit.Assert.*;


public class StudentDBTest {
    public final int DEFAULT_STUDENT_ID =1;
    public final int INVALID_ID =5;

    StudentDB studentDB;
    Student student;

    @Before
    public void setup(){
        studentDB = new StudentDB();
        student = new Student(DEFAULT_STUDENT_ID, null, null);
    }

    @After
    public void tearDown(){
        studentDB = null;
    }

    @Test
    public void testCountIncrementAfterAddingAStudent(){

       //cache the current size of a database
        int size = studentDB.countStudnets();

        //Exercise
        studentDB.addStudent(student);

        //Verify
        assertEquals(size+1, studentDB.countStudnets());
    }

    @Test
    public void testCountSameStudentTwice(){



        //cache the current size of a database
        int size = studentDB.countStudnets();

        //Exercise
        studentDB.addStudent(student);
        studentDB.addStudent(student);

        //Verify
        assertEquals(size+1, studentDB.countStudnets());
    }

    @Test
    public void testCountRemoveStudent(){

        studentDB.addStudent(student);

        //cache the current size of a database
        int size = studentDB.countStudnets();

        //Exercise
        studentDB.removeStudent(student.getId());


        //Verify
        assertEquals(size-1, studentDB.countStudnets());
    }

    @Test
    public void testRemoveStudentNotInDB(){


        //cache the current size of a database
        int size = studentDB.countStudnets();

        //Exercise
        studentDB.removeStudent(INVALID_ID);


        //Verify
        assertEquals(size, studentDB.countStudnets());
    }

    @Test
    public void testCommitWithSuccessfulDBConnection(){

        //Setup
        DBConnection dbConnection = new StubDBConnectionSuccess();
        studentDB.addStudent(student);

        //Exercise
        boolean result =studentDB.commit(dbConnection);

        //Verify
        assertTrue(result);

    }

    @Test
    public void testCommitWithSuccessfulDBConnection_Mock(){

        //Setup
        DBConnection dbConnection =  Mockito.mock(DBConnection.class);
        Mockito.when(dbConnection.commitStudent(student)).thenReturn(0);
      //  Mockito.when(dbConnection.commitStudent(Matchers.any(Student.class))).thenReturn(0);

        studentDB.addStudent(student);

        //Exercise
        boolean result =studentDB.commit(dbConnection);

        //Verify
        assertTrue(result);

    }

    @Test
    public void testCommitWithFailureDBConnection(){

        //Setup
        DBConnection dbConnection = new StubDBConnectionFail();
        studentDB.addStudent(student);

        //Exercise
        boolean result =studentDB.commit(dbConnection);

        //Verify
        assertTrue(!result);

    }

    @Test
    public void testCommitWithFailureDBConnection_Mock(){

        //Setup
        DBConnection dbConnection = Mockito.mock(DBConnection.class);
        Mockito.when(dbConnection.commitStudent(student)).thenReturn(1);
        studentDB.addStudent(student);

        //Exercise
        boolean result =studentDB.commit(dbConnection);

        //Verify
        assertTrue(!result);

    }

    @Test
    public void testDrirtyFlagSetToFalseAfterCreaction(){

        //Verify
        assertFalse(studentDB.isDirty());

    }

    @Test
    public void testDirtyFlagToTrueAfterAddingStudent(){

        //Exercise
        studentDB.addStudent(student);

        //Verify
        assertTrue(studentDB.isDirty());
    }

    @Test
    public void testDirtyFlagToTrueAfterRemovingStudent(){

        //setup
        studentDB.addStudent(student);
        studentDB.commit(new StubDBConnectionSuccess());

        //Exercise
        studentDB.removeStudent(student.getId());

        //Verify
        assertTrue(studentDB.isDirty());
    }

    @Test
    public void testDrityFalgSetToFalseAfterCommiting(){

        //Exercise
        studentDB.addStudent(student);
        studentDB.commit(new StubDBConnectionSuccess());

        //Verify
        assertFalse(studentDB.isDirty());

    }


    @Test
    public  void testDBIsCalledWhenDBIsDirty(){

        //SetUp
        StudentDBConnectionSuccessSpy spyConnection = new StudentDBConnectionSuccessSpy();
        int count = spyConnection.count();
        studentDB.addStudent(student);


        //Exercise
        studentDB.commit(spyConnection);

        //Verify
        assertTrue(spyConnection.count()>count);
    }

    @Test
    public  void testDBIsNotCalledWhenDBIsNotDirty(){

        //SetUp
        StudentDBConnectionSuccessSpy spyConnection = new StudentDBConnectionSuccessSpy();
        studentDB.addStudent(student);
        studentDB.commit(spyConnection);
        int count = spyConnection.count();

        //Exercise
        studentDB.commit(spyConnection);

        //Verify
        assertEquals(count,spyConnection.count() );
    }


    @Test
    public  void testDBIsNotCalledWhenDBIsNotDirty_Mock(){

        //SetUp
        StudentDBConnectionSuccessSpy spyConnection = new StudentDBConnectionSuccessSpy();
        studentDB.addStudent(student);
        studentDB.commit(spyConnection);
        int count = spyConnection.count();

        //Exercise
        studentDB.commit(spyConnection);

        //Verify
        assertEquals(count,spyConnection.count() );
    }

    @Test
    public  void testDBIsCalledWhenDBIsDirty_Mock(){

        //SetUp
        DBConnection dbConnection = Mockito.mock(DBConnection.class);
//        int count = spyConnection.count();
        studentDB.addStudent(student);


        //Exercise
        studentDB.commit(dbConnection);

        //Verify
        Mockito.verify(dbConnection, Mockito.times(1))
                .commitStudent(Matchers.any(Student.class));
    }
}