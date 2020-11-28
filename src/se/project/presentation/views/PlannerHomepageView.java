/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.presentation.views;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Giacomo
 */
public class PlannerHomepageView extends javax.swing.JFrame
{

    /**
     * Creates new form PlannerHomepageView
     */
    public PlannerHomepageView()
    {
        initComponents();
        this.setVisible(true);
    }
    
    public JLabel getjCloseConnectionLabel()
    {
        return jCloseConnectionLabel;
    }

    public JLabel getjExitLabel()
    {
        return jExitLabel;
    }

    public JLabel getjGoBackLabel()
    {
        return jGoBackLabel;
    }
    
    public JPanel getjMaintenanceActivityPanel()
    {
        return jMaintenanceActivityPanel;
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
        jLabel2 = new javax.swing.JLabel();
        jMaintenanceActivityPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(33, 33, 35));

        jCloseConnectionLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/icon/icons8_shutdown_30px.png"))); // NOI18N
        jCloseConnectionLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jGoBackLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/icon/icons8_back_to_30px.png"))); // NOI18N
        jGoBackLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jExitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/icon/icons8_cancel_30px.png"))); // NOI18N
        jExitLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/icon/Planner_Homepage.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 42)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Planner Portal");

        jMaintenanceActivityPanel.setBackground(new java.awt.Color(188, 180, 169));
        jMaintenanceActivityPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/icon/icons8_engineering_50px.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel4.setText("Maintenance Activity");

        javax.swing.GroupLayout jMaintenanceActivityPanelLayout = new javax.swing.GroupLayout(jMaintenanceActivityPanel);
        jMaintenanceActivityPanel.setLayout(jMaintenanceActivityPanelLayout);
        jMaintenanceActivityPanelLayout.setHorizontalGroup(
            jMaintenanceActivityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jMaintenanceActivityPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jMaintenanceActivityPanelLayout.setVerticalGroup(
            jMaintenanceActivityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jMaintenanceActivityPanelLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jMaintenanceActivityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCloseConnectionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jGoBackLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jExitLabel)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jMaintenanceActivityPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel2)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jExitLabel)
                            .addComponent(jGoBackLabel)
                            .addComponent(jCloseConnectionLabel))
                        .addGap(53, 53, 53)
                        .addComponent(jLabel2)
                        .addGap(50, 50, 50)
                        .addComponent(jMaintenanceActivityPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 74, Short.MAX_VALUE)
                        .addComponent(jLabel1))))
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
            java.util.logging.Logger.getLogger(PlannerHomepageView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(PlannerHomepageView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(PlannerHomepageView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(PlannerHomepageView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new PlannerHomepageView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jCloseConnectionLabel;
    private javax.swing.JLabel jExitLabel;
    private javax.swing.JLabel jGoBackLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jMaintenanceActivityPanel;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
