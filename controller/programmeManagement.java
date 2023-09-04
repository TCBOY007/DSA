/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import adt.*;
import assignment.*;
import entity.*;
import java.util.function.Predicate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author chook
 */
public class programmeManagement {

    private LinkedListInterface<Programme> programmeList = new LinkedList<>();
    private StackInterface<String> stack = new LinkedStack<>();
    
    private ListInterface<TutorialGroup> tutorialGroupList = new ArrayList<>(); 
    
    MainProgramTG tutorialGroupManage = new MainProgramTG();

    public programmeManagement() {
        initializeData();
    }

    public void initializeData() {
        programmeList.add(new Programme("Diploma in Computer Science", "DCS", "DIPLOMA", 2, 3847.99));
        programmeList.add(new Programme("Diploma in Information", "DIT", "DIPLOMA", 2, 3847.99));
        programmeList.add(new Programme("Diploma in Biology", "DIB", "DIPLOMA", 2, 3847.99));
        programmeList.add(new Programme("Bachelor in Data Science", "RDS", "DEGREE", 3, 35645.55));
        programmeList.add(new Programme("Master in Business", "MIB", "MASTER", 2, 49945.56));
        
        tutorialGroupList = tutorialGroupManage.getTGList();
        
        TutorialGroup tempTutGrp1 = tutorialGroupList.getEntry(1);
        ListInterface<TutorialGroup> tempTutGrpList1 = new ArrayList<>();
        tempTutGrpList1.adddata(tempTutGrp1);
        programmeList.getData(1).setTutorialGroups(tempTutGrpList1);
        
        
        TutorialGroup tempTutGrp2 = tutorialGroupList.getEntry(2);
        ListInterface<TutorialGroup> tempTutGrpList2 = new ArrayList<>();
        tempTutGrpList2.adddata(tempTutGrp2);
        programmeList.getData(2).setTutorialGroups(tempTutGrpList2);
                
    }
    
    public boolean addProgamme(Programme prog) {
        programmeList.add(prog);

        if (programmeList.contains(prog)) {
            return true;
        } else {
            return false;
        }
    }

    public LinkedListInterface<Programme> searchProgramme(String key, String condition) {

        switch (condition) {
            case "name":
                Predicate<Programme> searchByName = search -> search.getProgrammeName().toUpperCase().contains(key);
                LinkedListInterface<Programme> listByName = programmeList.searchByCriteria(searchByName);

                return listByName;
            case "code":
                Predicate<Programme> searchByCode = search -> search.getProgrammeCode().equals(key);
                LinkedListInterface<Programme> listByCode = programmeList.searchByCriteria(searchByCode);                

                return listByCode;
            case "type":
                Predicate<Programme> searchByType = search -> search.getProgrammeType().equals(key);
                LinkedListInterface<Programme> listByType = programmeList.searchByCriteria(searchByType);

                return listByType;
            default:
                LinkedListInterface<Programme> defaultList = new LinkedList<>();

                for (int i = 1; i <= programmeList.getTotalNumberData(); i++) {
                    defaultList.add(programmeList.getData(i));
                }

                return defaultList;
        }

    }

    public void printAll() {
        System.out.printf("%70s\n", "================");
        System.out.printf("%70s\n", "|Programme List|");
        System.out.printf("%70s\n", "================");
        System.out.printf("%-5s %-35s %-20s %-20s %-28s %-20s\n", "", "Programme Name", "Programme Code", "Programme Type", "Programme Duration(Years)", "Programme Fee(RM)");
        System.out.printf("%-5s %-35s %-20s %-20s %-28s %-20s\n", "", "-------------------------", "------------------", "------------------", "-------------------------", "------------------");
        for (int i = 1; i <= programmeList.getTotalNumberData(); i++) {
            Programme tempProg = programmeList.getData(i);
            System.out.printf("[%d] %-1s %-35s %-20s %-20s %-28d %-20.2f\n", i, "", tempProg.getProgrammeName(), tempProg.getProgrammeCode(), tempProg.getProgrammeType(), tempProg.getProgrammeDuration(), tempProg.getProgrammeFee());
        }
        System.out.printf("%-5s %-35s %-20s %-20s %-28s %-20s\n", "", "-------------------------", "------------------", "------------------", "-------------------------", "------------------");

    }

    public void printByParameter(LinkedListInterface<Programme> printList) {
        System.out.printf("%70s\n", "================");
        System.out.printf("%70s\n", "|Programme List|");
        System.out.printf("%70s\n", "================");
        System.out.printf("%-5s %-35s %-20s %-20s %-28s %-20s\n", "", "Programme Name", "Programme Code", "Programme Type", "Programme Duration(Years)", "Programme Fee(RM)");
        System.out.printf("%-5s %-35s %-20s %-20s %-28s %-20s\n", "", "-------------------------", "------------------", "------------------", "-------------------------", "------------------");
        for (int i = 1; i <= printList.getTotalNumberData(); i++) {
            Programme tempProg = printList.getData(i);
            System.out.printf("[%d] %-1s %-35s %-20s %-20s %-28d %-20.2f\n", i, "", tempProg.getProgrammeName(), tempProg.getProgrammeCode(), tempProg.getProgrammeType(), tempProg.getProgrammeDuration(), tempProg.getProgrammeFee());
        }
        System.out.printf("%-5s %-35s %-20s %-20s %-28s %-20s\n", "", "-------------------------", "------------------", "------------------", "-------------------------", "------------------");

    }

    public boolean replaceProgramme(Programme newProgramme, int index) {
        boolean successReplace = false;
        successReplace = programmeList.replace(index, newProgramme);

        return successReplace;
    }

    public boolean removeProgramme(int positionToRemove) {
        boolean sucessfulRemove = false;
        Programme tempProg = programmeList.getData(positionToRemove);
        programmeList.remove(positionToRemove);

        if (!programmeList.contains(tempProg)) {
            sucessfulRemove = true;
        }

        return sucessfulRemove;
    }
    
    public ListInterface<TutorialGroup> getAllTutorialGroupList(){
        return tutorialGroupManage.getTGList();
    }

    public void addHistory(String history){
        
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Create a formatter with the desired format pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        // Format the LocalDateTime object
        String formattedDateTime = currentDateTime.format(formatter);
        
        stack.push(formattedDateTime + "  " + history);
        
    }
    
    public void printHistory(){
        System.out.println("      Timeline                         Action");
        System.out.println("-------------------- ------------------------------------");
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
    
}
