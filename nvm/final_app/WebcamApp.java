/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package final_app;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Dimension;
import final_app.display_Product;
/**
 *
 * @author jhyvriel
 */
public class WebcamApp extends javax.swing.JFrame {
    private static com.github.sarxos.webcam.Webcam webcam; // Webcam object
    private static JLabel resultLabel;
    private volatile String processedBarcode = null; // Flag to store the last processed barcode

    public WebcamApp() {
        webcam = Webcam.getDefault();  // Try to get the default webcam

if (webcam == null) {
    JOptionPane.showMessageDialog(null, "No webcam detected! Exiting...");
    System.exit(1);  // Exit if no webcam is found
} else {
    System.out.println("Webcam initialized successfully.");
}
if (webcam.isOpen()) {
    webcam.close();
}

        webcam.setViewSize(new Dimension(640, 480));

        getContentPane().removeAll();
        setLayout(new BorderLayout());

        // Webcam panel
        WebcamPanel webcamPanel = new WebcamPanel(webcam);
        webcamPanel.setFPSDisplayed(true);
        webcamPanel.setDisplayDebugInfo(true);
        webcamPanel.setImageSizeDisplayed(true);
        webcamPanel.setMirrored(true);
        add(webcamPanel, BorderLayout.CENTER);

        // Result label
        resultLabel = new JLabel("Place a barcode/QR code in front of the camera...", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(resultLabel, BorderLayout.SOUTH);

        // JFrame properties
        setTitle("Barcode Scanner Application");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        startBarcodeScanner();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                closeWebcam();
                // Open the ScanNow JFrame
                /*ScanNow scanNowFrame = new ScanNow();
                scanNowFrame.setVisible(true);*/
            }
        });
    }
private void startBarcodeScanner() {
    new Thread(() -> {
        while (true) {
            try {
                // Check if the webcam is properly initialized and open
                if (webcam != null && webcam.isOpen()) {
                    BufferedImage image = webcam.getImage();
                    if (image != null) {
                        String result = scanBarcode(image);
                        if (result != null && !result.equals(processedBarcode)) {
                            processedBarcode = result; // Mark barcode as processed
                            SwingUtilities.invokeLater(() -> {
                                resultLabel.setText("Decoded: " + result);
                                fetchProductFromDatabase(result);
                            });

                            // Optionally, you can clear the processedBarcode flag after some time 
                            // or after processing the result to allow new barcode detection.
                            // If you want an automatic restart for the scanner:
                            resetScanner();
                        }
                    }
                }
                
                // Small sleep to prevent excessive CPU usage and control barcode scanning speed
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }).start();
}

// Method to reset the scanner after each barcode is processed
private void resetScanner() {
    SwingUtilities.invokeLater(() -> {
        // Optionally reset or clear any UI elements related to scanning
        processedBarcode = null;  // Clear the processedBarcode flag for the next scan
        resultLabel.setText("Place a barcode/QR code in front of the camera..."); // Reset message
    });
}



    private String scanBarcode(BufferedImage image) {
        try {
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            Result result = new MultiFormatReader().decode(bitmap);
            return result.getText();
        } catch (NotFoundException e) {
            return null;
        }
    }

    private void fetchProductFromDatabase(String barcode) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn == null) return;

            String query = "SELECT * FROM addproduct WHERE barcode = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, barcode);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String productName = rs.getString("name");
                String details = rs.getString("details");
                double price = rs.getDouble("price");
                String location = rs.getString("location");
                String bar = rs.getString("barcode");
                byte[] pic = rs.getBytes("pic");

                // Pass data to display_Product JFrame
                display_Product productFrame = new display_Product(productName,details, price, location, bar, pic);
                productFrame.setVisible(true);
                this.dispose(); // Close scanner window
            } else {
                JOptionPane.showMessageDialog(this, "No product found for this barcode.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching product details!");
        }
    }

    private void closeWebcam() {
        if (webcam != null && webcam.isOpen()) {
            webcam.close();
            webcam = null; // Set webcam to null to prevent future calls causing recursion
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 204, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
        SwingUtilities.invokeLater(WebcamApp::new);
    }






    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
