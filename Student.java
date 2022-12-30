package org.example;

import java.io.Serializable;

public class Student implements Serializable {
    private byte age;
    private int id;
    private String name;
    private String address;
    private float gpa;

    public Student(byte age, int id, String name, String address, float gpa) {
        this.age = age;
        this.id = id;
        this.name = name;
        this.address = address;
        this.gpa = gpa;
    }

    public byte getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public float getGpa() {
        return gpa;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }
}
