
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zach
 */
public class Sandwich extends Food {
    String sandwich;
    
    public Sandwich(String s){
        if(s.equalsIgnoreCase("b")){
            sandwich = BLTC;
        }else if(s.equalsIgnoreCase("t")){
            sandwich = THRD;
        }else if(s.equalsIgnoreCase("c")){
            sandwich = CHZB;
            price = NUM1;
        }else if(s.equalsIgnoreCase("m")){
            sandwich = MLTC;
        }else{
            sandwich = SLAB;
            price = NUM2;
        }
    }
    
    public String display() {
        String msg = sandwich + " - $" + price + "\n";
        return msg;
    }
}
