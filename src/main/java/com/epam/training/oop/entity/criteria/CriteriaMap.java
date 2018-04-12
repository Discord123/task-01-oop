package com.epam.training.oop.entity.criteria;

import java.util.HashMap;
import java.util.Map;

public class CriteriaMap <T extends SearchCriteria> {

	private String deviceType;

	private Map<T, String> criteria = new HashMap<>();

	public boolean add(T searchCriteria, Object value) {
		boolean isAdded = false;
		if(value != null){
			criteria.put(searchCriteria, value.toString());
			isAdded = true;
		}
		return isAdded;
	}
	
	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public Map<T, String> getCriteria() {
		return criteria;
	}
}
