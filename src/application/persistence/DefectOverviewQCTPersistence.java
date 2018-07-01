package application.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import application.exceptions.PersistenceException;

public final class DefectOverviewQCTPersistence {

	private final String sqlVerifyE2EDefectId = "select count(bg.bg_bug_id)"
				+" from e2e_project_testing_db.bug bg,"
				+" e2e_project_testing_db.release_cycles rcyc,"
				+" e2e_project_testing_db.releases rel"
				+" where bg.bg_bug_id = ?"
				+" and rcyc.rcyc_id = bg.bg_detected_in_rcyc"
				+" and rcyc.rcyc_parent_id = bg.bg_detected_in_rel"
				+" and rel.rel_id = bg.bg_detected_in_rel";
	private final String sqlE2EDefectDetails = "select bg.bg_bug_id as DEFECT_ID,"
				+" bg.bg_summary as SUMMARY,"
				+" bg.bg_user_01 as APPLICATION,"
				+" bg.bg_user_19 as ENVIRONMENT,"
				+" bg.bg_priority as PRIORITY,"
				+" bg.bg_severity as BUSINESS_RISK,"
				+" bg.bg_user_02 as PROJECT_ID,"
				+" rel.rel_name as DETECTED_IN_RELEASE,"
				+" rcyc.rcyc_name as DETECTED_IN_TEST_STAGE,"
				+" bg.bg_detection_version as DETECTED_IN_VERSION,"
				+" bg.bg_user_40 as FLOW,"
				+" bg.bg_user_10 as DETECTED_BY,"
				+" bg.bg_user_07 as ASSIGNED_TO,"
				+" bg.bg_status as STATUS,"
				+" bg.bg_detection_date as DETECTED_ON_DATE,"
				+" bg.bg_user_11 as ESTIMATED_FIX_DATE,"
				+" bg.bg_user_45 as PRODUCTION_BUG_FIX_DATE,"
				+" bg.bg_closing_date as CLOSING_DATE,"
				+" bg.bg_description as DESCRIPTION,"
				+" bg.bg_dev_comments as COMMENTS"
				+" from e2e_project_testing_db.bug bg,"
				+" e2e_project_testing_db.release_cycles rcyc,"
				+" e2e_project_testing_db.releases rel"
				+" where bg.bg_bug_id = ?"
				+" and rcyc.rcyc_id = bg.bg_detected_in_rcyc"
				+" and rcyc.rcyc_parent_id = bg.bg_detected_in_rel"
				+" and rel.rel_id = bg.bg_detected_in_rel";
	private final String sqlVerifyV1DefectId = "select count(bg.bg_bug_id)"
				+" from omg_tdi_oms_db0.bug bg"
				+" where bg.bg_bug_id = ?";
	private final String sqlV1DefectDetails = "select bg.bg_bug_id as DEFECT_ID,"
			    +" bg.bg_summary as SUMMARY,"
			    +" bg.bg_user_01 as APPLICATION,"
			    +" bg.bg_USER_17 as ENVIRONMENT,"
			    +" bg.Bg_Priority as PRIORITY,"
			    +" bg.Bg_Severity as SEVERITY,"
			    +" bg.bg_user_13 as INVESTIGATION_PRIORITY,"
			    +" bg.bg_project as PROJECT,"
			    +" bg.bg_user_02 as PILOT_IMPACT,"
			    +" bg.bg_detection_version as DETECTED_IN_VERSION,"
			    +" bg.bg_user_30 as WORKAROUND,"
			    +" bg.bg_user_18 as DETECTED_BY,"
			    +" bg.bg_user_26 as ASSIGNED_TO,"
			    +" bg.bg_status as STATUS,"
			    +" bg.bg_detection_date as DETECTED_ON_DATE,"
			    +" bg.bg_user_11 as EST1MATED_FIX_DATE,"
			    +" bg.bg_vts as MODIFIED,"
			    +" bg.bg_closing_date as CLOSING_DATE,"
			    +" bg.bg_description as DESCRIPTION,"
			    +" bg.bg_dev_comments as COMMENTS"
			    +" from omg_tdi_oms_db0.bug bg"
			    +" where bg.bg_bug_id = ?";
	private final String sqlMapE2EDefectToProblem = "select BG.BG_USER_01 as APPLICATION,"
				 +" BG.BG_SEVERITY as BUSINESS_RISK,"
				 +" REL.REL_NAME as DETECTED_IN_RELEASE,"
				 +" BG.BG_USER_07 as ASSIGNED_TO"
				 +" from E2E_PROJECT_TESTING_DB.BUG BG, E2E_PROJECT_TESTING_DB.RELEASES REL"
				 +" where BG.BG_BUG_ID = ?"
				 +" and REL.REL_ID = BG.BG_DETECTED_IN_REL";
	private final String sqlMapV1DefectToProblem = "select BG.BG_USER_01 as APPLICATION,"
		       +" BG.BG_PRIORITY as PRIORITY,"
		       +" BG.BG_DETECTION_VERSION as DETECTED_IN_VERSION,"
		       +" BG.BG_USER_26 as ASSIGNED_TO"
		       +" from OMG_TDI_OMS_DB0.BUG BG"
		       +" where BG.BG_BUG_ID = ?";
	public final String verifyE2EDefectId(Connection objQCTConnection, String defectId) throws PersistenceException{
		try{
			Statement objStatement = objQCTConnection.createStatement();
            ResultSet resultSet = objStatement.executeQuery(sqlVerifyE2EDefectId.replace("?", defectId));
            String result = null;
            while (resultSet.next()){
                result = resultSet.getString(1);
            }
            return result;
        }catch(SQLException eSQL){
        	if(eSQL.getErrorCode() == 904){
        		throw new PersistenceException("I", "Application Message", "Invalid Defect ID. It must contains only numbers.");
        	}else{
        		throw new PersistenceException("E", "Application Error", "Unknown database error. Please contact System Administrator.");
        	}
        }
	}

	public final String verifyV1DefectId(Connection objQCTConnection, String defectId) throws PersistenceException{
		try{
			Statement objStatement = objQCTConnection.createStatement();
            ResultSet resultSet = objStatement.executeQuery(sqlVerifyV1DefectId.replace("?", defectId));
            String result = null;
            while (resultSet.next()){
                result = resultSet.getString(1);
            }
            return result;
        }catch(SQLException eSQL){
        	if(eSQL.getErrorCode() == 904){
        		throw new PersistenceException("I", "Application Message", "Invalid Defect ID. It must contains only numbers.");
        	}else{
        		throw new PersistenceException("E", "Application Error", "Unknown database error. Please contact System Administrator.");
        	}
        }
	}

	public final String[] fetchE2EDefectDetails(Connection objQCTConnection, String defectId) throws PersistenceException{
		try{
			Statement objStatement = objQCTConnection.createStatement();
            ResultSet resultSet = objStatement.executeQuery(sqlE2EDefectDetails.replace("?", defectId));
            String[] databaseResult = new String[20];
            while (resultSet.next()){
            	for (int i=0; i<20; i++){
            		databaseResult[i] = resultSet.getString(i+1);
            	}
            }
            return databaseResult;
        }catch(SQLException eSQL){
        	if(eSQL.getErrorCode() == 904){
        		throw new PersistenceException("I", "Application Message", "Invalid Defect ID. It must contains only numbers.");
        	}else{
        		throw new PersistenceException("E", "Application Error", "Unknown database error. Please contact System Administrator.");
        	}
        }
	}

	public final String[] fetchV1DefectDetails(Connection objQCTConnection, String defectId) throws PersistenceException{
		try{
			Statement objStatement = objQCTConnection.createStatement();
            ResultSet resultSet = objStatement.executeQuery(sqlV1DefectDetails.replace("?", defectId));
            String[] databaseResult = new String[20];
            while (resultSet.next()){
            	for (int i=0; i<20; i++){
            		databaseResult[i] = resultSet.getString(i+1);
            	}
            }
            return databaseResult;
        }catch(SQLException eSQL){
        	if(eSQL.getErrorCode() == 904){
        		throw new PersistenceException("I", "Application Message", "Invalid Defect ID. It must contains only numbers.");
        	}else{
        		throw new PersistenceException("E", "Application Error", "Unknown database error. Please contact System Administrator.");
        	}
        }
	}

	public final List<String> mapE2EDefectToProblem(Connection objQCTConnection, String defectId) throws PersistenceException{
		try{
			Statement objStatement = objQCTConnection.createStatement();
            ResultSet resultSet = objStatement.executeQuery(sqlMapE2EDefectToProblem.replace("?", defectId));
            ResultSetMetaData rsmd = resultSet.getMetaData();
            List<String> databaseResult = new ArrayList<String>();
            while (resultSet.next()){
            	for (int i=1; i<=rsmd.getColumnCount(); i++){
            		databaseResult.add(resultSet.getString(i));
            	}
            }
            return databaseResult;
        }catch(SQLException eSQL){
        	eSQL.printStackTrace();
        	if(eSQL.getErrorCode() == 904){
        		throw new PersistenceException("I", "Application Message", "Invalid Defect ID. It must contains only numbers.");
        	}else{
        		throw new PersistenceException("E", "Application Error", "Unknown database error. Please contact System Administrator.");
        	}
        }
	}

	public final List<String> mapV1DefectToProblem(Connection objQCTConnection, String defectId) throws PersistenceException{
		try{
			Statement objStatement = objQCTConnection.createStatement();
            ResultSet resultSet = objStatement.executeQuery(sqlMapV1DefectToProblem.replace("?", defectId));
            ResultSetMetaData rsmd = resultSet.getMetaData();
            List<String> databaseResult = new ArrayList<String>();
            while (resultSet.next()){
            	for (int i=1; i<=rsmd.getColumnCount(); i++){
            		databaseResult.add(resultSet.getString(i));
            	}
            }
            return databaseResult;
        }catch(SQLException eSQL){
        	eSQL.printStackTrace();
        	if(eSQL.getErrorCode() == 904){
        		throw new PersistenceException("I", "Application Message", "Invalid Defect ID. It must contains only numbers.");
        	}else{
        		throw new PersistenceException("E", "Application Error", "Unknown database error. Please contact System Administrator.");
        	}
        }
	}
}
