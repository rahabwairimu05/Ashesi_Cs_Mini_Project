/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wangari
 */
public class Sale {
    Product myProduct;
    int numProducts;
    
    public Sale(Product theProduct,int theNumProducts){
        myProduct=theProduct;
        numProducts = theNumProducts;
        
   }
    public Product getProducts(){
        return myProduct;
    }
    public int getNumProducts(){
        return numProducts;
    }
    public void setProduct(Product newProduct){
        myProduct=newProduct;
        }
    public void setNumProducts(int newNumProducts){
        numProducts=newNumProducts;
        }
    @Override
    public String toString(){
        return (myProduct+" "+numProducts);
    }
}
