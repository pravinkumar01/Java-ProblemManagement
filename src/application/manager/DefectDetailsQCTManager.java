package application.manager;

import java.sql.Connection;

import application.beans.DefectOverviewBean;
import application.exceptions.ManagerException;
import application.exceptions.PersistenceException;
import application.frames.ResourceProvider;
import application.persistence.DefectOverviewQCTPersistence;

public class DefectDetailsQCTManager {

	private final ResourceProvider objResourceProvider;
	private final DefectOverviewBean objDefectOverviewBean;
	private final DefectOverviewQCTPersistence objDefectDetailsPersistence;

	public DefectDetailsQCTManager(ResourceProvider objResourceProvider, DefectOverviewBean objDefectOverviewBean) {
		this.objResourceProvider = objResourceProvider;
		this.objDefectOverviewBean =  objDefectOverviewBean;
		this.objDefectDetailsPersistence = new DefectOverviewQCTPersistence();
	}

	public void actionSearch(Connection objQCTConnection, String defectId) throws ManagerException{
		try{
			String[] dbResultDefectDetails = null;
			if(this.verifyE2EDefectId(objQCTConnection, defectId)){
				dbResultDefectDetails = objDefectDetailsPersistence.fetchE2EDefectDetails(objQCTConnection, defectId);
				objDefectOverviewBean.setE2EDefect(true);
			}else{
				if(this.verifyV1DefectId(objQCTConnection, defectId)){
					dbResultDefectDetails = objDefectDetailsPersistence.fetchV1DefectDetails(objQCTConnection, defectId);
					objDefectOverviewBean.setE2EDefect(false);
				}else{
					throw new ManagerException(1001, "I", "Application Meaasge", "Defect not found in E2E or V1 Project. Please verify Defect ID.");
				}
			}
			objDefectOverviewBean.setDefectId(dbResultDefectDetails[0]);//Defect ID
			objDefectOverviewBean.setSummary(dbResultDefectDetails[1]);//Summary
			objDefectOverviewBean.setApplication(dbResultDefectDetails[2]);//Application
			objDefectOverviewBean.setEnvironment(dbResultDefectDetails[3]);//Environment
			objDefectOverviewBean.setPriority(dbResultDefectDetails[4]);//Priority
			objDefectOverviewBean.setBusinessRisk(dbResultDefectDetails[5]);//BusinessRisk SEVERITY
			objDefectOverviewBean.setProjectId(dbResultDefectDetails[6]);//ProjectId INVESTIGATION_PRIORITY
			objDefectOverviewBean.setDetectedInRelease(dbResultDefectDetails[7]);//DetectedInRelease PROJECT
			objDefectOverviewBean.setDetectedInTestStage(dbResultDefectDetails[8]);//DetectedInTestStage PILOT_IMPACT
			objDefectOverviewBean.setDetectedInVersion(dbResultDefectDetails[9]);//DetectedInVersion
			objDefectOverviewBean.setFlow(dbResultDefectDetails[10]);//Flow WORKAROUND
			objDefectOverviewBean.setDetectedBy(dbResultDefectDetails[11]);//DetectedBy
			objDefectOverviewBean.setAssignedTo(dbResultDefectDetails[12]);//AssignedTo
			objDefectOverviewBean.setStatus(dbResultDefectDetails[13]);//Status
			objDefectOverviewBean.setDetectedOnDate(dbResultDefectDetails[14]);//DetectedOnDate
			objDefectOverviewBean.setEstimatedFixDate(dbResultDefectDetails[15]);//EstimatedFixDate
			objDefectOverviewBean.setProdBugFixDate(dbResultDefectDetails[16]);//ProdBugFixDate MODIFIED
			objDefectOverviewBean.setClosingDate(dbResultDefectDetails[17]);//ClosingDate
			objDefectOverviewBean.setDescription(correctFontInDescAndComm(dbResultDefectDetails[18]));//Description
			objDefectOverviewBean.setComments(correctFontInDescAndComm(dbResultDefectDetails[19]));//Comments
		}catch(PersistenceException ePer){
			throw new ManagerException(1000, ePer.getErrorType(), ePer.getErrorName(), ePer.getErrorMessage());
		}
	}

	private String correctFontInDescAndComm(String inputText){
		String returnText = null;
		if(inputText != null){
			returnText = inputText.replace("font-size:9pt", "font-size:13pt").replace("font-size:8pt", "font-size:13pt");
		}
		return returnText;
	}

	protected boolean verifyE2EDefectId(Connection objQCTConnection, String defectId) throws PersistenceException{
			String dbResult = this.objDefectDetailsPersistence.verifyE2EDefectId(objQCTConnection, defectId);

			if (this.objResourceProvider.compareString(dbResult, "1")){
				return true;
			}else{
				return false;
			}
	}

	protected boolean verifyV1DefectId(Connection objQCTConnection, String defectId) throws PersistenceException{
		String dbResult = this.objDefectDetailsPersistence.verifyV1DefectId(objQCTConnection, defectId);

		if (this.objResourceProvider.compareString(dbResult, "1")){
			return true;
		}else{
			return false;
		}
	}
}
