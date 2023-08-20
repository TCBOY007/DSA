/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import adt.*;
import asg.*;
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

    public void courseMenu() {

        int chkIgnoreString = 0;
        int selection = 0;

        do {
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

            LocalDateTime myDateObj = LocalDateTime.now();
            String formattedDate = myDateObj.format(myFormatObj);
            System.out.println(formattedDate);

            System.out.println("=================================================");
            System.out.println("|\t WELCOME TO Course Management System \t|");
            System.out.println("=================================================");
            System.out.println("| Please Enter Your Selection \t\t\t | ");
            System.out.println("| 1. Add Course \t\t\t\t |");
            System.out.println("| 2. Remove Course  \t\t\t\t |");
            System.out.println("| 3. Display Course \t\t\t\t |");
            System.out.println("| 0. Back\t\t\t\t\t |");
            System.out.println("=================================================");

            do {

                boolean flag = false;

                do {
                    try {
                        Scanner sc = new Scanner(System.in);
                        System.out.println("Enter your selection : ");
                        selection = sc.nextInt();
                        
                        
                        
                        while(chkIgnoreString > 0){
                            scanner.nextLine();
                            break;
                        }
            
                        
                        
                        
                    } catch (Exception e) {
                        // accept integer only.
                        System.out.println("\n\nWrong input ! Please only type Integer ! \n\n");
                        flag = true;
                    }

                } while (flag == true);
                
                chkIgnoreString++;
                Logo logo = new Logo();

                switch (selection) {

                    case 1:

                        if (addMenu()) {
                            System.out.println("Course added successfully");
                        } else {
                            System.out.println("Failed to add course, Please try again");
                        }

                        break;
                    case 2:

                        if (removeMenu()) {
                            System.out.println("Course removed successfully");
                        } else {
                            System.out.println("Failed to remove course, Please try again");
                        }
                        break;

                    case 3:

                        SystemCls();
                        display();
                        break;

                    case 4:

                    case 5:

                    case 0:
                        asg asg = new asg();
                        asg.mainMenu();
                        break;

                    default:

                        System.out.println("Wrong Input , Please only type 1-5");
                        break;
                }

            } while (selection < 0 || selection > 5);

        } while (selection != 0);

    }

    public boolean addMenu() {
        

        boolean added = false;

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

        //here add different type of add
        added = courseList.add(course);

        return added;

    }

    public boolean removeMenu() {

        SystemCls();

        boolean removed = false;

        System.out.println("How would you like to remove the course?");
        System.out.println("===========");
        System.out.println("By Name");
        System.out.println("By Id");
        System.out.println("By number (1-" + courseList.getNumberOfEntries() + ")");
        System.out.println("===========");

        //here add different type of delete, now is using the index number
        System.out.println("Please enter position that u would like to remove:");
        int position = scanner.nextInt();

        if (position != 0 && position <= courseList.getNumberOfEntries()) {
            courseList.remove(position);
            removed = true;
        }

        return removed;
    }

    public void display() {

        Iterator<Course> iterator = courseList.getIterator();

        while (iterator.hasNext()) {
            Course course = iterator.next();
            System.out.println("removed");
            System.out.println("Course code:" + course.getCourseCode());
            System.out.println("Course name :" + course.getCourseName());
            System.out.println("Course Description :" + course.getCourseDescription());
            System.out.println("Course Credit Hour :" + course.getCourseCreditHour());
            System.out.println("\n\n");
        }

        //press Enter key to continue
        try {
            System.out.println("Press Enter key to continue");
            System.in.read();
        } catch (Exception e) {
        }

    }

    static void SystemCls() {
        for (int i = 0; i < 25; i++) {
            System.out.println();
        }
    }

}
