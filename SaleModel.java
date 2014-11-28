/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.models;

import java.util.TreeMap;

/**
 *
 * @author deincrediblelowkey
 */
public class SaleModel {
    private int id;
    private String productname;
    private int price;
    private int quantity;
    
    TreeMap<Integer,SaleModel> salemodel;
    
    
    public SaleModel(){
        this.salemodel = new TreeMap<>();
        
    }
    
    public void setname(String newname){
        productname = newname;
    }
    
    public void setprice(int newprice){
        price = newprice;
    }
    
    public void setquantity(int newquantity){
        quantity = newquantity;
    } 
    
    public String getname(){
        return productname;
    }
    
    public int getPrice(){
        return price;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void setId(int newid){
        id = newid;
    }
    
    public int getId(){
        return id;
    }
    
    
    
    
    
    public void addSale(int a,String z,int x,int y){
        SaleModel sale = new SaleModel();
        sale.setId(a);
        sale.setname(z);
        sale.setprice(x);
        sale.setquantity(y);
        
        salemodel.put(a,sale);
        System.out.println(salemodel.get(a).getname());
    }
}
