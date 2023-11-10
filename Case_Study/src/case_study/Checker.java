/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package case_study;

import java.util.Arrays;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Kowkie
 */
public class Checker {
//    public int CheckMines(){
//     Random rand = new Random(1);
//      int randInt = rand.nextInt( 36 );
//      return randInt;
//    
//    }
    public int[] CheckMines(int lvl){
       
     Random rand = new Random();
      int[] randInt =new int[12];
     
     switch (lvl){
         case 1:{
             
             int[] hold = {rand.nextInt(36),rand.nextInt(36),rand.nextInt(36)};
             randInt = Arrays.copyOf(hold, 3);
    
         }
     }
        return randInt;

      
    
    
    }
}
