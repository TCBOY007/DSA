/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
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
public class TutorialGroupUI {

    Scanner scanner = new Scanner(System.in);
    private StudentUI STUI = new StudentUI();
    
      
//=====================================================================================
// Main menu
//=====================================================================================
    public int TutorialGroupMenuChoice() {
        int choice;

        do {
            TGM();
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("Pleas Enter again! \"%s\" is not a valid number.%n", input);
                TGM();
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
        } while (choice < 0);
        return choice;
    }
    
    public void TGM() {
        System.out.println("\nTutorial Group MENU");
        System.out.println("1. Add Tutorial Group");
        System.out.println("2. Remove Tutorial Group");
        System.out.println("3. List All Tutorial Group");
        System.out.println("4. Edit Tutorial Group");
        System.out.println("5. Report");
        System.out.println("0. Quit");
        System.out.print("Enter choice: ");
    }
//=====================================================================================
//=====================================================================================
    
    
    
//=====================================================================================
// To add tutorial group and get student information
//=====================================================================================
    public int inputTutorialGroupName() {
        int name;
        
        do {
            System.out.print("Enter Tutorial Group name (ex:'1') : ");
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("Pleas Enter again! \"%s\" is not a valid number.%n", input);
                System.out.print("\nEnter Tutorial Group name (ex:'1') : ");
            }
            name = scanner.nextInt();
        } while (name < 0);
        return name;
    }

    public int inputTutorialGroupID() {
        int id;
        
        do {
            System.out.print("Enter Tutorial Group ID (ex:'1234'): ");
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("Pleas Enter again! \"%s\" is not a valid number.%n", input);
                System.out.print("\nEnter Tutorial Group ID (ex:'1234'): ");
            }
            id = scanner.nextInt();
        } while (id < 0);
        return id;
    }

    public TutorialGroup inputTutorialGroupDetails() {
        TutorialGroup TG = new TutorialGroup();
        int TGName = inputTutorialGroupName();
        int TGID = inputTutorialGroupID();
        ListInterface<Student> student = new ArrayList();
        
        for (int i = 10; i > 5; i++) {
            String YN = STUI.inputAddStudent();
            switch (YN.toUpperCase()) {
                case "Y":
                    student.add(STUI.inputStudentDetails());
                    //i = 0;
                    System.out.print("Sucess !!!\n");
                    break;
                case "N":
                    i = 0;
                    break;
                default:
                    System.out.println("Please enter again!");
            }
        }

        System.out.println();
        return new TutorialGroup(TGName,TGID,student);
    }
//=====================================================================================
//=====================================================================================
    
    
    
    
// List all Tutorial Group
    public void listAllTutorialGroup(String outputStr) {
        System.out.println("\nList of Tutorial Group:");
        System.out.println(outputStr);
        
    }

    
    
// Get no of the student to remove student
//=====================================================================================
    public int inputNoTutorialGroup() {
        System.out.print("Enter no of the tutorial group that want to chose: ");
        int num = scanner.nextInt();
        scanner.nextLine();
        return num;
    }

// Get the result of either remove student or not remove it
//=====================================================================================
    public String inputRemoveTutorialGroup() {
        System.out.print("Enter (Y/y) to remove Tutorial Group or (N/n) to cancel : ");
        String yORn = scanner.nextLine();
        return yORn;
    }

// Edit Function
//=====================================================================================
    
    public int whatToEdit() {
        int choice;

        do {
            WTE();
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("Pleas Enter again! \"%s\" is not a valid number.%n", input);
                WTE();
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
        } while (choice < 0);

        return choice;
    }
    public void WTE() {
        System.out.println("\nTutorial Group Edit");
        System.out.println("1. Tutorial Group Name");
        System.out.println("2. Tutorial Group ID");
        System.out.println("0. Quit");
        System.out.print("Enter choice: ");
    }
    
    

    public int changeTutorialGroupName(){
        int name;
        do {
            System.out.print("Enter New Tutorial Group name (ex:'1') : ");
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("Pleas Enter again! \"%s\" is not a valid number.%n", input);
                System.out.print("\nEnter Tutorial Group name (ex:'1') : ");
            }
            name = scanner.nextInt();
        } while (name < 0);
        return name;
    }

    public int changeTutorialGroupID() {
        int id;
        do {
            System.out.print("Enter New Tutorial Group ID (ex:'1234'): ");
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("Pleas Enter again! \"%s\" is not a valid number.%n", input);
                System.out.print("\nEnter Tutorial Group ID (ex:'1234'): ");
            }
            id = scanner.nextInt();
        } while (id < 0);
        return id;
    }    
    
    public void printTutorialGroupDetails(TutorialGroup TG) {
        System.out.println("\n");
        System.out.println("Tutorial Group Details");
        System.out.println("Tutorial Gtoup Name:" + TG.getTutorialGroupName());
        System.out.println("Tutorial Group ID:" + TG.getTutorialGroupID());
        System.out.println("\n");
    }

    public TutorialGroup inputTG(TutorialGroup TG, int num) {
        
        int name = 0;
        int id = 0;
        ListInterface<Student> NewStudent = TG.getStudent();
        
        if (num == 1){
            name = changeTutorialGroupName();
            id = TG.getTutorialGroupID();
            
        }else if (num == 2){
            name = TG.getTutorialGroupName();
            id = changeTutorialGroupID();
        }else if (num == 0) {
            name = TG.getTutorialGroupName();
            id = TG.getTutorialGroupID();
            System.out.println("\nExiting system!");
        }else{
            System.out.println("\nWe dont have this selection!");
        }
        

        System.out.println();
        return new TutorialGroup(name, id, NewStudent);
    }

}
