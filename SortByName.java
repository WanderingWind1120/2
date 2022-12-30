package org.example;

import java.util.Comparator;

public class SortByName implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
    // Không sử dụng comparable để có thể custom cái compare và không ảnh hưởng đến OOP gốc
}
