/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.LinkedList;

/**
 *
 * @author chenc
 */
public class Course {

    private String courseCode;
    private String courseName;
    private String courseDescription;
    private int courseCreditHour;
    private LinkedList<Programme> Programme;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public int getCourseCreditHour() {
        return courseCreditHour;
    }

    public void setCourseCreditHour(int courseCreditHour) {
        this.courseCreditHour = courseCreditHour;
    }

    public LinkedList<Programme> getProgramme() {
        return Programme;
    }

    public void setProgramme(LinkedList<Programme> Programme) {
        this.Programme = Programme;
    }
    
    

   
    
    
    
    

}
