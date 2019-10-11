package edu.uom.studentdb;

public class Student {

    private int id;
    private String name;
    private String cource;

    public Student(int id, String name, String cource) {
        this.id = id;
        this.name = name;
        this.cource = cource;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCource() {
        return cource;
    }

    public void setCource(String cource) {
        this.cource = cource;
    }
}
