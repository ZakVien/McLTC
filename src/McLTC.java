
import java.util.ArrayList;
import java.util.Random;
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
public class McLTC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String sandwich = "";
        String frySize = "";
        String drinkSize = "";
        String response = "";
        String subtotalStr = "";
        String orderDetails = "";
        int comboResponse = 0;
        boolean repeat = true;
        boolean okayToPay = false;
        boolean cancelCombo = false;
        
        while(repeat){
            JOptionPane.showMessageDialog(null, "Welcome to McLTC's!\nPress OK to start your order.", "McLTC's - Begin Order", JOptionPane.PLAIN_MESSAGE);
            ArrayList<Food> order = new ArrayList<Food>();
            sandwich = "";
            do{
                
                try{
                    sandwich = JOptionPane.showInputDialog(null, 
                    "(B)ig LTC - ($2.99)\n"
                    + "(T)hird Pounder w/ Cheese -  ($2.99)\n"
                    + "(C)heeseburger - ($1.99)\n"
                    + "(M)cLTC Chicken - ($2.99)\n"
                    + "(S)lab-o-Fish - ($0.99)\n"
                    + "(Q)uit/Cancel Order",
                    "McLTC's - Menu",
                    JOptionPane.QUESTION_MESSAGE);
                    if(!sandwich.equalsIgnoreCase("b") &&
                    !sandwich.equalsIgnoreCase("t") &&
                    !sandwich.equalsIgnoreCase("c") &&
                    !sandwich.equalsIgnoreCase("m") &&
                    !sandwich.equalsIgnoreCase("s") &&
                    !sandwich.equalsIgnoreCase("q")){
                        throw new ValidationException();
                    }
                } catch (ValidationException error) {
                    JOptionPane.showMessageDialog(null, "Selection must be (B), (T), (C), (M), (S), or (Q)", "McLTC's - Invalid selection", JOptionPane.WARNING_MESSAGE);
                } catch (NullPointerException error){
                    break;
                }
                
                if(sandwich.equalsIgnoreCase("b") ||
                sandwich.equalsIgnoreCase("t") ||
                sandwich.equalsIgnoreCase("c") ||
                sandwich.equalsIgnoreCase("m") ||
                sandwich.equalsIgnoreCase("s")){
                    if(sandwich.equalsIgnoreCase("c")){
                        comboResponse = JOptionPane.showConfirmDialog(null, "Would you like to turn your sandwich into a combo for an extra $2.50?\n"
                            + "This combo includes fries, soda, and an extra cheeseburger.", "McLTC's - Combo?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    }else{
                        comboResponse = JOptionPane.showConfirmDialog(null, "Would you like to turn your sandwich into a combo for an extra $2.50?\n"
                            + "This combo includes fries and soda.", "McLTC's - Combo?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    }
                    if(comboResponse == 0){
                        cancelCombo = false;
                        do{
                            try{
                                frySize = JOptionPane.showInputDialog(null, 
                                "Please make a selection\n"
                                + "(S)mall Fries\n"
                                + "(M)edium Fries\n"
                                + "(L)arge Fries",
                                "McLTC's - Fry size", 
                                JOptionPane.QUESTION_MESSAGE);
                                if(!frySize.equalsIgnoreCase("s") && !frySize.equalsIgnoreCase("m") && !frySize.equalsIgnoreCase("l")){
                                    throw new ValidationException();
                                }
                            } catch (ValidationException error) {
                                JOptionPane.showMessageDialog(null, "Selection must be (S), (M), or (L)", "McLTC's - Invalid selection", JOptionPane.WARNING_MESSAGE);
                            } catch (NullPointerException error) {
                                cancelCombo = true;
                                break;
                            }
                        }while(!frySize.equalsIgnoreCase("s") && !frySize.equalsIgnoreCase("m") && !frySize.equalsIgnoreCase("l"));
                        if(!cancelCombo){
                            do{
                                try{
                                    drinkSize = JOptionPane.showInputDialog(null, 
                                    "Please make a selection\n"
                                    + "(S)mall Soda\n"
                                    + "(M)edium Soda\n"
                                    + "(L)arge Soda", 
                                    "McLTC's - Soda size", 
                                    JOptionPane.QUESTION_MESSAGE);
                                    if(!drinkSize.equalsIgnoreCase("s") && !drinkSize.equalsIgnoreCase("m") && !drinkSize.equalsIgnoreCase("l")){
                                        throw new ValidationException();
                                    }
                                } catch (ValidationException error) {
                                    JOptionPane.showMessageDialog(null, "Selection must be (S), (M), or (L)", "McLTC's - Invalid selection", JOptionPane.WARNING_MESSAGE);
                                } catch (NullPointerException error) {
                                    cancelCombo = true;
                                    break;
                                }
                            }while(!drinkSize.equalsIgnoreCase("s") && !drinkSize.equalsIgnoreCase("m") && !drinkSize.equalsIgnoreCase("l"));
                        }
                        if(!cancelCombo){
                            Sandwich meal = new Combo(sandwich, frySize, drinkSize);
                            order.add(meal);
                            meal.setSubtotal(order);
                            meal.setOrderDetails(order);
                            subtotalStr = meal.getSubtotal();
                            orderDetails = meal.getOrderDetails();
                        }
                    }else if(comboResponse == 1){
                        Sandwich meal = new Sandwich(sandwich);
                        order.add(meal);
                        meal.setSubtotal(order);
                        meal.setOrderDetails(order);
                        subtotalStr = meal.getSubtotal();
                        orderDetails = meal.getOrderDetails();
                    }
                    if(!cancelCombo){
                        do{
                            try{
                                response = JOptionPane.showInputDialog(null, 
                                    "(A)dd more items to your order\n"
                                    + "(P)ay for your order", "McLTC's - Continue order", JOptionPane.QUESTION_MESSAGE);
                                if(!response.equalsIgnoreCase("a") && !response.equalsIgnoreCase("p")){
                                    throw new ValidationException();
                                }
                            } catch (ValidationException error) {
                                JOptionPane.showMessageDialog(null, "Selection must be (A) or (P)", "McLTC's - Invalid selection", JOptionPane.WARNING_MESSAGE);
                            }
                        }while(!response.equalsIgnoreCase("a") && !response.equalsIgnoreCase("P"));
                        if(response.equalsIgnoreCase("p")){
                            okayToPay = true;
                            break;
                        }
                    }else{
                        cancelCombo = false;
                        JOptionPane.showMessageDialog(null, "Your meal has been removed from your order.", "McLTC's - Cancel combo", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }while(!sandwich.equalsIgnoreCase("q") || sandwich == null);
            if(okayToPay){
                JOptionPane.showMessageDialog(null, orderDetails + "Total: " + subtotalStr + "\nPlease press OK to pay", "McLTC's - Order confirmation", JOptionPane.PLAIN_MESSAGE);
                Random rand = new Random();
                int orderNumber = rand.nextInt(100);
                JOptionPane.showMessageDialog(null, "Thank you for your purchase.\nYour order number is: " + orderNumber, "McLTC's - Payment complete", JOptionPane.INFORMATION_MESSAGE);
                order.clear();
                okayToPay = false;
            }
        }
    }
    
}
