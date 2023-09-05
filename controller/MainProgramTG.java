/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import client.TutorialGroupUI;
import client.StudentUI;
import client.GeneralUI;
import adt.ArrayList;
import adt.*;
import entity.*;
import java.util.Scanner;
//import assignment.SaveData;

/**
 *
 * @author tqz11
 */
public class MainProgramTG {

    private static ListInterface<Student> StudentList = new ArrayList();
    private static ListInterface<TutorialGroup> TGList = new ArrayList();
    private TutorialGroupUI TGUI = new TutorialGroupUI();
    private StudentUI STUI = new StudentUI();
    private GeneralUI GUI = new GeneralUI();

    Scanner scanner = new Scanner(System.in);

    public MainProgramTG() {
        data();
    }

    public ListInterface<TutorialGroup> getTGList() {
        return TGList;
    }

    public static void main(String[] args) {
        MainProgramTG MainProgramTG = new MainProgramTG();
        MainProgramTG.MainProgramTG();

    }

    protected static void data() {
        StudentList.add(new Student("TAI QI ZHENG", "M", 22));
        StudentList.add(new Student("WONG", "F", 21));
        StudentList.add(new Student("LEE", "M", 24));
        StudentList.add(new Student("HENG", "F", 20));
        TGList.add(new TutorialGroup(1, 2234, StudentList));
    }

    // Tutorial Group menu
    //======================================================
    public void MainProgramTG() {
        int choice = 0;
        do {
            choice = TGUI.TutorialGroupMenuChoice();
            switch (choice) {
                case 0:
                    GUI.exit();
                    break;
                case 1:
                    addNewTutorialGroup();
                    break;
                case 2:
                    removeTutorialGroup();
                    break;
                case 3:
                    TGUI.listAllTutorialGroup(getAllTutorialGroup());
                    break;
                case 4:
                    EditMenu();
                    break;
                case 5:
                    ReportTG();
                    break;
                default:
                    GUI.NTS();
            }
        } while (choice != 0);
    }

    // Edit Menu
    //======================================================
    public void EditMenu() {
        int choice = 0;
        boolean V = false;
        TGUI.listAllTutorialGroup(getAllTutorialGroup());

        do {
            int num = TGUI.inputNoTutorialGroup();

            V = TGList.validation(num);

            if (V == true) {
                String YN = "";
                TGUI.listAllTutorialGroup(getPositionTutorialGroup(num));

                do {
                    choice = GUI.getMenuChoice();
                    switch (choice) {
                        case 0:
                            GUI.exit();
                            break;
                        case 1:
                            // Tutorial Group
                            TGMenu(num);
                            break;
                        case 2:
                            StudentMenu(num);
                            break;
                        default:
                            GUI.NTS();
                    }
                } while (choice != 0);
            } else {
                GUI.DHTG();
            }
        } while (V == false);
    }

    //======================================================
    // Tutorial Group
    //======================================================
    public void TGMenu(int num) {
        int choice = 0;
        do {
            choice = TGUI.whatToEdit();
            TGList.replace(num, TGUI.inputTG(TGList.getEntry(num), choice));
            TGUI.listAllTutorialGroup(getPositionTutorialGroup(num));
        } while (choice != 0);

    }

    public void addNewTutorialGroup() {
        TutorialGroup newTG = TGUI.inputTutorialGroupDetails();
        TGList.add(newTG);
    }

    public void removeTutorialGroup() {

        boolean V = false;

        do {

            TGUI.listAllTutorialGroup(getAllTutorialGroup());
            int num = TGUI.inputNoTutorialGroup();

            V = TGList.validation(num);

            if (V == true) {

                String YN = "";
                TGUI.listAllTutorialGroup(getPositionTutorialGroup(num));
                for (int i = 10; i > 5; i++) {
                    YN = TGUI.inputRemoveTutorialGroup();
                    switch (YN) {
                        case "Y":
                            TGList.remove(num);
                            i = 0;
                            break;
                        case "y":
                            TGList.remove(num);
                            i = 0;
                            break;
                        case "N":
                            i = 0;
                            break;
                        case "n":
                            i = 0;
                            break;
                        default:
                            GUI.RE();
                    }
                }
            } else {
                GUI.DHTG();
            }
        } while (V == false);

    }

    public String getPositionTutorialGroup(int i) {
        String outputStr = "";
        outputStr += String.valueOf(i+1) + TGList.getEntry(i) + "\n";
        return outputStr;
    }

    public String getAllTutorialGroup() {
        String outputStr = "";
        for (int i = 1; i <= TGList.getNumberOfEntries(); i++) {
            outputStr += String.valueOf(i+1) + TGList.getEntry(i) + "\n";
        }
        return outputStr;
    }

    
    
    
    
    // Student menu
    //======================================================
    public void StudentMenu(int num) {
        int choice = 0;
        ListInterface<Student> NewStudent = TGList.getEntry(num).getStudent();
        do {
            choice = STUI.getStudentMenuChoice();
            switch (choice) {
                case 0:
                    GUI.exit();
                    break;
                case 1:
                    //Add student
                    addNewStudent(NewStudent);
                    break;
                case 2:
                    //Remove Student
                    STUI.listAllStudent(getAllStudent(NewStudent));
                    removeStudent(NewStudent);
                    break;
                case 3:
                    //Change Tutorial Group
                    STUI.listAllStudent(getAllStudent(NewStudent));
                    ChangeStudentTutorialGroup(NewStudent);
                    break;
                case 4:
                    //List all Student
                    STUI.listAllStudent(getAllStudent(NewStudent));
                    break;
                default:
                    GUI.NTS();
            }
        } while (choice != 0);
    }

    
    
    //======================================================
    public String getAllStudent(ListInterface<Student> NewStudent) {
        String outputStr = "";
        for (int i = 1; i <= NewStudent.getNumberOfEntries(); i++) {
            outputStr += String.valueOf(i+1) + NewStudent.getEntry(i) + "\n";
        }
        return outputStr;
    }

    public void addNewStudent(ListInterface<Student> NewStudent) {
        Student newStudent = STUI.inputStudentDetails();
        NewStudent.add(newStudent);
    }

    public void removeStudent(ListInterface<Student> NewStudent) {
        boolean V = false;

        do {

            int num = STUI.inputNoStudent();

            V = NewStudent.validation(num);

            if (V == true) {
                String YN = "";
                STUI.printStudentDetails(NewStudent.getEntry(num));
                for (int i = 10; i > 5; i++) {
                    YN = STUI.inputRemoveStudent();
                    switch (YN.toUpperCase()) {
                        case "Y":
                            NewStudent.remove(num);
                            i = 0;
                            break;
                        case "N":
                            i = 0;
                            break;
                        default:
                            GUI.RE();
                    }
                }
            } else {
                GUI.DHS();
            }
        } while (V == false);
    }

    public void ChangeStudentTutorialGroup(ListInterface<Student> NewStudent) {

        boolean V = false;

        do {
            int num = STUI.inputNoStudent();

            V = NewStudent.validation(num);

            if (V == true) {
                String YN = "";
                STUI.printStudentDetails(NewStudent.getEntry(num));
                int numNTG = STUI.inputChangeStudentTutorialGroup();

                ListInterface<Student> NewStudent1 = TGList.getEntry(numNTG).getStudent();

                for (int i = 10; i > 5; i++) {
                    YN = STUI.inputRemoveStudent();
                    switch (YN.toUpperCase()) {
                        case "Y":
                            Student newStudent = NewStudent.getEntry(num);
                            NewStudent1.add(numNTG, newStudent);
                            NewStudent.remove(num);
                            i = 0;
                            break;
                        case "N":
                            i = 0;
                            break;
                        default:
                            GUI.RE();
                    }
                }
            } else {
                GUI.DHS();
            }
        } while (V == false);
    }

    
    
    
    
    //======================================================
    //Report
    //======================================================
    
    public void ReportTG() {
        String G = "";
        String F = "F";
        String M = "M";
        int T = 0;
        int S = 0;
        int NF = 0;
        int NM = 0;
        
        int AGE = 0;
        int AGE1 = 0;
        int AGE2 = 0;
        int AGE3 = 0;
        int AGE4 = 0;
        int AGEAVG = 0;

        for (int i = 1; i <= TGList.getNumberOfEntries(); i++) {
            T++;
            ListInterface<Student> NewStudent = TGList.getEntry(i).getStudent();
            for (int j = 1; j <= NewStudent.getNumberOfEntries(); j++) {
                G = NewStudent.getEntry(j).getStudentGender();
                AGEAVG += NewStudent.getEntry(j).getStudentAge();
                AGE = NewStudent.getEntry(j).getStudentAge();
                
                if(AGE < 20){
                    AGE1++;
                }else if (AGE >= 20 && AGE <= 22){
                    AGE2++;
                }else if (AGE >= 23 && AGE <= 25){
                    AGE3++;
                }else if (AGE >= 26){
                    AGE4++;
                }
                
                if(M.equals(G)){
                    NM++;
                }else if(F.equals(G)){
                    NF++;
                }
                else{
                }
                S++;
            }

        }
        AGEAVG = AGEAVG/S;
        GUI.report(T, S, NF, NM, AGEAVG, AGE1, AGE2, AGE3, AGE4);

    }

}
