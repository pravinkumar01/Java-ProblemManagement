package application.exceptions;

/*************************************************************************************************************
 * Created By: Pravin Kumar (id833937)																		 *
 * Creation Date: 05/03/2016																		   		 *
 * Description: Exception class for application.manager package												 *
 *************************************************************************************************************/
public class PersistenceException extends Exception{

	private static final long serialVersionUID = 1L;
	private final String errorType;
    private final String errorName;
    private final String errorMessage;

    public PersistenceException(String errorType, String errorName, String errorMessage) {
        this.errorType = errorType;
        this.errorName = errorName;
        this.errorMessage = errorMessage;
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
