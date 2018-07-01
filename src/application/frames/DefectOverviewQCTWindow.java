package application.frames;

import info.clearthought.layout.TableLayout;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import application.beans.DefectOverviewBean;
import application.beans.LoginBean;
import application.exceptions.ManagerException;
import application.manager.DefectDetailsQCTManager;


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
final class DefectOverviewQCTWindow extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	{
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JPanel pnlMain;
	private JTextField txtDefectId;
	private JLabel lblDefectId;
	private JLabel lblUserName;
	private JLabel lblHeader;
	private JPanel pnlHeader;
	private JLabel lblDetectedInRelease;
	private JLabel lblDetectedOnDate;
	private JTextField txtDetectedInVersion;
	private JTextField txtDetectedInTestStage;
	private JTextField txtDetectedInRelease;
	private JTextField txtEstimatedFixDate;
	private JEditorPane edtrpnComments;
	private JEditorPane edtrpnDescription;
	private JScrollPane scrpnComments;
	private JScrollPane scrpnDescription;
	private JPanel pnlDescriptionComments;
	private JButton btnSearchDefect;
	private JTextField txtSearch;
	private JTextField txtSummary;
	private JLabel lblSummary;
	private JLabel lblHeaderLeft;
	private JTextField txtDetectedBy;
	private JLabel lblEstimatedFixDate;
	private JTextField txtPriority;
	private JTextField txtProjectId;
	private JTextField txtDetectedOnDate;
	private JTextField txtProdBugFixDate;
	private JTextField txtBusinessRisk;
	private JTextField txtClosingDate;
	private JTextField txtAssignedTo;
	private JTextField txtEnvironment;
	private JTextField txtFlow;
	private JTextField txtStatus;
	private JTextField txtApplication;
	private JLabel lblStatus;
	private JLabel lblProjectId;
	private JLabel lblEnvironment;
	private JLabel lblFlow;
	private JLabel lblAssignedTo;
	private JLabel lblDetectedInVersion;
	private JLabel lblApplication;
	private JLabel lblProdBugFixDate;
	private JLabel lblDetectedBy;
	private JLabel lblDetectedInTestStage;
	private JLabel lblPriority;
	private JLabel lblClosingDate;
	private JLabel lblBusinessRisk;
	private JPanel pnlDefectDetails;
	private JPanel pnlContainer;
	private JLabel lblHPSMIncidentOverview;
	private JLabel lblDashboard;
	private JLabel lblE2EProblemOverview;
	private JLabel lblHPSMProblemOverview;
	private final ResourceProvider objResourceProvider;
	private final DashboardWindow objDashboardWindow;
	private final LoginBean objLoginBean;
	private final DefectOverviewBean objDefectOverviewBean;
	private final DefectDetailsQCTManager objDefectDetailsQCTManager;

 	public DefectOverviewQCTWindow(DashboardWindow objDashboardWindow) {
		super();
		this.objDashboardWindow = objDashboardWindow;
		this.objLoginBean = objDashboardWindow.getObjLoginBean();
		this.objResourceProvider = objDashboardWindow.getObjResourceProvider();
		this.objDefectOverviewBean = new DefectOverviewBean();
		this.objDefectDetailsQCTManager = new DefectDetailsQCTManager(this.objResourceProvider, this.objDefectOverviewBean);
		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("E2E Tracker - Defect Overview (QCT)");
		{
			pnlMain = new JPanel();
			getContentPane().add(pnlMain, BorderLayout.CENTER);
			pnlMain.setLayout(null);
			pnlMain.setPreferredSize(new java.awt.Dimension(1249, 822));
			pnlMain.setBackground(new java.awt.Color(125,190,255));
			{
				pnlContainer = new JPanel();
				TableLayout jPanel2Layout = new TableLayout(new double[][] {{3.0, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, 3.0}, {TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, 50.0, 10.0, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, 3.0}});
				jPanel2Layout.setHGap(5);
				jPanel2Layout.setVGap(5);
				pnlContainer.setLayout(jPanel2Layout);
				pnlMain.add(pnlContainer);
				pnlContainer.setBounds(0, 0, 1599, 822);
				pnlContainer.setBackground(new java.awt.Color(125,190,255));
				pnlContainer.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
				{
					pnlDefectDetails = new JPanel();
					TableLayout jPanel3Layout = new TableLayout(new double[][] {{146.0, 6.0, TableLayout.FILL, 10.0, 170.0, 6.0, TableLayout.FILL, 10.0, 137.0, 6.0, 288.0, 6.0, 191.0, 10.0, TableLayout.FILL}, {3.0, TableLayout.FILL, 6.0, TableLayout.FILL, 6.0, TableLayout.FILL, 6.0, TableLayout.FILL, 6.0, TableLayout.FILL}});
					jPanel3Layout.setHGap(5);
					jPanel3Layout.setVGap(5);
					pnlDefectDetails.setLayout(jPanel3Layout);
					pnlContainer.add(pnlDefectDetails, "1, 1, 3, 3");
					pnlDefectDetails.setBackground(new java.awt.Color(125,190,255));
					{
						lblBusinessRisk = new JLabel();
						pnlDefectDetails.add(lblBusinessRisk, "0, 9");
						lblBusinessRisk.setText("Business Risk");
						lblBusinessRisk.setFont(new java.awt.Font("Cambria",1,16));
						lblBusinessRisk.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblDetectedInRelease = new JLabel();
						pnlDefectDetails.add(lblDetectedInRelease, "4, 5");
						lblDetectedInRelease.setText("Detected in Release");
						lblDetectedInRelease.setFont(new java.awt.Font("Cambria",1,16));
						lblDetectedInRelease.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblDetectedOnDate = new JLabel();
						pnlDefectDetails.add(lblDetectedOnDate, "12, 3");
						lblDetectedOnDate.setText("Detected on Date");
						lblDetectedOnDate.setFont(new java.awt.Font("Cambria",1,16));
						lblDetectedOnDate.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblClosingDate = new JLabel();
						pnlDefectDetails.add(lblClosingDate, "12, 9");
						lblClosingDate.setText("Closing Date");
						lblClosingDate.setFont(new java.awt.Font("Cambria",1,16));
						lblClosingDate.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblPriority = new JLabel();
						pnlDefectDetails.add(lblPriority, "0, 7");
						lblPriority.setText("Priority");
						lblPriority.setFont(new java.awt.Font("Cambria",1,16));
						lblPriority.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblDetectedInTestStage = new JLabel();
						pnlDefectDetails.add(lblDetectedInTestStage, "4, 7");
						lblDetectedInTestStage.setText("Detected in Test Stage");
						lblDetectedInTestStage.setFont(new java.awt.Font("Cambria",1,16));
						lblDetectedInTestStage.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblDetectedBy = new JLabel();
						pnlDefectDetails.add(lblDetectedBy, "8, 5");
						lblDetectedBy.setText("Detected By");
						lblDetectedBy.setFont(new java.awt.Font("Cambria",1,16));
						lblDetectedBy.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblProdBugFixDate = new JLabel();
						pnlDefectDetails.add(lblProdBugFixDate, "12, 7");
						lblProdBugFixDate.setText("Production Bug Fix Date");
						lblProdBugFixDate.setFont(new java.awt.Font("Cambria",1,16));
						lblProdBugFixDate.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblApplication = new JLabel();
						pnlDefectDetails.add(lblApplication, "0, 3");
						lblApplication.setText("Application");
						lblApplication.setFont(new java.awt.Font("Cambria",1,16));
						lblApplication.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblDetectedInVersion = new JLabel();
						pnlDefectDetails.add(lblDetectedInVersion, "4, 9");
						lblDetectedInVersion.setText("Detected in Version");
						lblDetectedInVersion.setFont(new java.awt.Font("Cambria",1,16));
						lblDetectedInVersion.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblAssignedTo = new JLabel();
						pnlDefectDetails.add(lblAssignedTo, "8, 7");
						lblAssignedTo.setText("Assigned To");
						lblAssignedTo.setFont(new java.awt.Font("Cambria",1,16));
						lblAssignedTo.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblFlow = new JLabel();
						pnlDefectDetails.add(lblFlow, "8, 3");
						lblFlow.setText("Flow");
						lblFlow.setFont(new java.awt.Font("Cambria",1,16));
						lblFlow.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblEnvironment = new JLabel();
						pnlDefectDetails.add(lblEnvironment, "0, 5");
						lblEnvironment.setText("Environment");
						lblEnvironment.setFont(new java.awt.Font("Cambria",1,16));
						lblEnvironment.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblProjectId = new JLabel();
						pnlDefectDetails.add(lblProjectId, "4, 3");
						lblProjectId.setText("Project ID");
						lblProjectId.setFont(new java.awt.Font("Cambria",1,16));
						lblProjectId.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblStatus = new JLabel();
						pnlDefectDetails.add(lblStatus, "8, 9");
						lblStatus.setText("Status");
						lblStatus.setFont(new java.awt.Font("Cambria",1,16));
						lblStatus.setForeground(new java.awt.Color(64,0,64));
					}
					{
						txtApplication = new JTextField();
						pnlDefectDetails.add(txtApplication, "2, 3");
						txtApplication.setFont(new java.awt.Font("Cambria",0,14));
						txtApplication.setForeground(new java.awt.Color(0,0,64));
						txtApplication.setEditable(false);
						txtApplication.setBackground(new java.awt.Color(242,255,255));
						txtApplication.setDropMode(javax.swing.DropMode.USE_SELECTION);
					}
					{
						txtStatus = new JTextField();
						pnlDefectDetails.add(txtStatus, "10, 9");
						txtStatus.setFont(new java.awt.Font("Cambria",0,14));
						txtStatus.setForeground(new java.awt.Color(0,0,64));
						txtStatus.setEditable(false);
						txtStatus.setBackground(new java.awt.Color(242,255,255));
						txtStatus.setDropMode(javax.swing.DropMode.USE_SELECTION);
					}
					{
						txtFlow = new JTextField();
						pnlDefectDetails.add(txtFlow, "10, 3");
						txtFlow.setFont(new java.awt.Font("Cambria",0,14));
						txtFlow.setForeground(new java.awt.Color(0,0,64));
						txtFlow.setEditable(false);
						txtFlow.setBackground(new java.awt.Color(242,255,255));
						txtFlow.setDropMode(javax.swing.DropMode.USE_SELECTION);
					}
					{
						txtEnvironment = new JTextField();
						pnlDefectDetails.add(txtEnvironment, "2, 5");
						txtEnvironment.setFont(new java.awt.Font("Cambria",0,14));
						txtEnvironment.setForeground(new java.awt.Color(0,0,64));
						txtEnvironment.setEditable(false);
						txtEnvironment.setBackground(new java.awt.Color(242,255,255));
						txtEnvironment.setDropMode(javax.swing.DropMode.USE_SELECTION);
					}
					{
						txtBusinessRisk = new JTextField();
						pnlDefectDetails.add(txtBusinessRisk, "2, 9");
						txtBusinessRisk.setEditable(false);
						txtBusinessRisk.setBackground(new java.awt.Color(242,255,255));
						txtBusinessRisk.setForeground(new java.awt.Color(0,0,64));
						txtBusinessRisk.setFont(new java.awt.Font("Cambria",0,14));
						txtBusinessRisk.setDropMode(javax.swing.DropMode.USE_SELECTION);
					}
					{
						txtProdBugFixDate = new JTextField();
						pnlDefectDetails.add(txtProdBugFixDate, "14, 7");
						txtProdBugFixDate.setFont(new java.awt.Font("Cambria",0,14));
						txtProdBugFixDate.setForeground(new java.awt.Color(0,0,64));
						txtProdBugFixDate.setEditable(false);
						txtProdBugFixDate.setBackground(new java.awt.Color(242,255,255));
						txtProdBugFixDate.setDropMode(javax.swing.DropMode.USE_SELECTION);
					}
					{
						txtDetectedOnDate = new JTextField();
						pnlDefectDetails.add(txtDetectedOnDate, "14, 3");
						txtDetectedOnDate.setFont(new java.awt.Font("Cambria",0,14));
						txtDetectedOnDate.setEditable(false);
						txtDetectedOnDate.setBackground(new java.awt.Color(242,255,255));
						txtDetectedOnDate.setForeground(new java.awt.Color(0,0,64));
						txtDetectedOnDate.setDropMode(javax.swing.DropMode.USE_SELECTION);
					}
					{
						txtProjectId = new JTextField();
						pnlDefectDetails.add(txtProjectId, "6, 3");
						txtProjectId.setFont(new java.awt.Font("Cambria",0,14));
						txtProjectId.setEditable(false);
						txtProjectId.setBackground(new java.awt.Color(242,255,255));
						txtProjectId.setForeground(new java.awt.Color(0,0,64));
						txtProjectId.setDropMode(javax.swing.DropMode.USE_SELECTION);
					}
					{
						txtPriority = new JTextField();
						pnlDefectDetails.add(txtPriority, "2, 7");
						txtPriority.setFont(new java.awt.Font("Cambria",0,14));
						txtPriority.setForeground(new java.awt.Color(0,0,64));
						txtPriority.setEditable(false);
						txtPriority.setBackground(new java.awt.Color(242,255,255));
						txtPriority.setDropMode(javax.swing.DropMode.USE_SELECTION);
					}
					{
						lblEstimatedFixDate = new JLabel();
						pnlDefectDetails.add(lblEstimatedFixDate, "12, 5");
						lblEstimatedFixDate.setText("Estimated Fix Date");
						lblEstimatedFixDate.setFont(new java.awt.Font("Cambria",1,16));
						lblEstimatedFixDate.setForeground(new java.awt.Color(64,0,64));
					}
					{
						txtDetectedBy = new JTextField();
						pnlDefectDetails.add(txtDetectedBy, "10, 5");
						txtDetectedBy.setFont(new java.awt.Font("Cambria",0,14));
						txtDetectedBy.setForeground(new java.awt.Color(0,0,64));
						txtDetectedBy.setEditable(false);
						txtDetectedBy.setBackground(new java.awt.Color(242,255,255));
						txtDetectedBy.setDropMode(javax.swing.DropMode.USE_SELECTION);
					}
					{
						lblSummary = new JLabel();
						pnlDefectDetails.add(lblSummary, "4, 1");
						lblSummary.setText("Summary");
						lblSummary.setFont(new java.awt.Font("Cambria",1,16));
						lblSummary.setForeground(new java.awt.Color(64,0,64));
					}
					{
						txtSummary = new JTextField();
						pnlDefectDetails.add(txtSummary, "6, 1, 14, 1");
						txtSummary.setFont(new java.awt.Font("Cambria",0,14));
						txtSummary.setForeground(new java.awt.Color(0,0,64));
						txtSummary.setEditable(false);
						txtSummary.setBackground(new java.awt.Color(242,255,255));
						txtSummary.setDropMode(javax.swing.DropMode.USE_SELECTION);
					}
					{
						txtAssignedTo = new JTextField();
						pnlDefectDetails.add(txtAssignedTo, "10, 7");
						txtAssignedTo.setEditable(false);
						txtAssignedTo.setBackground(new java.awt.Color(242,255,255));
						txtAssignedTo.setForeground(new java.awt.Color(0,0,64));
						txtAssignedTo.setFont(new java.awt.Font("Cambria",0,14));
						txtAssignedTo.setDropMode(javax.swing.DropMode.USE_SELECTION);
					}
					{
						txtClosingDate = new JTextField();
						pnlDefectDetails.add(txtClosingDate, "14, 9");
						txtClosingDate.setEditable(false);
						txtClosingDate.setBackground(new java.awt.Color(242,255,255));
						txtClosingDate.setForeground(new java.awt.Color(0,0,64));
						txtClosingDate.setFont(new java.awt.Font("Cambria",0,14));
						txtClosingDate.setDropMode(javax.swing.DropMode.USE_SELECTION);
					}
					{
						txtEstimatedFixDate = new JTextField();
						pnlDefectDetails.add(txtEstimatedFixDate, "14, 5");
						txtEstimatedFixDate.setEditable(false);
						txtEstimatedFixDate.setBackground(new java.awt.Color(242,255,255));
						txtEstimatedFixDate.setForeground(new java.awt.Color(0,0,64));
						txtEstimatedFixDate.setFont(new java.awt.Font("Cambria",0,14));
						txtEstimatedFixDate.setDropMode(javax.swing.DropMode.USE_SELECTION);
					}
					{
						txtDetectedInRelease = new JTextField();
						pnlDefectDetails.add(txtDetectedInRelease, "6, 5");
						txtDetectedInRelease.setEditable(false);
						txtDetectedInRelease.setBackground(new java.awt.Color(242,255,255));
						txtDetectedInRelease.setForeground(new java.awt.Color(0,0,64));
						txtDetectedInRelease.setFont(new java.awt.Font("Cambria",0,14));
						txtDetectedInRelease.setDropMode(javax.swing.DropMode.USE_SELECTION);
					}
					{
						txtDetectedInTestStage = new JTextField();
						pnlDefectDetails.add(txtDetectedInTestStage, "6, 7");
						txtDetectedInTestStage.setEditable(false);
						txtDetectedInTestStage.setBackground(new java.awt.Color(242,255,255));
						txtDetectedInTestStage.setForeground(new java.awt.Color(0,0,64));
						txtDetectedInTestStage.setFont(new java.awt.Font("Cambria",0,14));
						txtDetectedInTestStage.setDropMode(javax.swing.DropMode.USE_SELECTION);
					}
					{
						txtDetectedInVersion = new JTextField();
						pnlDefectDetails.add(txtDetectedInVersion, "6, 9");
						txtDetectedInVersion.setEditable(false);
						txtDetectedInVersion.setBackground(new java.awt.Color(242,255,255));
						txtDetectedInVersion.setForeground(new java.awt.Color(0,0,64));
						txtDetectedInVersion.setFont(new java.awt.Font("Cambria",0,14));
						txtDetectedInVersion.setDropMode(javax.swing.DropMode.USE_SELECTION);
					}
					{
						lblDefectId = new JLabel();
						pnlDefectDetails.add(lblDefectId, "0, 1");
						lblDefectId.setText("Defect ID");
						lblDefectId.setFont(new java.awt.Font("Cambria",1,16));
						lblDefectId.setForeground(new java.awt.Color(64,0,64));
					}
					{
						txtDefectId = new JTextField();
						pnlDefectDetails.add(txtDefectId, "2, 1");
						txtDefectId.setEditable(false);
						txtDefectId.setBackground(new java.awt.Color(242,255,255));
						txtDefectId.setForeground(new java.awt.Color(0,0,64));
						txtDefectId.setFont(new java.awt.Font("Cambria",0,14));
						txtDefectId.setDropMode(javax.swing.DropMode.USE_SELECTION);
					}
				}
				{
					pnlDescriptionComments = new JPanel();
					TableLayout jPanel4Layout = new TableLayout(new double[][] {{TableLayout.FILL, TableLayout.FILL, 10.0, TableLayout.FILL, TableLayout.FILL}, {TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL}});
					jPanel4Layout.setHGap(5);
					jPanel4Layout.setVGap(5);
					pnlDescriptionComments.setLayout(jPanel4Layout);
					pnlContainer.add(pnlDescriptionComments, "1, 5, 3, 9");
					pnlDescriptionComments.setBackground(new java.awt.Color(125,190,255));
					{
						scrpnDescription = new JScrollPane();
						pnlDescriptionComments.add(scrpnDescription, "0, 0, 1, 4");
						scrpnDescription.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
						scrpnDescription.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						scrpnDescription.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(192,192,192), 2, true), "Description", TitledBorder.LEADING, TitledBorder.TOP, new java.awt.Font("Cambria",1,16), new java.awt.Color(64,0,64)));
						scrpnDescription.setBackground(new java.awt.Color(117,186,255));
						{
							edtrpnDescription = new JEditorPane();
							scrpnDescription.setViewportView(edtrpnDescription);
							edtrpnDescription.setPreferredSize(new java.awt.Dimension(5000, 5000));
							edtrpnDescription.setEditable(false);
							edtrpnDescription.setBackground(new java.awt.Color(240,255,255));
							edtrpnDescription.setContentType("text/html");
							edtrpnDescription.setFont(new java.awt.Font("Cambria",0,14));
						}
					}
					{
						scrpnComments = new JScrollPane();
						pnlDescriptionComments.add(scrpnComments, "3, 0, 4, 4");
						scrpnComments.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						scrpnComments.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
						scrpnComments.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(192,192,192), 2, true), "Dev Comments", TitledBorder.LEADING, TitledBorder.TOP, new java.awt.Font("Cambria",1,16), new java.awt.Color(64,0,64)));
						scrpnComments.setBackground(new java.awt.Color(117,186,255));
						{
							edtrpnComments = new JEditorPane();
							scrpnComments.setViewportView(edtrpnComments);
							edtrpnComments.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
							edtrpnComments.setFont(lblApplication.getFont());
							edtrpnComments.setPreferredSize(new java.awt.Dimension(5000, 500));
							edtrpnComments.setEditable(false);
							edtrpnComments.setBackground(new java.awt.Color(240,255,255));
							edtrpnComments.setContentType("text/html");
							edtrpnComments.setFont(new java.awt.Font("Cambria",0,18));
						}
					}
				}
				{
					pnlHeader = new JPanel();
					TableLayout jPanel1Layout = new TableLayout(new double[][] {{10.0, TableLayout.FILL, TableLayout.FILL, 62.0, TableLayout.FILL, TableLayout.FILL, 15.0, 6.0, TableLayout.FILL, 50.0, 15.0, 6.0, TableLayout.FILL, 50.0, 15.0, 15.0, 6.0, TableLayout.FILL, 50.0, 15.0, 15.0, TableLayout.FILL, TableLayout.FILL, 6.0, TableLayout.FILL, 6.0}, {3.0, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, 3.0}});
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
						pnlHeader.add(lblHeaderLeft, "1, 1, 3, 6");
						lblHeaderLeft.setText("Problem Management");
						lblHeaderLeft.setHorizontalTextPosition(SwingConstants.CENTER);
						lblHeaderLeft.setHorizontalAlignment(SwingConstants.CENTER);
						lblHeaderLeft.setFont(new java.awt.Font("Belgacom Bold",0,28));
						lblHeaderLeft.setForeground(new java.awt.Color(176,230,255));
					}
					{
						txtSearch = new JTextField();
						pnlHeader.add(txtSearch, "22, 4, 22, 6");
						txtSearch.setHorizontalAlignment(SwingConstants.CENTER);
						txtSearch.setText("Search");
						txtSearch.setFont(new java.awt.Font("Cambria",2,14));
						txtSearch.setForeground(new java.awt.Color(192,192,192));
						txtSearch.setBackground(new java.awt.Color(242,255,255));
						txtSearch.addFocusListener(new FocusAdapter() {
							public void focusLost(FocusEvent evt) {
								txtSearchFocusLost(evt);
							}
						});
						txtSearch.addKeyListener(new KeyAdapter() {
							public void keyPressed(KeyEvent evt) {
								txtSearchKeyPressed(evt);
							}
							public void keyReleased(KeyEvent evt) {
								txtSearchKeyReleased(evt);
							}
							public void keyTyped(KeyEvent evt) {
								txtSearchKeyTyped(evt);
							}
						});
						txtSearch.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								txtSearchMouseClicked(evt);
							}
						});
					}
					{
						btnSearchDefect = new JButton();
						pnlHeader.add(btnSearchDefect, "24, 4, 24, 6");
						btnSearchDefect.setText("Search");
						btnSearchDefect.setFont(new java.awt.Font("Cambria",1,16));
						btnSearchDefect.setHorizontalTextPosition(SwingConstants.CENTER);
						btnSearchDefect.setEnabled(false);
						btnSearchDefect.setForeground(new java.awt.Color(192,192,192));
						btnSearchDefect.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								btnSearchDefectActionPerformed(evt);
							}
						});
					}
					{
						lblHeader = new JLabel();
						pnlHeader.add(lblHeader, "4, 1, 20, 4");
						lblHeader.setText("Defect Overview (QCT)");
						lblHeader.setFont(new java.awt.Font("Baskerville Old Face",1,36));
						lblHeader.setForeground(new java.awt.Color(0,73,147));
						lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
						lblHeader.setHorizontalTextPosition(SwingConstants.CENTER);
						lblHeader.setBackground(new java.awt.Color(128,0,255));
					}
					{
						lblUserName = new JLabel();
						pnlHeader.add(lblUserName, "22, 1, 24, 2");
						lblUserName.setText("Welcome "+ this.objLoginBean.getFirstName());
						lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
						lblUserName.setFont(new java.awt.Font("Cambria",2,16));
						lblUserName.setForeground(new java.awt.Color(221,238,255));
						lblUserName.setHorizontalTextPosition(SwingConstants.CENTER);
					}
					{
						lblHPSMProblemOverview = new JLabel();
						pnlHeader.add(lblHPSMProblemOverview, "12, 5, 15, 6");
						lblHPSMProblemOverview.setText("Problem Overview (HPSM)");
						lblHPSMProblemOverview.setHorizontalTextPosition(SwingConstants.CENTER);
						lblHPSMProblemOverview.setHorizontalAlignment(SwingConstants.CENTER);
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
						lblE2EProblemOverview = new JLabel();
						pnlHeader.add(lblE2EProblemOverview, "8, 5, 10, 6");
						lblE2EProblemOverview.setText("Problem Overview (E2E)");
						lblE2EProblemOverview.setHorizontalTextPosition(SwingConstants.CENTER);
						lblE2EProblemOverview.setHorizontalAlignment(SwingConstants.CENTER);
						lblE2EProblemOverview.setForeground(new java.awt.Color(206,255,255));
						lblE2EProblemOverview.setFont(new java.awt.Font("Cambria",0,16));
						lblE2EProblemOverview.addMouseListener(new MouseAdapter() {
							public void mouseExited(MouseEvent evt) {
								lblE2EProblemOverviewMouseExited(evt);
							}
							public void mouseEntered(MouseEvent evt) {
								lblE2EProblemOverviewMouseEntered(evt);
							}
							public void mouseClicked(MouseEvent evt) {
								lblE2EProblemOverviewMouseClicked(evt);
							}
						});
					}
					{
						lblDashboard = new JLabel();
						pnlHeader.add(lblDashboard, "5, 5, 6, 6");
						lblDashboard.setText("Go To Dashboard");
						lblDashboard.setHorizontalTextPosition(SwingConstants.CENTER);
						lblDashboard.setHorizontalAlignment(SwingConstants.RIGHT);
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
						lblHPSMIncidentOverview = new JLabel();
						pnlHeader.add(lblHPSMIncidentOverview, "17, 5, 20, 6");
						lblHPSMIncidentOverview.setText("Incident Overview (HPSM)");
						lblHPSMIncidentOverview.setHorizontalTextPosition(SwingConstants.CENTER);
						lblHPSMIncidentOverview.setHorizontalAlignment(SwingConstants.CENTER);
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
				}
			}
		}
		pack();
		this.setSize(1621, 860);
	}

	private void btnSearchDefectActionPerformed(ActionEvent evt) {
		try{
			this.prepareDefectOverviewWindow(this.txtSearch.getText());
		}catch(ManagerException eMan){
			this.handleManagerExceptio(eMan);
		}catch(Exception eAll){
			this.handleException(eAll);
		}
	}

	private void txtSearchKeyTyped(KeyEvent evt) {
		if(this.objResourceProvider.compareString(this.txtSearch.getText(), "Search")){
			this.setSearchField("Editing");
		}else{
			if(this.objResourceProvider.verifyIncidentId(this.txtSearch.getText())){
				this.setSearchField("Correct Input");
			}else{
				this.setSearchField("Incorrect Input");
			}
		}
	}

	private void txtSearchKeyPressed(KeyEvent evt) {
		this.checkSearchInput();
	}

	private void txtSearchKeyReleased(KeyEvent evt) {
		this.checkSearchInput();
	}

	private void txtSearchMouseClicked(MouseEvent evt) {
		if(this.objResourceProvider.compareString(this.txtSearch.getText(), "Search")){
			this.setSearchField("Editing");
		}
	}

	private void txtSearchFocusLost(FocusEvent evt) {
		if(this.objResourceProvider.compareString(this.txtSearch.getText(), "")){
			this.setSearchField("Initial");
		}
	}

	private void setSearchField(String stage){
		if(this.objResourceProvider.compareString(stage, "Editing")){
			this.txtSearch.setText("");
			this.txtSearch.setBackground(new java.awt.Color(242,255,255));
			this.txtSearch.setForeground(new java.awt.Color(0,0,64));
			this.txtSearch.setFont(new java.awt.Font("Cambria",0,14));
			this.btnSearchDefect.setEnabled(false);
			this.btnSearchDefect.setForeground(new java.awt.Color(192,192,192));
		}else if(this.objResourceProvider.compareString(stage, "Initial")){
			this.txtSearch.setText("Search");
			this.txtSearch.setFont(new java.awt.Font("Cambria",2,14));
			this.txtSearch.setForeground(new java.awt.Color(192,192,192));
			this.txtSearch.setBackground(new java.awt.Color(242,255,255));
			this.btnSearchDefect.setEnabled(false);
			this.btnSearchDefect.setForeground(new java.awt.Color(192,192,192));
		}else if(this.objResourceProvider.compareString(stage, "Correct Input")){
			this.txtSearch.setFont(new java.awt.Font("Cambria",0,14));
			this.txtSearch.setForeground(new java.awt.Color(0,0,64));
			this.txtSearch.setBackground(new java.awt.Color(210,255,210));
			this.btnSearchDefect.setEnabled(true);
			this.btnSearchDefect.setForeground(new java.awt.Color(64,0,64));
		}else if(this.objResourceProvider.compareString(stage, "Incorrect Input")){
			this.txtSearch.setFont(new java.awt.Font("Cambria",0,14));
			this.txtSearch.setForeground(new java.awt.Color(255,0,0));
			this.txtSearch.setBackground(new java.awt.Color(255,206,206));
			this.btnSearchDefect.setEnabled(false);
			this.btnSearchDefect.setForeground(new java.awt.Color(192,192,192));
		}
	}

	protected void prepareDefectOverviewWindow(String defectId) throws ManagerException{
		if(this.objResourceProvider.verifyDefectId(defectId)){
			Connection objQCTConnection = this.objResourceProvider.getDatabaseConnection("QCT");
			this.objDefectDetailsQCTManager.actionSearch(objQCTConnection, defectId);
			this.objResourceProvider.closeDatabaseConnection(objQCTConnection, false, true);
			this.setComponentValues();
		}else{
			throw new ManagerException(1000, "E", "Application Message", "Invalid Defect ID.");
		}
	}

	private void setComponentValues(){
		if(objDefectOverviewBean.isE2EDefect()){
			this.changeInterfaceForE2E();
		}else{
			this.changeInterfaceForV1();
		}
		this.setSearchField("Initial");

		this.txtDefectId.setText(objDefectOverviewBean.getDefectId());
		this.txtDefectId.setToolTipText(objDefectOverviewBean.getDefectId());

		this.txtSummary.setText(objDefectOverviewBean.getSummary());
		this.txtSummary.setToolTipText(objDefectOverviewBean.getSummary());

		this.txtApplication.setText(objDefectOverviewBean.getApplication());
		this.txtApplication.setToolTipText(objDefectOverviewBean.getApplication());

		this.txtEnvironment.setText(objDefectOverviewBean.getEnvironment());
		this.txtEnvironment.setToolTipText(objDefectOverviewBean.getEnvironment());

		this.txtPriority.setText(objDefectOverviewBean.getPriority());
		this.txtPriority.setToolTipText(objDefectOverviewBean.getPriority());

		this.txtBusinessRisk.setText(objDefectOverviewBean.getBusinessRisk());
		this.txtBusinessRisk.setToolTipText(objDefectOverviewBean.getBusinessRisk());

		this.txtProjectId.setText(objDefectOverviewBean.getProjectId());
		this.txtProjectId.setToolTipText(objDefectOverviewBean.getProjectId());

		this.txtDetectedInRelease.setText(objDefectOverviewBean.getDetectedInRelease());
		this.txtDetectedInRelease.setToolTipText(objDefectOverviewBean.getDetectedInRelease());

		this.txtDetectedInTestStage.setText(objDefectOverviewBean.getDetectedInTestStage());
		this.txtDetectedInTestStage.setToolTipText(objDefectOverviewBean.getDetectedInTestStage());

		this.txtDetectedInVersion.setText(objDefectOverviewBean.getDetectedInVersion());
		this.txtDetectedInVersion.setToolTipText(objDefectOverviewBean.getDetectedInVersion());

		this.txtFlow.setText(objDefectOverviewBean.getFlow());
		this.txtFlow.setToolTipText(objDefectOverviewBean.getFlow());

		this.txtDetectedBy.setText(objDefectOverviewBean.getDetectedBy());
		this.txtDetectedBy.setToolTipText(objDefectOverviewBean.getDetectedBy());

		this.txtAssignedTo.setText(objDefectOverviewBean.getAssignedTo());
		this.txtAssignedTo.setToolTipText(objDefectOverviewBean.getAssignedTo());

		this.txtStatus.setText(objDefectOverviewBean.getStatus());
		this.txtStatus.setToolTipText(objDefectOverviewBean.getStatus());

		this.txtDetectedOnDate.setText(objDefectOverviewBean.getDetectedOnDate());
		this.txtDetectedOnDate.setToolTipText(objDefectOverviewBean.getDetectedOnDate());

		this.txtEstimatedFixDate.setText(objDefectOverviewBean.getEstimatedFixDate());
		this.txtEstimatedFixDate.setToolTipText(objDefectOverviewBean.getEstimatedFixDate());

		this.txtProdBugFixDate.setText(objDefectOverviewBean.getProdBugFixDate());
		this.txtProdBugFixDate.setToolTipText(objDefectOverviewBean.getProdBugFixDate());

		this.txtClosingDate.setText(objDefectOverviewBean.getClosingDate());
		this.txtClosingDate.setToolTipText(objDefectOverviewBean.getClosingDate());

		this.edtrpnDescription.setText(objDefectOverviewBean.getDescription());
		this.edtrpnComments.setText(objDefectOverviewBean.getComments());
	}

	private void resetComponentValues(){
		this.setSearchField("Initial");
		this.changeInterfaceForE2E();

		this.txtDefectId.setText("");
		this.txtDefectId.setToolTipText("");

		this.txtSummary.setText("");
		this.txtSummary.setToolTipText("");

		this.txtApplication.setText("");
		this.txtApplication.setToolTipText("");

		this.txtEnvironment.setText("");
		this.txtEnvironment.setToolTipText("");

		this.txtPriority.setText("");
		this.txtPriority.setToolTipText("");

		this.txtBusinessRisk.setText("");
		this.txtBusinessRisk.setToolTipText("");

		this.txtProjectId.setText("");
		this.txtProjectId.setToolTipText("");

		this.txtDetectedInRelease.setText("");
		this.txtDetectedInRelease.setToolTipText("");

		this.txtDetectedInTestStage.setText("");
		this.txtDetectedInTestStage.setToolTipText("");

		this.txtDetectedInVersion.setText("");
		this.txtDetectedInVersion.setToolTipText("");

		this.txtFlow.setText("");
		this.txtFlow.setToolTipText("");

		this.txtDetectedBy.setText("");
		this.txtDetectedBy.setToolTipText("");

		this.txtAssignedTo.setText("");
		this.txtAssignedTo.setToolTipText("");

		this.txtStatus.setText("");
		this.txtStatus.setToolTipText("");

		this.txtDetectedOnDate.setText("");
		this.txtDetectedOnDate.setToolTipText("");

		this.txtEstimatedFixDate.setText("");
		this.txtEstimatedFixDate.setToolTipText("");

		this.txtProdBugFixDate.setText("");
		this.txtProdBugFixDate.setToolTipText("");

		this.txtClosingDate.setText("");
		this.txtClosingDate.setToolTipText("");

		this.edtrpnDescription.setText("");
		this.edtrpnComments.setText("");
	}

	private void changeInterfaceForV1(){
		this.lblBusinessRisk.setText("Severity"); //Change Business Risk to Severity
		this.lblProjectId.setText("Investigation Priority"); //Change Project Id to Investigation Priority
		this.lblDetectedInRelease.setText("Project"); //Change Detected in Release to Project
		this.lblDetectedInTestStage.setText("Pilot Impact"); //Change Detected in Test Stage to Pilot Impact
		this.lblFlow.setText("Workaround"); //Change Flow to Workaround
		this.lblProdBugFixDate.setText("Modified");  //Change Prod Bug Fix Date to Modified
	}

	private void changeInterfaceForE2E(){
		this.lblBusinessRisk.setText("Business Risk"); //Change Business Risk to Severity
		this.lblProjectId.setText("Project ID"); //Change Project Id to Investigation Priority
		this.lblDetectedInRelease.setText("Detected in Release"); //Change Detected in Release to Project
		this.lblDetectedInTestStage.setText("Detected in Test Stage"); //Change Detected in Test Stage to Pilot Impact
		this.lblFlow.setText("Flow"); //Change Flow to Workaround
		this.lblProdBugFixDate.setText("Production Bug Fix Date");  //Change Prod Bug Fix Date to Modified
	}

	private void handleManagerExceptio(ManagerException eMan){
		if(eMan.getErrorType().equalsIgnoreCase("I")){
            JOptionPane.showMessageDialog(this, eMan.getErrorMessage(), eMan.getErrorName(),JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, eMan.getErrorMessage(), eMan.getErrorName(), JOptionPane.ERROR_MESSAGE);
        }
		this.setSearchField("Initial");
	}

	private void handleException(Exception eAll){
		JOptionPane.showMessageDialog(this, "Something went wrong. Please contact System Administrator.", "Application Error", JOptionPane.ERROR_MESSAGE);
		this.resetComponentValues();
	}

	private void checkSearchInput(){
		if(this.objResourceProvider.compareString(this.txtSearch.getText(), "Search") || this.objResourceProvider.compareString(this.txtSearch.getText(), "")){
			this.setSearchField("Initial");
		}else{
			if(this.objResourceProvider.verifyDefectId(this.txtSearch.getText())){
				this.setSearchField("Correct Input");
			}else{
				this.setSearchField("Incorrect Input");
			}
		}
	}

	private void lblE2EProblemOverviewMouseClicked(MouseEvent evt) {
		try{
			this.objDashboardWindow.getObjProblemOverviewE2EWindow().setVisible(true);
			this.objDashboardWindow.getObjProblemOverviewE2EWindow().setExtendedState(MAXIMIZED_BOTH);
		}catch(NullPointerException eNull){
			ProblemOverviewE2EWindow objProblemOverviewE2EWindow = new ProblemOverviewE2EWindow(objDashboardWindow);
			objProblemOverviewE2EWindow.setVisible(true);
			objProblemOverviewE2EWindow.setExtendedState(MAXIMIZED_BOTH);
			this.objDashboardWindow.setObjProblemOverviewE2EWindow(objProblemOverviewE2EWindow);
		}
	}

	private void lblHPSMIncidentOverviewMouseClicked(MouseEvent evt) {
		try{
			this.objDashboardWindow.getObjIncidentOverviewHPSMWindow().setVisible(true);
			this.objDashboardWindow.getObjIncidentOverviewHPSMWindow().setExtendedState(MAXIMIZED_BOTH);
		}catch(NullPointerException eNull){
			IncidentOverviewHPSMWindow objIncidentOverviewHPSMWindow= new IncidentOverviewHPSMWindow(objDashboardWindow);
			objIncidentOverviewHPSMWindow.setVisible(true);
			objIncidentOverviewHPSMWindow.setExtendedState(MAXIMIZED_BOTH);
			this.objDashboardWindow.setObjIncidentOverviewHPSMWindow(objIncidentOverviewHPSMWindow);
		}
	}

	private void lblDashboardMouseClicked(MouseEvent evt) {
			this.objDashboardWindow.setVisible(true);
			this.objDashboardWindow.setExtendedState(MAXIMIZED_BOTH);
			this.objDashboardWindow.resetDashboard();
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

	private void lblE2EProblemOverviewMouseEntered(MouseEvent evt) {
		lblE2EProblemOverview.setForeground(new java.awt.Color(0,0,255));
		lblE2EProblemOverview.setFont(new java.awt.Font("Cambria",2,16));
	}

	private void lblHPSMIncidentOverviewMouseEntered(MouseEvent evt) {
		lblHPSMIncidentOverview.setForeground(new java.awt.Color(0,0,255));
		lblHPSMIncidentOverview.setFont(new java.awt.Font("Cambria",2,16));
	}

	private void lblDashboardMouseEntered(MouseEvent evt) {
		lblDashboard.setForeground(new java.awt.Color(0,0,255));
		lblDashboard.setFont(new java.awt.Font("Cambria",2,16));
	}

	private void lblHPSMProblemOverviewMouseEntered(MouseEvent evt) {
		lblHPSMProblemOverview.setForeground(new java.awt.Color(0,0,255));
		lblHPSMProblemOverview.setFont(new java.awt.Font("Cambria",2,16));
	}

	private void lblE2EProblemOverviewMouseExited(MouseEvent evt) {
		lblE2EProblemOverview.setForeground(new java.awt.Color(206,255,255));
		lblE2EProblemOverview.setFont(new java.awt.Font("Cambria",0,16));
	}

	private void lblHPSMIncidentOverviewMouseExited(MouseEvent evt) {
		lblHPSMIncidentOverview.setForeground(new java.awt.Color(206,255,255));
		lblHPSMIncidentOverview.setFont(new java.awt.Font("Cambria",0,16));
	}

	private void lblDashboardMouseExited(MouseEvent evt) {
		lblDashboard.setForeground(new java.awt.Color(206,255,255));
		lblDashboard.setFont(new java.awt.Font("Cambria",0,16));
	}

	private void lblHPSMProblemOverviewMouseExited(MouseEvent evt) {
		lblHPSMProblemOverview.setForeground(new java.awt.Color(206,255,255));
		lblHPSMProblemOverview.setFont(new java.awt.Font("Cambria",0,16));
	}

}
