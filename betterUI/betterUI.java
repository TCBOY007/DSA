/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package betterUI;

/**
 *
 * @author chook
 */
public class betterUI {
    
    public static void pauseFor2Second(){
        try {
            // Sleep for 2 seconds (2000 milliseconds)
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // Handle the exception if sleep is interrupted
            e.printStackTrace();
        }
    }
    
    public static void systemCls() {
        for (int i = 0; i < 25; i++) {
            System.out.println();
        }
    }
    
    public static void modifyingScreen(){
        System.out.print("Modifying ");

        for (int i = 0; i < 10; i++) {
            System.out.print(".");
            try {
                Thread.sleep(500); // Pause for half a second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nModifying complete!");
    }
}
