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
import static se.project.storage.DatabaseConnection.closeConnection;

/**
 *
 * @author Giacomo
 */
public class ViewMaintenanceActivityView extends javax.swing.JFrame
{

    /**
     * Creates new form ViewMaintenanceActivityView
     */
    public ViewMaintenanceActivityView()
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSearchLabel = new javax.swing.JLabel();

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

        jTable.setBackground(new java.awt.Color(188, 180, 169));
        jTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 42)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("View Maintenance Procedures ");

        jTextField1.setBackground(new java.awt.Color(188, 180, 169));
        jTextField1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Search by Name");

        jSearchLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/icon/icons8_search_50px.png"))); // NOI18N
        jSearchLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jSearchLabel.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jSearchLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jCloseConnectionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jGoBackLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jExitLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSearchLabel))
                    .addComponent(jLabel2))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jGoBackLabel)
                    .addComponent(jCloseConnectionLabel)
                    .addComponent(jExitLabel))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel1)
                        .addGap(55, 55, 55)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(108, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSearchLabel))
                        .addGap(308, 308, 308))))
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
            Logger.getLogger(ViewMaintenanceActivityView.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
        openLoginPage();
    }//GEN-LAST:event_jCloseConnectionLabelMouseClicked

    private void jGoBackLabelMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jGoBackLabelMouseClicked
    {//GEN-HEADEREND:event_jGoBackLabelMouseClicked
        dispose();
        // goBackMaintenanceActivityPage(getConnection());
    }//GEN-LAST:event_jGoBackLabelMouseClicked

    private void jExitLabelMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jExitLabelMouseClicked
    {//GEN-HEADEREND:event_jExitLabelMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jExitLabelMouseClicked

    private void jSearchLabelMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jSearchLabelMouseClicked
    {//GEN-HEADEREND:event_jSearchLabelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jSearchLabelMouseClicked

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
            java.util.logging.Logger.getLogger(ViewMaintenanceActivityView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ViewMaintenanceActivityView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ViewMaintenanceActivityView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ViewMaintenanceActivityView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ViewMaintenanceActivityView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jCloseConnectionLabel;
    private javax.swing.JLabel jExitLabel;
    private javax.swing.JLabel jGoBackLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jSearchLabel;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
