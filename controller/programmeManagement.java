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
    
    public void searchProgramme(String key, String condition){
        
        switch(condition){
            case "name":
                
                break;
            case "code":
                Predicate<Programme> searchBy = search -> search.getProgrammeCode().equals(key);
                int chkExist = 0;

                for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
                    if (searchBy.test(programmeList.getEntry(i))) {
                        chkExist++;
                        System.out.println("Found matching programme: " + programmeList.getEntry(i));
                    }
                }

                if (chkExist == 0) {
                    System.out.println("No Programme Found !");
                }
                break;
            case "type":
                
                break;
        }
        
        
    }
    
    public void printAll(){
        // idea 1 : parameter = general / detail
        // detail = print all , general = print general point
        
        for(int i=1; i <= programmeList.getNumberOfEntries(); i++){
            System.out.println(programmeList.getEntry(i));
        }
        
    }
    
}
