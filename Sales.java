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
public class Sales {
 
    String name;
    double grandTotal;
    int id;
    String address;
    int number;
    String date;
    
    public Sales(int sid, String cname, double sgrandTotal, String paddress,int cnumber,String odate){
        this.id= sid;
        this.name = cname;
        this.grandTotal = sgrandTotal;
        this.address = paddress;
        this.number = cnumber;
        this.date = odate;
        
    }
    
    public int getid(){
        return id;
    }
    
    public String getname(){
        return name;
    }
    
    public double getprice(){
        return grandTotal;
    }
    
    public int getnumber(){
        return number;
    }
    
    public String getaddress(){
        return address;
    }
    
    public String getdate(){
        return date;
    }
    
   

}
