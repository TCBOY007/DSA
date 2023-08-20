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
        boolean chkInput;
        
        do{
            
            do{
                
                do{
                    chkInput = true;
                    System.out.println("\n");
                    System.out.println("==========================================");
                    System.out.println("|              PROGRAMMES                |");
                    System.out.println("==========================================");
                    System.out.println("[1] Programmes Details");
                    System.out.println("[2] Tutorial Groups of Programmes");
                    System.out.println("[3] Courses of Programmes Details");
                    System.out.println("[4] Exit");
                    System.out.println("-----------------------------------------");
                    System.out.print("Choice: ");

                    if (scanner.hasNextInt()) {
                        choice = scanner.nextInt();

                        if (choice >= 1 && choice <= 4) {
                            chkInput = false;

                            System.out.println("\n");
                            switch (choice) {
                                case 1:
                                    programmeSubMenu();
                                    break;
                                case 2:
                                    coursesSubMenu();
                                    break;
                                    
                            }

                        } else {
                            System.out.println("Invalid Option! Please try again");
                            betterUI.pauseFor2Second();
                            betterUI.systemCls();
                        }
                    }else{
                        scanner.nextLine();
                        System.out.println("Invalid input! Please enter a valid numerical value.\n");
                    }
                    
                }while(chkInput);
                

                
                
                
            }while(choice < 1 || choice > 4);
        }while(choice != 4);
        

    }
    
    public static void programmeSubMenu(){        
        int choice = 0;
        boolean chkInput;

        do {

            do {
                
                do{
                    chkInput = true;
                    
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

                    if (scanner.hasNextInt()) {
                        choice = scanner.nextInt();

                        // Consume the newline character left in the buffer
                        // after scan int, it will ignore the first coming scan line
                        scanner.nextLine();

                        if (choice >= 1 && choice <= 6) {
                            chkInput = false;
                            System.out.println("\n");
                            switch (choice) {
                                case 1:
                                    addProgramme();
                                    break;
                                case 2:
                                    searchProgramme();
                                    break;
                                case 3:
                                    modifyProgramme();
                                    break;
                                case 4:
                                    listProgramme();
                                    break;
                                case 5:
                                    removeProgramme();
                                    break;

                            }

                        } else {
                            System.out.println("Invalid Option! Please try again");
                            betterUI.pauseFor2Second();
                            betterUI.systemCls();
                        }

                    }else{
                        scanner.nextLine();
                        System.out.println("Invalid input! Please enter a valid numerical value.\n");
                    }
                }while(chkInput);
                

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
                
                if(type >= 1 && type <= 3){
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
                    
                }
                else{
                    System.out.println("Invalid Option! Please try again\n");
                    betterUI.pauseFor2Second();
                }
                
            } else {
                scanner.nextLine();
                System.out.println("Invalid input! Please enter a valid numerical value.\n");
            }
            
        } while (chk);
        
        
        do {
            scanner.nextLine();
            System.out.print("Enter programme duration(years) :");
            int duration;
            if (scanner.hasNextInt()) {
                duration = scanner.nextInt();
                if (duration > 0) {
                    newProg.setProgrammeDuration(duration);
                    chk2 = false;
                    break;
                } else {
                    System.out.println("Invalid input! Please enter a valid numerical value.");

                }

            } else {
                System.out.println("Invalid input! Please enter a valid numerical value.");
            }

        } while (chk2);
        
        
        do {
            scanner.nextLine();
            System.out.print("Enter programme fee :");
            double fee;
            if (scanner.hasNextDouble()) {
                fee = scanner.nextDouble();
                if (fee > 0) {
                    newProg.setProgrammeFee(fee);
                    chk3 = false;
                    break;
                }
                else {
                    System.out.println("Invalid input! Please enter a valid numerical value.");

                }

            } else {
                System.out.println("Invalid input! Please enter a valid numerical value.");
            }

        } while (chk3);
        
        
        
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
        boolean chkInput, chk = true;
        
        do {

            do {
                do{
                    chkInput = true;
                    
                    System.out.println("\n");
                    System.out.println("              Search By             ");
                    System.out.println("------------------------------------");
                    System.out.println("[1] Name");
                    System.out.println("[2] Code");
                    System.out.println("[3] Type");
                    System.out.println("[4] Exit");
                    System.out.println("-------------------------------------");
                    System.out.print("Choice: ");
                    
                    if (scanner.hasNextInt()) {
                        choice = scanner.nextInt();

                        // Consume the newline character left in the buffer
                        // after scan int, it will ignore the first coming scan line
                        scanner.nextLine();

                        if (choice >= 1 && choice <= 4) {
                            chkInput = false;
                            System.out.println("\n");
                            switch (choice) {
                                case 1:
                                    System.out.print("Search by Name: ");
                                    String nameInput = scanner.nextLine();
                                    ListInterface<Programme> listByName = progManage.searchProgramme(nameInput.toUpperCase(), "name");

                                    progManage.printByParameter(listByName);

                                    if (listByName.isEmpty()) {
                                        System.out.println("No Programme !");
                                    }

                                    break;
                                case 2:
                                    System.out.print("Search by Code: ");
                                    String codeInput = scanner.nextLine();
                                    ListInterface<Programme> listByCode = progManage.searchProgramme(codeInput.toUpperCase(), "code");

                                    progManage.printByParameter(listByCode);

                                    if (listByCode.isEmpty()) {
                                        System.out.println("No Programme !");
                                    }
                                    break;
                                case 3:
                                    String typeInput = "";
                                    do {

                                        System.out.println("Enter programme type :");
                                        System.out.println("[1] Diploma [2] Degreee [3] Master");
                                        System.out.println("--------------------------------------");
                                        System.out.print("Choice: ");
                                        if (scanner.hasNextInt()) {
                                            int type = scanner.nextInt();

                                            if (type >= 1 && type <= 3) {
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

                                                chk = false;

                                            } else {
                                                System.out.println("Invalid Option! Please try again\n");
                                                betterUI.pauseFor2Second();
                                            }

                                        } else {
                                            scanner.nextLine();
                                            System.out.println("Invalid input! Please enter a valid numerical value.\n");
                                        }

                                    } while (chk);

                                    ListInterface<Programme> listByType = progManage.searchProgramme(typeInput, "type");

                                    progManage.printByParameter(listByType);

                                    if (listByType.isEmpty()) {
                                        System.out.println("No Programme !");
                                    }
                                    break;

                            }

                        } else {
                            System.out.println("Invalid Option! Please try again");
                            betterUI.pauseFor2Second();
                            betterUI.systemCls();
                        }

                    } else {
                        scanner.nextLine();
                        System.out.println("Invalid input! Please enter a valid numerical value.\n");
                    }
                    
                    
                }while(chkInput);

            } while (choice < 1 || choice > 4);
        } while (choice != 4);
    }
    
    public static void modifyProgramme(){

        int index = 0, choice =0;
        boolean chkInput;
        boolean chkInput2;


                do {
                    chkInput = true;

                    progManage.printAll();
                    System.out.println("\n");
                    System.out.print("Select the index of programme to modify: ");

                    if (scanner.hasNextInt()) {
                        index = scanner.nextInt();
                        chkInput = false;
                        // Consume the newline character left in the buffer
                        // after scan int, it will ignore the first coming scan line
                        scanner.nextLine();
                        
                        if (index >= 1 && index <= progManage.searchProgramme("", "").getNumberOfEntries()) {
                            
                            do{
                                chkInput2 = true;
                                Programme tempProg = progManage.searchProgramme("", "").getEntry(index);
                                
                                
                                do{
                                    do{
                                        
                                        System.out.println("\n");
                                        System.out.printf("%-35s %-20s %-20s %-28s %-20s\n", "Programme Name", "Programme Code", "Programme Type", "Programme Duration(Years)", "Programme Fee");
                                        System.out.printf("%-35s %-20s %-20s %-28s %-20s\n", "-------------------------", "------------------", "------------------", "------------------", "------------------");
                                        System.out.printf("%-35s %-20s %-20s %-28d %-20.2f\n", tempProg.getProgrammeName(), tempProg.getProgrammeCode(), tempProg.getProgrammeType(), tempProg.getProgrammeDuration(), tempProg.getProgrammeFee());
                                        System.out.printf("%-35s %-20s %-20s %-28s %-20s\n", "-------------------------", "------------------", "------------------", "------------------", "------------------");
                                        System.out.println("--------Modify--------");
                                        System.out.println("[1] Programme Name");
                                        System.out.println("[2] Programme Code");
                                        System.out.println("[3] Programme Type");
                                        System.out.println("[4] Programme Duration");
                                        System.out.println("[5] Programme Fee");
                                        System.out.println("[6] Exit");
                                        System.out.println("----------------------");
                                        System.out.print("Choice: ");

                                        if (scanner.hasNextInt()) {
                                            chkInput2 = false;
                                            choice = scanner.nextInt();

                                            // Consume the newline character left in the buffer
                                            // after scan int, it will ignore the first coming scan line
                                            scanner.nextLine();

                                            if (choice >= 1 && choice <= 6) {
                                                switch (choice) {
                                                    case 1:
                                                        System.out.print("Enter new name: ");
                                                        String newName = scanner.nextLine();
                                                        Programme newNameProg = progManage.searchProgramme("", "").getEntry(index);
                                                        newNameProg.setProgrammeName(newName);
                                                        if (progManage.replaceProgramme(newNameProg, index)) {
                                                            betterUI.modifyingScreen();
                                                        }
                                                        break;
                                                    case 2:
                                                        System.out.print("Enter new code: ");
                                                        String newCode = scanner.nextLine();
                                                        Programme newCodeProg = progManage.searchProgramme("", "").getEntry(index);
                                                        newCodeProg.setProgrammeCode(newCode);
                                                        if (progManage.replaceProgramme(newCodeProg, index)) {
                                                            betterUI.modifyingScreen();
                                                        }
                                                        break;
                                                    case 3:
                                                        String typeInput = "";
                                                        boolean chk = true;
                                                        do {

                                                            System.out.println("Enter new programme type :");
                                                            System.out.println("[1] Diploma [2] Degreee [3] Master");
                                                            System.out.println("--------------------------------------");
                                                            System.out.print("Choice: ");
                                                            if (scanner.hasNextInt()) {
                                                                int type = scanner.nextInt();

                                                                if (type >= 1 && type <= 3) {
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

                                                                    chk = false;

                                                                } else {
                                                                    System.out.println("Invalid Option! Please try again\n");
                                                                    betterUI.pauseFor2Second();
                                                                }

                                                            } else {
                                                                scanner.nextLine();
                                                                System.out.println("Invalid input! Please enter a valid numerical value.\n");
                                                            }

                                                        } while (chk);
                                                        Programme newTypeProg = progManage.searchProgramme("", "").getEntry(index);
                                                        newTypeProg.setProgrammeType(typeInput);
                                                        if (progManage.replaceProgramme(newTypeProg, index)) {
                                                            betterUI.modifyingScreen();
                                                        }
                                                        break;
                                                    case 4:
                                                        boolean chk2 = true;
                                                        do {
                                                            System.out.print("Enter new programme duration(years) :");
                                                            int duration;
                                                            if (scanner.hasNextInt()) {
                                                                duration = scanner.nextInt();
                                                                if (duration > 0) {
                                                                    Programme newDurationProg = progManage.searchProgramme("", "").getEntry(index);
                                                                    newDurationProg.setProgrammeDuration(duration);
                                                                    if (progManage.replaceProgramme(newDurationProg, index)) {
                                                                        betterUI.modifyingScreen();
                                                                    }                                                                    
                                                                    chk2 = false;
                                                                    break;
                                                                } else {
                                                                    System.out.println("Invalid input! Please enter a valid numerical value.");

                                                                }

                                                            } else {
                                                                scanner.nextLine();
                                                                System.out.println("Invalid input! Please enter a valid numerical value.");
                                                            }

                                                        } while (chk2);
                                                        break;
                                                    case 5:
                                                        boolean chk3 = true;
                                                        do {
                                                            System.out.print("Enter new programme fee :");
                                                            double fee;
                                                            if (scanner.hasNextDouble()) {
                                                                fee = scanner.nextDouble();
                                                                if (fee > 0) {
                                                                    Programme newFeeProg = progManage.searchProgramme("", "").getEntry(index);
                                                                    newFeeProg.setProgrammeFee(fee);
                                                                    if (progManage.replaceProgramme(newFeeProg, index)) {
                                                                        betterUI.modifyingScreen();
                                                                    }
                                                                    chk3 = false;
                                                                    break;
                                                                } else {
                                                                    System.out.println("Invalid input! Please enter a valid numerical value.");

                                                                }

                                                            } else {
                                                                scanner.nextLine();
                                                                System.out.println("Invalid input! Please enter a valid numerical value.");
                                                            }

                                                        } while (chk3);
                                                        break;
                                                        
                                                }

                                            } else {
                                                System.out.println("Invalid Option! Please try again");
                                                betterUI.pauseFor2Second();
                                                betterUI.systemCls();
                                            }

                                        } else {
                                            scanner.nextLine();
                                            System.out.println("Invalid Option! Please try again");
                                            betterUI.pauseFor2Second();
                                            betterUI.systemCls();
                                        }
                                        
                                        
                                    }while(choice < 1 || choice > 6);
                                }while(choice != 6);
                                

                            }while(chkInput2);
                            
                            
                    } else {
                        scanner.nextLine();
                        System.out.println("Invalid input! Please enter a valid numerical value.\n");
                    }

                }
                    
                }while (chkInput);

    }
    
    public static void listProgramme(){
        progManage.printAll();
    }
    
    public static void removeProgramme(){
        int choice = 0;
        boolean chkInput;

                do {
                    chkInput = true;
                    progManage.printAll();
                    System.out.println("\n");
                    System.out.print("Select the index of programme to delete: ");

                    if (scanner.hasNextInt()) {
                        choice = scanner.nextInt();

                        // Consume the newline character left in the buffer
                        // after scan int, it will ignore the first coming scan line
                        scanner.nextLine();

                        if (choice >= 1 && choice <= progManage.searchProgramme("", "").getNumberOfEntries()) {
                            chkInput = false;
                            System.out.println("\n");
                            
                            Programme tempProg = progManage.searchProgramme("", "").getEntry(choice);
                            System.out.println("Programme to delete: " + tempProg.getProgrammeName());
                            System.out.println("\t[1] Confirm   [0] No");
                            System.out.print("Choice: ");
                            
                            if(scanner.hasNextInt()){
                                int confirmInput = scanner.nextInt();
                                scanner.nextLine();
                                    if (confirmInput == 1) {
                                        
                                        if(progManage.removeProgramme(choice)){
                                            betterUI.modifyingScreen();
                                            System.out.println("Returning back to progrmme menu...");
                                            betterUI.pauseFor2Second();
                                        }
                                        
                                    } else {
                                        System.out.println("No Programme is removed");
                                        System.out.println("Returning back to progrmme menu...");
                                        betterUI.pauseFor2Second();
                                    }
                            }
                            else{
                                System.out.println("No Programme is removed");
                                System.out.println("Returning back to progrmme menu...");
                                betterUI.pauseFor2Second();
                            }

                            
                            

                        } else {
                            System.out.println("Invalid Option! Please try again");
                            betterUI.pauseFor2Second();
                            betterUI.systemCls();
                        }

                    } else {
                        scanner.nextLine();
                        System.out.println("Invalid input! Please enter a valid numerical value.\n");
                    }

                } while (chkInput);


        
        
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
    
    
    
    
}
