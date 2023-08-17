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
                System.out.println("[2] Tutorial Groups of Programmes");
                System.out.println("[3] Courses of Programmes Details");
                System.out.println("[4] Intrsuctors of Programmes Details");
                System.out.println("[5] Exit");
                System.out.println("-----------------------------------------");
                System.out.print("Choice: ");
                choice = scanner.nextInt();
                
                if(choice < 1 || choice > 5){
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
                
            }while(choice < 1 || choice > 5);
        }while(choice != 5);
        

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
                        removeProgramme();
                        break;

                }

            } while (choice < 1 || choice > 6);
        } while (choice != 6);
        
    }
    
    public static void addProgramme(){
        Programme newProg = new Programme();
        boolean chk = true;
        boolean chk2 = true;
        boolean chk3 = true;
        
        System.out.print("Enter programme name :");
        newProg.setProgrammeName(scanner.nextLine());
        System.out.print("Enter programme code :");
        newProg.setProgrammeCode(scanner.nextLine().toUpperCase());
        
        do {
            
            System.out.println("Enter programme type :");
            System.out.println("[1] Diploma [2] Degreee [3] Master");
            System.out.println("--------------------------------------");
            System.out.print("Choice: ");
            if (scanner.hasNextInt()) {
                int type = scanner.nextInt();  
                
                if(type <= 1 || type <= 3){
                    String typeInput = "";
                    switch (type) {
                        case 1:
                            typeInput = "DIPLOMA";
                            break;
                        case 2:
                            typeInput = "DEGREE";
                            break;
                        case 3:
                            typeInput = "MASTER";
                            break;
                    }
                    newProg.setProgrammeType(typeInput);

                    chk = false;
                    break;
                }
                else{
                    System.out.println("Invalid Option! Please try again\n");
                }
                
            } else {
                scanner.nextLine();
                System.out.println("Invalid input! Please enter a valid numerical value.\n");
            }
            
        } while (chk);
        
        
        do {
            scanner.nextLine();
            System.out.print("Enter programme duration(years) :");
            if (scanner.hasNextInt()) {
                newProg.setProgrammeDuration(scanner.nextInt());
                chk2 = false;
                break;
            } else {
                System.out.println("Invalid input! Please enter a valid numerical value.");
            }

        } while (chk2);
        
        do{
            scanner.nextLine();
            System.out.print("Enter programme fee :");
            if(scanner.hasNextDouble()){
                newProg.setProgrammeFee(scanner.nextDouble());
                chk3 = false;
                break;
            }else{
                System.out.println("Invalid input! Please enter a valid numerical value.");
            }
            
        }while(chk3);
        
        
        if(progManage.addProgamme(newProg)){
            System.out.println("New Programmed Added Successfully !");
            betterUI.pauseFor2Second();
        }
        else{
            System.out.println("No Programme Added !");
        }
        
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
                        ListInterface<Programme> listByName = progManage.searchProgramme(nameInput.toUpperCase(), "name");
                        
                        System.out.println("Programme Found: ");
                        for(int i=1; i<=listByName.getNumberOfEntries(); i++){
                            System.out.println(listByName.getEntry(i));
                        }
                        
                        if(listByName.isEmpty())
                            System.out.println("No Programme !");
                        
                        break;
                    case 2:
                        System.out.print("Search by Code: ");
                        String codeInput = scanner.nextLine();
                        ListInterface<Programme> listByCode = progManage.searchProgramme(codeInput.toUpperCase(), "code");
                        
                        System.out.println("Programme Found: ");
                        for (int i = 1; i <= listByCode.getNumberOfEntries(); i++) {
                            System.out.println(listByCode.getEntry(i));
                        }
                        
                        if (listByCode.isEmpty())
                            System.out.println("No Programme !");
                        break;
                    case 3:
                        System.out.print("Search by Type: ");
                        System.out.println("[1] Diploma [2] Degreee [3] Master");
                        System.out.println("--------------------------------------");
                        System.out.print("Choice: ");                        
                        int type = scanner.nextInt();
                        
                        String typeInput ="";
                        switch(type){
                            case 1:
                                typeInput = "DIPLOMA";
                                break;
                            case 2:
                                typeInput = "DEGREE";
                                break;
                            case 3:
                                typeInput = "MASTER";
                                break;
                        }
                        
                        ListInterface<Programme> listByType = progManage.searchProgramme(typeInput, "type");
                        
                        System.out.println("Programme Found: ");
                        for (int i = 1; i <= listByType.getNumberOfEntries(); i++) {
                            System.out.println(listByType.getEntry(i));
                        }
                        
                        if (listByType.isEmpty())
                            System.out.println("No Programme !");
                        break;

                }

            } while (choice < 1 || choice > 4);
        } while (choice != 4);
    }
    
    public static void listProgramme(){
        progManage.printAll();
    }
    
    public static void removeProgramme(){
        System.out.println("Select the type of programme:");
        System.out.println("[1] Diploma [2] Degreee [3] Master");
        System.out.println("--------------------------------------");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        
        switch(choice){
            case 1:
                ListInterface<Programme> diplomaList = progManage.searchProgramme("DIPLOMA", "type");
                
                break;
            case 2:
                ListInterface<Programme> degreeList = progManage.searchProgramme("DEGREE", "type");
                
                break;
            case 3:
                ListInterface<Programme> masterList = progManage.searchProgramme("MASTER", "type");
                
                break;
        }
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
