/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wangari
 */
public class Product {
    int productQuantity;
    String productName;
    int productId;
    double productPrice;
    
    public Product( String theName, double thePrice,int theQuantity){
        productName=theName;
        productPrice=thePrice;
       productQuantity= theQuantity;
       
    }
    
    public String getProductName(){
        return productName;
    }
    public double getProductPrice(){
        return productPrice;
    }
    public int getProductQuantity(){
        return productQuantity;
    }
    public void setProductName(String newProductName){
        productName=newProductName;
    }
    public void setProductPrice(double newProductPrice){
       productPrice= newProductPrice;
    }
    public void setProductQuantity(int newProductQuantity){
        productQuantity =newProductQuantity;
     }
    
    public int increaseProductQuantity(int quantityToIncrease){
       productQuantity+= quantityToIncrease;
       return productQuantity;
    }
    public int decreseProductQuantity(int quantityToDecrease){
      productQuantity-= quantityToDecrease;
      return productQuantity;
    }
    
    @Override
    public String toString(){
        return(productName +" "+ productPrice +" "+ productQuantity);
    }
}
