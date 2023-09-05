/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package betterUI;

/**
 *
 * @author chook zhen yew
 */
public class betterUI {
    
    public static void pauseFor2Second(){
        for (int i = 0; i < 5; i++) {
            System.out.print(".");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void systemCls() {
        for (int i = 0; i < 25; i++) {
            System.out.println();
        }
    }
    
    public static void loadingScreen(String action){
        System.out.print(action);

        for (int i = 0; i < 10; i++) {
            System.out.print(".");
            try {
                Thread.sleep(500); // Pause for half a second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n" + action + " Complete!");
    }
}
