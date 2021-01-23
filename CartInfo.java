/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototype;


public class CartInfo {
    
    String cusername;
    int prod_id;
    String name;
    double unitPrice;
    int quantity;
    double totalPrice;
    
    public CartInfo(int pid, String pname, double pprice,int pquantity){
        this.prod_id= pid;
        this.name = pname;
        this.unitPrice = pprice;
        this.quantity = pquantity;
        this.totalPrice = quantity * unitPrice;
        
    }
    
    public int getcid(){
        return prod_id;
    }
    
    public String getcname(){
        return name;
    }
    
    public double getcuprice(){
        return unitPrice;
    }
    
    public int getcquantity(){
        return quantity;
    }
    
     public double getctprice(){
        return totalPrice;
    }
    
}


