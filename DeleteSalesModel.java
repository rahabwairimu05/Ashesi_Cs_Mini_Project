//package mvc.models;
package mvc.controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import mvc.views.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wangari
 */
public class DeleteSalesModel extends javax.swing.JFrame {
 public  DeleteSalesView mydelete;
 Connection conn=null;
private ActionListener actionlistener;
 
    public DeleteSalesModel() {
    
      mydelete = new DeleteSalesView(); 
     // mydelete.setVisible(true);
    }
  public void searchProduct(){
         int  saleId=Integer.parseInt(mydelete.getProductId().getText());
         try {
             
       Class.forName("com.mysql.jdbc.Driver").newInstance();
 conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost/Sales?user=root&password=");
 System.out.println("connected to database");
        PreparedStatement p =conn.prepareStatement("SELECT * FROM AllSales WHERE saleId = "+saleId+";");


  java.sql.ResultSet r = p.executeQuery ();
  while(r.next()) {
    mydelete.getProductId().setText(r.getString("saleId")) ;
    mydelete.getProductName().setText(r.getString("productName"));
   mydelete.getProductPrice().setText( r.getString("productPrice")) ;
  mydelete.getProductQuantity().setText( r.getString("productQuantity")) ;
   
  }
}
       catch (Exception e) {
  JOptionPane.showMessageDialog(null,e);
        }
    } 
  public void closeForm(){
     //System.exit(0);
     mydelete.setVisible(false);
 } 
  public void deleteSale(){
    int  saleId=Integer.parseInt(mydelete.getProductId().getText());
    try {
  Class.forName("com.mysql.jdbc.Driver").newInstance();
 conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost/Sales?user=root&password=");
        PreparedStatement p =conn.prepareStatement("Delete FROM AllSales" + " WHERE saleId=?");
        p.setInt(1,saleId);
        p.execute();
        
    } catch(Exception e){
        System.out.println("Error"+e.toString());
        return;        
    }
      
  }
     public void theController(){
       actionlistener = new ActionListener (){
         @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==mydelete.delete()   ){
            deleteSale();
        }
         if(e.getSource()==mydelete.searchSale()){
       searchProduct();
        }
    else if(e.getSource()==mydelete.closingForm()){
       closeForm();
        }
         
    }
       };
        mydelete.delete().addActionListener(actionlistener);
     mydelete.searchSale().addActionListener(actionlistener);
     mydelete.closingForm().addActionListener(actionlistener);
        
        
    }
  
//public static void main(String[]args){
//   DeleteSalesModel myModel = new DeleteSalesModel();
//    myModel.theController();    
//}    
    
}
