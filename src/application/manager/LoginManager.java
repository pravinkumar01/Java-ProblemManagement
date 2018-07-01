package application.manager;

import application.beans.LoginBean;
import application.exceptions.ManagerException;
import application.exceptions.PersistenceException;
import application.frames.ResourceProvider;
import application.persistence.LoginPersistence;

import java.sql.Connection;

public class LoginManager {

    private final LoginPersistence objLoginPersistence;
    private final ResourceProvider objResourceProvider;

    public LoginManager(ResourceProvider objResourceProvider) {
        this.objLoginPersistence = new LoginPersistence();
        this.objResourceProvider = objResourceProvider;
    }

    public LoginBean actionLogin(Connection objConnection, String userId, String encryptedPassword) throws ManagerException{
        try{
            if (userId.equals("") || userId.equals(null)){
                throw new ManagerException(1000, "I", "Login Message", "Please provide User Id.");
            }

            if (encryptedPassword.equals("") || encryptedPassword.equals(null)){
                throw new ManagerException(1002, "I", "Login Message", "Please provide Password.");
            }

            if (validateUserId(objConnection, userId)){
                String[] databaseResult = objLoginPersistence.getPasswordAndAccess(objConnection, userId);
                if(this.objResourceProvider.compareString(encryptedPassword, databaseResult[0])){
                    if(objResourceProvider.compareString(databaseResult[1], "Y")){
                        String[] userDetails = objLoginPersistence.getUserDetails(objConnection, userId);
                        LoginBean objLoginBean = new LoginBean(userId.toLowerCase(), userDetails[0], userDetails[1], userDetails[2]);
                        return objLoginBean;
                    }else{
                        throw new ManagerException(1000, "I", "Login Message", "Account is currently blocked. Please contact System Administrator.");
                    }
                }else{
                    throw new ManagerException(1002, "E", "Login Error", "Incorrect Password. Please verify your Password.");
                }
            }else{
                throw new ManagerException(1001, "E", "Login Error", "User Id not found. Please verify your User Id. It should be in format idXXXXXX.");
            }
        }catch(PersistenceException ePer){
            throw new ManagerException(1000, ePer.getErrorType(),ePer.getErrorName(), ePer.getErrorMessage());
        }
    }

    protected String getOperatorNameFromOperatorId(Connection objLocalConnection, String operatorId) throws ManagerException{
    	try{
    		String[] userDetails = this.objLoginPersistence.getUserDetails(objLocalConnection, operatorId);
    		return operatorId + "-"+userDetails[0]+" "+userDetails[1];
    	}catch(PersistenceException ePer){
    		throw new ManagerException(1000, ePer.getErrorType(),ePer.getErrorName(), ePer.getErrorMessage());
    	}
    }

    private boolean validateUserId(Connection objConnection, String userId) throws PersistenceException{
        String databaseResult = objLoginPersistence.validateUserId(objConnection, userId);
        if (this.objResourceProvider.compareString(databaseResult, "1")){
            return true;
        }else{
            return false;
        }
    }

    public final boolean updateProfilePassword (Connection objConnection, String password, String userId) throws ManagerException{
    	try{
    		int rowsAffected = this.objLoginPersistence.updateProfilePassword(objConnection, password, userId);
    		if (rowsAffected == 1){
    			return true;
    		}else {
    			return false;
    		}
    	}catch(PersistenceException ePer){
    		throw new ManagerException(1000, ePer.getErrorType(),ePer.getErrorName(), ePer.getErrorMessage());
    	}
    }
}
