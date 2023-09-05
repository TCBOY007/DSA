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
 * @author chook zhen yew
 */
public class programmeUI {
    static Scanner scanner = new Scanner(System.in);
    static programmeManagement progManage = new programmeManagement();
        
    public static void programmeMainMenu(){
        
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
                    System.out.println("[3] History Report");
                    System.out.println("[4] Exit");
                    System.out.println("-----------------------------------------");
                    System.out.print("Choice: ");

                    if (scanner.hasNextInt()) {
                        choice = scanner.nextInt();
                        
                        scanner.nextLine();

                        if (choice >= 1 && choice <= 4) {
                            chkInput = false;

                            System.out.println("\n");
                            switch (choice) {
                                case 1:
                                    programmeSubMenu();
                                    break;
                                case 2:
                                    tutGroupSubMenu();
                                    break;
                                case 3:
                                    historyReport();
                                    break;
                            }

                        } else {
                            System.out.print("Invalid Option! Please try again later");
                            betterUI.pauseFor2Second();
                            betterUI.systemCls();
                        }
                    }else{
                        scanner.nextLine();
                        System.out.print("Invalid input! Please enter a valid numerical value later");
                        betterUI.pauseFor2Second();
                        betterUI.systemCls();
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
                            System.out.print("Invalid Option! Please try again later");
                            betterUI.pauseFor2Second();
                            betterUI.systemCls();
                        }

                    }else{
                        scanner.nextLine();
                        System.out.print("Invalid input! Please enter a valid numerical value later");
                        betterUI.pauseFor2Second();
                        betterUI.systemCls();
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
                }
                
            } else {
                scanner.nextLine();
                System.out.println("Invalid input! Please enter a valid numerical value\n");
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
                    System.out.println("Invalid input! Please enter a valid numerical value");

                }

            } else {
                System.out.println("Invalid input! Please enter a valid numerical value");
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
                    System.out.println("Invalid input! Please enter a valid numerical value");

                }

            } else {
                System.out.println("Invalid input! Please enter a valid numerical value");
            }

        } while (chk3);
        
        
        
        if(progManage.addProgamme(newProg)){
            progManage.addHistory("Added new programme (" + newProg.getProgrammeName() + ")");
            betterUI.loadingScreen("Adding");
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
                                    
                                    LinkedListInterface<Programme> listByName = progManage.searchProgramme(nameInput.toUpperCase(), "name");
                                    betterUI.loadingScreen("Searching");
                                    progManage.addHistory("Searched for (" + nameInput +")" + " by progamme name");
                                    
                                    System.out.println("\n");
                                    if (!listByName.isEmpty()) {
                                        progManage.printByParameter(listByName);
                                    }else{
                                        System.out.println("No such Programme !");
                                    }
                                    

                                    break;
                                case 2:
                                    System.out.print("Search by Code: ");
                                    String codeInput = scanner.nextLine();
                                    LinkedListInterface<Programme> listByCode = progManage.searchProgramme(codeInput.toUpperCase(), "code");
                                    betterUI.loadingScreen("Searching");
                                    progManage.addHistory("Searched for (" + codeInput + ")" + " by programme code");
                                    
                                    System.out.println("\n");
                                    if (!listByCode.isEmpty()) {
                                        progManage.printByParameter(listByCode);
                                    } else {
                                        System.out.println("No such Programme !");
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
                                            }

                                        } else {
                                            scanner.nextLine();
                                            System.out.println("Invalid input! Please enter a valid numerical value\n");
                                        }

                                    } while (chk);

                                    LinkedListInterface<Programme> listByType = progManage.searchProgramme(typeInput, "type");
                                    betterUI.loadingScreen("Searching");
                                    progManage.addHistory("Searched for (" + typeInput + ")" + " by progamme type");
                                    
                                    System.out.println("\n");
                                    if (!listByType.isEmpty()) {
                                        progManage.printByParameter(listByType);
                                    } else {
                                        System.out.println("No such Programme !");
                                    }
                                    break;

                            }

                        } else {
                            System.out.print("Invalid Option! Please try again later");
                            betterUI.pauseFor2Second();
                        }

                    } else {
                        scanner.nextLine();
                        System.out.print("Invalid input! Please enter a valid numerical value later");
                        betterUI.pauseFor2Second();
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
                        
                        if (index >= 1 && index <= progManage.searchProgramme("", "").getTotalNumberData()) {
                            
                            do{
                                chkInput2 = true;
                                Programme tempProg = progManage.searchProgramme("", "").getData(index);
                                
                                
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
                                                        Programme newNameProg = progManage.searchProgramme("", "").getData(index);
                                                        String oldName = newNameProg.getProgrammeName();
                                                        newNameProg.setProgrammeName(newName);
                                                        if (progManage.replaceProgramme(newNameProg, index)) {
                                                            betterUI.loadingScreen("Modifying");
                                                            progManage.addHistory("Modified programme name from (" + oldName + ") to new name (" + newName + ")");
                                                            
                                                        }else{
                                                            System.out.println("Modify Failed!");
                                                        }
                                                        break;
                                                    case 2:
                                                        System.out.print("Enter new code: ");
                                                        String newCode = scanner.nextLine();
                                                        Programme newCodeProg = progManage.searchProgramme("", "").getData(index);
                                                        String oldCode = newCodeProg.getProgrammeCode();
                                                        newCodeProg.setProgrammeCode(newCode);
                                                        if (progManage.replaceProgramme(newCodeProg, index)) {
                                                            betterUI.loadingScreen("Modifying");
                                                            progManage.addHistory("Modified programme code of " + newCodeProg.getProgrammeName() + " from (" + oldCode + ") to new code (" + newCode + ")");

                                                        }else {
                                                            System.out.println("Modify Failed!");
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
                                                                }

                                                            } else {
                                                                scanner.nextLine();
                                                                System.out.println("Invalid input! Please enter a valid numerical value\n");
                                                            }

                                                        } while (chk);
                                                        Programme newTypeProg = progManage.searchProgramme("", "").getData(index);
                                                        String oldType = newTypeProg.getProgrammeType();
                                                        newTypeProg.setProgrammeType(typeInput);
                                                        if (progManage.replaceProgramme(newTypeProg, index)) {
                                                            betterUI.loadingScreen("Modifying");
                                                            progManage.addHistory("Modified programme type of " + newTypeProg.getProgrammeName() + " from (" + oldType + ") to new type (" + typeInput + ")");

                                                            
                                                        }else {
                                                            System.out.println("Modify Failed!");
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
                                                                    Programme newDurationProg = progManage.searchProgramme("", "").getData(index);
                                                                    int oldDuration = newDurationProg.getProgrammeDuration();
                                                                    newDurationProg.setProgrammeDuration(duration);
                                                                    if (progManage.replaceProgramme(newDurationProg, index)) {
                                                                        betterUI.loadingScreen("Modifying");
                                                                        progManage.addHistory("Modified programme duration of " + newDurationProg.getProgrammeName() + " from " + oldDuration + " years to " + duration + " years");

                                                                    }else {
                                                                        System.out.println("Modify Failed!");
                                                                    }                                                                    
                                                                    chk2 = false;
                                                                    break;
                                                                } else {
                                                                    System.out.println("Invalid input! Please enter a valid numerical value");

                                                                }

                                                            } else {
                                                                scanner.nextLine();
                                                                System.out.println("Invalid input! Please enter a valid numerical value");
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
                                                                    Programme newFeeProg = progManage.searchProgramme("", "").getData(index);
                                                                    double oldFee = newFeeProg.getProgrammeFee();
                                                                    newFeeProg.setProgrammeFee(fee);
                                                                    if (progManage.replaceProgramme(newFeeProg, index)) {
                                                                        betterUI.loadingScreen("Modifying");
                                                                        progManage.addHistory("Modified programme fee of " + newFeeProg.getProgrammeName() + " from RM" + oldFee+ " to RM" + fee );

                                                                    }else {
                                                                        System.out.println("Modify Failed!");
                                                                    }
                                                                    chk3 = false;
                                                                    break;
                                                                } else {
                                                                    System.out.println("Invalid input! Please enter a valid numerical value");

                                                                }

                                                            } else {
                                                                scanner.nextLine();
                                                                System.out.println("Invalid input! Please enter a valid numerical value");
                                                            }

                                                        } while (chk3);
                                                        break;
                                                        
                                                }

                                            } else {
                                                System.out.print("Invalid Option! Please try again later");
                                                betterUI.pauseFor2Second();
                                                betterUI.systemCls();
                                            }

                                        } else {
                                            scanner.nextLine();
                                            System.out.print("Invalid Option! Please try again later");
                                            betterUI.pauseFor2Second();
                                            betterUI.systemCls();
                                        }
                                        
                                        
                                    }while(choice < 1 || choice > 6);
                                }while(choice != 6);
                                

                            }while(chkInput2);
                            
                            
                    } else {
                        scanner.nextLine();
                        System.out.println("Invalid input! Please enter a valid index\n");
                    }

                }else {
                        scanner.nextLine();
                        System.out.println("Invalid input! Please enter a valid index\n");
                    }
                    
                }while (chkInput);

    }
    
    public static void listProgramme(){
        progManage.addHistory("Listed all progammes");
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

                        if (choice >= 1 && choice <= progManage.searchProgramme("", "").getTotalNumberData()) {
                            chkInput = false;
                            System.out.println("\n");
                            
                            Programme tempProg = progManage.searchProgramme("", "").getData(choice);
                            System.out.println("Programme to delete: " + tempProg.getProgrammeName());
                            System.out.println("\t[1] Confirm   [0] No");
                            System.out.print("Choice: ");
                            
                            if(scanner.hasNextInt()){
                                int confirmInput = scanner.nextInt();
                                scanner.nextLine();
                                    if (confirmInput == 1) {
                                        
                                        if(progManage.removeProgramme(choice)){
                                            progManage.addHistory("Removed programme " + tempProg.getProgrammeName());
                                            betterUI.loadingScreen("Removing");
                                            System.out.print("Returning back to progrmme menu");
                                            betterUI.pauseFor2Second();
                                        }
                                        
                                    } else {
                                        System.out.println("No Programme is removed");
                                        System.out.print("Returning back to progrmme menu");
                                        betterUI.pauseFor2Second();
                                    }
                            }
                            else{
                                scanner.nextLine();
                                System.out.println("No Programme is removed");
                                System.out.print("Returning back to progrmme menu");
                                betterUI.pauseFor2Second();
                            }

                            
                            

                        } else {
                            System.out.print("Invalid Option! Please try again");
                            betterUI.pauseFor2Second();
                        }

                    } else {
                        scanner.nextLine();
                        System.out.print("Invalid input! Please enter a valid numerical value");
                        betterUI.pauseFor2Second();
                    }

                } while (chkInput);


        
        
    }
    
    
    
    public static void tutGroupSubMenu() {
        int choice = 0;
        boolean chkInput;

        do {

            do {
                
                do{
                    chkInput = true;
                    
                    System.out.println("\n");
                    System.out.println("          Tutorial Groups           ");
                    System.out.println("------------------------------------");
                    System.out.println("[1] Add Tutorial Group to a Programme");
                    System.out.println("[2] Remove Tutorial Group from a Programme");
                    System.out.println("[3] List Tutorial Group for a Programme");
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
                                    addTutGroupToProgramme();
                                    break;
                                case 2:
                                    removeTutGroupFromProgramme();
                                    break;
                                case 3:
                                    listTutGroupForProgramme();
                                    break;

                            }

                        } else {
                            System.out.print("Invalid Option! Please try again");
                            betterUI.pauseFor2Second();
                            betterUI.systemCls();
                        }

                    }else{
                        scanner.nextLine();
                        System.out.println("Invalid input! Please enter a valid numerical value\n");
                    }
                }while(chkInput);
                

            } while (choice < 1 || choice > 4);
        } while (choice != 4);
        
        
    }
    
    public static void addTutGroupToProgramme(){
        
        int index = 0, choice =0;
        boolean chkInput;
        boolean chkInput2;


                do {
                    chkInput = true;

                    progManage.printAll();
                    System.out.println("\n");
                    System.out.print("Select the index of programme to add tutorial group: ");

                    if (scanner.hasNextInt()) {
                        index = scanner.nextInt();
                        chkInput = false;
                        // Consume the newline character left in the buffer
                        // after scan int, it will ignore the first coming scan line
                        scanner.nextLine();
                        
                        if (index >= 1 && index <= progManage.searchProgramme("", "").getTotalNumberData()) {
                            
                            do{
                                chkInput2 = true;
                                Programme tempProg = progManage.searchProgramme("", "").getData(index);
                                ListInterface<TutorialGroup> tempTGList = progManage.getAllTutorialGroupList();
                                
                                if(tempProg.getTutorialGroups().getNumberOfEntries() != tempTGList.getNumberOfEntries()){
                                    do {

                                        System.out.println("\n");
                                        System.out.println("==========================================================");
                                        System.out.println("Programe selected: " + tempProg.getProgrammeName());
                                        System.out.println("==========================================================");
                                        System.out.println("The available tutorial group for current programme to add: ");

                                        for (int i = 1; i <= tempTGList.getNumberOfEntries(); i++) {
                                            //!tempTGList.getEntry(i).equals(tempProg.getTutorialGroups().getEntry(i))
                                            if (!tempProg.getTutorialGroups().contains(tempTGList.getEntry(i))) {
                                                System.out.println("[" + i + "]");
                                                System.out.println(tempTGList.getEntry(i));
                                            }

                                        }

                                        System.out.println("----------------------");
                                        System.out.print("Tutorial group index: ");

                                        if (scanner.hasNextInt()) {
                                            chkInput2 = false;
                                            choice = scanner.nextInt();

                                            // Consume the newline character left in the buffer
                                            // after scan int, it will ignore the first coming scan line
                                            scanner.nextLine();

                                            if (choice >= 1 && choice <= tempTGList.getNumberOfEntries()) {
                                                TutorialGroup tempTG = tempTGList.getEntry(choice);

                                                if (progManage.addTutGrpToProg(tempProg, tempTG)) {
                                                    progManage.addHistory("Added new tutorial group (id = " + tempTGList.getEntry(choice).getTutorialGroupID() + ") to programme (" + tempProg.getProgrammeName() + ")");
                                                    betterUI.loadingScreen("Adding");
                                                } else {
                                                    System.out.println("No tutorial group was added as choice selected was existed in the programme");
                                                }

                                            } else {

                                                System.out.print("Invalid Input! Please try again later");
                                                betterUI.pauseFor2Second();
                                                betterUI.systemCls();
                                            }

                                        } else {
                                            scanner.nextLine();
                                            System.out.print("Invalid Input! Please try again later");
                                            betterUI.pauseFor2Second();
                                            betterUI.systemCls();
                                        }

                                    } while (choice < 1 || choice > tempTGList.getNumberOfEntries());
                                }
                                else{
                                    chkInput2 = false;
                                    System.out.println("All tutorial groups existed in current programme");
                                }
                                
                                

                                

                            }while(chkInput2);
                            
                            
                    } else {
                        
                        System.out.println("Invalid option! Please enter a valid index\n");
                    }

                }else {
                        scanner.nextLine();
                        System.out.println("Invalid input! Please enter a valid index\n");
                    }
                    
                }while (chkInput);
    }
    
    public static void removeTutGroupFromProgramme(){
        
        int index = 0, choice = 0;
        boolean chkInput;
        boolean chkInput2;

        do {
            chkInput = true;

            progManage.printAll();
            System.out.println("\n");
            System.out.print("Select the index of programme to remove tutorial group: ");

            if (scanner.hasNextInt()) {
                index = scanner.nextInt();
                chkInput = false;
                // Consume the newline character left in the buffer
                // after scan int, it will ignore the first coming scan line
                scanner.nextLine();

                if (index >= 1 && index <= progManage.searchProgramme("", "").getTotalNumberData()) {

                    do {
                        chkInput2 = true;
                        Programme tempProg = progManage.searchProgramme("", "").getData(index);
                        ListInterface<TutorialGroup> tempTGList = progManage.getAllTutorialGroupList();

                        
                        
                        if(tempProg.getTutorialGroups().getNumberOfEntries() != 0){
                            do {

                                System.out.println("\n");
                                System.out.println("==========================================================");
                                System.out.println("Programe selected: " + tempProg.getProgrammeName());
                                System.out.println("==========================================================");
                                System.out.println("The available tutorial group for current programme to remove: ");

                                for (int i = 1; i <= tempTGList.getNumberOfEntries(); i++) {
                                    if (tempProg.getTutorialGroups().contains(tempTGList.getEntry(i))) {
                                        System.out.println("[" + i + "]");
                                        System.out.println(tempTGList.getEntry(i));
                                    }

                                }

                                System.out.println("----------------------");
                                System.out.print("Tutorial group index: ");

                                if (scanner.hasNextInt()) {
                                    chkInput2 = false;
                                    choice = scanner.nextInt();

                                    // Consume the newline character left in the buffer
                                    // after scan int, it will ignore the first coming scan line
                                    scanner.nextLine();

                                    if (choice >= 1 && choice <= tempTGList.getNumberOfEntries()) {
                                        TutorialGroup tempTG = tempTGList.getEntry(choice);

                                        if (progManage.removeTutGrpFromProg(tempProg, choice)) {
                                            //tempProg.getTutorialGroups().remove(choice);

                                            progManage.addHistory("Remove tutorial group (id = " + tempTGList.getEntry(choice).getTutorialGroupID() + ") from programme (" + tempProg.getProgrammeName() + ")");
                                            betterUI.loadingScreen("Removing");
                                        } else {
                                            System.out.println("No tutorial group was removed");
                                        }

                                    } else {

                                        System.out.print("Invalid Input! Please try again later");
                                        betterUI.pauseFor2Second();
                                        betterUI.systemCls();
                                    }

                                } else {
                                    scanner.nextLine();
                                    System.out.print("Invalid Input! Please try again later");
                                    betterUI.pauseFor2Second();
                                    betterUI.systemCls();
                                }

                            } while (choice < 1 || choice > tempTGList.getNumberOfEntries());
                        }
                        else{
                            chkInput2 = false;
                            System.out.println("Current programme has no tutorial group to remove");
                        }
                        
                        
                        

                    } while (chkInput2);

                } else {
                    scanner.nextLine();
                    System.out.println("Invalid option! Please enter a valid index\n");
                }

            } else {
                scanner.nextLine();
                System.out.println("Invalid input! Please enter a valid index\n");
            }

        } while (chkInput);
    }
    
    public static void listTutGroupForProgramme(){
        
        LinkedListInterface<Programme> tempProgList = progManage.searchProgramme("", "");
          
        
        int index = 0;
        boolean chkInput;

        do {
            chkInput = true;

            progManage.printAll();
            System.out.println("\n");
            System.out.print("Select the index of programme to show tutorial group: ");

            if (scanner.hasNextInt()) {
                index = scanner.nextInt();
                chkInput = false;
                // Consume the newline character left in the buffer
                // after scan int, it will ignore the first coming scan line
                scanner.nextLine();

                if (index >= 1 && index <= progManage.searchProgramme("", "").getTotalNumberData()) {
                        Programme tempProg = progManage.searchProgramme("", "").getData(index);


                            System.out.println("\n");
                            System.out.println("==========================================================");
                            System.out.println("Programe selected: " + tempProg.getProgrammeName());
                            System.out.println("==========================================================");
                            System.out.println("The tutorial group for current programme: ");

                            
                            if(tempProg.getTutorialGroups().getNumberOfEntries() == 0){
                                System.out.println("\tThis programme currently has no tutorial groups");
                                
                            }else{
                                for (int i = 1; i <= tempProg.getTutorialGroups().getNumberOfEntries(); i++) {
                                    System.out.println("[" + i + "]");
                                    System.out.println(tempProg.getTutorialGroups().getEntry(i));

                                }

                                progManage.addHistory("Listing tutorial groups for programme (" + tempProg.getProgrammeName() + ")");
                            }
                           


                } else {
                    scanner.nextLine();
                    System.out.println("Invalid option! Please enter a valid index\n");
                }

            } else {
                scanner.nextLine();
                System.out.println("Invalid input! Please enter a valid index\n");
            }

        } while (chkInput);
    }
    
    
    public static void historyReport(){
        progManage.printHistory();
    }
    
}
