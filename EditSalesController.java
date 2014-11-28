package mvc.controllers;

import mvc.views.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wangari
 */
public class EditSalesController extends javax.swing.JFrame {
Connection conn=null;
public EditSales mySales ;

private ActionListener actionlistener;
 
    public EditSalesController() {
    
      mySales = new EditSales(); 
      //mySales.setVisible(true);
    }


    public void controller(){
         int  saleId=Integer.parseInt(mySales.getEditId().getText());
         try {
             
       Class.forName("com.mysql.jdbc.Driver").newInstance();
 conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost/Sales?user=root&password=");
 System.out.println("connected to database");
        PreparedStatement p =conn.prepareStatement("SELECT * FROM AllSales WHERE saleId = "+saleId+";");


  java.sql.ResultSet r = p.executeQuery ();
  while(r.next()) {
    mySales.getEditId().setText(r.getString("saleId")) ;
    mySales.getProductName().setText(r.getString("productName"));
   mySales.getProductPrice().setText( r.getString("productPrice")) ;
   mySales.getProductQuantity().setText( r.getString("productQuantity")) ;
   
  }
}
       catch (Exception e) {
  JOptionPane.showMessageDialog(null,e);
        }
    }
    
 public void controlSave(){

        int  saleId =Integer.parseInt(mySales.getEditId().getText());      
        String productName = mySales.getProductName().getText();
        int productPrice = Integer.parseInt(mySales.getProductPrice().getText());
        int productQuantity = Integer.parseInt(mySales.getProductQuantity().getText());
  try{
       Class.forName("com.mysql.jdbc.Driver").newInstance();
 conn = java.sql.DriverManager.getConnection(
 "jdbc:mysql://localhost/Sales?user=root&password=");
 
    PreparedStatement p=conn.prepareStatement("UPDATE AllSales set saleId=?, productName=? ,productPrice =?,productQuantity=? where saleId like '%"+saleId+ "%';");
    p.setInt(1, saleId);
    p.setString(2, productName);
    p.setInt(3,productPrice );
    p.setInt(4,productQuantity);
    p.execute(); 
    p.close();
    //use execute if no results expected back
    }catch(Exception e){
        System.out.println("Error"+e.toString());
        //return;        
    }
         }
 public void closeForm(){
     //System.exit(0);
     mySales.setVisible(false);
 }
   
   public void theController(){
       actionlistener = new ActionListener (){
         @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==mySales.savingData()   ){
            controlSave();
        }
       else  if(e.getSource()==mySales.theEdit()){
       controller();
        }
       else  if(e.getSource()==mySales.closingForm()){
       closeForm();
        }
         
    }
       };
        mySales.theEdit().addActionListener(actionlistener);
     mySales.savingData().addActionListener(actionlistener);
        
        
    }
public static void main(String[]args){
    EditSalesController mycontrol = new EditSalesController();
    mycontrol.theController();
}
       
   }

  
         
  //  }
//}