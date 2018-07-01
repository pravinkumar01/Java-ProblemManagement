package application.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import application.exceptions.PersistenceException;

public final class DashboardPersistence {

	private final String sqlListItemsforFilterItem = "SELECT DISTINCT (?) FROM REPORT_SCHEMA.E2E_TRACKER_PROBLEM_DETAILS";
	private final String sqlGetAllRecords = "SELECT E.TRACKER_ID, E.PROBLEM_TYPE, E.BUSINESS_RISK, E.DETECTED_IN, E.DEFECT_ID, E.INCIDENT_ID,"
			+ " E.PROBLEM_ID, E.ASSIGNED_TO, E.STATUS, E.APPLICATION_NAME, E.SYS_RET_ERROR, E.ERROR_CODE, E.WORK_BASKET,"
			+ " E.ERROR_DESCRIPTION, E.PROBLEM_DESCRIPTION, E.WORKAROUND, E.ISSUE_LOGGED_BY, E.ISSUE_LOGGED_ON, E.LAST_UPDATED_BY,"
			+ " E.LAST_UPDATED_ON FROM REPORT_SCHEMA.E2E_TRACKER_PROBLEM_DETAILS E";
	private final String sqlGetActivityLogsByTrackerId = "SELECT E.* FROM REPORT_SCHEMA.E2E_TRACKER_ACTIVITY_LOGS E WHERE E.TRACKER_ID = ? ORDER BY E.LOGGED_ON";

	public final List<String> getListOfAllItemsForSelectedFilterItem(Connection objConnection, String filterColumnName) throws PersistenceException{
		try{
			Statement objStatement = objConnection.createStatement();
            ResultSet resultSet = objStatement.executeQuery(sqlListItemsforFilterItem.replace("?", filterColumnName));
            List<String> dabataResult = new ArrayList<String>();
            while (resultSet.next()){
            	dabataResult.add(resultSet.getString(1));
            }
            return dabataResult;
        }catch(SQLException eSQL){
        	if(eSQL.getErrorCode() == 904){
        		throw new PersistenceException("I", "Application Message", "Selected filter doesnot exixts.");
        	}else{
        		throw new PersistenceException("E", "Application Error", "Unknown database error. Please contact System Administrator.");
        	}
        }
	}

	public final List<List<String>> fetchRecordsFromProblemDetails(Connection objConnection, String filters) throws PersistenceException{
		try{
			List<List<String>> resultList = new ArrayList<List<String>>();
			Statement objStatement = objConnection.createStatement();
            ResultSet resultSet = objStatement.executeQuery(sqlGetAllRecords + filters);
            resultList.add(this.getColumnsName(resultSet));
            while (resultSet.next()){
            	List<String> dabataResult = new ArrayList<String>();
            	for(int i=1; i<=resultList.get(0).size(); i++){
            		dabataResult.add(resultSet.getString(i));
            	}
            	resultList.add(dabataResult);
            }
            return resultList;
        }catch(SQLException eSQL){
        	throw new PersistenceException("E", "Application Error", "Unknown database error. Please contact System Administrator.");
        }
	}

	protected final List<String> getColumnsName(ResultSet resultSet) throws PersistenceException{
		try{
            ResultSetMetaData rsmd = resultSet.getMetaData();
            List<String> dabataResult = new ArrayList<String>();
            for(int i=1; i<=rsmd.getColumnCount(); i++){
				dabataResult.add(rsmd.getColumnName(i));
			}
            return dabataResult;
        }catch(SQLException eSQL){
        	throw new PersistenceException("E", "Application Error", "Unknown database error. Please contact System Administrator.");
        }
	}

	public final List<List<String>> fetchActivityLogs(Connection objConnection, String trackerId) throws PersistenceException{
		try{
			PreparedStatement preparedStatement = objConnection.prepareStatement(sqlGetActivityLogsByTrackerId);
			preparedStatement.setString(1, trackerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<List<String>> dabataResult = new ArrayList<List<String>>();
            int columnCount = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()){
            	List<String> records = new ArrayList<String>();
            	for(int i=1; i<=columnCount; i++){
            		records.add(resultSet.getString(i));
            	}
            	dabataResult.add(records);
            }
            return dabataResult;
        }catch(SQLException eSQL){
        	throw new PersistenceException("E", "Application Error", "Unknown database error. Please contact System Administrator.");
        }
	}
}
