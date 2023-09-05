/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;
import adt.ArrayList;
import adt.ListInterface;
import entity.TutorialGroup;
import entity.Student;
import java.util.Scanner;

/**
 *
 * @author tqz11
 */
public class StudentUI {
    
    Scanner scanner = new Scanner(System.in);
    
    // Student menu
    //======================================================
    public int getStudentMenuChoice() {
        int choice;

        do {
            SMenu();
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("Pleas Enter again! \"%s\" is not a valid number.%n", input);
                SMenu();
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
        } while (choice < 0);

        return choice;
    }
    public void SMenu(){
        System.out.println("\nStudent MENU");
        System.out.println("1. Add new student");
        System.out.println("2. Remove student");
        System.out.println("3. Change student tutorial group");
        System.out.println("4. List all student");
        System.out.println("0. Quit");
        System.out.print("Enter choice: ");
    }
    
    
    
        // List all Student
    public void listAllStudent(String outputStr) {
        System.out.println("\nList of Student:\nNo.   Student Name                   Student ID   Age   Gender");
        System.out.println(outputStr);
    }
    
    // Get no of the student to remove student
    //======================================================
    public int inputNoStudent() {
        System.out.print("Enter no of the Student that want to chose: ");
        int num = scanner.nextInt();
        scanner.nextLine();
        return num;
    }
    
    // Get the tutorial group that the student will be change to
    //======================================================
    public int inputChangeStudentTutorialGroup() {
        System.out.print("Enter the tutorial group that you would like to let student change to : ");
        int tGroup = scanner.nextInt();
        scanner.nextLine();
        return tGroup;
    }
    
    // Get the result of either remove student or not remove it
    //======================================================
    public String inputRemoveStudent() {
        System.out.print("Enter (Y/y) to remove student or (N/n) to cancel : ");
        String yORn = scanner.nextLine();
        return yORn;
    }

    // Print out the student details
    //======================================================
    public void printStudentDetails(Student student) {
        System.out.println("\n");
        System.out.println("Student Details");
        System.out.println("Student name:" + student.getStudentName());
        System.out.println("Student ID:" + student.getStudrntID());
        System.out.println("Student age: " + student.getStudentAge());
        System.out.println("Student gender: " + student.getStudentGender());
        System.out.println("\n");
    }
    
    // Get the result of either add student or not
    //======================================================
    public String inputAddStudent() {
        System.out.print("Do you want to add student in to tutorial class");
        System.out.print("Enter (Y/y) to add student or (N/n) to cancel : ");
        String yORn = scanner.nextLine();
        yORn.toUpperCase();
        return yORn;
    }
    
    // Get the result of either add student or not
    //======================================================
    public String inputAddMoreStudent() {
        System.out.print("Enter (Y/y) to add more student or (N/n) to cancel : ");
        String yORn = scanner.nextLine();
        yORn.toUpperCase();
        return yORn;
    }

    // To add student and get student information
    //======================================================
    public String inputStudentName() {
        String name = "";

        System.out.print("Enter Student name : ");
        while (!scanner.hasNext("[A-Za-z]*")) {
            String input = scanner.next();
            System.out.printf("Pleas Enter again! \"%s\" is not a String value.%n", input);
            System.out.print("Enter Student name : ");
        }
        name = scanner.nextLine();

        return name;
    }

    public String inputStudentGender() {
        String gender = "";
        
        for (int i = 10; i > 5; i++) {
            System.out.print("Enter Student gender (F/M) : ");
            gender = scanner.nextLine();
            switch (gender.toUpperCase()) {
                case "F":
                    i = 0;
                    break;
                case "M":
                    i = 0;
                    break;
                default:
                    System.out.println("Please enter again!");
            }
        }
        return gender.toUpperCase();
    }

    public int inputStudentAge() {
        int age;

        do {
            System.out.print("Enter Student age : ");
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("Pleas Enter again! \"%s\" is not a valid number.%n", input);
                System.out.print("Enter Student age : ");
            }
            age = scanner.nextInt();
            scanner.nextLine();
        } while (age < 0);
        return age;
    }

    public Student inputStudentDetails() {
        Student student = new Student();
        String name = inputStudentName();
        String gender = inputStudentGender();
        int age = inputStudentAge();

        System.out.println();
        return new Student(name, gender, age);
    }
    //======================================================
    
    public Student inputStudentTG(Student student) {
        String name = student.getStudentName();
        String gender = student.getStudentGender();
        int tGroup = inputChangeStudentTutorialGroup();
        int age = student.getStudentAge();
        //int i = student.getQuantityOfStudent();
        System.out.println();
        return new Student(name, gender, age);
    }
    
}
