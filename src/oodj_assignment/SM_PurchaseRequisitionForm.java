
package oodj_assignment;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raida
 */
public class SM_PurchaseRequisitionForm extends javax.swing.JFrame {

    private DefaultTableModel model = new DefaultTableModel();
    private List<String[]> prDataList = new ArrayList<>(); // Store PR data
    private static final String PR_FILE_PATH = "src\\oodj_assignment_data\\PurchaseRequisition.txt";
    
    String[] columnName = {"PrID", "itemID", "Quantity", "PRDate", "supplierID", "prStatus"};

    public SM_PurchaseRequisitionForm() {
        model.setColumnIdentifiers(columnName);
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnLoad = new javax.swing.JButton();
        BtnGenerate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        label1 = new java.awt.Label();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BtnLoad.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        BtnLoad.setText("Load");
        BtnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLoadActionPerformed(evt);
            }
        });

        BtnGenerate.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        BtnGenerate.setText("Generate");
        BtnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGenerateActionPerformed(evt);
            }
        });

        jTable1.setModel(model);
        jScrollPane1.setViewportView(jTable1);

        label1.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 48)); // NOI18N
        label1.setText("Purchase Requisition");

        jButton1.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 24)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(215, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnGenerate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnLoad, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(73, 73, 73))
            .addGroup(layout.createSequentialGroup()
                .addGap(376, 376, 376)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(271, Short.MAX_VALUE)
                .addComponent(BtnGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLoadActionPerformed
        // Clear existing table data
        model.setRowCount(0);

        try (BufferedReader br = new BufferedReader(new FileReader(PR_FILE_PATH))) {
            String line;
            boolean isFirstLine = true; // Flag to skip the header line
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the header line
                }
                String[] rowData = line.split(",");
                model.addRow(rowData);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading PR file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_BtnLoadActionPerformed

    private boolean isDuplicatePR(String itemID, String stockUpdateDate) {
        for (String[] pr : prDataList) {
            if (pr[1].equals(itemID) && pr[3].equals(stockUpdateDate)) {
                return true; // Duplicate found
            }
        }
        return false; // No duplicate found
    }

    
    private void BtnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGenerateActionPerformed
        
        String inventoryFilePath = "src\\oodj_assignment_data\\InventoryData.txt";
    List<String[]> newPRs = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(inventoryFilePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] inventoryItem = line.split(","); // Split each line into columns
            String itemID = inventoryItem[0];
            String stockStatus = inventoryItem[8];
            String quantityReq = inventoryItem[9];
            String stockUpdateDate = inventoryItem[6];
            String supplierID = inventoryItem[7];

            // Check if the item is understock and not already in the PR list
            if ("Understock".equalsIgnoreCase(stockStatus) && !isDuplicatePR(itemID, stockUpdateDate)) {
                // Generate new PR ID
                String newPrID = "PR" + (model.getRowCount() + newPRs.size() + 1);
                String[] newPR = {newPrID, itemID, quantityReq, stockUpdateDate, supplierID, "Pending"};
                newPRs.add(newPR);
                model.addRow(newPR); // Add to the table model
            }
        }

        // Write the new PRs to the PR file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PR_FILE_PATH, true))) {
            for (String[] pr : newPRs) {
                bw.write(String.join(",", pr));
                bw.newLine();
            }
        }
        JOptionPane.showMessageDialog(this, "PRs generated successfully.");
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error generating PRs: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_BtnGenerateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new SM_MainPage().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

 
    
    
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
            java.util.logging.Logger.getLogger(SM_PurchaseRequisitionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SM_PurchaseRequisitionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SM_PurchaseRequisitionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SM_PurchaseRequisitionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SM_PurchaseRequisitionForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnGenerate;
    private javax.swing.JButton BtnLoad;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
