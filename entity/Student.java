/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author tqz11
 */
public class Student implements Serializable {

    private String studentName;
    private String StudentGender;
    private static int number = 2300;
    private int studrntID;
    private int studentAge;
    
    public Student () {

    }

    public Student(String studentName, String studentGender, int studentAge) {

        this.studentName = studentName;
        this.StudentGender = studentGender;
        this.studentAge = studentAge;
        this.studrntID = number++;

    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentGender() {
        return StudentGender;
    }

    public void setStudentGender(String StudentGender) {
        this.StudentGender = StudentGender;
    }

    public static int getNumber() {
        return number;
    }

    public static void setNumber(int number) {
        Student.number = number;
    }

    public int getStudrntID() {
        return studrntID;
    }

    public void setStudrntID(int studrntID) {
        this.studrntID = studrntID;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }
    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.number != other.number) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "Student\n==========\nStudent Name :" + studentName + "\nStudent Gender :" + StudentGender + "\nStudent Current Tutorial Group :" + studentCTGroup + "\nStudrnt ID :" + studrntID + "\nStudent Age :" + studentAge /*+ ", quantityOfStudent=" + quantityOfStudent*/;
        return String.format("     %-30s %-12d %-5d %-6s",  studentName, studrntID, studentAge, StudentGender);
    
    }



}
