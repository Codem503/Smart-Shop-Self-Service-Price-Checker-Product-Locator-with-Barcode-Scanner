/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package final_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author jhyvriel
 */
public class update extends javax.swing.JFrame {

    /**
     * Creates new form update
     */
    public update() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        P1 = new javax.swing.JTextField();
        L2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        namep = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        D3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        B4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        P1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(P1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 130, -1));

        L2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(L2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 290, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Price");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Location");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, -1, -1));

        jButton2.setText("←");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        namep.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        namep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namepActionPerformed(evt);
            }
        });
        jPanel1.add(namep, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 290, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Product Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Details");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 60, -1));

        D3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(D3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 290, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Barcode");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        B4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(B4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 290, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/BSIT_LOGO.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel7.setText("Price Checker and Locator");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, -1, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("copyright@PriceChecker&locator All rights reserved");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        DisplayAddProduct pi = new DisplayAddProduct();
        pi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
          String Price = P1.getText();
    String Location = L2.getText();
    String Details = D3.getText();
    String Barcode = B4.getText();
    String Name = namep.getText();

    if (Price == null || Price.trim().isEmpty() || 
        Location == null || Location.trim().isEmpty() ||  
        Details == null || Details.trim().isEmpty() || 
        Barcode == null || Barcode.trim().isEmpty() || 
        Name == null || Name.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "PLEASE ENTER ALL FIELDS!", "Input Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        // Load the MySQL driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish connection
        Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/ProductScan", "root", "");

        // Correct SQL query to update the product details where name matches
        String query = "UPDATE addproduct SET price = ?, location = ?, details = ?, barcode = ? WHERE name = ?";

        // Prepare the statement
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, Price);      // Set price
        pst.setString(2, Location);  // Set location
        pst.setString(3, Details);   // Set details
        pst.setString(4, Barcode);   // Set barcode
        pst.setString(5, Name);      // Identify product by name

        // Execute the query
        int update = pst.executeUpdate();

        if (update > 0) {
            JOptionPane.showMessageDialog(null, "Product updated successfully!", "Update Info", JOptionPane.INFORMATION_MESSAGE);
            DisplayAddProduct pi = new DisplayAddProduct();
            pi.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Failed to update product. Check if the Name exists.", "Update Error", JOptionPane.WARNING_MESSAGE);
        }

        // Close resources
        pst.close();
        con.close();
    } catch (Exception e) {
        // Handle any errors that occur
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void namepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namepActionPerformed

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
            java.util.logging.Logger.getLogger(update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new update().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField B4;
    private javax.swing.JTextField D3;
    private javax.swing.JTextField L2;
    private javax.swing.JTextField P1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField namep;
    // End of variables declaration//GEN-END:variables
}
