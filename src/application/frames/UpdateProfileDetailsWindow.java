package application.frames;

import info.clearthought.layout.TableLayout;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import application.beans.LoginBean;
import application.exceptions.ManagerException;
import application.manager.LoginManager;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
final class UpdateProfileDetailsWindow extends javax.swing.JFrame {

	{
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	private static final long serialVersionUID = 1L;
	private JPanel pnlMain;
	private JTextField txtAccessType;
	private JLabel lblAccessType;
	private JLabel lblLastName;
	private JLabel lblRetypePassword;
	private JLabel lblFirstName;
	private JPasswordField pwdRetypePassword;
	private JTextField txtLastName;
	private JTextField txtFirstName;
	private JLabel lblUserId;
	private JButton btnUpdate;
	private JLabel lblPassword;
	private JTextField txtUserId;
	private JPasswordField pwdPassword;
	private JLabel lblHeader;
	private final LoginBean objLoginBean;
	private final ResourceProvider objResourceProvider;
	private final DashboardWindow objDashboardWindow;

	public UpdateProfileDetailsWindow(DashboardWindow objDashboardWindow) {
		super();
		this.objDashboardWindow = objDashboardWindow;
		this.objResourceProvider = objDashboardWindow.getObjResourceProvider();
		this.objLoginBean = objDashboardWindow.getObjLoginBean();
		this.initGUI();
		this.initComponents();
	}

	private void initGUI() {
		pnlMain = new javax.swing.JPanel();
		TableLayout pnlMainLayout = new TableLayout(new double[][] {{15.0, 123.0, 3.0, TableLayout.FILL, TableLayout.FILL, 15.0}, {15.0, TableLayout.FILL, 10.0, TableLayout.FILL, 3.0, TableLayout.FILL, 3.0, TableLayout.FILL, 3.0, TableLayout.FILL, 3.0, TableLayout.FILL, 3.0, TableLayout.FILL, 3.0, TableLayout.FILL, 15.0}});
		pnlMainLayout.setHGap(5);
		pnlMainLayout.setVGap(5);
		pnlMain.setLayout(pnlMainLayout);
        lblHeader = new javax.swing.JLabel();
        pnlMain.add(lblHeader, "1, 1, 4, 1");
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt){
				updateProfileDetailsWindowClosing(evt);
			}
		});
        setTitle("Profile Details");
        setBackground(new java.awt.Color(125, 190, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        this.setPreferredSize(new java.awt.Dimension(462, 394));
        this.setBounds(570, 220, 442, 303);
        setResizable(false);

        pnlMain.setBackground(new java.awt.Color(125,190,255));

        {
        	txtUserId = new javax.swing.JTextField();
        	pnlMain.add(txtUserId, "3, 3, 4, 3");
        	txtUserId.setBackground(new java.awt.Color(236,255,236));
        	txtUserId.setBounds(140, 40, 190, 30);
        	txtUserId.setEditable(false);
        }
        {
        	lblUserId = new javax.swing.JLabel();
        	pnlMain.add(lblUserId, "1, 3");
        	lblUserId.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        	lblUserId.setForeground(new java.awt.Color(51, 0, 51));
        	lblUserId.setText("User Id");
        	lblUserId.setBounds(25, 40, 95, 30);
        }
        {
        	pwdPassword = new javax.swing.JPasswordField();
        	pnlMain.add(pwdPassword, "3, 11, 4, 11");
        	pwdPassword.setBackground(new java.awt.Color(236,255,236));
        	pwdPassword.setBounds(140, 80, 190, 30);
        	pwdPassword.setToolTipText("Password must contain 8 characters.");
        	pwdPassword.addKeyListener(new KeyAdapter() {
        		public void keyReleased(KeyEvent evt) {
        			pwdPasswordKeyReleased(evt);
        		}
        	});
        }
        {
        	lblPassword = new javax.swing.JLabel();
        	pnlMain.add(lblPassword, "1, 11");
        	lblPassword.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        	lblPassword.setForeground(new java.awt.Color(51, 0, 51));
        	lblPassword.setText("Password");
        	lblPassword.setBounds(25, 80, 95, 30);
        }
        {
        	btnUpdate = new javax.swing.JButton();
        	pnlMain.add(btnUpdate, "4, 15");
        	btnUpdate.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        	btnUpdate.setForeground(new java.awt.Color(192,192,192));
        	btnUpdate.setEnabled(false);
        	btnUpdate.setText("Update");
        	btnUpdate.setBorder(null);
        	btnUpdate.addActionListener(new java.awt.event.ActionListener() {
        		public void actionPerformed(java.awt.event.ActionEvent evt) {
        			btnUpdateActionPerformed(evt);
        		}
        	});
        	btnUpdate.setHorizontalTextPosition(SwingConstants.CENTER);
        }
        {
        	txtFirstName = new JTextField();
        	pnlMain.add(txtFirstName, "3, 5, 4, 5");
        	txtFirstName.setBackground(new java.awt.Color(236,255,236));
        	txtFirstName.setBounds(140, 40, 190, 30);
        	txtFirstName.setEditable(false);
        }
        {
        	txtLastName = new JTextField();
        	pnlMain.add(txtLastName, "3, 7, 4, 7");
        	txtLastName.setBackground(new java.awt.Color(236,255,236));
        	txtLastName.setBounds(140, 40, 190, 30);
        	txtLastName.setEditable(false);
        }
        {
        	pwdRetypePassword = new JPasswordField();
        	pnlMain.add(pwdRetypePassword, "3, 13, 4, 13");
        	pwdRetypePassword.setBackground(new java.awt.Color(236,255,236));
        	pwdRetypePassword.setBounds(140, 80, 190, 30);
        	pwdRetypePassword.setToolTipText("Password must contain 8 characters.");
        	pwdRetypePassword.addKeyListener(new KeyAdapter() {
        		public void keyReleased(KeyEvent evt) {
        			pwdRetypePasswordKeyReleased(evt);
        		}
        	});
        }
        {
        	lblFirstName = new JLabel();
        	pnlMain.add(lblFirstName, "1, 5");
        	lblFirstName.setText("First Name");
        	lblFirstName.setForeground(new java.awt.Color(51,0,51));
        	lblFirstName.setFont(new java.awt.Font("Cambria",0,16));
        	lblFirstName.setBounds(25, 40, 95, 30);
        }
        {
        	lblLastName = new JLabel();
        	pnlMain.add(lblLastName, "1, 7");
        	lblLastName.setText("Last Name");
        	lblLastName.setForeground(new java.awt.Color(51,0,51));
        	lblLastName.setFont(new java.awt.Font("Cambria",0,16));
        	lblLastName.setBounds(25, 40, 95, 30);
        }
        {
        	lblRetypePassword = new JLabel();
        	pnlMain.add(lblRetypePassword, "1, 13");
        	lblRetypePassword.setText("Retype Password");
        	lblRetypePassword.setForeground(new java.awt.Color(51,0,51));
        	lblRetypePassword.setFont(new java.awt.Font("Cambria",0,16));
        	lblRetypePassword.setBounds(25, 80, 95, 30);
        }
        {
        	lblAccessType = new JLabel();
        	pnlMain.add(lblAccessType, "1, 9");
        	lblAccessType.setText("Access Type");
        	lblAccessType.setForeground(new java.awt.Color(51,0,51));
        	lblAccessType.setFont(new java.awt.Font("Cambria",0,16));
        	lblAccessType.setBounds(25, 40, 95, 30);
        }
        {
        	txtAccessType = new JTextField();
        	pnlMain.add(txtAccessType, "3, 9, 4, 9");
        	txtAccessType.setEditable(false);
        	txtAccessType.setBackground(new java.awt.Color(236,255,236));
        	txtAccessType.setBounds(140, 40, 190, 30);
        	txtAccessType.setEditable(false);
        }

        lblHeader.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblHeader.setForeground(new java.awt.Color(0,73,147));
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Profile Details");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setVerticalGroup(layout.createSequentialGroup()
        	.addComponent(pnlMain, 0, 437, Short.MAX_VALUE));
        layout.setHorizontalGroup(layout.createSequentialGroup()
        	.addComponent(pnlMain, 0, 333, Short.MAX_VALUE));

        getAccessibleContext().setAccessibleDescription("");

        pack();
        this.setSize(462, 394);
	}

	private void initComponents(){
		this.txtUserId.setText(objLoginBean.getUserId());;
		this.txtFirstName.setText(objLoginBean.getFirstName());
		this.txtLastName.setText(objLoginBean.getLastName());
		if(objResourceProvider.compareString(objLoginBean.getAccessType(), "A")){
			this.txtAccessType.setText("Admin");
		}else if(objResourceProvider.compareString(objLoginBean.getAccessType(), "U")){
			this.txtAccessType.setText("User");
		}else{
			this.txtAccessType.setText("Other");
		}
	}

	protected final void btnUpdateActionPerformed(ActionEvent evt){
		try{
			ResourceProvider objResourceProvider = new ResourceProvider();
			Connection objLocalConnection = objResourceProvider.getDatabaseConnection("E2ETracker");
			LoginManager objLoginManager = new LoginManager(this.objResourceProvider);
			String pwd = objResourceProvider.getEncryptPassword(String.valueOf(this.pwdPassword.getPassword()));
			if(objLoginManager.updateProfilePassword(objLocalConnection, pwd, this.objLoginBean.getUserId())){
				JOptionPane.showMessageDialog(this, "Password has been updated successfully.","Application Message",JOptionPane.INFORMATION_MESSAGE);
				this.pwdPassword.setText("");
				this.pwdRetypePassword.setText("");
			}else{
				JOptionPane.showMessageDialog(this, "Unable to change Password.","Application Error",JOptionPane.ERROR_MESSAGE);
			}
			objResourceProvider.closeDatabaseConnection(objLocalConnection, true, true);
		}catch(ManagerException eMan){
			if(this.objResourceProvider.compareString(eMan.getErrorType(), "I")){
	            JOptionPane.showMessageDialog(this, eMan.getErrorMessage(), eMan.getErrorName(),JOptionPane.INFORMATION_MESSAGE);
	        }else{
	            JOptionPane.showMessageDialog(this, eMan.getErrorMessage(), eMan.getErrorName(), JOptionPane.ERROR_MESSAGE);
	        }
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "Unknown error encountered by application. Please contact administrator.", "Application Error", JOptionPane.ERROR_MESSAGE);
			this.initComponents();
		}
	}

	private void pwdRetypePasswordKeyReleased(KeyEvent evt) {
		String pwd = String.valueOf(this.pwdPassword.getPassword());
		String rePwd = String.valueOf(this.pwdRetypePassword.getPassword());
		if(pwd.length()>7){
			if(this.objResourceProvider.compareString(pwd, rePwd)){
				this.pwdRetypePassword.setBackground(new java.awt.Color(210,255,210));
				this.btnUpdate.setEnabled(true);
				this.btnUpdate.setForeground(new java.awt.Color(64,0,64));
			}else{
				this.pwdRetypePassword.setBackground(new java.awt.Color(255,206,206));
				this.btnUpdate.setEnabled(false);
				this.btnUpdate.setForeground(new java.awt.Color(192,192,192));
			}
		}
	}

	private void pwdPasswordKeyReleased(KeyEvent evt) {
		String pwd = String.valueOf(this.pwdPassword.getPassword());
		if(pwd.length()>7){
			this.pwdRetypePassword.setEnabled(true);
			this.pwdPassword.setBackground(new java.awt.Color(210,255,210));
		}else{
			this.pwdRetypePassword.setEnabled(false);
			this.pwdPassword.setBackground(new java.awt.Color(255,206,206));
			this.btnUpdate.setEnabled(false);
			this.btnUpdate.setForeground(new java.awt.Color(192,192,192));
		}
	}

	private void updateProfileDetailsWindowClosing(WindowEvent evt){

		try{
			this.objDashboardWindow.getObjDefectOverviewQCTWindow().setVisible(true);
		}catch(NullPointerException eNull){}

		try{
			this.objDashboardWindow.getObjProblemOverviewE2EWindow().setVisible(true);
		}catch(NullPointerException eNull){}

		try{
			this.objDashboardWindow.getObjProblemOverviewHPSMWindow().setVisible(true);
		}catch(NullPointerException eNull){}

		try{
			this.objDashboardWindow.getObjIncidentOverviewHPSMWindow().setVisible(true);
		}catch(NullPointerException eNull){}

		this.dispose();

		try{
			this.objDashboardWindow.setVisible(true);
			this.objDashboardWindow.setExtendedState(Frame.MAXIMIZED_BOTH);
		}catch(NullPointerException eNull){}
	}

}
