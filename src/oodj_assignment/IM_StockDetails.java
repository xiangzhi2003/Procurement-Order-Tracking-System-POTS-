package oodj_assignment;

import oodj_assignment_functions.Inventory;

public class IM_StockDetails extends javax.swing.JFrame {

    public IM_StockDetails() {
        initComponents();
    }
    Inventory inv = new Inventory();
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        informationTable = new javax.swing.JTable();
        IM_FunctionPanel = new javax.swing.JPanel();
        IM_ViewUnderstocked = new javax.swing.JButton();
        IM_ModifyInventory = new javax.swing.JButton();
        IM_ViewAll = new javax.swing.JButton();
        AM_LogOutBtn = new javax.swing.JButton();
        AM_LogOutBtn1 = new javax.swing.JButton();
        IM_ViewSufficient = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setMaximumSize(new java.awt.Dimension(1050, 550));
        setMinimumSize(new java.awt.Dimension(1050, 550));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setForeground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 30)); // NOI18N
        jLabel1.setText("Stock Information");

        informationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(informationTable);

        IM_FunctionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Inventory Manager Function Panel"));
        IM_FunctionPanel.setToolTipText("");
        IM_FunctionPanel.setName(""); // NOI18N

        IM_ViewUnderstocked.setBackground(new java.awt.Color(153, 153, 153));
        IM_ViewUnderstocked.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        IM_ViewUnderstocked.setText("View Understocked Item");
        IM_ViewUnderstocked.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        IM_ViewUnderstocked.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IM_ViewUnderstockedActionPerformed(evt);
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

        IM_ViewAll.setBackground(new java.awt.Color(153, 153, 153));
        IM_ViewAll.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        IM_ViewAll.setText("View All");
        IM_ViewAll.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        IM_ViewAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IM_ViewAllActionPerformed(evt);
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

        AM_LogOutBtn1.setBackground(new java.awt.Color(102, 102, 102));
        AM_LogOutBtn1.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        AM_LogOutBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oodj_assignment_images/logout.png"))); // NOI18N
        AM_LogOutBtn1.setText("Back To Main");
        AM_LogOutBtn1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AM_LogOutBtn1.setMaximumSize(new java.awt.Dimension(75, 75));
        AM_LogOutBtn1.setMinimumSize(new java.awt.Dimension(75, 75));
        AM_LogOutBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AM_LogOutBtn1ActionPerformed(evt);
            }
        });

        IM_ViewSufficient.setBackground(new java.awt.Color(153, 153, 153));
        IM_ViewSufficient.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        IM_ViewSufficient.setText("View Sufficient Item");
        IM_ViewSufficient.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        IM_ViewSufficient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IM_ViewSufficientActionPerformed(evt);
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
                    .addComponent(IM_ViewUnderstocked, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AM_LogOutBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IM_ViewAll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AM_LogOutBtn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IM_ViewSufficient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        IM_FunctionPanelLayout.setVerticalGroup(
            IM_FunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IM_FunctionPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(IM_ViewAll, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IM_ViewUnderstocked, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IM_ViewSufficient, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(IM_ModifyInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AM_LogOutBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AM_LogOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(365, 365, 365)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(IM_FunctionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IM_FunctionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void IM_ViewUnderstockedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IM_ViewUnderstockedActionPerformed
        inv.ViewUnderstock(informationTable);
    }//GEN-LAST:event_IM_ViewUnderstockedActionPerformed

    private void IM_ModifyInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IM_ModifyInventoryActionPerformed
        this.dispose();
        new IM_ModifyStock().setVisible(true);
    }//GEN-LAST:event_IM_ModifyInventoryActionPerformed

    private void IM_ViewAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IM_ViewAllActionPerformed
        inv.ViewTable(informationTable);
    }//GEN-LAST:event_IM_ViewAllActionPerformed

    private void AM_LogOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AM_LogOutBtnActionPerformed
        this.dispose();
        new LoginForm().setVisible(true);
    }//GEN-LAST:event_AM_LogOutBtnActionPerformed

    private void AM_LogOutBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AM_LogOutBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AM_LogOutBtn1ActionPerformed

    private void IM_ViewSufficientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IM_ViewSufficientActionPerformed
        inv.ViewSufficient(informationTable);
    }//GEN-LAST:event_IM_ViewSufficientActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        inv.ViewTable(informationTable);
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
            java.util.logging.Logger.getLogger(IM_StockDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IM_StockDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IM_StockDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IM_StockDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IM_StockDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AM_LogOutBtn;
    private javax.swing.JButton AM_LogOutBtn1;
    private javax.swing.JPanel IM_FunctionPanel;
    private javax.swing.JButton IM_ModifyInventory;
    private javax.swing.JButton IM_ViewAll;
    private javax.swing.JButton IM_ViewSufficient;
    private javax.swing.JButton IM_ViewUnderstocked;
    private javax.swing.JTable informationTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
