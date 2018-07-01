package application.beans;

import java.util.List;
import java.util.Map;

public class DashboardBean {

	private List<String> filterComboBoxAllItems;
	private Map<String, String> mapFilterItemToTableColumn;
	private Map<String, List<String>> mapAllListItemsForAllFilterItems;
	private List<List<String>> filterDetails;
	private boolean firstFilterActiveFlag;
	private List<String> firstFilterComboBoxAllItems;
	private String firstFilterComboBoxSelectedItem;
	private List<String> firstFilterJListAllItems;
	private List<String> firstFilterJListSelectedItems;
	private boolean secondFilterActiveFlag;
	private List<String> secondFilterComboBoxAllItems;
	private String secondFilterComboBoxSelectedItem;
	private List<String> secondFilterJListAllItems;
	private List<String> secondFilterJListSelectedItems;
	private boolean thirdFilterActiveFlag;
	private List<String> thirdFilterComboBoxAllItems;
	private String thirdFilterComboBoxSelectedItem;
	private List<String> thirdFilterJListAllItems;
	private List<String> thirdFilterJListSelectedItems;
	private boolean fourthFilterActiveFlag;
	private List<String> fourthFilterComboBoxAllItems;
	private String fourthFilterComboBoxSelectedItem;
	private List<String> fourthFilterJListAllItems;
	private List<String> fourthFilterJListSelectedItems;
	private List<List<String>> tableRecords;

	public final List<List<String>> getFilterDetails() {
		return filterDetails;
	}

	public final void setFilterDetails(List<List<String>> filterDetails) {
		this.filterDetails = filterDetails;
	}

	public final List<String> getFilterComboBoxAllItems() {
		return filterComboBoxAllItems;
	}


	public final void setFilterComboBoxAllItems(List<String> filterComboBoxAllItems) {
		this.filterComboBoxAllItems = filterComboBoxAllItems;
	}

	public final void setMapFilterItemToTableColumn(
			Map<String, String> mapFilterItemToTableColumn) {
		this.mapFilterItemToTableColumn = mapFilterItemToTableColumn;
	}

	public final Map<String, String> getMapFilterItemToTableColumn() {

		return mapFilterItemToTableColumn;
	}


	public final Map<String, List<String>> getMapAllListItemsForAllFilterItems() {
		return mapAllListItemsForAllFilterItems;
	}

	public final void setMapAllListItemsForAllFilterItems(
			Map<String, List<String>> mapAllListItemsForAllFilterItems) {
		this.mapAllListItemsForAllFilterItems = mapAllListItemsForAllFilterItems;
	}

	public final boolean isFirstFilterActiveFlag() {
		return firstFilterActiveFlag;
	}

	public final void setFirstFilterActiveFlag(boolean firstFilterActiveFlag) {
		this.firstFilterActiveFlag = firstFilterActiveFlag;
	}

	public final List<String> getFirstFilterComboBoxAllItems() {
		return firstFilterComboBoxAllItems;
	}

	public final void setFirstFilterComboBoxAllItems(
			List<String> firstFilterComboBoxAllItems) {
		this.firstFilterComboBoxAllItems = firstFilterComboBoxAllItems;
	}

	public final String getFirstFilterComboBoxSelectedItem() {
		return firstFilterComboBoxSelectedItem;
	}

	public final void setFirstFilterComboBoxSelectedItem(
			String firstFilterComboBoxSelectedItem) {
		this.firstFilterComboBoxSelectedItem = firstFilterComboBoxSelectedItem;
	}

	public final List<String> getFirstFilterJListAllItems() {
		return firstFilterJListAllItems;
	}

	public final void setFirstFilterJListAllItems(
			List<String> firstFilterJListAllItems) {
		this.firstFilterJListAllItems = firstFilterJListAllItems;
	}

	public final List<String> getFirstFilterJListSelectedItems() {
		return firstFilterJListSelectedItems;
	}

	public final void setFirstFilterJListSelectedItems(
			List<String> firstFilterJListSelectedItems) {
		this.firstFilterJListSelectedItems = firstFilterJListSelectedItems;
	}

	public final boolean isSecondFilterActiveFlag() {
		return secondFilterActiveFlag;
	}

	public final void setSecondFilterActiveFlag(boolean secondFilterActiveFlag) {
		this.secondFilterActiveFlag = secondFilterActiveFlag;
	}

	public final List<String> getSecondFilterComboBoxAllItems() {
		return secondFilterComboBoxAllItems;
	}

	public final void setSecondFilterComboBoxAllItems(
			List<String> secondFilterComboBoxAllItems) {
		this.secondFilterComboBoxAllItems = secondFilterComboBoxAllItems;
	}

	public final String getSecondFilterComboBoxSelectedItem() {
		return secondFilterComboBoxSelectedItem;
	}

	public final void setSecondFilterComboBoxSelectedItem(
			String secondFilterComboBoxSelectedItem) {
		this.secondFilterComboBoxSelectedItem = secondFilterComboBoxSelectedItem;
	}

	public final List<String> getSecondFilterJListAllItems() {
		return secondFilterJListAllItems;
	}

	public final void setSecondFilterJListAllItems(
			List<String> secondFilterJListAllItems) {
		this.secondFilterJListAllItems = secondFilterJListAllItems;
	}

	public final List<String> getSecondFilterJListSelectedItems() {
		return secondFilterJListSelectedItems;
	}

	public final void setSecondFilterJListSelectedItems(
			List<String> secondFilterJListSelectedItems) {
		this.secondFilterJListSelectedItems = secondFilterJListSelectedItems;
	}

	public final boolean isThirdFilterActiveFlag() {
		return thirdFilterActiveFlag;
	}

	public final void setThirdFilterActiveFlag(boolean thirdFilterActiveFlag) {
		this.thirdFilterActiveFlag = thirdFilterActiveFlag;
	}

	public final List<String> getThirdFilterComboBoxAllItems() {
		return thirdFilterComboBoxAllItems;
	}

	public final void setThirdFilterComboBoxAllItems(
			List<String> thirdFilterComboBoxAllItems) {
		this.thirdFilterComboBoxAllItems = thirdFilterComboBoxAllItems;
	}

	public final String getThirdFilterComboBoxSelectedItem() {
		return thirdFilterComboBoxSelectedItem;
	}

	public final void setThirdFilterComboBoxSelectedItem(
			String thirdFilterComboBoxSelectedItem) {
		this.thirdFilterComboBoxSelectedItem = thirdFilterComboBoxSelectedItem;
	}

	public final List<String> getThirdFilterJListAllItems() {
		return thirdFilterJListAllItems;
	}

	public final void setThirdFilterJListAllItems(
			List<String> thirdFilterJListAllItems) {
		this.thirdFilterJListAllItems = thirdFilterJListAllItems;
	}

	public final List<String> getThirdFilterJListSelectedItems() {
		return thirdFilterJListSelectedItems;
	}

	public final void setThirdFilterJListSelectedItems(
			List<String> thirdFilterJListSelectedItems) {
		this.thirdFilterJListSelectedItems = thirdFilterJListSelectedItems;
	}

	public final boolean isFourthFilterActiveFlag() {
		return fourthFilterActiveFlag;
	}

	public final void setFourthFilterActiveFlag(boolean fourthFilterActiveFlag) {
		this.fourthFilterActiveFlag = fourthFilterActiveFlag;
	}

	public final List<String> getFourthFilterComboBoxAllItems() {
		return fourthFilterComboBoxAllItems;
	}

	public final void setFourthFilterComboBoxAllItems(
			List<String> fourthFilterComboBoxAllItems) {
		this.fourthFilterComboBoxAllItems = fourthFilterComboBoxAllItems;
	}

	public final String getFourthFilterComboBoxSelectedItem() {
		return fourthFilterComboBoxSelectedItem;
	}

	public final void setFourthFilterComboBoxSelectedItem(
			String fourthFilterComboBoxSelectedItem) {
		this.fourthFilterComboBoxSelectedItem = fourthFilterComboBoxSelectedItem;
	}

	public final List<String> getFourthFilterJListAllItems() {
		return fourthFilterJListAllItems;
	}

	public final void setFourthFilterJListAllItems(
			List<String> fourthFilterJListAllItems) {
		this.fourthFilterJListAllItems = fourthFilterJListAllItems;
	}

	public final List<String> getFourthFilterJListSelectedItems() {
		return fourthFilterJListSelectedItems;
	}

	public final void setFourthFilterJListSelectedItems(
			List<String> fourthFilterJListSelectedItems) {
		this.fourthFilterJListSelectedItems = fourthFilterJListSelectedItems;
	}

	public final List<List<String>> getTableRecords() {
		return tableRecords;
	}

	public final void setTableRecords(List<List<String>> tableRecords) {
		this.tableRecords = tableRecords;
	}
}
