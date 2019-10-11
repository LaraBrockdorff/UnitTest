package edu.uom.studentdb.spies;

import edu.uom.studentdb.DBConnection;
import edu.uom.studentdb.Student;

public class StudentDBConnectionSuccessSpy implements DBConnection {

    private int counter = 0;

    public int commitStudent(Student student){
        counter++;
        return 0;

    }

    public int count(){
        return counter;
    }
}
