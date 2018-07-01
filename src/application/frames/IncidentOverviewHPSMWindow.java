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

import application.beans.IncidentOverviewHPSMBean;
import application.beans.LoginBean;
import application.exceptions.ManagerException;
import application.manager.IncidentOverviewHPSMManager;


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
final class IncidentOverviewHPSMWindow extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	{
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private JPanel pnlMain;
	private JEditorPane edtrpnProgress;
	private JScrollPane scrpnProgress;
	private JEditorPane edtrpnResolutionComment;
	private JScrollPane scrpnResolutionComment;
	private JTextField txtIncidentId;
	private JLabel lblIncidentId;
	private JLabel lblUserName;
	private JLabel lblHeader;
	private JPanel pnlHeader;
	private JLabel lblRequestorId;
	private JEditorPane edtrpnDescription;
	private JScrollPane scrpnDescription;
	private JPanel pnlDescriptionComments;
	private JButton btnSearch;
	private JTextField txtSearch;
	private JTextField txtTitle;
	private JLabel lblTitle;
	private JLabel lblHeaderLeft;
	private JTextField txtAssigneeId;
	private JTextField txtRequestorId;
	private JTextField txtOpenTime;
	private JTextField txtStatus;
	private JTextField txtAssignmentGroup;
	private JLabel lblStatus;
	private JLabel lblOpenTime;
	private JLabel lblAssigneeId;
	private JLabel lblAssignmentGroup;
	private JPanel pnlIncidentDetails;
	private JPanel pnlContainer;
	private JTextField txtAssigneeName;
	private JLabel lblUpdatedBy;
	private JTextField txtResolvedBy;
	private JLabel lblResolvedBy;
	private JTextField txtUpdatedBy;
	private JLabel lblAssigneeName;
	private JTextField txtRequestedBy;
	private JLabel lblRequestedBy;
	private JTextField txtCloseTime;
	private JLabel lblCloseTime;
	private JTextField txtProblemType;
	private JLabel lblProblemType;
	private JTextField txtConfigurationItem;
	private JLabel lblDashboard;
	private JLabel lblE2EProblemOverview;
	private JLabel lblQCTDefectOverview;
	private JLabel lblHPSMProblemOverview;
	private JLabel lblConfigurationItem;
	private final ResourceProvider objResourceProvider;
	private final LoginBean objLoginBean;
	private final DashboardWindow objDashboardWindow;
	private final IncidentOverviewHPSMBean objIncidentOverviewHPSMBean;
	private final IncidentOverviewHPSMManager objIncidentOverviewHPSMManager;

 	public IncidentOverviewHPSMWindow(DashboardWindow objDashboardWindow) {
		super();
		this.objLoginBean = objDashboardWindow.getObjLoginBean();
		this.objDashboardWindow = objDashboardWindow;
		this.objResourceProvider = objDashboardWindow.getObjResourceProvider();
		this.objIncidentOverviewHPSMBean = new IncidentOverviewHPSMBean();
		this.objIncidentOverviewHPSMManager = new IncidentOverviewHPSMManager(objResourceProvider, objIncidentOverviewHPSMBean);
		initGUI();
		this.setVisible(false);
	}

	private void initGUI() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("E2E Tracker - Incident Overview (HPSM)");
		{
			pnlMain = new JPanel();
			getContentPane().add(pnlMain, BorderLayout.CENTER);
			pnlMain.setLayout(null);
			pnlMain.setPreferredSize(new java.awt.Dimension(1249, 822));
			pnlMain.setBackground(new java.awt.Color(125,190,255));
			{
				pnlContainer = new JPanel();
				TableLayout jPanel2Layout = new TableLayout(new double[][] {{3.0, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, 3.0}, {3.0, 89.0, 63.0, TableLayout.FILL, 6.0, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, 3.0}});
				jPanel2Layout.setHGap(5);
				jPanel2Layout.setVGap(5);
				pnlContainer.setLayout(jPanel2Layout);
				pnlMain.add(pnlContainer);
				pnlContainer.setBounds(0, -6, 1599, 822);
				pnlContainer.setBackground(new java.awt.Color(125,190,255));
				pnlContainer.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
				{
					pnlIncidentDetails = new JPanel();
					TableLayout jPanel3Layout = new TableLayout(new double[][] {{146.0, 6.0, TableLayout.FILL, 6.0, 120.0, 6.0, TableLayout.FILL, 6.0, 115.0, 6.0, TableLayout.FILL, 6.0, 115.0, 6.0, TableLayout.FILL, 6.0, 114.0, 6.0, TableLayout.FILL}, {3.0, TableLayout.FILL, 6.0, TableLayout.FILL, 3.0, TableLayout.FILL, 6.0}});
					jPanel3Layout.setHGap(5);
					jPanel3Layout.setVGap(5);
					pnlIncidentDetails.setLayout(jPanel3Layout);
					pnlContainer.add(pnlIncidentDetails, "1, 2, 3, 3");
					pnlIncidentDetails.setBackground(new java.awt.Color(125,190,255));
					{
						lblRequestorId = new JLabel();
						pnlIncidentDetails.add(lblRequestorId, "4, 3");
						lblRequestorId.setText("Requestor Id");
						lblRequestorId.setFont(new java.awt.Font("Cambria",1,16));
						lblRequestorId.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblAssignmentGroup = new JLabel();
						pnlIncidentDetails.add(lblAssignmentGroup, "0, 5");
						lblAssignmentGroup.setText("Assignment Group");
						lblAssignmentGroup.setFont(new java.awt.Font("Cambria",1,16));
						lblAssignmentGroup.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblAssigneeId = new JLabel();
						pnlIncidentDetails.add(lblAssigneeId, "4, 5");
						lblAssigneeId.setText("Assignee Id");
						lblAssigneeId.setFont(new java.awt.Font("Cambria",1,16));
						lblAssigneeId.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblOpenTime = new JLabel();
						pnlIncidentDetails.add(lblOpenTime, "12, 3");
						lblOpenTime.setText("Open Time");
						lblOpenTime.setFont(new java.awt.Font("Cambria",1,16));
						lblOpenTime.setForeground(new java.awt.Color(64,0,64));
					}
					{
						lblStatus = new JLabel();
						pnlIncidentDetails.add(lblStatus, "16, 1");
						lblStatus.setText("Status");
						lblStatus.setFont(new java.awt.Font("Cambria",1,16));
						lblStatus.setForeground(new java.awt.Color(64,0,64));
					}
					{
						txtAssignmentGroup = new JTextField();
						pnlIncidentDetails.add(txtAssignmentGroup, "2, 5");
						txtAssignmentGroup.setFont(new java.awt.Font("Cambria",0,14));
						txtAssignmentGroup.setForeground(new java.awt.Color(0,0,64));
						txtAssignmentGroup.setEditable(false);
						txtAssignmentGroup.setBackground(new java.awt.Color(242,255,255));
						txtAssignmentGroup.setFocusable(false);
					}
					{
						txtStatus = new JTextField();
						pnlIncidentDetails.add(txtStatus, "18, 1");
						txtStatus.setFont(new java.awt.Font("Cambria",0,14));
						txtStatus.setForeground(new java.awt.Color(0,0,64));
						txtStatus.setEditable(false);
						txtStatus.setBackground(new java.awt.Color(242,255,255));
						txtStatus.setDropMode(javax.swing.DropMode.USE_SELECTION);
					}
					{
						txtOpenTime = new JTextField();
						pnlIncidentDetails.add(txtOpenTime, "14, 3");
						txtOpenTime.setFont(new java.awt.Font("Cambria",0,14));
						txtOpenTime.setForeground(new java.awt.Color(0,0,64));
						txtOpenTime.setEditable(false);
						txtOpenTime.setBackground(new java.awt.Color(242,255,255));
						txtOpenTime.setDropMode(javax.swing.DropMode.USE_SELECTION);
					}
					{
						txtRequestorId = new JTextField();
						pnlIncidentDetails.add(txtRequestorId, "6, 3");
						txtRequestorId.setFont(new java.awt.Font("Cambria",0,14));
						txtRequestorId.setEditable(false);
						txtRequestorId.setBackground(new java.awt.Color(242,255,255));
						txtRequestorId.setForeground(new java.awt.Color(0,0,64));
						txtRequestorId.setDropMode(javax.swing.DropMode.USE_SELECTION);
					}
					{
						txtAssigneeId = new JTextField();
						pnlIncidentDetails.add(txtAssigneeId, "6, 5");
						txtAssigneeId.setFont(new java.awt.Font("Cambria",0,14));
						txtAssigneeId.setEditable(false);
						txtAssigneeId.setBackground(new java.awt.Color(242,255,255));
						txtAssigneeId.setForeground(new java.awt.Color(0,0,64));
						txtAssigneeId.setFocusable(false);
					}
					{
						lblTitle = new JLabel();
						pnlIncidentDetails.add(lblTitle, "4, 1");
						lblTitle.setText("Title");
						lblTitle.setFont(new java.awt.Font("Cambria",1,16));
						lblTitle.setForeground(new java.awt.Color(64,0,64));
					}
					{
						txtTitle = new JTextField();
						pnlIncidentDetails.add(txtTitle, "6, 1, 10, 1");
						txtTitle.setFont(new java.awt.Font("Cambria",0,14));
						txtTitle.setForeground(new java.awt.Color(0,0,64));
						txtTitle.setEditable(false);
						txtTitle.setBackground(new java.awt.Color(242,255,255));
						txtTitle.setDropMode(javax.swing.DropMode.USE_SELECTION);
					}
					{
						lblIncidentId = new JLabel();
						pnlIncidentDetails.add(lblIncidentId, "0, 1");
						lblIncidentId.setText("Incident ID");
						lblIncidentId.setFont(new java.awt.Font("Cambria",1,16));
						lblIncidentId.setForeground(new java.awt.Color(64,0,64));
					}
					{
						txtIncidentId = new JTextField();
						pnlIncidentDetails.add(txtIncidentId, "2, 1");
						txtIncidentId.setEditable(false);
						txtIncidentId.setBackground(new java.awt.Color(242,255,255));
						txtIncidentId.setForeground(new java.awt.Color(0,0,64));
						txtIncidentId.setFont(new java.awt.Font("Cambria",0,14));
						txtIncidentId.setFocusable(false);
					}
					{
						lblConfigurationItem = new JLabel();
						pnlIncidentDetails.add(lblConfigurationItem, "0, 3");
						lblConfigurationItem.setText("Configuration Item");
						lblConfigurationItem.setForeground(new java.awt.Color(64,0,64));
						lblConfigurationItem.setFont(new java.awt.Font("Cambria",1,16));
					}
					{
						txtConfigurationItem = new JTextField();
						pnlIncidentDetails.add(txtConfigurationItem, "2, 3");
						txtConfigurationItem.setFont(new java.awt.Font("Cambria",0,14));
						txtConfigurationItem.setText("");
						txtConfigurationItem.setEditable(false);
						txtConfigurationItem.setBackground(new java.awt.Color(242,255,255));
						txtConfigurationItem.setForeground(new java.awt.Color(0,0,64));
						txtConfigurationItem.setToolTipText("");
						txtConfigurationItem.setFocusable(false);
					}
					{
						lblProblemType = new JLabel();
						pnlIncidentDetails.add(lblProblemType, "12, 1");
						lblProblemType.setText("Problem Type");
						lblProblemType.setForeground(new java.awt.Color(64,0,64));
						lblProblemType.setFont(new java.awt.Font("Cambria",1,16));
					}
					{
						txtProblemType = new JTextField();
						pnlIncidentDetails.add(txtProblemType, "14, 1");
						txtProblemType.setFont(new java.awt.Font("Cambria",0,14));
						txtProblemType.setText("");
						txtProblemType.setEditable(false);
						txtProblemType.setBackground(new java.awt.Color(242,255,255));
						txtProblemType.setForeground(new java.awt.Color(0,0,64));
						txtProblemType.setToolTipText("");
						txtProblemType.setFocusable(false);
					}
					{
						lblCloseTime = new JLabel();
						pnlIncidentDetails.add(lblCloseTime, "16, 3");
						lblCloseTime.setText("Close Time");
						lblCloseTime.setForeground(new java.awt.Color(64,0,64));
						lblCloseTime.setFont(new java.awt.Font("Cambria",1,16));
					}
					{
						txtCloseTime = new JTextField();
						pnlIncidentDetails.add(txtCloseTime, "18, 3");
						txtCloseTime.setFont(new java.awt.Font("Cambria",0,14));
						txtCloseTime.setText("");
						txtCloseTime.setEditable(false);
						txtCloseTime.setDropMode(javax.swing.DropMode.USE_SELECTION);
						txtCloseTime.setBackground(new java.awt.Color(242,255,255));
						txtCloseTime.setForeground(new java.awt.Color(0,0,64));
						txtCloseTime.setToolTipText("");
					}
					{
						lblRequestedBy = new JLabel();
						pnlIncidentDetails.add(lblRequestedBy, "8, 3");
						lblRequestedBy.setText("Requested By");
						lblRequestedBy.setForeground(new java.awt.Color(64,0,64));
						lblRequestedBy.setFont(new java.awt.Font("Cambria",1,16));
					}
					{
						txtRequestedBy = new JTextField();
						pnlIncidentDetails.add(txtRequestedBy, "10, 3");
						txtRequestedBy.setFont(new java.awt.Font("Cambria",0,14));
						txtRequestedBy.setText("");
						txtRequestedBy.setEditable(false);
						txtRequestedBy.setBackground(new java.awt.Color(242,255,255));
						txtRequestedBy.setForeground(new java.awt.Color(0,0,64));
						txtRequestedBy.setToolTipText("");
						txtRequestedBy.setFocusable(false);
					}
					{
						lblAssigneeName = new JLabel();
						pnlIncidentDetails.add(lblAssigneeName, "8, 5");
						lblAssigneeName.setText("Assignee Name");
						lblAssigneeName.setForeground(new java.awt.Color(64,0,64));
						lblAssigneeName.setFont(new java.awt.Font("Cambria",1,16));
					}
					{
						txtUpdatedBy = new JTextField();
						pnlIncidentDetails.add(txtUpdatedBy, "14, 5");
						txtUpdatedBy.setFont(new java.awt.Font("Cambria",0,14));
						txtUpdatedBy.setText("");
						txtUpdatedBy.setEditable(false);
						txtUpdatedBy.setBackground(new java.awt.Color(242,255,255));
						txtUpdatedBy.setForeground(new java.awt.Color(0,0,64));
						txtUpdatedBy.setToolTipText("");
						txtUpdatedBy.setFocusable(false);
					}
					{
						lblResolvedBy = new JLabel();
						pnlIncidentDetails.add(lblResolvedBy, "16, 5");
						lblResolvedBy.setText("Resolved By");
						lblResolvedBy.setForeground(new java.awt.Color(64,0,64));
						lblResolvedBy.setFont(new java.awt.Font("Cambria",1,16));
					}
					{
						txtResolvedBy = new JTextField();
						pnlIncidentDetails.add(txtResolvedBy, "18, 5");
						txtResolvedBy.setFont(new java.awt.Font("Cambria",0,14));
						txtResolvedBy.setText("");
						txtResolvedBy.setEditable(false);
						txtResolvedBy.setBackground(new java.awt.Color(242,255,255));
						txtResolvedBy.setForeground(new java.awt.Color(0,0,64));
						txtResolvedBy.setToolTipText("");
						txtResolvedBy.setFocusable(false);
					}
					{
						lblUpdatedBy = new JLabel();
						pnlIncidentDetails.add(lblUpdatedBy, "12, 5");
						lblUpdatedBy.setText("Updated By");
						lblUpdatedBy.setForeground(new java.awt.Color(64,0,64));
						lblUpdatedBy.setFont(new java.awt.Font("Cambria",1,16));
					}
					{
						txtAssigneeName = new JTextField();
						pnlIncidentDetails.add(txtAssigneeName, "10, 5");
						txtAssigneeName.setFont(new java.awt.Font("Cambria",0,14));
						txtAssigneeName.setText("");
						txtAssigneeName.setEditable(false);
						txtAssigneeName.setDropMode(javax.swing.DropMode.USE_SELECTION);
						txtAssigneeName.setBackground(new java.awt.Color(242,255,255));
						txtAssigneeName.setForeground(new java.awt.Color(0,0,64));
						txtAssigneeName.setToolTipText("");
					}
				}
				{
					pnlDescriptionComments = new JPanel();
					TableLayout jPanel4Layout = new TableLayout(new double[][] {{TableLayout.FILL, TableLayout.FILL, 6.0, TableLayout.FILL, TableLayout.FILL}, {TableLayout.FILL, TableLayout.FILL, 6.0, TableLayout.FILL, 6.0, TableLayout.FILL, 6.0, TableLayout.FILL, TableLayout.FILL}});
					jPanel4Layout.setHGap(5);
					jPanel4Layout.setVGap(5);
					pnlDescriptionComments.setLayout(jPanel4Layout);
					pnlContainer.add(pnlDescriptionComments, "1, 5, 3, 11");
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
						scrpnResolutionComment = new JScrollPane();
						pnlDescriptionComments.add(scrpnResolutionComment, "0, 5, 1, 8");
						scrpnResolutionComment.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						scrpnResolutionComment.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
						scrpnResolutionComment.setBackground(new java.awt.Color(117,186,255));
						scrpnResolutionComment.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(192,192,192),2,true),"Resolution Comment",TitledBorder.LEADING,TitledBorder.TOP,new java.awt.Font("Cambria",1,16),new java.awt.Color(64,0,64)));
						{
							edtrpnResolutionComment = new JEditorPane();
							scrpnResolutionComment.setViewportView(edtrpnResolutionComment);
							edtrpnResolutionComment.setEditable(false);
							edtrpnResolutionComment.setBackground(new java.awt.Color(240,255,255));
							edtrpnResolutionComment.setFont(new java.awt.Font("Cambria",0,14));
							edtrpnResolutionComment.setPreferredSize(new java.awt.Dimension(756, 245));
						}
					}
					{
						scrpnProgress = new JScrollPane();
						pnlDescriptionComments.add(scrpnProgress, "3, 0, 4, 8");
						scrpnProgress.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						scrpnProgress.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
						scrpnProgress.setBackground(new java.awt.Color(117,186,255));
						scrpnProgress.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(192,192,192),2,true),"Progress",TitledBorder.LEADING,TitledBorder.TOP,new java.awt.Font("Cambria",1,16),new java.awt.Color(64,0,64)));
						{
							edtrpnProgress = new JEditorPane();
							scrpnProgress.setViewportView(edtrpnProgress);
							edtrpnProgress.setEditable(false);
							edtrpnProgress.setBackground(new java.awt.Color(240,255,255));
							edtrpnProgress.setFont(new java.awt.Font("Cambria",0,14));
							edtrpnProgress.setPreferredSize(new java.awt.Dimension(5000,5000));
						}
					}
				}
				{
					pnlHeader = new JPanel();
					TableLayout jPanel1Layout = new TableLayout(new double[][] {{10.0, TableLayout.FILL, TableLayout.FILL, 50.0, TableLayout.FILL, TableLayout.FILL, 6.0, TableLayout.FILL, 50.0, 6.0, TableLayout.FILL, 15.0, 10.0, 6.0, TableLayout.FILL, 50.0, 15.0, TableLayout.FILL, TableLayout.FILL, 6.0, TableLayout.FILL, 6.0}, {3.0, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, 3.0}});
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
						pnlHeader.add(txtSearch, "18, 4, 18, 6");
						txtSearch.setHorizontalAlignment(SwingConstants.CENTER);
						txtSearch.setText("Search");
						txtSearch.setFont(new java.awt.Font("Cambria",2,14));
						txtSearch.setForeground(new java.awt.Color(192,192,192));
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
						});
					}
					{
						btnSearch = new JButton();
						pnlHeader.add(btnSearch, "20, 4, 20, 6");
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
						pnlHeader.add(lblHeader, "5, 1, 14, 4");
						lblHeader.setText("Incident Overview (HPSM)");
						lblHeader.setFont(new java.awt.Font("Baskerville Old Face",1,36));
						lblHeader.setForeground(new java.awt.Color(0,73,147));
						lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
						lblHeader.setHorizontalTextPosition(SwingConstants.CENTER);
						lblHeader.setBackground(new java.awt.Color(128,0,255));
					}
					{
						lblUserName = new JLabel();
						pnlHeader.add(lblUserName, "18, 1, 20, 3");
						lblUserName.setText("Welcome "+ this.objLoginBean.getFirstName());
						lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
						lblUserName.setFont(new java.awt.Font("Cambria",2,16));
						lblUserName.setForeground(new java.awt.Color(221,238,255));
						lblUserName.setHorizontalTextPosition(SwingConstants.CENTER);
					}
					{
						lblHPSMProblemOverview = new JLabel();
						pnlHeader.add(lblHPSMProblemOverview, "14, 5, 16, 6");
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
						lblQCTDefectOverview = new JLabel();
						pnlHeader.add(lblQCTDefectOverview, "10, 5, 12, 6");
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
						lblE2EProblemOverview = new JLabel();
						pnlHeader.add(lblE2EProblemOverview, "7, 5, 8, 6");
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
						pnlHeader.add(lblDashboard, "5, 5, 5, 6");
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

	private void btnSearchActionPerformed(ActionEvent evt){
		try{
			this.prepareIncidentOverviewHPSMWindow(this.txtSearch.getText());
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

	protected void prepareIncidentOverviewHPSMWindow(String incidentId) throws ManagerException{
		if(this.objResourceProvider.verifyIncidentId(incidentId)){
			Connection objHPSMConnection = this.objResourceProvider.getDatabaseConnection("HPSM");
			this.objIncidentOverviewHPSMManager.actionSearch(objHPSMConnection,incidentId);
			this.objResourceProvider.closeDatabaseConnection(objHPSMConnection, false, true);
			this.setComponentValues();
		}else{
			throw new ManagerException(1000, "I", "Application Message", "Invalid Incident ID.");
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
			this.txtSearch.setText("Search");
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
		this.txtIncidentId.setText(this.objIncidentOverviewHPSMBean.getIncidentId());
		this.txtIncidentId.setToolTipText(this.objIncidentOverviewHPSMBean.getIncidentId());
		this.txtTitle.setText(this.objIncidentOverviewHPSMBean.getTitle());
		this.txtTitle.setToolTipText(this.objIncidentOverviewHPSMBean.getTitle());
		this.txtProblemType.setText(this.objIncidentOverviewHPSMBean.getProblemType());
		this.txtProblemType.setToolTipText(this.objIncidentOverviewHPSMBean.getProblemType());
		this.txtStatus.setText(this.objIncidentOverviewHPSMBean.getStatus());
		this.txtStatus.setToolTipText(this.objIncidentOverviewHPSMBean.getStatus());
		this.txtConfigurationItem.setText(this.objIncidentOverviewHPSMBean.getConfigurationItem());
		this.txtConfigurationItem.setToolTipText(this.objIncidentOverviewHPSMBean.getConfigurationItem());
		this.txtRequestorId.setText(this.objIncidentOverviewHPSMBean.getRequestorId());
		this.txtRequestorId.setToolTipText(this.objIncidentOverviewHPSMBean.getRequestorId());
		this.txtRequestedBy.setText(this.objIncidentOverviewHPSMBean.getRequestedBy());
		this.txtRequestedBy.setToolTipText(this.objIncidentOverviewHPSMBean.getRequestedBy());
		this.txtOpenTime.setText(this.objIncidentOverviewHPSMBean.getOpenTime());
		this.txtOpenTime.setToolTipText(this.objIncidentOverviewHPSMBean.getOpenTime());
		this.txtCloseTime.setText(this.objIncidentOverviewHPSMBean.getCloseTime());
		this.txtCloseTime.setToolTipText(this.objIncidentOverviewHPSMBean.getCloseTime());
		this.txtAssignmentGroup.setText(this.objIncidentOverviewHPSMBean.getAssignmentGroup());
		this.txtAssignmentGroup.setToolTipText(this.objIncidentOverviewHPSMBean.getAssignmentGroup());
		this.txtAssigneeId.setText(this.objIncidentOverviewHPSMBean.getAssigneeId());
		this.txtAssigneeId.setToolTipText(this.objIncidentOverviewHPSMBean.getAssigneeId());
		this.txtAssigneeName.setText(this.objIncidentOverviewHPSMBean.getAssigneeName());
		this.txtAssigneeName.setToolTipText(this.objIncidentOverviewHPSMBean.getAssigneeName());
		this.txtUpdatedBy.setText(this.objIncidentOverviewHPSMBean.getUpdatedBy());
		this.txtUpdatedBy.setToolTipText(this.objIncidentOverviewHPSMBean.getUpdatedBy());
		this.txtResolvedBy.setText(this.objIncidentOverviewHPSMBean.getResolvedBy());
		this.txtResolvedBy.setToolTipText(this.objIncidentOverviewHPSMBean.getResolvedBy());
		this.edtrpnDescription.setText(this.objIncidentOverviewHPSMBean.getDescription());
		this.edtrpnDescription.setToolTipText(this.objIncidentOverviewHPSMBean.getDescription());
		this.edtrpnResolutionComment.setText(this.objIncidentOverviewHPSMBean.getResolutionComment());
		this.edtrpnResolutionComment.setToolTipText(this.objIncidentOverviewHPSMBean.getResolutionComment());
		this.edtrpnProgress.setText(this.objIncidentOverviewHPSMBean.getProgress());
		this.edtrpnProgress.setToolTipText(this.objIncidentOverviewHPSMBean.getProgress());
	}

	private void resetComponentValues(){
		this.setSearchField("Initial");
		this.txtIncidentId.setText("");
		this.txtIncidentId.setToolTipText("");
		this.txtTitle.setText("");
		this.txtTitle.setToolTipText("");
		this.txtProblemType.setText("");
		this.txtProblemType.setToolTipText("");
		this.txtStatus.setText("");
		this.txtStatus.setToolTipText("");
		this.txtConfigurationItem.setText("");
		this.txtConfigurationItem.setToolTipText("");
		this.txtRequestorId.setText("");
		this.txtRequestorId.setToolTipText("");
		this.txtRequestedBy.setText("");
		this.txtRequestedBy.setToolTipText("");
		this.txtOpenTime.setText("");
		this.txtOpenTime.setToolTipText("");
		this.txtCloseTime.setText("");
		this.txtCloseTime.setToolTipText("");
		this.txtAssignmentGroup.setText("");
		this.txtAssignmentGroup.setToolTipText("");
		this.txtAssigneeId.setText("");
		this.txtAssigneeId.setToolTipText("");
		this.txtAssigneeName.setText("");
		this.txtAssigneeName.setToolTipText("");
		this.txtUpdatedBy.setText("");
		this.txtUpdatedBy.setToolTipText("");
		this.txtResolvedBy.setText("");
		this.txtResolvedBy.setToolTipText("");
		this.edtrpnDescription.setText("");
		this.edtrpnDescription.setToolTipText("");
		this.edtrpnResolutionComment.setText("");
		this.edtrpnResolutionComment.setToolTipText("");
		this.edtrpnProgress.setText("");
		this.edtrpnProgress.setToolTipText("");
	}

	private void checkSearchInput(){
		if(this.objResourceProvider.compareString(this.txtSearch.getText(), "Search")  || this.objResourceProvider.compareString(this.txtSearch.getText(), "")){
			this.setSearchField("Editing");
		}else{
			if(this.objResourceProvider.verifyIncidentId(this.txtSearch.getText())){
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

	private void lblHPSMProblemOverviewMouseClicked(MouseEvent evt) {
		try{
			this.objDashboardWindow.getObjProblemOverviewHPSMWindow().setVisible(true);
			this.objDashboardWindow.getObjProblemOverviewHPSMWindow().setExtendedState(MAXIMIZED_BOTH);
		}catch(NullPointerException eNull){
			ProblemOverviewHPSMWindow objProblemOverviewHPSMWindow= new ProblemOverviewHPSMWindow(objDashboardWindow);
			objProblemOverviewHPSMWindow.setVisible(true);
			objProblemOverviewHPSMWindow.setExtendedState(MAXIMIZED_BOTH);
			this.objDashboardWindow.setObjProblemOverviewHPSMWindow(objProblemOverviewHPSMWindow);
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

	private void lblHPSMProblemOverviewMouseEntered(MouseEvent evt) {
		lblHPSMProblemOverview.setForeground(new java.awt.Color(0,0,255));
		lblHPSMProblemOverview.setFont(new java.awt.Font("Cambria",2,16));
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

	private void lblHPSMProblemOverviewMouseExited(MouseEvent evt) {
		lblHPSMProblemOverview.setForeground(new java.awt.Color(206,255,255));
		lblHPSMProblemOverview.setFont(new java.awt.Font("Cambria",0,16));
	}
}
