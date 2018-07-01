package application.beans;

import java.util.List;

public class AdminWorkspaceBean {
	private List<String> listUserId;
	private String userId;
	private String password;
	private String firstName;
	private String LastName;
	private String accessType;
	private String accessFlag;
	private String selectedOptionName;
	private List<String> selectedOptionValueList;
	private String selectOptionValue;

	public final List<String> getListUserId() {
		return listUserId;
	}

	public final void setListUserId(List<String> listUserId) {
		this.listUserId = listUserId;
	}

	public final String getUserId() {
		return userId;
	}

	public final void setUserId(String userId) {
		this.userId = userId;
	}

	public final String getPassword() {
		return password;
	}

	public final void setPassword(String password) {
		this.password = password;
	}

	public final String getFirstName() {
		return firstName;
	}

	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public final String getLastName() {
		return LastName;
	}

	public final void setLastName(String lastName) {
		LastName = lastName;
	}

	public final String getAccessType() {
		return accessType;
	}

	public final void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	public final String getAccessFlag() {
		return accessFlag;
	}

	public final void setAccessFlag(String accessFlag) {
		this.accessFlag = accessFlag;
	}

	public final String getSelectedOptionName() {
		return selectedOptionName;
	}

	public final void setSelectedOptionName(String selectedOptionName) {
		this.selectedOptionName = selectedOptionName;
	}

	public final List<String> getSelectedOptionValueList() {
		return selectedOptionValueList;
	}

	public final void setSelectedOptionValueList(
			List<String> selectedOptionValueList) {
		this.selectedOptionValueList = selectedOptionValueList;
	}

	public final String getSelectOptionValue() {
		return selectOptionValue;
	}

	public final void setSelectOptionValue(String selectOptionValue) {
		this.selectOptionValue = selectOptionValue;
	}
}
