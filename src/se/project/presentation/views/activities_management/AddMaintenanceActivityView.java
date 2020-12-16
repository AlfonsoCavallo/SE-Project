package se.project.presentation.views.activities_management;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import se.project.presentation.views.AbstractView;

/**
 * Manages the interaction with a Add Maintenance Activity page.
 * 
 */
public class AddMaintenanceActivityView extends AbstractView
{

    /**
     * Creates new form AddMaintenanceActivityView.
     */
    public AddMaintenanceActivityView()
    {
        initComponents();
        this.setVisible(true);
    }

    /**
     * 
     * @return a JPanel representing the add maintenance activity button.
     */
    public JPanel getjAddPanel()
    {
        return jAddPanel;
    }

    /**
     * 
     * @return a JPanel representing the clear button.
     */
    public JPanel getjClearPanel()
    {
        return jClearPanel;
    }

    /**
     * 
     * @return a JLabel representing the close connection button.
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
     * @return a String containing the text in the description text area.
     */
    public String getStringActivityDescription()
    {
        return this.jDescriptionTextArea.getText();
    }

    /**
     * 
     * @return a String containing the selected value in the Branch Office Combo Box.
     */
    public String getBranchOffice()
    {
        return this.jBranchOfficeComboBox.getSelectedItem().toString();
    }

    /**
     * 
     * @return the Branch Office Combo Box.
     */
    public JComboBox<String> getjBranchOfficeComboBox()
    {
        return jBranchOfficeComboBox;
    }
    
    /**
     * 
     * @return a String containing the selected value in the Department Combo Box.
     */
    public String getDepartment()
    {
        return this.jDepartmentComboBox.getSelectedItem().toString();
    }
    
    /**
     * 
     * @return the Department Combo Box.
     */
    public JComboBox<String> getjDepartmentComboBox()
    {
        return jDepartmentComboBox;
    }
    
    /**
     * 
     * @return a String containing the selected value in the Interruptible Combo Box.
     */
    public String getIsInterruptibleValue()
    {
        return this.jInterruptibleComboBox.getSelectedItem().toString();
    }

    /**
     * 
     * @return a String containing the text in the name text field.
     */
    public String getStringActivityName()
    {
        return this.jNameTextField.getText();
    }

    /**
     * 
     * @return a String containing the selected value in the Planned Combo Box.
     */
    public String getIsPlannedValue()
    {
        return this.jPlannedComboBox.getSelectedItem().toString();
    }

    /**
     * 
     * @return the Planned Combo Box.
     */
    public JComboBox<String> getjPlannedComboBox()
    {
        return jPlannedComboBox;
    }
    
    /**
     * 
     * @return the String containing the text in the standard procedure text field.
     */
    public String getStringStandardProcedure()
    {
        return this.jStandardProcedureTextField.getText();
    }

    /**
     * 
     * @return the JTextField containing the standard procedure.
     */
    public JTextField getjStandardProcedureTextField()
    {
        return jStandardProcedureTextField;
    }
    
    /**
     * 
     * @return a String containing the text in the time text field.
     */
    public String getStringTimeNeeded()
    {
        return this.jTimeTextField.getText();
    }

    /**
     * 
     * @return a String containing the selected valure in the typology combo box.
     */
    public String getStringTypology()
    {
        return this.jTypologyComboBox.getSelectedItem().toString();
    }

    /**
     * 
     * @return a String containing the selected value in the week combo box.
     */
    public String getStringWeek()
    {
        return this.jWeekComboBox.getSelectedItem().toString();
    }

    /**
     *  resets the description text area.
     */
    public void resetjDescriptionTextArea()
    {
        this.jDescriptionTextArea.setText("");
    }

    /**
     *  resets the name text field.
     */
    public void resetjNameTextField()
    {
        this.jNameTextField.setText("");
    }

    /**
     *  resets the standard procedure text field.
     */
    public void resetjStandardProcedureTextField()
    {
        this.jStandardProcedureTextField.setText("");
    }

    /**
     *  resets the time text field.
     */
    public void resetjTimeTextField()
    {
        this.jTimeTextField.setText("");
    }

    /**
     *  resets the Branch Office combo box.
     */
    public void resetjBranchOfficeComboBox()
    {
        this.jBranchOfficeComboBox.setSelectedIndex(0);
    }

    /**
     *  resets the Department combo box.
     */
    public void resetjDepartmentComboBox()
    {
        this.jDepartmentComboBox.setSelectedIndex(0);
    }
    
    /**
     *  resets the Interruptible combo box.
     */
    public void resetjInterruptibleComboBox()
    {
        this.jInterruptibleComboBox.setSelectedIndex(0);
    }

    /**
     *  resets the planned combo box.
     */
    public void resetjPlannedComboBox()
    {
        this.jPlannedComboBox.setSelectedIndex(0);
    }

    /**
     *  resets the typology combo box.
     */
    public void resetjTypologyComboBox()
    {
        this.jTypologyComboBox.setSelectedIndex(0);
    }

    /**
     *  resets the week combo box.
     */
    public void resetjWeekComboBox()
    {
        this.jWeekComboBox.setSelectedIndex(0);
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
        jNameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTimeTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jInterruptibleComboBox = new javax.swing.JComboBox<String>();
        jLabel5 = new javax.swing.JLabel();
        jTypologyComboBox = new javax.swing.JComboBox<String>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jDescriptionTextArea = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jWeekComboBox = new javax.swing.JComboBox<String>();
        jLabel8 = new javax.swing.JLabel();
        jPlannedComboBox = new javax.swing.JComboBox<String>();
        jEWOLabel = new javax.swing.JLabel();
        jBranchOfficeComboBox = new javax.swing.JComboBox<String>();
        jStandardProcedureTextField = new javax.swing.JTextField();
        jStandardProcedureLabel = new javax.swing.JLabel();
        jAddPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jClearPanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jDepartmentComboBox = new javax.swing.JComboBox<String>();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(33, 33, 35));
        jPanel1.setPreferredSize(new java.awt.Dimension(1228, 700));

        jCloseConnectionLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/assets/icons/icons8_shutdown_30px.png"))); // NOI18N
        jCloseConnectionLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jGoBackLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/assets/icons/icons8_back_to_30px.png"))); // NOI18N
        jGoBackLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jExitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/assets/icons/icons8_cancel_30px.png"))); // NOI18N
        jExitLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 42)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Add Maintenance Activity");

        jNameTextField.setBackground(new java.awt.Color(188, 180, 169));
        jNameTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Name");

        jTimeTextField.setBackground(new java.awt.Color(188, 180, 169));
        jTimeTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Time Needed");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Interruptible");

        jInterruptibleComboBox.setBackground(new java.awt.Color(188, 180, 169));
        jInterruptibleComboBox.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jInterruptibleComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "yes", "no" }));
        jInterruptibleComboBox.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jInterruptibleComboBoxActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Typology");

        jTypologyComboBox.setBackground(new java.awt.Color(188, 180, 169));
        jTypologyComboBox.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTypologyComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "electrical", "electronic", "hydraulic", "mechanical" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Description");

        jDescriptionTextArea.setBackground(new java.awt.Color(188, 180, 169));
        jDescriptionTextArea.setColumns(20);
        jDescriptionTextArea.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jDescriptionTextArea.setRows(5);
        jScrollPane1.setViewportView(jDescriptionTextArea);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Week");

        jWeekComboBox.setBackground(new java.awt.Color(188, 180, 169));
        jWeekComboBox.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jWeekComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52" }));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Planned");

        jPlannedComboBox.setBackground(new java.awt.Color(188, 180, 169));
        jPlannedComboBox.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPlannedComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "yes", "no" }));

        jEWOLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jEWOLabel.setForeground(new java.awt.Color(204, 204, 204));
        jEWOLabel.setText("Branch Office");

        jBranchOfficeComboBox.setBackground(new java.awt.Color(188, 180, 169));
        jBranchOfficeComboBox.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jBranchOfficeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fisciano", "Lauria", "Montecorvino Rovella", "Montella", "Morra", "Nusco", "Torrione" }));

        jStandardProcedureTextField.setBackground(new java.awt.Color(188, 180, 169));
        jStandardProcedureTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jStandardProcedureLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jStandardProcedureLabel.setForeground(new java.awt.Color(204, 204, 204));
        jStandardProcedureLabel.setText("Standard Procedure");

        jAddPanel.setBackground(new java.awt.Color(188, 180, 169));
        jAddPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/assets/icons/icons8_plus_30px.png"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("Add");

        javax.swing.GroupLayout jAddPanelLayout = new javax.swing.GroupLayout(jAddPanel);
        jAddPanel.setLayout(jAddPanelLayout);
        jAddPanelLayout.setHorizontalGroup(
            jAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jAddPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addContainerGap(123, Short.MAX_VALUE))
        );
        jAddPanelLayout.setVerticalGroup(
            jAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jAddPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jClearPanel.setBackground(new java.awt.Color(188, 180, 169));
        jClearPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/se/project/assets/icons/icons8_broom_30px.png"))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Clear");

        javax.swing.GroupLayout jClearPanelLayout = new javax.swing.GroupLayout(jClearPanel);
        jClearPanel.setLayout(jClearPanelLayout);
        jClearPanelLayout.setHorizontalGroup(
            jClearPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jClearPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addContainerGap(118, Short.MAX_VALUE))
        );
        jClearPanelLayout.setVerticalGroup(
            jClearPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jClearPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jClearPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDepartmentComboBox.setBackground(new java.awt.Color(188, 180, 169));
        jDepartmentComboBox.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jDepartmentComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Carpentry", "Cleaning", "Molding", "Painting", "Printing" }));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Department");

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
                        .addGap(0, 137, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jNameTextField)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel5)
                                        .addComponent(jTypologyComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jDepartmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel9))
                                .addGap(114, 114, 114)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPlannedComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jStandardProcedureTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel6))
                                                .addGap(109, 109, 109))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(63, 63, 63)
                                                .addComponent(jLabel7))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jInterruptibleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(83, 83, 83)
                                                .addComponent(jWeekComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(jEWOLabel)
                                            .addComponent(jBranchOfficeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jStandardProcedureLabel))))
                                .addGap(138, 138, 138))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jAddPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(141, 141, 141)
                                .addComponent(jClearPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(314, 314, 314))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(353, 353, 353))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jExitLabel)
                    .addComponent(jGoBackLabel)
                    .addComponent(jCloseConnectionLabel))
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jInterruptibleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jWeekComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jEWOLabel, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTypologyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBranchOfficeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jStandardProcedureLabel)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPlannedComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStandardProcedureTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDepartmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jAddPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jClearPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jInterruptibleComboBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jInterruptibleComboBoxActionPerformed
    {//GEN-HEADEREND:event_jInterruptibleComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jInterruptibleComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(AddMaintenanceActivityView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(AddMaintenanceActivityView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(AddMaintenanceActivityView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(AddMaintenanceActivityView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new AddMaintenanceActivityView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jAddPanel;
    private javax.swing.JComboBox<String> jBranchOfficeComboBox;
    private javax.swing.JPanel jClearPanel;
    private javax.swing.JLabel jCloseConnectionLabel;
    private javax.swing.JComboBox<String> jDepartmentComboBox;
    private javax.swing.JTextArea jDescriptionTextArea;
    private javax.swing.JLabel jEWOLabel;
    private javax.swing.JLabel jExitLabel;
    private javax.swing.JLabel jGoBackLabel;
    private javax.swing.JComboBox<String> jInterruptibleComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jNameTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jPlannedComboBox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jStandardProcedureLabel;
    private javax.swing.JTextField jStandardProcedureTextField;
    private javax.swing.JTextField jTimeTextField;
    private javax.swing.JComboBox<String> jTypologyComboBox;
    private javax.swing.JComboBox<String> jWeekComboBox;
    // End of variables declaration//GEN-END:variables
}
