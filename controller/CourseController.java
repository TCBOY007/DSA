/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import adt.*;
import asg.Logo;
import entity.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author chenc
 */
public class CourseController {

    private LinkedList<Course> courseList = new LinkedList<Course>();
    Scanner scanner = new Scanner(System.in);

    public CourseController() {

    }

    public void addToLast() {

     

        System.out.println("Enter new course code:");
        String courseCode = scanner.nextLine();

        System.out.println("Enter new course name:");
        String courseName = scanner.nextLine();

        System.out.println("Enter new course Description:");
        String courseDescription = scanner.nextLine();

        System.out.println("Enter new credit hour:");
        int creditHour = scanner.nextInt();
        

        Course course = new Course();
        course.setCourseCode(courseCode);
        course.setCourseName(courseName);
        course.setCourseDescription(courseDescription);
        course.setCourseCreditHour(creditHour);

        if (courseList.add(course)) {
            loadScreen("add");
        } else {
            System.out.println("failed to add");
        }

    }

    public void addByPosition() {

        System.out.println("Enter new course code:");
        String courseCode = scanner.nextLine();

        System.out.println("Enter new course name:");
        String courseName = scanner.nextLine();

        System.out.println("Enter new course Description:");
        String courseDescription = scanner.nextLine();

        System.out.println("Enter new credit hour:");
        int creditHour = scanner.nextInt();

        Course course = new Course();
        course.setCourseCode(courseCode);
        course.setCourseName(courseName);
        course.setCourseDescription(courseDescription);
        course.setCourseCreditHour(creditHour);

        System.out.println("Specify the position You would like to add");
        int position = scanner.nextInt();

        if (courseList.add(position, course)) {
            System.out.println("added successfully");
        } else {
            System.out.println("failed to add");
        }
    }

    public void removeByName() {

    }

    public void removeById() {

    }

    public void removeByPosition() {

        int chkIgnoreString = 0;

        System.out.println("Please enter position that u would like to remove:");
        int position = scanner.nextInt();

        while (chkIgnoreString > 0) {
            scanner.nextLine();
            break;
        }

        chkIgnoreString++;

        if (courseList.remove(position)) {
            System.out.println("removed successfully");
        } else {
            System.out.println("failed to removed");
        }

    }

    public void displayAll() {

        int i = 1;
        Iterator<Course> iterator = courseList.getIterator();

        System.out.printf("%70s\n", "================");
        System.out.printf("%70s\n", "|Course List|");
        System.out.printf("%70s\n", "================");
        System.out.printf("%-5s %-35s %-20s %-20s %-28s %-20s %-20s\n", "", "Course Code", "Course Name", "Course Description", "Credit Hour", "Course Fee", "Programme");
        System.out.printf("%-5s %-35s %-20s %-20s %-28s %-20s %-20s\n", "", "-------------------------", "------------------", "------------------", "------------------", "------------------", "------------------");

        while (iterator.hasNext()) {

            Course course = iterator.next();
            System.out.printf("%d %-1s %-35s %-20s %-20s %-28d %-20d \n", i, "", course.getCourseCode(), course.getCourseName(), course.getCourseDescription(), course.getCourseCreditHour(), course.getCourseFee());
            i++;
            
        }
        System.out.printf("%-5s %-35s %-20s %-20s %-28s %-20s %-20s\n", "", "-------------------------", "------------------", "------------------", "------------------", "------------------", "------------------");

    }
    
      public static void loadScreen(String action){
        System.out.print(action+"ing");

        for (int i = 0; i < 10; i++) {
            System.out.print(".");
            try {
                Thread.sleep(500); // Pause for half a second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(action+" complete!");
    }

}
