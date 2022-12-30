package org.example;

import java.util.Comparator;

public class SortByGPA implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        if (s1.getGpa() == s2.getGpa()){
            return 0;
        }
        else if (s1.getGpa() > s2.getGpa()) {
            return 1;
        }
        return -1;
    }
}
