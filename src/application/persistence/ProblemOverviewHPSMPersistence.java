package application.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.exceptions.PersistenceException;

public final class ProblemOverviewHPSMPersistence {

	private final String sqlVerifyPmId = "Select count(rca.id)"
					+" from sce_schema.ROOTCAUSEM1 rca"
					+" where rca.id = ?";

	private final String sqlFetchPmDetails = "Select rca.id"
					+" ,rca.assignment"
					+" ,rca.status"
					+" ,rca.open_time"
					+" ,rca.brief_description"
					+" ,rca.description"
					+" ,rca.root_cause"
					+" ,rca.updateprgn"
					+" ,rca.opened_by"
					+" ,rca.ticket_owner"
					+" ,rca.resolution"
					+" ,rca.workaround"
					+" from sce_schema.ROOTCAUSEM1 rca"
					+" where rca.id = ?";

	public final String verifyProblemIdHPSM(Connection objHPSMConnection, String problemId) throws PersistenceException{
		try{
			Statement objStatement = objHPSMConnection.createStatement();
            ResultSet resultSet = objStatement.executeQuery(sqlVerifyPmId.replace("?", "'"+ problemId+"'"));
            String result = null;
            while (resultSet.next()){
                result = resultSet.getString(1);
            }
            return result;
		}catch(SQLException eSQL){
        	if(eSQL.getErrorCode() == 904){
        		throw new PersistenceException("I", "Application Message", "Invalid Problem ID. It must be in format PMXXXXXX.");
        	}else{
        		throw new PersistenceException("E", "Application Error", "Unknown database error. Please contact System Administrator.");
        	}
        }
	}

	public final String[] fetchProblemDetailsHPSM(Connection objHPSMConnection, String problemId) throws PersistenceException{
		try{
			Statement objStatement = objHPSMConnection.createStatement();
            ResultSet resultSet = objStatement.executeQuery(sqlFetchPmDetails.replace("?","'"+ problemId+"'"));
            String[] databaseResult = new String[12];
            while (resultSet.next()){
            	for (int i=0; i<12; i++){
            		databaseResult[i] = resultSet.getString(i+1);
            	}
            }
            return databaseResult;
        }catch(SQLException eSQL){
        	if(eSQL.getErrorCode() == 904){
        		throw new PersistenceException("I", "Application Message", "Invalid Problem ID. It must be in format PMXXXXXX.");
        	}else{
        		throw new PersistenceException("E", "Application Error", "Unknown database error. Please contact System Administrator.");
        	}
        }
	}
}
