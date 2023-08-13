/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author chook zhen yew
 */
public class programme {
    private String programmeName;   
    private String programmeCode;
    private String programmeType;           // eg diploma / degree / master
    private String programmeDescription;    // not so necessary, considering
    private int programmeDuration;          // in terms of year
    private double programmeFee;            // 2 decimal place
    
    private instructor[] instructors;          // list of instructors involved
    private course[] courses;                  // list of courses involved
    private tutorialGroup[] tutorialGroups;    // list of tutorial groups involved

    
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

    public String getProgrammeDescription() {
        return programmeDescription;
    }

    public void setProgrammeDescription(String programmeDescription) {
        this.programmeDescription = programmeDescription;
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

    public instructor[] getInstructors() {
        return instructors;
    }

    public void setInstructors(instructor[] instructors) {
        this.instructors = instructors;
    }

    public course[] getCourses() {
        return courses;
    }

    public void setCourses(course[] courses) {
        this.courses = courses;
    }

    public tutorialGroup[] getTutorialGroups() {
        return tutorialGroups;
    }

    public void setTutorialGroups(tutorialGroup[] tutorialGroups) {
        this.tutorialGroups = tutorialGroups;
    }
    
    
    
    
}
