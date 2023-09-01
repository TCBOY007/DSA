package controller;

import adt.*;
import entity.*;
import java.util.function.Predicate;

public class Instructor {

    private ListInterface<Tutor> tutorList = new ArrayList<>();
    private StackInterface<String> historyList = new ArrayStack<>();

    public Instructor() {
        initializeTutor();
    }

    public boolean addTutor(Tutor tutor) {
        tutorList.add(tutor);
        if (tutorList.contains(tutor)) {
            return true;
        } else {
            return false;
        }

    }

    public void initializeTutor() {
        tutorList.add(new Tutor("T001", "Moon", "M", "moon@gmail.com", "Master"));
        tutorList.add(new Tutor("T002", "Sunny", "F", "sunny@gmail.com", "PhD"));
        tutorList.add(new Tutor("T003", "TC", "M", "tc@gmail.com", "Bachelor"));
    }

    public Tutor getTutor(int index) {
        return tutorList.getEntry(index);
    }

    public int getTutorListSize() {
        return tutorList.getNumberOfEntries();
    }

    public ListInterface<Tutor> searchTutorByCode(String key) {
        Predicate<Tutor> searchByCode = search -> search.gettCode().equals(key);
        return searchTutor(searchByCode);
    }

    public ListInterface<Tutor> searchTutorByName(String key) {
        Predicate<Tutor> searchByName = search -> search.gettName().toUpperCase().contains(key.toUpperCase());
        return searchTutor(searchByName);
    }

    public ListInterface<Tutor> searchTutorByGender(String key) {
        Predicate<Tutor> searchByType = search -> search.gettGender().equals(key);
        return searchTutor(searchByType);

    }

    public ListInterface<Tutor> searchTutor(Predicate<Tutor> predicate) {
        ListInterface<Tutor> listByName = new ArrayList<>();
        for (int i = 1; i <= tutorList.getNumberOfEntries(); i++) {
            if (predicate.test(tutorList.getEntry(i))) {
                listByName.add(tutorList.getEntry(i));
            }
        }
        return listByName;
    }

    public Tutor returnSpecificTutor(int index) {
        Tutor tutor = new Tutor();
        tutor = tutorList.getEntry(index);
        return tutor;
    }

    public boolean deleteTutor(int index) {
        boolean deleted = false;
        Tutor tempTutor = tutorList.getEntry(index);
        tutorList.remove(index);
        if (!tutorList.contains(tempTutor)) {
            deleted = true;
        }
        return deleted;
    }

    //--------------------------------------------------------------------------
    //History Function
    public boolean addTutorHistory(String newHistory) {
        historyList.push(newHistory);
        return true;
    }

    public String popTutorHistory() {
        return historyList.pop();
    }

    public boolean isEmptyHistory() {
        return historyList.isEmpty();
    }

    public int tutorHistorySize() {
        return historyList.size();
    }

}
