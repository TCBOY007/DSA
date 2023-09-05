package controller;

import entity.Tutor;
import java.util.Scanner;

public class TutorUI {

    Scanner scanner = new Scanner(System.in);
    Instructor instructor;

    public TutorUI(Instructor instructor) {
        this.instructor = instructor;
    }

    public int getMenuChoice() {
        int choice;
        do {
            choice = 0;
            System.out.println("+=============================+");
            System.out.println("|   Welcome to Tutor system   |");
            System.out.println("+=============================+");
            System.out.println("| 1. Create/Add new Tutor     |");
            System.out.println("| 2. Remove/Delete Tutor      |");
            System.out.println("| 3. Find Tutor               |");
            System.out.println("| 4. Modify Tutor Details     |");
            System.out.println("| 5. List All Tutor           |");
            System.out.println("| 6. List Function History    |");
            System.out.println("| 0. Exit                     |");
            System.out.println("+=============================+");
            System.out.println("");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            if (choice < 0 || choice > 6) {
                System.out.println("Invalid Input! Please Enter (0 - 5)");
                pressEnter();
                systemCls();
            }
        } while (choice < 0 || choice > 6);

        return choice;
    }

    //Add Function
    public String inputTutorCode() {
        String tCode = generateTutorID();
        System.out.println("New Tutor Code is: " + tCode);
        return tCode;
    }

    public String inputTutorName() {
        String tName;

        do {
            System.out.print("Enter Tutor Name: ");
            tName = scanner.nextLine().trim();
            if (!isLetter(tName)) {
                System.out.println("Invalid name! Only letter is allowed!");
                pressEnter();
            }
        } while (!isLetter(tName));

        return tName;
    }

    public String inputTutorGender() {
        char tempGender;
        String tGender;

        do {
            System.out.print("Enter Tutor Gender(M/F): ");
            tempGender = scanner.nextLine().trim().charAt(0);
            tempGender = Character.toUpperCase(tempGender);
            if (tempGender != 'M' && tempGender != 'F') {
                System.out.println("Invalid Gender! Enter (M = 'Male' / F = 'Female')");
                pressEnter();
                systemCls();
            }
        } while (tempGender != 'M' && tempGender != 'F');

        if (tempGender == 'M') {
            tGender = "M";
        } else {
            tGender = "F";
        }

        return tGender;
    }

    public String inputTutorEmail() {
        String tEmail;
        do {
            System.out.print("Enter Tutor Email: ");
            tEmail = scanner.nextLine().trim();
            if (!isValidEmail(tEmail)) {
                System.out.println("Invalid Email! email must contain '@' & '.'");
                pressEnter();
                systemCls();
            }
        } while (!isValidEmail(tEmail));

        return tEmail;
    }

    public String inputTutorGrade() {
        int aqSelection;
        String tGrade = null;

        do {
            System.out.println("---Academic Qualification---");
            System.out.println("1. Diploma");
            System.out.println("2. Degree");
            System.out.println("3. Master");
            System.out.println("4. PHD");
            System.out.print("Select Tutor Academic Qualification: ");
            aqSelection = scanner.nextInt();
            scanner.nextLine();
            if (aqSelection < 1 || aqSelection > 4) {
                System.out.println("Invalid option! Enter (1 - 4)");
                pressEnter();
                systemCls();
            }
        } while (aqSelection < 1 || aqSelection > 4);

        switch (aqSelection) {
            case 1:
                tGrade = "Diploma";
                return tGrade;
            case 2:
                tGrade = "Degree";
                return tGrade;
            case 3:
                tGrade = "Master";
                return tGrade;
            case 4:
                tGrade = "PHD";
                return tGrade;
        }

        return tGrade;
    }

    public String generateTutorID() {
        // Use the tList size from Instructor to generate the next ID
        int nextTutorID = instructor.getTutorListSize() + 1;
        return String.format("T%03d", nextTutorID); // Formats ID as T000X
    }

    public Tutor inputTutorDetails() {
        String tCode = inputTutorCode().trim();
        String tName = inputTutorName().trim();
        String tGender = inputTutorGender().trim();
        String tEmail = inputTutorEmail().trim();
        String tGrade = inputTutorGrade().trim();
        return new Tutor(tCode, tName, tGender, tEmail, tGrade);
    }

    //--------------------------------------------------
    //List all Tutors
    public void listAllTutors() {
        System.out.println("---Tutor List---");
        System.out.println("+=================================================================================================+");
        System.out.println(String.format("%1s %3s %-6s %-20s %-7s %5s %-25s %-22s %1s",
                "|", "No.", "Code", "Name", "Gender", "", "Email", "Education Qualification", "|"));
        System.out.println("+=================================================================================================+");
        for (int i = 0; i < instructor.getTutorListSize(); i++) {
            System.out.println("| " + (i + 1) + ".  " + instructor.getTutor(i) + "|");
        }
        System.out.println("+=================================================================================================+");
        System.out.println("");
    }

    public void displayTutorDetails(int rowChoice) {
        System.out.println("---Tutor Details---");
        System.out.println("ID: " + instructor.getTutor(rowChoice).gettCode());
        System.out.println("Name: " + instructor.getTutor(rowChoice).gettName());
        System.out.println("Gender: " + instructor.getTutor(rowChoice).gettGender());
        System.out.println("Phone Number: " + instructor.getTutor(rowChoice).gettEmail());
        System.out.println("Education Level: " + instructor.getTutor(rowChoice).gettGrade());
        System.out.println("");
    }

    public int searchCondition() {
        int searchChoice;
        do {
            System.out.println("+=========================+");
            System.out.println("| Search Function (Tutor) |");
            System.out.println("+=========================+");
            System.out.println("| 1. Search By Code       |");
            System.out.println("| 2. Search By Name       |");
            System.out.println("| 3. Search By Gender     |");
            System.out.println("| 0. Back to Tutor Main   |");
            System.out.println("+=========================+");
            System.out.print("Enter you choice: ");
            searchChoice = scanner.nextInt();
            scanner.nextLine();
            if (searchChoice < 0 || searchChoice > 3) {
                System.out.println("Invalid Option! Enter (0 - 3)");
                pressEnter();
                systemCls();
            }
        } while (searchChoice < 0 || searchChoice > 3);
        System.out.println("");
        return searchChoice;
    }

    public String keyCode() {
        String searchkey;
        do {
            System.out.print("Enter Tutor Code: ");
            searchkey = scanner.nextLine().trim();
            if (!isValidId(searchkey)) {
                System.out.println("Invalid ID Format! Example 'T000' ");
                pressEnter();
                systemCls();
            }
        } while (!isValidId(searchkey));
        System.out.println("");
        return searchkey;
    }

    public String keyName() {
        String searchKey;
        do {
            System.out.print("Enter Tutor Name: ");
            searchKey = scanner.nextLine().trim();
            if (!isLetter(searchKey)) {
                System.out.println("Invalid Name! Words only");
                pressEnter();
                systemCls();
            }
        } while (isLetter(searchKey));
        System.out.println("");
        return searchKey;
    }

    public String keyGender() {
        char tempGender;
        String searchkey;
        do {
            System.out.print("Enter Tutor Gender(M/F): ");
            tempGender = scanner.nextLine().trim().charAt(0);
            tempGender = Character.toUpperCase(tempGender);
            if (tempGender != 'M' && tempGender != 'F') {
                System.out.println("Invalid Gender! Enter (M = 'Male' / F = 'Female')");
                pressEnter();
                systemCls();
            }
        } while (tempGender != 'M' && tempGender != 'F');

        if (tempGender == 'M') {
            searchkey = "M";
        } else {
            searchkey = "F";
        }
        return searchkey;
    }

    // Modify Function  
    public int modifyRow() {
        int choiceSize = instructor.getTutorListSize();
        int rowChoice;

        do {
            rowChoice = 0;
            listAllTutors();

            System.out.print("Enter the number of row you want to modify: ");
            rowChoice = scanner.nextInt();
            scanner.nextLine();
            if (rowChoice < 1 || rowChoice > choiceSize) {
                System.out.println("Invalid Row!");
                System.out.print("Press enter to continue");
                scanner.nextLine();
                systemCls();
            }

        } while (rowChoice < 1 || rowChoice > choiceSize);

        System.out.println("");
        return rowChoice - 1;
    }

    public int modifyCondition() {
        int choice;

        do {
            choice = 0;

            System.out.println("---Modify Tutor Function---");
            System.out.println("1. Modify Tutor Name");
            System.out.println("2. Modify Tutor Gender");
            System.out.println("3. Modify Tutor Email");
            System.out.println("4. Modify Tutor Grade");
            System.out.println("0. Back");
            System.out.println("");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice < 0 || choice > 4) {
                System.out.println("Invalid option! Enter (0 - 5)");
                System.out.print("Press enter to continue");
                scanner.nextLine();
                systemCls();
            }
        } while (choice < 0 || choice > 4);

        return choice;
    }

    public Tutor modifyProccessing(int condition, int index) {

        String changedValue = null;
        Tutor tutor = instructor.returnSpecificTutor(index);

        switch (condition) {
            case 1:
                changedValue = inputTutorName();
                tutor.settName(changedValue);
                return tutor;
            case 2:
                changedValue = inputTutorGender();
                tutor.settGender(changedValue);
                return tutor;
            case 3:
                changedValue = inputTutorEmail();
                tutor.settEmail(changedValue);
                return tutor;
            case 4:
                changedValue = inputTutorGrade();
                tutor.settGrade(changedValue);
                return tutor;
        }
        return null;
    }

    // Delete Function
    public int deleteTutorByRow() {
        int rowSize = instructor.getTutorListSize();
        int rowDelete;
        char comfirm;

        do {
            rowDelete = 0;
            listAllTutors();

            System.out.print("Enter the row you want to delete: ");
            rowDelete = scanner.nextInt();
            scanner.nextLine();

            if (rowDelete < 1 || rowDelete > rowSize) {
                System.out.println("Invalid Row! Enter a valid row");
                System.out.print("Press enter to continue");
                scanner.nextLine();
                systemCls();
            }
        } while (rowDelete < 1 || rowDelete > rowSize);

        do {
            System.out.print("Are you sure want to delete(Y/N)? : ");
            comfirm = scanner.nextLine().charAt(0);
            comfirm = Character.toUpperCase(comfirm);
            if (comfirm != 'N' && comfirm != 'Y') {
                System.out.println("Invalid Input! Y/N only");
                System.out.print("Press enter to continue");
                scanner.nextLine();
                systemCls();
            }
        } while (comfirm != 'N' && comfirm != 'Y');

        if (comfirm == 'N') {
            rowDelete = 0;
        }

        return rowDelete;
    }

    // History Function
    public void addToTutorHistory(int choice) {

        String newHistory = null;

        switch (choice) {
            case 0:
                newHistory = "Exit Tutor Module";
                break;
            case 1:
                newHistory = "Add new Tutor";
                break;
            case 2:
                newHistory = "Remove Tutor";
                break;
            case 3:
                newHistory = "Find Tutor";
                break;
            case 4:
                newHistory = "Modify Tutor Details";
                break;
            case 5:
                newHistory = "List All Tutor";
                break;
            case 6:
                newHistory = "List History";
                break;

            default:
                break;

        }

        instructor.addTutorHistory(newHistory);

    }

    public void listTutorHistory() {

        int tutorHistorySize = instructor.tutorHistorySize();
        System.out.println("---Function History---");
        while (!instructor.isEmptyHistory()) {
            System.out.println("   " + instructor.popTutorHistory());
        }
        System.out.println("");
        System.out.println("Function carried out(times): " + tutorHistorySize);
        System.out.println("");
    }

    //Other Function
    public void systemCls() {
        for (int i = 0; i < 10; i++) {
            System.out.println("");
        }
    }

    public boolean isLetter(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                return false;
            }
        }
        return true;
    }

    public void pressEnter() {
        System.out.print("Press 'Enter' to continue");
        scanner.nextLine();
    }

    public boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

        int atIndex = email.indexOf('@');
        int dotIndex = email.lastIndexOf('.');

        if (atIndex <= 0 || dotIndex <= atIndex || dotIndex == email.length() - 1) {
            return false;
        }

        return true;
    }

    public static boolean isValidId(String tutorId) {
        return tutorId.matches("T\\d{3}");
    }
}
