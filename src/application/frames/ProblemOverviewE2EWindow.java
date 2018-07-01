package application.frames;

import info.clearthought.layout.TableLayout;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.util.Calendar;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import application.beans.LoginBean;
import application.beans.ProblemOverviewE2EBean;
import application.exceptions.ManagerException;
import application.manager.ProblemOverviewE2EManager;


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
public class ProblemOverviewE2EWindow extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	{
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JPanel pnlMain;
	private JLabel lblUserName;
	private JTextArea txtarComments;
	private JTextArea txtarWorkaround;
	private JTextArea txtarErrorDescription;
	private JLabel lblHPSMIncidentOverview;
	private JLabel lblHPSMProblemOverview;
	private JLabel lblQCTDefectWindow;
	private JScrollPane scrpnActivityLogs;
	private JButton btnReset;
	private JLabel lblLockStatus;
	private JCheckBox chkbxLogNewProblem;
	private JButton btnInsert;
	private JComboBox<String> cmbbxUpdateExixtingProblem;
	private JCheckBox chkbxEnableEditing;
	private JTextField txtLastUpdatedOn;
	private JTextField txtIssueLoggedOn;
	private JTextField txtErrorCode;
	private JTextField txtAssignedTo;
	private JLabel lblAssignedTo;
	private JComboBox<String> cmbbxDetectedIn;
	private JComboBox<String> cmbbxWorkBasket;
	private JComboBox<String> cmbbxApplicationName;
	private JComboBox<String> cmbbxSysRetError;
	private JComboBox<String> cmbbxBusinessRisk;
	private JComboBox<String> cmbbxStatus;
	private JTextField txtIncidentId;
	private JTextField txtProblemId;
	private JTextField txtDefectId;
	private JTextField txtTrackerId;
	private JLabel lblBusinessRisk;
	private JLabel lblDashboard;
	private JComboBox<String> cmbbxProblemType;
	private JLabel lblProblemType;
	private JLabel lblErrorCode;
	private JLabel lblWorkBasket;
	private JLabel lblIssueLoggedOn;
	private JLabel lblIssueLoggedBy;
	private JLabel lblLastUpdatedOn;
	private JLabel lblSysRetError;
	private JLabel lblApplicationName;
	private JLabel lblDetectedIn;
	private JTextArea txtarProblemDescription;
	private JScrollPane scrpnProblemDescription;
	private JLabel lblStatus;
	private JLabel lblIncidentId;
	private JLabel lblProblemId;
	private JLabel lblDefectId;
	private JLabel lblTrackerId;
	private JTextArea txtarActivityLogs;
	private JScrollPane scrpnComments;
	private JScrollPane scrpnWorkaround;
	private JScrollPane scrpnErrorDescription;
	private JLabel lblHeader;
	private JPanel pnlHeader;
	private JPanel pnlDescriptionComments;
	private JLabel lblHeaderLeft;
	private JTextField txtIssueLoggedBy;
	private JPanel pnlE2EProblemDetails;
	private JPanel pnlContainer;
	private boolean saveRequiredFlag;
	private boolean defectIdFlag ;
	private boolean incidentIfFlag;
	private boolean problemIdFlag;
	private final ResourceProvider objResourceProvider;
	private final LoginBean objLoginBean;
	private final DashboardWindow objDashboardWindow;
	private final ProblemOverviewE2EBean objProblemOverviewE2EBean;
	private final ProblemOverviewE2EManager objProblemOverviewE2EManager;

 	public ProblemOverviewE2EWindow(DashboardWindow objDashboardWindow) {
 		super();
 		this.objDashboardWindow = objDashboardWindow;
 		this.objResourceProvider = objDashboardWindow.getObjResourceProvider();
 		this.objLoginBean = objDashboardWindow.getObjLoginBean();
		this.objProblemOverviewE2EBean = new ProblemOverviewE2EBean();
		this.objProblemOverviewE2EManager = new ProblemOverviewE2EManager(this.objResourceProvider,
				objProblemOverviewE2EBean, objDashboardWindow.getObjDashboardManager());
		this.initBeanWithDefauleValues(true);
		this.initGUI();
		this.applyProfileConstraint();
		saveRequiredFlag = false;
		defectIdFlag = true;
		incidentIfFlag = true;
		problemIdFlag = true;
	}

	private void initGUI() {
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("E2E Tracker - Problem Overview (E2E)");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt){
				problemOverviewE2EWindowClosing(evt);
			}
		});
		{
			pnlMain = new JPanel();
			getContentPane().add(pnlMain, BorderLayout.CENTER);
			pnlMain.setLayout(null);
			pnlMain.setPreferredSize(new java.awt.Dimension(1249, 822));
			pnlMain.setBackground(new java.awt.Color(125,190,255));
			{
				pnlContainer = new JPanel();
				TableLayout jPanel2Layout = new TableLayout(new double[][] {{3.0, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, 3.0}, {TableLayout.FILL, 70.0, TableLayout.FILL, 46.0, 6.0, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, 3.0}});
				jPanel2Layout.setHGap(5);
				jPanel2Layout.setVGap(5);
				pnlContainer.setLayout(jPanel2Layout);
				pnlMain.add(pnlContainer);
				pnlContainer.setBounds(0, 0, 1599, 822);
				pnlContainer.setBackground(new java.awt.Color(125,190,255));
				pnlContainer.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
				pnlContainer.setForeground(new java.awt.Color(0,0,160));
				{
					pnlE2EProblemDetails = new JPanel();
					TableLayout pnlE2EProblemDetailsLayout = new TableLayout(new double[][] {{TableLayout.PREFERRED, 176.0, 3.0, 128.0, TableLayout.FILL, 3.0, 147.0, 210.0, 6.0, TableLayout.FILL, 285.0, 3.0, TableLayout.FILL}, {TableLayout.FILL, 6.0, TableLayout.FILL, 6.0, TableLayout.FILL, 6.0, TableLayout.FILL}});
					pnlE2EProblemDetailsLayout.setHGap(5);
					pnlE2EProblemDetailsLayout.setVGap(5);
					pnlE2EProblemDetails.setLayout(pnlE2EProblemDetailsLayout);
					pnlContainer.add(pnlE2EProblemDetails, "1, 1, 3, 3");
					pnlE2EProblemDetails.setBackground(new java.awt.Color(125,190,255));
					pnlE2EProblemDetails.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(192,192,192), 2, true), "Problem Details", TitledBorder.LEFT, TitledBorder.TOP, new java.awt.Font("Cambria",1,14), new java.awt.Color(0,0,64)));
					{
						txtIssueLoggedBy = new JTextField();
						pnlE2EProblemDetails.add(txtIssueLoggedBy, "10, 4");
						txtIssueLoggedBy.setEditable(false);
						txtIssueLoggedBy.setBackground(new java.awt.Color(232,248,255));
						txtIssueLoggedBy.setForeground(new java.awt.Color(0,0,0));
						txtIssueLoggedBy.setFont(new java.awt.Font("Cambria",0,14));
					}
					{
						lblTrackerId = new JLabel();
						pnlE2EProblemDetails.add(lblTrackerId, "0, 0");
						lblTrackerId.setText("Tracker ID");
						lblTrackerId.setBackground(new java.awt.Color(64,0,64));
						lblTrackerId.setFont(new java.awt.Font("Cambria",1,16));
						lblTrackerId.setForeground(new java.awt.Color(64,0,64));
					}
					{
						txtTrackerId = new JTextField();
						pnlE2EProblemDetails.add(txtTrackerId, "1, 0");
						txtTrackerId.setBackground(new java.awt.Color(232,248,255));
						txtTrackerId.setEditable(false);
						txtTrackerId.setForeground(new java.awt.Color(0,0,0));
						txtTrackerId.setFont(new java.awt.Font("Cambria",0,14));
					}
					{
						lblDefectId = new JLabel();
						pnlE2EProblemDetails.add(lblDefectId, "3, 0");
						lblDefectId.setText("Defect Id");
						lblDefectId.setBackground(new java.awt.Color(64,0,64));
						lblDefectId.setFont(new java.awt.Font("Cambria",1,16));
						lblDefectId.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblProblemId = new JLabel();
						pnlE2EProblemDetails.add(lblProblemId, "3, 4");
						lblProblemId.setText("Problem ID");
						lblProblemId.setBackground(new java.awt.Color(64,0,64));
						lblProblemId.setFont(new java.awt.Font("Cambria",1,16));
						lblProblemId.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblIncidentId = new JLabel();
						pnlE2EProblemDetails.add(lblIncidentId, "3, 2");
						lblIncidentId.setText("Incident ID");
						lblIncidentId.setBackground(new java.awt.Color(64,0,64));
						lblIncidentId.setFont(new java.awt.Font("Cambria",1,16));
						lblIncidentId.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblStatus = new JLabel();
						pnlE2EProblemDetails.add(lblStatus, "6, 0");
						lblStatus.setText("Status");
						lblStatus.setBackground(new java.awt.Color(64,0,64));
						lblStatus.setFont(new java.awt.Font("Cambria",1,16));
						lblStatus.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblDetectedIn = new JLabel();
						pnlE2EProblemDetails.add(lblDetectedIn, "0, 6");
						lblDetectedIn.setText("Detected In");
						lblDetectedIn.setBackground(new java.awt.Color(64,0,64));
						lblDetectedIn.setFont(new java.awt.Font("Cambria",1,16));
						lblDetectedIn.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblApplicationName = new JLabel();
						pnlE2EProblemDetails.add(lblApplicationName, "6, 2");
						lblApplicationName.setText("Application Name");
						lblApplicationName.setBackground(new java.awt.Color(64,0,64));
						lblApplicationName.setFont(new java.awt.Font("Cambria",1,16));
						lblApplicationName.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblSysRetError = new JLabel();
						pnlE2EProblemDetails.add(lblSysRetError, "6, 4");
						lblSysRetError.setText("Sys. Ret. Error");
						lblSysRetError.setBackground(new java.awt.Color(64,0,64));
						lblSysRetError.setFont(new java.awt.Font("Cambria",1,16));
						lblSysRetError.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblLastUpdatedOn = new JLabel();
						pnlE2EProblemDetails.add(lblLastUpdatedOn, "9, 2");
						lblLastUpdatedOn.setText("Last Updated On");
						lblLastUpdatedOn.setBackground(new java.awt.Color(64,0,64));
						lblLastUpdatedOn.setFont(new java.awt.Font("Cambria",1,16));
						lblLastUpdatedOn.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblIssueLoggedBy = new JLabel();
						pnlE2EProblemDetails.add(lblIssueLoggedBy, "9, 4");
						lblIssueLoggedBy.setText("Issue Logged By");
						lblIssueLoggedBy.setBackground(new java.awt.Color(64,0,64));
						lblIssueLoggedBy.setFont(new java.awt.Font("Cambria",1,16));
						lblIssueLoggedBy.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblIssueLoggedOn = new JLabel();
						pnlE2EProblemDetails.add(lblIssueLoggedOn, "9, 6");
						lblIssueLoggedOn.setText("Issue Logged On");
						lblIssueLoggedOn.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
						lblIssueLoggedOn.setBackground(new java.awt.Color(64,0,64));
						lblIssueLoggedOn.setFont(new java.awt.Font("Cambria",1,16));
						lblIssueLoggedOn.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblWorkBasket = new JLabel();
						pnlE2EProblemDetails.add(lblWorkBasket, "9, 0");
						lblWorkBasket.setText("Work Basket");
						lblWorkBasket.setBackground(new java.awt.Color(64,0,64));
						lblWorkBasket.setFont(new java.awt.Font("Cambria",1,16));
						lblWorkBasket.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblErrorCode = new JLabel();
						pnlE2EProblemDetails.add(lblErrorCode, "3, 6");
						lblErrorCode.setText("Error Code");
						lblErrorCode.setBackground(new java.awt.Color(64,0,64));
						lblErrorCode.setFont(new java.awt.Font("Cambria",1,16));
						lblErrorCode.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblProblemType = new JLabel();
						pnlE2EProblemDetails.add(lblProblemType, "0, 2");
						lblProblemType.setText("Problem Type");
						lblProblemType.setBackground(new java.awt.Color(64,0,64));
						lblProblemType.setFont(new java.awt.Font("Cambria",1,16));
						lblProblemType.setForeground(new java.awt.Color(64,0,64));
					}
					{
						ComboBoxModel<String> cmbProblemTypeModel =
								new DefaultComboBoxModel<String>(
										this.objResourceProvider.convertListToArray(
												this.objProblemOverviewE2EBean.getDefaultListProblemType()));
						cmbbxProblemType = new JComboBox<String>();
						pnlE2EProblemDetails.add(cmbbxProblemType, "1, 2");
						cmbbxProblemType.setModel(cmbProblemTypeModel);
						cmbbxProblemType.setForeground(new java.awt.Color(0,0,0));
						cmbbxProblemType.setFont(new java.awt.Font("Cambria",0,14));
						cmbbxProblemType.setBackground(new java.awt.Color(79,198,255));
						cmbbxProblemType.addItemListener(new ItemListener() {
							public void itemStateChanged(ItemEvent evt) {
								cmbbxProblemTypeItemStateChanged(evt);
							}
						});
						this.adjustPopupWidth(this.cmbbxProblemType);
					}
					{
						lblBusinessRisk = new JLabel();
						pnlE2EProblemDetails.add(lblBusinessRisk, "0, 4");
						lblBusinessRisk.setText("Business Risk");
						lblBusinessRisk.setBackground(new java.awt.Color(64,0,64));
						lblBusinessRisk.setFont(new java.awt.Font("Cambria",1,16));
						lblBusinessRisk.setForeground(new java.awt.Color(64,0,64));
					}
					{
						txtDefectId = new JTextField();
						pnlE2EProblemDetails.add(txtDefectId, "4, 0");
						txtDefectId.addFocusListener(new FocusAdapter() {
							public void focusLost(FocusEvent evt) {
								txtDefectIdFocusLost(evt);
							}
						});
						txtDefectId.setBackground(new java.awt.Color(232,248,255));
						txtDefectId.setEditable(false);
						txtDefectId.setForeground(new java.awt.Color(0,0,0));
						txtDefectId.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								txtDefectIdMouseClicked(evt);
							}
						});
						txtDefectId.addKeyListener(new KeyAdapter() {
							public void keyTyped(KeyEvent evt) {
								txtDefectIdKeyTyped(evt);
							}
							public void keyReleased(KeyEvent evt) {
								txtDefectIdKeyReleased(evt);
							}
							public void keyPressed(KeyEvent evt) {
								txtDefectIdKeyPressed(evt);
							}
						});
						txtDefectId.setFont(new java.awt.Font("Cambria",0,14));
					}
					{
						txtProblemId = new JTextField();
						pnlE2EProblemDetails.add(txtProblemId, "4, 4");
						txtProblemId.setBackground(new java.awt.Color(232,248,255));
						txtProblemId.setEditable(false);
						txtProblemId.setForeground(new java.awt.Color(0,0,0));
						txtProblemId.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								txtProblemIdMouseClicked(evt);
							}
						});
						txtProblemId.addKeyListener(new KeyAdapter() {
							public void keyTyped(KeyEvent evt) {
								txtProblemIdKeyTyped(evt);
							}
							public void keyReleased(KeyEvent evt) {
								txtProblemIdKeyReleased(evt);
							}
							public void keyPressed(KeyEvent evt) {
								txtProblemIdKeyPressed(evt);
							}
						});
						txtProblemId.setFont(new java.awt.Font("Cambria",0,14));
					}
					{
						txtIncidentId = new JTextField();
						pnlE2EProblemDetails.add(txtIncidentId, "4, 2");
						txtIncidentId.setBackground(new java.awt.Color(232,248,255));
						txtIncidentId.setEditable(false);
						txtIncidentId.setForeground(new java.awt.Color(0,0,0));
						txtIncidentId.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								txtIncidentIdMouseClicked(evt);
							}
						});
						txtIncidentId.addKeyListener(new KeyAdapter() {
							public void keyTyped(KeyEvent evt) {
								txtIncidentIdKeyTyped(evt);
							}
							public void keyReleased(KeyEvent evt) {
								txtIncidentIdKeyReleased(evt);
							}
							public void keyPressed(KeyEvent evt) {
								txtIncidentIdKeyPressed(evt);
							}
						});
						txtIncidentId.setFont(new java.awt.Font("Cambria",0,14));
					}
					{
						ComboBoxModel<String> jComboBox1Model =
								new DefaultComboBoxModel<String>(
										this.objResourceProvider.convertListToArray(
												this.objProblemOverviewE2EBean.getDefaultListStatus()));
						cmbbxStatus = new JComboBox<String>();
						pnlE2EProblemDetails.add(cmbbxStatus, "7, 0");
						cmbbxStatus.setForeground(new java.awt.Color(0,0,0));
						cmbbxStatus.addItemListener(new ItemListener() {
							public void itemStateChanged(ItemEvent evt) {
								cmbbxStatusItemStateChanged(evt);
							}
						});
						cmbbxStatus.setModel(jComboBox1Model);
						cmbbxStatus.setBackground(new java.awt.Color(79,198,255));
						this.adjustPopupWidth(this.cmbbxStatus);
					}
					{
						ComboBoxModel<String> cmbbxBusinessRiskModel =
								new DefaultComboBoxModel<String>(
										this.objResourceProvider.convertListToArray(
												this.objProblemOverviewE2EBean.getDefaultListBusinessRisk()));
						cmbbxBusinessRisk = new JComboBox<String>();
						pnlE2EProblemDetails.add(cmbbxBusinessRisk, "1, 4");
						cmbbxBusinessRisk.setModel(cmbbxBusinessRiskModel);
						cmbbxBusinessRisk.setForeground(new java.awt.Color(0,0,0));
						cmbbxBusinessRisk.setFont(new java.awt.Font("Cambria",0,14));
						cmbbxBusinessRisk.setBackground(new java.awt.Color(79,198,255));
						cmbbxBusinessRisk.addItemListener(new ItemListener() {
							public void itemStateChanged(ItemEvent evt) {
								cmbbxBusinessRiskItemStateChanged(evt);
							}
						});
						this.adjustPopupWidth(this.cmbbxBusinessRisk);
					}
					{
						ComboBoxModel<String> cmbbxIdentifiedInProjectModel =
								new DefaultComboBoxModel<String>(
										this.objResourceProvider.convertListToArray(
												this.objProblemOverviewE2EBean.getDefaultListApplicationName()));
						cmbbxSysRetError = new JComboBox<String>();
						pnlE2EProblemDetails.add(cmbbxSysRetError, "7, 4");
						cmbbxSysRetError.setModel(cmbbxIdentifiedInProjectModel);
						cmbbxSysRetError.setBackground(new java.awt.Color(79,198,255));
						cmbbxSysRetError.setForeground(new java.awt.Color(0,0,0));
						cmbbxSysRetError.addItemListener(new ItemListener() {
							public void itemStateChanged(ItemEvent evt) {
								cmbbxSysRetErrorItemStateChanged(evt);
							}
						});
						this.adjustPopupWidth(this.cmbbxSysRetError);
					}
					{
						ComboBoxModel<String> cmbbxApplicationNameModel =
								new DefaultComboBoxModel<String>(
										this.objResourceProvider.convertListToArray(
												this.objProblemOverviewE2EBean.getDefaultListApplicationName()));
						cmbbxApplicationName = new JComboBox<String>();
						pnlE2EProblemDetails.add(cmbbxApplicationName, "7, 2");
						cmbbxApplicationName.setModel(cmbbxApplicationNameModel);
						cmbbxApplicationName.setBackground(new java.awt.Color(79,198,255));
						cmbbxApplicationName.setForeground(new java.awt.Color(0,0,0));
						cmbbxApplicationName.addItemListener(new ItemListener() {
							public void itemStateChanged(ItemEvent evt) {
								cmbbxApplicationNameItemStateChanged(evt);
							}
						});
						this.adjustPopupWidth(this.cmbbxApplicationName);
					}
					{
						ComboBoxModel<String> cmbbxWorkBasketModel =
								new DefaultComboBoxModel<String>(
										this.objResourceProvider.convertListToArray(
												this.objProblemOverviewE2EBean.getDefaultListWorkBasket()));
						cmbbxWorkBasket = new JComboBox<String>();
						pnlE2EProblemDetails.add(cmbbxWorkBasket, "10, 0");
						cmbbxWorkBasket.setModel(cmbbxWorkBasketModel);
						cmbbxWorkBasket.setBackground(new java.awt.Color(79,198,255));
						cmbbxWorkBasket.setForeground(new java.awt.Color(0,0,0));
						cmbbxWorkBasket.addItemListener(new ItemListener() {
							public void itemStateChanged(ItemEvent evt) {
								cmbbxWorkBasketItemStateChanged(evt);
							}
						});
						this.adjustPopupWidth(this.cmbbxWorkBasket);
					}
					{
						ComboBoxModel<String> cmbbxDetectedInModel =
								new DefaultComboBoxModel<String>(
										this.objResourceProvider.convertListToArray(
												this.objProblemOverviewE2EBean.getDefaultListDetectedIn()));
						cmbbxDetectedIn = new JComboBox<String>();
						pnlE2EProblemDetails.add(cmbbxDetectedIn, "1, 6");
						cmbbxDetectedIn.setModel(cmbbxDetectedInModel);
						cmbbxDetectedIn.setBackground(new java.awt.Color(79,198,255));
						cmbbxDetectedIn.setForeground(new java.awt.Color(0,0,0));
						cmbbxDetectedIn.addItemListener(new ItemListener() {
							public void itemStateChanged(ItemEvent evt) {
								cmbbxDetectedInItemStateChanged(evt);
							}
						});
						this.adjustPopupWidth(this.cmbbxDetectedIn);
					}
					{
						lblAssignedTo = new JLabel();
						pnlE2EProblemDetails.add(lblAssignedTo, "6, 6");
						lblAssignedTo.setText("Assigned To");
						lblAssignedTo.setFont(new java.awt.Font("Cambria",1,16));
						lblAssignedTo.setForeground(new java.awt.Color(64,0,64));
					}
					{
						txtAssignedTo = new JTextField();
						pnlE2EProblemDetails.add(txtAssignedTo, "7, 6");
						txtAssignedTo.setBackground(new java.awt.Color(232,248,255));
						txtAssignedTo.setEditable(false);
						txtAssignedTo.setForeground(new java.awt.Color(0,0,0));
						txtAssignedTo.setFont(new java.awt.Font("Cambria",0,14));
					}
					{
						txtErrorCode = new JTextField();
						pnlE2EProblemDetails.add(txtErrorCode, "4, 6");
						txtErrorCode.setBackground(new java.awt.Color(232,248,255));
						txtErrorCode.setEditable(false);
						txtErrorCode.setForeground(new java.awt.Color(0,0,0));
						txtErrorCode.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								txtErrorCodeMouseClicked(evt);
							}
						});
						txtErrorCode.addKeyListener(new KeyAdapter() {
							public void keyTyped(KeyEvent evt) {
								txtErrorCodeKeyTyped(evt);
							}
							public void keyReleased(KeyEvent evt) {
								txtErrorCodeKeyReleased(evt);
							}
							public void keyPressed(KeyEvent evt) {
								txtErrorCodeKeyPressed(evt);
							}
						});
						txtErrorCode.setFont(new java.awt.Font("Cambria",0,14));
					}
					{
						txtIssueLoggedOn = new JTextField();
						pnlE2EProblemDetails.add(txtIssueLoggedOn, "10, 6");
						txtIssueLoggedOn.setBackground(new java.awt.Color(232,248,255));
						txtIssueLoggedOn.setEditable(false);
						txtIssueLoggedOn.setForeground(new java.awt.Color(0,0,0));
						txtIssueLoggedOn.setFont(new java.awt.Font("Cambria",0,14));
					}
					{
						txtLastUpdatedOn = new JTextField();
						pnlE2EProblemDetails.add(txtLastUpdatedOn, "10, 2");
						txtLastUpdatedOn.setBackground(new java.awt.Color(232,248,255));
						txtLastUpdatedOn.setEditable(false);
						txtLastUpdatedOn.setForeground(new java.awt.Color(0,0,0));
						txtLastUpdatedOn.setFont(new java.awt.Font("Cambria",0,14));
					}
					{
						lblLockStatus = new JLabel();
						pnlE2EProblemDetails.add(lblLockStatus, "12, 0");
						lblLockStatus.setFont(new java.awt.Font("Cambria",1,14));
						lblLockStatus.setForeground(new java.awt.Color(0,0,64));
					}
					{
						chkbxEnableEditing = new JCheckBox();
						pnlE2EProblemDetails.add(chkbxEnableEditing, "12, 2");
						chkbxEnableEditing.setHorizontalAlignment(SwingConstants.CENTER);
						chkbxEnableEditing.addItemListener(new ItemListener() {
							public void itemStateChanged(ItemEvent evt) {
								chkbxEnableEditingItemStateChanged(evt);
							}
						});
						chkbxEnableEditing.setVisible(false);
						chkbxEnableEditing.setText("Enable Editing");
						chkbxEnableEditing.setFont(new java.awt.Font("Cambria",1,14));
						chkbxEnableEditing.setForeground(new java.awt.Color(64,0,64));
						chkbxEnableEditing.setEnabled(false);
					}
					{
						chkbxLogNewProblem = new JCheckBox();
						pnlE2EProblemDetails.add(chkbxLogNewProblem, "12, 4");
						chkbxLogNewProblem.setHorizontalAlignment(SwingConstants.CENTER);
						chkbxLogNewProblem.addItemListener(new ItemListener() {
							public void itemStateChanged(ItemEvent evt) {
								chkbxLogNewProblemItemStateChanged(evt);
							}
						});
						chkbxLogNewProblem.setVisible(false);
						chkbxLogNewProblem.setText("New Problem");
						chkbxLogNewProblem.setFont(new java.awt.Font("Cambria",1,14));
						chkbxLogNewProblem.setForeground(new java.awt.Color(64,0,64));
						chkbxLogNewProblem.setEnabled(false);
					}
					{
						btnInsert = new JButton();
						pnlE2EProblemDetails.add(btnInsert, "12, 6");
						btnInsert.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								btnInsertActionPerformed(evt);
							}
						});
						btnInsert.setVisible(false);
						btnInsert.setText("Insert");
						btnInsert.setEnabled(false);
						btnInsert.setFont(new java.awt.Font("Cambria",1,14));
						btnInsert.setForeground(new java.awt.Color(64,0,64));
					}
					{
						btnReset = new JButton();
						pnlE2EProblemDetails.add(btnReset, "12, 0");
						btnReset.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								btnResetActionPerformed(evt);
							}
						});
						btnReset.setText("Reset");
						btnReset.setForeground(new java.awt.Color(64,0,64));
						btnReset.setFont(new java.awt.Font("Cambria",1,14));
					}
				}
				{
					pnlDescriptionComments = new JPanel();
					TableLayout jPanel4Layout = new TableLayout(new double[][] {{TableLayout.FILL, 6.0, TableLayout.FILL, 10.0, TableLayout.FILL, 6.0, TableLayout.FILL}, {TableLayout.FILL, 6.0, TableLayout.FILL}});
					jPanel4Layout.setHGap(5);
					jPanel4Layout.setVGap(5);
					pnlDescriptionComments.setLayout(jPanel4Layout);
					pnlContainer.add(pnlDescriptionComments, "1, 5, 3, 11");
					pnlDescriptionComments.setBackground(new java.awt.Color(125,190,255));
					{
						scrpnErrorDescription = new JScrollPane();
						pnlDescriptionComments.add(scrpnErrorDescription, "0, 0");
						scrpnErrorDescription.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						scrpnErrorDescription.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
						scrpnErrorDescription.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(192,192,192), 2, true), "Error Description", TitledBorder.LEFT, TitledBorder.TOP, new java.awt.Font("Cambria",1,14), new java.awt.Color(0,0,64)));
						{
							txtarErrorDescription = new JTextArea();
							scrpnErrorDescription.setViewportView(txtarErrorDescription);
							txtarErrorDescription.setPreferredSize(new java.awt.Dimension(1000, 3000));
							txtarErrorDescription.setFont(new java.awt.Font("Cambria",0,14));
							txtarErrorDescription.setForeground(new java.awt.Color(0,0,160));
							txtarErrorDescription.addMouseListener(new MouseAdapter() {
								public void mouseClicked(MouseEvent evt) {
									txtarErrorDescriptionMouseClicked(evt);
								}
							});
							txtarErrorDescription.addKeyListener(new KeyAdapter() {
								public void keyTyped(KeyEvent evt) {
									txtarErrorDescriptionKeyTyped(evt);
								}
								public void keyReleased(KeyEvent evt) {
									txtarErrorDescriptionKeyReleased(evt);
								}
								public void keyPressed(KeyEvent evt) {
									txtarErrorDescriptionKeyPressed(evt);
								}
							});
							txtarErrorDescription.setEditable(false);
						}
					}
					{
						scrpnWorkaround = new JScrollPane();
						pnlDescriptionComments.add(scrpnWorkaround, "0, 2");
						scrpnWorkaround.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						scrpnWorkaround.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
						scrpnWorkaround.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(192,192,192), 2, true), "Workaround", TitledBorder.LEFT, TitledBorder.TOP, new java.awt.Font("Cambria",1,14), new java.awt.Color(0,0,64)));
						{
							txtarWorkaround = new JTextArea();
							scrpnWorkaround.setViewportView(txtarWorkaround);
							txtarWorkaround.setPreferredSize(new java.awt.Dimension(1000, 3000));
							txtarWorkaround.setFont(new java.awt.Font("Cambria",0,14));
							txtarWorkaround.setForeground(new java.awt.Color(0,0,160));
							txtarWorkaround.addMouseListener(new MouseAdapter() {
								public void mouseClicked(MouseEvent evt) {
									txtarWorkaroundMouseClicked(evt);
								}
							});
							txtarWorkaround.addKeyListener(new KeyAdapter() {
								public void keyTyped(KeyEvent evt) {
									txtarWorkaroundKeyTyped(evt);
								}
								public void keyReleased(KeyEvent evt) {
									txtarWorkaroundKeyReleased(evt);
								}
								public void keyPressed(KeyEvent evt) {
									txtarWorkaroundKeyPressed(evt);
								}
							});
							txtarWorkaround.setEditable(false);
						}
					}
					{
						scrpnComments = new JScrollPane();
						pnlDescriptionComments.add(scrpnComments, "4, 0, 4, 2");
						scrpnComments.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						scrpnComments.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
						scrpnComments.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(192,192,192), 2, true), "Comment", TitledBorder.LEFT, TitledBorder.TOP, new java.awt.Font("Cambria",1,14), new java.awt.Color(0,0,64)));
						{
							txtarComments = new JTextArea();
							scrpnComments.setViewportView(txtarComments);
							txtarComments.setPreferredSize(new java.awt.Dimension(1000, 3000));
							txtarComments.setFont(new java.awt.Font("Cambria",0,14));
							txtarComments.setForeground(new java.awt.Color(0,0,160));
							txtarComments.addMouseListener(new MouseAdapter() {
								public void mouseClicked(MouseEvent evt) {
									txtarCommentsMouseClicked(evt);
								}
							});
							txtarComments.addKeyListener(new KeyAdapter() {
								public void keyTyped(KeyEvent evt) {
									txtarCommentsKeyTyped(evt);
								}
								public void keyReleased(KeyEvent evt) {
									txtarCommentsKeyReleased(evt);
								}
								public void keyPressed(KeyEvent evt) {
									txtarCommentsKeyPressed(evt);
								}
							});
							txtarComments.setEditable(false);
						}
					}
					{
						scrpnActivityLogs = new JScrollPane();
						pnlDescriptionComments.add(scrpnActivityLogs, "6, 0, 6, 2");
						scrpnActivityLogs.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						scrpnActivityLogs.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
						scrpnActivityLogs.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(192,192,192), 2, true), "Activity Logs", TitledBorder.LEFT, TitledBorder.TOP, new java.awt.Font("Cambria",1,14), new java.awt.Color(0,0,64)));
						{
							txtarActivityLogs = new JTextArea();
							scrpnActivityLogs.setViewportView(txtarActivityLogs);
							txtarActivityLogs.setPreferredSize(new java.awt.Dimension(1000, 3000));
							txtarActivityLogs.setFont(new java.awt.Font("Cambria",0,14));
							txtarActivityLogs.setForeground(new java.awt.Color(0,0,160));
							txtarActivityLogs.setEditable(false);
						}
					}
					{
						scrpnProblemDescription = new JScrollPane();
						pnlDescriptionComments.add(scrpnProblemDescription, "2, 0, 2, 2");
						scrpnProblemDescription.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						scrpnProblemDescription.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
						scrpnProblemDescription.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(192,192,192), 2, true), "Problem Description", TitledBorder.LEFT, TitledBorder.TOP, new java.awt.Font("Cambria",1,14), new java.awt.Color(0,0,64)));
						{
							txtarProblemDescription = new JTextArea();
							scrpnProblemDescription.setViewportView(txtarProblemDescription);
							txtarProblemDescription.setText("Test");
							txtarProblemDescription.setEditable(false);
							txtarProblemDescription.setForeground(new java.awt.Color(0,0,160));
							txtarProblemDescription.addMouseListener(new MouseAdapter() {
								public void mouseClicked(MouseEvent evt) {
									txtarProblemDescriptionMouseClicked(evt);
								}
							});
							txtarProblemDescription.addKeyListener(new KeyAdapter() {
								public void keyTyped(KeyEvent evt) {
									txtarProblemDescriptionKeyTyped(evt);
								}
								public void keyReleased(KeyEvent evt) {
									txtarProblemDescriptionKeyReleased(evt);
								}
								public void keyPressed(KeyEvent evt) {
									txtarProblemDescriptionKeyPressed(evt);
								}
							});
						}
					}
				}
				{
					pnlHeader = new JPanel();
					TableLayout jPanel1Layout = new TableLayout(new double[][] {{10.0, TableLayout.FILL, 6.0, TableLayout.FILL, 6.0, TableLayout.FILL, 6.0, TableLayout.FILL, 6.0, 50.0, TableLayout.FILL, 3.0, TableLayout.FILL, TableLayout.FILL, 3.0, TableLayout.FILL, TableLayout.FILL, 15.0, 6.0, TableLayout.FILL, TableLayout.FILL, 15.0, 50.0, 6.0, TableLayout.FILL, 6.0, TableLayout.FILL, 6.0, TableLayout.FILL, 6.0}, {3.0, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, 3.0}});
					jPanel1Layout.setHGap(5);
					jPanel1Layout.setVGap(5);
					pnlHeader.setLayout(jPanel1Layout);
					pnlContainer.add(pnlHeader, "0, 0, 4, 0");
					pnlHeader.setBackground(new java.awt.Color(34,145,255));
					pnlHeader.setBorder(BorderFactory.createCompoundBorder(
							new LineBorder(new java.awt.Color(128,0,128), 1, false),
							new LineBorder(new java.awt.Color(0,253,253), 2, true)));
					{
						lblHeaderLeft = new JLabel();
						pnlHeader.add(lblHeaderLeft, "1, 1, 5, 7");
						lblHeaderLeft.setText("Problem Management");
						lblHeaderLeft.setHorizontalTextPosition(SwingConstants.LEFT);
						lblHeaderLeft.setHorizontalAlignment(SwingConstants.LEFT);
						lblHeaderLeft.setFont(new java.awt.Font("Belgacom Bold",0,28));
						lblHeaderLeft.setForeground(new java.awt.Color(176,230,255));
					}
					{
						lblHeader = new JLabel();
						pnlHeader.add(lblHeader, "7, 1, 22, 4");
						lblHeader.setText("Problem Overview (E2E)");
						lblHeader.setFont(new java.awt.Font("Baskerville Old Face",1,36));
						lblHeader.setForeground(new java.awt.Color(0,73,147));
						lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
						lblHeader.setHorizontalTextPosition(SwingConstants.CENTER);
						lblHeader.setBackground(new java.awt.Color(128,0,255));
					}
					{
						lblUserName = new JLabel();
						pnlHeader.add(lblUserName, "25, 1, 29, 3");
						lblUserName.setText("Welcome "+ this.objLoginBean.getFirstName());
						lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
						lblUserName.setFont(new java.awt.Font("Cambria",2,14));
						lblUserName.setForeground(new java.awt.Color(221,238,255));
						lblUserName.setHorizontalTextPosition(SwingConstants.CENTER);
					}
					{
						lblQCTDefectWindow = new JLabel();
						pnlHeader.add(lblQCTDefectWindow, "12, 5, 14, 7");
						lblQCTDefectWindow.setText("Defect Overview (QCT)");
						lblQCTDefectWindow.setHorizontalAlignment(SwingConstants.CENTER);
						lblQCTDefectWindow.setHorizontalTextPosition(SwingConstants.CENTER);
						lblQCTDefectWindow.setForeground(new java.awt.Color(206,255,255));
						lblQCTDefectWindow.setFont(new java.awt.Font("Cambria",0,16));
						lblQCTDefectWindow.addMouseListener(new MouseAdapter() {
							public void mouseExited(MouseEvent evt) {
								lblQCTDefectWindowMouseExited(evt);
							}
							public void mouseEntered(MouseEvent evt) {
								lblQCTDefectWindowMouseEntered(evt);
							}
							public void mouseClicked(MouseEvent evt) {
								lblQCTDefectWindowMouseClicked(evt);
							}
						});
					}
					{
						lblHPSMProblemOverview = new JLabel();
						pnlHeader.add(lblHPSMProblemOverview, "15, 5, 17, 7");
						lblHPSMProblemOverview.setText("Problem Overview (HPSM)");
						lblHPSMProblemOverview.setHorizontalAlignment(SwingConstants.CENTER);
						lblHPSMProblemOverview.setHorizontalTextPosition(SwingConstants.CENTER);
						lblHPSMProblemOverview.setForeground(new java.awt.Color(206,255,255));
						lblHPSMProblemOverview.setFont(new java.awt.Font("Cambria",0,16));
						lblHPSMProblemOverview.addMouseListener(new MouseAdapter() {
							public void mouseExited(MouseEvent evt) {
								lblHPSMProblemOverviewMouseExited(evt);
							}
							public void mouseEntered(MouseEvent evt) {
								lblHPSMProblemOverviewMouseEntered(evt);
							}
							public void mouseClicked(MouseEvent evt) {
								lblHPSMProblemOverviewMouseClicked(evt);
							}
						});
					}
					{
						lblHPSMIncidentOverview = new JLabel();
						pnlHeader.add(lblHPSMIncidentOverview, "19, 5, 21, 7");
						lblHPSMIncidentOverview.setText("Incident Overview (HPSM)");
						lblHPSMIncidentOverview.setHorizontalAlignment(SwingConstants.CENTER);
						lblHPSMIncidentOverview.setHorizontalTextPosition(SwingConstants.CENTER);
						lblHPSMIncidentOverview.setForeground(new java.awt.Color(206,255,255));
						lblHPSMIncidentOverview.setFont(new java.awt.Font("Cambria",0,16));
						lblHPSMIncidentOverview.addMouseListener(new MouseAdapter() {
							public void mouseExited(MouseEvent evt) {
								lblHPSMIncidentOverviewMouseExited(evt);
							}
							public void mouseEntered(MouseEvent evt) {
								lblHPSMIncidentOverviewMouseEntered(evt);
							}
							public void mouseClicked(MouseEvent evt) {
								lblHPSMIncidentOverviewMouseClicked(evt);
							}
						});
					}
					{
						lblDashboard = new JLabel();
						pnlHeader.add(lblDashboard, "9, 5, 10, 7");
						lblDashboard.setText("Go To Dashboard");
						lblDashboard.setHorizontalAlignment(SwingConstants.CENTER);
						lblDashboard.setHorizontalTextPosition(SwingConstants.CENTER);
						lblDashboard.setForeground(new java.awt.Color(206,255,255));
						lblDashboard.setFont(new java.awt.Font("Cambria",0,16));
						lblDashboard.addMouseListener(new MouseAdapter() {
							public void mouseExited(MouseEvent evt) {
								lblDashboardMouseExited(evt);
							}
							public void mouseEntered(MouseEvent evt) {
								lblDashboardMouseEntered(evt);
							}
							public void mouseClicked(MouseEvent evt) {
								lblDashboardMouseClicked(evt);
							}
						});
					}
					{
						ComboBoxModel<String> cmbbxUpdateExixtingProblemModel =
								new DefaultComboBoxModel<String>(
										this.objResourceProvider.convertListToArray(
												this.objProblemOverviewE2EBean.getExistingProblemList()));
								cmbbxUpdateExixtingProblem = new JComboBox<String>();
								pnlHeader.add(cmbbxUpdateExixtingProblem, "26, 4, 28, 7");
								cmbbxUpdateExixtingProblem.setFont(new java.awt.Font("Cambria",1,14));
								cmbbxUpdateExixtingProblem.setForeground(new java.awt.Color(0,0,160));
								cmbbxUpdateExixtingProblem.addItemListener(new ItemListener() {
									public void itemStateChanged(ItemEvent evt) {
										cmbbxUpdateExixtingProblemItemStateChanged(evt);
									}
								});
								cmbbxUpdateExixtingProblem.setModel(cmbbxUpdateExixtingProblemModel);
								this.adjustPopupWidth(cmbbxUpdateExixtingProblem);
					}
				}
			}
		}
		pack();
		this.setSize(1621, 860);
	}

	private final void adjustPopupWidth(JComboBox<String> box/*,FontMetrics metrics*/) {
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

	private void initBeanWithDefauleValues(boolean initAllBeanVariableFlag){
		try{
			if(initAllBeanVariableFlag){
				Connection objLocalConnection = this.objResourceProvider.getDatabaseConnection("E2ETracker");
				this.objProblemOverviewE2EManager.setExistingProblemIdList(objLocalConnection);
				this.objProblemOverviewE2EManager.setDefaultValueForApplicationName(objLocalConnection);
				this.objProblemOverviewE2EManager.setDefaultValueForProblemType(objLocalConnection);
				this.objProblemOverviewE2EManager.setDefaultValueForBusinessRisk(objLocalConnection);
				this.objProblemOverviewE2EManager.setDefaultValueForStatus(objLocalConnection);
				this.objProblemOverviewE2EManager.setDefaultValueForWorkBasket(objLocalConnection);
				this.objProblemOverviewE2EManager.setDefaultValueForDetectedIn(objLocalConnection);
				this.objResourceProvider.closeDatabaseConnection(objLocalConnection, false, true);
			}
			this.objProblemOverviewE2EBean.setSelectedProblem(
					this.objProblemOverviewE2EBean.getExistingProblemList().get(0));
			this.objProblemOverviewE2EBean.setTrackerId("");
			this.objProblemOverviewE2EBean.setSelectedValueProblemType(
					this.objProblemOverviewE2EBean.getDefaultListProblemType().get(0));
			this.objProblemOverviewE2EBean.setSelectedValueBusinessRisk(
					this.objProblemOverviewE2EBean.getDefaultListBusinessRisk().get(0));
			this.objProblemOverviewE2EBean.setSelectedValueDetectedIn(
					this.objProblemOverviewE2EBean.getDefaultListDetectedIn().get(0));
			this.objProblemOverviewE2EBean.setDefectId("");
			this.objProblemOverviewE2EBean.setIncidentId("");
			this.objProblemOverviewE2EBean.setProblemId("");
			this.objProblemOverviewE2EBean.setAssignedTo("");
			this.objProblemOverviewE2EBean.setSelectedValueStatus(
					this.objProblemOverviewE2EBean.getDefaultListStatus().get(0));
			this.objProblemOverviewE2EBean.setSelectedValueApplicationName(
					this.objProblemOverviewE2EBean.getDefaultListApplicationName().get(0));
			this.objProblemOverviewE2EBean.setSelectedValueSysRetError(
					this.objProblemOverviewE2EBean.getDefaultListApplicationName().get(0));
			this.objProblemOverviewE2EBean.setErrorCode("");
			this.objProblemOverviewE2EBean.setSelectedValueWorkBasket(
					this.objProblemOverviewE2EBean.getDefaultListWorkBasket().get(0));
			this.objProblemOverviewE2EBean.setLastUpdatedOn("");
			this.objProblemOverviewE2EBean.setIssueLoggedBy("");
			this.objProblemOverviewE2EBean.setIssueLoggedOn("");
			this.objProblemOverviewE2EBean.setErrorDescription("");
			this.objProblemOverviewE2EBean.setWorkaround("");
			this.objProblemOverviewE2EBean.setProblemDescription("");
			this.objProblemOverviewE2EBean.setComments("");
			this.objProblemOverviewE2EBean.setActivityLogs("");
			this.objProblemOverviewE2EBean.setEditFlag("");
			this.objProblemOverviewE2EBean.setLockedBy("");
		}catch(ManagerException eMan){
			this.managerExceptionHandling(eMan);
		}catch(Exception e){
			e.printStackTrace();
			this.otherExceptionHandling();
		}
	}

	protected void resetDefaultValueForComponent(boolean initBeanFlag){
		this.initBeanWithDefauleValues(initBeanFlag);
		this.txtTrackerId.setText(this.objProblemOverviewE2EBean.getTrackerId());
		this.txtTrackerId.setToolTipText(this.objProblemOverviewE2EBean.getTrackerId());
		txtTrackerId.setBackground(new java.awt.Color(232,248,255));
		txtTrackerId.setEditable(false);
		txtTrackerId.setFont(new java.awt.Font("Cambria",0,14));

		this.txtDefectId.setText(this.objProblemOverviewE2EBean.getDefectId());
		this.txtDefectId.setToolTipText(this.objProblemOverviewE2EBean.getDefectId());
		txtDefectId.setText("");
		txtDefectId.setBackground(new java.awt.Color(232,248,255));
		txtDefectId.setEditable(false);
		txtDefectId.setFont(new java.awt.Font("Cambria",0,14));


		this.txtProblemId.setText(this.objProblemOverviewE2EBean.getProblemId());
		this.txtProblemId.setToolTipText(this.objProblemOverviewE2EBean.getProblemId());
		txtProblemId.setBackground(new java.awt.Color(232,248,255));
		txtProblemId.setEditable(false);
		txtProblemId.setFont(new java.awt.Font("Cambria",0,14));

		this.txtIncidentId.setText(this.objProblemOverviewE2EBean.getIncidentId());
		this.txtIncidentId.setToolTipText(this.objProblemOverviewE2EBean.getIncidentId());
		txtIncidentId.setBackground(new java.awt.Color(232,248,255));
		txtIncidentId.setEditable(false);
		txtIncidentId.setFont(new java.awt.Font("Cambria",0,14));

		this.txtAssignedTo.setText(this.objProblemOverviewE2EBean.getAssignedTo());
		this.txtAssignedTo.setToolTipText(this.objProblemOverviewE2EBean.getAssignedTo());
		txtAssignedTo.setBackground(new java.awt.Color(232,248,255));
		txtAssignedTo.setEditable(false);
		txtAssignedTo.setFont(new java.awt.Font("Cambria",0,14));

		this.txtErrorCode.setText(this.objProblemOverviewE2EBean.getErrorCode());
		this.txtErrorCode.setToolTipText(this.objProblemOverviewE2EBean.getErrorCode());
		txtErrorCode.setBackground(new java.awt.Color(232,248,255));
		txtErrorCode.setEditable(false);
		txtErrorCode.setFont(new java.awt.Font("Cambria",0,14));

		this.txtLastUpdatedOn.setText(this.objProblemOverviewE2EBean.getLastUpdatedOn());
		this.txtLastUpdatedOn.setToolTipText(this.objProblemOverviewE2EBean.getLastUpdatedOn());
		txtLastUpdatedOn.setBackground(new java.awt.Color(232,248,255));
		txtLastUpdatedOn.setEditable(false);
		txtLastUpdatedOn.setFont(new java.awt.Font("Cambria",0,14));

		this.txtIssueLoggedBy.setText(this.objProblemOverviewE2EBean.getIssueLoggedBy());
		this.txtIssueLoggedBy.setToolTipText(this.objProblemOverviewE2EBean.getIssueLoggedBy());
		txtIssueLoggedBy.setEditable(false);
		txtIssueLoggedBy.setBackground(new java.awt.Color(232,248,255));
		txtIssueLoggedBy.setFont(new java.awt.Font("Cambria",0,14));

		this.txtIssueLoggedOn.setText(this.objProblemOverviewE2EBean.getIssueLoggedOn());
		this.txtIssueLoggedOn.setToolTipText(this.objProblemOverviewE2EBean.getIssueLoggedOn());
		txtIssueLoggedOn.setEditable(false);
		txtIssueLoggedOn.setBackground(new java.awt.Color(232,248,255));
		txtIssueLoggedOn.setFont(new java.awt.Font("Cambria",0,14));

		this.txtarErrorDescription.setText(this.objProblemOverviewE2EBean.getErrorDescription());
		txtarErrorDescription.setFont(new java.awt.Font("Cambria",0,14));
		txtarErrorDescription.setEditable(false);

		this.txtarWorkaround.setText(this.objProblemOverviewE2EBean.getWorkaround());
		txtarWorkaround.setFont(new java.awt.Font("Cambria",0,14));
		txtarWorkaround.setEditable(false);

		this.txtarComments.setText(this.objProblemOverviewE2EBean.getComments());
		txtarComments.setFont(new java.awt.Font("Cambria",0,14));
		txtarComments.setEditable(false);

		this.txtarActivityLogs.setText(this.objProblemOverviewE2EBean.getActivityLogs());
		txtarActivityLogs.setFont(new java.awt.Font("Cambria",0,14));
		txtarActivityLogs.setEditable(false);

		this.txtarProblemDescription.setText(this.objProblemOverviewE2EBean.getProblemDescription());
		txtarProblemDescription.setFont(new java.awt.Font("Cambria",0,14));
		txtarProblemDescription.setEditable(false);

		ComboBoxModel<String> defaultComboBoxModel = null;
		defaultComboBoxModel = new DefaultComboBoxModel<String>(
				this.objResourceProvider.convertListToArray(
						this.objProblemOverviewE2EBean.getDefaultListProblemType()));
		cmbbxProblemType.setModel(defaultComboBoxModel);
		this.adjustPopupWidth(this.cmbbxProblemType);

		defaultComboBoxModel = new DefaultComboBoxModel<String>(
				this.objResourceProvider.convertListToArray(
						this.objProblemOverviewE2EBean.getDefaultListStatus()));
		cmbbxStatus.setModel(defaultComboBoxModel);
		cmbbxStatus.setBackground(new java.awt.Color(79,198,255));
		this.adjustPopupWidth(this.cmbbxStatus);

		defaultComboBoxModel = new DefaultComboBoxModel<String>(
				this.objResourceProvider.convertListToArray(
						this.objProblemOverviewE2EBean.getDefaultListBusinessRisk()));
		cmbbxBusinessRisk.setModel(defaultComboBoxModel);
		this.adjustPopupWidth(this.cmbbxBusinessRisk);

		defaultComboBoxModel = new DefaultComboBoxModel<String>(
				this.objResourceProvider.convertListToArray(
						this.objProblemOverviewE2EBean.getDefaultListApplicationName()));
		cmbbxSysRetError.setModel(defaultComboBoxModel);
		this.adjustPopupWidth(this.cmbbxSysRetError);

		defaultComboBoxModel = new DefaultComboBoxModel<String>(
				this.objResourceProvider.convertListToArray(
						this.objProblemOverviewE2EBean.getDefaultListApplicationName()));
		cmbbxApplicationName.setModel(defaultComboBoxModel);
		this.adjustPopupWidth(this.cmbbxApplicationName);

		defaultComboBoxModel = new DefaultComboBoxModel<String>(
				this.objResourceProvider.convertListToArray(
						this.objProblemOverviewE2EBean.getDefaultListWorkBasket()));
		cmbbxWorkBasket.setModel(defaultComboBoxModel);
		this.adjustPopupWidth(this.cmbbxWorkBasket);

		defaultComboBoxModel = new DefaultComboBoxModel<String>(
				this.objResourceProvider.convertListToArray(
						this.objProblemOverviewE2EBean.getDefaultListDetectedIn()));
		cmbbxDetectedIn.setModel(defaultComboBoxModel);
		this.adjustPopupWidth(this.cmbbxDetectedIn);

		defaultComboBoxModel = new DefaultComboBoxModel<String>(this.objResourceProvider.convertListToArray(this.objProblemOverviewE2EBean.getExistingProblemList()));
		cmbbxUpdateExixtingProblem.setModel(defaultComboBoxModel);
		this.adjustPopupWidth(cmbbxUpdateExixtingProblem);

		chkbxEnableEditing.setText("Enable Editing");
		chkbxEnableEditing.setFont(new java.awt.Font("Cambria",1,14));
		chkbxEnableEditing.setForeground(new java.awt.Color(64,0,64));

		chkbxLogNewProblem.setText("New Problem");
		chkbxLogNewProblem.setFont(new java.awt.Font("Cambria",1,14));
		chkbxLogNewProblem.setForeground(new java.awt.Color(64,0,64));

		btnInsert.setText("Insert");
		btnInsert.setEnabled(false);
		btnInsert.setVisible(false);
		btnInsert.setFont(new java.awt.Font("Cambria",1,14));
		btnInsert.setForeground(new java.awt.Color(64,0,64));

		btnReset.setText("Reset");
		btnReset.setFont(new java.awt.Font("Cambria",1,14));
		btnReset.setForeground(new java.awt.Color(64,0,64));

		lblLockStatus.setFont(new java.awt.Font("Cambria",1,14));
		lblLockStatus.setForeground(new java.awt.Color(0,0,64));
		lblLockStatus.setVisible(false);

		this.enableFieldForEditing(false);
		this.applyProfileConstraint();
	}

	private void managerExceptionHandling(ManagerException eMan){
		if(this.objResourceProvider.compareString(eMan.getErrorType(), "I")){
            JOptionPane.showMessageDialog(this, eMan.getErrorMessage(), eMan.getErrorName(),JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, eMan.getErrorMessage(), eMan.getErrorName(), JOptionPane.ERROR_MESSAGE);
        }
	}

	private void otherExceptionHandling(){
		JOptionPane.showMessageDialog(this, "Something went wrong. Please contact System Administrator.", "Application Error", JOptionPane.ERROR_MESSAGE);
	}

	private void cmbbxUpdateExixtingProblemItemStateChanged(ItemEvent evt) {
		try{
			if(evt.getStateChange()== ItemEvent.SELECTED){
				String trackerId = (String)this.cmbbxUpdateExixtingProblem.getSelectedItem();
				this.objProblemOverviewE2EBean.setSelectedProblem(trackerId);
				if(trackerId.equalsIgnoreCase("--Select Problem--") || trackerId.equalsIgnoreCase("")){
					this.resetDefaultValueForComponent(false);
				}else{
					Connection objLocalConnection = this.objResourceProvider.getDatabaseConnection("E2ETracker");
					this.objProblemOverviewE2EManager.setBeanVariablesWithProblemDetails(objLocalConnection, trackerId);
					this.objResourceProvider.closeDatabaseConnection(objLocalConnection, false, true);
					this.chkbxEnableEditing.setSelected(false);
					this.chkbxLogNewProblem.setSelected(false);
					if(this.objProblemOverviewE2EBean.getEditFlag().equalsIgnoreCase("Y")){
						this.chkbxEnableEditing.setEnabled(true);
					}else{
						this.chkbxEnableEditing.setEnabled(false);
						String message = "Editing not allowed. Record is currently locked by "+this.objProblemOverviewE2EBean.getLockedBy()+".";
						JOptionPane.showMessageDialog(this, message, "Application Message", JOptionPane.INFORMATION_MESSAGE);
					}
					this.setComponentValueFromBean();
				}
			}
		}catch(ManagerException eMan){
			this.managerExceptionHandling(eMan);
		}catch(Exception e){
			e.printStackTrace();
			this.otherExceptionHandling();
		}
	}

	private void applyProfileConstraint(){
		if(this.objLoginBean.getAccessType().equalsIgnoreCase("O")){
			this.chkbxEnableEditing.setEnabled(false);
			this.chkbxEnableEditing.setVisible(false);
			this.chkbxLogNewProblem.setEnabled(false);
			this.chkbxLogNewProblem.setVisible(false);
			this.btnInsert.setEnabled(false);
		}else{
			this.chkbxEnableEditing.setEnabled(false);
			this.chkbxEnableEditing.setVisible(true);
			this.chkbxLogNewProblem.setEnabled(true);
			this.chkbxLogNewProblem.setVisible(true);
			this.btnInsert.setEnabled(true);
		}
	}

	private void setComponentValueFromBean(){
		this.txtTrackerId.setText(this.objProblemOverviewE2EBean.getTrackerId());
		this.txtTrackerId.setToolTipText(this.objProblemOverviewE2EBean.getTrackerId());
		this.cmbbxProblemType.setSelectedIndex(
				this.objResourceProvider.getIndexFromList(
						this.objProblemOverviewE2EBean.getDefaultListProblemType(),
						this.objProblemOverviewE2EBean.getSelectedValueProblemType()));
		this.cmbbxBusinessRisk.setSelectedIndex(
				this.objResourceProvider.getIndexFromList(
						this.objProblemOverviewE2EBean.getDefaultListBusinessRisk(),
						this.objProblemOverviewE2EBean.getSelectedValueBusinessRisk()));
		this.cmbbxDetectedIn.setSelectedIndex(
				this.objResourceProvider.getIndexFromList(
						this.objProblemOverviewE2EBean.getDefaultListDetectedIn(),
						this.objProblemOverviewE2EBean.getSelectedValueDetectedIn()));
		this.txtDefectId.setText(this.objProblemOverviewE2EBean.getDefectId());
		this.txtDefectId.setToolTipText(this.objProblemOverviewE2EBean.getDefectId());
		this.txtIncidentId.setText(this.objProblemOverviewE2EBean.getIncidentId());
		this.txtIncidentId.setToolTipText(this.objProblemOverviewE2EBean.getIncidentId());
		this.txtProblemId.setText(this.objProblemOverviewE2EBean.getProblemId());
		this.txtProblemId.setToolTipText(this.objProblemOverviewE2EBean.getProblemId());
		this.txtAssignedTo.setText(this.objProblemOverviewE2EBean.getAssignedTo());
		this.txtAssignedTo.setToolTipText(this.objProblemOverviewE2EBean.getAssignedTo());
		this.cmbbxStatus.setSelectedIndex(
				this.objResourceProvider.getIndexFromList(
						this.objProblemOverviewE2EBean.getDefaultListStatus(),
						this.objProblemOverviewE2EBean.getSelectedValueStatus()));
		this.cmbbxApplicationName.setSelectedIndex(
				this.objResourceProvider.getIndexFromList(
						this.objProblemOverviewE2EBean.getDefaultListApplicationName(),
						this.objProblemOverviewE2EBean.getSelectedValueApplicationName()));
		this.cmbbxSysRetError.setSelectedIndex(
				this.objResourceProvider.getIndexFromList(
						this.objProblemOverviewE2EBean.getDefaultListApplicationName(),
						this.objProblemOverviewE2EBean.getSelectedValueSysRetError()));
		this.txtErrorCode.setText(this.objProblemOverviewE2EBean.getErrorCode());
		this.txtErrorCode.setToolTipText(this.objProblemOverviewE2EBean.getErrorCode());
		this.cmbbxWorkBasket.setSelectedIndex(
				this.objResourceProvider.getIndexFromList(
						this.objProblemOverviewE2EBean.getDefaultListWorkBasket(),
						this.objProblemOverviewE2EBean.getSelectedValueWorkBasket()));
		this.txtLastUpdatedOn.setText(this.objProblemOverviewE2EBean.getLastUpdatedOn());
		this.txtLastUpdatedOn.setToolTipText(this.objProblemOverviewE2EBean.getLastUpdatedOn());
		this.txtIssueLoggedBy.setText(this.objProblemOverviewE2EBean.getIssueLoggedBy());
		this.txtIssueLoggedBy.setToolTipText(this.objProblemOverviewE2EBean.getIssueLoggedBy());
		this.txtIssueLoggedOn.setText(this.objProblemOverviewE2EBean.getIssueLoggedOn());
		this.txtIssueLoggedOn.setToolTipText(this.objProblemOverviewE2EBean.getIssueLoggedOn());
		this.txtarErrorDescription.setText(this.objProblemOverviewE2EBean.getErrorDescription());
		this.txtarWorkaround.setText(this.objProblemOverviewE2EBean.getWorkaround());
		this.txtarProblemDescription.setText(this.objProblemOverviewE2EBean.getProblemDescription());
		this.txtarComments.setText("");
		this.txtarActivityLogs.setText(this.objProblemOverviewE2EBean.getActivityLogs());
	}

	private void chkbxEnableEditingItemStateChanged(ItemEvent evt) {
		try{
			this.setComponentValueFromBean();
			String editFlag = null;
			String userId = null;
			if(this.chkbxEnableEditing.isSelected()){
				this.objDashboardWindow.setProblemWindowE2EFlag(true);
				this.cmbbxUpdateExixtingProblem.setEnabled(false);
				this.chkbxLogNewProblem.setEnabled(false);
				this.btnInsert.setText("Update");
				this.btnInsert.setVisible(true);
				this.btnInsert.setEnabled(true);
				this.enableFieldForEditing(true);
				editFlag = "N";
				userId = this.objLoginBean.getUserId();
			}else{
				this.objDashboardWindow.setProblemWindowE2EFlag(false);
				this.cmbbxUpdateExixtingProblem.setEnabled(true);
				this.chkbxLogNewProblem.setEnabled(true);
				this.btnInsert.setText("Insert");
				this.btnInsert.setVisible(false);
				this.btnInsert.setEnabled(false);
				this.enableFieldForEditing(false);
				editFlag = "Y";
				userId = null;
			}
			Connection objLocalConnection = this.objResourceProvider.getDatabaseConnection("E2ETracker");
			this.objProblemOverviewE2EManager.updateLockOnProblem(objLocalConnection, editFlag, userId, this.objProblemOverviewE2EBean.getSelectedProblem());
			this.objResourceProvider.closeDatabaseConnection(objLocalConnection, true, true);
		}catch(ManagerException eMan){
			this.managerExceptionHandling(eMan);
		}catch(Exception e){
			e.printStackTrace();
			this.otherExceptionHandling();
		}
	}

	private void chkbxLogNewProblemItemStateChanged(ItemEvent evt) {
		if(this.chkbxLogNewProblem.isSelected()){
			this.objDashboardWindow.setProblemWindowE2EFlag(true);
			this.resetDefaultValueForComponent(false);
			this.cmbbxUpdateExixtingProblem.setEnabled(false);
			this.enableFieldForEditing(true);
			this.btnInsert.setText("Insert");
			this.btnInsert.setVisible(true);
			this.btnInsert.setEnabled(true);
			Calendar calendar = Calendar.getInstance();
			java.util.Date currentDate = calendar.getTime();
			java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(currentDate.getTime());
			this.txtIssueLoggedOn.setText(currentTimestamp.toString());
			this.objProblemOverviewE2EBean.setIssueLoggedOn(currentTimestamp.toString());
			this.txtLastUpdatedOn.setText(currentTimestamp.toString());
			this.objProblemOverviewE2EBean.setLastUpdatedOn(currentTimestamp.toString());
			String currentUser = this.objLoginBean.getUserId() + "-" + this.objLoginBean.getFirstName() + " " + this.objLoginBean.getLastName();
			this.txtIssueLoggedBy.setText(currentUser);
			this.objProblemOverviewE2EBean.setIssueLoggedBy(currentUser);
		}else{
			this.objDashboardWindow.setProblemWindowE2EFlag(false);
			this.cmbbxUpdateExixtingProblem.setEnabled(true);
			this.enableFieldForEditing(false);
			this.btnInsert.setText("Insert");
			this.btnInsert.setVisible(false);
			this.btnInsert.setEnabled(false);
			this.txtTrackerId.setText("");
			this.objProblemOverviewE2EBean.setSelectedProblem("");
			this.txtIssueLoggedBy.setText("");
			this.objProblemOverviewE2EBean.setIssueLoggedBy("");
			this.txtIssueLoggedOn.setText("");
			this.objProblemOverviewE2EBean.setIssueLoggedOn("");
			this.txtLastUpdatedOn.setText("");
			this.objProblemOverviewE2EBean.setLastUpdatedOn("");
			this.txtAssignedTo.setText("");
			this.objProblemOverviewE2EBean.setAssignedTo("");
		}
	}

	private void enableFieldForEditing(boolean enableFlag){
		this.txtDefectId.setEditable(enableFlag);
		this.txtIncidentId.setEditable(enableFlag);
		this.txtProblemId.setEditable(enableFlag);
		this.txtErrorCode.setEditable(enableFlag);
		this.txtarErrorDescription.setEditable(enableFlag);
		this.txtarWorkaround.setEditable(enableFlag);
		this.txtarProblemDescription.setEditable(enableFlag);
		this.txtarComments.setEditable(enableFlag);
		if(enableFlag){
			this.txtDefectId.setToolTipText("Defect ID must contain only numbers.");
			this.txtIncidentId.setToolTipText("Incident ID must be in format IMxxxxxxx where 'x' represents digits.");
			this.txtProblemId.setToolTipText("Problem ID must be in format PMxxxxxx where 'x' represents digits.");
		}else{
			this.txtDefectId.setToolTipText("");
			this.txtIncidentId.setToolTipText("");
			this.txtProblemId.setToolTipText("");
		}
		this.saveRequiredFlag = false;
		this.defectIdFlag = true;
		this.incidentIfFlag = true;
		this.problemIdFlag = true;
	}

	private void cmbbxProblemTypeItemStateChanged(ItemEvent evt) {
		if(evt.getStateChange()== ItemEvent.SELECTED){
			String selectedValue = (String)this.cmbbxProblemType.getSelectedItem();
			this.captureChangeInField();
			this.objProblemOverviewE2EBean.setSelectedValueProblemType(selectedValue);
		}
	}

	private void cmbbxBusinessRiskItemStateChanged(ItemEvent evt) {
		if(evt.getStateChange()== ItemEvent.SELECTED){
			String selectedValue = (String)this.cmbbxBusinessRisk.getSelectedItem();
			this.captureChangeInField();
			this.objProblemOverviewE2EBean.setSelectedValueBusinessRisk(selectedValue);
		}
	}

	private void cmbbxDetectedInItemStateChanged(ItemEvent evt) {
		if(evt.getStateChange()== ItemEvent.SELECTED){
			String selectedValue = (String)this.cmbbxDetectedIn.getSelectedItem();
			this.captureChangeInField();
			this.objProblemOverviewE2EBean.setSelectedValueDetectedIn(selectedValue);
		}
	}

	private void cmbbxStatusItemStateChanged(ItemEvent evt) {
		if(evt.getStateChange()== ItemEvent.SELECTED){
			String selectedValue = (String)this.cmbbxStatus.getSelectedItem();
			this.captureChangeInField();
			this.objProblemOverviewE2EBean.setSelectedValueStatus(selectedValue);
		}
	}

	private void cmbbxApplicationNameItemStateChanged(ItemEvent evt) {
		if(evt.getStateChange()== ItemEvent.SELECTED){
			String selectedValue = (String)this.cmbbxApplicationName.getSelectedItem();
			this.captureChangeInField();
			this.objProblemOverviewE2EBean.setSelectedValueApplicationName(selectedValue);
		}
	}

	private void cmbbxSysRetErrorItemStateChanged(ItemEvent evt) {
		if(evt.getStateChange()== ItemEvent.SELECTED){
			String selectedValue = (String)this.cmbbxSysRetError.getSelectedItem();
			this.captureChangeInField();
			this.objProblemOverviewE2EBean.setSelectedValueSysRetError(selectedValue);
		}
	}

	private void cmbbxWorkBasketItemStateChanged(ItemEvent evt) {
		if(evt.getStateChange()== ItemEvent.SELECTED){
			String selectedValue = (String)this.cmbbxWorkBasket.getSelectedItem();
			this.captureChangeInField();
			this.objProblemOverviewE2EBean.setSelectedValueWorkBasket(selectedValue);
		}
	}

	private void txtDefectIdKeyPressed(KeyEvent evt) {
		this.captureChangeInField();
		this.textComponentDefectId(this.txtDefectId.getText());
	}

	private void txtIncidentIdKeyPressed(KeyEvent evt) {
		this.captureChangeInField();
		this.textComponentIncidentId(this.txtIncidentId.getText());
	}

	private void txtProblemIdKeyPressed(KeyEvent evt) {
		this.captureChangeInField();
		this.textComponentProblemId(this.txtProblemId.getText());
	}

	private void txtErrorCodeKeyPressed(KeyEvent evt) {
		this.captureChangeInField();
	}

	private void txtDefectIdKeyReleased(KeyEvent evt) {
		this.captureChangeInField();
		this.textComponentDefectId(this.txtDefectId.getText());
	}

	private void txtIncidentIdKeyReleased(KeyEvent evt) {
		this.captureChangeInField();
		this.textComponentIncidentId(this.txtIncidentId.getText());
	}

	private void txtProblemIdKeyReleased(KeyEvent evt) {
		this.captureChangeInField();
		this.textComponentProblemId(this.txtProblemId.getText());
	}

	private void txtErrorCodeKeyReleased(KeyEvent evt) {
		this.captureChangeInField();
	}

	private void txtDefectIdKeyTyped(KeyEvent evt) {
		this.captureChangeInField();
		this.textComponentDefectId(this.txtDefectId.getText());
	}

	private void txtIncidentIdKeyTyped(KeyEvent evt) {
		this.captureChangeInField();
		this.textComponentIncidentId(this.txtIncidentId.getText());
	}

	private void txtProblemIdKeyTyped(KeyEvent evt) {
		this.captureChangeInField();
		this.textComponentProblemId(this.txtProblemId.getText());
	}

	private void txtErrorCodeKeyTyped(KeyEvent evt) {
		this.captureChangeInField();
	}

	private void txtDefectIdMouseClicked(MouseEvent evt) {
		this.captureChangeInField();
		this.textComponentDefectId(this.txtDefectId.getText());
	}

	private void txtIncidentIdMouseClicked(MouseEvent evt) {
		this.captureChangeInField();
		this.textComponentIncidentId(this.txtIncidentId.getText());
	}

	private void txtProblemIdMouseClicked(MouseEvent evt) {
		this.captureChangeInField();
		this.textComponentProblemId(this.txtProblemId.getText());
	}

	private void txtErrorCodeMouseClicked(MouseEvent evt) {
		this.captureChangeInField();
	}

	private void txtarErrorDescriptionKeyPressed(KeyEvent evt) {
		this.captureChangeInField();
	}

	private void txtarWorkaroundKeyPressed(KeyEvent evt) {
		this.captureChangeInField();
	}

	private void txtarProblemDescriptionKeyPressed(KeyEvent evt) {
		this.captureChangeInField();
	}

	private void txtarCommentsKeyPressed(KeyEvent evt) {
		this.captureChangeInField();
	}

	private void txtarErrorDescriptionKeyReleased(KeyEvent evt) {
		this.captureChangeInField();
	}

	private void txtarWorkaroundKeyReleased(KeyEvent evt) {
		this.captureChangeInField();
	}

	private void txtarProblemDescriptionKeyReleased(KeyEvent evt) {
		this.captureChangeInField();
	}

	private void txtarCommentsKeyReleased(KeyEvent evt) {
		this.captureChangeInField();
	}

	private void txtarErrorDescriptionKeyTyped(KeyEvent evt) {
		this.captureChangeInField();
	}

	private void txtarWorkaroundKeyTyped(KeyEvent evt) {
		this.captureChangeInField();
	}

	private void txtarProblemDescriptionKeyTyped(KeyEvent evt) {
		this.captureChangeInField();
	}

	private void txtarCommentsKeyTyped(KeyEvent evt) {
		this.captureChangeInField();
	}

	private void txtarErrorDescriptionMouseClicked(MouseEvent evt) {
		this.captureChangeInField();
	}

	private void txtarWorkaroundMouseClicked(MouseEvent evt) {
		this.captureChangeInField();
	}

	private void txtarProblemDescriptionMouseClicked(MouseEvent evt) {
		this.captureChangeInField();
	}

	private void txtarCommentsMouseClicked(MouseEvent evt) {
		this.captureChangeInField();
	}

	private void txtDefectIdFocusLost(FocusEvent evt) {
		String defectId = this.txtDefectId.getText();
		try{
			if(this.objResourceProvider.verifyDefectId(defectId) && defectId.length() > 0){
				Connection objQCTConnection = this.objResourceProvider.getDatabaseConnection("QCT");
				Connection objLocalConnection = this.objResourceProvider.getDatabaseConnection("E2ETracker");
				List<String> databaseResult = this.objProblemOverviewE2EManager.getDefectDetails(objQCTConnection, defectId);
				this.objProblemOverviewE2EManager.updateCodeDetails(objLocalConnection, databaseResult);
				this.objResourceProvider.closeDatabaseConnection(objQCTConnection, false, true);
				this.objResourceProvider.closeDatabaseConnection(objLocalConnection, true, true);

				int index = this.objResourceProvider.getIndexFromList(
						this.objProblemOverviewE2EBean.getDefaultListProblemType(), "Defect");
				this.cmbbxProblemType.setSelectedIndex(index);
				//this.objProblemOverviewE2EBean.setSelectedValueProblemType(
						//this.objProblemOverviewE2EBean.getDefaultListProblemType().get(index));

				if(databaseResult.get(0).equalsIgnoreCase("V1")){
					if(databaseResult.get(2).equalsIgnoreCase("1-Low")){
						databaseResult.set(2, "3-Low impact");
					}else if(databaseResult.get(2).equalsIgnoreCase("2-Medium")){
						databaseResult.set(2, "2-Not blocking");
					}else if(databaseResult.get(2).equalsIgnoreCase("3-High")){
						databaseResult.set(2, "1-Blocking");
					}
				}

				index = this.objResourceProvider.getIndexFromList(
						this.objProblemOverviewE2EBean.getDefaultListBusinessRisk(), databaseResult.get(2));
				this.cmbbxBusinessRisk.setSelectedIndex(index);
				//this.objProblemOverviewE2EBean.setSelectedValueBusinessRisk(
						//this.objProblemOverviewE2EBean.getDefaultListBusinessRisk().get(index));

				ComboBoxModel<String> defaultComboBoxModel = null;
				defaultComboBoxModel = new DefaultComboBoxModel<String>(
						this.objResourceProvider.convertListToArray(
								this.objProblemOverviewE2EBean.getDefaultListDetectedIn()));
				this.cmbbxDetectedIn.setModel(defaultComboBoxModel);
				index = this.objResourceProvider.getIndexFromList(
						this.objProblemOverviewE2EBean.getDefaultListDetectedIn(), databaseResult.get(3));
				this.cmbbxDetectedIn.setSelectedIndex(index);
				//this.objProblemOverviewE2EBean.setSelectedValueDetectedIn(
						//this.objProblemOverviewE2EBean.getDefaultListDetectedIn().get(index));

				defaultComboBoxModel = new DefaultComboBoxModel<String>(
						this.objResourceProvider.convertListToArray(
								this.objProblemOverviewE2EBean.getDefaultListApplicationName()));
				this.cmbbxApplicationName.setModel(defaultComboBoxModel);
				index = this.objResourceProvider.getIndexFromList(
						this.objProblemOverviewE2EBean.getDefaultListApplicationName(), databaseResult.get(1));
				this.cmbbxApplicationName.setSelectedIndex(index);
				//this.objProblemOverviewE2EBean.setSelectedValueApplicationName(
						//this.objProblemOverviewE2EBean.getDefaultListApplicationName().get(index));

				this.cmbbxSysRetError.setModel(defaultComboBoxModel);
				this.cmbbxSysRetError.setSelectedIndex(index);
				//this.objProblemOverviewE2EBean.setSelectedValueSysRetError(
						//this.objProblemOverviewE2EBean.getDefaultListApplicationName().get(index));

				this.txtAssignedTo.setText(databaseResult.get(4));
				this.txtAssignedTo.setToolTipText(databaseResult.get(4));
				this.objProblemOverviewE2EBean.setAssignedTo(databaseResult.get(4));
			}
		}catch(ManagerException eMan){
			if(eMan.getErrorCode() == 1005){
				if (JOptionPane.showConfirmDialog(this, "Defect ID: " + defectId + " not found. Are you still want to continue?", "Application Warning",
				        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					this.cmbbxProblemType.setSelectedIndex(this.objResourceProvider.getIndexFromList(
							this.objProblemOverviewE2EBean.getDefaultListProblemType(), "Defect"));
				} else {
					this.txtDefectId.setText("");
					this.cmbbxProblemType.setSelectedIndex(0);
				}
			}else{
				this.managerExceptionHandling(eMan);
			}
		}catch(Exception e){
			e.printStackTrace();
			this.otherExceptionHandling();
		}
	}

	private void captureChangeInField(){
		if(this.chkbxEnableEditing.isSelected()){
			this.saveRequiredFlag = true;
		}
	}

	private void textComponentDefectId(String inputString){
		if(inputString.length() == 0){
			this.defectIdFlag = true;
			txtDefectId.setBackground(new java.awt.Color(232,248,255));
			txtDefectId.setForeground(new java.awt.Color(0,0,0));
		}else{
			if(this.objResourceProvider.verifyDefectId(inputString)){
				txtDefectId.setBackground(new java.awt.Color(232,248,255));
				txtDefectId.setForeground(new java.awt.Color(0,0,0));
				this.defectIdFlag = true;
			}else{
				txtDefectId.setBackground(new java.awt.Color(255,206,206));
				txtDefectId.setForeground(new java.awt.Color(255,0,0));
				this.defectIdFlag = false;
			}
		}
		this.updateEnable();
	}

	private void textComponentIncidentId(String inputString){
		if(inputString.length() == 0){
			this.incidentIfFlag = true;
			txtIncidentId.setBackground(new java.awt.Color(232,248,255));
			txtIncidentId.setForeground(new java.awt.Color(0,0,0));
		}else{
			if(this.objResourceProvider.verifyIncidentId(inputString)){
				txtIncidentId.setBackground(new java.awt.Color(232,248,255));
				txtIncidentId.setForeground(new java.awt.Color(0,0,0));
				this.incidentIfFlag = true;
			}else{
				txtIncidentId.setBackground(new java.awt.Color(255,206,206));
				txtIncidentId.setForeground(new java.awt.Color(255,0,0));
				this.incidentIfFlag = false;
			}
		}
		this.updateEnable();
	}

	private void textComponentProblemId(String inputString){
		if(inputString.length() == 0){
			this.problemIdFlag = true;
			txtProblemId.setBackground(new java.awt.Color(232,248,255));
			txtProblemId.setForeground(new java.awt.Color(0,0,0));
		}else{
			if(this.objResourceProvider.verifyPmId(inputString)){
				txtProblemId.setBackground(new java.awt.Color(232,248,255));
				txtProblemId.setForeground(new java.awt.Color(0,0,0));
				this.problemIdFlag = true;
			}else{
				txtProblemId.setBackground(new java.awt.Color(255,206,206));
				txtProblemId.setForeground(new java.awt.Color(255,0,0));
				this.problemIdFlag = false;
			}
		}
		this.updateEnable();
	}

	private void updateEnable(){
		if(this.defectIdFlag && this.incidentIfFlag && this.problemIdFlag){
			this.btnInsert.setEnabled(true);
			this.btnInsert.setForeground(new java.awt.Color(64,0,64));
		}else{
			this.btnInsert.setEnabled(false);
			this.btnInsert.setForeground(new java.awt.Color(128,128,128));
		}
	}

	private void btnInsertActionPerformed(ActionEvent evt) {
		this.objProblemOverviewE2EBean.setDefectId(this.txtDefectId.getText());
		this.objProblemOverviewE2EBean.setIncidentId(this.txtIncidentId.getText());
		this.objProblemOverviewE2EBean.setProblemId(this.txtProblemId.getText());
		this.objProblemOverviewE2EBean.setErrorCode(this.txtErrorCode.getText());
		this.objProblemOverviewE2EBean.setErrorDescription(this.txtarErrorDescription.getText());
		this.objProblemOverviewE2EBean.setWorkaround(this.txtarWorkaround.getText());
		this.objProblemOverviewE2EBean.setProblemDescription(this.txtarProblemDescription.getText());
		this.objProblemOverviewE2EBean.setComments(this.txtarComments.getText());
		if(this.chkbxEnableEditing.isSelected()){
			upsertProblemDetails(false);
		}else{
			upsertProblemDetails(true);
		}
	}

	private void upsertProblemDetails(boolean newFlag){
		try{
			Connection objLocalConnection = this.objResourceProvider.getDatabaseConnection("E2ETracker");
			String trackerId = this.objProblemOverviewE2EManager.upsertProblemDetails(objLocalConnection, this.objLoginBean.getUserId(), newFlag);
			this.objResourceProvider.closeDatabaseConnection(objLocalConnection, true, true);
			if(newFlag){
	            JOptionPane.showMessageDialog(this, "Problem:" + trackerId + " has been logged.", "Application Message",JOptionPane.INFORMATION_MESSAGE);
			}else{
	            JOptionPane.showMessageDialog(this, "Problem:" + trackerId + " has been updated successfully.", "Application Message",JOptionPane.INFORMATION_MESSAGE);
			}
            resetDefaultValueForComponent(true);
            this.cmbbxUpdateExixtingProblem.setSelectedIndex(this.objResourceProvider.getIndexFromList(this.objProblemOverviewE2EBean.getExistingProblemList(), trackerId));
            this.objProblemOverviewE2EBean.setSelectedProblem(trackerId);
		}catch(ManagerException eMan){
			this.managerExceptionHandling(eMan);
		}catch(Exception e){
			e.printStackTrace();
			this.otherExceptionHandling();
		}
	}

	private void btnResetActionPerformed(ActionEvent evt) {
		this.chkbxEnableEditing.setSelected(false);
		this.chkbxLogNewProblem.setSelected(false);
		this.resetDefaultValueForComponent(true);
	}

	private void lblDashboardMouseClicked(MouseEvent evt) {
		this.objDashboardWindow.setVisible(true);
		this.objDashboardWindow.setExtendedState(MAXIMIZED_BOTH);
		this.objDashboardWindow.resetDashboard();
	}

	private void lblQCTDefectWindowMouseClicked(MouseEvent evt) {
		try{
			this.objDashboardWindow.getObjDefectOverviewQCTWindow().setVisible(true);
			this.objDashboardWindow.getObjDefectOverviewQCTWindow().setExtendedState(MAXIMIZED_BOTH);
		}catch(NullPointerException eNull){
			DefectOverviewQCTWindow objDefectOverviewQCTWindow = new DefectOverviewQCTWindow(objDashboardWindow);
			objDefectOverviewQCTWindow.setVisible(true);
			objDefectOverviewQCTWindow.setExtendedState(MAXIMIZED_BOTH);
			this.objDashboardWindow.setObjDefectOverviewQCTWindow(objDefectOverviewQCTWindow);
		}

	}

	private void lblHPSMProblemOverviewMouseClicked(MouseEvent evt) {
		try{
			this.objDashboardWindow.getObjProblemOverviewHPSMWindow().setVisible(true);
			this.objDashboardWindow.getObjProblemOverviewHPSMWindow().setExtendedState(MAXIMIZED_BOTH);
		}catch(NullPointerException eNull){
			ProblemOverviewHPSMWindow objProblemOverviewHPSMWindow = new ProblemOverviewHPSMWindow(objDashboardWindow);
			objProblemOverviewHPSMWindow.setVisible(true);
			objProblemOverviewHPSMWindow.setExtendedState(MAXIMIZED_BOTH);
			this.objDashboardWindow.setObjProblemOverviewHPSMWindow(objProblemOverviewHPSMWindow);
		}
	}

	private void lblHPSMIncidentOverviewMouseClicked(MouseEvent evt) {
		try{
			this.objDashboardWindow.getObjIncidentOverviewHPSMWindow().setVisible(true);
			this.objDashboardWindow.getObjIncidentOverviewHPSMWindow().setExtendedState(MAXIMIZED_BOTH);
		}catch(NullPointerException eNull){
			IncidentOverviewHPSMWindow objIncidentOverviewHPSMWindow = new IncidentOverviewHPSMWindow(objDashboardWindow);
			objIncidentOverviewHPSMWindow.setVisible(true);
			objIncidentOverviewHPSMWindow.setExtendedState(MAXIMIZED_BOTH);
			this.objDashboardWindow.setObjIncidentOverviewHPSMWindow(objIncidentOverviewHPSMWindow);
		}
	}

	private void lblDashboardMouseEntered(MouseEvent evt) {
		lblDashboard.setForeground(new java.awt.Color(0,0,255));
		lblDashboard.setFont(new java.awt.Font("Cambria",2,16));
	}

	private void lblQCTDefectWindowMouseEntered(MouseEvent evt) {
		lblQCTDefectWindow.setForeground(new java.awt.Color(0,0,255));
		lblQCTDefectWindow.setFont(new java.awt.Font("Cambria",2,16));
	}

	private void lblHPSMProblemOverviewMouseEntered(MouseEvent evt) {
		lblHPSMProblemOverview.setForeground(new java.awt.Color(0,0,255));
		lblHPSMProblemOverview.setFont(new java.awt.Font("Cambria",2,16));
	}

	private void lblHPSMIncidentOverviewMouseEntered(MouseEvent evt) {
		lblHPSMIncidentOverview.setForeground(new java.awt.Color(0,0,255));
		lblHPSMIncidentOverview.setFont(new java.awt.Font("Cambria",2,16));
	}

	private void lblDashboardMouseExited(MouseEvent evt) {
		lblDashboard.setForeground(new java.awt.Color(206,255,255));
		lblDashboard.setFont(new java.awt.Font("Cambria",0,16));
	}

	private void lblQCTDefectWindowMouseExited(MouseEvent evt) {
		lblQCTDefectWindow.setForeground(new java.awt.Color(206,255,255));
		lblQCTDefectWindow.setFont(new java.awt.Font("Cambria",0,16));
	}

	private void lblHPSMProblemOverviewMouseExited(MouseEvent evt) {
		lblHPSMProblemOverview.setForeground(new java.awt.Color(206,255,255));
		lblHPSMProblemOverview.setFont(new java.awt.Font("Cambria",0,16));
	}

	private void lblHPSMIncidentOverviewMouseExited(MouseEvent evt) {
		lblHPSMIncidentOverview.setForeground(new java.awt.Color(206,255,255));
		lblHPSMIncidentOverview.setFont(new java.awt.Font("Cambria",0,16));
	}

	private void problemOverviewE2EWindowClosing(WindowEvent evt){
		this.problemOverviewE2EWindowClosingProcess(false);
	}

	protected void problemOverviewE2EWindowClosingProcess(boolean callFromDashboardWindow){
		if (this.chkbxEnableEditing.isSelected() || saveRequiredFlag){
			if (JOptionPane.showConfirmDialog(this, "Are you want to save changes before exit?", "Application Message",
			        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				if(this.defectIdFlag && this.incidentIfFlag && this.problemIdFlag){
					this.upsertProblemDetails(false);
					this.windowCloseWay(callFromDashboardWindow);
				}else{
					if(this.defectIdFlag == false){
			            JOptionPane.showMessageDialog(this, "Please provide valid Defect ID.", "Application Message",JOptionPane.INFORMATION_MESSAGE);
					}else if(this.incidentIfFlag == false){
			            JOptionPane.showMessageDialog(this, "Please provide valid Incident ID.", "Application Message",JOptionPane.INFORMATION_MESSAGE);
					}else{
			            JOptionPane.showMessageDialog(this, "Please provide valid Problem ID.", "Application Message",JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}else{
				this.chkbxEnableEditing.setSelected(false);
				this.chkbxLogNewProblem.setSelected(false);
				this.removedAllLock();
				this.windowCloseWay(callFromDashboardWindow);
			}
		}else{
			this.removedAllLock();
			this.windowCloseWay(callFromDashboardWindow);
		}
		this.objDashboardWindow.setProblemWindowE2EFlag(false);
	}

	private void removedAllLock(){
		try{
			Connection objLocalConnection = this.objResourceProvider.getDatabaseConnection("E2ETracker");
			this.objProblemOverviewE2EManager.removeAllLock(objLocalConnection, this.objLoginBean.getUserId());
		}catch(ManagerException eMan){
			this.managerExceptionHandling(eMan);
		}catch(Exception e){
			e.printStackTrace();
			this.otherExceptionHandling();
		}
	}

	private void windowCloseWay(boolean callFromDashboardWindow){
		if(callFromDashboardWindow){
			if(this.objDashboardWindow.getObjDefectOverviewQCTWindow()!= null){
				this.objDashboardWindow.getObjDefectOverviewQCTWindow().dispose();
			}

			if(this.objDashboardWindow.getObjProblemOverviewHPSMWindow() != null){
				this.objDashboardWindow.getObjProblemOverviewHPSMWindow().dispose();
			}

			if(this.objDashboardWindow.getObjIncidentOverviewHPSMWindow() != null){
				this.objDashboardWindow.getObjProblemOverviewHPSMWindow().dispose();
			}
			this.dispose();
			this.objDashboardWindow.dispose();
		}else{
			this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		}
	}

	protected final void setCmbbxUpdateExixtingProblem(String trackerId){
		if (this.chkbxEnableEditing.isSelected() || saveRequiredFlag){
			if (JOptionPane.showConfirmDialog(this, "Are you want to save changes before exit?", "Application Message",
			        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				this.upsertProblemDetails(false);
			}
		}
		this.chkbxEnableEditing.setSelected(false);
		this.chkbxLogNewProblem.setSelected(false);
		this.removedAllLock();
		this.cmbbxUpdateExixtingProblem.setSelectedIndex(this.objResourceProvider.getIndexFromList(
		this.objProblemOverviewE2EBean.getExistingProblemList(), trackerId));
	}


}
