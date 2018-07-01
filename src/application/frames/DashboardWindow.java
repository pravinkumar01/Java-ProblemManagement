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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DebugGraphics;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import application.beans.DashboardBean;
import application.beans.LoginBean;
import application.exceptions.ManagerException;
import application.manager.DashboardManager;



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
final class DashboardWindow extends javax.swing.JFrame {

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
	private JLabel lblChangePassword;
	private JList<String> listFirstFilter;
	private JButton btnRefreshDashboard;
	private JTable tblProblemRecords;
	private JScrollPane scrpnProblemRecords;
	private JButton btnExportAsExcel;
	private JButton btnResetAllFilters;
	private JButton btnApplyFilters;
	private JList<String> listFourthFilter;
	private JList<String> listThirdFilter;
	private JList<String> listSecondFilter;
	private JScrollPane scrpnFourthFilter;
	private JComboBox<String> cmbbxFourthFilter;
	private JScrollPane scrpnThirdFilter;
	private JComboBox<String> cmbbxThirdFilter;
	private JLabel lblUserName;
	private JScrollPane scrpnSecondFilter;
	private JComboBox<String> cmbbxSecondFilter;
	private JScrollPane scrpnFirstFilter;
	private JComboBox<String> cmbbxFirstFilter;
	private JLabel lblHPSMIncidentOverview;
	private JLabel lblHPSMProblemOverview;
	private JLabel lblQCTDefectOverview;
	private JLabel lblE2EProblemOverview;
	private JLabel lblHeader;
	private JPanel pnlHeader;
	private JPanel pnlDescriptionComments;
	private JButton btnSearch;
	private JTextField txtSearch;
	private JLabel lblHeaderLeft;
	private JPanel pnlFilters;
	private JPanel pnlContainer;

	private final ResourceProvider objResourceProvider;
	private final LoginBean objLoginBean;
	private final DashboardBean objDashboardBean;
	private final DashboardManager objDashboardManager;
	private UpdateProfileDetailsWindow objUpdateProfileDetailsWindow;
	private boolean problemWindowE2EFlag;
	private ProblemOverviewE2EWindow objProblemOverviewE2EWindow;
	private ProblemOverviewHPSMWindow objProblemOverviewHPSMWindow;
	private DefectOverviewQCTWindow objDefectOverviewQCTWindow;
	private IncidentOverviewHPSMWindow objIncidentOverviewHPSMWindow;

 	public DashboardWindow(ResourceProvider objResourceProvider, LoginBean objLoginBean) {
		super();
		this.objResourceProvider = objResourceProvider;
		this.objLoginBean = objLoginBean;
		this.objDashboardBean = new DashboardBean();
		this.objDashboardManager = new DashboardManager(this.objResourceProvider, this.objDashboardBean);
		this.initBeanComponent();
		initGUI();
		this.setTableModel();
	}

	private void initGUI() {
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("E2E Tracker - Dashboard");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt){
				dashboardWindowClosing(evt);
			}
		});
		{
			pnlMain = new JPanel();
			getContentPane().add(pnlMain, BorderLayout.CENTER);
			pnlMain.setLayout(null);
			pnlMain.setPreferredSize(new java.awt.Dimension(1604, 837));
			pnlMain.setBackground(new java.awt.Color(125,190,255));
			{
				pnlContainer = new JPanel();
				TableLayout jPanel2Layout = new TableLayout(new double[][] {{3.0, TableLayout.FILL, 6.0, TableLayout.FILL, 6.0, TableLayout.FILL, 6.0, TableLayout.FILL, 6.0, TableLayout.FILL, 3.0}, {15.0, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, 3.0, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, 10.0, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, 22.0}});
				jPanel2Layout.setHGap(5);
				jPanel2Layout.setVGap(5);
				pnlContainer.setLayout(jPanel2Layout);
				pnlMain.add(pnlContainer);
				pnlContainer.setBounds(0, 0, 1599, 822);
				pnlContainer.setBackground(new java.awt.Color(125,190,255));
				pnlContainer.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
				{
					pnlFilters = new JPanel();
					TableLayout jPanel3Layout = new TableLayout(new double[][] {{TableLayout.FILL, TableLayout.FILL, 40.0, 6.0, TableLayout.FILL, TableLayout.FILL, 40.0, 6.0, TableLayout.FILL, TableLayout.FILL, 40.0, 6.0, TableLayout.FILL, TableLayout.FILL, 40.0, 6.0, TableLayout.FILL}, {TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL}});
					jPanel3Layout.setHGap(5);
					jPanel3Layout.setVGap(5);
					pnlFilters.setLayout(jPanel3Layout);
					pnlContainer.add(pnlFilters, "1, 3, 9, 7");
					pnlFilters.setBackground(new java.awt.Color(125,190,255));
					pnlFilters.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(192,192,192), 2, false), "Filters", TitledBorder.LEFT, TitledBorder.TOP, new java.awt.Font("Cambria",0,16), new java.awt.Color(0,0,64)));
					{
						ComboBoxModel<String> cmbbxFirstFilterModel =
								new DefaultComboBoxModel<String>(this.objResourceProvider.convertListToArray(this.objDashboardBean.getFirstFilterComboBoxAllItems()));
						cmbbxFirstFilter = new JComboBox<String>();
						pnlFilters.add(cmbbxFirstFilter, "0, 0, 2, 0");
						cmbbxFirstFilter.setModel(cmbbxFirstFilterModel);
						cmbbxFirstFilter.setFont(new java.awt.Font("Cambria",0,14));
						cmbbxFirstFilter.setForeground(new java.awt.Color(0,0,160));
						this.adjustPopupWidth(cmbbxFirstFilter);
						cmbbxFirstFilter.addMouseListener(new MouseAdapter() {
							public void mouseEntered(MouseEvent evt) {
								cmbbxFirstFilterMouseEntered(evt);
							}
						});
						cmbbxFirstFilter.addItemListener(new ItemListener() {
							public void itemStateChanged(ItemEvent evt) {
								cmbbxFirstFilterItemStateChanged(evt);
							}
						});
					}
					{
						scrpnFirstFilter = new JScrollPane();
						pnlFilters.add(scrpnFirstFilter, "0, 1, 2, 3");
						{
							ListModel<String> listFirstFilterModel =
									new DefaultComboBoxModel<String>(new String[]{null});
							listFirstFilter = new JList<String>();
							scrpnFirstFilter.setViewportView(listFirstFilter);
							listFirstFilter.setModel(listFirstFilterModel);
							listFirstFilter.setPreferredSize(new java.awt.Dimension(1000, 1000));
							listFirstFilter.addListSelectionListener(new ListSelectionListener() {
								public void valueChanged(ListSelectionEvent evt) {
									listFirstFilterValueChanged(evt);
								}
							});
						}
					}
					{
						ComboBoxModel<String> cmbbxSecondFilterModel =
								new DefaultComboBoxModel<String>(this.objResourceProvider.convertListToArray(this.objDashboardBean.getSecondFilterComboBoxAllItems()));
						cmbbxSecondFilter = new JComboBox<String>();
						pnlFilters.add(cmbbxSecondFilter, "4, 0, 6, 0");
						cmbbxSecondFilter.setModel(cmbbxSecondFilterModel);
						cmbbxSecondFilter.setFont(new java.awt.Font("Cambria",0,14));
						cmbbxSecondFilter.setForeground(new java.awt.Color(0,0,160));
						this.adjustPopupWidth(cmbbxSecondFilter);
						cmbbxSecondFilter.addMouseListener(new MouseAdapter() {
							public void mouseEntered(MouseEvent evt) {
								cmbbxSecondFilterMouseEntered(evt);
							}
						});
						cmbbxSecondFilter.addItemListener(new ItemListener() {
							public void itemStateChanged(ItemEvent evt) {
								cmbbxSecondFilterItemStateChanged(evt);
							}
						});
					}
					{
						scrpnSecondFilter = new JScrollPane();
						scrpnSecondFilter.setEnabled(true);
						pnlFilters.add(scrpnSecondFilter, "4, 1, 6, 3");
						{
							ListModel<String> listSecondFilterModel =
									new DefaultComboBoxModel<String>(new String[]{null});
							listSecondFilter = new JList<String>();
							listSecondFilter.setEnabled(true);
							scrpnSecondFilter.setViewportView(listSecondFilter);
							listSecondFilter.setModel(listSecondFilterModel);
							listSecondFilter.setPreferredSize(new java.awt.Dimension(1000, 1000));
							listSecondFilter.addListSelectionListener(new ListSelectionListener() {
								public void valueChanged(ListSelectionEvent evt) {
									listSecondFilterValueChanged(evt);
								}
							});
						}
					}
					{
						ComboBoxModel<String> cmbbxThirdFilterModel =
								new DefaultComboBoxModel<String>(this.objResourceProvider.convertListToArray(this.objDashboardBean.getThirdFilterComboBoxAllItems()));
						cmbbxThirdFilter = new JComboBox<String>();
						pnlFilters.add(cmbbxThirdFilter, "8, 0, 10, 0");
						cmbbxThirdFilter.setModel(cmbbxThirdFilterModel);
						cmbbxThirdFilter.setFont(new java.awt.Font("Cambria",0,14));
						cmbbxThirdFilter.setForeground(new java.awt.Color(0,0,160));
						this.adjustPopupWidth(cmbbxThirdFilter);
						cmbbxThirdFilter.addMouseListener(new MouseAdapter() {
							public void mouseEntered(MouseEvent evt) {
								cmbbxThirdFilterMouseEntered(evt);
							}
						});
						cmbbxThirdFilter.addItemListener(new ItemListener() {
							public void itemStateChanged(ItemEvent evt) {
								cmbbxThirdFilterItemStateChanged(evt);
							}
						});
					}
					{
						scrpnThirdFilter = new JScrollPane();
						pnlFilters.add(scrpnThirdFilter, "8, 1, 10, 3");
						{
							ListModel<String> listThirdFilterModel =
									new DefaultComboBoxModel<String>(new String[]{null});
							listThirdFilter = new JList<String>();
							scrpnThirdFilter.setViewportView(listThirdFilter);
							listThirdFilter.setModel(listThirdFilterModel);
							listThirdFilter.setPreferredSize(new java.awt.Dimension(1000, 1000));
							listThirdFilter.addListSelectionListener(new ListSelectionListener() {
								public void valueChanged(ListSelectionEvent evt) {
									listThirdFilterValueChanged(evt);
								}
							});
						}
					}
					{
						ComboBoxModel<String> cmbbxFourthFilterModel =
								new DefaultComboBoxModel<String>(this.objResourceProvider.convertListToArray(this.objDashboardBean.getFourthFilterComboBoxAllItems()));
						cmbbxFourthFilter = new JComboBox<String>();
						pnlFilters.add(cmbbxFourthFilter, "12, 0, 14, 0");
						cmbbxFourthFilter.setModel(cmbbxFourthFilterModel);
						cmbbxFourthFilter.setFont(new java.awt.Font("Cambria",0,14));
						cmbbxFourthFilter.setForeground(new java.awt.Color(0,0,160));
						this.adjustPopupWidth(cmbbxFourthFilter);
						cmbbxFourthFilter.addMouseListener(new MouseAdapter() {
							public void mouseEntered(MouseEvent evt) {
								cmbbxFourthFilterMouseEntered(evt);
							}
						});
						cmbbxFourthFilter.addItemListener(new ItemListener() {
							public void itemStateChanged(ItemEvent evt) {
								cmbbxFourthFilterItemStateChanged(evt);
							}
						});
					}
					{
						scrpnFourthFilter = new JScrollPane();
						pnlFilters.add(scrpnFourthFilter, "12, 1, 14, 3");
						{
							ListModel<String> listFourthFilterModel =
									new DefaultComboBoxModel<String>(new String[]{null});
							listFourthFilter = new JList<String>();
							scrpnFourthFilter.setViewportView(listFourthFilter);
							listFourthFilter.setModel(listFourthFilterModel);
							listFourthFilter.setPreferredSize(new java.awt.Dimension(1000, 1000));
							listFourthFilter.addListSelectionListener(new ListSelectionListener() {
								public void valueChanged(ListSelectionEvent evt) {
									listFourthFilterValueChanged(evt);
								}
							});
						}
					}
					{
						btnExportAsExcel = new JButton();
						pnlFilters.add(btnExportAsExcel, "16, 3");
						btnExportAsExcel.setFont(new java.awt.Font("Cambria",1,12));
						btnExportAsExcel.setForeground(new java.awt.Color(64,0,64));
						btnExportAsExcel.setText("Export as Excel File");
						btnExportAsExcel.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								btnExportAsExcelActionPerformed(evt);
							}
						});
					}
					{
						btnRefreshDashboard = new JButton();
						pnlFilters.add(btnRefreshDashboard, "16, 2");
						btnRefreshDashboard.setText("Refresh Dashboard");
						btnRefreshDashboard.setFont(new java.awt.Font("Cambria",1,12));
						btnRefreshDashboard.setForeground(new java.awt.Color(64,0,64));
						btnRefreshDashboard.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								btnRefreshDashboardActionPerformed(evt);
							}
						});
					}
					{
						btnResetAllFilters = new JButton();
						pnlFilters.add(btnResetAllFilters, "16, 1");
						btnResetAllFilters.setText("Reset All Filters");
						btnResetAllFilters.setFont(new java.awt.Font("Cambria",1,12));
						btnResetAllFilters.setForeground(new java.awt.Color(64,0,64));
						btnResetAllFilters.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								btnResetAllFiltersActionPerformed(evt);
							}
						});
					}
					{
						btnApplyFilters = new JButton();
						pnlFilters.add(btnApplyFilters, "16, 0");
						btnApplyFilters.setText("Search All Records");
						btnApplyFilters.setFont(new java.awt.Font("Cambria",1,12));
						btnApplyFilters.setForeground(new java.awt.Color(64,0,64));
						btnApplyFilters.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								btnApplyFiltersActionPerformed(evt);
							}
						});
					}
				}
				{
					pnlDescriptionComments = new JPanel();
					TableLayout jPanel4Layout = new TableLayout(new double[][] {{TableLayout.FILL, TableLayout.FILL, 6.0, TableLayout.FILL, TableLayout.FILL, 6.0, TableLayout.FILL, TableLayout.FILL, 6.0, TableLayout.FILL, TableLayout.FILL, 6.0, TableLayout.FILL, TableLayout.FILL, 6.0}, {TableLayout.FILL}});
					jPanel4Layout.setHGap(5);
					jPanel4Layout.setVGap(5);
					pnlDescriptionComments.setLayout(jPanel4Layout);
					pnlContainer.add(pnlDescriptionComments, "1, 9, 9, 24");
					pnlDescriptionComments.setBackground(new java.awt.Color(125,190,255));
					pnlDescriptionComments.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(192,192,192), 2, true), "Records", TitledBorder.LEFT, TitledBorder.TOP, new java.awt.Font("Cambria",1,14)));
					{
						scrpnProblemRecords = new JScrollPane();
						pnlDescriptionComments.add(scrpnProblemRecords, "0, 0, 14, 0");
						scrpnProblemRecords.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0), "", TitledBorder.LEFT, TitledBorder.TOP));
						scrpnProblemRecords.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						scrpnProblemRecords.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
						{
							TableModel problemRecordsTable1Model =
									new CustomeTableModel(null,this.objResourceProvider.convertListToArray(this.objDashboardBean.getTableRecords().get(0)));
							tblProblemRecords = new JTable();
							this.tblProblemRecords.getTableHeader().setFont(new java.awt.Font("Cambria",1,14));
							this.tblProblemRecords.getTableHeader().setForeground(new java.awt.Color(64,0,64));
							this.tblProblemRecords.getTableHeader().setReorderingAllowed(false);;
							this.tblProblemRecords.setModel(problemRecordsTable1Model);
							scrpnProblemRecords.setViewportView(tblProblemRecords);
							tblProblemRecords.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
							tblProblemRecords.setShowHorizontalLines(true);
							tblProblemRecords.setShowVerticalLines(true);
							tblProblemRecords.setCellSelectionEnabled(true);
							tblProblemRecords.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
							tblProblemRecords.setSelectionBackground(new java.awt.Color(164,209,255));
							tblProblemRecords.setSelectionForeground(new java.awt.Color(64,0,64));
							tblProblemRecords.setFont(new java.awt.Font("SansSerif",0,14));
							tblProblemRecords.addMouseListener(new MouseAdapter() {
								public void mouseClicked(MouseEvent evt) {
									tblProblemRecordsMouseClicked(evt);
								}
							});
							tblProblemRecords.setModel(problemRecordsTable1Model);
						}
					}
				}
				{
					pnlHeader = new JPanel();
					TableLayout jPanel1Layout = new TableLayout(new double[][] {{10.0, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, 6.0, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, 15.0, 15.0, 6.0, TableLayout.FILL, 97.0, 3.0, TableLayout.FILL, 132.0, 6.0, TableLayout.FILL, TableLayout.FILL, 50.0, 6.0, TableLayout.FILL, 50.0, TableLayout.FILL, 6.0, 50.0, 3.0, 50.0, 50.0, 6.0}, {3.0, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, 3.0, TableLayout.FILL, TableLayout.FILL, 3.0}});
					jPanel1Layout.setHGap(5);
					jPanel1Layout.setVGap(5);
					pnlHeader.setLayout(jPanel1Layout);
					pnlContainer.add(pnlHeader, "0, 0, 10, 2");
					pnlHeader.setBackground(new java.awt.Color(34,145,255));
					pnlHeader.setBorder(BorderFactory.createCompoundBorder(
							new LineBorder(new java.awt.Color(128,0,128), 1, false),
							new LineBorder(new java.awt.Color(0,253,253), 2, true)));
					{
						lblHeaderLeft = new JLabel();
						pnlHeader.add(lblHeaderLeft, "1, 1, 4, 6");
						lblHeaderLeft.setText("Problem Management");
						lblHeaderLeft.setHorizontalTextPosition(SwingConstants.LEFT);
						lblHeaderLeft.setHorizontalAlignment(SwingConstants.LEFT);
						lblHeaderLeft.setFont(new java.awt.Font("Belgacom Bold",0,28));
						lblHeaderLeft.setForeground(new java.awt.Color(176,230,255));
					}
					{
						txtSearch = new JTextField();
						pnlHeader.add(txtSearch, "24, 4, 26, 6");
						txtSearch.setText("Search keyword");
						txtSearch.setFont(new java.awt.Font("Cambria",2,14));
						txtSearch.setForeground(new java.awt.Color(192,192,192));
						txtSearch.setBackground(new java.awt.Color(242,255,255));
						txtSearch.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
						txtSearch.setHorizontalAlignment(SwingConstants.CENTER);
						txtSearch.setEditable(true);
						txtSearch.addKeyListener(new KeyAdapter() {
							public void keyReleased(KeyEvent evt) {
								txtSearchKeyReleased(evt);
							}
							public void keyPressed(KeyEvent evt) {
								txtSearchKeyPressed(evt);
							}
						});
						txtSearch.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								txtSearchMouseClicked(evt);
							}
							public void mouseExited(MouseEvent evt) {
								txtSearchMouseExited(evt);
							}
							public void mouseEntered(MouseEvent evt) {
								txtSearchMouseEntered(evt);
							}
						});

					}
					{
						btnSearch = new JButton();
						pnlHeader.add(btnSearch, "28, 4, 29, 6");
						btnSearch.setText("Search");
						btnSearch.setFont(new java.awt.Font("Cambria",1,16));
						btnSearch.setForeground(new java.awt.Color(64,0,64));
						btnSearch.setEnabled(true);
						btnSearch.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								btnSearchActionPerformed(evt);
							}
						});
					}
					{
						lblHeader = new JLabel();
						pnlHeader.add(lblHeader, "6, 1, 22, 4");
						lblHeader.setText("Dashboard");
						lblHeader.setFont(new java.awt.Font("Baskerville Old Face",1,36));
						lblHeader.setForeground(new java.awt.Color(0,73,147));
						lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
						lblHeader.setHorizontalTextPosition(SwingConstants.CENTER);
						lblHeader.setBackground(new java.awt.Color(128,0,255));
					}
					{
						lblUserName = new JLabel();
						pnlHeader.add(lblUserName, "23, 1, 26, 2");
						lblUserName.setText("Welcome "+ this.objLoginBean.getFirstName());
						lblUserName.setHorizontalAlignment(SwingConstants.RIGHT);
						lblUserName.setFont(new java.awt.Font("Cambria",2,14));
						lblUserName.setForeground(new java.awt.Color(221,238,255));
						lblUserName.setHorizontalTextPosition(SwingConstants.CENTER);
					}
					{
						lblQCTDefectOverview = new JLabel();
						pnlHeader.add(lblQCTDefectOverview, "12, 5, 13, 6");
						lblQCTDefectOverview.setText("Defect Overview (QCT)");
						lblQCTDefectOverview.setHorizontalAlignment(SwingConstants.CENTER);
						lblQCTDefectOverview.setHorizontalTextPosition(SwingConstants.CENTER);
						lblQCTDefectOverview.setForeground(new java.awt.Color(206,255,255));
						lblQCTDefectOverview.setFont(new java.awt.Font("Cambria",0,16));
						lblQCTDefectOverview.addMouseListener(new MouseAdapter() {
							public void mouseExited(MouseEvent evt) {
								lblQCTDefectOverviewMouseExited(evt);
							}
							public void mouseClicked(MouseEvent evt) {
								lblQCTDefectOverviewMouseClicked(evt);
							}
							public void mouseEntered(MouseEvent evt) {
								lblQCTDefectOverviewMouseEntered(evt);
							}
						});
					}
					{
						lblHPSMProblemOverview = new JLabel();
						pnlHeader.add(lblHPSMProblemOverview, "15, 5, 16, 6");
						lblHPSMProblemOverview.setText("Problem Overview (HPSM)");
						lblHPSMProblemOverview.setHorizontalAlignment(SwingConstants.CENTER);
						lblHPSMProblemOverview.setHorizontalTextPosition(SwingConstants.CENTER);
						lblHPSMProblemOverview.setForeground(new java.awt.Color(206,255,255));
						lblHPSMProblemOverview.setFont(new java.awt.Font("Cambria",0,16));
						lblHPSMProblemOverview.addMouseListener(new MouseAdapter() {
							public void mouseExited(MouseEvent evt) {
								lblHPSMProblemOverviewMouseExited(evt);
							}
							public void mouseClicked(MouseEvent evt) {
								lblHPSMProblemOverviewMouseClicked(evt);
							}
							public void mouseEntered(MouseEvent evt) {
								lblHPSMProblemOverviewMouseEntered(evt);
							}
						});
					}
					{
						lblHPSMIncidentOverview = new JLabel();
						pnlHeader.add(lblHPSMIncidentOverview, "18, 5, 20, 6");
						lblHPSMIncidentOverview.setText("Incident Overview (HPSM)");
						lblHPSMIncidentOverview.setHorizontalAlignment(SwingConstants.CENTER);
						lblHPSMIncidentOverview.setHorizontalTextPosition(SwingConstants.CENTER);
						lblHPSMIncidentOverview.setForeground(new java.awt.Color(206,255,255));
						lblHPSMIncidentOverview.setFont(new java.awt.Font("Cambria",0,16));
						lblHPSMIncidentOverview.addMouseListener(new MouseAdapter() {
							public void mouseExited(MouseEvent evt) {
								lblHPSMIncidentOverviewMouseExited(evt);
							}
							public void mouseClicked(MouseEvent evt) {
								lblHPSMIncidentOverviewMouseClicked(evt);
							}
							public void mouseEntered(MouseEvent evt) {
								lblHPSMIncidentOverviewMouseEntered(evt);
							}
						});
					}
					{
						lblE2EProblemOverview = new JLabel();
						pnlHeader.add(lblE2EProblemOverview, "7, 5, 10, 6");
						lblE2EProblemOverview.setText("Problem Overview (E2E)");
						lblE2EProblemOverview.setHorizontalAlignment(SwingConstants.CENTER);
						lblE2EProblemOverview.setHorizontalTextPosition(SwingConstants.CENTER);
						lblE2EProblemOverview.setForeground(new java.awt.Color(206,255,255));
						lblE2EProblemOverview.setFont(new java.awt.Font("Cambria",0,16));
						lblE2EProblemOverview.addMouseListener(new MouseAdapter() {
							public void mouseExited(MouseEvent evt) {
								lblE2EProblemOverviewMouseExited(evt);
							}
							public void mouseClicked(MouseEvent evt) {
								lblE2EProblemOverviewMouseClicked(evt);
							}
							public void mouseEntered(MouseEvent evt) {
								lblE2EProblemOverviewMouseEntered(evt);
							}
						});
					}
					{
						lblChangePassword = new JLabel();
						pnlHeader.add(lblChangePassword, "28, 1, 29, 2");
						lblChangePassword.setText("Change Password");
						lblChangePassword.setHorizontalAlignment(SwingConstants.CENTER);
						lblChangePassword.setFont(new java.awt.Font("Cambria",1,12));
						lblChangePassword.setForeground(new java.awt.Color(206,255,255));
						lblChangePassword.setHorizontalTextPosition(SwingConstants.CENTER);
						lblChangePassword.addMouseListener(new MouseAdapter() {
							public void mouseExited(MouseEvent evt) {
								lblChangePasswordMouseExited(evt);
							}
							public void mouseEntered(MouseEvent evt) {
								lblChangePasswordMouseEntered(evt);
							}
							public void mouseClicked(MouseEvent evt) {
								lblChangePasswordMouseClicked(evt);
							}
						});
					}
				}
			}
		}
		pack();
		this.setSize(1621, 860);
	}

	private void cmbbxFirstFilterMouseEntered(MouseEvent evt) {
		try{
			if(!(this.objDashboardBean.isFirstFilterActiveFlag())){
				String selectedFilterItem = String.valueOf(this.cmbbxFirstFilter.getSelectedItem());
				this.objDashboardManager.cmbbxFirstFilterMouseEntered(selectedFilterItem);
				this.resetListModel(1);
				this.removeFilterItem(1);
				this.removeFilterItem(2);
				this.removeFilterItem(3);
				this.removeFilterItem(4);
				this.addFilterItem(1);
				this.addFilterItem(2);
				this.addFilterItem(3);
				this.addFilterItem(4);
			}else{
				this.removeFilterItem(1);
			}
		}catch(Exception eAll){
           this.otherExceptionHandling();
		}
	}

	private void cmbbxSecondFilterMouseEntered(MouseEvent evt) {
		try{
			if(!(this.objDashboardBean.isSecondFilterActiveFlag())){
				String selectedFilterItem = String.valueOf(this.cmbbxSecondFilter.getSelectedItem());
				this.objDashboardManager.cmbbxSecondFilterMouseEntered(selectedFilterItem);
				this.resetListModel(2);
				this.removeFilterItem(1);
				this.removeFilterItem(2);
				this.removeFilterItem(3);
				this.removeFilterItem(4);
				this.addFilterItem(1);
				this.addFilterItem(2);
				this.addFilterItem(3);
				this.addFilterItem(4);
			}else{
				this.removeFilterItem(2);
			}
		}catch(Exception eAll){
           this.otherExceptionHandling();
		}
	}

	private void cmbbxThirdFilterMouseEntered(MouseEvent evt) {
		try{
			if(!(this.objDashboardBean.isThirdFilterActiveFlag())){
				String selectedFilterItem = String.valueOf(this.cmbbxThirdFilter.getSelectedItem());
				this.objDashboardManager.cmbbxThirdFilterMouseEntered(selectedFilterItem);
				this.resetListModel(3);
				this.removeFilterItem(1);
				this.removeFilterItem(2);
				this.removeFilterItem(3);
				this.removeFilterItem(4);
				this.addFilterItem(1);
				this.addFilterItem(2);
				this.addFilterItem(3);
				this.addFilterItem(4);
			}else{
				this.removeFilterItem(3);
			}
		}catch(Exception eAll){
           this.otherExceptionHandling();
		}
	}

	private void cmbbxFourthFilterMouseEntered(MouseEvent evt) {
		try{
			if(!(this.objDashboardBean.isFourthFilterActiveFlag())){
				String selectedFilterItem = String.valueOf(this.cmbbxFourthFilter.getSelectedItem());
				this.objDashboardManager.cmbbxFourthFilterMouseEntered(selectedFilterItem);
				this.resetListModel(4);
				this.removeFilterItem(1);
				this.removeFilterItem(2);
				this.removeFilterItem(3);
				this.removeFilterItem(4);
				this.addFilterItem(1);
				this.addFilterItem(2);
				this.addFilterItem(3);
				this.addFilterItem(4);
			}else{
				this.removeFilterItem(4);
			}
		}catch(Exception eAll){
           this.otherExceptionHandling();
		}
	}

	private void cmbbxFirstFilterItemStateChanged(ItemEvent evt) {
		try{
			String selectedFilterItem = String.valueOf(this.cmbbxFirstFilter.getSelectedItem());
			this.objDashboardManager.cmbbxFirstFilterItemStateChanged(selectedFilterItem);
			this.addFilterItem(1);
			this.addFilterItem(2);
			this.addFilterItem(3);
			this.addFilterItem(4);
			this.resetListModel(1);
			this.setSearchAllRecordsButtonText();
		}catch(Exception eAll){
           this.otherExceptionHandling();
		}
	}

	private void cmbbxSecondFilterItemStateChanged(ItemEvent evt) {
		try{
			String selectedFilterItem = String.valueOf(this.cmbbxSecondFilter.getSelectedItem());
			this.objDashboardManager.cmbbxSecondFilterItemStateChanged(selectedFilterItem);
			this.addFilterItem(1);
			this.addFilterItem(2);
			this.addFilterItem(3);
			this.addFilterItem(4);
			this.resetListModel(2);
			this.setSearchAllRecordsButtonText();
		}catch(Exception eAll){
			eAll.printStackTrace();
           this.otherExceptionHandling();
		}
	}

	private void cmbbxThirdFilterItemStateChanged(ItemEvent evt) {
		try{
			String selectedFilterItem = String.valueOf(this.cmbbxThirdFilter.getSelectedItem());
			this.objDashboardManager.cmbbxThirdFilterItemStateChanged(selectedFilterItem);
			this.addFilterItem(1);
			this.addFilterItem(2);
			this.addFilterItem(3);
			this.addFilterItem(4);
			this.resetListModel(3);
			this.setSearchAllRecordsButtonText();
		}catch(Exception eAll){
           this.otherExceptionHandling();
		}
	}

	private void cmbbxFourthFilterItemStateChanged(ItemEvent evt) {
		try{
			String selectedFilterItem = String.valueOf(this.cmbbxFourthFilter.getSelectedItem());
			this.objDashboardManager.cmbbxFourthFilterItemStateChanged(selectedFilterItem);
			this.addFilterItem(1);
			this.addFilterItem(2);
			this.addFilterItem(3);
			this.addFilterItem(4);
			this.resetListModel(4);
			this.setSearchAllRecordsButtonText();
		}catch(Exception eAll){
           this.otherExceptionHandling();
		}
	}

	private void listFirstFilterValueChanged(ListSelectionEvent evt) {
		try{
			if(!(evt.getValueIsAdjusting())){
				if(!(this.listFirstFilter.getSelectedIndex() == -1)){
					this.objDashboardManager.listFirstFilterValueChanged(this.listFirstFilter.getSelectedValuesList());

					if(this.objDashboardBean.isSecondFilterActiveFlag() == false){
						this.resetComboxModel(2);
						this.resetListModel(2);
					}else{
						this.removeFilterItem(2);
					}

					if(this.objDashboardBean.isThirdFilterActiveFlag() == false){
						this.resetComboxModel(3);
						this.resetListModel(3);
					}else{
						this.removeFilterItem(3);
					}

					if(this.objDashboardBean.isFourthFilterActiveFlag() == false){
						this.resetComboxModel(4);
						this.resetListModel(4);
					}else{
						this.removeFilterItem(4);
					}
				}else{
					this.objDashboardBean.setFirstFilterActiveFlag(false);
					removeFilterItem(2);
					removeFilterItem(3);
					removeFilterItem(4);
					addFilterItem(2);
					addFilterItem(3);
					addFilterItem(4);
				}
				this.setSearchAllRecordsButtonText();
			}
		}catch(Exception eAll){
           this.otherExceptionHandling();
		}
	}

	private void listSecondFilterValueChanged(ListSelectionEvent evt) {
		try{
			if(!(evt.getValueIsAdjusting())){
				if(!(this.listSecondFilter.getSelectedIndex() == -1)){
					this.objDashboardManager.listSecondFilterValueChanged(this.listSecondFilter.getSelectedValuesList());
					if(this.objDashboardBean.isFirstFilterActiveFlag() == false){
						this.resetComboxModel(1);
						this.resetListModel(1);
					}else{
						this.removeFilterItem(1);
					}

					if(this.objDashboardBean.isThirdFilterActiveFlag() == false){
						this.resetComboxModel(3);
						this.resetListModel(3);
					}else{
						this.removeFilterItem(3);
					}

					if(this.objDashboardBean.isFourthFilterActiveFlag() == false){
						this.resetComboxModel(4);
						this.resetListModel(4);
					}else{
						this.removeFilterItem(4);
					}
				}else{
					this.objDashboardBean.setSecondFilterActiveFlag(false);
					removeFilterItem(1);
					removeFilterItem(3);
					removeFilterItem(4);
					addFilterItem(1);
					addFilterItem(3);
					addFilterItem(4);
				}
				this.setSearchAllRecordsButtonText();
			}
		}catch(Exception eAll){
           this.otherExceptionHandling();
		}
	}

	private void listThirdFilterValueChanged(ListSelectionEvent evt) {
		try{
			if(!(evt.getValueIsAdjusting())){
				if(!(this.listThirdFilter.getSelectedIndex() == -1)){
					this.objDashboardManager.listThirdFilterValueChanged(this.listThirdFilter.getSelectedValuesList());

					if(this.objDashboardBean.isFirstFilterActiveFlag() == false){
						this.resetComboxModel(1);
						this.resetListModel(1);
					}else{
						this.removeFilterItem(1);
					}

					if(this.objDashboardBean.isSecondFilterActiveFlag() == false){
						this.resetComboxModel(2);
						this.resetListModel(2);
					}else{
						this.removeFilterItem(2);
					}

					if(this.objDashboardBean.isFourthFilterActiveFlag() == false){
						this.resetComboxModel(4);
						this.resetListModel(4);
					}else{
						this.removeFilterItem(4);
					}

				}else{
					this.objDashboardBean.setThirdFilterActiveFlag(false);
					removeFilterItem(1);
					removeFilterItem(2);
					removeFilterItem(4);
					addFilterItem(1);
					addFilterItem(2);
					addFilterItem(4);
				}
				this.setSearchAllRecordsButtonText();
			}
		}catch(Exception eAll){
           this.otherExceptionHandling();
		}
	}

	private void listFourthFilterValueChanged(ListSelectionEvent evt) {
		try{
			if(!(evt.getValueIsAdjusting())){
				if(!(this.listFourthFilter.getSelectedIndex() == -1)){
					this.objDashboardManager.listFourthFilterValueChanged(this.listFourthFilter.getSelectedValuesList());

					if(this.objDashboardBean.isFirstFilterActiveFlag() == false){
						this.resetComboxModel(1);
						this.resetListModel(1);
					}else{
						this.removeFilterItem(1);
					}

					if(this.objDashboardBean.isSecondFilterActiveFlag() == false){
						this.resetComboxModel(2);
						this.resetListModel(2);
					}else{
						this.removeFilterItem(2);
					}

					if(this.objDashboardBean.isThirdFilterActiveFlag() == false){
						this.resetComboxModel(3);
						this.resetListModel(3);
					}else{
						this.removeFilterItem(3);
					}
				}else{
					this.objDashboardBean.setFourthFilterActiveFlag(false);
					removeFilterItem(1);
					removeFilterItem(2);
					removeFilterItem(3);
					addFilterItem(1);
					addFilterItem(2);
					addFilterItem(3);
				}
				this.setSearchAllRecordsButtonText();
			}
		}catch(Exception eAll){
           this.otherExceptionHandling();
		}
	}

	private void lblE2EProblemOverviewMouseEntered(MouseEvent evt) {
		lblE2EProblemOverview.setForeground(new java.awt.Color(0,0,255));
		lblE2EProblemOverview.setFont(new java.awt.Font("Cambria",2,16));
	}

	private void lblE2EProblemOverviewMouseExited(MouseEvent evt) {
		lblE2EProblemOverview.setForeground(new java.awt.Color(206,255,255));
		lblE2EProblemOverview.setFont(new java.awt.Font("Cambria",0,16));
	}

	private void lblE2EProblemOverviewMouseClicked(MouseEvent evt) {
		try{
			this.objProblemOverviewE2EWindow.setVisible(true);
			this.objProblemOverviewE2EWindow.setExtendedState(MAXIMIZED_BOTH);
		}catch(NullPointerException eNull){
			this.objProblemOverviewE2EWindow = new ProblemOverviewE2EWindow(this);
			this.objProblemOverviewE2EWindow.setVisible(true);
			this.objProblemOverviewE2EWindow.setExtendedState(MAXIMIZED_BOTH);
		}
	}

	private void lblQCTDefectOverviewMouseEntered(MouseEvent evt) {
		lblQCTDefectOverview.setForeground(new java.awt.Color(0,0,255));
		lblQCTDefectOverview.setFont(new java.awt.Font("Cambria",2,16));
	}

	private void lblQCTDefectOverviewMouseExited(MouseEvent evt) {
		lblQCTDefectOverview.setForeground(new java.awt.Color(206,255,255));
		lblQCTDefectOverview.setFont(new java.awt.Font("Cambria",0,16));
	}

	private void lblQCTDefectOverviewMouseClicked(MouseEvent evt) {
		try{
			this.objDefectOverviewQCTWindow.setVisible(true);
			this.objDefectOverviewQCTWindow.setExtendedState(MAXIMIZED_BOTH);
		}catch(NullPointerException eNull){
			this.objDefectOverviewQCTWindow = new DefectOverviewQCTWindow(this);
			this.objDefectOverviewQCTWindow.setVisible(true);
			this.objDefectOverviewQCTWindow.setExtendedState(MAXIMIZED_BOTH);
		}
	}

	private void lblHPSMProblemOverviewMouseEntered(MouseEvent evt) {
		lblHPSMProblemOverview.setForeground(new java.awt.Color(0,0,255));
		lblHPSMProblemOverview.setFont(new java.awt.Font("Cambria",2,16));
	}

	private void lblHPSMProblemOverviewMouseExited(MouseEvent evt) {
		lblHPSMProblemOverview.setForeground(new java.awt.Color(206,255,255));
		lblHPSMProblemOverview.setFont(new java.awt.Font("Cambria",0,16));
	}

	private void lblHPSMProblemOverviewMouseClicked(MouseEvent evt) {
		try{
			this.objProblemOverviewHPSMWindow.setVisible(true);
			this.objProblemOverviewHPSMWindow.setExtendedState(MAXIMIZED_BOTH);
		}catch(NullPointerException eNull){
			this.objProblemOverviewHPSMWindow = new ProblemOverviewHPSMWindow(this);
			this.objProblemOverviewHPSMWindow.setVisible(true);
			this.objProblemOverviewHPSMWindow.setExtendedState(MAXIMIZED_BOTH);
		}
	}

	private void lblHPSMIncidentOverviewMouseEntered(MouseEvent evt) {
		lblHPSMIncidentOverview.setForeground(new java.awt.Color(0,0,255));
		lblHPSMIncidentOverview.setFont(new java.awt.Font("Cambria",2,16));
	}

	private void lblHPSMIncidentOverviewMouseExited(MouseEvent evt) {
		lblHPSMIncidentOverview.setForeground(new java.awt.Color(206,255,255));
		lblHPSMIncidentOverview.setFont(new java.awt.Font("Cambria",0,16));
	}

	private void lblHPSMIncidentOverviewMouseClicked(MouseEvent evt) {
		try{
			this.objIncidentOverviewHPSMWindow.setVisible(true);
			this.objIncidentOverviewHPSMWindow.setExtendedState(MAXIMIZED_BOTH);
		}catch(NullPointerException eNull){
			this.objIncidentOverviewHPSMWindow = new IncidentOverviewHPSMWindow(this);
			this.objIncidentOverviewHPSMWindow.setVisible(true);
			this.objIncidentOverviewHPSMWindow.setExtendedState(MAXIMIZED_BOTH);
		}
	}

	private void initBeanComponent(){
    	try{
			Connection objConnection = this.objResourceProvider.getDatabaseConnection("E2ETracker");
			this.objDashboardManager.initBeanComponentDefaultValue(objConnection);
			this.objResourceProvider.closeDatabaseConnection(objConnection, false, true);
		}catch(Exception eAll){
           this.otherExceptionHandling();
		}
    }

	private void resetComboxModel(int filterSequence){
		ComboBoxModel<String> objComboBoxModel = null;
		if(filterSequence == 1){
			objComboBoxModel = new DefaultComboBoxModel<String>(this.objResourceProvider.convertListToArray(this.objDashboardBean.getFirstFilterComboBoxAllItems()));
			this.cmbbxFirstFilter.setModel(objComboBoxModel);
		}else if(filterSequence == 2){
			objComboBoxModel = new DefaultComboBoxModel<String>(this.objResourceProvider.convertListToArray(this.objDashboardBean.getSecondFilterComboBoxAllItems()));
			this.cmbbxSecondFilter.setModel(objComboBoxModel);
		}else if(filterSequence == 3){
			objComboBoxModel = new DefaultComboBoxModel<String>(this.objResourceProvider.convertListToArray(this.objDashboardBean.getThirdFilterComboBoxAllItems()));
			this.cmbbxThirdFilter.setModel(objComboBoxModel);
		}else{
			objComboBoxModel = new DefaultComboBoxModel<String>(this.objResourceProvider.convertListToArray(this.objDashboardBean.getFourthFilterComboBoxAllItems()));
			this.cmbbxFourthFilter.setModel(objComboBoxModel);
		}
	}

	private void resetListModel(int filterSequence){
		ListModel<String> objListBoxModel = null;
		if(filterSequence == 1){
			objListBoxModel = new DefaultComboBoxModel<String>(this.objResourceProvider.convertListToArray(this.objDashboardBean.getFirstFilterJListAllItems()));
			this.listFirstFilter.setModel(objListBoxModel);
		}else if(filterSequence == 2){
			objListBoxModel = new DefaultComboBoxModel<String>(this.objResourceProvider.convertListToArray(this.objDashboardBean.getSecondFilterJListAllItems()));
			this.listSecondFilter.setModel(objListBoxModel);
		}else if(filterSequence == 3){
			objListBoxModel = new DefaultComboBoxModel<String>(this.objResourceProvider.convertListToArray(this.objDashboardBean.getThirdFilterJListAllItems()));
			this.listThirdFilter.setModel(objListBoxModel);
		}else{
			objListBoxModel = new DefaultComboBoxModel<String>(this.objResourceProvider.convertListToArray(this.objDashboardBean.getFourthFilterJListAllItems()));
			this.listFourthFilter.setModel(objListBoxModel);
		}
	}

	private void removeFilterItem(int filterSequence){
		if(filterSequence == 1){
			List<Integer> removalFilterItem = this.objDashboardManager.removalListFromFilterItems(1);
			int size = removalFilterItem.size();
			if(size > 0){
				for(int i = 0; i < size; i++){
					this.cmbbxFirstFilter.removeItemAt(removalFilterItem.get(i));
				}
			}
		}else if(filterSequence == 2){
			List<Integer> removalFilterItem = this.objDashboardManager.removalListFromFilterItems(2);
			int size = removalFilterItem.size();
			if(size > 0){
				for(int i = 0; i < size; i++){
					this.cmbbxSecondFilter.removeItemAt(removalFilterItem.get(i));
				}
			}
		}else if(filterSequence == 3){
			List<Integer> removalFilterItem = this.objDashboardManager.removalListFromFilterItems(3);
			int size = removalFilterItem.size();
			if(size > 0){
				for(int i = 0; i < size; i++){
					this.cmbbxThirdFilter.removeItemAt(removalFilterItem.get(i));
				}
			}
		}else{
			List<Integer> removalFilterItem = this.objDashboardManager.removalListFromFilterItems(4);
			int size = removalFilterItem.size();
			if(size > 0){
				for(int i = 0; i < size; i++){
					this.cmbbxFourthFilter.removeItemAt(removalFilterItem.get(i));
				}
			}
		}

	}

	private void addFilterItem(int filterSequence){
		if(filterSequence == 1){
			List<String> addFilterItem = this.objDashboardManager.addListForFilterItem(1);
			int size = addFilterItem.size();
			if(size > 0){
				for(int i = 0; i < size; i++){
					this.cmbbxFirstFilter.addItem(addFilterItem.get(i));
				}
			}
		}else if(filterSequence == 2){
			List<String> addFilterItem = this.objDashboardManager.addListForFilterItem(2);
			int size = addFilterItem.size();
			if(size > 0){
				for(int i = 0; i < size; i++){
					this.cmbbxSecondFilter.addItem(addFilterItem.get(i));
				}
			}
		}else if(filterSequence == 3){
			List<String> addFilterItem = this.objDashboardManager.addListForFilterItem(3);
			int size = addFilterItem.size();
			if(size > 0){
				for(int i = 0; i < size; i++){
					this.cmbbxThirdFilter.addItem(addFilterItem.get(i));
				}
			}
		}else{
			List<String> addFilterItem = this.objDashboardManager.addListForFilterItem(4);
			int size = addFilterItem.size();
			if(size > 0){
				for(int i = 0; i < size; i++){
					this.cmbbxFourthFilter.addItem(addFilterItem.get(i));
				}
			}
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

	private void btnApplyFiltersActionPerformed(ActionEvent evt) {
		try{
			Connection objConnection = this.objResourceProvider.getDatabaseConnection("E2ETracker");
			this.objDashboardManager.btnApplyFiltersActionPerformed(objConnection, true);
			this.objResourceProvider.closeDatabaseConnection(objConnection, false, true);
			this.setTableModel();
		}catch(ManagerException eman){
			managerExceptionHandling(eman);
		}catch(Exception e){
			this.otherExceptionHandling();
		}

	}

	private void setTableModel(){
		List<List<String>> recordList = new ArrayList<List<String>>();

		TableModel problemRecordsTable1Model = null;
		if(this.objDashboardBean.getTableRecords().size()>1){
			for(int i=1; i<this.objDashboardBean.getTableRecords().size(); i++){
				recordList.add(this.objDashboardBean.getTableRecords().get(i));
			}
			problemRecordsTable1Model =
					new CustomeTableModel(this.objResourceProvider.convertListOfListToMultiDimArray(recordList),
							this.objResourceProvider.convertListToArray(this.objDashboardBean.getTableRecords().get(0)));
		}else{
			problemRecordsTable1Model =
					new DefaultTableModel(null,this.objResourceProvider.convertListToArray(this.objDashboardBean.getTableRecords().get(0)));
		}

		this.tblProblemRecords.getTableHeader().setFont(new java.awt.Font("Cambria",1,14));
		this.tblProblemRecords.getTableHeader().setForeground(new java.awt.Color(64,0,64));
		this.tblProblemRecords.setModel(problemRecordsTable1Model);
		this.tblProblemRecords.setRowHeight(143);

		for(int i=0; i<tblProblemRecords.getColumnCount();i++){
			this.tblProblemRecords.getColumnModel().getColumn(i).setCellRenderer(new CustomTableCellRender());
			this.tblProblemRecords.getColumnModel().getColumn(i).setCellEditor(new CustomeCellEditor());
			if(i == 12 || i == 17 ||i == 18 ||i == 19||i == 20){
				this.tblProblemRecords.getColumnModel().getColumn(i).setPreferredWidth(170);
			}else if (i == 13 || i == 14 ||i == 15 ||i == 16){
				this.tblProblemRecords.getColumnModel().getColumn(i).setPreferredWidth(400);

			}else{
				this.tblProblemRecords.getColumnModel().getColumn(i).setPreferredWidth(130);

			}
		}
	}

	private void setSearchAllRecordsButtonText(){
		if(this.objDashboardBean.isFirstFilterActiveFlag() ||
				this.objDashboardBean.isSecondFilterActiveFlag()||
				this.objDashboardBean.isThirdFilterActiveFlag()||
				this.objDashboardBean.isFourthFilterActiveFlag()){
			btnApplyFilters.setText("Search With Filters");
		}else{
			this.btnApplyFilters.setText("Search All Records");
		}
	}

	private void btnSearchActionPerformed(ActionEvent evt) {
		try{
			Connection objConnection = this.objResourceProvider.getDatabaseConnection("E2ETracker");
			this.objDashboardManager.btnSearchDefectActionPerformed(objConnection, this.txtSearch.getText());
			this.objDashboardManager.cmbbxFirstFilterItemStateChanged("--Select Filter--");
			this.objDashboardManager.cmbbxSecondFilterItemStateChanged("--Select Filter--");
			this.objDashboardManager.cmbbxThirdFilterItemStateChanged("--Select Filter--");
			this.objDashboardManager.cmbbxFourthFilterItemStateChanged("--Select Filter--");
			this.resetComboxModel(1);
			this.resetComboxModel(2);
			this.resetComboxModel(3);
			this.resetComboxModel(4);
			this.resetListModel(1);
			this.resetListModel(2);
			this.resetListModel(3);
			this.resetListModel(4);
			this.objResourceProvider.closeDatabaseConnection(objConnection, false, true);
			this.setTableModel();
		}catch(ManagerException eman){
			managerExceptionHandling(eman);
		}catch(Exception e){
			this.otherExceptionHandling();
		}
	}

	private void txtSearchMouseEntered(MouseEvent evt) {
		if (this.objResourceProvider.compareString(this.txtSearch.getText(), "Search keyword")){
			this.txtSearch.setText("");
			this.txtSearch.setFont(new java.awt.Font("Cambria",0,14));
			this.txtSearch.setForeground(new java.awt.Color(64,0,64));
		}
	}

	private void txtSearchMouseExited(MouseEvent evt) {
		 if(this.objResourceProvider.compareString(this.txtSearch.getText(), "")){
			this.txtSearch.setText("Search keyword");
			this.txtSearch.setFont(new java.awt.Font("Cambria",0,14));
			this.txtSearch.setForeground(new java.awt.Color(192,192,192));
		}
	}

	private void txtSearchMouseClicked(MouseEvent evt) {
		this.txtSearch.setFont(new java.awt.Font("Cambria",0,14));
		this.txtSearch.setForeground(new java.awt.Color(64,0,64));
	}

	private void txtSearchKeyPressed(KeyEvent evt) {
		if (this.objResourceProvider.compareString(this.txtSearch.getText(), "Search keyword")){
			this.txtSearch.setText("");
			this.txtSearch.setFont(new java.awt.Font("Cambria",0,14));
			this.txtSearch.setForeground(new java.awt.Color(64,0,64));
		}
	}

	private void txtSearchKeyReleased(KeyEvent evt) {
		if(this.objResourceProvider.compareString(this.txtSearch.getText(), "")){
			this.txtSearch.setText("Search keyword");
			this.txtSearch.setFont(new java.awt.Font("Cambria",0,14));
			this.txtSearch.setForeground(new java.awt.Color(192,192,192));
		}
	}

	private void btnResetAllFiltersActionPerformed(ActionEvent evt) {
		this.objDashboardManager.cmbbxFirstFilterItemStateChanged("--Select Filter--");
		this.objDashboardManager.cmbbxSecondFilterItemStateChanged("--Select Filter--");
		this.objDashboardManager.cmbbxThirdFilterItemStateChanged("--Select Filter--");
		this.objDashboardManager.cmbbxFourthFilterItemStateChanged("--Select Filter--");
		this.resetComboxModel(1);
		this.resetComboxModel(2);
		this.resetComboxModel(3);
		this.resetComboxModel(4);
		this.resetListModel(1);
		this.resetListModel(2);
		this.resetListModel(3);
		this.resetListModel(4);
	}

	private void tblProblemRecordsMouseClicked(MouseEvent evt) {
		try{
			int row = this.tblProblemRecords.rowAtPoint(evt.getPoint());
		    int col = this.tblProblemRecords.columnAtPoint(evt.getPoint());
		    System.out.println(col);
		    if(col == 4){
		    	//Defect Window QCT
		    	String defectId = (String)this.tblProblemRecords.getModel().getValueAt(row, col);
		    	if(defectId == null || this.objResourceProvider.compareString(defectId, "")){
		    		throw new ManagerException(1000, "I", "Application Message", "No Defect ID linked with selected issue.");
		    	}else{
		    		try{
		    			this.objDefectOverviewQCTWindow.prepareDefectOverviewWindow(defectId);
				    	this.objDefectOverviewQCTWindow.setVisible(true);
				    	this.objDefectOverviewQCTWindow.setExtendedState(MAXIMIZED_BOTH);
		    		}catch(NullPointerException eNull){
		    			DefectOverviewQCTWindow objDefectOverviewQCTWindow = new DefectOverviewQCTWindow(this);
		    			this.objDefectOverviewQCTWindow = objDefectOverviewQCTWindow;
		    			this.objDefectOverviewQCTWindow.prepareDefectOverviewWindow(defectId);
				    	this.objDefectOverviewQCTWindow.setVisible(true);
				    	this.objDefectOverviewQCTWindow.setExtendedState(MAXIMIZED_BOTH);
		    		}

		    	}
		    }else if(col == 5){
		    	//Incident Window HPSM
		    	String incidentId = (String)this.tblProblemRecords.getModel().getValueAt(row, col);
		    	if(incidentId == null || this.objResourceProvider.compareString(incidentId, "")){
		    		throw new ManagerException(1000, "I", "Application Message", "No Incident ID linked with selected issue.");
		    	}else{
		    		try{
		    			this.objIncidentOverviewHPSMWindow.prepareIncidentOverviewHPSMWindow(incidentId);
			    		this.objIncidentOverviewHPSMWindow.setVisible(true);
						this.objIncidentOverviewHPSMWindow.setExtendedState(MAXIMIZED_BOTH);
		    		}catch(NullPointerException eNull){
		    			IncidentOverviewHPSMWindow objIncidentOverviewHPSMWindow = new IncidentOverviewHPSMWindow(this);
		    			this.objIncidentOverviewHPSMWindow = objIncidentOverviewHPSMWindow;
		    			this.objIncidentOverviewHPSMWindow.prepareIncidentOverviewHPSMWindow(incidentId);
			    		this.objIncidentOverviewHPSMWindow.setVisible(true);
						this.objIncidentOverviewHPSMWindow.setExtendedState(MAXIMIZED_BOTH);
		    		}
		    	}
		    }else if(col == 6){
		    	//Problem Window HPSM
		    	String problemId = (String)this.tblProblemRecords.getModel().getValueAt(row, col);
		    	if(problemId == null || this.objResourceProvider.compareString(problemId, "")){
		    		throw new ManagerException(1000, "I", "Application Message", "No Problem ID linked with selected issue.");
		    	}else{
		    		try{
		    			this.objProblemOverviewHPSMWindow.prepareProblemOverviewHPSMWindow(problemId);
				    	this.objProblemOverviewHPSMWindow.setVisible(true);
				    	this.objProblemOverviewHPSMWindow.setExtendedState(MAXIMIZED_BOTH);
		    		}catch(NullPointerException eNull){
		    			ProblemOverviewHPSMWindow objProblemOverviewHPSMWindow = new ProblemOverviewHPSMWindow(this);
		    			this.objProblemOverviewHPSMWindow = objProblemOverviewHPSMWindow;
		    			this.objProblemOverviewHPSMWindow.prepareProblemOverviewHPSMWindow(problemId);
				    	this.objProblemOverviewHPSMWindow.setVisible(true);
				    	this.objProblemOverviewHPSMWindow.setExtendedState(MAXIMIZED_BOTH);
		    		}

		    	}
		    }else{
		    	String trackerId = (String)this.tblProblemRecords.getModel().getValueAt(row, 0);
	    		try{
	    			this.objProblemOverviewE2EWindow.setCmbbxUpdateExixtingProblem(trackerId);
			    	this.objProblemOverviewE2EWindow.setVisible(true);
			    	this.objProblemOverviewE2EWindow.setExtendedState(MAXIMIZED_BOTH);
	    		}catch(NullPointerException eNull){
	    			ProblemOverviewE2EWindow objProblemOverviewE2EWindow = new ProblemOverviewE2EWindow(this);
	    			this.objProblemOverviewE2EWindow = objProblemOverviewE2EWindow;
	    			this.objProblemOverviewE2EWindow.setCmbbxUpdateExixtingProblem(trackerId);
			    	this.objProblemOverviewE2EWindow.setVisible(true);
			    	this.objProblemOverviewE2EWindow.setExtendedState(MAXIMIZED_BOTH);
	    		}
		    }
		}catch(ManagerException eman){
			managerExceptionHandling(eman);
		}catch(Exception e){
			this.otherExceptionHandling();
		}
	}

	private void btnExportAsExcelActionPerformed(ActionEvent evt) {
		try{
			if(this.objResourceProvider.generateExcelFile(this.objDashboardBean.getTableRecords(), "E2ETracker.xlsx")){
	            JOptionPane.showMessageDialog(this, "Excel File: 'E2ETracker.xlsx' successfully generated.", "Application Message",JOptionPane.INFORMATION_MESSAGE);
			}
		}catch(ManagerException eman){
			managerExceptionHandling(eman);
		}catch(Exception e){
			this.otherExceptionHandling();
		}
	}

	private void btnRefreshDashboardActionPerformed(ActionEvent evt) {
		this.resetDashboard();
	}

	protected void resetDashboard(){
		try{
			Connection objLocalConnection = this.objResourceProvider.getDatabaseConnection("E2ETracker");
			txtSearch.setText("Search keyword");
			txtSearch.setFont(new java.awt.Font("Cambria",2,14));
			txtSearch.setForeground(new java.awt.Color(192,192,192));
			this.objDashboardBean.setFirstFilterActiveFlag(false);
			this.objDashboardBean.setSecondFilterActiveFlag(false);
			this.objDashboardBean.setThirdFilterActiveFlag(false);
			this.objDashboardBean.setFourthFilterActiveFlag(false);
			this.objDashboardManager.cmbbxFirstFilterItemStateChanged("--Select Filter--");
			this.objDashboardManager.cmbbxSecondFilterItemStateChanged("--Select Filter--");
			this.objDashboardManager.cmbbxThirdFilterItemStateChanged("--Select Filter--");
			this.objDashboardManager.cmbbxFourthFilterItemStateChanged("--Select Filter--");
			this.resetComboxModel(1);
			this.resetComboxModel(2);
			this.resetComboxModel(3);
			this.resetComboxModel(4);
			this.resetListModel(1);
			this.resetListModel(2);
			this.resetListModel(3);
			this.resetListModel(4);
			this.objDashboardManager.btnApplyFiltersActionPerformed(objLocalConnection, false);
			this.objResourceProvider.closeDatabaseConnection(objLocalConnection, false, true);
			this.setTableModel();
		}catch(ManagerException eman){
			managerExceptionHandling(eman);
		}catch(Exception e){
			this.otherExceptionHandling();
		}
	}

	private void otherExceptionHandling(){
		JOptionPane.showMessageDialog(this, "Unknown error encountered by application. Please contact administrator.", "Application Error", JOptionPane.ERROR_MESSAGE);
		this.resetDashboard();
	}

	private void managerExceptionHandling(ManagerException eMan){
		if(this.objResourceProvider.compareString(eMan.getErrorType(), "I")){
            JOptionPane.showMessageDialog(this, eMan.getErrorMessage(), eMan.getErrorName(),JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, eMan.getErrorMessage(), eMan.getErrorName(), JOptionPane.ERROR_MESSAGE);
        }
	}

	protected final ProblemOverviewE2EWindow getObjProblemOverviewE2EWindow() {
		return objProblemOverviewE2EWindow;
	}

	protected final ProblemOverviewHPSMWindow getObjProblemOverviewHPSMWindow() {
		return objProblemOverviewHPSMWindow;
	}

	protected final DefectOverviewQCTWindow getObjDefectOverviewQCTWindow() {
		return objDefectOverviewQCTWindow;
	}

	protected final IncidentOverviewHPSMWindow getObjIncidentOverviewHPSMWindow() {
		return objIncidentOverviewHPSMWindow;
	}

	protected final ResourceProvider getObjResourceProvider() {
		return objResourceProvider;
	}

	protected final LoginBean getObjLoginBean() {
		return objLoginBean;
	}

	protected final DashboardBean getObjDashboardBean() {
		return objDashboardBean;
	}

	protected final DashboardManager getObjDashboardManager() {
		return objDashboardManager;
	}

	protected final void setObjProblemOverviewE2EWindow(
			ProblemOverviewE2EWindow objProblemOverviewE2EWindow) {
		this.objProblemOverviewE2EWindow = objProblemOverviewE2EWindow;
	}

	protected final void setObjProblemOverviewHPSMWindow(
			ProblemOverviewHPSMWindow objProblemOverviewHPSMWindow) {
		this.objProblemOverviewHPSMWindow = objProblemOverviewHPSMWindow;
	}

	protected final void setObjDefectOverviewQCTWindow(
			DefectOverviewQCTWindow objDefectOverviewQCTWindow) {
		this.objDefectOverviewQCTWindow = objDefectOverviewQCTWindow;
	}

	protected final void setObjIncidentOverviewHPSMWindow(
			IncidentOverviewHPSMWindow objIncidentOverviewHPSMWindow) {
		this.objIncidentOverviewHPSMWindow = objIncidentOverviewHPSMWindow;
	}

	private void dashboardWindowClosing(WindowEvent evt){
		if (JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Application Message",
		        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			if(this.objProblemOverviewE2EWindow != null && this.problemWindowE2EFlag){
				this.objProblemOverviewE2EWindow.setVisible(true);
				this.objProblemOverviewE2EWindow.setExtendedState(Frame.MAXIMIZED_BOTH);
				this.objProblemOverviewE2EWindow.problemOverviewE2EWindowClosingProcess(true);
			}else{
				if(this.objDefectOverviewQCTWindow != null){
					this.objDefectOverviewQCTWindow.dispose();
				}

				if(this.objProblemOverviewHPSMWindow != null){
					this.objProblemOverviewHPSMWindow.dispose();
				}

				if(this.objIncidentOverviewHPSMWindow != null){
					this.objIncidentOverviewHPSMWindow.dispose();
				}

				if(this.objProblemOverviewE2EWindow != null){
					this.objProblemOverviewE2EWindow.dispose();
				}

				this.dispose();
			}
		}
	}

	protected final boolean isProblemWindowE2EFlag() {
		return problemWindowE2EFlag;
	}

	protected final void setProblemWindowE2EFlag(boolean problemWindowE2EFlag) {
		this.problemWindowE2EFlag = problemWindowE2EFlag;
	}

	private void lblChangePasswordMouseClicked(MouseEvent evt) {
		try{
			this.objUpdateProfileDetailsWindow.setVisible(true);
		}catch(NullPointerException eNull){
			UpdateProfileDetailsWindow objUpdateProfileDetailsWindow = new UpdateProfileDetailsWindow(this);
			objUpdateProfileDetailsWindow.setVisible(true);
			this.objUpdateProfileDetailsWindow = objUpdateProfileDetailsWindow;
		}

		this.setVisible(false);

		try{
			this.objDefectOverviewQCTWindow.setVisible(false);
		}catch(NullPointerException eNull){}

		try{
			this.objProblemOverviewE2EWindow.setVisible(false);
		}catch(NullPointerException eNull){}

		try{
			this.objProblemOverviewHPSMWindow.setVisible(false);
		}catch(NullPointerException eNull){}

		try{
			this.objIncidentOverviewHPSMWindow.setVisible(false);
		}catch(NullPointerException eNull){}
	}

	private void lblChangePasswordMouseEntered(MouseEvent evt) {
		lblChangePassword.setForeground(new java.awt.Color(0,0,255));
		lblChangePassword.setFont(new java.awt.Font("Cambria",2,12));
	}

	private void lblChangePasswordMouseExited(MouseEvent evt) {
		lblChangePassword.setForeground(new java.awt.Color(206,255,255));
		lblChangePassword.setFont(new java.awt.Font("Cambria",0,12));
	}

}
