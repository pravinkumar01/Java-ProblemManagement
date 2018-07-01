package application.manager;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import application.beans.DashboardBean;
import application.exceptions.ManagerException;
import application.exceptions.PersistenceException;
import application.frames.ResourceProvider;
import application.persistence.DashboardPersistence;

public class DashboardManager {

	private final ResourceProvider objResourceProvider;
	private final DashboardPersistence objDashboardPersistence;
	private final DashboardBean objDashboardBean;

	public DashboardManager(ResourceProvider objResourceProvider, DashboardBean objDashboardBean) {
		this.objResourceProvider = objResourceProvider;
		this.objDashboardPersistence = new DashboardPersistence();
		this.objDashboardBean = objDashboardBean;
	}

	public void initBeanComponentDefaultValue(Connection objLocalConnection) throws ManagerException{
		List<String> defaultFilterItems = new ArrayList<String>();
		defaultFilterItems.add("--Select Filter--");
		defaultFilterItems.add("Problem Type");
		defaultFilterItems.add("Business Risk");
		defaultFilterItems.add("Detected In");
		defaultFilterItems.add("Status");
		defaultFilterItems.add("Application Name");
		defaultFilterItems.add("Sys. Ret. Error");
		defaultFilterItems.add("Work Basket");
		defaultFilterItems.add("Issue Logged By");
		defaultFilterItems.add("Last Updated By");
		this.objDashboardBean.setFilterComboBoxAllItems(defaultFilterItems);

		Map<String, String> mapFilterItemToTableColumn = new TreeMap<String, String>();
		mapFilterItemToTableColumn.put("Problem Type", "PROBLEM_TYPE");
		mapFilterItemToTableColumn.put("Business Risk", "BUSINESS_RISK");
		mapFilterItemToTableColumn.put("Detected In", "DETECTED_IN");
		mapFilterItemToTableColumn.put("Status", "STATUS");
		mapFilterItemToTableColumn.put("Application Name", "APPLICATION_NAME");
		mapFilterItemToTableColumn.put("Sys. Ret. Error", "SYS_RET_ERROR");
		mapFilterItemToTableColumn.put("Work Basket", "WORK_BASKET");
		mapFilterItemToTableColumn.put("Issue Logged By", "ISSUE_LOGGED_BY");
		mapFilterItemToTableColumn.put("Last Updated By", "LAST_UPDATED_BY");
		this.objDashboardBean.setMapFilterItemToTableColumn(mapFilterItemToTableColumn);

		this.resetValuesOfAllListItemsForAllFilterItems(objLocalConnection);

		List<List<String>> defaultFilterDetails = new ArrayList<List<String>>();
		defaultFilterDetails.add(null);
		defaultFilterDetails.add(null);
		defaultFilterDetails.add(null);
		defaultFilterDetails.add(null);
		this.objDashboardBean.setFilterDetails(defaultFilterDetails);

		this.objDashboardBean.setFirstFilterActiveFlag(false);
		this.objDashboardBean.setSecondFilterActiveFlag(false);
		this.objDashboardBean.setThirdFilterActiveFlag(false);
		this.objDashboardBean.setFourthFilterActiveFlag(false);

		this.objDashboardBean.setFirstFilterComboBoxAllItems(defaultFilterItems);
		this.objDashboardBean.setSecondFilterComboBoxAllItems(defaultFilterItems);
		this.objDashboardBean.setThirdFilterComboBoxAllItems(defaultFilterItems);
		this.objDashboardBean.setFourthFilterComboBoxAllItems(defaultFilterItems);

		this.objDashboardBean.setFirstFilterComboBoxSelectedItem("--Select Filter--");
		this.objDashboardBean.setSecondFilterComboBoxSelectedItem("--Select Filter--");
		this.objDashboardBean.setThirdFilterComboBoxSelectedItem("--Select Filter--");
		this.objDashboardBean.setFourthFilterComboBoxSelectedItem("--Select Filter--");

		for(int i = 1; i<=4; i++){
			this.resetValuesOfListItemForSelectedFilterItem(i, "--Select Filter--");
		}

		List<String> defaultSelectedListItems = new ArrayList<String>();
		defaultSelectedListItems.add(null);
		this.objDashboardBean.setFirstFilterJListSelectedItems(defaultSelectedListItems);
		this.objDashboardBean.setSecondFilterJListSelectedItems(defaultSelectedListItems);
		this.objDashboardBean.setThirdFilterJListSelectedItems(defaultSelectedListItems);
		this.objDashboardBean.setFourthFilterJListSelectedItems(defaultSelectedListItems);
		this.btnApplyFiltersActionPerformed(objLocalConnection, false);
	}

	public void cmbbxFirstFilterMouseEntered(String selesctedFilterValue){
		if(this.objDashboardBean.isFirstFilterActiveFlag() == false){
			this.resetValueOfSelectedFilterItem(1, selesctedFilterValue);
			this.resetApplicableValuesOfFilterItem(1);
			this.resetValuesOfListItemForSelectedFilterItem(1, selesctedFilterValue);
		}
	}

	public void cmbbxSecondFilterMouseEntered(String selesctedFilterValue){
		if(this.objDashboardBean.isSecondFilterActiveFlag() == false){
			this.resetValueOfSelectedFilterItem(2, selesctedFilterValue);
			this.resetApplicableValuesOfFilterItem(2);
			this.resetValuesOfListItemForSelectedFilterItem(2, selesctedFilterValue);
		}
	}

	public void cmbbxThirdFilterMouseEntered(String selesctedFilterValue){
		if(this.objDashboardBean.isThirdFilterActiveFlag() == false){
			this.resetValueOfSelectedFilterItem(3, selesctedFilterValue);
			this.resetApplicableValuesOfFilterItem(3);
			this.resetValuesOfListItemForSelectedFilterItem(3, selesctedFilterValue);
		}
	}

	public void cmbbxFourthFilterMouseEntered(String selesctedFilterValue){
		if(this.objDashboardBean.isFourthFilterActiveFlag() == false){
			this.resetValueOfSelectedFilterItem(4, selesctedFilterValue);
			this.resetApplicableValuesOfFilterItem(4);
			this.resetValuesOfListItemForSelectedFilterItem(4, selesctedFilterValue);
		}
	}

	public void cmbbxFirstFilterItemStateChanged(String firstFilterSelectedItem){
		this.resetValueOfSelectedFilterItem(1, firstFilterSelectedItem);
		this.resetValuesOfListItemForSelectedFilterItem(1, firstFilterSelectedItem);
		this.objDashboardBean.setFirstFilterJListAllItems(this.objDashboardBean.getMapAllListItemsForAllFilterItems().get(firstFilterSelectedItem));
		this.objDashboardBean.setFirstFilterActiveFlag(false);
	}

	public void cmbbxSecondFilterItemStateChanged(String secondFilterSelectedItem){
		this.resetValueOfSelectedFilterItem(2, secondFilterSelectedItem);
		this.resetValuesOfListItemForSelectedFilterItem(2, secondFilterSelectedItem);
		this.objDashboardBean.setSecondFilterJListAllItems(this.objDashboardBean.getMapAllListItemsForAllFilterItems().get(secondFilterSelectedItem));
		this.objDashboardBean.setSecondFilterActiveFlag(false);
	}

	public void cmbbxThirdFilterItemStateChanged(String thirdFilterSelectedItem){
		this.resetValueOfSelectedFilterItem(3, thirdFilterSelectedItem);
		this.resetValuesOfListItemForSelectedFilterItem(3, thirdFilterSelectedItem);
		this.objDashboardBean.setThirdFilterJListAllItems(this.objDashboardBean.getMapAllListItemsForAllFilterItems().get(thirdFilterSelectedItem));
		this.objDashboardBean.setThirdFilterActiveFlag(false);
	}

	public void cmbbxFourthFilterItemStateChanged(String fourthFilterSelectedItem){
		this.resetValueOfSelectedFilterItem(4, fourthFilterSelectedItem);
		this.resetValuesOfListItemForSelectedFilterItem(4, fourthFilterSelectedItem);
		this.objDashboardBean.setFourthFilterJListAllItems(this.objDashboardBean.getMapAllListItemsForAllFilterItems().get(fourthFilterSelectedItem));
		this.objDashboardBean.setFourthFilterActiveFlag(false);
	}

	public void listFirstFilterValueChanged(List<String> firstFilterSelectedListItems){
		this.objDashboardBean.setFirstFilterJListSelectedItems(firstFilterSelectedListItems);
		this.objDashboardBean.setFirstFilterActiveFlag(true);

		if(!(this.objDashboardBean.isSecondFilterActiveFlag())){
			this.resetApplicableValuesOfFilterItem(2);
			this.objDashboardBean.setSecondFilterJListAllItems(this.objDashboardBean.getMapAllListItemsForAllFilterItems().get("--Select Filter--"));
		}

		if(!(this.objDashboardBean.isThirdFilterActiveFlag())){
			this.resetApplicableValuesOfFilterItem(3);
			this.objDashboardBean.setThirdFilterJListAllItems(this.objDashboardBean.getMapAllListItemsForAllFilterItems().get("--Select Filter--"));
		}

		if(!(this.objDashboardBean.isFourthFilterActiveFlag())){
			this.resetApplicableValuesOfFilterItem(4);
			this.objDashboardBean.setFourthFilterJListAllItems(this.objDashboardBean.getMapAllListItemsForAllFilterItems().get("--Select Filter--"));
		}
	}

	public void listSecondFilterValueChanged(List<String> secondFilterSelectedListItems){
		this.objDashboardBean.setSecondFilterJListSelectedItems(secondFilterSelectedListItems);
		this.objDashboardBean.setSecondFilterActiveFlag(true);

		if(!(this.objDashboardBean.isFirstFilterActiveFlag())){
			this.resetApplicableValuesOfFilterItem(1);
			this.objDashboardBean.setFirstFilterJListAllItems(this.objDashboardBean.getMapAllListItemsForAllFilterItems().get("--Select Filter--"));
		}

		if(!(this.objDashboardBean.isThirdFilterActiveFlag())){
			System.out.println("inside");
			this.resetApplicableValuesOfFilterItem(3);
			this.objDashboardBean.setThirdFilterJListAllItems(this.objDashboardBean.getMapAllListItemsForAllFilterItems().get("--Select Filter--"));
		}

		if(!(this.objDashboardBean.isFourthFilterActiveFlag())){
			this.resetApplicableValuesOfFilterItem(4);
			this.objDashboardBean.setFourthFilterJListAllItems(this.objDashboardBean.getMapAllListItemsForAllFilterItems().get("--Select Filter--"));
		}
	}

	public void listThirdFilterValueChanged(List<String> thirdFilterSelectedListItems){
		this.objDashboardBean.setThirdFilterJListSelectedItems(thirdFilterSelectedListItems);
		this.objDashboardBean.setThirdFilterActiveFlag(true);

		if(!(this.objDashboardBean.isFirstFilterActiveFlag())){
			this.resetApplicableValuesOfFilterItem(1);
			this.objDashboardBean.setFirstFilterJListAllItems(this.objDashboardBean.getMapAllListItemsForAllFilterItems().get("--Select Filter--"));
		}

		if(!(this.objDashboardBean.isSecondFilterActiveFlag())){
			this.resetApplicableValuesOfFilterItem(2);
			this.objDashboardBean.setSecondFilterJListAllItems(this.objDashboardBean.getMapAllListItemsForAllFilterItems().get("--Select Filter--"));
		}

		if(!(this.objDashboardBean.isFourthFilterActiveFlag())){
			this.resetApplicableValuesOfFilterItem(4);
			this.objDashboardBean.setFourthFilterJListAllItems(this.objDashboardBean.getMapAllListItemsForAllFilterItems().get("--Select Filter--"));
		}
	}

	public void listFourthFilterValueChanged(List<String> fourthFilterSelectedListItems){
		this.objDashboardBean.setFourthFilterJListSelectedItems(fourthFilterSelectedListItems);
		this.objDashboardBean.setFourthFilterActiveFlag(true);

		if(!(this.objDashboardBean.isFirstFilterActiveFlag())){
			this.resetApplicableValuesOfFilterItem(1);
			this.objDashboardBean.setFirstFilterJListAllItems(this.objDashboardBean.getMapAllListItemsForAllFilterItems().get("--Select Filter--"));
		}

		if(!(this.objDashboardBean.isSecondFilterActiveFlag())){
			this.resetApplicableValuesOfFilterItem(2);
			this.objDashboardBean.setSecondFilterJListAllItems(this.objDashboardBean.getMapAllListItemsForAllFilterItems().get("--Select Filter--"));
		}

		if(!(this.objDashboardBean.isThirdFilterActiveFlag())){
			this.resetApplicableValuesOfFilterItem(3);
			this.objDashboardBean.setThirdFilterJListAllItems(this.objDashboardBean.getMapAllListItemsForAllFilterItems().get("--Select Filter--"));
		}
	}

	private void resetValuesOfAllListItemsForAllFilterItems(Connection objLocalConnection) throws ManagerException{
		try{
			Map<String, List<String>> newMapAllListItemsForAllFilterItems = new TreeMap<String, List<String>>();
			List<String> allFilterItems = this.objDashboardBean.getFilterComboBoxAllItems();
			for(int i = 0; i<allFilterItems.size(); i++){
				List<String> tempList = null;
				if(i == 0){
					tempList = new ArrayList<String>();
					tempList.add(null);
				}else{
					tempList = this.objDashboardPersistence.getListOfAllItemsForSelectedFilterItem(
							objLocalConnection, this.objDashboardBean.getMapFilterItemToTableColumn().get(allFilterItems.get(i)));
				}
				newMapAllListItemsForAllFilterItems.put(allFilterItems.get(i), tempList);
			}
			this.objDashboardBean.setMapAllListItemsForAllFilterItems(newMapAllListItemsForAllFilterItems);
		}catch(PersistenceException ePer){
			throw new ManagerException(1000, ePer.getErrorType(), ePer.getErrorName(), ePer.getErrorMessage());
		}
	}

	private void resetValuesOfListItemForSelectedFilterItem (int filterSequence, String selectedFilterItem){
		if(filterSequence == 1){
			this.objDashboardBean.setFirstFilterJListAllItems(this.objDashboardBean.getMapAllListItemsForAllFilterItems().get(selectedFilterItem));
		}else if(filterSequence == 2){
			this.objDashboardBean.setSecondFilterJListAllItems(this.objDashboardBean.getMapAllListItemsForAllFilterItems().get(selectedFilterItem));
		}else if(filterSequence == 3){
			this.objDashboardBean.setThirdFilterJListAllItems(this.objDashboardBean.getMapAllListItemsForAllFilterItems().get(selectedFilterItem));
		}else{
			this.objDashboardBean.setFourthFilterJListAllItems(this.objDashboardBean.getMapAllListItemsForAllFilterItems().get(selectedFilterItem));
		}
	}

	private void resetValueOfSelectedFilterItem(int filterSequence, String selectedFilterItem){
		if(filterSequence == 1){
			this.objDashboardBean.setFirstFilterComboBoxSelectedItem(selectedFilterItem);
		}else if(filterSequence == 2){
			this.objDashboardBean.setSecondFilterComboBoxSelectedItem(selectedFilterItem);
		}else if(filterSequence == 3){
			this.objDashboardBean.setThirdFilterComboBoxSelectedItem(selectedFilterItem);
		}else{
			this.objDashboardBean.setFourthFilterComboBoxSelectedItem(selectedFilterItem);
		}
		this.resetValuesOfListItemForSelectedFilterItem(filterSequence, selectedFilterItem);
	}

	private void resetApplicableValuesOfFilterItem(int filterSequence){
		List<String> valuesOfFilterItem = new ArrayList<String>();

		for (int i = 0; i < this.objDashboardBean.getFilterComboBoxAllItems().size(); i++) {
			valuesOfFilterItem.add(this.objDashboardBean.getFilterComboBoxAllItems().get(i));
		}

		int dynamicListSize = valuesOfFilterItem.size();
		for(int j = 0; j < dynamicListSize; j++){
			boolean removeFlag = false;

			if(filterSequence == 1){
				if(this.objDashboardBean.isSecondFilterActiveFlag()
						&& this.objResourceProvider.compareString(this.objDashboardBean.getSecondFilterComboBoxSelectedItem(), valuesOfFilterItem.get(j))){
					removeFlag = true;
				}else if(this.objDashboardBean.isThirdFilterActiveFlag()
						&& this.objResourceProvider.compareString(this.objDashboardBean.getThirdFilterComboBoxSelectedItem(), valuesOfFilterItem.get(j))){
					removeFlag = true;
				}else if(this.objDashboardBean.isFourthFilterActiveFlag()
						&& this.objResourceProvider.compareString(this.objDashboardBean.getFourthFilterComboBoxSelectedItem(), valuesOfFilterItem.get(j))){
					removeFlag = true;
				}

				if(removeFlag){
					valuesOfFilterItem.remove(j);
					j = 0;
				}

				this.objDashboardBean.setFirstFilterComboBoxAllItems(valuesOfFilterItem);
			}else if (filterSequence == 2){
				if(this.objDashboardBean.isFirstFilterActiveFlag()
						&& this.objResourceProvider.compareString(this.objDashboardBean.getFirstFilterComboBoxSelectedItem(), valuesOfFilterItem.get(j))){
					removeFlag = true;
				}else if(this.objDashboardBean.isThirdFilterActiveFlag()
						&& this.objResourceProvider.compareString(this.objDashboardBean.getThirdFilterComboBoxSelectedItem(), valuesOfFilterItem.get(j))){
					removeFlag = true;
				}else if(this.objDashboardBean.isFourthFilterActiveFlag()
						&& this.objResourceProvider.compareString(this.objDashboardBean.getFourthFilterComboBoxSelectedItem(), valuesOfFilterItem.get(j))){
					removeFlag = true;
				}

				if(removeFlag){
					valuesOfFilterItem.remove(j);
					j = 0;
				}

				this.objDashboardBean.setSecondFilterComboBoxAllItems(valuesOfFilterItem);
			}else if (filterSequence == 3){
				if(this.objDashboardBean.isFirstFilterActiveFlag()
						&& this.objResourceProvider.compareString(this.objDashboardBean.getFirstFilterComboBoxSelectedItem(), valuesOfFilterItem.get(j))){
					removeFlag = true;
				}else if(this.objDashboardBean.isSecondFilterActiveFlag()
						&& this.objResourceProvider.compareString(this.objDashboardBean.getSecondFilterComboBoxSelectedItem(), valuesOfFilterItem.get(j))){
					removeFlag = true;
				}else if(this.objDashboardBean.isFourthFilterActiveFlag()
						&& this.objResourceProvider.compareString(this.objDashboardBean.getFourthFilterComboBoxSelectedItem(), valuesOfFilterItem.get(j))){
					removeFlag = true;
				}

				if(removeFlag){
					valuesOfFilterItem.remove(j);
					j = 0;
				}

				this.objDashboardBean.setThirdFilterComboBoxAllItems(valuesOfFilterItem);
			}else{
				if(this.objDashboardBean.isFirstFilterActiveFlag()
						&& this.objResourceProvider.compareString(this.objDashboardBean.getFirstFilterComboBoxSelectedItem(), valuesOfFilterItem.get(j))){
					removeFlag = true;
				}else if(this.objDashboardBean.isSecondFilterActiveFlag()
						&& this.objResourceProvider.compareString(this.objDashboardBean.getSecondFilterComboBoxSelectedItem(), valuesOfFilterItem.get(j))){
					removeFlag = true;
				}else if(this.objDashboardBean.isThirdFilterActiveFlag()
						&& this.objResourceProvider.compareString(this.objDashboardBean.getThirdFilterComboBoxSelectedItem(), valuesOfFilterItem.get(j))){
					removeFlag = true;
				}

				if(removeFlag){
					valuesOfFilterItem.remove(j);
					j = 0;
				}

				this.objDashboardBean.setFourthFilterComboBoxAllItems(valuesOfFilterItem);
			}
			dynamicListSize = valuesOfFilterItem.size();
		}

	}

	public List<Integer> removalListFromFilterItems(int filterSaquence){
		List<Integer> removalList = new ArrayList<Integer>();

		if(filterSaquence == 1){
			if(this.objDashboardBean.isSecondFilterActiveFlag()){
				for(int i = 0; i < this.objDashboardBean.getFirstFilterComboBoxAllItems().size(); i++){
					if(this.objResourceProvider.compareString(this.objDashboardBean.getSecondFilterComboBoxSelectedItem()
							, this.objDashboardBean.getFirstFilterComboBoxAllItems().get(i))){
						this.objDashboardBean.getFirstFilterComboBoxAllItems().remove(i);
						removalList.add(i);
					}
				}
			}

			if(this.objDashboardBean.isThirdFilterActiveFlag()){
				for(int i = 0; i < this.objDashboardBean.getFirstFilterComboBoxAllItems().size(); i++){
					if(this.objResourceProvider.compareString(this.objDashboardBean.getThirdFilterComboBoxSelectedItem()
							, this.objDashboardBean.getFirstFilterComboBoxAllItems().get(i))){
						this.objDashboardBean.getFirstFilterComboBoxAllItems().remove(i);
						removalList.add(i);
					}
				}
			}

			if(this.objDashboardBean.isFourthFilterActiveFlag()){
				for(int i = 0; i < this.objDashboardBean.getFirstFilterComboBoxAllItems().size(); i++){
					if(this.objResourceProvider.compareString(this.objDashboardBean.getFourthFilterComboBoxSelectedItem()
							, this.objDashboardBean.getFirstFilterComboBoxAllItems().get(i))){
						this.objDashboardBean.getFirstFilterComboBoxAllItems().remove(i);
						removalList.add(i);
					}
				}
			}
		}else if(filterSaquence == 2){
			if(this.objDashboardBean.isFirstFilterActiveFlag()){
				for(int i = 0; i < this.objDashboardBean.getSecondFilterComboBoxAllItems().size(); i++){
					if(this.objResourceProvider.compareString(this.objDashboardBean.getFirstFilterComboBoxSelectedItem()
							, this.objDashboardBean.getSecondFilterComboBoxAllItems().get(i))){
						this.objDashboardBean.getSecondFilterComboBoxAllItems().remove(i);
						removalList.add(i);
					}
				}
			}

			if(this.objDashboardBean.isThirdFilterActiveFlag()){
				for(int i = 0; i < this.objDashboardBean.getSecondFilterComboBoxAllItems().size(); i++){
					if(this.objResourceProvider.compareString(this.objDashboardBean.getThirdFilterComboBoxSelectedItem()
							, this.objDashboardBean.getSecondFilterComboBoxAllItems().get(i))){
						this.objDashboardBean.getSecondFilterComboBoxAllItems().remove(i);
						removalList.add(i);
					}
				}
			}

			if(this.objDashboardBean.isFourthFilterActiveFlag()){
				for(int i = 0; i < this.objDashboardBean.getSecondFilterComboBoxAllItems().size(); i++){
					if(this.objResourceProvider.compareString(this.objDashboardBean.getFourthFilterComboBoxSelectedItem()
							, this.objDashboardBean.getSecondFilterComboBoxAllItems().get(i))){
						this.objDashboardBean.getSecondFilterComboBoxAllItems().remove(i);
						removalList.add(i);
					}
				}
			}
		}else if(filterSaquence == 3){
			if(this.objDashboardBean.isFirstFilterActiveFlag()){
				for(int i = 0; i < this.objDashboardBean.getThirdFilterComboBoxAllItems().size(); i++){
					if(this.objResourceProvider.compareString(this.objDashboardBean.getFirstFilterComboBoxSelectedItem()
							, this.objDashboardBean.getThirdFilterComboBoxAllItems().get(i))){
						this.objDashboardBean.getThirdFilterComboBoxAllItems().remove(i);
						removalList.add(i);
					}
				}
			}

			if(this.objDashboardBean.isSecondFilterActiveFlag()){
				for(int i = 0; i < this.objDashboardBean.getThirdFilterComboBoxAllItems().size(); i++){
					if(this.objResourceProvider.compareString(this.objDashboardBean.getSecondFilterComboBoxSelectedItem()
							, this.objDashboardBean.getThirdFilterComboBoxAllItems().get(i))){
						this.objDashboardBean.getThirdFilterComboBoxAllItems().remove(i);
						removalList.add(i);
					}
				}
			}

			if(this.objDashboardBean.isFourthFilterActiveFlag()){
				for(int i = 0; i < this.objDashboardBean.getThirdFilterComboBoxAllItems().size(); i++){
					if(this.objResourceProvider.compareString(this.objDashboardBean.getFourthFilterComboBoxSelectedItem()
							, this.objDashboardBean.getThirdFilterComboBoxAllItems().get(i))){
						this.objDashboardBean.getThirdFilterComboBoxAllItems().remove(i);
						removalList.add(i);
					}
				}
			}
		}else{
			if(this.objDashboardBean.isFirstFilterActiveFlag()){
				for(int i = 0; i < this.objDashboardBean.getFourthFilterComboBoxAllItems().size(); i++){
					if(this.objResourceProvider.compareString(this.objDashboardBean.getFirstFilterComboBoxSelectedItem()
							, this.objDashboardBean.getFourthFilterComboBoxAllItems().get(i))){
						this.objDashboardBean.getFourthFilterComboBoxAllItems().remove(i);
						removalList.add(i);
					}
				}
			}

			if(this.objDashboardBean.isSecondFilterActiveFlag()){
				for(int i = 0; i < this.objDashboardBean.getFourthFilterComboBoxAllItems().size(); i++){
					if(this.objResourceProvider.compareString(this.objDashboardBean.getSecondFilterComboBoxSelectedItem()
							, this.objDashboardBean.getFourthFilterComboBoxAllItems().get(i))){
						this.objDashboardBean.getFourthFilterComboBoxAllItems().remove(i);
						removalList.add(i);
					}
				}
			}

			if(this.objDashboardBean.isThirdFilterActiveFlag()){
				for(int i = 0; i < this.objDashboardBean.getFourthFilterComboBoxAllItems().size(); i++){
					if(this.objResourceProvider.compareString(this.objDashboardBean.getThirdFilterComboBoxSelectedItem()
							, this.objDashboardBean.getFourthFilterComboBoxAllItems().get(i))){
						this.objDashboardBean.getFourthFilterComboBoxAllItems().remove(i);
						removalList.add(i);
					}
				}
			}
		}

		return removalList;
	}

	public List<String> addListForFilterItem(int filterSequence){
		List<String> addList = new ArrayList<String>();

		for (int i = 0; i < this.objDashboardBean.getFilterComboBoxAllItems().size(); i++){
			addList.add(this.objDashboardBean.getFilterComboBoxAllItems().get(i));
		}

		if(filterSequence == 1){
			if(this.objDashboardBean.isSecondFilterActiveFlag()){
				for(int i = 0; i < addList.size(); i++){
					if(this.objResourceProvider.compareString(this.objDashboardBean.getSecondFilterComboBoxSelectedItem()
							, addList.get(i))){
						addList.remove(i);
					}
				}
			}

			if(this.objDashboardBean.isThirdFilterActiveFlag()){
				for(int i = 0; i < addList.size(); i++){
					if(this.objResourceProvider.compareString(this.objDashboardBean.getThirdFilterComboBoxSelectedItem()
							, addList.get(i))){
						addList.remove(i);
					}
				}
			}

			if(this.objDashboardBean.isFourthFilterActiveFlag()){
				for(int i = 0; i < addList.size(); i++){
					if(this.objResourceProvider.compareString(this.objDashboardBean.getFourthFilterComboBoxSelectedItem()
							, addList.get(i))){
						addList.remove(i);
					}
				}
			}

			for (int i = 0; i < this.objDashboardBean.getFirstFilterComboBoxAllItems().size(); i++){
				for (int j = 0; j < addList.size(); j++){
					if(this.objResourceProvider.compareString(objDashboardBean.getFirstFilterComboBoxAllItems().get(i), addList.get(j))){
						addList.remove(j);
					}
				}
			}

			for (int j = 0; j < addList.size(); j++){
				this.objDashboardBean.getFirstFilterComboBoxAllItems().add(addList.get(j));
			}

		}else if(filterSequence == 2){
			if(this.objDashboardBean.isFirstFilterActiveFlag()){
				for(int i = 0; i < addList.size(); i++){
					if(this.objResourceProvider.compareString(this.objDashboardBean.getFirstFilterComboBoxSelectedItem()
							, addList.get(i))){
						addList.remove(i);
					}
				}
			}

			if(this.objDashboardBean.isThirdFilterActiveFlag()){
				for(int i = 0; i < addList.size(); i++){
					if(this.objResourceProvider.compareString(this.objDashboardBean.getThirdFilterComboBoxSelectedItem()
							, addList.get(i))){
						addList.remove(i);
					}
				}
			}

			if(this.objDashboardBean.isFourthFilterActiveFlag()){
				for(int i = 0; i < addList.size(); i++){
					if(this.objResourceProvider.compareString(this.objDashboardBean.getFourthFilterComboBoxSelectedItem()
							, addList.get(i))){
						addList.remove(i);
					}
				}
			}

			for (int i = 0; i < this.objDashboardBean.getSecondFilterComboBoxAllItems().size(); i++){
				for (int j = 0; j < addList.size(); j++){
					if(this.objResourceProvider.compareString(objDashboardBean.getSecondFilterComboBoxAllItems().get(i), addList.get(j))){
						addList.remove(j);
					}
				}
			}

			for (int j = 0; j < addList.size(); j++){
				this.objDashboardBean.getSecondFilterComboBoxAllItems().add(addList.get(j));
			}
		}else if(filterSequence == 3){
			if(this.objDashboardBean.isFirstFilterActiveFlag()){
				for(int i = 0; i < addList.size(); i++){
					if(this.objResourceProvider.compareString(this.objDashboardBean.getFirstFilterComboBoxSelectedItem()
							, addList.get(i))){
						addList.remove(i);
					}
				}
			}

			if(this.objDashboardBean.isSecondFilterActiveFlag()){
				for(int i = 0; i < addList.size(); i++){
					if(this.objResourceProvider.compareString(this.objDashboardBean.getSecondFilterComboBoxSelectedItem()
							, addList.get(i))){
						addList.remove(i);
					}
				}
			}

			if(this.objDashboardBean.isFourthFilterActiveFlag()){
				for(int i = 0; i < addList.size(); i++){
					if(this.objResourceProvider.compareString(this.objDashboardBean.getFourthFilterComboBoxSelectedItem()
							, addList.get(i))){
						addList.remove(i);
					}
				}
			}

			for (int i = 0; i < this.objDashboardBean.getThirdFilterComboBoxAllItems().size(); i++){
				for (int j = 0; j < addList.size(); j++){
					if(this.objResourceProvider.compareString(objDashboardBean.getThirdFilterComboBoxAllItems().get(i), addList.get(j))){
						addList.remove(j);
					}
				}
			}

			for (int j = 0; j < addList.size(); j++){
				this.objDashboardBean.getThirdFilterComboBoxAllItems().add(addList.get(j));
			}
		}else{
			if(this.objDashboardBean.isFirstFilterActiveFlag()){
				for(int i = 0; i < addList.size(); i++){
					if(this.objResourceProvider.compareString(this.objDashboardBean.getFirstFilterComboBoxSelectedItem()
							, addList.get(i))){
						addList.remove(i);
					}
				}
			}

			if(this.objDashboardBean.isSecondFilterActiveFlag()){
				for(int i = 0; i < addList.size(); i++){
					if(this.objResourceProvider.compareString(this.objDashboardBean.getSecondFilterComboBoxSelectedItem()
							, addList.get(i))){
						addList.remove(i);
					}
				}
			}

			if(this.objDashboardBean.isThirdFilterActiveFlag()){
				for(int i = 0; i < addList.size(); i++){
					if(this.objResourceProvider.compareString(this.objDashboardBean.getThirdFilterComboBoxSelectedItem()
							, addList.get(i))){
						addList.remove(i);
					}
				}
			}

			for (int i = 0; i < this.objDashboardBean.getFourthFilterComboBoxAllItems().size(); i++){
				for (int j = 0; j < addList.size(); j++){
					if(this.objResourceProvider.compareString(objDashboardBean.getFourthFilterComboBoxAllItems().get(i), addList.get(j))){
						addList.remove(j);
					}
				}
			}

			for (int j = 0; j < addList.size(); j++){
				this.objDashboardBean.getFourthFilterComboBoxAllItems().add(addList.get(j));
			}
		}

		return addList;
	}

	public void btnApplyFiltersActionPerformed(Connection objLocalConnection, boolean applyFilters) throws ManagerException{
		try{
			String filters = " ";
			if(applyFilters){
				filters = this.prepareFilterDetails();
				if(this.objResourceProvider.compareString(filters, " ") == false){
					filters = " WHERE" + filters;
				}
			}

			List<List<String>> problemDetails = this.objDashboardPersistence.fetchRecordsFromProblemDetails(objLocalConnection, filters);

			for (int i=0; i<problemDetails.size(); i++){
				if(i == 0){
					problemDetails.get(i).add(16,"ACTIVITY_LOGS");
				}else{
					this.enrichProblemDetails(objLocalConnection, problemDetails.get(i));
				}
			}
			this.objDashboardBean.setTableRecords(problemDetails);
		}catch(PersistenceException ePer){
			throw new ManagerException(1000, ePer.getErrorType(), ePer.getErrorName(), ePer.getErrorMessage());
		}
	}

	protected List<String> enrichProblemDetails(Connection objLocalConnection, List<String> problemDetails) throws ManagerException{
		LoginManager objLoginManager = new LoginManager(this.objResourceProvider);
		problemDetails.add(16, this.prepareActivityLogs(objLocalConnection,problemDetails.get(0)));
		problemDetails.add(17, objLoginManager.getOperatorNameFromOperatorId(objLocalConnection, problemDetails.get(17)));
		problemDetails.remove(18);
		problemDetails.add(19, objLoginManager.getOperatorNameFromOperatorId(objLocalConnection, problemDetails.get(19)));
		problemDetails.remove(20);
		return problemDetails;
	}

	private String prepareFilterDetails(){
		List<List<String>> allFilterDetails = new ArrayList<List<String>>();
		String sql = " ";

		if(this.objDashboardBean.isFirstFilterActiveFlag()){
			List<String> firstFilterDetails = new ArrayList<String>();
			firstFilterDetails.add(this.objDashboardBean.getMapFilterItemToTableColumn().get(this.objDashboardBean.getFirstFilterComboBoxSelectedItem()));
			for(int i = 0; i<this.objDashboardBean.getFirstFilterJListSelectedItems().size(); i++){
				firstFilterDetails.add(this.objDashboardBean.getFirstFilterJListSelectedItems().get(i));
			}
			allFilterDetails.add(firstFilterDetails);
		}

		if(this.objDashboardBean.isSecondFilterActiveFlag()){
			List<String> secondFilterDetails = new ArrayList<String>();
			secondFilterDetails.add(this.objDashboardBean.getMapFilterItemToTableColumn().get(this.objDashboardBean.getSecondFilterComboBoxSelectedItem()));
			for(int i = 0; i<this.objDashboardBean.getSecondFilterJListSelectedItems().size(); i++){
				secondFilterDetails.add(this.objDashboardBean.getSecondFilterJListSelectedItems().get(i));
			}
			allFilterDetails.add(secondFilterDetails);
		}

		if(this.objDashboardBean.isThirdFilterActiveFlag()){
			List<String> thirdFilterDetails = new ArrayList<String>();
			thirdFilterDetails.add(this.objDashboardBean.getMapFilterItemToTableColumn().get(this.objDashboardBean.getThirdFilterComboBoxSelectedItem()));
			for(int i = 0; i<this.objDashboardBean.getThirdFilterJListSelectedItems().size(); i++){
				thirdFilterDetails.add(this.objDashboardBean.getThirdFilterJListSelectedItems().get(i));
			}
			allFilterDetails.add(thirdFilterDetails);
		}

		if(this.objDashboardBean.isFourthFilterActiveFlag()){
			List<String> fourthFilterDetails = new ArrayList<String>();
			fourthFilterDetails.add(this.objDashboardBean.getMapFilterItemToTableColumn().get(this.objDashboardBean.getFourthFilterComboBoxSelectedItem()));
			for(int i = 0; i<this.objDashboardBean.getFourthFilterJListSelectedItems().size(); i++){
				fourthFilterDetails.add(this.objDashboardBean.getFourthFilterJListSelectedItems().get(i));
			}
			allFilterDetails.add(fourthFilterDetails);
		}

		for (int i=0; i<allFilterDetails.size(); i++){
			for (int j=0; j<allFilterDetails.get(i).size(); j++){
				if (j == 0 ){
					sql = sql + allFilterDetails.get(i).get(j) + " IN ('";
				}else if(j == ((allFilterDetails.get(i).size()) - 1)){
					if(i == ((allFilterDetails.size()) - 1)){
						sql = sql + allFilterDetails.get(i).get(j) + "') ";
					}else{
						sql = sql + allFilterDetails.get(i).get(j) + "') AND ";
					}
				}else{
					sql = sql + allFilterDetails.get(i).get(j) +"','";
				}
			}
		}

		return sql;
	}

	private String prepareActivityLogs(Connection objLocalConnection, String trackerId) throws ManagerException{
		try{
			String result = "";
			LoginManager objLoginManager = new LoginManager(this.objResourceProvider);
			List<List<String>> activityLog = this.objDashboardPersistence.fetchActivityLogs(objLocalConnection, trackerId);

			for(int i=0; i<activityLog.size(); i++){
				String comments = activityLog.get(i).get(3);
				if(comments == null){
					comments = "";
				}

				result = result + activityLog.get(i).get(2) + " <" + objLoginManager.getOperatorNameFromOperatorId(objLocalConnection, activityLog.get(i).get(1)) + "> \n" + comments + "\n\n";
			}
			return result;
		}catch(PersistenceException ePer){
			throw new ManagerException(1000, ePer.getErrorType(), ePer.getErrorName(), ePer.getErrorMessage());
		}
	}

	public final void btnSearchDefectActionPerformed(Connection objLocalConnection, String searchKey) throws ManagerException{
		this.btnApplyFiltersActionPerformed(objLocalConnection, false);
		List<List<String>> databaseResult = this.objDashboardBean.getTableRecords();
		List<List<String>> resultList = new ArrayList<List<String>>();
		resultList.add(databaseResult.get(0));

		for(int i=1; i<databaseResult.size(); i++){
			for(int j=0; j<databaseResult.get(i).size(); j++){
				if(this.objResourceProvider.wordExistsInString(searchKey, databaseResult.get(i).get(j))){
					resultList.add(databaseResult.get(i));
					break;
				}
			}
		}

		this.objDashboardBean.setTableRecords(resultList);
	}
}
