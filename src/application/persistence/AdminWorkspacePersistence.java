package application.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import application.exceptions.PersistenceException;

public final class AdminWorkspacePersistence {

	private final String sqlGetUserIdList = "select E.USER_ID from REPORT_SCHEMA.E2E_TRACKER_USER_PROFILE E";
	private final String SqlGetUserDetails = "select E.USER_ID, E.FIRST_NAME, E.LAST_NAME, E.ACCESS_TYPE, E.ACCESS_FLAG from REPORT_SCHEMA.E2E_TRACKER_USER_PROFILE E where E.USER_ID = ?";
	private final String sqlUpdateUserDetails = "update REPORT_SCHEMA.E2E_TRACKER_USER_PROFILE E set E.FIRST_NAME = ?, E.LAST_NAME = ?, E.ACCESS_TYPE = ?, E.ACCESS_FLAG = ?, E.LAST_UPDATE_DATE = SYSDATE where E.USER_ID = ?";
	private final String sqlCreateUserProfile = "insert into REPORT_SCHEMA.E2E_TRACKER_USER_PROFILE (USER_ID, PASSWORD, FIRST_NAME, LAST_NAME, ACCESS_TYPE, ACCESS_FLAG, LAST_UPDATE_DATE) values (?, ?, ?, ?, ?, ?, SYSDATE)";
	private final String sqlGetOptionValueList = "select E.CODE_VALUE from REPORT_SCHEMA.E2E_TRACKER_CODE_DETAILS E where E.CODE_NAME = ?";
	private final String sqlUpdateCodeDetails = "insert into REPORT_SCHEMA.E2E_TRACKER_CODE_DETAILS (CODE_NAME, CODE_VALUE, LAST_USER_ID, LAST_UPDATE_DATE)"
											  +" values (?, ?, 'SYSADMIN', SYSDATE)";
	private final String sqlVerifyRefDataExists = "select count(*) from REPORT_SCHEMA.E2E_TRACKER_CODE_DETAILS E where E.CODE_NAME = ? and E.CODE_VALUE = ?";

	public final List<String> getUserIdList(Connection localConnection) throws PersistenceException{
		try{
			Statement objStatement = localConnection.createStatement();
            ResultSet resultSet = objStatement.executeQuery(sqlGetUserIdList);
            List<String> dabataResult = new ArrayList<String>();
            while (resultSet.next()){
            	dabataResult.add(resultSet.getString(1));
            }
            return dabataResult;
        }catch(SQLException eSQL){
        	throw new PersistenceException("E", "Application Error", "Unknown database error. Please contact System Administrator.");
        }
	}

	public final List<String> getUserDetails(Connection objLocalConnection, String userId) throws PersistenceException{
		try{
			PreparedStatement preparedStatement = objLocalConnection.prepareStatement(SqlGetUserDetails);
            preparedStatement.setString(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<String> dabataResult = new ArrayList<String>();
            while (resultSet.next()){
            	dabataResult.add(resultSet.getString(1));
            	dabataResult.add(resultSet.getString(2));
            	dabataResult.add(resultSet.getString(3));
            	dabataResult.add(resultSet.getString(4));
            	dabataResult.add(resultSet.getString(5));
            }
            return dabataResult;
        }catch(SQLException eSQL){
        	throw new PersistenceException("E", "Application Error", "Unknown database error. Please contact System Administrator.");
        }
	}

	public final void updateUserDetails(Connection objLocalConnection, List<String> userDetailsList, boolean updatePassword) throws PersistenceException{
		try{
			PreparedStatement preparedStatement = objLocalConnection.prepareStatement(sqlUpdateUserDetails);
            preparedStatement.setString(1, userDetailsList.get(2));
            preparedStatement.setString(2, userDetailsList.get(3));
            preparedStatement.setString(3, userDetailsList.get(4));
            preparedStatement.setString(4, userDetailsList.get(5));
            preparedStatement.setString(5, userDetailsList.get(0));
            preparedStatement.executeUpdate();

            if(updatePassword){
            	LoginPersistence objLoginPersistence = new LoginPersistence();
            	objLoginPersistence.updateProfilePassword(objLocalConnection, userDetailsList.get(1), userDetailsList.get(0));
            }
        }catch(SQLException eSQL){
        	throw new PersistenceException("E", "Application Error", "Unknown database error. Please contact System Administrator.");
        }
	}

	public final void createUserDetails(Connection objLocalConnection, List<String> userDetailsList) throws PersistenceException{
		try{
			PreparedStatement preparedStatement = objLocalConnection.prepareStatement(sqlCreateUserProfile);
            preparedStatement.setString(1, userDetailsList.get(0));
            preparedStatement.setString(2, userDetailsList.get(1));
            preparedStatement.setString(3, userDetailsList.get(2));
            preparedStatement.setString(4, userDetailsList.get(3));
            preparedStatement.setString(5, userDetailsList.get(4));
            preparedStatement.setString(6, userDetailsList.get(5));
            preparedStatement.executeUpdate();

        }catch(SQLException eSQL){
        	throw new PersistenceException("E", "Application Error", "Unknown database error. Please contact System Administrator.");
        }
	}

	public final List<String> getOptionValueList(Connection objLocalConnection, String selectedValueName) throws PersistenceException{
		try{
			PreparedStatement preparedStatement = objLocalConnection.prepareStatement(sqlGetOptionValueList);
            preparedStatement.setString(1, selectedValueName);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<String> dabataResult = new ArrayList<String>();
            while (resultSet.next()){
            	dabataResult.add(resultSet.getString(1));
            }
            return dabataResult;
        }catch(SQLException eSQL){
        	throw new PersistenceException("E", "Application Error", "Unknown database error. Please contact System Administrator.");
        }
	}

	public final void insertIntoCodeDetails(Connection objLocalConnection, String codeName, String codeValue) throws PersistenceException{
		try{
			PreparedStatement preparedStatement = objLocalConnection.prepareStatement(sqlUpdateCodeDetails);
            preparedStatement.setString(1, codeName);
            preparedStatement.setString(2, codeValue);
            preparedStatement.executeUpdate();
        }catch(SQLException eSQL){
        	eSQL.printStackTrace();
        	throw new PersistenceException("E", "Application Error", "Unknown database error. Please contact System Administrator.");
        }
	}

	public final String verifyCodeDetails(Connection objLocalConnection, String codeName, String codeValue) throws PersistenceException{
		try{
			PreparedStatement preparedStatement = objLocalConnection.prepareStatement(sqlVerifyRefDataExists);
	        preparedStatement.setString(1, codeName);
	        preparedStatement.setString(2, codeValue);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        String dabataResult = null;
	        while (resultSet.next()){
	        	dabataResult = resultSet.getString(1);
	        }
	        return dabataResult;
	    }catch(SQLException eSQL){
	    	eSQL.printStackTrace();
	    	throw new PersistenceException("E", "Application Error", "Unknown database error. Please contact System Administrator.");
	    }
	}
}
