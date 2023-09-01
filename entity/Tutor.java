/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author user
 */
public class Tutor {

    private String tCode;
    private String tName;
    private String tGender;
    private String tEmail;
    private String tGrade;

    public Tutor() {
    }

    public Tutor(String tCode, String tName, String tGender, String tEmail, String tGrade) {
        this.tCode = tCode;
        this.tName = tName;
        this.tGender = tGender;
        this.tEmail = tEmail;
        this.tGrade = tGrade;
    }

    public String gettCode() {
        return tCode;
    }

    public void settCode(String tCode) {
        this.tCode = tCode;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettGender() {
        return tGender;
    }

    public void settGender(String tGender) {
        this.tGender = tGender;
    }

    public String gettEmail() {
        return tEmail;
    }

    public void settEmail(String tEmail) {
        this.tEmail = tEmail;
    }

    public String gettGrade() {
        return tGrade;
    }

    public void settGrade(String tGrade) {
        this.tGrade = tGrade;
    }

    @Override
    public String toString() {
        return  String.format("%-6s %-20s %3s %6s %-25s %10s %-16s",
                        tCode, tName, tGender, "", tEmail,"", tGrade);
    }

}
