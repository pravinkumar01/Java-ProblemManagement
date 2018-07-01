package application.exceptions;

/*************************************************************************************************************
 * Created By: Pravin Kumar (id833937)																		 *
 * Creation Date: 05/03/2016																		   		 *
 * Description: Exception class for application.persistence package												 *
 *************************************************************************************************************/

public class ManagerException extends Exception{

	private static final long serialVersionUID = 1L;
	private final int errorCode;
    private final String errorType;
    private final String errorName;
    private final String errorMessage;

    public ManagerException(int errorCode, String errorType, String errorName, String errorMessage) {
        this.errorCode = errorCode;
        this.errorType = errorType;
        this.errorName = errorName;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorType() {
        return errorType;
    }

    public String getErrorName() {
        return errorName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
