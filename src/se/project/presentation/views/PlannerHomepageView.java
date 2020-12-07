package se.project.presentation.views;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class PlannerHomepageView extends AbstractView
{

    /**
     * Creates new form PlannerHomepageView
     */
    public PlannerHomepageView()
    {
        initComponents();
        this.setVisible(true);
    }
    
    /**
     * 
     * @return a JLabel representing the close connection button
     */
    public JLabel getjCloseConnectionLabel()
    {
        return jCloseConnectionLabel;
    }

    /**
     * 
     * @return a JLabel representing the exit button
     */
    public JLabel getjExitLabel()
    {
        return jExitLabel;
    }
    
    /**
     * 
     * @return a JPanel representing the button to open the maintenance activity page
     */
    public JPanel getjMaintenanceActivityPanel()
    {
        return jMaintenanceActivityPanel;
    }

    /**
     * 
     * @return a JPanel representing the button to open the activity assignment page
     */
    public JPanel getjActivityAssigmentPanel()
    {
        return jActivityAssigmentPanel;
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
        jExitLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMaintenanceActivityPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jActivityAssigmentPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(33, 33, 35));

        jCloseConnectionLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/assets/icons/icons8_shutdown_30px.png"))); // NOI18N
        jCloseConnectionLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jExitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/assets/icons/icons8_cancel_30px.png"))); // NOI18N
        jExitLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/assets/icons/Planner_Homepage.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 42)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Planner Portal");

        jMaintenanceActivityPanel.setBackground(new java.awt.Color(188, 180, 169));
        jMaintenanceActivityPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMaintenanceActivityPanel.setPreferredSize(new java.awt.Dimension(430, 80));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/assets/icons/icons8_engineering_50px.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel4.setText("Maintenance Activity");

        javax.swing.GroupLayout jMaintenanceActivityPanelLayout = new javax.swing.GroupLayout(jMaintenanceActivityPanel);
        jMaintenanceActivityPanel.setLayout(jMaintenanceActivityPanelLayout);
        jMaintenanceActivityPanelLayout.setHorizontalGroup(
            jMaintenanceActivityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jMaintenanceActivityPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jMaintenanceActivityPanelLayout.setVerticalGroup(
            jMaintenanceActivityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jMaintenanceActivityPanelLayout.createSequentialGroup()
                .addGroup(jMaintenanceActivityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jMaintenanceActivityPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel3))
                    .addGroup(jMaintenanceActivityPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jActivityAssigmentPanel.setBackground(new java.awt.Color(188, 180, 169));
        jActivityAssigmentPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jActivityAssigmentPanel.setPreferredSize(new java.awt.Dimension(430, 80));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/assets/icons/icons8_external_50px.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel6.setText("Activity Assignment");

        javax.swing.GroupLayout jActivityAssigmentPanelLayout = new javax.swing.GroupLayout(jActivityAssigmentPanel);
        jActivityAssigmentPanel.setLayout(jActivityAssigmentPanelLayout);
        jActivityAssigmentPanelLayout.setHorizontalGroup(
            jActivityAssigmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jActivityAssigmentPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jActivityAssigmentPanelLayout.setVerticalGroup(
            jActivityAssigmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jActivityAssigmentPanelLayout.createSequentialGroup()
                .addGroup(jActivityAssigmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jActivityAssigmentPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5))
                    .addGroup(jActivityAssigmentPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel6)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCloseConnectionLabel)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jExitLabel)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(118, 118, 118))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jMaintenanceActivityPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jActivityAssigmentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 41, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jExitLabel)
                            .addComponent(jCloseConnectionLabel))
                        .addGap(53, 53, 53)
                        .addComponent(jLabel2)
                        .addGap(50, 50, 50)
                        .addComponent(jMaintenanceActivityPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jActivityAssigmentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private javax.swing.JPanel jActivityAssigmentPanel;
    private javax.swing.JLabel jCloseConnectionLabel;
    private javax.swing.JLabel jExitLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jMaintenanceActivityPanel;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
