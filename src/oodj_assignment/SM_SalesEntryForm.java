
package oodj_assignment;
import oodj_assignment_functions.SalesEntryFileManager;
import oodj_assignment_functions.SalesEntry;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class SM_SalesEntryForm extends javax.swing.JFrame {
    
    private List<SalesEntry> salesEntries = new ArrayList<>();
    private DefaultTableModel model = new DefaultTableModel();
    private String[] columnName = {"Item code","Item name","Category","Quantity","Date"};
    private int row = -1;
   
    public SM_SalesEntryForm() {
        model.setColumnIdentifiers(columnName);
        initComponents();
    }

    private boolean validateInputs(){
        
        if (TFItemCode.getText().isEmpty() || TFItemName.getText().isEmpty() || 
            TFCategory.getText().isEmpty() || TFQuantity.getText().isEmpty() || 
            TFDate.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled!");
            return false;
            
        }
        
        try {
            Integer.parseInt(TFQuantity.getText());}
                    
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantity must be a number!");
            return false;}

        return true;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BtnAdd = new javax.swing.JButton();
        BtnEdit = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();
        TFItemCode = new javax.swing.JTextField();
        TFItemName = new javax.swing.JTextField();
        TFCategory = new javax.swing.JTextField();
        TFQuantity = new javax.swing.JTextField();
        TFDate = new javax.swing.JTextField();
        BtnSave = new javax.swing.JButton();
        BtnLoad = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(model);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Item Code");

        jLabel2.setText("Item Name");

        jLabel3.setText("Category");

        jLabel4.setText("Quantity");

        jLabel5.setText("Date");

        BtnAdd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnAdd.setText("Add");
        BtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddActionPerformed(evt);
            }
        });

        BtnEdit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnEdit.setText("Edit");
        BtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditActionPerformed(evt);
            }
        });

        BtnDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnDelete.setText("Delete");
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });

        TFItemCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFItemCodeActionPerformed(evt);
            }
        });

        TFItemName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFItemNameActionPerformed(evt);
            }
        });

        TFQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFQuantityActionPerformed(evt);
            }
        });

        BtnSave.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnSave.setText("Save");
        BtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSaveActionPerformed(evt);
            }
        });

        BtnLoad.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnLoad.setText("Load");
        BtnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLoadActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 48)); // NOI18N
        jLabel6.setText("Daily Sales Entry");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(BtnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jButton1)
                .addGap(370, 370, 370))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFDate, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(BtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(213, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(TFItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(TFItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TFCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(122, 122, 122)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(25, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row !");
            return;}

    // Confirm before deleting
        int confirmation = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to delete this row?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION
        );

        if (confirmation == JOptionPane.YES_OPTION) {
            model.removeRow(row);
            salesEntries.remove(row);
            clearTextField();         }
    }//GEN-LAST:event_BtnDeleteActionPerformed

    private void TFItemCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFItemCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFItemCodeActionPerformed

    private void BtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddActionPerformed
        if(!validateInputs()) return; 
        
        SalesEntry entry = new SalesEntry(
            TFItemCode.getText(),
            TFItemName.getText(),
            TFCategory.getText(),
            Integer.parseInt(TFQuantity.getText()),
            TFDate.getText()
        );

        salesEntries.add(entry); // Add to list
        model.addRow(entry.toArray()); // Add to table model
        clearTextField();
    }//GEN-LAST:event_BtnAddActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        row = jTable1.getSelectedRow();
        //is to get value from model based on selected row and fixed column numebr
        String itemCode = String.valueOf(model.getValueAt(row,0));
        String itemName = String.valueOf(model.getValueAt(row,1));
        String category =String.valueOf(model.getValueAt(row,2));
        String quantity =String.valueOf(model.getValueAt(row,3));
        String date =String.valueOf(model.getValueAt(row,4));
        
        //once i get value i will use them and display on respective textfield
        TFItemCode.setText(itemCode);
        TFItemName.setText(itemName);
        TFCategory.setText(category);
        TFQuantity.setText(quantity);
        TFDate.setText(date);
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditActionPerformed
        
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row first!");
            return;
        }

        if(!validateInputs()) return; // Apply input validation

            // Update the table model with new data from text fields
            model.setValueAt(TFItemCode.getText(), row, 0);
            model.setValueAt(TFItemName.getText(), row, 1);
            model.setValueAt(TFCategory.getText(), row, 2);
            model.setValueAt(TFQuantity.getText(), row, 3);
            model.setValueAt(TFDate.getText(), row, 4);

            // Update the SalesEntry list to reflect the change
            SalesEntry entry = salesEntries.get(row);
            entry.setItemCode(TFItemCode.getText());
            entry.setItemName(TFItemName.getText());
            entry.setCategory(TFCategory.getText());
            entry.setQuantity(Integer.parseInt(TFQuantity.getText()));
            entry.setDate(TFDate.getText());

            
            
            clearTextField(); // Optional: Clear text fields after edit
        
    }//GEN-LAST:event_BtnEditActionPerformed

    private void BtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaveActionPerformed
        try {
            SalesEntryFileManager.saveToFile( salesEntries, "src\\oodj_assignment_data\\SalesEntry1.txt");
            JOptionPane.showMessageDialog(this, "Data saved successfully!");
        } 
        catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + e.getMessage());
        }
        
    }//GEN-LAST:event_BtnSaveActionPerformed

    private void loadFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            model.setRowCount(0); // Clear existing data
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    // Skip header row
                    isHeader = false;
                    continue;
                }

                // Split line into columns and add to model
                String[] data = line.split(",");
                model.addRow(data);
            }

            JOptionPane.showMessageDialog(this, "Data loaded successfully!");
            } 
        
        
        catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading file: " + e.getMessage());
        }
    }

    
    
    private void BtnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLoadActionPerformed
        
        try {
            salesEntries = SalesEntryFileManager.loadFromFile("src\\oodj_assignment_data\\SalesEntry1.txt");
            model.setRowCount(0); // Clear table
            for (SalesEntry entry : salesEntries) {
                model.addRow(entry.toArray());
            }
            JOptionPane.showMessageDialog(this, "Data loaded successfully!");
        } 
        catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading file: " + e.getMessage());
        }
        
        
    }//GEN-LAST:event_BtnLoadActionPerformed

    private void TFItemNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFItemNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFItemNameActionPerformed

    private void TFQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFQuantityActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new SM_MainPage().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    
    private void clearTextField(){
        TFItemCode.setText("");
        TFItemName.setText("");
        TFCategory.setText("");
        TFQuantity.setText("");
        TFDate.setText("");
        
    }
    
    
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
            java.util.logging.Logger.getLogger(SM_SalesEntryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SM_SalesEntryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SM_SalesEntryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SM_SalesEntryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SM_SalesEntryForm().setVisible(true);
            }
        });
    }
    
    
    private void saveToFile(String filePath){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            // Write column headers
            for (int i = 0; i < model.getColumnCount(); i++) {
                bw.write(model.getColumnName(i) + (i == model.getColumnCount() - 1 ? "" : ","));
            }
            bw.newLine();

            // Write table data
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    bw.write(model.getValueAt(i, j).toString() + (j == model.getColumnCount() - 1 ? "" : ","));
                }
                bw.newLine();
            }

            JOptionPane.showMessageDialog(this, "Data saved successfully!");
        } 
        catch (IOException e){
            JOptionPane.showMessageDialog(this, "Error saving file: " + e.getMessage());
        }     
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAdd;
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnEdit;
    private javax.swing.JButton BtnLoad;
    private javax.swing.JButton BtnSave;
    private javax.swing.JTextField TFCategory;
    private javax.swing.JTextField TFDate;
    private javax.swing.JTextField TFItemCode;
    private javax.swing.JTextField TFItemName;
    private javax.swing.JTextField TFQuantity;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}


