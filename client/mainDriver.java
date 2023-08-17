/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
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
public class mainDriver {
    

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" MENU");
        System.out.println("-------");
        System.out.println("1. Programme");
        System.out.print("\nWhat is your choice : ");
        int choice = scanner.nextInt();
        
        
        switch(choice){
            case 1:
                programmeUI.programmeMainMenu();
                
        }
        
        
    }
    
}
