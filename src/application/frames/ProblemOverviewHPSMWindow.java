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

import application.beans.LoginBean;
import application.beans.ProblemOverviewHPSMBean;
import application.exceptions.ManagerException;
import application.manager.ProblemOverviewHPSMManager;


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
final class ProblemOverviewHPSMWindow extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	{
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private JPanel pnlMain;
	private JEditorPane edtrpnJournalUpdate;
	private JScrollPane scrpnJournalUpdate;
	private JEditorPane edtrpnWorkaround;
	private JScrollPane scrpnWorkaround;
	private JEditorPane edtrpnResolution;
	private JScrollPane scrpnResolution;
	private JTextField txtProblemId;
	private JLabel lblProblemId;
	private JLabel lblUserName;
	private JLabel lblHeader;
	private JPanel pnlHeader;
	private JLabel lblTicketOwner;
	private JEditorPane edtrpnRootCause;
	private JEditorPane edtrpnDescription;
	private JScrollPane scrpnRootCause;
	private JScrollPane scrpnDescription;
	private JPanel pnlDescriptionComments;
	private JButton btnSearch;
	private JTextField txtSearch;
	private JTextField txtTitle;
	private JLabel lblTitle;
	private JLabel lblHeaderLeft;
	private JTextField txtOpenedBy;
	private JTextField txtTicketOwner;
	private JTextField txtOpenTime;
	private JTextField txtStatus;
	private JTextField txtAssignmentGroup;
	private JLabel lblStatus;
	private JLabel lblOpenTime;
	private JLabel lblOpenedBy;
	private JLabel lblAssignmentGroup;
	private JPanel pnlDefectDetails;
	private JPanel pnlContainer;
	private JLabel lblHPSMIncidentOverview;
	private JLabel lblDashboard;
	private JLabel lblQCTDefectOverview;
	private JLabel lblE2EProblemOverview;
	private final DashboardWindow objDashboardWindow;
	private final ResourceProvider objResourceProvider;
	private final LoginBean objLoginBean;
	private final ProblemOverviewHPSMBean objProblemOverviewHPSMBean;
	private final ProblemOverviewHPSMManager objProblemOverviewHPSMManager;

 	public ProblemOverviewHPSMWindow(DashboardWindow objDashboardWindow) {
		super();
		this.objDashboardWindow = objDashboardWindow;
		this.objLoginBean = objDashboardWindow.getObjLoginBean();
		this.objResourceProvider = objDashboardWindow.getObjResourceProvider();
		this.objProblemOverviewHPSMBean = new ProblemOverviewHPSMBean();
		this.objProblemOverviewHPSMManager = new ProblemOverviewHPSMManager(this.objResourceProvider, objProblemOverviewHPSMBean);
		initGUI();
		this.setVisible(false);
	}

	private void initGUI() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("E2E Tracker - Problem Overview (HPSM)");
		{
			pnlMain = new JPanel();
			getContentPane().add(pnlMain, BorderLayout.CENTER);
			pnlMain.setLayout(null);
			pnlMain.setPreferredSize(new java.awt.Dimension(1249, 822));
			pnlMain.setBackground(new java.awt.Color(125,190,255));
			{
				pnlContainer = new JPanel();
				TableLayout jPanel2Layout = new TableLayout(new double[][] {{3.0, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, 3.0}, {3.0, TableLayout.FILL, 102.0, 6.0, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, 3.0}});
				jPanel2Layout.setHGap(5);
				jPanel2Layout.setVGap(5);
				pnlContainer.setLayout(jPanel2Layout);
				pnlMain.add(pnlContainer);
				pnlContainer.setBounds(0, -6, 1599, 822);
				pnlContainer.setBackground(new java.awt.Color(125,190,255));
				pnlContainer.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
				{
					pnlDefectDetails = new JPanel();
					TableLayout jPanel3Layout = new TableLayout(new double[][] {{146.0, 6.0, TableLayout.FILL, 6.0, 87.0, 6.0, TableLayout.FILL, 6.0, 102.0, 6.0, TableLayout.FILL, 6.0, 113.0, 6.0, TableLayout.FILL, 6.0, 60.0, 6.0, TableLayout.FILL}, {3.0, TableLayout.FILL, 6.0, TableLayout.FILL, 6.0}});
					jPanel3Layout.setHGap(5);
					jPanel3Layout.setVGap(5);
					pnlDefectDetails.setLayout(jPanel3Layout);
					pnlContainer.add(pnlDefectDetails, "1, 2, 3, 2");
					pnlDefectDetails.setBackground(new java.awt.Color(125,190,255));
					{
						lblTicketOwner = new JLabel();
						pnlDefectDetails.add(lblTicketOwner, "12, 3");
						lblTicketOwner.setText("Ticket Owner");
						lblTicketOwner.setFont(new java.awt.Font("Cambria",1,16));
						lblTicketOwner.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblAssignmentGroup = new JLabel();
						pnlDefectDetails.add(lblAssignmentGroup, "0, 3");
						lblAssignmentGroup.setText("Assignment Group");
						lblAssignmentGroup.setFont(new java.awt.Font("Cambria",1,16));
						lblAssignmentGroup.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblOpenedBy = new JLabel();
						pnlDefectDetails.add(lblOpenedBy, "4, 3");
						lblOpenedBy.setText("Opened By");
						lblOpenedBy.setFont(new java.awt.Font("Cambria",1,16));
						lblOpenedBy.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblOpenTime = new JLabel();
						pnlDefectDetails.add(lblOpenTime, "8, 3");
						lblOpenTime.setText("Open Time");
						lblOpenTime.setFont(new java.awt.Font("Cambria",1,16));
						lblOpenTime.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblStatus = new JLabel();
						pnlDefectDetails.add(lblStatus, "16, 3");
						lblStatus.setText("Status");
						lblStatus.setFont(new java.awt.Font("Cambria",1,16));
						lblStatus.setForeground(new java.awt.Color(64,0,64));
					}
					{
						txtAssignmentGroup = new JTextField();
						pnlDefectDetails.add(txtAssignmentGroup, "2, 3");
						txtAssignmentGroup.setFont(new java.awt.Font("Cambria",0,14));
						txtAssignmentGroup.setForeground(new java.awt.Color(0,0,64));
						txtAssignmentGroup.setEditable(false);
						txtAssignmentGroup.setBackground(new java.awt.Color(242,255,255));
						txtAssignmentGroup.setFocusable(false);
					}
					{
						txtStatus = new JTextField();
						pnlDefectDetails.add(txtStatus, "18, 3");
						txtStatus.setFont(new java.awt.Font("Cambria",0,14));
						txtStatus.setForeground(new java.awt.Color(0,0,64));
						txtStatus.setEditable(false);
						txtStatus.setBackground(new java.awt.Color(242,255,255));
						txtStatus.setDropMode(javax.swing.DropMode.USE_SELECTION);
					}
					{
						txtOpenTime = new JTextField();
						pnlDefectDetails.add(txtOpenTime, "10, 3");
						txtOpenTime.setFont(new java.awt.Font("Cambria",0,14));
						txtOpenTime.setForeground(new java.awt.Color(0,0,64));
						txtOpenTime.setEditable(false);
						txtOpenTime.setBackground(new java.awt.Color(242,255,255));
						txtOpenTime.setDropMode(javax.swing.DropMode.USE_SELECTION);
					}
					{
						txtTicketOwner = new JTextField();
						pnlDefectDetails.add(txtTicketOwner, "14, 3");
						txtTicketOwner.setFont(new java.awt.Font("Cambria",0,14));
						txtTicketOwner.setEditable(false);
						txtTicketOwner.setBackground(new java.awt.Color(242,255,255));
						txtTicketOwner.setForeground(new java.awt.Color(0,0,64));
						txtTicketOwner.setDropMode(javax.swing.DropMode.USE_SELECTION);
					}
					{
						txtOpenedBy = new JTextField();
						pnlDefectDetails.add(txtOpenedBy, "6, 3");
						txtOpenedBy.setFont(new java.awt.Font("Cambria",0,14));
						txtOpenedBy.setEditable(false);
						txtOpenedBy.setBackground(new java.awt.Color(242,255,255));
						txtOpenedBy.setForeground(new java.awt.Color(0,0,64));
						txtOpenedBy.setFocusable(false);
					}
					{
						lblTitle = new JLabel();
						pnlDefectDetails.add(lblTitle, "4, 1");
						lblTitle.setText("Title");
						lblTitle.setFont(new java.awt.Font("Cambria",1,16));
						lblTitle.setForeground(new java.awt.Color(64,0,64));
					}
					{
						txtTitle = new JTextField();
						pnlDefectDetails.add(txtTitle, "6, 1, 18, 1");
						txtTitle.setFont(new java.awt.Font("Cambria",0,14));
						txtTitle.setForeground(new java.awt.Color(0,0,64));
						txtTitle.setEditable(false);
						txtTitle.setBackground(new java.awt.Color(242,255,255));
						txtTitle.setDropMode(javax.swing.DropMode.USE_SELECTION);
					}
					{
						lblProblemId = new JLabel();
						pnlDefectDetails.add(lblProblemId, "0, 1");
						lblProblemId.setText("Problem ID");
						lblProblemId.setFont(new java.awt.Font("Cambria",1,16));
						lblProblemId.setForeground(new java.awt.Color(64,0,64));
					}
					{
						txtProblemId = new JTextField();
						pnlDefectDetails.add(txtProblemId, "2, 1");
						txtProblemId.setEditable(false);
						txtProblemId.setBackground(new java.awt.Color(242,255,255));
						txtProblemId.setForeground(new java.awt.Color(0,0,64));
						txtProblemId.setFont(new java.awt.Font("Cambria",0,14));
						txtProblemId.setFocusable(false);
					}
				}
				{
					pnlDescriptionComments = new JPanel();
					TableLayout jPanel4Layout = new TableLayout(new double[][] {{TableLayout.FILL, TableLayout.FILL, 6.0, TableLayout.FILL, TableLayout.FILL}, {TableLayout.FILL, TableLayout.FILL, 6.0, TableLayout.FILL, 6.0, TableLayout.FILL, 6.0, TableLayout.FILL, TableLayout.FILL}});
					jPanel4Layout.setHGap(5);
					jPanel4Layout.setVGap(5);
					pnlDescriptionComments.setLayout(jPanel4Layout);
					pnlContainer.add(pnlDescriptionComments, "1, 4, 3, 10");
					pnlDescriptionComments.setBackground(new java.awt.Color(125,190,255));
					{
						scrpnDescription = new JScrollPane();
						pnlDescriptionComments.add(scrpnDescription, "0, 0, 1, 3");
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
							edtrpnDescription.setFont(new java.awt.Font("Cambria",0,14));
						}
					}
					{
						scrpnRootCause = new JScrollPane();
						pnlDescriptionComments.add(scrpnRootCause, "3, 3, 4, 6");
						scrpnRootCause.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						scrpnRootCause.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
						scrpnRootCause.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(192,192,192), 2, true), "Root Cause", TitledBorder.LEADING, TitledBorder.TOP, new java.awt.Font("Cambria",1,16), new java.awt.Color(64,0,64)));
						scrpnRootCause.setBackground(new java.awt.Color(117,186,255));
						{
							edtrpnRootCause = new JEditorPane();
							scrpnRootCause.setViewportView(edtrpnRootCause);
							edtrpnRootCause.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
							edtrpnRootCause.setFont(lblAssignmentGroup.getFont());
							edtrpnRootCause.setPreferredSize(new java.awt.Dimension(5000, 500));
							edtrpnRootCause.setEditable(false);
							edtrpnRootCause.setBackground(new java.awt.Color(240,255,255));
							edtrpnRootCause.setFont(new java.awt.Font("Cambria",0,14));
						}
					}
					{
						scrpnResolution = new JScrollPane();
						pnlDescriptionComments.add(scrpnResolution, "3, 0, 4, 1");
						scrpnResolution.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						scrpnResolution.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
						scrpnResolution.setBackground(new java.awt.Color(117,186,255));
						scrpnResolution.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(192,192,192),2,true),"Resolution",TitledBorder.LEADING,TitledBorder.TOP,new java.awt.Font("Cambria",1,16),new java.awt.Color(64,0,64)));
						{
							edtrpnResolution = new JEditorPane();
							scrpnResolution.setViewportView(edtrpnResolution);
							edtrpnResolution.setEditable(false);
							edtrpnResolution.setBackground(new java.awt.Color(240,255,255));
							edtrpnResolution.setFont(new java.awt.Font("Cambria",0,14));
							edtrpnResolution.setPreferredSize(new java.awt.Dimension(5000,5000));
						}
					}
					{
						scrpnWorkaround = new JScrollPane();
						pnlDescriptionComments.add(scrpnWorkaround, "0, 5, 1, 8");
						scrpnWorkaround.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						scrpnWorkaround.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
						scrpnWorkaround.setBackground(new java.awt.Color(117,186,255));
						scrpnWorkaround.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(192,192,192),2,true),"Workaround",TitledBorder.LEADING,TitledBorder.TOP,new java.awt.Font("Cambria",1,16),new java.awt.Color(64,0,64)));
						{
							edtrpnWorkaround = new JEditorPane();
							scrpnWorkaround.setViewportView(edtrpnWorkaround);
							edtrpnWorkaround.setEditable(false);
							edtrpnWorkaround.setBackground(new java.awt.Color(240,255,255));
							edtrpnWorkaround.setFont(new java.awt.Font("Cambria",0,14));
							edtrpnWorkaround.setPreferredSize(new java.awt.Dimension(756, 245));
						}
					}
					{
						scrpnJournalUpdate = new JScrollPane();
						pnlDescriptionComments.add(scrpnJournalUpdate, "3, 7, 4, 8");
						scrpnJournalUpdate.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						scrpnJournalUpdate.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
						scrpnJournalUpdate.setBackground(new java.awt.Color(117,186,255));
						scrpnJournalUpdate.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(192,192,192),2,true),"Journal Updates",TitledBorder.LEADING,TitledBorder.TOP,new java.awt.Font("Cambria",1,16),new java.awt.Color(64,0,64)));
						{
							edtrpnJournalUpdate = new JEditorPane();
							scrpnJournalUpdate.setViewportView(edtrpnJournalUpdate);
							edtrpnJournalUpdate.setEditable(false);
							edtrpnJournalUpdate.setBackground(new java.awt.Color(240,255,255));
							edtrpnJournalUpdate.setFont(new java.awt.Font("Cambria",0,14));
							edtrpnJournalUpdate.setPreferredSize(new java.awt.Dimension(5000,5000));
						}
					}
				}
				{
					pnlHeader = new JPanel();
					TableLayout jPanel1Layout = new TableLayout(new double[][] {{10.0, TableLayout.FILL, TableLayout.FILL, 50.0, 6.0, 50.0, 150.0, 6.0, TableLayout.FILL, 15.0, 15.0, 15.0, 15.0, 6.0, TableLayout.FILL, 15.0, 15.0, 15.0, 6.0, TableLayout.FILL, 50.0, 15.0, 50.0, 50.0, 6.0, 50.0, TableLayout.FILL, 6.0, TableLayout.FILL, 6.0}, {3.0, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, 3.0}});
					jPanel1Layout.setHGap(5);
					jPanel1Layout.setVGap(5);
					pnlHeader.setLayout(jPanel1Layout);
					pnlContainer.add(pnlHeader, "0, 1, 4, 1");
					pnlHeader.setBackground(new java.awt.Color(34,145,255));
					pnlHeader.setBorder(BorderFactory.createCompoundBorder(
							new LineBorder(new java.awt.Color(128,0,128), 1, false),
							new LineBorder(new java.awt.Color(0,253,253), 2, true)));
					{
						lblHeaderLeft = new JLabel();
						pnlHeader.add(lblHeaderLeft, "1, 1, 3, 6");
						lblHeaderLeft.setText("Problem Management");
						lblHeaderLeft.setHorizontalTextPosition(SwingConstants.LEFT);
						lblHeaderLeft.setHorizontalAlignment(SwingConstants.LEFT);
						lblHeaderLeft.setFont(new java.awt.Font("Belgacom Bold",0,28));
						lblHeaderLeft.setForeground(new java.awt.Color(176,230,255));
					}
					{
						txtSearch = new JTextField();
						pnlHeader.add(txtSearch, "26, 4, 26, 6");
						txtSearch.setHorizontalAlignment(SwingConstants.CENTER);
						txtSearch.setText("Search PM ID");
						txtSearch.setFont(new java.awt.Font("Cambria",2,14));
						txtSearch.setForeground(new java.awt.Color(192,192,192));
						txtSearch.addFocusListener(new FocusAdapter() {
							public void focusLost(FocusEvent evt) {
								txtSearchFocusLost(evt);
							}
						});
						txtSearch.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								txtSearchMouseClicked(evt);
							}
						});
						txtSearch.setBackground(new java.awt.Color(242,255,255));
						txtSearch.addKeyListener(new KeyAdapter() {
							public void keyReleased(KeyEvent evt) {
								txtSearchKeyReleased(evt);
							}
							public void keyPressed(KeyEvent evt) {
								txtSearchKeyPressed(evt);
							}
							public void keyTyped(KeyEvent evt) {
								txtSearchKeyTyped(evt);
							}
						});
					}
					{
						btnSearch = new JButton();
						pnlHeader.add(btnSearch, "28, 4, 28, 6");
						btnSearch.setText("Search");
						btnSearch.setEnabled(false);
						btnSearch.setFont(new java.awt.Font("Cambria",1,16));
						btnSearch.setForeground(new java.awt.Color(192,192,192));
						btnSearch.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								btnSearchActionPerformed(evt);
							}
						});
					}
					{
						lblHeader = new JLabel();
						pnlHeader.add(lblHeader, "5, 1, 23, 4");
						lblHeader.setText("Problem Overview (HPSM)");
						lblHeader.setFont(new java.awt.Font("Baskerville Old Face",1,36));
						lblHeader.setForeground(new java.awt.Color(0,73,147));
						lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
						lblHeader.setHorizontalTextPosition(SwingConstants.CENTER);
						lblHeader.setBackground(new java.awt.Color(128,0,255));
					}
					{
						lblUserName = new JLabel();
						pnlHeader.add(lblUserName, "26, 1, 28, 3");
						lblUserName.setText("Welcome "+ this.objLoginBean.getFirstName());
						lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
						lblUserName.setFont(new java.awt.Font("Cambria",2,16));
						lblUserName.setForeground(new java.awt.Color(221,238,255));
						lblUserName.setHorizontalTextPosition(SwingConstants.CENTER);
					}
					{
						lblE2EProblemOverview = new JLabel();
						pnlHeader.add(lblE2EProblemOverview, "8, 5, 11, 6");
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
						lblQCTDefectOverview = new JLabel();
						pnlHeader.add(lblQCTDefectOverview, "14, 5, 16, 6");
						lblQCTDefectOverview.setText("Defect Overview (QCT)");
						lblQCTDefectOverview.setHorizontalTextPosition(SwingConstants.CENTER);
						lblQCTDefectOverview.setHorizontalAlignment(SwingConstants.CENTER);
						lblQCTDefectOverview.setForeground(new java.awt.Color(206,255,255));
						lblQCTDefectOverview.setFont(new java.awt.Font("Cambria",0,16));
						lblQCTDefectOverview.addMouseListener(new MouseAdapter() {
							public void mouseExited(MouseEvent evt) {
								lblQCTDefectOverviewMouseExited(evt);
							}
							public void mouseEntered(MouseEvent evt) {
								lblQCTDefectOverviewMouseEntered(evt);
							}
							public void mouseClicked(MouseEvent evt) {
								lblQCTDefectOverviewMouseClicked(evt);
							}
						});
					}
					{
						lblDashboard = new JLabel();
						pnlHeader.add(lblDashboard, "6, 5, 6, 6");
						lblDashboard.setText("Go To Dashboard");
						lblDashboard.setHorizontalTextPosition(SwingConstants.CENTER);
						lblDashboard.setHorizontalAlignment(SwingConstants.CENTER);
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
						pnlHeader.add(lblHPSMIncidentOverview, "19, 5, 21, 6");
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

	private void txtSearchKeyReleased(KeyEvent evt) {
		this.checkSearchInput();
	}

	private void txtSearchKeyPressed(KeyEvent evt) {
		this.checkSearchInput();
	}

	private void txtSearchKeyTyped(KeyEvent evt) {
		if(this.objResourceProvider.compareString(this.txtSearch.getText(), "Search PM ID")){
			this.setSearchField("Editing");
		}else{
			if(this.objResourceProvider.verifyIncidentId(this.txtSearch.getText())){
				this.setSearchField("Correct Input");
			}else{
				this.setSearchField("Incorrect Input");
			}
		}
	}
	private void txtSearchMouseClicked(MouseEvent evt) {
		if(this.objResourceProvider.compareString(this.txtSearch.getText(), "Search PM ID")){
			this.setSearchField("Editing");
		}
	}

	private void txtSearchFocusLost(FocusEvent evt) {
		if(this.objResourceProvider.compareString(this.txtSearch.getText(), "")){
			this.setSearchField("Initial");
		}
	}

	private void btnSearchActionPerformed(ActionEvent evt){
		try{
			this.prepareProblemOverviewHPSMWindow(this.txtSearch.getText());
		}catch(ManagerException eMan){
			if(objResourceProvider.compareString(eMan.getErrorType(), "I")){
                JOptionPane.showMessageDialog(this, eMan.getErrorMessage(), eMan.getErrorName(),JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this, eMan.getErrorMessage(), eMan.getErrorName(), JOptionPane.ERROR_MESSAGE);
            }
            this.setSearchField("Initial");
		}catch(Exception eAll){
			JOptionPane.showMessageDialog(this, "Something went wrong. Please contact System Administrator.", "Application Error", JOptionPane.ERROR_MESSAGE);
            this.resetComponentValues();
		}
	}

	protected void prepareProblemOverviewHPSMWindow(String problemId) throws ManagerException{
		if(this.objResourceProvider.verifyPmId(problemId)){
			Connection objHPSMConnection = this.objResourceProvider.getDatabaseConnection("HPSM");
			this.objProblemOverviewHPSMManager.actionSearch(objHPSMConnection,problemId);
			this.objResourceProvider.closeDatabaseConnection(objHPSMConnection, false, true);
			this.setComponentValues();
		}else{
			throw new ManagerException(1000, "E", "Application Message", "Invalid Problem ID.");
		}

	}

	private void setSearchField(String stage){
		if(this.objResourceProvider.compareString(stage, "Editing")){
			this.txtSearch.setText("");
			this.txtSearch.setBackground(new java.awt.Color(242,255,255));
			this.txtSearch.setForeground(new java.awt.Color(0,0,64));
			this.txtSearch.setFont(new java.awt.Font("Cambria",0,14));
			this.btnSearch.setEnabled(false);
			this.btnSearch.setForeground(new java.awt.Color(192,192,192));
		}else if(this.objResourceProvider.compareString(stage, "Initial")){
			this.txtSearch.setText("Search PM ID");
			this.txtSearch.setFont(new java.awt.Font("Cambria",2,14));
			this.txtSearch.setForeground(new java.awt.Color(192,192,192));
			this.txtSearch.setBackground(new java.awt.Color(242,255,255));
			this.btnSearch.setEnabled(false);
			this.btnSearch.setForeground(new java.awt.Color(192,192,192));
		}else if(this.objResourceProvider.compareString(stage, "Correct Input")){
			this.txtSearch.setFont(new java.awt.Font("Cambria",0,14));
			this.txtSearch.setForeground(new java.awt.Color(0,0,64));
			this.txtSearch.setBackground(new java.awt.Color(210,255,210));
			this.btnSearch.setEnabled(true);
			this.btnSearch.setForeground(new java.awt.Color(64,0,64));
		}else if(this.objResourceProvider.compareString(stage, "Incorrect Input")){
			this.txtSearch.setFont(new java.awt.Font("Cambria",0,14));
			this.txtSearch.setForeground(new java.awt.Color(255,0,0));
			this.txtSearch.setBackground(new java.awt.Color(255,206,206));
			this.btnSearch.setEnabled(false);
			this.btnSearch.setForeground(new java.awt.Color(192,192,192));
		}
	}

	private void setComponentValues(){
		this.setSearchField("Initial");
		this.txtProblemId.setText(objProblemOverviewHPSMBean.getProblemId());
		this.txtTitle.setText(objProblemOverviewHPSMBean.getTitle());
		this.txtStatus.setText(objProblemOverviewHPSMBean.getStatus());
		this.txtAssignmentGroup.setText(objProblemOverviewHPSMBean.getAssignmentGroup());
		this.txtOpenedBy.setText(objProblemOverviewHPSMBean.getOpenedBy());
		this.txtOpenTime.setText(objProblemOverviewHPSMBean.getOpenTime());
		this.txtTicketOwner.setText(objProblemOverviewHPSMBean.getTicketOwner());
		this.edtrpnDescription.setText(objProblemOverviewHPSMBean.getDescription());
		this.edtrpnRootCause.setText(objProblemOverviewHPSMBean.getRootCause());
		this.edtrpnResolution.setText(objProblemOverviewHPSMBean.getResolution());
		this.edtrpnWorkaround.setText(objProblemOverviewHPSMBean.getWorkaround());
		this.edtrpnJournalUpdate.setText(objProblemOverviewHPSMBean.getJournalUpdates());

		this.txtProblemId.setToolTipText(objProblemOverviewHPSMBean.getProblemId());
		this.txtTitle.setToolTipText(objProblemOverviewHPSMBean.getTitle());
		this.txtStatus.setToolTipText(objProblemOverviewHPSMBean.getStatus());
		this.txtAssignmentGroup.setToolTipText(objProblemOverviewHPSMBean.getAssignmentGroup());
		this.txtOpenedBy.setToolTipText(objProblemOverviewHPSMBean.getOpenedBy());
		this.txtOpenTime.setToolTipText(objProblemOverviewHPSMBean.getOpenTime());
		this.txtTicketOwner.setToolTipText(objProblemOverviewHPSMBean.getTicketOwner());
		this.edtrpnDescription.setToolTipText(objProblemOverviewHPSMBean.getDescription());
		this.edtrpnRootCause.setToolTipText(objProblemOverviewHPSMBean.getRootCause());
		this.edtrpnResolution.setToolTipText(objProblemOverviewHPSMBean.getResolution());
		this.edtrpnWorkaround.setToolTipText(objProblemOverviewHPSMBean.getWorkaround());
		this.edtrpnJournalUpdate.setToolTipText(objProblemOverviewHPSMBean.getJournalUpdates());
	}

	private void resetComponentValues(){
		this.setSearchField("Initial");
		this.txtProblemId.setText("");
		this.txtTitle.setText("");
		this.txtStatus.setText("");
		this.txtAssignmentGroup.setText("");
		this.txtOpenedBy.setText("");
		this.txtOpenTime.setText("");
		this.txtTicketOwner.setText("");
		this.edtrpnDescription.setText("");
		this.edtrpnRootCause.setText("");
		this.edtrpnResolution.setText("");
		this.edtrpnWorkaround.setText("");
		this.edtrpnJournalUpdate.setText("");

		this.txtSearch.setToolTipText("");
		this.txtProblemId.setToolTipText("");
		this.txtTitle.setToolTipText("");
		this.txtStatus.setToolTipText("");
		this.txtAssignmentGroup.setToolTipText("");
		this.txtOpenedBy.setToolTipText("");
		this.txtOpenTime.setToolTipText("");
		this.txtTicketOwner.setToolTipText("");
		this.edtrpnDescription.setToolTipText("");
		this.edtrpnRootCause.setToolTipText("");
		this.edtrpnResolution.setToolTipText("");
		this.edtrpnWorkaround.setToolTipText("");
		this.edtrpnJournalUpdate.setToolTipText("");
	}

	private void checkSearchInput(){
		if(this.objResourceProvider.compareString(this.txtSearch.getText(), "Search PM ID") || this.objResourceProvider.compareString(this.txtSearch.getText(), "")){
			this.setSearchField("Editing");
		}else{
			if(this.objResourceProvider.verifyPmId(this.txtSearch.getText())){
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

	private void lblQCTDefectOverviewMouseClicked(MouseEvent evt) {
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

	private void lblDashboardMouseClicked(MouseEvent evt) {
			this.objDashboardWindow.setVisible(true);
			this.objDashboardWindow.setExtendedState(MAXIMIZED_BOTH);
			this.objDashboardWindow.resetDashboard();
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

	private void lblE2EProblemOverviewMouseEntered(MouseEvent evt) {
		lblE2EProblemOverview.setForeground(new java.awt.Color(0,0,255));
		lblE2EProblemOverview.setFont(new java.awt.Font("Cambria",2,16));
	}

	private void lblQCTDefectOverviewMouseEntered(MouseEvent evt) {
		lblQCTDefectOverview.setForeground(new java.awt.Color(0,0,255));
		lblQCTDefectOverview.setFont(new java.awt.Font("Cambria",2,16));
	}

	private void lblDashboardMouseEntered(MouseEvent evt) {
		lblDashboard.setForeground(new java.awt.Color(0,0,255));
		lblDashboard.setFont(new java.awt.Font("Cambria",2,16));
	}

	private void lblHPSMIncidentOverviewMouseEntered(MouseEvent evt) {
		lblHPSMIncidentOverview.setForeground(new java.awt.Color(0,0,255));
		lblHPSMIncidentOverview.setFont(new java.awt.Font("Cambria",2,16));
	}

	private void lblE2EProblemOverviewMouseExited(MouseEvent evt) {
		lblE2EProblemOverview.setForeground(new java.awt.Color(206,255,255));
		lblE2EProblemOverview.setFont(new java.awt.Font("Cambria",0,16));
	}

	private void lblQCTDefectOverviewMouseExited(MouseEvent evt) {
		lblQCTDefectOverview.setForeground(new java.awt.Color(206,255,255));
		lblQCTDefectOverview.setFont(new java.awt.Font("Cambria",0,16));
	}

	private void lblDashboardMouseExited(MouseEvent evt) {
		lblDashboard.setForeground(new java.awt.Color(206,255,255));
		lblDashboard.setFont(new java.awt.Font("Cambria",0,16));
	}

	private void lblHPSMIncidentOverviewMouseExited(MouseEvent evt) {
		lblHPSMIncidentOverview.setForeground(new java.awt.Color(206,255,255));
		lblHPSMIncidentOverview.setFont(new java.awt.Font("Cambria",0,16));
	}
}
