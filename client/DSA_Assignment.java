package dsa_assignment;

import adt.ArrayList;
import adt.ListInterface;
import controller.*;
import entity.Tutor;

public class DSA_Assignment {
    
    private static Instructor instructor = new Instructor();
    private static ListInterface<Tutor> tutorList = new ArrayList<>();
    private static TutorUI tutorUI = new TutorUI(instructor);
    
    
    public void runTutorProgram(){
        int choice = 0;
        do{
            choice = tutorUI.getMenuChoice();
            tutorUI.addToTutorHistory(choice);
            switch(choice){
                case 1:
                    addNewTutor();
                    displayAllTutors();
                    break;
                case 2:
                    deleteTutor();
                    break;
                case 3:
                    searchTutor();
                    break;
                case 4:
                    modifyTutor();
                    break;
                case 5:
                    displayAllTutors();
                    break;
                case 6:
                    listFunctionHistory();
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        }while(choice != 0);
        

    }
    
    
    public static void main(String[] args) {
        DSA_Assignment test = new DSA_Assignment();
        test.runTutorProgram();
    }
    
    public void addNewTutor(){
        Tutor newTutor = tutorUI.inputTutorDetails();
        instructor.addTutor(newTutor);
    }
    
    public void displayAllTutors() {
        tutorUI.listAllTutors();
    }

    public void searchTutor(){
        tutorUI.listAllTutors();
        int condition = tutorUI.searchCondition();
        
        String key;
        ListInterface<Tutor> searchResult = null;
        
        switch(condition){
            case 1: 
                key = tutorUI.keyCode();
                searchResult = instructor.searchTutorByCode(key);
                break;
            case 2:
                key = tutorUI.keyName();
                searchResult = instructor.searchTutorByName(key);
                break;
            case 3:
                key = tutorUI.keyGender();
                searchResult = instructor.searchTutorByGender(key);
                break;
            default:
                System.out.println("Invalid serach Choice");
                break;
                
        }
        
        System.out.println("---The search result---");
        System.out.println(searchResult);
    
    }
   
    public void modifyTutor(){
        
        int rowChoice = tutorUI.modifyRow();
        
        tutorUI.displayTutorDetails(rowChoice);
                        
        int condition = tutorUI.modifyCondition();
        
        Tutor newTutorReplacement = tutorUI.modifyProccessing(condition, rowChoice);
        
        tutorList.replace(condition, newTutorReplacement); 
        System.out.println("");
        
        
    }
    
    public void deleteTutor(){
        int rowDeleted = tutorUI.deleteTutorByRow();
        
        if(rowDeleted == 0){
            System.out.println("Delete Canceled");
        }else{
            System.out.println(instructor.deleteTutor(rowDeleted - 1));
        }
        
    
    }
    
    public void listFunctionHistory(){
        tutorUI.listTutorHistory();

    }
   
    
}
