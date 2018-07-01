package application.manager;

import java.sql.Connection;

import application.beans.IncidentOverviewHPSMBean;
import application.exceptions.ManagerException;
import application.exceptions.PersistenceException;
import application.frames.ResourceProvider;
import application.persistence.IncidentOverviewHPSMPersistence;

public class IncidentOverviewHPSMManager {

	private final ResourceProvider objResourceProvider;
	private final IncidentOverviewHPSMBean objIncidentOverviewHPSMBean;
	private final IncidentOverviewHPSMPersistence objIncidentOverviewHPSMPersistence;

	public IncidentOverviewHPSMManager(ResourceProvider objResourceProvider, IncidentOverviewHPSMBean objIncidentOverviewHPSMBean) {
		this.objResourceProvider = objResourceProvider;
		this.objIncidentOverviewHPSMBean = objIncidentOverviewHPSMBean;
		this.objIncidentOverviewHPSMPersistence = new IncidentOverviewHPSMPersistence();
	}

	public void actionSearch(Connection objHPSMConnection, String incidentId) throws ManagerException{
		try{
			String[] dbResultIncidentDetails = null;
			if(this.verifyIncidentId(objHPSMConnection, incidentId)){
				dbResultIncidentDetails = objIncidentOverviewHPSMPersistence.fetchIncidentDetails(objHPSMConnection, incidentId);
			}else{
				throw new ManagerException(1001, "I", "Application Meaasge", "Incident ID not found. Please verify Incident ID.");
			}
			objIncidentOverviewHPSMBean.setIncidentId(dbResultIncidentDetails[0]);
			objIncidentOverviewHPSMBean.setTitle(dbResultIncidentDetails[1]);
			objIncidentOverviewHPSMBean.setProblemType(dbResultIncidentDetails[2]);
			objIncidentOverviewHPSMBean.setStatus(dbResultIncidentDetails[3]);
			objIncidentOverviewHPSMBean.setConfigurationItem(dbResultIncidentDetails[4]);
			objIncidentOverviewHPSMBean.setRequestorId(dbResultIncidentDetails[5]);
			objIncidentOverviewHPSMBean.setRequestedBy(dbResultIncidentDetails[6]);
			objIncidentOverviewHPSMBean.setOpenTime(dbResultIncidentDetails[7]);
			objIncidentOverviewHPSMBean.setCloseTime(dbResultIncidentDetails[8]);
			objIncidentOverviewHPSMBean.setAssignmentGroup(dbResultIncidentDetails[9]);
			objIncidentOverviewHPSMBean.setAssigneeId(dbResultIncidentDetails[10]);
			objIncidentOverviewHPSMBean.setAssigneeName(dbResultIncidentDetails[11]);
			objIncidentOverviewHPSMBean.setUpdatedBy(dbResultIncidentDetails[12]);
			objIncidentOverviewHPSMBean.setResolvedBy(dbResultIncidentDetails[13]);
			objIncidentOverviewHPSMBean.setDescription(dbResultIncidentDetails[14]);
			objIncidentOverviewHPSMBean.setResolutionComment(dbResultIncidentDetails[15]);
			objIncidentOverviewHPSMBean.setProgress(dbResultIncidentDetails[16]);

		}catch(PersistenceException ePer){
			throw new ManagerException(1000, ePer.getErrorType(), ePer.getErrorName(), ePer.getErrorMessage());
		}

	}

	private boolean verifyIncidentId(Connection objHPSMConnection, String incidentId) throws PersistenceException{
		String dbResult = this.objIncidentOverviewHPSMPersistence.verifyIncidentId(objHPSMConnection, incidentId);

		if (this.objResourceProvider.compareString(dbResult, "1")){
			return true;
		}else{
			return false;
		}
	}
}
