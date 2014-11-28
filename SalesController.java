    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */

    /**
     *
     * @author wangari
     */
    //import mvc.models.DeleteSalesModel;
    import mvc.controllers.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.sql.Connection;
import javax.swing.JOptionPane;
    //import java.sql.PreparedStatement;
    import mvc.views.*;
    import mvc.models.*;

    public class SalesController extends javax.swing.JFrame{

        private EditSales   view2;
        private SalesForm   view3;
        private AddSalesController view1 ;
        private EditSalesController view4;
        private DeleteSalesModel  view5;
        private AddSaleView view6;
       // AddSaleView newSale= new AddSaleView() ;  
      Connection conn=null;
      //private ActionListener actionlistener;


        private ActionListener actionlistener;

        public SalesController(AddSalesController view1,EditSales view2,SalesForm view3,EditSalesController view4,DeleteSalesModel view5,AddSaleView view6 ){
        // this.view1 = view1;
         this.view2 = view2;
         this.view3 = view3;
        this.view1= view1;
        this.view4= view4;
        this.view5= view5;
        this.view6 = view6;


        }

        public void control(){

            view3.setVisible(true);
        actionlistener = new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==view3.addSale()){
               // linkBtn1AndView3();
                    view1.newSale.setVisible(true);
                }
               else if(e.getSource()==view3.editSale()){
               view4.mySales.setVisible(true);
                }
               else if(e.getSource()==view3.deleteSale()){
                   view5.mydelete.setVisible(true);
               }
               else if(e.getSource()== view1.newSale.saveSale()){
                view1.controlAddSale(); 
                JOptionPane.showMessageDialog (null, "Sale Added succesfully" , "Sales Record", JOptionPane.INFORMATION_MESSAGE);
               }
               else if(e.getSource()== view1.newSale.closeView()){
                   view1.exit();
               }
               else if(e.getSource()== view4.mySales.theEdit()){
                   view4.controller();
               }
               else if(e.getSource()== view4.mySales.savingData()){
                   view4.controlSave();
                   JOptionPane.showMessageDialog (null, "Sales editted succesfully" , "Sales Record", JOptionPane.INFORMATION_MESSAGE);
               }
               else if (e.getSource()== view1.newSale.closeView()){
                   view1.exit();
               }
               else if (e.getSource()== view4.mySales.closingForm()){
                   view4.closeForm();
               }
               else if (e.getSource()==view5.mydelete.delete()   ){
                view5.deleteSale();
                JOptionPane.showMessageDialog (null, "Record deleted succesfully" , "sales Record", JOptionPane.INFORMATION_MESSAGE);
            }
            else if(e.getSource()==view5.mydelete.searchSale()){
           view5.searchProduct();
            }
            else  if(e.getSource()==view5.mydelete.closingForm()){
           view5.closeForm();
            }
            else if(e.getSource()== view6.saveSale()) 
                addSale();
                
            }
        };
        view3.addSale().addActionListener(actionlistener);
        view3.editSale().addActionListener(actionlistener);
        view3.deleteSale().addActionListener(actionlistener);
        view1.newSale.saveSale().addActionListener(actionlistener);
        view1.newSale.closeView().addActionListener(actionlistener);
        view4.mySales.theEdit().addActionListener(actionlistener);
        view4.mySales.savingData().addActionListener(actionlistener);
        view4.mySales.closingForm().addActionListener(actionlistener);
        view5.mydelete.delete().addActionListener(actionlistener);
         view5.mydelete.searchSale().addActionListener(actionlistener);
         view5.mydelete.closingForm().addActionListener(actionlistener);
         view6.saveSale().addActionListener(actionlistener);

        }
        
        
        
        private void addSale(){
        SaleModel sm = new SaleModel();
        int theid = Integer.parseInt(view6.getProductId().getText());
        int theprice = Integer.parseInt(view6.getProductPrice().getText());
        int thequantity = Integer.parseInt(view6.getProductQuantity().getText());
        sm.addSale(theid,view6.getProductName().getText(),theprice,thequantity); 
        //System.out.println();
    }
    
        private void deleteSales(){
            
        }

       


        public static void main(String[] args){


         AddSaleView view6= new AddSaleView(); 
         EditSales   view2= new  EditSales() ;
         SalesForm   view3= new SalesForm() ;
         //AddSaleView newSale= new AddSaleView() ;  
         AddSalesController nm = new AddSalesController();
         EditSalesController mycontrol = new  EditSalesController();
         DeleteSalesModel   myModel = new DeleteSalesModel();
         SalesController x = new SalesController(nm,view2,view3,mycontrol,myModel,view6);

         x.control();
        }
    }
