package application.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.exceptions.PersistenceException;

public final class IncidentOverviewHPSMPersistence {

	private final String sqlVerifyIncidentId = "Select count(T.NUMBERPRGN)"
				+" from SCE_SCHEMA.PROBSUMMARYM1 t where T.NUMBERPRGN = '?'";

	private final String sqlFetchIncidentDetails = "select T.NUMBERPRGN as INCIDENT_ID,"
		       + " T.BRIEF_DESCRIPTION as TITLE,"
		       + " T.PROBLEM_TYPE as PROBLEM_TYPE,"
		       + " T.PROBLEM_STATUS as STATUS,"
		       + " T.LOGICAL_NAME as CONFIGURATION_ITEM,"
		       + " T.CONTACT_NAME as REQUESTOR_ID,"
		       + " T.OPENED_BY as REQUESTED_BY,"
		       + " T.OPEN_TIME as OPEN_TIME,"
		       + " T.CLOSE_TIME as CLOSE_TIME,"
		       + " T.ASSIGNMENT as ASSIGNMENT_GROUP,"
		       + " T.ASSIGNEE_NAME as ASSIGNEE_ID,"
		       + " T.ACTOR as ASIGNEE_NAME,"
		       + " T.UPDATED_BY as UPDATED_BY,"
		       + " T.RESOLVED_BY as RESOLVED_BY,"
		       + " T.ACTION as DESCRIPTION,"
		       + " T.CLOSING_COMMENTS as RESOLUTION_COMMENT,"
		       + " T.UPDATE_ACTION as PROGRESS"
		       + " from SCE_SCHEMA.PROBSUMMARYM1 T where T.NUMBERPRGN = '?'";

	public final String verifyIncidentId(Connection objHPSMConnection, String incidentId) throws PersistenceException{
		try{
			Statement objStatement = objHPSMConnection.createStatement();
            ResultSet resultSet = objStatement.executeQuery(sqlVerifyIncidentId.replace("?", incidentId));
            String result = null;
            while (resultSet.next()){
                result = resultSet.getString(1);
            }
            return result;
        }catch(SQLException eSQL){
        	eSQL.printStackTrace();
        	if(eSQL.getErrorCode() == 904){
        		throw new PersistenceException("I", "Application Message", "Invalid Incident ID. It must be in format IMxxxxxxx.");
        	}else{
        		throw new PersistenceException("E", "Application Error", "Unknown database error. Please contact System Administrator.");
        	}
        }
	}

	public final String[] fetchIncidentDetails(Connection objHPSMConnection, String incidentId) throws PersistenceException{
		try{
			Statement objStatement = objHPSMConnection.createStatement();
            ResultSet resultSet = objStatement.executeQuery(sqlFetchIncidentDetails.replace("?", incidentId));
            String[] databaseResult = new String[17];
            while (resultSet.next()){
            	for (int i=0; i<17; i++){
            		databaseResult[i] = resultSet.getString(i+1);
            	}
            }
            return databaseResult;
        }catch(SQLException eSQL){
        	if(eSQL.getErrorCode() == 904){
        		throw new PersistenceException("I", "Application Message", "Invalid Incident ID. It must be in format IMxxxxxxx.");
        	}else{
        		throw new PersistenceException("E", "Application Error", "Unknown database error. Please contact System Administrator.");
        	}
        }
	}
}
