/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import entity.*;
import adt.*;
import controller.*;
import betterUI.*;
import java.util.Scanner;

/**
 *
 * @author chook
 */
public class programmeUI {
    static Scanner scanner = new Scanner(System.in);
    static programmeManagement progManage = new programmeManagement();
        
    public static void programmeMainMenu(){
        progManage.initializeData();
        int choice =0;
        
        do{
            
            do{
                System.out.println("\n");
                System.out.println("==========================================");
                System.out.println("|              PROGRAMMES                |");
                System.out.println("==========================================");
                System.out.println("[1] Programmes Details");
                System.out.println("[2] Courses of Programmes Details");
                System.out.println("[3] Intrsuctors of Programmes Details");
                System.out.println("[4] Exit");
                System.out.println("-----------------------------------------");
                System.out.print("Choice: ");
                choice = scanner.nextInt();
                
                if(choice < 1 || choice > 4){
                    System.out.println("Invalid Option! Please try again");
                    betterUI.pauseFor2Second();
                    betterUI.systemCls();
                }
                
                System.out.println("\n");
                switch(choice){
                    case 1:
                        programmeSubMenu();
                        break;
                    case 2:
                        coursesSubMenu();
                        break;
                    case 3:
                        instructorsSubMenu();
                        break;
                    
                }
                
            }while(choice < 1 || choice > 4);
        }while(choice != 4);
        

    }
    
    public static void programmeSubMenu(){        
        int choice = 0;

        do {

            do {
                System.out.println("\n");
                System.out.println("     PROGRAMME");
                System.out.println("----------------------");
                System.out.println("[1] Add Programme");
                System.out.println("[2] Search Programme");
                System.out.println("[3] Modify Programme");
                System.out.println("[4] List Programme");
                System.out.println("[5] Remove Programme");
                System.out.println("[6] Exit");
                System.out.println("----------------------");
                System.out.print("Choice: ");
                choice = scanner.nextInt();
                
                // Consume the newline character left in the buffer
                // after scan int, it will ignore the first coming scan line
                scanner.nextLine();

                if (choice < 1 || choice > 6) {
                    System.out.println("Invalid Option! Please try again");
                    betterUI.pauseFor2Second();
                    betterUI.systemCls();
                }

                System.out.println("\n");
                switch (choice) {
                    case 1:
                        addProgramme();
                        break;
                    case 2:
                        searchProgramme();
                        break;
                    case 3:
                        
                        break;
                    case 4:
                        listProgramme();
                        break;
                    case 5:
                        
                        break;

                }

            } while (choice < 1 || choice > 6);
        } while (choice != 6);
        
    }
    
    public static void addProgramme(){
        Programme newProg = new Programme();
        boolean chk = true;
        boolean chk2 = true;
        
        System.out.print("Enter programme name :");
        newProg.setProgrammeName(scanner.nextLine());
        System.out.print("Enter programme code :");
        newProg.setProgrammeCode(scanner.nextLine().toUpperCase());
        System.out.print("Enter programme type :");
        newProg.setProgrammeType(scanner.nextLine().toUpperCase());
        
        do {
            System.out.print("Enter programme duration(Years) :");
            if (scanner.hasNextInt()) {
                newProg.setProgrammeDuration(scanner.nextInt());
                chk = false;
                break;
            } else {
                scanner.nextLine();
                System.out.println("Invalid input! Please enter a valid numerical value.");
            }

        } while (chk);
        
        do{
            System.out.print("Enter programme fee :");
            if(scanner.hasNextDouble()){
                newProg.setProgrammeFee(scanner.nextDouble());
                chk2 = false;
                break;
            }else{
                scanner.nextLine();
                System.out.println("Invalid input! Please enter a valid numerical value.");
            }
            
        }while(chk2);
        
        
        System.out.println(progManage.addProgamme(newProg));
        
    }
    
    public static void searchProgramme(){
        int choice = 0;
        
        do {

            do {
                System.out.println("\n");
                System.out.println("              Search By             ");
                System.out.println("------------------------------------");
                System.out.println("[1] Name");
                System.out.println("[2] Code");
                System.out.println("[3] Type");
                System.out.println("[4] Exit");
                System.out.println("-------------------------------------");
                System.out.print("Choice: ");
                choice = scanner.nextInt();
                
                // Consume the newline character left in the buffer
                // after scan int, it will ignore the first coming scan line
                scanner.nextLine();

                if (choice < 1 || choice > 4) {
                    System.out.println("Invalid Option! Please try again");
                    betterUI.pauseFor2Second();
                    betterUI.systemCls();
                }

                System.out.println("\n");
                switch (choice) {
                    case 1:
                        System.out.print("Search by Name: ");
                        String nameInput = scanner.nextLine();
                        progManage.searchProgramme(nameInput.toUpperCase(), "name");
                        break;
                    case 2:
                        System.out.print("Search by Code: ");
                        String codeInput = scanner.nextLine();
                        progManage.searchProgramme(codeInput.toUpperCase(), "code");
                        break;
                    case 3:
                        System.out.print("Search by Type: ");
                        String typeInput = scanner.nextLine();
                        progManage.searchProgramme(typeInput.toUpperCase(), "code");
                        break;

                }

            } while (choice < 1 || choice > 4);
        } while (choice != 4);
    }
    
    public static void listProgramme(){
        progManage.printAll();
    }
    
    public static void coursesSubMenu() {
        int choice = 0;

        do {

            do {
                System.out.println("\n");
                System.out.println("              Courses               ");
                System.out.println("------------------------------------");
                System.out.println("[1] Add Courses to a Programme");
                System.out.println("[2] Remove Courses from a Programme");
                System.out.println("[3] List Courses for a Programme");
                System.out.println("[4] Exit");
                System.out.println("-------------------------------------");
                System.out.print("Choice: ");
                choice = scanner.nextInt();
                
                // Consume the newline character left in the buffer
                // after scan int, it will ignore the first coming scan line
                scanner.nextLine();

                if (choice < 1 || choice > 4) {
                    System.out.println("Invalid Option! Please try again");
                    betterUI.pauseFor2Second();
                    betterUI.systemCls();
                }

                System.out.println("\n");
                switch (choice) {
                    case 1:
                        
                        break;
                    case 2:
                        
                        break;
                    case 3:
                        
                        break;

                }

            } while (choice < 1 || choice > 4);
        } while (choice != 4);
        
    }
    
    public static void instructorsSubMenu() {        
        int choice = 0;

        do {

            do {
                System.out.println("\n");
                System.out.println("             Instructors            ");
                System.out.println("------------------------------------");
                System.out.println("[1] Add Instructors to a Programme");
                System.out.println("[2] Remove Instructors from a Programme");
                System.out.println("[3] List Instructors for a Programme");
                System.out.println("[4] Exit");
                System.out.println("-------------------------------------");
                System.out.print("Choice: ");
                choice = scanner.nextInt();
                
                // Consume the newline character left in the buffer
                // after scan int, it will ignore the first coming scan line
                scanner.nextLine();

                if (choice < 1 || choice > 4) {
                    System.out.println("Invalid Option! Please try again");
                    betterUI.pauseFor2Second();
                    betterUI.systemCls();
                }

                System.out.println("\n");
                switch (choice) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;

                }

            } while (choice < 1 || choice > 4);
        } while (choice != 4);
        
    }
}
