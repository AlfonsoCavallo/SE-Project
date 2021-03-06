package se.project.presentation.views.activities_management;


import javax.swing.JLabel;
import javax.swing.JPanel;
import se.project.presentation.views.AbstractView;

/**
 * Manages the interaction with a Maintenance Activity Page.
 * 
 */
public class MaintenanceActivityView extends AbstractView
{
    
    /**
     * Creates new form MaintenanceActivityView.
     */
    public MaintenanceActivityView()
    {
        initComponents();
        this.setVisible(true);
    }

    /**
     * 
     * @return a JPanel representing the button to open the add maintenance activity page.
     */
    public JPanel getjAddMaintenancePanel()
    {
        return jAddMaintenancePanel;
    }

    /**
     * 
     * @return a JLabel representing close connection button.
     */
    public JLabel getjCloseConnectionLabel()
    {
        return jCloseConnectionLabel;
    }

    /**
     * 
     * @return a JLabel representing the exit button.
     */
    public JLabel getjExitLabel()
    {
        return jExitLabel;
    }

    /**
     * 
     * @return a JLabel representing the go back button.
     */
    public JLabel getjGoBackLabel()
    {
        return jGoBackLabel;
    }

    /**
     * 
     * @return a JPanel representing the button to open the update maintenance activity page.
     */
    public JPanel getjUpdateMaintenancePanel()
    {
        return jUpdateMaintenancePanel;
    }

    /**
     * 
     * @return a JPanel representing the button to open the view and delete maintenance activity page.
     */
    public JPanel getjViewMaintenancePanel()
    {
        return jViewDeleteMaintenancePanel;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always.
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
        jViewDeleteMaintenancePanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(33, 33, 35));

        jCloseConnectionLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/assets/icons/icons8_shutdown_30px.png"))); // NOI18N
        jCloseConnectionLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jGoBackLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/assets/icons/icons8_back_to_30px.png"))); // NOI18N
        jGoBackLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jExitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/assets/icons/icons8_cancel_30px.png"))); // NOI18N
        jExitLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 42)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Maintenance Activity Management ");

        jAddMaintenancePanel.setBackground(new java.awt.Color(188, 180, 169));
        jAddMaintenancePanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jAddMaintenancePanel.setPreferredSize(new java.awt.Dimension(430, 89));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/assets/icons/icons8_new_copy_50px.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("Add Maintenance Activity");

        javax.swing.GroupLayout jAddMaintenancePanelLayout = new javax.swing.GroupLayout(jAddMaintenancePanel);
        jAddMaintenancePanel.setLayout(jAddMaintenancePanelLayout);
        jAddMaintenancePanelLayout.setHorizontalGroup(
            jAddMaintenancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jAddMaintenancePanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addContainerGap(139, Short.MAX_VALUE))
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

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/assets/icons/icons8_renew_50px.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setText("Update Maintenance Activity");

        javax.swing.GroupLayout jUpdateMaintenancePanelLayout = new javax.swing.GroupLayout(jUpdateMaintenancePanel);
        jUpdateMaintenancePanel.setLayout(jUpdateMaintenancePanelLayout);
        jUpdateMaintenancePanelLayout.setHorizontalGroup(
            jUpdateMaintenancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jUpdateMaintenancePanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addContainerGap(107, Short.MAX_VALUE))
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

        jViewDeleteMaintenancePanel.setBackground(new java.awt.Color(188, 180, 169));
        jViewDeleteMaintenancePanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jViewDeleteMaintenancePanel.setPreferredSize(new java.awt.Dimension(430, 89));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/assets/icons/icons8_delete_file_50px.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setText("View & Delete Maintenance Activity");

        javax.swing.GroupLayout jViewDeleteMaintenancePanelLayout = new javax.swing.GroupLayout(jViewDeleteMaintenancePanel);
        jViewDeleteMaintenancePanel.setLayout(jViewDeleteMaintenancePanelLayout);
        jViewDeleteMaintenancePanelLayout.setHorizontalGroup(
            jViewDeleteMaintenancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jViewDeleteMaintenancePanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jViewDeleteMaintenancePanelLayout.setVerticalGroup(
            jViewDeleteMaintenancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jViewDeleteMaintenancePanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jViewDeleteMaintenancePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(26, 26, 26))
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
                        .addGap(0, 266, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(247, 247, 247))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jUpdateMaintenancePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jViewDeleteMaintenancePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAddMaintenancePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(347, 347, 347))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jGoBackLabel)
                        .addComponent(jExitLabel))
                    .addComponent(jCloseConnectionLabel))
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addGap(83, 83, 83)
                .addComponent(jAddMaintenancePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jViewDeleteMaintenancePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jUpdateMaintenancePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
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
     * @param args the command line arguments.
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
    private javax.swing.JLabel jExitLabel;
    private javax.swing.JLabel jGoBackLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jUpdateMaintenancePanel;
    private javax.swing.JPanel jViewDeleteMaintenancePanel;
    // End of variables declaration//GEN-END:variables
}
