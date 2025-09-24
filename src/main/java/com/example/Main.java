package com.example;


import java.util.Scanner;

public class Main {

    private static Teacher[] listTeachers;
    private static Course[] listCourses;
    private static Student[] listStudents;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome");
        // System.out.println("Enter a school name:");
        // String schoolName = scanner.nextLine();
        
        System.out.println("Enter number of teachers:");
        int numTeachers = scanner.nextInt();
        for (int i = 0; i < numTeachers; i++) {
            System.out.println("Enter teacher's name");
            String teacherName = scanner.nextLine();
            System.out.println("Enter teacher's salary");
            double teacherSalary = scanner.nextDouble();
            listTeachers[i] = new Teacher(teacherName, teacherSalary);
        }

        System.out.println("Enter number of courses:");
        int numCourses = scanner.nextInt();
        for (int i = 0; i < numCourses; i++) {
            System.out.println("Enter course's name and price");
            String courseName = scanner.nextLine();
            System.out.println("Enter course's price");
            double coursePrice = scanner.nextDouble();
            listCourses[i] = new Course(courseName, coursePrice);
        }

        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter student's name");
            String name = scanner.nextLine();
            System.out.println("Enter student's address");
            String address = scanner.nextLine();
            System.out.println("Enter student's email");
            String email = scanner.nextLine();
            listStudents[i] = new Student(name, address, email);
        }


        System.out.println("System ready to enter commands");

        while (true) {
            String command = scanner.nextLine();
            String[] instr = command.split(" ");

            try {
                switch (instr[0]) {
                    case "ENROLL":
                        enrollStudent(instr[1], instr[2]);
                        break;
                    case "ASSIGN":
                        assignTeacher(instr[1], instr[2]);
                        break;
                    case "SHOW":
                        showCommand(instr);
                        break;
                    case "LOOKUP":
                        lookupCommand(instr);
                        break;
                    default:
                        System.out.println("Unknown command.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            scanner.close();
        }
        
    }

    private static void enrollStudent(String studentId, String courseId) {
        for (Course c : listCourses) {
            if(courseId == c.getCourseId()) {
                for(Student s : listStudents) {
                    s.setCourse(c);
                    System.out.println("Student enrolled!");
                }
                c.setMoneyEarned(c.getMoneyEarned() + c.getPrice());
            }
        }
    }

    private static void assignTeacher(String teacherId, String courseId) {
        for (Teacher t : listTeachers) {
            if(teacherId == t.getTeacherId()) {
                for(Course c : listCourses) {
                    c.setTeacher(t);
                System.out.println("Teacher assigned!");
                } 
            }
        }
        
    }

    private static void showCommand(String[] instr) {
        switch (instr[1]) {

            case "COURSES":
                for (Course c : listCourses) {
                    System.out.println(c.toString());
                }
                break;

            case "STUDENTS":
                for (Student s : listStudents) {
                    System.out.println(s.toString());
                }
                break;

            case "TEACHERS":
                for (Teacher t : listTeachers) {
                    System.out.println(t.toString());
                }          
                break;

            case "PROFIT":
                double totalEarned = 0;
                double totalSalary = 0;
                for (Course c : listCourses) {
                    totalEarned += c.getMoneyEarned();
                }
                for (Teacher t : listTeachers) {
                    totalSalary += t.getSalary();
                } 
                System.out.println("Profit: " + (totalEarned - totalSalary));
                break;

            default:
                System.out.println("Unknown show command.");
        }
    }

    private static void lookupCommand(String[] instr) {
        switch (instr[1]) {

            case "COURSES":
                for (Course c : listCourses) {
                    if(instr[2] == c.getCourseId()) {
                        System.out.println(c.toString());
                    }
                }
                break;

            case "STUDENTS":
                for (Student s : listStudents) {
                    if(instr[2] == s.getStudentId()) {
                        System.out.println(s.toString());
                    }
                }
                break;

            case "TEACHERS":
                for (Teacher t : listTeachers) {
                    if(instr[2] == t.getTeacherId()) {
                        System.out.println(t.toString());
                    }
                }          
                break;

            default:
                System.out.println("Unknown lookup command.");
        }
    }
}