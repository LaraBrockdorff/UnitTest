package edu.uom.studentdb;

import java.util.ArrayList;
import java.util.List;

public class StudentDB {

    private List<Student> db = new ArrayList<Student>();
    private boolean dirty = false;

    public boolean isDirty() {
        return dirty;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }

    public void addStudent(Student s){
        if(getStudentById(s.getId())==null){
            db.add(s);
            setDirty(true);
        }



    }

    public void removeStudent(int id){
        db.remove(getStudentById(id));
        setDirty(true);

    }

    public int countStudnets(){
        return db.size();
    }
    public  Student getStudentById(int id){
        for (Student s: db){
            if (s.getId()== id){
                return s;
            }
        }
        return null;
    }

    public boolean commit(DBConnection dbConnection) {
        boolean result = true;

        for(Student s : db){
            if (dbConnection.commitStudent(s)!=0){
                result =false;
            }
        }
        setDirty(false);
        return result;
    }
}
