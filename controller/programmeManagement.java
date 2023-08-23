/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import adt.*;
import entity.*;
import java.util.function.Predicate;

/**
 *
 * @author chook
 */
public class programmeManagement {
    
    private ListInterface<Programme> programmeList = new LinkedList<>();

    public programmeManagement() {
    }
    
    public void initializeData(){
        programmeList.add(new Programme("Diploma in Computer Science","DCS","DIPLOMA",2,3847.99));
        programmeList.add(new Programme("Diploma in Information", "DIT", "DIPLOMA", 2, 3847.99));
        programmeList.add(new Programme("Diploma in Biology", "DIB", "DIPLOMA", 2, 3847.99));
        programmeList.add(new Programme("Bachelor in Data Science", "RDS","DEGREE", 3,35645.55));
        programmeList.add(new Programme("Master in Business", "MIB","MASTER",2, 49945.56));
    }

    public boolean addProgamme(Programme prog){
        programmeList.add(prog);
        
        if(programmeList.contains(prog))
                return true;
        else
            return false;
    }
    
    public ListInterface<Programme> searchProgramme(String key, String condition) {
        
        switch (condition) {
            case "name":
                Predicate<Programme> searchByName = search -> search.getProgrammeName().toUpperCase().contains(key);
                ListInterface<Programme> listByName = new LinkedList<>();
                
                for (int i = 1; i <= programmeList.getTotalNumberData(); i++) {
                    if (searchByName.test(programmeList.getData(i))) {
                        listByName.add(programmeList.getData(i));
                    }
                }

                return listByName;
            case "code":
                Predicate<Programme> searchByCode = search -> search.getProgrammeCode().equals(key);
                ListInterface<Programme> listByCode = new LinkedList<>();

                for (int i = 1; i <= programmeList.getTotalNumberData(); i++) {
                    if (searchByCode.test(programmeList.getData(i))) {
                        listByCode.add(programmeList.getData(i));
                    }
                }

                return listByCode;
            case "type":
                Predicate<Programme> searchByType = search -> search.getProgrammeType().equals(key);
                ListInterface<Programme> listByType = new LinkedList<>();

                for (int i = 1; i <= programmeList.getTotalNumberData(); i++) {
                    if (searchByType.test(programmeList.getData(i))) {
                        listByType.add(programmeList.getData(i));
                    }
                }
                return listByType;
            default:
                ListInterface<Programme> defaultList = new LinkedList<>();

                for (int i = 1; i <= programmeList.getTotalNumberData(); i++) {
                        defaultList.add(programmeList.getData(i));
                    }
                
                return defaultList;
                }
                 
        }
        
    

    public void printAll(){
        System.out.printf("%70s\n","================");
        System.out.printf("%70s\n","|Programme List|");
        System.out.printf("%70s\n","================");
        System.out.printf("%-5s %-35s %-20s %-20s %-28s %-20s\n", "","Programme Name", "Programme Code", "Programme Type", "Programme Duration(Years)", "Programme Fee");
        System.out.printf("%-5s %-35s %-20s %-20s %-28s %-20s\n", "","-------------------------", "------------------", "------------------", "------------------", "------------------");
        for (int i = 1; i <= programmeList.getTotalNumberData(); i++) {
            Programme tempProg = programmeList.getData(i);
            System.out.printf("[%d] %-1s %-35s %-20s %-20s %-28d %-20.2f\n", i, "", tempProg.getProgrammeName(), tempProg.getProgrammeCode(), tempProg.getProgrammeType(), tempProg.getProgrammeDuration(), tempProg.getProgrammeFee());
        }
        System.out.printf("%-5s %-35s %-20s %-20s %-28s %-20s\n", "", "-------------------------", "------------------", "------------------", "------------------", "------------------");

    }
    
    public void printByParameter(ListInterface<Programme> printList){
        System.out.printf("%70s\n", "================");
        System.out.printf("%70s\n", "|Programme List|");
        System.out.printf("%70s\n", "================");
        System.out.printf("%-5s %-35s %-20s %-20s %-28s %-20s\n", "","Programme Name", "Programme Code", "Programme Type", "Programme Duration(Years)", "Programme Fee");
        System.out.printf("%-5s %-35s %-20s %-20s %-28s %-20s\n", "","-------------------------", "------------------", "------------------", "------------------", "------------------");
        for (int i = 1; i <= printList.getTotalNumberData(); i++) {
            Programme tempProg = printList.getData(i);
            System.out.printf("[%d] %-1s %-35s %-20s %-20s %-28d %-20.2f\n", i,"",tempProg.getProgrammeName(), tempProg.getProgrammeCode(), tempProg.getProgrammeType(), tempProg.getProgrammeDuration(), tempProg.getProgrammeFee());
        }
        System.out.printf("%-5s %-35s %-20s %-20s %-28s %-20s\n", "", "-------------------------", "------------------", "------------------", "------------------", "------------------");

    }
    
    public boolean replaceProgramme(Programme newProgramme, int index){
        boolean successReplace = false;
        successReplace = programmeList.replace(index, newProgramme);
        
        return successReplace;
    }
    
    public boolean removeProgramme(int positionToRemove){
        boolean sucessfulRemove = false;
        Programme tempProg = programmeList.getData(positionToRemove);
        programmeList.remove(positionToRemove);
        
        if(!programmeList.contains(tempProg)){
            sucessfulRemove = true;
        }
        
        return sucessfulRemove;
    }
    
}
