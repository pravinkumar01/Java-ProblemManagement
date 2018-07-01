package application.manager;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import application.beans.ProblemOverviewE2EBean;
import application.exceptions.ManagerException;
import application.exceptions.PersistenceException;
import application.frames.ResourceProvider;
import application.persistence.AdminWorkspacePersistence;
import application.persistence.DefectOverviewQCTPersistence;
import application.persistence.ProblemOverviewE2EPersistence;

public final class ProblemOverviewE2EManager {

	private final ResourceProvider objResourceProvider;
	private final DashboardManager objDashboardManager;
	private final ProblemOverviewE2EBean objProblemOverviewE2EBean;
	private final ProblemOverviewE2EPersistence objProblemOverviewE2EPersistence;

	public ProblemOverviewE2EManager(ResourceProvider objResourceProvider,
			ProblemOverviewE2EBean objProblemOverviewE2EBean, DashboardManager objDashboardManager) {
		this.objResourceProvider = objResourceProvider;
		this.objDashboardManager = objDashboardManager;
		this.objProblemOverviewE2EBean = objProblemOverviewE2EBean;
		this.objProblemOverviewE2EPersistence = new ProblemOverviewE2EPersistence();
	}

	public void setDefaultValueForApplicationName(Connection objLocalConnection) throws ManagerException{
		try{
			this.objProblemOverviewE2EBean.setDefaultListApplicationName(
							this.objProblemOverviewE2EPersistence.getApplicationNameList(objLocalConnection));
		}catch(PersistenceException ePer){
			throw new ManagerException(1000, ePer.getErrorType(), ePer.getErrorName(), ePer.getErrorMessage());
		}
	}

	public void setDefaultValueForProblemType(Connection objLocalConnection) throws ManagerException{
		try{
			this.objProblemOverviewE2EBean.setDefaultListProblemType(
							this.objProblemOverviewE2EPersistence.getProblemTypeList(objLocalConnection));
		}catch(PersistenceException ePer){
			throw new ManagerException(1000, ePer.getErrorType(), ePer.getErrorName(), ePer.getErrorMessage());
		}
	}

	public void setDefaultValueForBusinessRisk(Connection objLocalConnection) throws ManagerException{
		try{
			this.objProblemOverviewE2EBean.setDefaultListBusinessRisk(
							this.objProblemOverviewE2EPersistence.getBusinessRiskList(objLocalConnection));
		}catch(PersistenceException ePer){
			throw new ManagerException(1000, ePer.getErrorType(), ePer.getErrorName(), ePer.getErrorMessage());
		}
	}

	public void setDefaultValueForStatus(Connection objLocalConnection) throws ManagerException{
		try{
			this.objProblemOverviewE2EBean.setDefaultListStatus(
							this.objProblemOverviewE2EPersistence.getStatusList(objLocalConnection));
		}catch(PersistenceException ePer){
			throw new ManagerException(1000, ePer.getErrorType(), ePer.getErrorName(), ePer.getErrorMessage());
		}
	}

	public void setDefaultValueForWorkBasket(Connection objLocalConnection) throws ManagerException{
		try{
			this.objProblemOverviewE2EBean.setDefaultListWorkBasket(
							this.objProblemOverviewE2EPersistence.getWorkBasketList(objLocalConnection));
		}catch(PersistenceException ePer){
			throw new ManagerException(1000, ePer.getErrorType(), ePer.getErrorName(), ePer.getErrorMessage());
		}
	}

	public void setDefaultValueForDetectedIn(Connection objLocalConnection) throws ManagerException{
		try{
			this.objProblemOverviewE2EBean.setDefaultListDetectedIn(
							this.objProblemOverviewE2EPersistence.getDetectedInList(objLocalConnection));
		}catch(PersistenceException ePer){
			throw new ManagerException(1000, ePer.getErrorType(), ePer.getErrorName(), ePer.getErrorMessage());
		}
	}

	public void setExistingProblemIdList(Connection objLocalConnection) throws ManagerException{
		try{
			List<String> databaseResult = this.objProblemOverviewE2EPersistence.getExistingProblemList(objLocalConnection);
			if(databaseResult.size() == 0){
				databaseResult = new ArrayList<String>();
				databaseResult.add("");
			}else{
				databaseResult.add(0, "--Select Problem--");
			}
			this.objProblemOverviewE2EBean.setExistingProblemList(databaseResult);
		}catch(PersistenceException ePer){
			throw new ManagerException(1000, ePer.getErrorType(), ePer.getErrorName(), ePer.getErrorMessage());
		}
	}

	public void setBeanVariablesWithProblemDetails(Connection objLocalConnection, String trackerId) throws ManagerException{
		try{
			LoginManager objLoginManager = new LoginManager(objResourceProvider);
			List<String> databaseResult = this.objProblemOverviewE2EPersistence.getProblemDetails(objLocalConnection, trackerId);
			objDashboardManager.enrichProblemDetails(objLocalConnection, databaseResult);
			this.objProblemOverviewE2EBean.setTrackerId(databaseResult.get(0));
			this.objProblemOverviewE2EBean.setSelectedValueProblemType(databaseResult.get(1));
			this.objProblemOverviewE2EBean.setSelectedValueBusinessRisk(databaseResult.get(2));
			this.objProblemOverviewE2EBean.setSelectedValueDetectedIn(databaseResult.get(3));
			this.objProblemOverviewE2EBean.setDefectId(databaseResult.get(4));
			this.objProblemOverviewE2EBean.setIncidentId(databaseResult.get(5));
			this.objProblemOverviewE2EBean.setProblemId(databaseResult.get(6));
			this.objProblemOverviewE2EBean.setAssignedTo(databaseResult.get(7));
			this.objProblemOverviewE2EBean.setSelectedValueStatus(databaseResult.get(8));
			this.objProblemOverviewE2EBean.setSelectedValueApplicationName(databaseResult.get(9));
			this.objProblemOverviewE2EBean.setSelectedValueSysRetError(databaseResult.get(10));
			this.objProblemOverviewE2EBean.setErrorCode(databaseResult.get(11));
			this.objProblemOverviewE2EBean.setSelectedValueWorkBasket(databaseResult.get(12));
			this.objProblemOverviewE2EBean.setErrorDescription(databaseResult.get(13));
			this.objProblemOverviewE2EBean.setProblemDescription(databaseResult.get(14));
			this.objProblemOverviewE2EBean.setWorkaround(databaseResult.get(15));
			this.objProblemOverviewE2EBean.setActivityLogs(databaseResult.get(16));
			this.objProblemOverviewE2EBean.setIssueLoggedBy(databaseResult.get(17));
			this.objProblemOverviewE2EBean.setIssueLoggedOn(databaseResult.get(18));
			this.objProblemOverviewE2EBean.setComments("");
			this.objProblemOverviewE2EBean.setLastUpdatedOn(databaseResult.get(20));
			this.objProblemOverviewE2EBean.setEditFlag(databaseResult.get(21));
			if(databaseResult.get(22) != null){
				this.objProblemOverviewE2EBean.setLockedBy(objLoginManager.getOperatorNameFromOperatorId(objLocalConnection, databaseResult.get(22)));
			}else{
				this.objProblemOverviewE2EBean.setLockedBy(databaseResult.get(22));
			}
		}catch(PersistenceException ePer){
			throw new ManagerException(1000, ePer.getErrorType(), ePer.getErrorName(), ePer.getErrorMessage());
		}
	}

	public void updateLockOnProblem(Connection objLocalConnection, String editFlag, String userId, String trackerId) throws ManagerException{
		try{
			this.objProblemOverviewE2EPersistence.putLockOnProblem(objLocalConnection, editFlag, userId, trackerId);
		}catch(PersistenceException ePer){
			throw new ManagerException(1000, ePer.getErrorType(), ePer.getErrorName(), ePer.getErrorMessage());
		}
	}

	public List<String> getDefectDetails(Connection objQCTConnection, String defectId) throws ManagerException{
		try{
			DefectOverviewQCTPersistence objDefectOverviewQCTPersistence = new DefectOverviewQCTPersistence();
			String resultV2Defect = objDefectOverviewQCTPersistence.verifyE2EDefectId(objQCTConnection, defectId);
			List<String> databaseResult = null;
			if(this.objResourceProvider.compareString(resultV2Defect, "1")){
				databaseResult = objDefectOverviewQCTPersistence.mapE2EDefectToProblem(objQCTConnection, defectId);
				databaseResult.add(0, "E2E");
			}else{
				String resultV1Defect = objDefectOverviewQCTPersistence.verifyV1DefectId(objQCTConnection, defectId);
				if(this.objResourceProvider.compareString(resultV1Defect, "1")){
					databaseResult = objDefectOverviewQCTPersistence.mapV1DefectToProblem(objQCTConnection, defectId);
					databaseResult.add(0, "V1");
				}else{
					throw new ManagerException(1005, "I", "Application Message", "Defect not found in E2E or V1 Project. Please verify Defect ID.");
				}
			}
			return databaseResult;
		}catch(PersistenceException ePer){
			throw new ManagerException(1000, ePer.getErrorType(), ePer.getErrorName(), ePer.getErrorMessage());
		}
	}

	public void updateCodeDetails(Connection objLocalConnection, List<String> mapDefectList) throws ManagerException{
		try{
			AdminWorkspacePersistence objAdminWorkspacePersistence = new AdminWorkspacePersistence();
			int databaseResultApplication = Integer.parseInt(objAdminWorkspacePersistence.verifyCodeDetails(objLocalConnection, "Application Name", mapDefectList.get(1)));
			if((databaseResultApplication == 0)){
				objAdminWorkspacePersistence.insertIntoCodeDetails(objLocalConnection, "Application Name", mapDefectList.get(1));
				this.objProblemOverviewE2EBean.getDefaultListApplicationName().add(mapDefectList.get(1));
			}
			int databaseResultDetectedIn = Integer.parseInt(objAdminWorkspacePersistence.verifyCodeDetails(objLocalConnection, "Detected In", mapDefectList.get(3)));
			if((databaseResultDetectedIn == 0)){
				objAdminWorkspacePersistence.insertIntoCodeDetails(objLocalConnection, "Detected In", mapDefectList.get(3));
				this.objProblemOverviewE2EBean.getDefaultListDetectedIn().add(mapDefectList.get(3));
				this.setDefaultValueForDetectedIn(objLocalConnection);
			}
		}catch(PersistenceException ePer){
			throw new ManagerException(1000, ePer.getErrorType(), ePer.getErrorName(), ePer.getErrorMessage());
		}
	}

	public String upsertProblemDetails(Connection objLocalConnection, String userId, boolean newFlag) throws ManagerException{
		try{
			HashMap<String, String> problemDetails = this.prepareMapForProblemDetails(userId);
			String trackerId = null;
			if(newFlag){
				trackerId = this.objProblemOverviewE2EPersistence.insertIntoProblemDetails(objLocalConnection, problemDetails);
			}else{
				trackerId = this.objProblemOverviewE2EBean.getSelectedProblem();
				problemDetails.put("TRACKER_ID", trackerId);
				this.objProblemOverviewE2EPersistence.updateExistingProblem(objLocalConnection, problemDetails);
			}
			return trackerId;
		}catch(PersistenceException ePer){
			throw new ManagerException(1000, ePer.getErrorType(), ePer.getErrorName(), ePer.getErrorMessage());
		}
	}

	private HashMap<String, String> prepareMapForProblemDetails(String userId){
		HashMap<String, String> problemDetails = new HashMap<String, String>();
		problemDetails.put("PROBLEM_TYPE", this.objProblemOverviewE2EBean.getSelectedValueProblemType());
		problemDetails.put("BUSINESS_RISK", this.objProblemOverviewE2EBean.getSelectedValueBusinessRisk());
		problemDetails.put("DETECTED_IN", this.objProblemOverviewE2EBean.getSelectedValueDetectedIn());
		problemDetails.put("DEFECT_ID", this.objProblemOverviewE2EBean.getDefectId());
		problemDetails.put("INCIDENT_ID", this.objProblemOverviewE2EBean.getIncidentId());
		problemDetails.put("PROBLEM_ID", this.objProblemOverviewE2EBean.getProblemId());
		problemDetails.put("ASSIGNED_TO", this.objProblemOverviewE2EBean.getAssignedTo());
		problemDetails.put("STATUS", this.objProblemOverviewE2EBean.getSelectedValueStatus());
		problemDetails.put("APPLICATION_NAME", this.objProblemOverviewE2EBean.getSelectedValueApplicationName());
		problemDetails.put("SYS_RET_ERROR", this.objProblemOverviewE2EBean.getSelectedValueSysRetError());
		problemDetails.put("ERROR_CODE", this.objProblemOverviewE2EBean.getErrorCode());
		problemDetails.put("WORK_BASKET", this.objProblemOverviewE2EBean.getSelectedValueWorkBasket());
		problemDetails.put("LAST_UPDATED_BY", userId);
		problemDetails.put("ERROR_DESCRIPTION", this.objProblemOverviewE2EBean.getErrorDescription());
		problemDetails.put("PROBLEM_DESCRIPTION", this.objProblemOverviewE2EBean.getProblemDescription());
		problemDetails.put("WORKAROUND", this.objProblemOverviewE2EBean.getWorkaround());
		problemDetails.put("COMMENTS", this.objProblemOverviewE2EBean.getComments());
		return problemDetails;
	}

	public void removeAllLock(Connection objLocalConnection, String userId) throws ManagerException{
		try{
			this.objProblemOverviewE2EPersistence.removeAllLock(objLocalConnection, userId);
		}catch(PersistenceException ePer){
			throw new ManagerException(1000, ePer.getErrorType(), ePer.getErrorName(), ePer.getErrorMessage());
		}
	}
}
