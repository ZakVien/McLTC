
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zach
 */
public abstract class Food implements Menu {
    double price = 2.99;
    double subtotal;
    String orderDetails = "";
    public abstract String display();
    
    public double roundDouble (double dub){
        double roundedDouble = Math.floor(dub * 100)/100;
        return roundedDouble;
    }
    public void setSubtotal(ArrayList<Food> order){
        //add together costs of all pizzas
        double totalcost = 0.0;
        for(Food list : order){
            totalcost = totalcost + list.price;
        }
        subtotal = roundDouble(totalcost);
    }
    public void setOrderDetails(ArrayList<Food> order){
        String msg = "";
        int index = 0;
        for(Food list : order){
            msg = msg + "Item #" + (index + 1) + "\n" + list.display() + "\n";
            index++;
        }
        orderDetails = msg;
    }
    public String getSubtotal(){
        String str = "$" + subtotal;
        return str;
    }
    public String getOrderDetails(){
        return orderDetails;
    }
}
