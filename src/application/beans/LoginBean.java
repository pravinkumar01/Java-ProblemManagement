package application.beans;

/*************************************************************************************************************
 * Created By: Pravin Kumar (id833937)																		 *
 * Creation Date: 05/03/2016																		   		 *
 * Description: Bean class to hold data for LoginWindow											             *
 *************************************************************************************************************/
public class LoginBean {
    private final String userId;
    private final String firstName;
    private final String lastName;
    private final String accessType;

    public LoginBean(String userId, String firstName, String lastName, String accessType) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accessType = accessType;
    }

    public final String getUserId() {
        return userId;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final String getLastName() {
        return lastName;
    }

    public final String getAccessType() {
        return accessType;
    }


}
