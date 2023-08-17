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
        programmeList.add(new Programme("Diploma in Computer Science","DCS","DIPLOMA",3847.99));
        programmeList.add(new Programme("Bachelor in Data Science", "RDS","DEGREE", 35645.55));
        programmeList.add(new Programme("DIploma in Business", "DAB","DIPLOMA", 3945.56));
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

                for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
                    if (searchByName.test(programmeList.getEntry(i))) {
                        listByName.add(programmeList.getEntry(i));
                    }
                }

                return listByName;
            case "code":
                Predicate<Programme> searchByCode = search -> search.getProgrammeCode().equals(key);
                ListInterface<Programme> listByCode = new LinkedList<>();

                for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
                    if (searchByCode.test(programmeList.getEntry(i))) {
                        listByCode.add(programmeList.getEntry(i));
                    }
                }

                return listByCode;
            case "type":
                Predicate<Programme> searchByType = search -> search.getProgrammeType().equals(key);
                ListInterface<Programme> listByType = new LinkedList<>();

                for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
                    if (searchByType.test(programmeList.getEntry(i))) {
                        listByType.add(programmeList.getEntry(i));
                    }
                }
                return listByType;
            default:
                break;
        }
        
        return null;
    }

    
    public void printAll(){
        // idea 1 : parameter = general / detail
        // detail = print all , general = print general point
        
        for(int i=1; i <= programmeList.getNumberOfEntries(); i++){
            System.out.println(programmeList.getEntry(i));
        }
        
    }
    
}
