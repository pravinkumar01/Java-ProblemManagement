package application.frames;
import info.clearthought.layout.TableLayout;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import application.beans.AdminWorkspaceBean;
import application.beans.LoginBean;
import application.exceptions.ManagerException;
import application.manager.AdminWorkspaceManager;


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
final class AdminProfileWindow extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JPanel pnlMain;
	private JPanel pnlUpdateDropDownOptions;
	private JRadioButton rdbtnUpdateExistingUser;
	private JRadioButton rdbtnCreateNewUser;
	private JRadioButton jRadioButton1;
	private JRadioButton rdbtnUnlock;
	private JRadioButton rdbtnLockProblem;
	private JButton btnLockUnlock;
	private JComboBox<String> cmbbxLockUnlockTrackerId;
	private JPanel pnlLockUnlockProblem;
	private JScrollPane scrpnCodeDetailsValue;
	private JList<String> listCodeDetailsValue;
	private JTextField txtUpdateCodeDetails;
	private JComboBox<String> cmbbxUpdateExistingUser;
	//private JButton btnRemoveProfile;
	private JLabel lblHeadre;
	private JButton btnCreateProfile;
	private JComboBox<String> cmbbxAccessFlag;
	private JComboBox<String> cmbbxAccessType;
	private JLabel lblAccessFlag;
	private JLabel lblAccessType;
	private JTextField txtLastName;
	private JTextField txtFirstName;
	private JLabel lblLastName;
	private JButton btnUpdateOption;
	private JLabel lblFirstName;
	private JTextField txtPassword;
	private JLabel lblPassword;
	private JTextField txtUserId;
	private JLabel lblUserId;
	private JPanel pnlUserProfile;
	private JLabel jLabel13;
	private JPanel pnlContainer;
	private JRadioButton rdbtnAutoMode;
	private JRadioButton rdbtnManualMode;
	private JComboBox<String> cmbbxOptionName;
	private boolean userIdFlag;
	private boolean passwordFlag;
	private boolean firstNameFlag;
	private boolean lastNameFlag;
	private final ResourceProvider objResourceProvider;
	private final AdminWorkspaceManager objAdminWorkspaceManager;
	private final AdminWorkspaceBean objAdminWorkspaceBean;

 	public AdminProfileWindow(LoginBean objLoginBean, ResourceProvider objResourceProvider) {
		super();
		this.objResourceProvider = objResourceProvider;
		this.objAdminWorkspaceBean = new AdminWorkspaceBean();
		this.objAdminWorkspaceManager = new AdminWorkspaceManager(this.objAdminWorkspaceBean);
		initGUI();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				LoginBean objLoginBean = new LoginBean("id83393","Pravin","Kumar","Y");
				ResourceProvider objResourceProvider = new ResourceProvider();
				AdminProfileWindow inst = new AdminProfileWindow(objLoginBean, objResourceProvider);
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setExtendedState(Frame.MAXIMIZED_BOTH);
			this.setTitle("Admin Workspace");
			this.setResizable(false);
			{
				pnlMain = new JPanel();
				getContentPane().add(pnlMain, BorderLayout.CENTER);
				pnlMain.setLayout(null);
				pnlMain.setPreferredSize(new java.awt.Dimension(704, 583));
				pnlMain.setBackground(new java.awt.Color(125,190,255));
				{
					pnlContainer = new JPanel();
					TableLayout pnlContainerLayout = new TableLayout(new double[][] {{6.0, 174.0, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, 6.0}, {6.0, 40.0, 3.0, 30.0, 3.0, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, 6.0, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, 3.0, TableLayout.FILL, TableLayout.FILL, 6.0}});
					pnlContainerLayout.setHGap(5);
					pnlContainerLayout.setVGap(5);
					pnlContainer.setLayout(pnlContainerLayout);
					pnlMain.add(pnlContainer);
					pnlContainer.setBounds(0, 0, 706, 556);
					pnlContainer.setBackground(new java.awt.Color(125,190,255));
					pnlContainer.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
					{
						pnlUpdateDropDownOptions = new JPanel();
						pnlContainer.add(pnlUpdateDropDownOptions, "1, 10, 4, 13");
						TableLayout pnlUpdateDropDownOptionsLayout = new TableLayout(new double[][] {{3.0, TableLayout.FILL, 3.0, TableLayout.FILL, TableLayout.FILL, 3.0}, {3.0, TableLayout.FILL, 3.0, TableLayout.FILL, 3.0, TableLayout.FILL, 6.0}});
						pnlUpdateDropDownOptionsLayout.setHGap(5);
						pnlUpdateDropDownOptionsLayout.setVGap(5);
						pnlUpdateDropDownOptions.setBackground(new java.awt.Color(125,190,255));
						pnlUpdateDropDownOptions.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(128,128,128), 1, false), "Update Code Details", TitledBorder.LEFT, TitledBorder.TOP, new java.awt.Font("Cambria",1,14), new java.awt.Color(0,0,128)));
						pnlUpdateDropDownOptions.setLayout(pnlUpdateDropDownOptionsLayout);
						{
							jLabel13 = new JLabel();
							pnlUpdateDropDownOptions.add(jLabel13, "0, 1");
							jLabel13.setText("Password");
						}
						{
							btnUpdateOption = new JButton();
							pnlUpdateDropDownOptions.add(btnUpdateOption, "4, 1");
							btnUpdateOption.setFont(new java.awt.Font("Cambria",1,14));
							btnUpdateOption.setForeground(new java.awt.Color(64,0,64));
							btnUpdateOption.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									btnUpdateOptionActionPerformed(evt);
								}
							});
							btnUpdateOption.setText("Insert");
						}
						{
							ComboBoxModel<String> cmbbxOptionNameModel =
									new DefaultComboBoxModel<String>(
											new String[] {"Detected In", "Application Name"});
							cmbbxOptionName = new JComboBox<String>();
							//cmbbxOptionName.setSelectedIndex(0);
							//this.objAdminWorkspaceBean.setSelectedOptionName((String)cmbbxOptionName.getSelectedItem());
							pnlUpdateDropDownOptions.add(cmbbxOptionName, "3, 1");
							cmbbxOptionName.addItemListener(new ItemListener() {
								public void itemStateChanged(ItemEvent evt) {
									cmbbxOptionNameItemStateChanged(evt);
								}
							});
							cmbbxOptionName.setModel(cmbbxOptionNameModel);
						}
						{
							rdbtnAutoMode = new JRadioButton();
							pnlUpdateDropDownOptions.add(rdbtnAutoMode, "1, 1");
							rdbtnAutoMode.setText("Update from QCT Database");
							rdbtnAutoMode.setFont(new java.awt.Font("Cambria",0,14));
							rdbtnAutoMode.setForeground(new java.awt.Color(64,0,64));
							rdbtnAutoMode.setSelected(true);
							rdbtnAutoMode.addItemListener(new ItemListener() {
								public void itemStateChanged(ItemEvent evt) {
									rdbtnAutoModeItemStateChanged(evt);
								}
							});
						}
						{
							rdbtnManualMode = new JRadioButton();
							pnlUpdateDropDownOptions.add(rdbtnManualMode, "1, 3");
							rdbtnManualMode.setText("Insert New Option Manually");
							rdbtnManualMode.setFont(new java.awt.Font("Cambria",0,14));
							rdbtnManualMode.setForeground(new java.awt.Color(64,0,64));
							rdbtnManualMode.addItemListener(new ItemListener() {
								public void itemStateChanged(ItemEvent evt) {
									rdbtnManualModeItemStateChanged(evt);
								}
							});
						}
						{
							txtUpdateCodeDetails = new JTextField();
							txtUpdateCodeDetails.setVisible(false);
							pnlUpdateDropDownOptions.add(txtUpdateCodeDetails, "3, 3");
							txtUpdateCodeDetails.setFont(new java.awt.Font("Cambria",0,14));
						}
						{
							scrpnCodeDetailsValue = new JScrollPane();
							pnlUpdateDropDownOptions.add(scrpnCodeDetailsValue, "3, 3, 3, 5");
							{
								ListModel<String> listCodeDetailsValueModel =
										new DefaultComboBoxModel<String>(
												new String[] { "" });
								listCodeDetailsValue = new JList<String>();
								scrpnCodeDetailsValue.setViewportView(listCodeDetailsValue);
								listCodeDetailsValue.setModel(listCodeDetailsValueModel);
								listCodeDetailsValue.setPreferredSize(new java.awt.Dimension(306, 69));
								scrpnCodeDetailsValue.setVisible(false);
							}
						}
						{
							jRadioButton1 = new JRadioButton();
							pnlUpdateDropDownOptions.add(jRadioButton1, "1, 5");
							jRadioButton1.setText("Remove Existing Options");
							jRadioButton1.setSelected(false);
							jRadioButton1.setFont(new java.awt.Font("Cambria",0,14));
							jRadioButton1.setForeground(new java.awt.Color(64,0,64));
							jRadioButton1.addItemListener(new ItemListener() {
								public void itemStateChanged(ItemEvent evt) {
									jRadioButton1ItemStateChanged(evt);
								}
							});
						}
					}
					{
						pnlUserProfile = new JPanel();
						pnlContainer.add(pnlUserProfile, "1, 3, 4, 8");
						TableLayout pnlUserProfileLayout = new TableLayout(new double[][] {{3.0, TableLayout.FILL, 3.0, TableLayout.FILL, TableLayout.FILL, 3.0, TableLayout.FILL, 3.0, TableLayout.FILL, TableLayout.FILL, 3.0}, {3.0, TableLayout.FILL, 3.0, TableLayout.FILL, 3.0, TableLayout.FILL, 3.0, TableLayout.FILL, 3.0}});
						pnlUserProfileLayout.setHGap(5);
						pnlUserProfileLayout.setVGap(5);
						pnlUserProfile.setLayout(pnlUserProfileLayout);
						pnlUserProfile.setBackground(new java.awt.Color(125,190,255));
						pnlUserProfile.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(128,128,128), 1, false), "User Profile", TitledBorder.LEFT, TitledBorder.TOP, new java.awt.Font("Cambria",1,14), new java.awt.Color(0,0,128)));
						{
							lblUserId = new JLabel();
							pnlUserProfile.add(lblUserId, "1, 3");
							lblUserId.setText("User ID");
							lblUserId.setFont(new java.awt.Font("Cambria",0,14));
							lblUserId.setForeground(new java.awt.Color(64,0,64));
						}
						{
							txtUserId = new JTextField();
							pnlUserProfile.add(txtUserId, "3, 3, 4, 3");
							txtUserId.setFont(new java.awt.Font("Cambria",0,14));
							txtUserId.setForeground(new java.awt.Color(64,0,64));
							txtUserId.setBackground(new java.awt.Color(240,255,255));
							txtUserId.addKeyListener(new KeyAdapter() {
								public void keyReleased(KeyEvent evt) {
									txtUserIdKeyReleased(evt);
								}
								public void keyTyped(KeyEvent evt) {
									txtUserIdKeyTyped(evt);
								}
								public void keyPressed(KeyEvent evt) {
									txtUserIdKeyPressed(evt);
								}
							});
						}
						{
							lblPassword = new JLabel();
							pnlUserProfile.add(lblPassword, "1, 5");
							lblPassword.setText("Password");
							lblPassword.setFont(new java.awt.Font("Cambria",0,14));
							lblPassword.setForeground(new java.awt.Color(64,0,64));
						}
						{
							txtPassword = new JTextField();
							pnlUserProfile.add(txtPassword, "3, 5, 4, 5");
							txtPassword.setFont(new java.awt.Font("Cambria",0,14));
							txtPassword.setForeground(new java.awt.Color(64,0,64));
							txtPassword.setBackground(new java.awt.Color(240,255,255));
							txtPassword.addKeyListener(new KeyAdapter() {
								public void keyReleased(KeyEvent evt) {
									txtPasswordKeyReleased(evt);
								}
								public void keyTyped(KeyEvent evt) {
									txtPasswordKeyTyped(evt);
								}
								public void keyPressed(KeyEvent evt) {
									txtPasswordKeyPressed(evt);
								}
							});
						}
						{
							lblFirstName = new JLabel();
							pnlUserProfile.add(lblFirstName, "6, 3");
							lblFirstName.setText("First Name");
							lblFirstName.setFont(new java.awt.Font("Cambria",0,14));
							lblFirstName.setForeground(new java.awt.Color(64,0,64));
						}
						{
							lblLastName = new JLabel();
							pnlUserProfile.add(lblLastName, "6, 5");
							lblLastName.setText("Last Name");
							lblLastName.setFont(new java.awt.Font("Cambria",0,14));
							lblLastName.setForeground(new java.awt.Color(64,0,64));
						}
						{
							txtFirstName = new JTextField();
							pnlUserProfile.add(txtFirstName, "8, 3, 9, 3");
							txtFirstName.setFont(new java.awt.Font("Cambria",0,14));
							txtFirstName.setForeground(new java.awt.Color(64,0,64));
							txtFirstName.setBackground(new java.awt.Color(240,255,255));
							txtFirstName.addKeyListener(new KeyAdapter() {
								public void keyReleased(KeyEvent evt) {
									txtFirstNameKeyReleased(evt);
								}
								public void keyTyped(KeyEvent evt) {
									txtFirstNameKeyTyped(evt);
								}
								public void keyPressed(KeyEvent evt) {
									txtFirstNameKeyPressed(evt);
								}
							});
						}
						{
							txtLastName = new JTextField();
							pnlUserProfile.add(txtLastName, "8, 5, 9, 5");
							txtLastName.setFont(new java.awt.Font("Cambria",0,14));
							txtLastName.setForeground(new java.awt.Color(64,0,64));
							txtLastName.setBackground(new java.awt.Color(240,255,255));
							txtLastName.addKeyListener(new KeyAdapter() {
								public void keyReleased(KeyEvent evt) {
									txtLastNameKeyReleased(evt);
								}
								public void keyTyped(KeyEvent evt) {
									txtLastNameKeyTyped(evt);
								}
								public void keyPressed(KeyEvent evt) {
									txtLastNameKeyPressed(evt);
								}
							});
						}
						{
							lblAccessType = new JLabel();
							pnlUserProfile.add(lblAccessType, "1, 7");
							lblAccessType.setText("Access Type");
							lblAccessType.setFont(new java.awt.Font("Cambria",0,14));
							lblAccessType.setForeground(new java.awt.Color(64,0,64));
						}
						{
							lblAccessFlag = new JLabel();
							pnlUserProfile.add(lblAccessFlag, "6, 7");
							lblAccessFlag.setText("Access Flag");
							lblAccessFlag.setFont(new java.awt.Font("Cambria",0,14));
							lblAccessFlag.setForeground(new java.awt.Color(64,0,64));
						}
						{
							ComboBoxModel<String> cmbbxAccessTypeModel =
									new DefaultComboBoxModel<String>(
											new String[] { "Admin", "User", "Other"});
							cmbbxAccessType = new JComboBox<String>();
							pnlUserProfile.add(cmbbxAccessType, "3, 7, 4, 7");
							cmbbxAccessType.setModel(cmbbxAccessTypeModel);
						}
						{
							ComboBoxModel<String> jComboBox1Model =
									new DefaultComboBoxModel<String>(
											new String[] { "Allowed", "Blocked" });
							cmbbxAccessFlag = new JComboBox<String>();
							pnlUserProfile.add(cmbbxAccessFlag, "8, 7, 9, 7");
							cmbbxAccessFlag.setModel(jComboBox1Model);
						}
						{
							btnCreateProfile = new JButton();
							pnlUserProfile.add(btnCreateProfile, "8, 1, 10, 1");
							btnCreateProfile.setFont(new java.awt.Font("Cambria",1,14));
							btnCreateProfile.setForeground(new java.awt.Color(64,0,64));
							btnCreateProfile.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									btnCreateProfileActionPerformed(evt);
								}
							});
							btnCreateProfile.setText("Create Profile");
							btnCreateProfile.setEnabled(false);
						}
						{
							ComboBoxModel<String> jComboBox4Model =
									new DefaultComboBoxModel<String>(
											new String[] { "Item One", "Item Two" });
							cmbbxUpdateExistingUser = new JComboBox<String>();
							pnlUserProfile.add(cmbbxUpdateExistingUser, "4, 1, 6, 1");
							cmbbxUpdateExistingUser.setVisible(false);
							cmbbxUpdateExistingUser.setEnabled(false);
							cmbbxUpdateExistingUser.addItemListener(new ItemListener() {
								public void itemStateChanged(ItemEvent evt) {
									cmbbxUpdateExistingUserItemStateChanged(evt);
								}
							});
							cmbbxUpdateExistingUser.setModel(jComboBox4Model);
						}
						{
							rdbtnCreateNewUser = new JRadioButton();
							pnlUserProfile.add(rdbtnCreateNewUser, "1, 1");
							rdbtnCreateNewUser.setText("Create");
							rdbtnCreateNewUser.setFont(new java.awt.Font("Cambria",0,14));
							rdbtnCreateNewUser.setForeground(new java.awt.Color(64,0,64));
						}
						{
							rdbtnUpdateExistingUser = new JRadioButton();
							pnlUserProfile.add(rdbtnUpdateExistingUser, "3, 1");
							rdbtnUpdateExistingUser.setText("Update");
							rdbtnUpdateExistingUser.setFont(new java.awt.Font("Cambria",0,14));
							rdbtnUpdateExistingUser.setForeground(new java.awt.Color(64,0,64));
						}
						/*
						{
							btnRemoveProfile = new JButton();
							pnlUserProfile.add(btnRemoveProfile, "4, 7, 6, 7");
							btnRemoveProfile.setText("Remove Profile");
							btnRemoveProfile.addActionListener(new ActionListener() {								public void actionPerformed(ActionEvent evt) {
									btnRemoveProfileActionPerformed(evt);
								}
							});
							btnRemoveProfile.setEnabled(false);
							btnRemoveProfile.setVisible(false);
						}
						*/
					}
					{
						lblHeadre = new JLabel();
						pnlContainer.add(lblHeadre, "1, 1, 4, 1");
						lblHeadre.setText("Admin Workspace");
						lblHeadre.setFont(new java.awt.Font("Cambria",1,22));
						lblHeadre.setHorizontalAlignment(SwingConstants.CENTER);
						lblHeadre.setHorizontalTextPosition(SwingConstants.CENTER);
						lblHeadre.setForeground(new java.awt.Color(64,0,64));
					}
					{
						pnlLockUnlockProblem = new JPanel();
						pnlContainer.add(pnlLockUnlockProblem, "1, 15, 4, 16");
						TableLayout pnlLockUnlockProblemLayout = new TableLayout(new double[][] {{3.0, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, 3.0}, {6.0, TableLayout.FILL, 6.0}});
						pnlLockUnlockProblemLayout.setHGap(5);
						pnlLockUnlockProblemLayout.setVGap(5);
						pnlLockUnlockProblem.setLayout(pnlLockUnlockProblemLayout);
						pnlLockUnlockProblem.setBackground(new java.awt.Color(125,190,255));
						pnlLockUnlockProblem.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(128,128,128), 1, false), "Lock/Unlock Problem for editing", TitledBorder.LEFT, TitledBorder.TOP, new java.awt.Font("Cambria",1,14), new java.awt.Color(0,0,128)));
						{
							ComboBoxModel<String> jComboBox2Model =
									new DefaultComboBoxModel<String>(
											new String[] { "Item One", "Item Two" });
							cmbbxLockUnlockTrackerId = new JComboBox<String>();
							pnlLockUnlockProblem.add(cmbbxLockUnlockTrackerId, "3, 1");
							cmbbxLockUnlockTrackerId.setModel(jComboBox2Model);
							cmbbxLockUnlockTrackerId.addItemListener(new ItemListener() {
								public void itemStateChanged(ItemEvent evt) {
									cmbbxLockUnlockTrackerIdItemStateChanged(evt);
								}
							});
						}
						{
							btnLockUnlock = new JButton();
							pnlLockUnlockProblem.add(btnLockUnlock, "4, 1");
							btnLockUnlock.setText("Lock");
							btnLockUnlock.setFont(new java.awt.Font("Cambria",1,14));
							btnLockUnlock.setForeground(new java.awt.Color(64,0,64));
							btnLockUnlock.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									btnLockUnlockActionPerformed(evt);
								}
							});
						}
						{
							rdbtnLockProblem = new JRadioButton();
							pnlLockUnlockProblem.add(rdbtnLockProblem, "1, 1");
							rdbtnLockProblem.setText("Lock");
							rdbtnLockProblem.setFont(new java.awt.Font("Cambria",0,14));
							rdbtnLockProblem.setForeground(new java.awt.Color(64,0,64));
							rdbtnLockProblem.addItemListener(new ItemListener() {
								public void itemStateChanged(ItemEvent evt) {
									rdbtnLockProblemItemStateChanged(evt);
								}
							});
						}
						{
							rdbtnUnlock = new JRadioButton();
							pnlLockUnlockProblem.add(rdbtnUnlock, "2, 1");
							rdbtnUnlock.setText("Unlock");
							rdbtnUnlock.setFont(new java.awt.Font("Cambria",0,14));
							rdbtnUnlock.setForeground(new java.awt.Color(64,0,64));
							rdbtnUnlock.addItemListener(new ItemListener() {
								public void itemStateChanged(ItemEvent evt) {
									rdbtnUnlockItemStateChanged(evt);
								}
							});
						}

					}
				}
			}
			pack();
			this.setSize(712, 584);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void chkbxUpdateExistingUserItemStateChanged(ItemEvent evt) {
		/*
		if(this.chkbxUpdateExistingUser.isSelected(){
			this.chkbxUpdateExistingUserSelected();
		}else{
			this.chkbxUpdateExistingUserNotSelected();;
		}
		*/
	}

	private void chkbxUpdateExistingUserSelected(){
		try{
			this.cmbbxUpdateExistingUser.setEnabled(true);
			this.txtUserId.setEnabled(false);
			this.btnCreateProfile.setText("Update Profile");
			//this.btnRemoveProfile.setVisible(true);
			//this.btnRemoveProfile.setEnabled(false);
			this.btnCreateProfile.setEnabled(false);
			Connection objLocalConnection = this.objResourceProvider.getDatabaseConnection("E2ETracker");
			this.objAdminWorkspaceManager.getUserIdList(objLocalConnection);
			this.objResourceProvider.closeDatabaseConnection(objLocalConnection, false, true);
			ComboBoxModel<String> objComboBoxModel = new DefaultComboBoxModel<String>(
					this.objResourceProvider.convertListToArray(
							this.objAdminWorkspaceBean.getListUserId()));
			this.cmbbxUpdateExistingUser.setModel(objComboBoxModel);
			this.adjustPopupWidth(this.cmbbxUpdateExistingUser);
			this.cmbbxUpdateExistingUser.setVisible(true);
			this.cmbbxUpdateExistingUser.setEnabled(true);
			this.txtUserId.setText("");
			this.txtPassword.setText("");
			this.txtFirstName.setText("");
			this.txtLastName.setText("");
			this.userIdFlag = false;
			this.passwordFlag = false;
			this.firstNameFlag = false;
			this.lastNameFlag = false;
			this.checkButtonEnability();
		}catch(ManagerException eMan){
			this.managerExceptionHandling(eMan);;
		}catch(Exception e){
			this.otherExceptionHandling();
		}

	}

	private void chkbxUpdateExistingUserNotSelected(){
		this.cmbbxUpdateExistingUser.setEnabled(false);
		this.txtUserId.setEnabled(true);
		btnCreateProfile.setText("Create Profile");
		//this.btnRemoveProfile.setVisible(false);
		//this.btnRemoveProfile.setEnabled(false);
		//this.btnRemoveProfile.setEnabled(false);
		this.cmbbxUpdateExistingUser.setVisible(false);
		this.cmbbxUpdateExistingUser.setEnabled(false);
		this.txtUserId.setText("");
		this.txtPassword.setText("");
		this.txtFirstName.setText("");
		this.txtLastName.setText("");
		this.userIdFlag = false;
		this.passwordFlag = false;
		this.firstNameFlag = false;
		this.lastNameFlag = false;
		this.checkButtonEnability();
	}

	private void cmbbxUpdateExistingUserItemStateChanged(ItemEvent evt) {
		try{
			if(evt.getStateChange()== ItemEvent.SELECTED){
				String selectItem = (String)this.cmbbxUpdateExistingUser.getSelectedItem();
				if(selectItem.equalsIgnoreCase("--Select User ID--")){
					this.txtUserId.setText("");
					this.txtPassword.setText("");
					this.txtFirstName.setText("");
					this.txtLastName.setText("");
					this.cmbbxAccessType.setSelectedIndex(0);
					this.cmbbxAccessFlag.setSelectedIndex(0);
					this.userIdFlag = false;
					this.passwordFlag = false;
					this.firstNameFlag = false;
					this.lastNameFlag = false;
					this.checkButtonEnability();
				}else{
					Connection objLocalConnection = this.objResourceProvider.getDatabaseConnection("E2ETracker");
					this.objAdminWorkspaceManager.getUserDetails(objLocalConnection, (String)this.cmbbxUpdateExistingUser.getSelectedItem());
					this.objResourceProvider.closeDatabaseConnection(objLocalConnection, false, true);
					this.txtUserId.setText(this.objAdminWorkspaceBean.getUserId());
					this.txtPassword.setText(this.objAdminWorkspaceBean.getPassword());
					this.txtFirstName.setText(this.objAdminWorkspaceBean.getFirstName());
					this.txtLastName.setText(this.objAdminWorkspaceBean.getLastName());
					this.userIdFlag = true;
					this.passwordFlag = true;
					this.firstNameFlag = true;
					this.lastNameFlag = true;
					this.checkButtonEnability();
					if(this.objAdminWorkspaceBean.getAccessType().equalsIgnoreCase("A")){
						this.cmbbxAccessType.setSelectedIndex(0);
					}else if(this.objAdminWorkspaceBean.getAccessType().equalsIgnoreCase("U")){
						this.cmbbxAccessType.setSelectedIndex(1);
					}else{
						this.cmbbxAccessType.setSelectedIndex(2);
					}

					if(this.objAdminWorkspaceBean.getAccessFlag().equalsIgnoreCase("Y")){
						this.cmbbxAccessFlag.setSelectedIndex(0);
					}else{
						this.cmbbxAccessFlag.setSelectedIndex(1);
					}
				}
			}
		}catch(ManagerException eMan){
			this.managerExceptionHandling(eMan);;
		}catch(Exception e){
			this.otherExceptionHandling();
		}
	}

	private final void adjustPopupWidth(JComboBox<String> box) {
        if (box.getItemCount() == 0) {
            return;
        }

        Object comp = box.getUI().getAccessibleChild(box, 0);
        if (!(comp instanceof JPopupMenu)) {
            return;
        }

        JPopupMenu popup = (JPopupMenu) comp;
        JScrollPane scrollPane = (JScrollPane) popup.getComponent(0);
        Dimension size = scrollPane.getPreferredSize();
        scrollPane.setPreferredSize(size);
        scrollPane.setMaximumSize(size);
	}
/*
	private void btnRemoveProfileActionPerformed(ActionEvent evt) {
		try{
			String userId = (String)this.cmbbxUpdateExistingUser.getSelectedItem();
			Connection objLocalConnection = this.objResourceProvider.getDatabaseConnection("E2ETracker");
			this.objAdminWorkspaceManager.deleteUserProfile(objLocalConnection, userId);
			this.objResourceProvider.closeDatabaseConnection(objLocalConnection, true, true);
            JOptionPane.showMessageDialog(this,"User Id: "+userId+" has been removed successfully.", "Application Message",JOptionPane.INFORMATION_MESSAGE);
            this.chkbxUpdateExistingUserSelected();
		}catch(ManagerException eMan){
			this.managerExceptionHandling(eMan);;
		}catch(Exception e){
			this.otherExceptionHandling();
		}
	}
*/
	private void btnCreateProfileActionPerformed(ActionEvent evt){
		try{
			List<String> listUserDetails = new ArrayList<String>();
			boolean updatePassword = false;
			String userId = this.txtUserId.getText();
			String password = this.txtPassword.getText();
			String firstName = this.txtFirstName.getText();
			String lastName = this.txtLastName.getText();
			String accessType = (String)this.cmbbxAccessType.getSelectedItem();
			String accessFlag = (String)this.cmbbxAccessFlag.getSelectedItem();

			if(accessType.equalsIgnoreCase("Admin")){
				accessType = "A";
			}else if(accessType.equalsIgnoreCase("User")){
				accessType = "U";
			}else{
				accessType = "O";
			}


			if(accessFlag.equalsIgnoreCase("Allowed")){
				accessFlag = "Y";
			}else{
				accessFlag = "N";
			}

			listUserDetails.add(userId);
			listUserDetails.add(firstName);
			listUserDetails.add(lastName);
			listUserDetails.add(accessType);
			listUserDetails.add(accessFlag);

			if (password.length() < 8){
				updatePassword = false;
				listUserDetails.add(1, null);
			}else{
				updatePassword = true;
				listUserDetails.add(1, this.objResourceProvider.getEncryptPassword(password));
			}
			/*
			if(this.chkbxUpdateExistingUser.isSelected()){
				Connection objLocalConnection = this.objResourceProvider.getDatabaseConnection("E2ETracker");
				this.objAdminWorkspaceManager.updateUserProfile(objLocalConnection, listUserDetails, updatePassword);
				this.objResourceProvider.closeDatabaseConnection(objLocalConnection, true, true);
	            JOptionPane.showMessageDialog(this,"User Id: "+userId+" has been updated successfully.", "Application Message",JOptionPane.INFORMATION_MESSAGE);
	            this.chkbxUpdateExistingUserSelected();
			}else{
				Connection objLocalConnection = this.objResourceProvider.getDatabaseConnection("E2ETracker");
				this.objAdminWorkspaceManager.createUserProfile(objLocalConnection, listUserDetails);
				this.objResourceProvider.closeDatabaseConnection(objLocalConnection, true, true);
	            JOptionPane.showMessageDialog(this,"User Id: "+userId+" has been created successfully.", "Application Message",JOptionPane.INFORMATION_MESSAGE);
				this.chkbxUpdateExistingUserNotSelected();
			}*/
		}catch(ManagerException eMan){
			this.managerExceptionHandling(eMan);
		}catch(Exception e){
			e.printStackTrace();
			this.otherExceptionHandling();
		}
	}

	private boolean verifyUserId(String inputString){
		if(inputString.matches("^[id]{2}\\d{6}") && inputString.length()==8){
			return true;
		}else{
			return false;
		}
	}

	private boolean verifyFirstAndLastName(String inputString){
		if(inputString.matches("[a-zA-Z]+") && inputString.length()>3){
			return true;
		}else{
			return false;
		}
	}

	private boolean verifyPassword(String inputString){
		/*
		if(this.chkbxUpdateExistingUser.isSelected()){
			if(inputString.length()>7 || inputString.length()==0){
				return true;
			}else{
				return false;
			}
		}else{
			if(inputString.length()>7){
				return true;
			}else{
				return false;
			}
		}*/
		return false;
	}

	private void otherExceptionHandling(){
		JOptionPane.showMessageDialog(this, "Unknown error encountered by application. Please contact administrator.", "Application Error", JOptionPane.ERROR_MESSAGE);
	}

	private void managerExceptionHandling(ManagerException eMan){
		if(this.objResourceProvider.compareString(eMan.getErrorType(), "I")){
            JOptionPane.showMessageDialog(this, eMan.getErrorMessage(), eMan.getErrorName(),JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, eMan.getErrorMessage(), eMan.getErrorName(), JOptionPane.ERROR_MESSAGE);
        }
	}

	private void txtUserIdKeyPressed(KeyEvent evt) {
		if(this.verifyUserId(this.txtUserId.getText())){
			this.txtUserId.setBackground(new java.awt.Color(240,255,255));
			this.userIdFlag = true;
		}else{
			this.txtUserId.setBackground(new java.awt.Color(255,206,206));
			this.userIdFlag = false;
		}

		this.checkButtonEnability();
	}

	private void txtUserIdKeyTyped(KeyEvent evt) {
		if(this.verifyUserId(this.txtUserId.getText())){
			this.txtUserId.setBackground(new java.awt.Color(240,255,255));
			this.userIdFlag = true;
		}else{
			this.txtUserId.setBackground(new java.awt.Color(255,206,206));
			this.userIdFlag = false;
		}

		this.checkButtonEnability();
	}

	private void txtUserIdKeyReleased(KeyEvent evt) {
		if(this.verifyUserId(this.txtUserId.getText())){
			this.txtUserId.setBackground(new java.awt.Color(240,255,255));
			this.userIdFlag = true;
		}else{
			this.txtUserId.setBackground(new java.awt.Color(255,206,206));
			this.userIdFlag = false;
		}

		this.checkButtonEnability();
	}

	private void txtPasswordKeyPressed(KeyEvent evt) {
		if(this.verifyPassword(this.txtPassword.getText())){
			this.txtPassword.setBackground(new java.awt.Color(240,255,255));
			this.passwordFlag = true;
		}else{
			this.txtPassword.setBackground(new java.awt.Color(255,206,206));
			this.passwordFlag = false;
		}

		this.checkButtonEnability();
	}

	private void txtPasswordKeyReleased(KeyEvent evt) {
		if(this.verifyPassword(this.txtPassword.getText())){
			this.txtPassword.setBackground(new java.awt.Color(240,255,255));
			this.passwordFlag = true;
		}else{
			this.txtPassword.setBackground(new java.awt.Color(255,206,206));
			this.passwordFlag = false;
		}

		this.checkButtonEnability();
	}

	private void txtPasswordKeyTyped(KeyEvent evt) {
		if(this.verifyPassword(this.txtPassword.getText())){
			this.txtPassword.setBackground(new java.awt.Color(240,255,255));
			this.passwordFlag = true;
		}else{
			this.txtPassword.setBackground(new java.awt.Color(255,206,206));
			this.passwordFlag = false;
		}

		this.checkButtonEnability();
	}

	private void txtFirstNameKeyPressed(KeyEvent evt) {
		if(this.verifyFirstAndLastName(this.txtFirstName.getText())){
			this.txtFirstName.setBackground(new java.awt.Color(240,255,255));
			this.firstNameFlag = true;
		}else{
			this.txtFirstName.setBackground(new java.awt.Color(255,206,206));
			this.firstNameFlag = false;
		}

		this.checkButtonEnability();
	}

	private void txtFirstNameKeyTyped(KeyEvent evt) {
		if(this.verifyFirstAndLastName(this.txtFirstName.getText())){
			this.txtFirstName.setBackground(new java.awt.Color(240,255,255));
			this.firstNameFlag = true;
		}else{
			this.txtFirstName.setBackground(new java.awt.Color(255,206,206));
			this.firstNameFlag = false;
		}

		this.checkButtonEnability();
	}

	private void txtFirstNameKeyReleased(KeyEvent evt) {
		if(this.verifyFirstAndLastName(this.txtFirstName.getText())){
			this.txtFirstName.setBackground(new java.awt.Color(240,255,255));
			this.firstNameFlag = true;
		}else{
			this.txtFirstName.setBackground(new java.awt.Color(255,206,206));
			this.firstNameFlag = false;
		}

		this.checkButtonEnability();
	}

	private void txtLastNameKeyPressed(KeyEvent evt) {
		if(this.verifyFirstAndLastName(this.txtLastName.getText())){
			this.txtLastName.setBackground(new java.awt.Color(240,255,255));
			this.lastNameFlag = true;
		}else{
			this.txtLastName.setBackground(new java.awt.Color(255,206,206));
			this.lastNameFlag = false;
		}

		this.checkButtonEnability();
	}

	private void txtLastNameKeyTyped(KeyEvent evt) {
		if(this.verifyFirstAndLastName(this.txtLastName.getText())){
			this.txtLastName.setBackground(new java.awt.Color(240,255,255));
			this.lastNameFlag = true;
		}else{
			this.txtLastName.setBackground(new java.awt.Color(255,206,206));
			this.lastNameFlag = false;
		}

		this.checkButtonEnability();
	}

	private void txtLastNameKeyReleased(KeyEvent evt) {
		if(this.verifyFirstAndLastName(this.txtLastName.getText())){
			this.txtLastName.setBackground(new java.awt.Color(240,255,255));
			this.lastNameFlag = true;
		}else{
			this.txtLastName.setBackground(new java.awt.Color(255,206,206));
			this.lastNameFlag = false;
		}

		this.checkButtonEnability();
	}

	private void checkButtonEnability(){
		if(this.userIdFlag && this.passwordFlag && this.firstNameFlag && this.lastNameFlag){
			this.btnCreateProfile.setEnabled(true);
			//this.btnRemoveProfile.setEnabled(true);
		}else{
			this.btnCreateProfile.setEnabled(false);
			//this.btnRemoveProfile.setEnabled(false);
		}
	}

	private void rdbtnAutoModeItemStateChanged(ItemEvent evt) {
		if(this.rdbtnAutoMode.isSelected()){
			ComboBoxModel<String> cmbbxOptionNameModel =
					new DefaultComboBoxModel<String>(
							new String[] { "Detected In", "Application Name"});
			this.cmbbxOptionName.setModel(cmbbxOptionNameModel);
			this.rdbtnManualMode.setSelected(false);
			this.txtUpdateCodeDetails.setVisible(false);
			this.txtUpdateCodeDetails.setText("");
			this.scrpnCodeDetailsValue.setVisible(false);
			this.listCodeDetailsValue.setVisible(false);
		}else{
			this.rdbtnManualMode.setSelected(true);
		}
	}

	private void rdbtnManualModeItemStateChanged(ItemEvent evt) {
		if(this.rdbtnManualMode.isSelected()){
			ComboBoxModel<String> cmbbxOptionNameModel =
					new DefaultComboBoxModel<String>(
							new String[] { "Detected In", "Application Name", "Status", "Business Risk", "Problem Type", "Work Basket"});
			this.cmbbxOptionName.setModel(cmbbxOptionNameModel);
			this.rdbtnAutoMode.setSelected(false);
			this.txtUpdateCodeDetails.setVisible(true);
		}else{
			this.rdbtnAutoMode.setSelected(true);
			this.txtUpdateCodeDetails.setVisible(false);
		}
	}


	private void rdbtnUnlockItemStateChanged(ItemEvent evt) {
		System.out.println("rdbtnUnlock.itemStateChanged, event="+evt);
		//TODO add your code for rdbtnUnlock.itemStateChanged
	}

	private void rdbtnLockProblemItemStateChanged(ItemEvent evt) {
		System.out.println("rdbtnLockProblem.itemStateChanged, event="+evt);
		//TODO add your code for rdbtnLockProblem.itemStateChanged
	}

	private void btnLockUnlockActionPerformed(ActionEvent evt) {
		System.out.println("btnLockUnlock.actionPerformed, event="+evt);
		//TODO add your code for btnLockUnlock.actionPerformed
	}

	private void cmbbxLockUnlockTrackerIdItemStateChanged(ItemEvent evt) {
		System.out.println("cmbbxLockUnlockTrackerId.itemStateChanged, event="+evt);
		//TODO add your code for cmbbxLockUnlockTrackerId.itemStateChanged
	}

	private void btnUpdateOptionActionPerformed(ActionEvent evt) {
		System.out.println("btnUpdateOption.actionPerformed, event="+evt);
		//TODO add your code for btnUpdateOption.actionPerformed
	}

	private void cmbbxOptionNameItemStateChanged(ItemEvent evt) {
		System.out.println("cmbbxOptionName.itemStateChanged, event="+evt);
		//TODO add your code for cmbbxOptionName.itemStateChanged
	}

	private void jRadioButton1ItemStateChanged(ItemEvent evt) {
		System.out.println("jRadioButton1.itemStateChanged, event="+evt);
		//TODO add your code for jRadioButton1.itemStateChanged
	}

}
