package com.epam.training.oop.dao;

import com.epam.training.oop.entity.Device;
import com.epam.training.oop.entity.Laptop;
import com.epam.training.oop.entity.Oven;
import com.epam.training.oop.entity.Refrigerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class DeviceDAO {

	private static final String DATABASE_FILE_NAME = "device_db.txt";

	public List<Device> readDevice(List<String> criteria) {
		String applianceType = criteria.get(0);
		List<Device> relevantDevices = searchInDatabase(applianceType, criteria);
		return relevantDevices;
	}

	private List<Device> searchInDatabase(String deviceType, List<String> criteriaList){
		List<Device> relevantDevices = new ArrayList<>();
		ClassLoader classLoader = DeviceDAO.class.getClassLoader();
		try(InputStream is = classLoader.getResourceAsStream(DATABASE_FILE_NAME);
			BufferedReader br = new BufferedReader(new InputStreamReader(is))){

			String readLine;
			while ((readLine = br.readLine()) != null)
				if (getMatch(readLine, criteriaList)) {
					Device device = createDevice(deviceType, readLine);
					relevantDevices.add(device);
				}

		} catch (IOException e){
			e.printStackTrace();
		}
		return relevantDevices;
	}

	private static boolean getMatch(String readData, List<String> criteriaList){
		boolean isMatch = true;
		int size = criteriaList.size();
		for(int i=1; i<size;i++){
			if (!Pattern.matches(criteriaList.get(i), readData)) {
				isMatch = false;
				break;
			}
		}
		return isMatch;
	}

	private static Device createDevice(String deviceType, String readLine){
		Device device = null;
		List<String> parametersList = getParametersArrayForFoundedDevice(readLine);
		if(deviceType.equals("Oven")){
			device =  buildOven(parametersList);

		} else if(deviceType.equals("Laptop")){
			device = buildLaptop(parametersList);

		} else if(deviceType.equals("Refrigerator")){
			device = buildRefrigerator(parametersList);
		}
		return device;
	}

	private static Device buildRefrigerator(List<String> parametersList) {
		Refrigerator refrigerator = new Refrigerator();
		refrigerator.setPowerConsumption(Double.parseDouble(parametersList.get(0)));
		refrigerator.setWeight(Double.parseDouble(parametersList.get(1)));
		refrigerator.setFreezerCapacity(Double.parseDouble(parametersList.get(2)));
		refrigerator.setOverallCapacity(Double.parseDouble(parametersList.get(3)));
		refrigerator.setHeight(Double.parseDouble(parametersList.get(4)));
		refrigerator.setWidth(Double.parseDouble(parametersList.get(5)));
		return refrigerator;
	}

	private static Device buildLaptop(List<String> parametersList) {
		Laptop laptop = new Laptop();
		laptop.setBatteryCapacity(Double.parseDouble(parametersList.get(0)));
		laptop.setOs(parametersList.get(1));
		laptop.setMemoryROM(Double.parseDouble(parametersList.get(2)));
		laptop.setSystemMemory(Double.parseDouble(parametersList.get(3)));
		laptop.setCpu(Double.parseDouble(parametersList.get(4)));
		laptop.setDisplayInches(Double.parseDouble(parametersList.get(5)));
		return laptop;
	}

	private static Device buildOven(List<String> parametersList) {
		Oven oven = new Oven();
		oven.setPowerConsumption(Double.parseDouble(parametersList.get(0)));
		oven.setWeight(Double.parseDouble(parametersList.get(1)));
		oven.setCapacity(Double.parseDouble(parametersList.get(2)));
		oven.setDepth(Double.parseDouble(parametersList.get(3)));
		oven.setHeight(Double.parseDouble(parametersList.get(4)));
		oven.setWidth(Double.parseDouble(parametersList.get(5)));
		return oven;
	}

	private static List<String> getParametersArrayForFoundedDevice(String parameters){
		List<String> paramsList = new ArrayList<>();
		int currentPosition = 0;
		int currentStartIndex;
		while ((currentStartIndex = parameters.indexOf("=", currentPosition)) != -1){
			int indexOfEndMark = parameters.indexOf(" ,", currentStartIndex);
			if(indexOfEndMark == -1){
				indexOfEndMark = parameters.indexOf(" ;");
			}
			paramsList.add(parameters.substring(currentStartIndex+1, indexOfEndMark));
			currentPosition = currentStartIndex+1;
		}
		return paramsList;
	}
}