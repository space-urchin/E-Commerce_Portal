/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototype;

/**
 *
 * @author USER
 */
public class Product {
    
    int id;
    String name;
    double price;
    int quantity;
    String dateAdded;
    byte[] image;
    String htype;
    String htex;
    String feature;
    
    public Product(int pid, String pname, double pprice,int pquantity, String pdateAdded, byte[] pimage, String phtype, String phtex, String pfeature){
        this.id= pid;
        this.name = pname;
        this.price = pprice;
        this.quantity = pquantity;
        this.dateAdded = pdateAdded;
        this.image = pimage;
        this.htype = phtype;
        this.htex = phtex;
        this.feature = pfeature;
    }
    
    public int getid(){
        return id;
    }
    
    public String getname(){
        return name;
    }
    
    public double getprice(){
        return price;
    }
    
    public int getquantity(){
        return quantity;
    }
    
    public String getDate(){
        return dateAdded;
    }
    
    public byte[] getimage(){
        return image;
    }
    
    public String getType(){
        return htype;
    }
      
    public String getTexture(){
        return htex;
    }
        
    public String getFeature(){
        return feature;
    } 
}
