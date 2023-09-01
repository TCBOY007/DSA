/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import adt.*;
import entity.*;
import asg.*;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 *
 * @author chenc
 */
public class CourseController {

    private ListInterface<Course> courseList = new LinkedList<>();

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
        scanner.nextLine();

        System.out.println("Enter new Course Fee : ");
        double courseFee = scanner.nextDouble();
        scanner.nextLine();

        Course course = new Course();
        course.setCourseCode(courseCode);
        course.setCourseName(courseName);
        course.setCourseDescription(courseDescription);
        course.setCourseCreditHour(creditHour);
        course.setCourseFee(courseFee);

        if (courseList.add(course)) {
            System.out.println(courseList.getTotalNumberData());
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

        System.out.println("Enter new Course Fee: ");
        double courseFee = scanner.nextDouble();

        Course course = new Course();
        course.setCourseCode(courseCode);
        course.setCourseName(courseName);
        course.setCourseCreditHour(creditHour);
        course.setCourseFee(courseFee);
        course.setCourseDescription(courseDescription);

        System.out.println("Specify the position You would like to add");
        int position = scanner.nextInt();

        if (courseList.add(position, course)) {
            System.out.println("added successfully");
        } else {
            System.out.println("failed to add");
        }
    }

    public void removeByPosition() {

        int selection = 0;
        char sure;

        displayAll();
        System.out.println("===============================================");
        System.out.println("Select the index of the course to remove (type 0 to go back):");
        System.out.println("Enter (0-" + courseList.getTotalNumberData() + "): ");
        System.out.println("===============================================");

        do {

            System.out.println("Enter your Selection:");
            selection = scanner.nextInt();

            if (selection < 0 || selection > courseList.getTotalNumberData()) {
                System.out.println("Invalid option, Please try ");
            }

        } while (selection < 0 || selection > courseList.getTotalNumberData());

        if (selection == 0) {

            return;

        } else if (selection > 0 && selection <= courseList.getTotalNumberData()) {

            do {

                System.out.println("Are you sure ? (y/n) :");
                sure = scanner.next().toUpperCase().charAt(0);

                if (sure == 'Y') {

                    if (courseList.remove(selection)) {
                        loadScreen("remov");
                    } else {
                        System.out.println("failed to removed");
                    }

                } else if (sure == 'N') {

                    System.out.println("Removal cancel");
                    break;

                } else {
                    System.out.println("Invalid input. Please enter 'y' or 'n'.");
                }

            } while (sure != 'Y' && sure != 'N');

        }

    }

    public ListInterface<Course> searchName(String name) {

        int i = 1;

        Iterator<Course> iterator = courseList.getIterator();

        Predicate<Course> searchByName = search -> search.getCourseName().toUpperCase().contains(name);
        ListInterface<Course> listByName = courseList.search(searchByName);

        while (iterator.hasNext()) {

            Course course = iterator.next();

            if (searchByName.test(courseList.getData(i))) {
                if (!listByName.contains(course)) {
                    listByName.add(courseList.getData(i));
                }
            }

            i++;
        }

        return listByName;

    }

    public ListInterface<Course> searchID(String id) {

        int i = 1;

        Iterator<Course> iterator = courseList.getIterator();

        Predicate<Course> searchByID = search -> search.getCourseName().toUpperCase().contains(id);
        ListInterface<Course> listByID = courseList.search(searchByID);

        while (iterator.hasNext()) {

            Course course = iterator.next();

            if (searchByID.test(courseList.getData(i))) {
                if (!listByID.contains(course)) {
                    listByID.add(courseList.getData(i));
                }
            }

            i++;
        }

        return listByID;

    }

    public void modifyByCode(int index) {

        boolean modify = false;

        do {

            Course newCourse = new Course();
            System.out.println("Please Enter the new Code :");
            String newCode = scanner.nextLine();

            newCourse = courseList.getData(index);
            newCourse.setCourseCode(newCode);

            modify = courseList.replace(index, newCourse);

            if (modify) {
                loadScreen("Modif");
            }

        } while (index < 0 || index > courseList.getTotalNumberData());

    }

    public void modifyByName(int index) {
        boolean modify = false;

        do {

            Course newCourse = new Course();
            System.out.println("Please Enter the New Name :");
            String newName = scanner.nextLine();

            newCourse = courseList.getData(index);
            newCourse.setCourseName(newName);

            modify = courseList.replace(index, newCourse);

            if (modify) {
                loadScreen("Modif");
            }

        } while (index < 0 || index > courseList.getTotalNumberData());

    }

    public void modifyCourseDescription(int index) {
        boolean modify = false;

        do {

            Course newCourse = new Course();
            System.out.println("Please Enter the New Course Description :");
            String newDescription = scanner.nextLine();

            newCourse = courseList.getData(index);
            newCourse.setCourseName(newDescription);

            modify = courseList.replace(index, newCourse);

            if (modify) {
                loadScreen("Modif");
            }

        } while (index < 0 || index > courseList.getTotalNumberData());
    }

    public void modifyCreditHour(int index) {
        boolean modify = false;
        int count = 0;
        int newCreditHour = 0;
        do {

            Course newCourse = new Course();
            System.out.println("Please Enter the New Course Credit Hour :");
            try {
                newCreditHour = scanner.nextInt();
                scanner.nextLine();

                newCourse = courseList.getData(index);
                newCourse.setCourseCreditHour(newCreditHour);

                modify = courseList.replace(index, newCourse);

                if (modify) {
                    loadScreen("Modif");
                }

            } catch (Exception e) {
                System.out.println("Invalid! Please only Enter Integer !");
                scanner.nextLine();
            }
            count++;
        } while (modify != true && count < 3);
    }

    public void modifyCourseFee(int index) {
        boolean modify = false;
        int count = 0;
        double newCreditFee = 0;
        do {

            Course newCourse = new Course();
            System.out.println("Please Enter the New Course Fee :");
            try {
                newCreditFee = scanner.nextInt();
                scanner.nextLine();

                newCourse = courseList.getData(index);
                newCourse.setCourseFee(newCreditFee);

                modify = courseList.replace(index, newCourse);

                if (modify) {
                    loadScreen("Modif");
                }

            } catch (Exception e) {
                System.out.println("Invalid! Please only Enter Integer !");
                scanner.nextLine();
            }
            count++;
        } while (modify != true && count < 3);
    }

    public void displayAll() {

        int i = 1;
        Iterator<Course> iterator = courseList.getIterator();

        System.out.printf("%70s\n", "================");
        System.out.printf("%70s\n", "| Course List  |");
        System.out.printf("%70s\n", "================");
        System.out.printf("%-5s %-20s %-35s %-20s %-20s %-20s\n", "", "Course Code", "Course Name", "Credit Hour", "Course Fee", "Programme");
        System.out.printf("%-5s %-20s %-35s %-20s %-20s %-20s\n", "", "------------------", "----------------------------------", "------------------", "------------------", "------------------");

        while (iterator.hasNext()) {

            Course course = iterator.next();
            System.out.printf("%-5d %-1s %-20s %-35s %-20d %-20.2f %-30s \n", i, "", course.getCourseCode(), course.getCourseName(), course.getCourseCreditHour(), course.getCourseFee(), course.getProgramme());
            i++;

        }
        System.out.printf("%-5s %-20s %-35s %-20s %-20s %-20s\n", "", "------------------", "----------------------------------", "------------------", "------------------", "------------------");

    }

    public void display(ListInterface<Course> list) {
        int i = 1;
        Iterator<Course> iterator = list.getIterator();

        System.out.printf("%70s\n", "================");
        System.out.printf("%70s\n", "| Course List  |");
        System.out.printf("%70s\n", "================");
        System.out.printf("%-5s %-20s %-35s %-20s %-20s %-20s\n", "", "Course Code", "Course Name", "Credit Hour", "Course Fee", "Programme");
        System.out.printf("%-5s %-20s %-35s %-20s %-20s %-20s\n", "", "------------------", "----------------------------------", "------------------", "------------------", "------------------");

        while (iterator.hasNext()) {

            Course course = iterator.next();
            System.out.printf("%-5d %-1s %-20s %-35s %-20d %-20.2f %-30s \n", i, "", course.getCourseCode(), course.getCourseName(), course.getCourseCreditHour(), course.getCourseFee(), course.getProgramme());
            i++;

        }
        System.out.printf("%-5s %-20s %-35s %-20s %-20s %-20s\n", "", "------------------", "----------------------------------", "------------------", "------------------", "------------------");

        System.out.println("\nPress ENTER key to continue");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

    public int getSize() {
        return courseList.getTotalNumberData();
    }

    public void initializeData() {
        courseList.add(new Course("1", "1", "1", 2, 3847.99));

    }

    public static void loadScreen(String action) {

        System.out.print(action + "ing");

        for (int i = 0; i < 3; i++) {
            System.out.print(".");
            try {
                Thread.sleep(500); // Pause for half a second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Completed!");
        try {
            Thread.sleep(800); // Pause for half a second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
