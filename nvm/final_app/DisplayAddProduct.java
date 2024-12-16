/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package final_app;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jhyvriel
 */
public class DisplayAddProduct extends javax.swing.JFrame {

    /**
     * Creates new form DisplayAddProduct
     */
    public DisplayAddProduct() {
        initComponents();
         data();
         populateComboBox(); 
    }

 private int categoryCount;
 
 private void populateComboBox() {
     this.categoryCount = 0;
    try {
        // Load the MySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish database connection
        String url = "jdbc:mysql://localhost:3306/productscan"; // Update with your DB details
        Connection con = DriverManager.getConnection(url, "root", "");

        // Prepare and execute SQL query
        String query = "SELECT category FROM categories"; // Replace with your table and column names
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        // Clear existing items in the JComboBox (optional)
        jComboBox1.removeAllItems();

        // Populate the JComboBox with data from the ResultSet
        while (rs.next()) {
            String item = rs.getString("category"); // Replace "some_column" with your column name
            jComboBox1.addItem(item); // Add each item to the JComboBox
             categoryCount++;
        }
        
        
        // Close resources
        rs.close();
        ps.close();
        con.close();

    } catch (ClassNotFoundException e) {
        JOptionPane.showMessageDialog(this, "Database driver not found: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}
     private void data() {
    try {
        // Load the MySQL driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish connection
        String url = "jdbc:mysql://localhost:3306/productscan";
        Connection con = DriverManager.getConnection(url, "root", "");

        // SQL query to select account based on account name and password
        String query = "SELECT name,details,location,price,category FROM addproduct";
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();

        // Get column metadata
        ResultSetMetaData rsmd = rs.getMetaData();
        int cols = rsmd.getColumnCount();
        String[] colName = new String[cols];
        for (int i = 0; i < cols; i++) {
            colName[i] = rsmd.getColumnName(i + 1);
        }

        // Create a custom table model
        DefaultTableModel model = new DefaultTableModel(colName, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make all cells non-editable
            }
        };

        // Populate the table model with data
        while (rs.next()) {
            String[] row = new String[cols];
            for (int i = 0; i < cols; i++) {
                row[i] = rs.getString(i + 1);
            }
            model.addRow(row);
        }

        // Apply the model to the table
        jTable2.setModel(model);

        // Set left alignment for all cells
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        for (int i = 0; i < jTable2.getColumnCount(); i++) {
            jTable2.getColumnModel().getColumn(i).setCellRenderer(leftRenderer);

            // Disable column resizing
            jTable2.getColumnModel().getColumn(i).setResizable(false);
        }

        // Disable column reordering
        jTable2.getTableHeader().setReorderingAllowed(false);

        // Close resources
        rs.close();
        pst.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace(); // Print error for debugging
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Add_Product = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(750, 462));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Add_Product.setText("Add Product");
        Add_Product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_ProductActionPerformed(evt);
            }
        });
        jPanel1.add(Add_Product, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 410, -1, 30));

        jPanel3.setBackground(new java.awt.Color(0, 204, 255));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane2.setBorder(null);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel4.setBackground(new java.awt.Color(0, 204, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(600, 280));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTable2);

        jPanel4.add(jScrollPane3);

        jScrollPane2.setViewportView(jPanel4);

        jPanel3.add(jScrollPane2);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 510, 280));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SEARCH FOR PRODUCTS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 340, 60));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 140, 30));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 180, 30));

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, 90, 30));

        jButton3.setText("Refresh");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/BSIT_LOGO.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 100, 100));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText("Price Checker and Locator");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jButton1.setText("←");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jButton4.setText("Delete Product");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, -1, -1));

        jButton5.setText("Update Product");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 420, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Add_ProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_ProductActionPerformed
        // TODO add your handling code here:
        AddProduct pi = new AddProduct();
        pi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Add_ProductActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String combo = (String) jComboBox1.getSelectedItem(); // Get the selected column from the combo box
        String input = jTextField1.getText(); // Get the user's input text

    // Validate user input
   

    try {
        // Load the MySQL driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish connection
        String url = "jdbc:mysql://localhost:3306/productscan";
        Connection con = DriverManager.getConnection(url, "root", "");

        PreparedStatement dis = null;
        // Dynamically build query
      if (input == null || input.trim().isEmpty()) {
    String search = "SELECT name,details,location,price,category FROM addproduct WHERE category = ?";
    dis = con.prepareStatement(search);
    dis.setString(1, combo); // Use a parameterized query for security
} else {
    String search = "SELECT name,details,location,price,category FROM addproduct WHERE category = ? AND name = ?";
    dis = con.prepareStatement(search);
    dis.setString(1, combo); // Use placeholders for query parameters
    dis.setString(2, input);
}

// Execute query
ResultSet rs = dis.executeQuery();

// Check if the ResultSet contains data
if (!rs.isBeforeFirst()) { // No data
    JOptionPane.showMessageDialog(this, "No matching records found.", "Search Result", JOptionPane.INFORMATION_MESSAGE);
    
    // Close resources to prevent memory leaks
    rs.close();
    dis.close();
    con.close();
    return; // Stop further execution
}

        // Get table metadata to set column headers
        ResultSetMetaData rsmd = rs.getMetaData(); 
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        
        // Clear existing data and set column names
        model.setRowCount(0); // Clear table
        int cols = rsmd.getColumnCount();
        String[] colName = new String[cols];
        for (int i = 0; i < cols; i++) {
            colName[i] = rsmd.getColumnName(i + 1);
        }
        model.setColumnIdentifiers(colName);

        // Populate rows from ResultSet
        while (rs.next()) {
            Object[] row = new Object[cols];
            for (int i = 0; i < cols; i++) {
                row[i] = rs.getObject(i + 1);
            }
            model.addRow(row);
        }

        // Align text to the left in all cells
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        for (int i = 0; i < jTable2.getColumnCount(); i++) {
            jTable2.getColumnModel().getColumn(i).setCellRenderer(leftRenderer);
        }

        // Close resources
        rs.close();
        dis.close();
        con.close();

    }catch (SQLException sqlEx) {
    sqlEx.printStackTrace(); // Print SQL error for debugging
    JOptionPane.showMessageDialog(this, "Database error: " + sqlEx.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
} catch (Exception e) {
    e.printStackTrace(); // Print general error for debugging
    JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         try {
        // Load the MySQL driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish connection
        String url = "jdbc:mysql://localhost:3306/productscan";
        Connection con = DriverManager.getConnection(url, "root", "");

        // SQL query to select account based on account name and password
        String query = "SELECT name,details,location,price,category FROM addproduct";
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();

        // Get column metadata
        ResultSetMetaData rsmd = rs.getMetaData();
        int cols = rsmd.getColumnCount();
        String[] colName = new String[cols];
        for (int i = 0; i < cols; i++) {
            colName[i] = rsmd.getColumnName(i + 1);
        }

        // Create a custom table model
        DefaultTableModel model = new DefaultTableModel(colName, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make all cells non-editable
            }
        };

        // Populate the table model with data
        while (rs.next()) {
            String[] row = new String[cols];
            for (int i = 0; i < cols; i++) {
                row[i] = rs.getString(i + 1);
            }
            model.addRow(row);
        }

        // Apply the model to the table
        jTable2.setModel(model);

        // Set left alignment for all cells
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        for (int i = 0; i < jTable2.getColumnCount(); i++) {
            jTable2.getColumnModel().getColumn(i).setCellRenderer(leftRenderer);

            // Disable column resizing
            jTable2.getColumnModel().getColumn(i).setResizable(false);
        }

        // Disable column reordering
        jTable2.getTableHeader().setReorderingAllowed(false);

        // Close resources
        rs.close();
        pst.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace(); // Print error for debugging
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Main_interface pi = new Main_interface ();
        pi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable2.getSelectedRow();
        if (selectedRow == -1) { // No row selected
    JOptionPane.showMessageDialog(this, "Please select a row first.", "Warning", JOptionPane.WARNING_MESSAGE);
    return; // Stop execution if no row is selected
}

    // Retrieve data from the selected row (assuming the first column contains the ID)
   // ID column
   

    try {
         String selectedItem = jTable2.getValueAt(selectedRow, 0).toString();
        // Load the MySQL driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish connection
        String url = "jdbc:mysql://localhost:3306/productscan"; // Replace with your database name
        Connection con = DriverManager.getConnection(url, "root", ""); // Update username and password if needed

        String del = "DELETE from addproduct where name = ?";
        PreparedStatement delStmt = con.prepareStatement(del);
 
        delStmt.setString(1, selectedItem);

        int moveResult = delStmt.executeUpdate();
            if (moveResult > 0) {
                // Remove the row from the JTable
                DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                model.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Item moved and removed successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to remove the item from the current table.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        

        // Close statements and connection
        delStmt.close();
        

    } catch (ClassNotFoundException e) {
        JOptionPane.showMessageDialog(this, "MySQL JDBC Driver not found! " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "SQL Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        update pi = new update ();
        pi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(DisplayAddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DisplayAddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DisplayAddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DisplayAddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DisplayAddProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add_Product;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
