package org.example;

import java.util.Scanner;

public class Main {
        public static Scanner scanner = new Scanner(System.in);
        public static void main(String[] args) {
            String choose = null;
            boolean exit = false;
            StudentManagement studentManagement = new StudentManagement();
            int studentId;

            // Run method hiển thị Menu
            showMenu();

            while (true) {
                choose = scanner.nextLine();
                switch (choose) {
                    case "1":
                        studentManagement.add();
                        break;
                    case "2":
                        studentId = studentManagement.inputId();
                        studentManagement.edit(studentId);
                        break;
                    case "3":
                        studentId = studentManagement.inputId();
                        studentManagement.delete(studentId);
                        break;
                    case "4":
                        studentManagement.sortByGPA();
                        break;
                    case "5":
                        studentManagement.sortByName();
                        break;
                    case "6":
                        studentManagement.show();
                        break;
                    case "0":
                        System.out.println("exited!");
                        exit = true;
                        break;
                    default:
                        System.out.println("invalid! please choose action in below menu:");
                        break;
                }
                if (exit) {
                    break;
                }
                // show menu
                showMenu();
            }
        }

  // Hiển thị Menu
    public static void showMenu() {
        System.out.println("-----------menu------------");
        System.out.println("1. Add student.");
        System.out.println("2. Edit student by id.");
        System.out.println("3. Delete student by id.");
        System.out.println("4. Sort student by gpa.");
        System.out.println("5. Sort student by name.");
        System.out.println("6. Show student.");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
    }
}