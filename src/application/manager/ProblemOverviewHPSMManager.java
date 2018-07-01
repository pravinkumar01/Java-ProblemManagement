package application.manager;

import java.sql.Connection;

import application.beans.ProblemOverviewHPSMBean;
import application.exceptions.ManagerException;
import application.exceptions.PersistenceException;
import application.frames.ResourceProvider;
import application.persistence.ProblemOverviewHPSMPersistence;

public class ProblemOverviewHPSMManager {

	private final ResourceProvider objResourceProvider;
	private final ProblemOverviewHPSMBean objProblemOverviewHPSMBean;
	private final ProblemOverviewHPSMPersistence objProblemOverviewHPSMPersistence;

	public ProblemOverviewHPSMManager(ResourceProvider objResourceProvider, ProblemOverviewHPSMBean objProblemOverviewHPSMBean) {
		this.objResourceProvider = objResourceProvider;
		this.objProblemOverviewHPSMBean = objProblemOverviewHPSMBean;
		this.objProblemOverviewHPSMPersistence = new ProblemOverviewHPSMPersistence();
	}

	public void actionSearch(Connection objConnection, String problemId) throws ManagerException{
		try{
			String[] dbResultDefectDetails = null;
			if(this.verifyProblemId(objConnection, problemId)){
				dbResultDefectDetails = objProblemOverviewHPSMPersistence.fetchProblemDetailsHPSM(objConnection, problemId);
			}else{
				throw new ManagerException(1001, "I", "Application Meaasge", "Problem ID not found. Please verify Problem ID.");
			}
			objProblemOverviewHPSMBean.setProblemId(dbResultDefectDetails[0]);//Problem ID
			objProblemOverviewHPSMBean.setAssignmentGroup(dbResultDefectDetails[1]);//Assignment Group
			objProblemOverviewHPSMBean.setStatus(dbResultDefectDetails[2]);//Status
			objProblemOverviewHPSMBean.setOpenTime(dbResultDefectDetails[3]);//Open Time
			objProblemOverviewHPSMBean.setTitle(dbResultDefectDetails[4]);//Title
			objProblemOverviewHPSMBean.setDescription(dbResultDefectDetails[5]);//Description
			objProblemOverviewHPSMBean.setRootCause(dbResultDefectDetails[6]);//Root Cause
			objProblemOverviewHPSMBean.setJournalUpdates(dbResultDefectDetails[7]);//Journal Updates
			objProblemOverviewHPSMBean.setOpenedBy(dbResultDefectDetails[8]);//Opened By
			objProblemOverviewHPSMBean.setTicketOwner(dbResultDefectDetails[9]);//Ticket Owner
			objProblemOverviewHPSMBean.setResolution(dbResultDefectDetails[10]);//Resolution
			objProblemOverviewHPSMBean.setWorkaround(dbResultDefectDetails[11]);//Workaround
		}catch(PersistenceException ePer){
			throw new ManagerException(1000, ePer.getErrorType(), ePer.getErrorName(), ePer.getErrorMessage());
		}
	}

	private boolean verifyProblemId(Connection objConnection, String problemId) throws PersistenceException{
		String dbResult = this.objProblemOverviewHPSMPersistence.verifyProblemIdHPSM(objConnection, problemId);

		if (this.objResourceProvider.compareString(dbResult, "1")){
			return true;
		}else{
			return false;
		}
	}
}
