package application.manager;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import application.beans.AdminWorkspaceBean;
import application.exceptions.ManagerException;
import application.exceptions.PersistenceException;
import application.persistence.AdminWorkspacePersistence;

public class AdminWorkspaceManager {

	private final AdminWorkspacePersistence objAdminWorkspacePersistence;
	private final AdminWorkspaceBean objAdminWorkspaceBean;

	public AdminWorkspaceManager(AdminWorkspaceBean objAdminWorkspaceBean) {
		this.objAdminWorkspacePersistence = new AdminWorkspacePersistence();
		this.objAdminWorkspaceBean = objAdminWorkspaceBean;
	}

	public void getUserIdList(Connection loclaConnection) throws ManagerException{
		try{
			List<String> finalList = new ArrayList<String>();
			List<String> objResult = this.objAdminWorkspacePersistence.getUserIdList(loclaConnection);

			finalList.add("--Select User ID--");
			for(int i=0; i<objResult.size(); i++){
				finalList.add(objResult.get(i));
			}
			this.objAdminWorkspaceBean.setListUserId(finalList);
		}catch(PersistenceException ePer){
			throw new ManagerException(1000, ePer.getErrorType(), ePer.getErrorName(), ePer.getErrorMessage());
		}
	}

	public void getUserDetails(Connection loclaConnection, String userId) throws ManagerException{
		try{
			List<String> objResult = this.objAdminWorkspacePersistence.getUserDetails(loclaConnection, userId);
			this.objAdminWorkspaceBean.setUserId(objResult.get(0));
			this.objAdminWorkspaceBean.setPassword("");
			this.objAdminWorkspaceBean.setFirstName(objResult.get(1));
			this.objAdminWorkspaceBean.setLastName(objResult.get(2));
			this.objAdminWorkspaceBean.setAccessType(objResult.get(3));
			this.objAdminWorkspaceBean.setAccessFlag(objResult.get(4));
		}catch(PersistenceException ePer){
			throw new ManagerException(1000, ePer.getErrorType(), ePer.getErrorName(), ePer.getErrorMessage());
		}
	}
/*
	public void deleteUserProfile(Connection loclaConnection, String userId) throws ManagerException{
		try{
			this.objAdminWorkspacePersistence.deleteUserProfile(loclaConnection, userId);
		}catch(PersistenceException ePer){
			throw new ManagerException(1000, ePer.getErrorType(), ePer.getErrorName(), ePer.getErrorMessage());
		}
	}
*/
	public void updateUserProfile(Connection loclaConnection, List<String> userDetails, boolean updatePassword) throws ManagerException{
		try{
			this.objAdminWorkspacePersistence.updateUserDetails(loclaConnection, userDetails, updatePassword);
		}catch(PersistenceException ePer){
			throw new ManagerException(1000, ePer.getErrorType(), ePer.getErrorName(), ePer.getErrorMessage());
		}
	}

	public void createUserProfile(Connection loclaConnection, List<String> userDetails) throws ManagerException{
		try{
			this.objAdminWorkspacePersistence.createUserDetails(loclaConnection, userDetails);
		}catch(PersistenceException ePer){
			throw new ManagerException(1000, ePer.getErrorType(), ePer.getErrorName(), ePer.getErrorMessage());
		}
	}

	public void getOptionValueList(Connection objLocalConnection) throws ManagerException{
		try{
			this.objAdminWorkspaceBean.setSelectedOptionValueList(
					this.objAdminWorkspacePersistence.getOptionValueList(
							objLocalConnection, this.objAdminWorkspaceBean.getSelectedOptionName()));
		}catch(PersistenceException ePer){
			throw new ManagerException(1000, ePer.getErrorType(), ePer.getErrorName(), ePer.getErrorMessage());
		}
	}
}
