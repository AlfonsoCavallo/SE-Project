/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.presentation.views;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static se.project.storage.DatabaseConnection.closeConnection;
import static se.project.business_logic.controllers.SAHomepageController.*;
import static se.project.storage.DatabaseConnection.getConnection;
import static se.project.business_logic.controllers.MainController.openLoginPage;

/**
 *
 * @author Giacomo
 */
public class SAHomepageView extends javax.swing.JFrame
{

    /**
     * Creates new form SAHomepageView
     */
    public SAHomepageView()
    {
        initComponents();
        this.setVisible(true);
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
        jExitLabel = new javax.swing.JLabel();
        jCloseConnectionLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jUserInfoPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jAccessRecordPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jMaintenanceProceduresPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(33, 33, 35));

        jExitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/icon/icons8_cancel_30px.png"))); // NOI18N
        jExitLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jExitLabel.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jExitLabelMouseClicked(evt);
            }
        });

        jCloseConnectionLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/icon/icons8_shutdown_30px.png"))); // NOI18N
        jCloseConnectionLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCloseConnectionLabel.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jCloseConnectionLabelMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 42)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("System Administrator Portal");

        jUserInfoPanel.setBackground(new java.awt.Color(188, 180, 169));
        jUserInfoPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jUserInfoPanel.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jUserInfoPanelMouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/icon/icons8_user_50px.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel7.setText("User Info");

        javax.swing.GroupLayout jUserInfoPanelLayout = new javax.swing.GroupLayout(jUserInfoPanel);
        jUserInfoPanel.setLayout(jUserInfoPanelLayout);
        jUserInfoPanelLayout.setHorizontalGroup(
            jUserInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jUserInfoPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addGap(29, 29, 29)
                .addComponent(jLabel7)
                .addContainerGap(217, Short.MAX_VALUE))
        );
        jUserInfoPanelLayout.setVerticalGroup(
            jUserInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jUserInfoPanelLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jUserInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4))
                .addGap(19, 19, 19))
        );

        jAccessRecordPanel.setBackground(new java.awt.Color(188, 180, 169));
        jAccessRecordPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jAccessRecordPanel.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jAccessRecordPanelMouseClicked(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/icon/icons8_timeline_50px.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel8.setText("Access Record");

        javax.swing.GroupLayout jAccessRecordPanelLayout = new javax.swing.GroupLayout(jAccessRecordPanel);
        jAccessRecordPanel.setLayout(jAccessRecordPanelLayout);
        jAccessRecordPanelLayout.setHorizontalGroup(
            jAccessRecordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jAccessRecordPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addGap(29, 29, 29)
                .addComponent(jLabel8)
                .addContainerGap(149, Short.MAX_VALUE))
        );
        jAccessRecordPanelLayout.setVerticalGroup(
            jAccessRecordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jAccessRecordPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jAccessRecordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jMaintenanceProceduresPanel.setBackground(new java.awt.Color(188, 180, 169));
        jMaintenanceProceduresPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMaintenanceProceduresPanel.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jMaintenanceProceduresPanelMouseClicked(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/icon/icons8_engineering_50px.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel9.setText("Maintenance Procedures");

        javax.swing.GroupLayout jMaintenanceProceduresPanelLayout = new javax.swing.GroupLayout(jMaintenanceProceduresPanel);
        jMaintenanceProceduresPanel.setLayout(jMaintenanceProceduresPanelLayout);
        jMaintenanceProceduresPanelLayout.setHorizontalGroup(
            jMaintenanceProceduresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jMaintenanceProceduresPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(20, 20, 20))
        );
        jMaintenanceProceduresPanelLayout.setVerticalGroup(
            jMaintenanceProceduresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jMaintenanceProceduresPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jMaintenanceProceduresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/icon/SA_Homepage.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 23, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jAccessRecordPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jMaintenanceProceduresPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jUserInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jCloseConnectionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jExitLabel)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCloseConnectionLabel)
                    .addComponent(jExitLabel))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(93, 93, 93)
                        .addComponent(jUserInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jAccessRecordPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jMaintenanceProceduresPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jExitLabelMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jExitLabelMouseClicked
    {//GEN-HEADEREND:event_jExitLabelMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jExitLabelMouseClicked

    private void jCloseConnectionLabelMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jCloseConnectionLabelMouseClicked
    {//GEN-HEADEREND:event_jCloseConnectionLabelMouseClicked
        try
        {
            closeConnection();
        } catch (SQLException ex)
        {
            Logger.getLogger(SAHomepageView.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
        openLoginPage();
    }//GEN-LAST:event_jCloseConnectionLabelMouseClicked

    private void jUserInfoPanelMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jUserInfoPanelMouseClicked
    {//GEN-HEADEREND:event_jUserInfoPanelMouseClicked
        dispose();
        openUserInfoPage(getConnection());
    }//GEN-LAST:event_jUserInfoPanelMouseClicked

    private void jAccessRecordPanelMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jAccessRecordPanelMouseClicked
    {//GEN-HEADEREND:event_jAccessRecordPanelMouseClicked
        dispose();
        openRecordAccessPage(getConnection());
    }//GEN-LAST:event_jAccessRecordPanelMouseClicked

    private void jMaintenanceProceduresPanelMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jMaintenanceProceduresPanelMouseClicked
    {//GEN-HEADEREND:event_jMaintenanceProceduresPanelMouseClicked
        dispose();
        openMaintenanceProceduresPage(getConnection());
    }//GEN-LAST:event_jMaintenanceProceduresPanelMouseClicked

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
            java.util.logging.Logger.getLogger(SAHomepageView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(SAHomepageView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(SAHomepageView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(SAHomepageView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new SAHomepageView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jAccessRecordPanel;
    private javax.swing.JLabel jCloseConnectionLabel;
    private javax.swing.JLabel jExitLabel;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jMaintenanceProceduresPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jUserInfoPanel;
    // End of variables declaration//GEN-END:variables
}
