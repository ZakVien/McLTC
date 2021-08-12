
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zach
 */
public class Combo extends Sandwich {
    public String friesSize;
    public String drinkSize;
    
    public Combo(String s, String f, String d){
        super(s);
        if(s.equals("c")){
            sandwich = CHZS;
        }
        
        if(f.equalsIgnoreCase("s")){
            friesSize = "Small";
        }else if(f.equalsIgnoreCase("m")){
            friesSize = "Medium";
        }else{
            friesSize = "Large";
        }
        
        if(d.equalsIgnoreCase("s")){
            drinkSize = "Small";
        }else if(d.equalsIgnoreCase("m")){
            drinkSize = "Medium";
        }else{
            drinkSize = "Large";
        }
        price = price + COMBOCOST;
    }
    
    @Override
    public String display() {
        String msg = sandwich + " Combo - $" + price + "\n-"
                + friesSize + " Fries\n-"
                + drinkSize + " Soda\n";
        return msg;
    }
}
