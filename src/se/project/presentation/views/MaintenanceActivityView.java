/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.presentation.views;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static se.project.business_logic.controllers.MainController.openLoginPage;
import static se.project.business_logic.controllers.UserInfoController.goBackSystemAdministratorHomepage;
import static se.project.storage.DatabaseConnection.closeConnection;
import static se.project.storage.DatabaseConnection.getConnection;

/**
 *
 * @author Giacomo
 */
public class MaintenanceActivityView extends javax.swing.JFrame
{

    /**
     * Creates new form MaintenanceActivityView
     */
    public MaintenanceActivityView()
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jCloseConnectionLabel = new javax.swing.JLabel();
        jGoBackLabel = new javax.swing.JLabel();
        jExitLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jAddMaintenancePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jUpdateMaintenancePanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jViewMaintenancePanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDeleteMaintenancePanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(33, 33, 35));

        jCloseConnectionLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/icon/icons8_shutdown_30px.png"))); // NOI18N
        jCloseConnectionLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCloseConnectionLabel.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jCloseConnectionLabelMouseClicked(evt);
            }
        });

        jGoBackLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/icon/icons8_back_to_30px.png"))); // NOI18N
        jGoBackLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jGoBackLabel.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jGoBackLabelMouseClicked(evt);
            }
        });

        jExitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/icon/icons8_cancel_30px.png"))); // NOI18N
        jExitLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jExitLabel.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jExitLabelMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 42)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Maintenance Procedures Management ");

        jAddMaintenancePanel.setBackground(new java.awt.Color(188, 180, 169));
        jAddMaintenancePanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jAddMaintenancePanel.setPreferredSize(new java.awt.Dimension(430, 89));
        jAddMaintenancePanel.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jAddMaintenancePanelMouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/icon/icons8_new_copy_50px.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("Add Maintenance Procedure");

        javax.swing.GroupLayout jAddMaintenancePanelLayout = new javax.swing.GroupLayout(jAddMaintenancePanel);
        jAddMaintenancePanel.setLayout(jAddMaintenancePanelLayout);
        jAddMaintenancePanelLayout.setHorizontalGroup(
            jAddMaintenancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jAddMaintenancePanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jAddMaintenancePanelLayout.setVerticalGroup(
            jAddMaintenancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jAddMaintenancePanelLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jAddMaintenancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jAddMaintenancePanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jAddMaintenancePanelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(28, 28, 28))))
        );

        jUpdateMaintenancePanel.setBackground(new java.awt.Color(188, 180, 169));
        jUpdateMaintenancePanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jUpdateMaintenancePanel.setPreferredSize(new java.awt.Dimension(430, 89));
        jUpdateMaintenancePanel.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jUpdateMaintenancePanelMouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/icon/icons8_renew_50px.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setText("Update Maintenance Procedure");

        javax.swing.GroupLayout jUpdateMaintenancePanelLayout = new javax.swing.GroupLayout(jUpdateMaintenancePanel);
        jUpdateMaintenancePanel.setLayout(jUpdateMaintenancePanelLayout);
        jUpdateMaintenancePanelLayout.setHorizontalGroup(
            jUpdateMaintenancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jUpdateMaintenancePanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jUpdateMaintenancePanelLayout.setVerticalGroup(
            jUpdateMaintenancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jUpdateMaintenancePanelLayout.createSequentialGroup()
                .addGroup(jUpdateMaintenancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jUpdateMaintenancePanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3))
                    .addGroup(jUpdateMaintenancePanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel7)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jViewMaintenancePanel.setBackground(new java.awt.Color(188, 180, 169));
        jViewMaintenancePanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jViewMaintenancePanel.setPreferredSize(new java.awt.Dimension(430, 89));
        jViewMaintenancePanel.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jViewMaintenancePanelMouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/icon/icons8_analyze_50px.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setText("View Maintenance Procedure");

        javax.swing.GroupLayout jViewMaintenancePanelLayout = new javax.swing.GroupLayout(jViewMaintenancePanel);
        jViewMaintenancePanel.setLayout(jViewMaintenancePanelLayout);
        jViewMaintenancePanelLayout.setHorizontalGroup(
            jViewMaintenancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jViewMaintenancePanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jViewMaintenancePanelLayout.setVerticalGroup(
            jViewMaintenancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jViewMaintenancePanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel4)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jViewMaintenancePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(26, 26, 26))
        );

        jDeleteMaintenancePanel.setBackground(new java.awt.Color(188, 180, 169));
        jDeleteMaintenancePanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jDeleteMaintenancePanel.setPreferredSize(new java.awt.Dimension(430, 89));
        jDeleteMaintenancePanel.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jDeleteMaintenancePanelMouseClicked(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/icon/icons8_delete_file_50px.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel9.setText("Delete Maintenance Procedure");

        javax.swing.GroupLayout jDeleteMaintenancePanelLayout = new javax.swing.GroupLayout(jDeleteMaintenancePanel);
        jDeleteMaintenancePanel.setLayout(jDeleteMaintenancePanelLayout);
        jDeleteMaintenancePanelLayout.setHorizontalGroup(
            jDeleteMaintenancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDeleteMaintenancePanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jDeleteMaintenancePanelLayout.setVerticalGroup(
            jDeleteMaintenancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDeleteMaintenancePanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jDeleteMaintenancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDeleteMaintenancePanelLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(10, 10, 10)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCloseConnectionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jGoBackLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jExitLabel)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(225, 225, 225))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(119, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jViewMaintenancePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAddMaintenancePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(139, 139, 139)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDeleteMaintenancePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jUpdateMaintenancePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(110, 110, 110))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jGoBackLabel)
                        .addComponent(jExitLabel))
                    .addComponent(jCloseConnectionLabel))
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jUpdateMaintenancePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAddMaintenancePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jViewMaintenancePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDeleteMaintenancePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(207, Short.MAX_VALUE))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jCloseConnectionLabelMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jCloseConnectionLabelMouseClicked
    {//GEN-HEADEREND:event_jCloseConnectionLabelMouseClicked
        try
        {
            closeConnection();
        } catch (SQLException ex)
        {
            Logger.getLogger(MaintenanceActivityView.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
        openLoginPage();
    }//GEN-LAST:event_jCloseConnectionLabelMouseClicked

    private void jGoBackLabelMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jGoBackLabelMouseClicked
    {//GEN-HEADEREND:event_jGoBackLabelMouseClicked
        dispose();
        goBackSystemAdministratorHomepage(getConnection());
    }//GEN-LAST:event_jGoBackLabelMouseClicked

    private void jExitLabelMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jExitLabelMouseClicked
    {//GEN-HEADEREND:event_jExitLabelMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jExitLabelMouseClicked

    private void jAddMaintenancePanelMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jAddMaintenancePanelMouseClicked
    {//GEN-HEADEREND:event_jAddMaintenancePanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jAddMaintenancePanelMouseClicked

    private void jViewMaintenancePanelMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jViewMaintenancePanelMouseClicked
    {//GEN-HEADEREND:event_jViewMaintenancePanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jViewMaintenancePanelMouseClicked

    private void jUpdateMaintenancePanelMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jUpdateMaintenancePanelMouseClicked
    {//GEN-HEADEREND:event_jUpdateMaintenancePanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jUpdateMaintenancePanelMouseClicked

    private void jDeleteMaintenancePanelMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jDeleteMaintenancePanelMouseClicked
    {//GEN-HEADEREND:event_jDeleteMaintenancePanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jDeleteMaintenancePanelMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(MaintenanceActivityView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(MaintenanceActivityView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(MaintenanceActivityView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(MaintenanceActivityView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new MaintenanceActivityView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jAddMaintenancePanel;
    private javax.swing.JLabel jCloseConnectionLabel;
    private javax.swing.JPanel jDeleteMaintenancePanel;
    private javax.swing.JLabel jExitLabel;
    private javax.swing.JLabel jGoBackLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jUpdateMaintenancePanel;
    private javax.swing.JPanel jViewMaintenancePanel;
    // End of variables declaration//GEN-END:variables
}