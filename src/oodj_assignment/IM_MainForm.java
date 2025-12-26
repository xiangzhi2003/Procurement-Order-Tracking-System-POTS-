package oodj_assignment;

import java.util.Scanner;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.List;
import javax.swing.*;
import oodj_assignment_functions.Inventory;

public class IM_MainForm extends javax.swing.JFrame {
    public IM_MainForm() { //creates new IM form
        initComponents();
    }
Inventory inventory = new Inventory(); 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        IM_Panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        IM_FunctionPanel = new javax.swing.JPanel();
        IM_ViewSupplier = new javax.swing.JButton();
        IM_ModifyInventory = new javax.swing.JButton();
        IM_ViewStock1 = new javax.swing.JButton();
        AM_LogOutBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        IM_OverviewTable = new javax.swing.JTable();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        IM_Panel.setBackground(new java.awt.Color(153, 153, 153));
        IM_Panel.setMinimumSize(new java.awt.Dimension(1050, 550));
        IM_Panel.setName("Inventory Manager Panel"); // NOI18N
        IM_Panel.setPreferredSize(new java.awt.Dimension(1050, 550));

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 30)); // NOI18N
        jLabel1.setText("Welcome, Inventory Manager");

        IM_FunctionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Inventory Manager Function Panel"));
        IM_FunctionPanel.setToolTipText("");
        IM_FunctionPanel.setName(""); // NOI18N

        IM_ViewSupplier.setBackground(new java.awt.Color(153, 153, 153));
        IM_ViewSupplier.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        IM_ViewSupplier.setText("View Supplier");
        IM_ViewSupplier.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        IM_ViewSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IM_ViewSupplierActionPerformed(evt);
            }
        });

        IM_ModifyInventory.setBackground(new java.awt.Color(153, 153, 153));
        IM_ModifyInventory.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        IM_ModifyInventory.setText("Modify Inventory Stock");
        IM_ModifyInventory.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        IM_ModifyInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IM_ModifyInventoryActionPerformed(evt);
            }
        });

        IM_ViewStock1.setBackground(new java.awt.Color(153, 153, 153));
        IM_ViewStock1.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        IM_ViewStock1.setText("View Inventory Stock");
        IM_ViewStock1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        IM_ViewStock1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IM_ViewStock1ActionPerformed(evt);
            }
        });

        AM_LogOutBtn.setBackground(new java.awt.Color(102, 102, 102));
        AM_LogOutBtn.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        AM_LogOutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oodj_assignment_images/logout.png"))); // NOI18N
        AM_LogOutBtn.setText("Log Out");
        AM_LogOutBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AM_LogOutBtn.setMaximumSize(new java.awt.Dimension(75, 75));
        AM_LogOutBtn.setMinimumSize(new java.awt.Dimension(75, 75));
        AM_LogOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AM_LogOutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout IM_FunctionPanelLayout = new javax.swing.GroupLayout(IM_FunctionPanel);
        IM_FunctionPanel.setLayout(IM_FunctionPanelLayout);
        IM_FunctionPanelLayout.setHorizontalGroup(
            IM_FunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IM_FunctionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(IM_FunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IM_ModifyInventory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IM_ViewSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AM_LogOutBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IM_ViewStock1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        IM_FunctionPanelLayout.setVerticalGroup(
            IM_FunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IM_FunctionPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(IM_ViewStock1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(IM_ModifyInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(IM_ViewSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AM_LogOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        IM_OverviewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Item ID", "Item Name", "Category", "Stock", "Stock Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(IM_OverviewTable);

        javax.swing.GroupLayout IM_PanelLayout = new javax.swing.GroupLayout(IM_Panel);
        IM_Panel.setLayout(IM_PanelLayout);
        IM_PanelLayout.setHorizontalGroup(
            IM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, IM_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(IM_FunctionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(IM_PanelLayout.createSequentialGroup()
                .addGap(277, 277, 277)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        IM_PanelLayout.setVerticalGroup(
            IM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IM_PanelLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(IM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(IM_FunctionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(IM_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(IM_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void IM_ViewSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IM_ViewSupplierActionPerformed
        this.dispose();
        new IM_SupplierList().setVisible(true);
    }//GEN-LAST:event_IM_ViewSupplierActionPerformed

    private void IM_ModifyInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IM_ModifyInventoryActionPerformed
        this.dispose();
        new IM_ModifyStock().setVisible(true);
    }//GEN-LAST:event_IM_ModifyInventoryActionPerformed

    private void IM_ViewStock1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IM_ViewStock1ActionPerformed
        this.dispose();
        new IM_StockDetails().setVisible(true);
    }//GEN-LAST:event_IM_ViewStock1ActionPerformed

    private void AM_LogOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AM_LogOutBtnActionPerformed
        this.dispose();
        new LoginForm().setVisible(true);
    }//GEN-LAST:event_AM_LogOutBtnActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        inventory.ViewTable(IM_OverviewTable);
    }//GEN-LAST:event_formComponentShown

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
            java.util.logging.Logger.getLogger(IM_MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IM_MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IM_MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IM_MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IM_MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AM_LogOutBtn;
    private javax.swing.JPanel IM_FunctionPanel;
    private javax.swing.JButton IM_ModifyInventory;
    private javax.swing.JTable IM_OverviewTable;
    private javax.swing.JPanel IM_Panel;
    private javax.swing.JButton IM_ViewStock1;
    private javax.swing.JButton IM_ViewSupplier;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
