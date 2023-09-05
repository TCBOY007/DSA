/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import adt.ListInterface;
/**
 *
 * @author tqz11
 */
public class TutorialGroup {

    private int tutorialGroupName;
    private int tutorialGroupID;
    private ListInterface<Student> student;

    public TutorialGroup(int tutorialGroupName, int tutorialGroupID, ListInterface<Student> student) {
        this.tutorialGroupName = tutorialGroupName;
        this.tutorialGroupID = tutorialGroupID;
        this.student = student;
    }

    public TutorialGroup() {
    }

    public int getTutorialGroupName() {
        return tutorialGroupName;
    }

    public void setTutorialGroupName(int tutorialGroup) {
        this.tutorialGroupName = tutorialGroup;
    }

    public int getTutorialGroupID() {
        return tutorialGroupID;
    }

    public void setTutorialGroupID(int tutorialGroupID) {
        this.tutorialGroupID = tutorialGroupID;
    }

    public ListInterface<Student> getStudent() {
        return student;
    }

    public void setStudent(ListInterface<Student> student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return " TutorialGroup\n" + "Tutorial Group Name :" + tutorialGroupName + "\nTutorial Group ID :" + tutorialGroupID + "\nStudents: \n" + student;
    }

}
