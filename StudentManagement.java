package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentManagement {
    public static Scanner scanner = new Scanner(System.in);
    private ArrayList<Student> studentArrayList;
    private StudentDatabase studentDatabase;


    public StudentManagement() { // inject dependency object, module, bean, constructor based từ class database
        studentDatabase = new StudentDatabase();
        studentArrayList = studentDatabase.read();
    }

    // Thêm object studen mới với trong arraylist đã inject vào constructor ở bên trên từ Database
    public void add() {
        int id = (studentArrayList.size() > 0) ? (studentArrayList.size() + 1) : 1;
        System.out.println("student id = " + id);
        String name = inputName();
        byte age = inputAge();
        String address = inputAddress();
        float gpa = inputGpa();
        Student student = new Student(age, id, name, address, gpa);
        studentArrayList.add(student);
        studentDatabase.write(studentArrayList);
    }

    // Sửa thông tin 1 object student có tồn tại theo id
    public void edit(int id) {
        boolean isExisted = false;

        for (int i = 0; i < studentArrayList.size(); i++) {
            if (studentArrayList.get(i).getId() == id) {
                isExisted = true;
                studentArrayList.get(i).setName(inputName());
                studentArrayList.get(i).setAge(inputAge());
                studentArrayList.get(i).setAddress(inputAddress());
                studentArrayList.get(i).setGpa(inputGpa());
                break;
            }
        }
        if (!isExisted) {
            System.out.printf("id = %d not existed.\n", id);
        } else {
            studentDatabase.write(studentArrayList);
        }
    }

    // Xóa 1 object student theo id
    public void delete(int id) {
        Student student = null;
        int size = studentArrayList.size();
        for (int i = 0; i < size; i++) {
            if (studentArrayList.get(i).getId() == id) {
                student = studentArrayList.get(i);
                break;
            }
        }
        if (student != null) {
            studentArrayList.remove(student);
            studentDatabase.write(studentArrayList);
        } else {
            System.out.printf("id = %d not existed.\n", id);
        }
    }

    // Sắp xếp theo alphabet từ String name
    public void sortByName() {
        Collections.sort(studentArrayList, new SortByName());
    }

    // Sắp xếp từ nhỏ đến lớn GPA
    public void sortByGPA() {
        Collections.sort(studentArrayList, new SortByGPA());
    }

    // Hiển thị
    public void show() {
        for (Student s : studentArrayList) {
            System.out.println(s.getId());
            System.out.println(s.getName());
            System.out.println(s.getAge());
            System.out.println(s.getAddress());
            System.out.println(s.getGpa());
        }
    }

    // inputID
    public int inputId() {
        System.out.print("Input student id: ");
        while (true) {
            try {
                int id = Integer.parseInt((scanner.nextLine()));
                return id;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input student id again: ");
            }
        }
    }

    // input name
    private String inputName() {
        System.out.print("Input student name: ");
        return scanner.nextLine();
    }

    // input address
    private String inputAddress() {
        System.out.print("Input student address: ");
        return scanner.nextLine();
    }

    // input age
    private byte inputAge() {
        System.out.print("Input student age: ");
        while (true) {
            try {
                byte age = Byte.parseByte((scanner.nextLine()));
                if (age < 0 || age > 100) {
                    throw new NumberFormatException();
                }
                return age;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input student id again: ");
            }
        }
    }

    // input gpa
    private float inputGpa() {
        System.out.print("Input student gpa: ");
        while (true) {
            try {
                float gpa = Float.parseFloat((scanner.nextLine()));
                if (gpa < 0.0 || gpa > 10.0) {
                    throw new NumberFormatException();
                }
                return gpa;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input student age again: ");
            }
        }
    }

    // getter && setter
    public ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }

    public void setStudentArrayList(ArrayList<Student> studentArrayList) {
        this.studentArrayList = studentArrayList;
    }
}
