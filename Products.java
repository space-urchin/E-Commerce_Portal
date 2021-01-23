
package prototype;
import java.util.*;
import java.awt.*;
import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;




public class Products extends javax.swing.JFrame {

    /**
     * Creates new form Products
     */
    public Products() {
        initComponents();
        ShowProducts();
  
       texthtype.setSelectedItem(null);
       texthtexture.setSelectedItem(null);
       textFeature.setSelectedItem(null);
      
    }
    
    String ImagePath = null;
    int pos = 0;

    public Connection getConnection(){
        
        Connection con = null;
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","fariha","1234");

            
            return con;

         
        }catch(Exception e){ 
                System.out.println(e);
                return con;
            }
    }
    
    public boolean checkInputs(){
        
        if(textName.getText() == null || textPrice.getText() == null ||  textQuantity.getText() == null){
            return false;
        }
        else{
            try{
                Double.parseDouble(textPrice.getText());
                return true;
            }catch(Exception es){
                return false;
            }
            
        }
    }
    
     public boolean checkInputs1(){
        
        if(textId.getText() == null){
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
        Image img2 = img.getScaledInstance(labelImage.getWidth(),labelImage.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;
    }
    
    public ArrayList<Product> getProductList(){
        ArrayList<Product> productList = new ArrayList<Product>();
        Connection con = getConnection();
        String query = "Select * from Product";
        
        Statement st;
        ResultSet rs;
        
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            Product product;
            
            while(rs.next()){
                product =new Product(rs.getInt("id"),rs.getString("name"),Double.parseDouble(rs.getString("price")),rs.getInt("quantity"),rs.getString("date_added"), rs.getBytes("image"),rs.getString("hair_type"),rs.getString("hair_texture"),rs.getString("features"));
                productList.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return productList;
        
    }
    
    public void ShowProducts(){
        
        ArrayList<Product> list = getProductList();
        DefaultTableModel model = (DefaultTableModel)tableProduct.getModel();
        model.setRowCount(0);
        
        Object[] row = new Object[8];
        for(int i =0; i <list.size();i++){
            row[0] = list.get(i).getid();
            row[1] = list.get(i).getname();
            row[2] = list.get(i).getprice();
            row[3] = list.get(i).getquantity();
            row[4] = list.get(i).getDate();
            row[5] = list.get(i).getType();
            row[6] = list.get(i).getTexture();
            row[7] = list.get(i).getFeature();
            
            model.addRow(row);
            
        }
        
    
    }
    
    public void ShowItem(int index){
        textId.setText(Integer.toString(getProductList().get(index).getid()));
        textName.setText(getProductList().get(index).getname());
        textPrice.setText(Double.toString(getProductList().get(index).getprice()));
        textQuantity.setText(Integer.toString(getProductList().get(index).getquantity()));
        textDate.setText(getProductList().get(index).getDate());
        labelImage.setIcon(ResizeImage(null,getProductList().get(index).getimage()));
        texthtype.setSelectedItem(getProductList().get(index).getType());
        texthtexture.setSelectedItem(getProductList().get(index).getTexture());
        textFeature.setSelectedItem(getProductList().get(index).getFeature());
        
        
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        textId1 = new javax.swing.JTextField();
        texthtexture1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProduct = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textDate = new javax.swing.JTextField();
        textPrice = new javax.swing.JTextField();
        textName = new javax.swing.JTextField();
        textId = new javax.swing.JTextField();
        labelImage = new javax.swing.JLabel();
        buttonChoose = new javax.swing.JButton();
        buttonInsert = new javax.swing.JButton();
        buttonUpdate = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        buttonPrevious = new javax.swing.JButton();
        buttonNext = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        textQuantity = new javax.swing.JTextField();
        buttonBack = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        texthtype = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        texthtexture = new javax.swing.JComboBox<>();
        textFeature = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        buttonSearchID = new javax.swing.JButton();
        buttonSearchName = new javax.swing.JButton();
        buttonClear = new javax.swing.JButton();

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        textId1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        texthtexture1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fine", "Medium", "Thick or Coarse" }));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 51, 102));
        jLabel11.setText("*");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 102));
        jLabel13.setText("*");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 51, 102));
        jLabel16.setText("*");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 51, 102));
        jLabel18.setText("*");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 51, 102));
        jLabel20.setText("*");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 229, 217));

        tableProduct.setBackground(new java.awt.Color(161, 204, 255));
        tableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Price", "Quantity", "Date Added", "Hair Type", "Hair Texture", "Feature"
            }
        ));
        tableProduct.setGridColor(new java.awt.Color(128, 167, 113));
        tableProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableProduct);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Price");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Date Added");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Image");

        textDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        textPrice.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        textName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        textId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        labelImage.setBackground(new java.awt.Color(171, 156, 195));
        labelImage.setOpaque(true);

        buttonChoose.setText("Choose Image");
        buttonChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChooseActionPerformed(evt);
            }
        });

        buttonInsert.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        buttonInsert.setText("Insert");
        buttonInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInsertActionPerformed(evt);
            }
        });

        buttonUpdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        buttonUpdate.setText("Update");
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });

        buttonDelete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        buttonDelete.setText("Delete");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        buttonPrevious.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        buttonPrevious.setText("Previous");
        buttonPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPreviousActionPerformed(evt);
            }
        });

        buttonNext.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        buttonNext.setText("Next");
        buttonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNextActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Quantity");

        textQuantity.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        buttonBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        buttonBack.setText("Back");
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Hair Type");

        texthtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Straight", "Wavy", "Curly", "Kinky" }));
        texthtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texthtypeActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Hair Texture");

        texthtexture.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fine", "Medium", "Thick or Coarse" }));

        textFeature.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hair Regrowth", "Anti Dandruff", "Hair Strenthening", "Nourishing", "Shine" }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Feature");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 102));
        jLabel10.setText("*");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 102));
        jLabel12.setText("*");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 51, 102));
        jLabel14.setText("*");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 51, 102));
        jLabel15.setText("*");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 51, 102));
        jLabel17.setText("*");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 51, 102));
        jLabel19.setText("*");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 51, 102));
        jLabel21.setText("*");

        buttonSearchID.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        buttonSearchID.setText("Search");
        buttonSearchID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchIDActionPerformed(evt);
            }
        });

        buttonSearchName.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        buttonSearchName.setText("Search");
        buttonSearchName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchNameActionPerformed(evt);
            }
        });

        buttonClear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        buttonClear.setText("Clear");
        buttonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(textDate, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonSearchID))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonSearchName))
                            .addComponent(labelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texthtype, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textFeature, javax.swing.GroupLayout.Alignment.TRAILING, 0, 1, Short.MAX_VALUE)
                            .addComponent(texthtexture, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE))
                        .addGap(222, 222, 222)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(buttonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(84, 84, 84)
                                        .addComponent(buttonPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(63, 63, 63)
                                        .addComponent(buttonNext, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(buttonInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(179, 179, 179))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(buttonSearchID, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(57, 57, 57))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textDate, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(122, 122, 122)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonChoose))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonPrevious, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(texthtype, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addComponent(buttonNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(texthtexture, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textFeature, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel9)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChooseActionPerformed
       
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images","jpg","jpeg","png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            labelImage.setIcon(ResizeImage(path,null));
            ImagePath = path;
        }
        else{
            System.out.println("No file selected");
        }
        
        
    }//GEN-LAST:event_buttonChooseActionPerformed

    private void buttonInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInsertActionPerformed
        
        if(checkInputs() && ImagePath!=null){
           try{
           
               Connection con = getConnection();
               PreparedStatement ps = con.prepareStatement("Insert into product(name,price,quantity,date_added,image,hair_type,hair_texture,features) values(?,?,?,?,?,?,?,?) ");
               
               //ps.setInt(1,Integer.parseInt(textId.getText()));
               ps.setString(1,textName.getText());
               
               double price = Double.parseDouble(textPrice.getText());
               ps.setDouble(2,price);
               ps.setInt(3,Integer.parseInt(textQuantity.getText()));
                
               Date date = new Date();
               DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
               String strDate = dateFormat.format(date);
               
               ps.setString(4,strDate);
               
               InputStream img = new FileInputStream(new File(ImagePath));
               ps.setBlob(5,img);
               ps.setString(6,texthtype.getSelectedItem().toString());
               ps.setString(7,texthtexture.getSelectedItem().toString());
               ps.setString(8,textFeature.getSelectedItem().toString());
               ps.executeUpdate();
               ShowProducts();
               
               JOptionPane.showMessageDialog(null, "Data Saved");
               
         
            }catch(SQLException ex){ 
                System.out.println(ex);
               
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        else{
            JOptionPane.showMessageDialog(null, "One or more field are empty");
        }
    }//GEN-LAST:event_buttonInsertActionPerformed

    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
        
        if(checkInputs() && textId.getText()!=null){
            
            String UpdateQuery = null;
            PreparedStatement ps = null;
            Connection con = getConnection();
            
            if(ImagePath == null){
                
                try {
                    UpdateQuery = "Update product set name = ?, price = ?, quantity = ?, date_added = ? , hair_type = ?, hair_texture= ?, features = ? where id = ?";
                    ps = con.prepareStatement(UpdateQuery);
                    
                    ps.setString(1,textName.getText());
                    double price = Double.parseDouble(textPrice.getText());
                    ps.setDouble(2,price);
                    ps.setInt(3,Integer.parseInt(textQuantity.getText()));
                    ps.setString(4,textDate.getText());
                    ps.setString(5,texthtype.getSelectedItem().toString());
                    ps.setString(6,texthtexture.getSelectedItem().toString());
                    ps.setString(7,textFeature.getSelectedItem().toString());
                    ps.setInt(8,Integer.parseInt(textId.getText()));
                    ps.executeUpdate();
                    ShowProducts();
                    JOptionPane.showMessageDialog(null,"Record has been updated");
                   
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            else{
                try {
                    InputStream img = new FileInputStream(new File(ImagePath));
                    UpdateQuery = "Update product set name = ?, price = ?, quantity = ?, date_added = ?, image = ?, hair_type = ?, hair_texture= ?, features = ? where id = ?";
                    ps = con.prepareStatement(UpdateQuery);
                    
                    ps.setString(1,textName.getText());
                    double price = Double.parseDouble(textPrice.getText());
                    ps.setDouble(2,price);
                    ps.setInt(3,Integer.parseInt(textQuantity.getText()));
                    ps.setString(4,textDate.getText());
                    ps.setBlob(5,img);
                    ps.setString(6,texthtype.getSelectedItem().toString());
                    ps.setString(7,texthtexture.getSelectedItem().toString());
                    ps.setString(8,textFeature.getSelectedItem().toString());
                    ps.setInt(9,Integer.parseInt(textId.getText()));
                    ps.executeUpdate();
                    ShowProducts();
                    
                    JOptionPane.showMessageDialog(null,"Record has been updated");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
                 textId.setText(null);
                 labelImage.setIcon(null);
                 textName.setText(null);
                 textQuantity.setText(null);
                 textDate.setText(null);
                 textPrice.setText(null);
                 texthtype.setSelectedItem(null);
                 texthtexture.setSelectedItem(null);
                 textFeature.setSelectedItem(null);
            
        }else{
            JOptionPane.showMessageDialog(null,"One or more fields are invalid");
        }
    }//GEN-LAST:event_buttonUpdateActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        
        if(!textId.getText().equals(""))
        {
            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("delete from product where id =?");
                int id = Integer.parseInt(textId.getText());
                ps.setInt(1,id);
                ps.executeUpdate();
                ShowProducts();
      
                JOptionPane.showMessageDialog(null,"Product has been deleted");
                 textId.setText(null);
                 labelImage.setIcon(null);
                 textName.setText(null);
                 textQuantity.setText(null);
                 textDate.setText(null);
                 textPrice.setText(null);
                 texthtype.setSelectedItem(null);
                 texthtexture.setSelectedItem(null);
                 textFeature.setSelectedItem(null);
            } catch (SQLException ex) {
                Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Product not deleted.Enter valid ID");
            }
        }
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void tableProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductMouseClicked
        
        int index = tableProduct.getSelectedRow();
        ShowItem(index);
    }//GEN-LAST:event_tableProductMouseClicked

    private void buttonPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPreviousActionPerformed
        pos--;
        if(pos<0) pos = getProductList().size() - 1;
        ShowItem(pos);
    }//GEN-LAST:event_buttonPreviousActionPerformed

    private void buttonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNextActionPerformed
        pos++;
        if(pos > getProductList().size() - 1) pos = 0;
        ShowItem(pos);
    }//GEN-LAST:event_buttonNextActionPerformed

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
        this.setVisible(false);
        new AdminInterface().setVisible(true);
    }//GEN-LAST:event_buttonBackActionPerformed

    private void texthtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texthtypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texthtypeActionPerformed

    private void buttonSearchIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchIDActionPerformed
        if(checkInputs1()){
            try{

                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("Select * from product where id = ? ");

                ps.setInt(1,Integer.parseInt(textId.getText()));
                ResultSet rs = ps.executeQuery();

                boolean found = false;

                while(rs.next()){
                    found = true;
                    labelImage.setIcon(ResizeImage(null,rs.getBytes("image")));
                    textName.setText(rs.getString("name"));
                    textQuantity.setText(Integer.toString(rs.getInt("quantity")));
                    textDate.setText(rs.getString("date_added"));
                    textPrice.setText(Integer.toString(rs.getInt("price")));
                    texthtype.setSelectedItem(rs.getString("hair_type"));
                    texthtexture.setSelectedItem(rs.getString("hair_texture"));
                    textFeature.setSelectedItem(rs.getString("features"));
                }

                if(found)JOptionPane.showMessageDialog(null, "Product Found");
                else {
                    textId.setText(null);
                    labelImage.setIcon(null);
                    textName.setText(null);
                    textQuantity.setText(null);
                    textDate.setText(null);
                    textPrice.setText(null);
                    texthtype.setSelectedItem(null);
                    texthtexture.setSelectedItem(null);
                    textFeature.setSelectedItem(null);

                    JOptionPane.showMessageDialog(null, "Product not Found");
                }

            }catch(SQLException ex){
                System.out.println(ex);

            }
        }else{
            JOptionPane.showMessageDialog(null, "Input Product ID");

        }
    }//GEN-LAST:event_buttonSearchIDActionPerformed

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
                    textId.setText(Integer.toString(rs.getInt("id")));
                    labelImage.setIcon(ResizeImage(null,rs.getBytes("image")));
                    textName.setText(rs.getString("name"));
                    textQuantity.setText(Integer.toString(rs.getInt("quantity")));
                    textDate.setText(rs.getString("date_added"));
                    textPrice.setText(Integer.toString(rs.getInt("price")));
                    texthtype.setSelectedItem(rs.getString("hair_type"));
                    texthtexture.setSelectedItem(rs.getString("hair_texture"));
                    textFeature.setSelectedItem(rs.getString("features"));
                }

                if(found)JOptionPane.showMessageDialog(null, "Product Found");
                else {
                    textId.setText(null);
                    labelImage.setIcon(null);
                    textName.setText(null);
                    textQuantity.setText(null);
                    textDate.setText(null);
                    textPrice.setText(null);
                    texthtype.setSelectedItem(null);
                    texthtexture.setSelectedItem(null);
                    textFeature.setSelectedItem(null);

                    JOptionPane.showMessageDialog(null, "Product not Found");
                }

            }catch(SQLException ex){
                System.out.println(ex);

            }
        }else{
            JOptionPane.showMessageDialog(null, "Input Product ID");

        }
    }//GEN-LAST:event_buttonSearchNameActionPerformed

    private void buttonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearActionPerformed
                    textId.setText(null);
                    labelImage.setIcon(null);
                    textName.setText(null);
                    textQuantity.setText(null);
                    textDate.setText(null);
                    textPrice.setText(null);
                    texthtype.setSelectedItem(null);
                    texthtexture.setSelectedItem(null);
                    textFeature.setSelectedItem(null);

    }//GEN-LAST:event_buttonClearActionPerformed

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
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Products().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBack;
    private javax.swing.JButton buttonChoose;
    private javax.swing.JButton buttonClear;
    private javax.swing.JButton buttonDelete;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton buttonInsert;
    private javax.swing.JButton buttonNext;
    private javax.swing.JButton buttonPrevious;
    private javax.swing.JButton buttonSearchID;
    private javax.swing.JButton buttonSearchName;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel labelImage;
    private javax.swing.JTable tableProduct;
    private javax.swing.JTextField textDate;
    private javax.swing.JComboBox<String> textFeature;
    private javax.swing.JTextField textId;
    private javax.swing.JTextField textId1;
    private javax.swing.JTextField textName;
    private javax.swing.JTextField textPrice;
    private javax.swing.JTextField textQuantity;
    private javax.swing.JComboBox<String> texthtexture;
    private javax.swing.JComboBox<String> texthtexture1;
    private javax.swing.JComboBox<String> texthtype;
    // End of variables declaration//GEN-END:variables
}
