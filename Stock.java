/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wangari
 */
public class Stock {
    Product myProduct;
    int theProductQuantity;
    
   public Stock(Product theProduct, int theQuantity){
       myProduct= theProduct;
       theProductQuantity=theQuantity;
       }
   
   public Product getProduct(){
       return myProduct;
   }
   public int getTheProductQuantity(){
       return theProductQuantity;
   }
    public void  setProduct(Product newProduct){
        myProduct=newProduct;
        }
    public void setProductQuantity(int newProductQuantity){
        theProductQuantity=newProductQuantity;
        }
    public int increaseProductQuantity(int quantityToIncrease){
        theProductQuantity +=quantityToIncrease;
        return theProductQuantity;
    }
    public int decreaseProductQuantity(int quatityToDecrease){
        theProductQuantity -= quatityToDecrease;
        return theProductQuantity;
    }
    @Override
    public String toString(){
        return (myProduct+" "+theProductQuantity);
    }
}
