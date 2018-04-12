package com.epam.training.oop.service;

import com.epam.training.oop.dao.DeviceDAO;
import com.epam.training.oop.entity.Device;
import com.epam.training.oop.entity.criteria.CriteriaMap;
import com.epam.training.oop.service.util.SearchParametersCreator;
import com.epam.training.oop.service.util.Validator;

import java.util.List;

public class DeviceService {

	public List<Device> readDevice(CriteriaMap criteria) {
		List<Device> devices = null;

		if (Validator.validateCriteria(criteria)) {
			List<String> searchParameters = SearchParametersCreator.createSearchParameters(criteria);
			DeviceDAO deviceDAO = new DeviceDAO();
			devices = deviceDAO.readDevice(searchParameters);
		}
		
		return devices;
	}
}