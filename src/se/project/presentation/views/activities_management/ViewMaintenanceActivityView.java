package se.project.presentation.views.activities_management;


import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import se.project.presentation.views.AbstractView;

/**
 * Manages the interaction with a View Maintenance Activity page.
 * 
 */
public class ViewMaintenanceActivityView extends AbstractView
{
    private final DefaultTableModel defaultTableModel;

    /**
     * Creates new form ViewMaintenanceActivityView.
     */
    public ViewMaintenanceActivityView()
    {
        initComponents();
        this.defaultTableModel = new DefaultTableModel()
        {
           @Override
           public boolean isCellEditable(int row, int column)
           {
               return false; // So all cells are be not editable
           }        
        };
        Object columns[] = {"ID", "Name", "Time Needed", "Remaining Time", "Interruptible", "Typology", "Description", 
                            "Week", "Branch office", "Department", "Standard Procedure", "Planned"};
        this.defaultTableModel.setColumnIdentifiers(columns);
        this.jTable.setModel(this.defaultTableModel);
        this.setVisible(true);
    }
    
    /**
     * 
     * @return a String containing the text in the name text field.
     */
    public String getActivityName()
    {
        return this.jNameTextField.getText();
    } 
    
    /**
     *  resets the name text field.
     */
    public void resetNameField()
    {
        this.jNameTextField.setText("");
    }        

    /**
     * 
     * @return the JLabel representing the close connection button.
     */
    public JLabel getjCloseConnectionLabel()
    {
        return jCloseConnectionLabel;
    }

    /**
     * 
     * @return the JLabel representing the exit button.
     */
    public JLabel getjExitLabel()
    {
        return jExitLabel;
    }

    /**
     * 
     * @return the JLabel representing the go back button.
     */
    public JLabel getjGoBackLabel()
    {
        return jGoBackLabel;
    }

    /**
     * 
     * @return the JLabel representing the search button.
     */
    public JLabel getjSearchLabel()
    {
        return jSearchLabel;
    }
    
    /**
     * 
     * @return the JLabel representing the delete button.
     */
    public JLabel getjDeleteLabel()
    {
        return jDeleteLabel;
    }

    /**
     * 
     * @return the DefaultTableModel of the table that is in the page.
     */
    public DefaultTableModel getTableModel()
    {
        return defaultTableModel;
    }
    
    /**
     * 
     * @return the JTable that is in the page.
     */
    public JTable getjTable()
    {
        return jTable;
    }

    /**
     * 
     * @return the JTextField containing the name that has to be searched.
     */
    public JTextField getjNameTextField()
    {
        return jNameTextField;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jNameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSearchLabel = new javax.swing.JLabel();
        jDeleteLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(33, 33, 35));

        jCloseConnectionLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/assets/icons/icons8_shutdown_30px.png"))); // NOI18N
        jCloseConnectionLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jGoBackLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/assets/icons/icons8_back_to_30px.png"))); // NOI18N
        jGoBackLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jExitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/assets/icons/icons8_cancel_30px.png"))); // NOI18N
        jExitLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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
        jTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 42)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("View & Delete Maintenance Activities ");

        jNameTextField.setBackground(new java.awt.Color(188, 180, 169));
        jNameTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Search by Name");

        jSearchLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/assets/icons/icons8_search_50px.png"))); // NOI18N
        jSearchLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jDeleteLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/assets/icons/icons8_waste_50px.png"))); // NOI18N
        jDeleteLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSearchLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDeleteLabel)))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(236, 236, 236)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jGoBackLabel)
                    .addComponent(jCloseConnectionLabel)
                    .addComponent(jExitLabel))
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSearchLabel)
                            .addComponent(jNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDeleteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(108, Short.MAX_VALUE))
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
    private javax.swing.JLabel jDeleteLabel;
    private javax.swing.JLabel jExitLabel;
    private javax.swing.JLabel jGoBackLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jNameTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jSearchLabel;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
