/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class GeneralUI {
    
    Scanner scanner = new Scanner(System.in);
    
    public int getMenuChoice() {
        System.out.println("\nEdit MENU");
        System.out.println("1. Tutorial Group");
        System.out.println("2. Student");
        System.out.println("0. Quit");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
    
    public void exit() {
        System.out.println("\nExiting system!");
    }
    
    public void NTS() {
        System.out.println("\nWe dont have this selection!");
    }
    
    public void RE() {
        System.out.println("Please enter again!");
    }
    
    public void DHTG() {
        System.out.println("\nWe dont have this Tutorial Group!");
    }
    
    public void DHS() {
        System.out.println("\nWe dont have this Student!");
    }
    
    public void report(int T, int S, int NF, int NM, int AGEAVG, int AGE1, int AGE2, int AGE3, int AGE4) {

        
        System.out.println("Report");
        System.out.println("====================");
        System.out.println("The total number of Tutorial Group that we have is : " + T);
        System.out.println("The total number of Student that we have is        : " + S);
        System.out.println("Number of Student that is Female is                : " + NF);
        System.out.println("Number of Student that is Male is                  : " + NM);
        System.out.println("The age of Student that lower than 20 is           : " + AGE1);
        System.out.println("The age of Student that between 20 to 22 is        : " + AGE2);
        System.out.println("The age of Student that between 23 to 25 is        : " + AGE3);
        System.out.println("The age of Student that highest than 25 is         : " + AGE4);
        System.out.println("The average age for the student is                 : " + AGEAVG);
        
    }
    
}
