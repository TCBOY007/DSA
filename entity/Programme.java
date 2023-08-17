/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.LinkedList;

/**
 *
 * @author chook zhen yew
 */
public class Programme {
    private String programmeName;   
    private String programmeCode;
    private String programmeType;           // eg diploma / degree / master / phd
    private int programmeDuration;          // in terms of year
    private double programmeFee;            // 2 decimal place
    
    private LinkedList<Instructor> instructors;          // list of instructors involved (gonna change data type)
    private LinkedList<Course> courses;                  // list of courses involved
    private LinkedList<TutorialGroup> tutorialGroups;    // list of tutorial groups involved (gonna change data type)

    public Programme() {
    }

    public Programme(String programmeName, String programmeCode, String programmeType ,double programmeFee) {
        this.programmeName = programmeName;
        this.programmeCode = programmeCode;
        this.programmeType = programmeType;
        this.programmeFee = programmeFee;
    }

    
    
    public String getProgrammeName() {
        return programmeName;
    }

    public void setProgrammeName(String programmeName) {
        this.programmeName = programmeName;
    }

    public String getProgrammeCode() {
        return programmeCode;
    }

    public void setProgrammeCode(String programmeCode) {
        this.programmeCode = programmeCode;
    }

    public String getProgrammeType() {
        return programmeType;
    }

    public void setProgrammeType(String programmeType) {
        this.programmeType = programmeType;
    }


    public int getProgrammeDuration() {
        return programmeDuration;
    }

    public void setProgrammeDuration(int programmeDuration) {
        this.programmeDuration = programmeDuration;
    }

    public double getProgrammeFee() {
        return programmeFee;
    }

    public void setProgrammeFee(double programmeFee) {
        this.programmeFee = programmeFee;
    }

    public LinkedList<Course> getCourses() {
        return courses;
    }

    public void setCourses(LinkedList<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Programme{" + "programmeName=" + programmeName + ", programmeCode=" + programmeCode + ", programmeType=" + programmeType + ", programmeDuration=" + programmeDuration + ", programmeFee=" + programmeFee + ", instructors=" + instructors + ", courses=" + courses + ", tutorialGroups=" + tutorialGroups + '}';
    }




    
    
    
    
}
