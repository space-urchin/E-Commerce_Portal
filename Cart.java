/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prototype;

import java.awt.Image;
import java.sql.*;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.input.KeyCode.R;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class Cart extends javax.swing.JFrame {
    
    String username;
    double grandTotal = 0;

    /** Creates new form Cart */
    public Cart() {
        initComponents();
        ShowCartProducts();
    }
    public Cart(String cusername) {
        initComponents();
        this.username = cusername;
        ShowCartProducts();
    }

     public Connection getConnection(){
        
        Connection con = null;
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","fariha","1234");
            //JOptionPane.showMessageDialog(null, "Connected");
            
            return con;

         
        }catch(Exception e){ 
                System.out.println(e);
                return con;
            }
    }
     
     
     public boolean checkInputs(){
        
        if(textProdId.getText() == null){
            return false;
        }
        else{
            try{
                
                return true;
            }catch(Exception es){
                return false;
            }
            
        }
    }
     
     public boolean checkInputs2(){
        
        if(textName.getText() == null){
            return false;
        }
        else{
            try{
                
                return true;
            }catch(Exception es){
                return false;
            }
            
        }
    }
     
     public ImageIcon ResizeImage(String imagePath, byte[]pic){
        
        ImageIcon myImage = null;
        
        if(imagePath!=null){
            myImage = new ImageIcon(imagePath);
        }
        else{
            
            myImage = new ImageIcon(pic);
        }
        
        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(labelPreview.getWidth(),labelPreview.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;
    }
     
     
      public ArrayList<CartInfo> getCartList(){
        ArrayList<CartInfo> cartList = new ArrayList<CartInfo>();
        Connection con = getConnection();

        
        try {
            
            PreparedStatement ps = con.prepareStatement("Select * from Cart where customer_username = ?");
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            CartInfo cartInfo;
            
            while(rs.next()){
                System.out.println(username);
                cartInfo =new CartInfo(rs.getInt("prod_id"),rs.getString("name"),Double.parseDouble(rs.getString("unit_price")),rs.getInt("quantity"));
                cartList.add(cartInfo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return cartList;
        
    }
    
    public void ShowCartProducts(){
        
        try {
            ArrayList<CartInfo> list = getCartList();
            DefaultTableModel model = (DefaultTableModel)tableCart.getModel();
            model.setRowCount(0);
            
            
            
            Object[] row = new Object[5];
            for(int i =0; i <list.size();i++){
                row[0] = list.get(i).getcid();
                row[1] = list.get(i).getcname();
                row[2] = list.get(i).getcuprice();
                row[3] = list.get(i).getcquantity();
                row[4] = list.get(i).getcuprice()*list.get(i).getcquantity();
                
                //grandTotal = grandTotal + list.get(i).getcuprice()*list.get(i).getcquantity();
                model.addRow(row);
                
            }
            Connection conn = getConnection();
            String callst= "begin ? := TotalPrice(?);end;";
            CallableStatement cstmt = conn.prepareCall(callst);
            cstmt.registerOutParameter(1, Types.FLOAT);
            cstmt.setString(2,username);
            cstmt.executeUpdate();
            grandTotal = cstmt.getFloat(1);
            textGrand.setText(Double.toString(grandTotal));
            //textGrand.setText(Double.toString(grandTotal));
        } catch (SQLException ex) {
            Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
   public void ShowItem(int index){
        textProdId.setText(Integer.toString(getCartList().get(index).getcid()));
        textName.setText(getCartList().get(index).getcname());
        textUPrice.setText(Double.toString(getCartList().get(index).getcuprice()));
        textQuantity.setText(Integer.toString(getCartList().get(index).getcquantity()));
        try{
           
               Connection con = getConnection();
               PreparedStatement ps = con.prepareStatement("Select * from product where id = ? ");
               
               ps.setInt(1,Integer.parseInt(textProdId.getText()));
               ResultSet rs = ps.executeQuery();
               
               while(rs.next()){
                   labelPreview.setIcon(ResizeImage(null,rs.getBytes("image")));
                   textName.setText(rs.getString("name"));
                   textInStock.setText(Integer.toString(rs.getInt("quantity")));
                   textUPrice.setText(Integer.toString(rs.getInt("price")));
               }
             

               
         
            }catch(SQLException ex){ 
                System.out.println(ex);
            }
        
        
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCart = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        textProdId = new javax.swing.JTextField();
        buttonSearch = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        labelPreview = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textInStock = new javax.swing.JTextField();
        buttonAdd = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        textUPrice = new javax.swing.JTextField();
        buttonDelete = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        textQuantity = new javax.swing.JTextField();
        textGrand = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        buttonConfirm = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        textName = new javax.swing.JTextField();
        buttonEdit = new javax.swing.JButton();
        buttonBack = new javax.swing.JButton();
        buttonSearchName = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(249, 182, 196));

        tableCart.setBackground(new java.awt.Color(195, 228, 189));
        tableCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Unit Price", "Quantity", "Total Price"
            }
        ));
        tableCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCartMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCart);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("In Stock:");

        textProdId.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        buttonSearch.setBackground(new java.awt.Color(113, 200, 255));
        buttonSearch.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        buttonSearch.setText("Search");
        buttonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Product ID:");

        labelPreview.setBackground(new java.awt.Color(221, 244, 176));
        labelPreview.setOpaque(true);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Preview:");

        textInStock.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        buttonAdd.setBackground(new java.awt.Color(195, 221, 168));
        buttonAdd.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        buttonAdd.setText("Add To Cart");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Unit Price:");

        textUPrice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        buttonDelete.setBackground(new java.awt.Color(201, 69, 109));
        buttonDelete.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        buttonDelete.setText("Delete From Cart");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Quantity:");

        textQuantity.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        textGrand.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel6.setText("GRAND TOTAL:");

        buttonConfirm.setBackground(new java.awt.Color(175, 204, 250));
        buttonConfirm.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        buttonConfirm.setText("Checkout");
        buttonConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfirmActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Name:");

        textName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        buttonEdit.setBackground(new java.awt.Color(231, 244, 132));
        buttonEdit.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        buttonEdit.setText("Edit Cart");
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });

        buttonBack.setBackground(new java.awt.Color(187, 229, 231));
        buttonBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        buttonBack.setText("Back");
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackActionPerformed(evt);
            }
        });

        buttonSearchName.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        buttonSearchName.setText("Search");
        buttonSearchName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel7)
                                .addComponent(jLabel3)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(23, 23, 23)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(textProdId, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(textInStock, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textUPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonSearchName))
                            .addComponent(labelPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(buttonBack)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(191, 191, 191)
                                .addComponent(textGrand, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textGrand, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textProdId, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(buttonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(buttonSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(86, 86, 86)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textInStock, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(textUPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
        this.setVisible(false);
        new CustomerInterface(username).setVisible(true);
    }//GEN-LAST:event_buttonBackActionPerformed

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
        String UpdateQuery = null;
        PreparedStatement ps = null;
        Connection con = getConnection();

        try {
            UpdateQuery = "Update cart set quantity = ? where prod_id = ? and customer_username = ?";
            ps = con.prepareStatement(UpdateQuery);

            int quantity = Integer.parseInt(textQuantity.getText());
            ps.setDouble(1,quantity);
            ps.setInt(2,Integer.parseInt(textProdId.getText()));
            ps.setString(3,username);

            ps.executeUpdate();
            ShowCartProducts();
            JOptionPane.showMessageDialog(null,"Cart has been updated");

        } catch (SQLException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonEditActionPerformed

    private void buttonConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfirmActionPerformed
        this.setVisible(false);
        new Checkout(username,grandTotal).setVisible(true);
    }//GEN-LAST:event_buttonConfirmActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        if(!textProdId.getText().equals(""))
        {
            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("delete from cart where prod_id =? and customer_username = ?");
                int id = Integer.parseInt(textProdId.getText());
                ps.setInt(1,id);
                ps.setString(2,username);
                ps.executeUpdate();
                ShowCartProducts();

                JOptionPane.showMessageDialog(null,"Product has been deleted from Cart");
            } catch (SQLException ex) {
                Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Product not deleted.Enter valid ID");
            }
        }
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed

        if(Integer.parseInt(textQuantity.getText())<=Integer.parseInt(textInStock.getText()) && Integer.parseInt(textQuantity.getText())> 0){
            try{

                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("Insert into cart values (?,?,?,?,?) ");

                ps.setInt(1,Integer.parseInt(textProdId.getText()));
                ps.setString(2,username);
                ps.setString(3,textName.getText());
                ps.setInt(4,Integer.parseInt(textUPrice.getText()));
                ps.setInt(5,Integer.parseInt(textQuantity.getText()));
                ps.executeQuery();

                ShowCartProducts();
                JOptionPane.showMessageDialog(null, "Product Added to Cart");

            }catch(SQLException ex){
                System.out.println(ex);

            }
        }else{
            JOptionPane.showMessageDialog(null, "Enter  Valid Quantity");
        }
    }//GEN-LAST:event_buttonAddActionPerformed

    private void buttonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchActionPerformed

        if(checkInputs()){
            try{

                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("Select * from product where id = ? ");

                ps.setInt(1,Integer.parseInt(textProdId.getText()));
                ResultSet rs = ps.executeQuery();

                boolean found = false;

                while(rs.next()){
                    found = true;
                    labelPreview.setIcon(ResizeImage(null,rs.getBytes("image")));
                    textName.setText(rs.getString("name"));
                    textInStock.setText(Integer.toString(rs.getInt("quantity")));
                    textUPrice.setText(Integer.toString(rs.getInt("price")));
                }

                if(found)JOptionPane.showMessageDialog(null, "Product Found");
                else {
                    labelPreview.setIcon(null);
                    textName.setText(null);
                    textInStock.setText(null);
                    textUPrice.setText(null);

                    JOptionPane.showMessageDialog(null, "Product not Found");
                }

            }catch(SQLException ex){
                System.out.println(ex);

            }
        }else{
            JOptionPane.showMessageDialog(null, "Input Product ID");

        }
    }//GEN-LAST:event_buttonSearchActionPerformed

    private void tableCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCartMouseClicked
        int index = tableCart.getSelectedRow();
        ShowItem(index);
    }//GEN-LAST:event_tableCartMouseClicked

    private void buttonSearchNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchNameActionPerformed
        if(checkInputs2()){
            try{

                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("Select * from product where upper(product.name) like upper(?)");

                ps.setString(1,textName.getText());
                ResultSet rs = ps.executeQuery();

                boolean found = false;

                while(rs.next()){
                    found = true;
                    textProdId.setText(Integer.toString(rs.getInt("id")));
                    labelPreview.setIcon(ResizeImage(null,rs.getBytes("image")));
                    textName.setText(rs.getString("name"));
                    textInStock.setText(Integer.toString(rs.getInt("quantity")));
                    textUPrice.setText(Integer.toString(rs.getInt("price")));
                }

                if(found)JOptionPane.showMessageDialog(null, "Product Found");
                else {
                    labelPreview.setIcon(null);
                    textName.setText(null);
                    textInStock.setText(null);
                    textUPrice.setText(null);

                    JOptionPane.showMessageDialog(null, "Product not Found");
                }

            }catch(SQLException ex){
                System.out.println(ex);

            }
        }else{
            JOptionPane.showMessageDialog(null, "Input Product Name");

        }
    }//GEN-LAST:event_buttonSearchNameActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonBack;
    private javax.swing.JButton buttonConfirm;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonSearch;
    private javax.swing.JButton buttonSearchName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelPreview;
    private javax.swing.JTable tableCart;
    private javax.swing.JTextField textGrand;
    private javax.swing.JTextField textInStock;
    private javax.swing.JTextField textName;
    private javax.swing.JTextField textProdId;
    private javax.swing.JTextField textQuantity;
    private javax.swing.JTextField textUPrice;
    // End of variables declaration//GEN-END:variables

}
