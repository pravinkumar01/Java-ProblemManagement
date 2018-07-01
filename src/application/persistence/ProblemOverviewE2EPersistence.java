package application.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import application.exceptions.PersistenceException;

public final class ProblemOverviewE2EPersistence {

	private final String sqlGetValuseFromCodeDetails = "select CODE_VALUE from REPORT_SCHEMA.E2E_TRACKER_CODE_DETAILS E where E.CODE_NAME = ?";

	private final String sqlGetExistingProblemList = "select E.TRACKER_ID from REPORT_SCHEMA.E2E_TRACKER_PROBLEM_DETAILS E";

	private final String sqlGetProblemDetails = "SELECT E.TRACKER_ID, E.PROBLEM_TYPE, E.BUSINESS_RISK, E.DETECTED_IN, E.DEFECT_ID, E.INCIDENT_ID,"
												+ " E.PROBLEM_ID, E.ASSIGNED_TO, E.STATUS, E.APPLICATION_NAME, E.SYS_RET_ERROR, E.ERROR_CODE, E.WORK_BASKET,"
												+ " E.ERROR_DESCRIPTION, E.PROBLEM_DESCRIPTION, E.WORKAROUND, E.ISSUE_LOGGED_BY, E.ISSUE_LOGGED_ON, E.LAST_UPDATED_BY,"
												+ " E.LAST_UPDATED_ON, E.EDIT_FLAG, E.LOCKED_BY FROM REPORT_SCHEMA.E2E_TRACKER_PROBLEM_DETAILS E"
												+ " where E.TRACKER_ID = ?";

	private final String sqlUpdateLockOnProblem = "update REPORT_SCHEMA.E2E_TRACKER_PROBLEM_DETAILS E set E.EDIT_FLAG = ?, E.LOCKED_BY = ? where E.TRACKER_ID = ?";

	private final String sqlUpdateProblemDetails = "update REPORT_SCHEMA.E2E_TRACKER_PROBLEM_DETAILS"
												+ " set PROBLEM_TYPE = ?, BUSINESS_RISK = ?, DETECTED_IN = ?, DEFECT_ID = ?, INCIDENT_ID = ?, PROBLEM_ID = ?,"
												+ " STATUS = ?, APPLICATION_NAME = ?, SYS_RET_ERROR = ?, ERROR_CODE = ?, WORK_BASKET = ?,"
												+ " LAST_UPDATED_BY = ?, ERROR_DESCRIPTION = ?, PROBLEM_DESCRIPTION = ?, WORKAROUND = ?,"
												+ " EDIT_FLAG = 'Y', LOCKED_BY = null, LAST_UPDATED_ON = SYSDATE where TRACKER_ID = ?";

	private final String sqlInsertIntoActivityLogs = "insert into REPORT_SCHEMA.E2E_TRACKER_ACTIVITY_LOGS (TRACKER_ID, LOGGED_BY, LOGGED_ON, COMMENTS) values (?, ?, SYSDATE, ?)";

	private final String sqlGenerateTrackerId = "select 'E2E-'||REPORT_SCHEMA.SEQ_TRACKER_ID.nextval from dual";

	private final String sqlInsertProblem = "insert into REPORT_SCHEMA.E2E_TRACKER_PROBLEM_DETAILS values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, SYSDATE, ?, ?, ?, 'Y', null)";

	private final String sqlRemoveAllLock = "update REPORT_SCHEMA.E2E_TRACKER_PROBLEM_DETAILS E set E.EDIT_FLAG = 'Y', E.LOCKED_BY = null where E.EDIT_FLAG = 'N' and E.LOCKED_BY = ?";

	public final List<String> getApplicationNameList(Connection objLocalConnection) throws PersistenceException{
		try{
			PreparedStatement objPrepareStatement = objLocalConnection.prepareStatement(sqlGetValuseFromCodeDetails);
			objPrepareStatement.setString(1, "Application Name");
			ResultSet databaseResult = objPrepareStatement.executeQuery();

            List<String> listDatabaseResult = new ArrayList<String>();
            while (databaseResult.next()){
            	listDatabaseResult.add(databaseResult.getString(1));
            }
            return listDatabaseResult;
        }catch(SQLException eSQL){
        	throw new PersistenceException("E", "Application Error", "Unknown Database Error. Please contact System Administrator.");
        }
	}

	public final List<String> getProblemTypeList(Connection objLocalConnection) throws PersistenceException{
		try{
			PreparedStatement objPrepareStatement = objLocalConnection.prepareStatement(sqlGetValuseFromCodeDetails);
			objPrepareStatement.setString(1, "Problem Type");
			ResultSet databaseResult = objPrepareStatement.executeQuery();

            List<String> listDatabaseResult = new ArrayList<String>();
            while (databaseResult.next()){
            	listDatabaseResult.add(databaseResult.getString(1));
            }
            return listDatabaseResult;
        }catch(SQLException eSQL){
        	throw new PersistenceException("E", "Application Error", "Unknown Database Error. Please contact System Administrator.");
        }
	}

	public final List<String> getBusinessRiskList(Connection objLocalConnection) throws PersistenceException{
		try{
			PreparedStatement objPrepareStatement = objLocalConnection.prepareStatement(sqlGetValuseFromCodeDetails);
			objPrepareStatement.setString(1, "Business Risk");
			ResultSet databaseResult = objPrepareStatement.executeQuery();

            List<String> listDatabaseResult = new ArrayList<String>();
            while (databaseResult.next()){
            	listDatabaseResult.add(databaseResult.getString(1));
            }
            return listDatabaseResult;
        }catch(SQLException eSQL){
        	throw new PersistenceException("E", "Application Error", "Unknown Database Error. Please contact System Administrator.");
        }
	}

	public final List<String> getStatusList(Connection objLocalConnection) throws PersistenceException{
		try{
			PreparedStatement objPrepareStatement = objLocalConnection.prepareStatement(sqlGetValuseFromCodeDetails);
			objPrepareStatement.setString(1, "Status");
			ResultSet databaseResult = objPrepareStatement.executeQuery();

            List<String> listDatabaseResult = new ArrayList<String>();
            while (databaseResult.next()){
            	listDatabaseResult.add(databaseResult.getString(1));
            }
            return listDatabaseResult;
        }catch(SQLException eSQL){
        	throw new PersistenceException("E", "Application Error", "Unknown Database Error. Please contact System Administrator.");
        }
	}

	public final List<String> getWorkBasketList(Connection objLocalConnection) throws PersistenceException{
		try{
			PreparedStatement objPrepareStatement = objLocalConnection.prepareStatement(sqlGetValuseFromCodeDetails);
			objPrepareStatement.setString(1, "Work Basket");
			ResultSet databaseResult = objPrepareStatement.executeQuery();

            List<String> listDatabaseResult = new ArrayList<String>();
            while (databaseResult.next()){
            	listDatabaseResult.add(databaseResult.getString(1));
            }
            return listDatabaseResult;
        }catch(SQLException eSQL){
        	throw new PersistenceException("E", "Application Error", "Unknown Database Error. Please contact System Administrator.");
        }
	}

	public final List<String> getDetectedInList(Connection objLocalConnection) throws PersistenceException{
		try{
			PreparedStatement objPrepareStatement = objLocalConnection.prepareStatement(sqlGetValuseFromCodeDetails);
			objPrepareStatement.setString(1, "Detected In");
			ResultSet databaseResult = objPrepareStatement.executeQuery();

            List<String> listDatabaseResult = new ArrayList<String>();
            while (databaseResult.next()){
            	listDatabaseResult.add(databaseResult.getString(1));
            }
            return listDatabaseResult;
        }catch(SQLException eSQL){
        	throw new PersistenceException("E", "Application Error", "Unknown Database Error. Please contact System Administrator.");
        }
	}

	public final List<String> getExistingProblemList(Connection objLocalConnection) throws PersistenceException{
		try{
			Statement objStatement = objLocalConnection.createStatement();
            ResultSet databaseResult = objStatement.executeQuery(sqlGetExistingProblemList);
            List<String> listDatabaseResult = new ArrayList<String>();
            while (databaseResult.next()){
            	listDatabaseResult.add(databaseResult.getString(1));
            }
            return listDatabaseResult;
        }catch(SQLException eSQL){
        	throw new PersistenceException("E", "Application Error", "Unknown database error. Please contact System Administrator.");
        }
	}

	public final List<String> getProblemDetails(Connection objLocalConnection, String trackerId) throws PersistenceException{
		try{
			PreparedStatement objPrepareStatement = objLocalConnection.prepareStatement(sqlGetProblemDetails);
			objPrepareStatement.setString(1, trackerId);
			ResultSet databaseResult = objPrepareStatement.executeQuery();
			ResultSetMetaData rsmd = databaseResult.getMetaData();
            List<String> listDatabaseResult = new ArrayList<String>();
            while (databaseResult.next()){
            	for(int i=1; i<=rsmd.getColumnCount(); i++){
            		listDatabaseResult.add(databaseResult.getString(i));
    			}
            }
            return listDatabaseResult;
        }catch(SQLException eSQL){
        	throw new PersistenceException("E", "Application Error", "Unknown Database Error. Please contact System Administrator.");
        }
	}

	public final void putLockOnProblem(Connection objLocalConnection, String editFlag, String userId, String trackerId) throws PersistenceException{
		try{
			PreparedStatement objPrepareStatement = objLocalConnection.prepareStatement(sqlUpdateLockOnProblem);
			objPrepareStatement.setString(1, editFlag);
			objPrepareStatement.setString(2, userId);
			objPrepareStatement.setString(3, trackerId);
			objPrepareStatement.executeUpdate();
        }catch(SQLException eSQL){
        	throw new PersistenceException("E", "Application Error", "Unknown Database Error. Please contact System Administrator.");
        }
	}

	public final void updateExistingProblem(Connection objLocalConnection, HashMap<String, String> problemDetails) throws PersistenceException{
		try{
			PreparedStatement objPrepareStatement = objLocalConnection.prepareStatement(sqlUpdateProblemDetails);
			objPrepareStatement.setString(1, problemDetails.get("PROBLEM_TYPE"));
			objPrepareStatement.setString(2, problemDetails.get("BUSINESS_RISK"));
			objPrepareStatement.setString(3, problemDetails.get("DETECTED_IN"));
			objPrepareStatement.setString(4, problemDetails.get("DEFECT_ID"));
			objPrepareStatement.setString(5, problemDetails.get("INCIDENT_ID"));
			objPrepareStatement.setString(6, problemDetails.get("PROBLEM_ID"));
			objPrepareStatement.setString(7, problemDetails.get("STATUS"));
			objPrepareStatement.setString(8, problemDetails.get("APPLICATION_NAME"));
			objPrepareStatement.setString(9, problemDetails.get("SYS_RET_ERROR"));
			objPrepareStatement.setString(10, problemDetails.get("ERROR_CODE"));
			objPrepareStatement.setString(11, problemDetails.get("WORK_BASKET"));
			objPrepareStatement.setString(12, problemDetails.get("LAST_UPDATED_BY"));
			objPrepareStatement.setString(13, problemDetails.get("ERROR_DESCRIPTION"));
			objPrepareStatement.setString(14, problemDetails.get("PROBLEM_DESCRIPTION"));
			objPrepareStatement.setString(15, problemDetails.get("WORKAROUND"));
			objPrepareStatement.setString(16, problemDetails.get("TRACKER_ID"));
			objPrepareStatement.executeUpdate();
			this.insertIntoActivityLogs(objLocalConnection, problemDetails.get("TRACKER_ID"), problemDetails.get("LAST_UPDATED_BY"), problemDetails.get("COMMENTS"));
		}catch(SQLException eSQL){
			eSQL.printStackTrace();
	    	throw new PersistenceException("E", "Application Error", "Unknown Database Error. Please contact System Administrator.");
	    }
	}

	private final void insertIntoActivityLogs(Connection objLocalConnection, String trackerId, String loggedBy, String comments) throws PersistenceException{
		try{
			PreparedStatement objPrepareStatement = objLocalConnection.prepareStatement(sqlInsertIntoActivityLogs);
			objPrepareStatement.setString(1, trackerId);
			objPrepareStatement.setString(2, loggedBy);
			objPrepareStatement.setString(3, comments);
			objPrepareStatement.executeUpdate();
		}catch(SQLException eSQL){
	    	throw new PersistenceException("E", "Application Error", "Unknown Database Error. Please contact System Administrator.");
	    }
	}

	public final String insertIntoProblemDetails(Connection objLocalConnection, HashMap<String, String> problemDetails) throws PersistenceException{
		try{
			Statement objStatement = objLocalConnection.createStatement();
            ResultSet resultSet = objStatement.executeQuery(sqlGenerateTrackerId);
            String trackerId = null;
            while (resultSet.next()){
            	trackerId = resultSet.getString(1);
            }

            PreparedStatement objPrepareStatement = objLocalConnection.prepareStatement(sqlInsertProblem);
            objPrepareStatement.setString(1, trackerId);
            objPrepareStatement.setString(2, problemDetails.get("PROBLEM_TYPE"));
            objPrepareStatement.setString(3, problemDetails.get("BUSINESS_RISK"));
			objPrepareStatement.setString(4, problemDetails.get("DETECTED_IN"));
			objPrepareStatement.setString(5, problemDetails.get("DEFECT_ID"));
			objPrepareStatement.setString(6, problemDetails.get("INCIDENT_ID"));
			objPrepareStatement.setString(7, problemDetails.get("PROBLEM_ID"));
			objPrepareStatement.setString(8, problemDetails.get("ASSIGNED_TO"));
			objPrepareStatement.setString(9, problemDetails.get("STATUS"));
			objPrepareStatement.setString(10, problemDetails.get("APPLICATION_NAME"));
			objPrepareStatement.setString(11, problemDetails.get("SYS_RET_ERROR"));
			objPrepareStatement.setString(12, problemDetails.get("ERROR_CODE"));
			objPrepareStatement.setString(13, problemDetails.get("WORK_BASKET"));
			objPrepareStatement.setString(14, problemDetails.get("LAST_UPDATED_BY"));
			objPrepareStatement.setString(15, problemDetails.get("LAST_UPDATED_BY"));
			objPrepareStatement.setString(16, problemDetails.get("ERROR_DESCRIPTION"));
			objPrepareStatement.setString(17, problemDetails.get("PROBLEM_DESCRIPTION"));
			objPrepareStatement.setString(18, problemDetails.get("WORKAROUND"));
			objPrepareStatement.executeUpdate();

			this.insertIntoActivityLogs(objLocalConnection, trackerId, problemDetails.get("LAST_UPDATED_BY"), problemDetails.get("COMMENTS"));
            return trackerId;
		}catch(SQLException eSQL){
	    	throw new PersistenceException("E", "Application Error", "Unknown Database Error. Please contact System Administrator.");
	    }
	}

	public final void removeAllLock(Connection objLocalConnection, String userId) throws PersistenceException{
		try{
			PreparedStatement objPrepareStatement = objLocalConnection.prepareStatement(sqlRemoveAllLock);
			objPrepareStatement.setString(1, userId);
			objPrepareStatement.executeUpdate();
		}catch(SQLException eSQL){
	    	throw new PersistenceException("E", "Application Error", "Unknown Database Error. Please contact System Administrator.");
	    }
	}
}
