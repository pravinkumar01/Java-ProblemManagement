package application.frames;

import java.sql.Connection;
import application.beans.LoginBean;
import application.exceptions.ManagerException;
import application.manager.LoginManager;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

final class LoginWindow extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private javax.swing.JButton btnLogin;
	private javax.swing.JLabel lblHeader;
	private javax.swing.JLabel lblPassword;
	private javax.swing.JButton btnReset;
	private javax.swing.JLabel lblUserId;
	private javax.swing.JPanel pnlLoginDetails;
	private javax.swing.JPanel pnlMain;
	private javax.swing.JPasswordField pwdPassword;
	private javax.swing.JTextField txtUserId;

	public LoginWindow() {
        initComponents();
    }

    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlLoginDetails = new javax.swing.JPanel();
        lblUserId = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        lblPassword = new javax.swing.JLabel();
        txtUserId = new javax.swing.JTextField();
        pwdPassword = new javax.swing.JPasswordField();
        lblHeader = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(125, 190, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        this.setPreferredSize(new java.awt.Dimension(442, 303));
        this.setBounds(570, 220, 442, 303);
        setResizable(false);

        pnlMain.setBackground(new java.awt.Color(125,190,255));

        pnlLoginDetails.setBackground(new java.awt.Color(125,190,255));
        pnlLoginDetails.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(192,192,192), 2, true), "Login", TitledBorder.LEFT, TitledBorder.TOP, new java.awt.Font("Cambria",3,18), new java.awt.Color(64,0,64))); // NOI18N
        pnlLoginDetails.setLayout(null);

        lblUserId.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        lblUserId.setForeground(new java.awt.Color(51, 0, 51));
        lblUserId.setText("User Id");
        pnlLoginDetails.add(lblUserId);
        lblUserId.setBounds(25, 40, 95, 30);

        btnLogin.setBackground(new java.awt.Color(153, 153, 153));
        btnLogin.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(51, 0, 51));
        btnLogin.setText("Login");
        btnLogin.setBorder(null);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        pnlLoginDetails.add(btnLogin);
        btnLogin.setBounds(240, 130, 90, 35);
        btnLogin.setHorizontalTextPosition(SwingConstants.CENTER);

        btnReset.setBackground(new java.awt.Color(153, 153, 153));
        btnReset.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btnReset.setForeground(new java.awt.Color(51, 0, 51));
        btnReset.setText("Reset");
        btnReset.setBorder(null);
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        pnlLoginDetails.add(btnReset);
        btnReset.setBounds(140, 130, 90, 35);
        btnReset.setHorizontalTextPosition(SwingConstants.CENTER);

        lblPassword.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(51, 0, 51));
        lblPassword.setText("Password");
        pnlLoginDetails.add(lblPassword);
        lblPassword.setBounds(25, 80, 95, 30);

        txtUserId.setBackground(new java.awt.Color(236,255,236));
        pnlLoginDetails.add(txtUserId);
        txtUserId.setBounds(140, 40, 190, 30);

        pwdPassword.setBackground(new java.awt.Color(236,255,236));
        pnlLoginDetails.add(pwdPassword);
        pwdPassword.setBounds(140, 80, 190, 30);

        lblHeader.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblHeader.setForeground(new java.awt.Color(0,73,147));
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("E2E Problem Management");

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setVerticalGroup(pnlMainLayout.createSequentialGroup()
        	.addContainerGap(18, Short.MAX_VALUE)
        	.addComponent(lblHeader, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        	.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
        	.addComponent(pnlLoginDetails, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
        	.addContainerGap(34, 34));
        pnlMainLayout.setHorizontalGroup(pnlMainLayout.createSequentialGroup()
        	.addContainerGap(43, 43)
        	.addGroup(pnlMainLayout.createParallelGroup()
        	    .addGroup(pnlMainLayout.createSequentialGroup()
        	        .addComponent(pnlLoginDetails, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
        	        .addGap(0, 0, Short.MAX_VALUE))
        	    .addGroup(GroupLayout.Alignment.LEADING, pnlMainLayout.createSequentialGroup()
        	        .addGap(0, 24, Short.MAX_VALUE)
        	        .addComponent(lblHeader, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
        	        .addGap(14)))
        	.addContainerGap(41, 41));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setVerticalGroup(layout.createSequentialGroup()
        	.addComponent(pnlMain, 0, 265, Short.MAX_VALUE));
        layout.setHorizontalGroup(layout.createSequentialGroup()
        	.addComponent(pnlMain, 0, 432, Short.MAX_VALUE));

        getAccessibleContext().setAccessibleDescription("");

        pack();
        this.setSize(442, 303);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {
        try{
        	ResourceProvider objResourceProvider = new ResourceProvider();
        	Connection objLocalConnection = objResourceProvider.getDatabaseConnection("E2ETracker");
            LoginManager objLoginManager = new LoginManager(objResourceProvider);
            LoginBean objLoginBean = objLoginManager.actionLogin(
					objLocalConnection, this.txtUserId.getText().toLowerCase(),
					objResourceProvider.getEncryptPassword(String.valueOf(this.pwdPassword.getPassword())));
            DashboardWindow objDashboardWindow = new DashboardWindow(objResourceProvider, objLoginBean);
            objDashboardWindow.setExtendedState(MAXIMIZED_BOTH);
            objDashboardWindow.setVisible(true);
            this.dispose();
        }catch(ManagerException eMan){
            if(eMan.getErrorType().equalsIgnoreCase("I")){
                JOptionPane.showMessageDialog(this, eMan.getErrorMessage(), eMan.getErrorName(),JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this, eMan.getErrorMessage(), eMan.getErrorName(), JOptionPane.ERROR_MESSAGE);
            }

            if(eMan.getErrorCode() == 1001){
                this.txtUserId.setText("");
            }else if(eMan.getErrorCode() == 1002){
                this.pwdPassword.setText("");
            }else{
                this.txtUserId.setText("");
                this.pwdPassword.setText("");
            }
        }catch(Exception eAll){
            JOptionPane.showMessageDialog(this, "Application Error: Unknown error encountered by application. Please contact administrator.", "Application Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblResetActionPerformed
        this.txtUserId.setText("");
        this.pwdPassword.setText("");
    }


}
