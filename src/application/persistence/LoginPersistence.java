package application.persistence;

/*************************************************************************************************************
 * Created By: Pravin Kumar (id833937)																		 *
 * Creation Date: 05/03/2016																		   		 *
 * Description: Class to perform database operation require for Login										 *
 *************************************************************************************************************/

import application.exceptions.PersistenceException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class LoginPersistence {
	private final String sqlValidateUserId = "select count(U.USER_ID) from REPORT_SCHEMA.E2E_TRACKER_USER_PROFILE U where U.USER_ID = ?";
    private final String sqlFetchPasswordAndAccess = "select U.PASSWORD, U.ACCESS_FLAG from REPORT_SCHEMA.E2E_TRACKER_USER_PROFILE U where U.USER_ID = ?";
    private final String sqlFetchUserDetails = "select U.FIRST_NAME, U.LAST_NAME, U.ACCESS_TYPE from REPORT_SCHEMA.E2E_TRACKER_USER_PROFILE U where U.USER_ID = ?";
    private final String sqlUpdateProfilePassword = "update REPORT_SCHEMA.E2E_TRACKER_USER_PROFILE U set U.PASSWORD = ? where U.USER_ID = ?";

    public final String validateUserId(Connection objConnection, String userId) throws PersistenceException{
        try{
            PreparedStatement preparedStatement = objConnection.prepareStatement(sqlValidateUserId);
            preparedStatement.setString(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            String result = null;
            while (resultSet.next()){
                result = resultSet.getString(1);
            }
            return result;
        }catch(SQLException eSQL){
            throw new PersistenceException("E", "Application Error", "Unknown database error. Please contact System Administrator.");
        }
    }

    public final String[] getPasswordAndAccess(Connection objConnection, String userId) throws PersistenceException{
        try{
            PreparedStatement preparedStatement = objConnection.prepareStatement(sqlFetchPasswordAndAccess);
            preparedStatement.setString(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            String[] arrayResult = new String[2];
            while (resultSet.next()){
                arrayResult[0] = resultSet.getString(1);
                arrayResult[1] = resultSet.getString(2);
            }
            return arrayResult;
        }catch(SQLException eSQL){
            throw new PersistenceException("E", "Application Error", "Unknown database error. Please contact System Administrator.");
        }
    }

    public final String[] getUserDetails(Connection objConnection, String userId)throws PersistenceException{
       try{
           PreparedStatement preparedStatement = objConnection.prepareStatement(sqlFetchUserDetails);
            preparedStatement.setString(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            String[] arrayResult = new String[3];
            while (resultSet.next()){
                arrayResult[0] = resultSet.getString(1);
                arrayResult[1] = resultSet.getString(2);
                arrayResult[2] = resultSet.getString(3);
            }
            return arrayResult;
       }catch(SQLException eSQL){
            throw new PersistenceException("E", "Application Error", "Unknown database error. Please contact System Administrator.");
        }
    }

    public final int updateProfilePassword(Connection objConnection, String password, String userId) throws PersistenceException{
    	 try{
             PreparedStatement preparedStatement = objConnection.prepareStatement(sqlUpdateProfilePassword);
              preparedStatement.setString(1, password);
              preparedStatement.setString(2, userId);
              int result = preparedStatement.executeUpdate();
              return result;
         }catch(SQLException eSQL){
              eSQL.printStackTrace();
              throw new PersistenceException("E", "Application Error", "Unknown database error. Please contact System Administrator.");
          }
    }
}
