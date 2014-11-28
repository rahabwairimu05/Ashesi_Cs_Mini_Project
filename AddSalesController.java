
package mvc.controllers;
import mvc.views.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wangari
 */
public class AddSalesController extends javax.swing.JFrame {
 public  AddSaleView newSale ;  
  Connection conn=null;
  private ActionListener actionlistener;
  
  
    public AddSalesController() {
    
      newSale = new AddSaleView(); 
      //newSale.setVisible(true);
     
    }
    
  public void controlAddSale(){
      
      
      
      
      int  saleId =Integer.parseInt(newSale.getProductId().getText());      
      String productName = newSale.getProductName().getText();
      int productPrice = Integer.parseInt(newSale.getProductPrice().getText());
      int productQuantity = Integer.parseInt(newSale.getProductQuantity().getText());
  try{
       Class.forName("com.mysql.jdbc.Driver").newInstance();
 conn = java.sql.DriverManager.getConnection(
 "jdbc:mysql://localhost/Sales?user=root&password=");
 
 PreparedStatement p=conn.prepareStatement("INSERT INTO  AllSales(saleId,productName,productPrice,productQuantity)Values(?,?,?,?)");
            
    p.setInt(1, saleId);
    p.setString(2, productName);
    p.setInt(3,productPrice );
    p.setInt(4,productQuantity);
   
    p.execute(); 
    p.close();
   
    }catch(Exception e){
        System.out.println("Error"+e.toString());
              
    }
 }
  public void exit(){
      newSale.setVisible(false);
  }
  
  public void saleController(){
      actionlistener = new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
              if(e.getSource()== newSale.saveSale()){
                controlAddSale();  
              }  
             else if(e.getSource()== newSale.closeView()){
                  exit();
              }
          }
      };
      newSale.saveSale().addActionListener(actionlistener);
      newSale.closeView().addActionListener(actionlistener);
      
  }
  
// public static void main(String[]args){
//     AddSalesController mySalesController = new AddSalesController();
//     mySalesController.saleController();
//     
// }
    
  
    
    
}
