package com.epam.training.oop.service.util;

import com.epam.training.oop.entity.criteria.CriteriaMap;
import com.epam.training.oop.entity.criteria.LaptopCriteria;
import com.epam.training.oop.entity.criteria.OvenCriteria;
import com.epam.training.oop.entity.criteria.RefrigeratorCriteria;

import java.util.Map;


public class Validator {
	
	public static <T> boolean validateCriteria(CriteriaMap criteria) {
		if (criteria == null){
			return false;
		}

		Map<T, String> criteriaMap = criteria.getCriteria();
		for(Map.Entry<T, String> pair : criteriaMap.entrySet()){
			if(pair.getKey() == null || pair.getValue() == null){
				return false;
			}
		}

		String applianceType = criteria.getDeviceType();

		if (applianceType.equals("Oven")) {
			return checkOven(criteriaMap);
		}
		if (applianceType.equals("Laptop")) {
			return checkLaptop(criteriaMap);
		}
		if (applianceType.equals("Refrigerator")) {
			return checkRefrigerator(criteriaMap);
		}
		return false;
	}

	private static <E> boolean checkOven(Map<E, String> criteriaMap){
		if (criteriaMap.containsKey(OvenCriteria.POWER_CONSUMPTION)){
			try{
				Double.parseDouble(criteriaMap.get(OvenCriteria.POWER_CONSUMPTION).toString());
			} catch (NumberFormatException e){
				return false;
			}
		}
		if (criteriaMap.containsKey(OvenCriteria.WEIGHT)){
			try{
				Double.parseDouble(criteriaMap.get(OvenCriteria.WEIGHT).toString());
			} catch (NumberFormatException e){
				return false;
			}
		}
		if (criteriaMap.containsKey(OvenCriteria.CAPACITY)){
			try{
				Double.parseDouble(criteriaMap.get(OvenCriteria.CAPACITY).toString());
			} catch (NumberFormatException e){
				return false;
			}
		}
		if (criteriaMap.containsKey(OvenCriteria.DEPTH)){
			try{
				Double.parseDouble(criteriaMap.get(OvenCriteria.DEPTH).toString());
			} catch (NumberFormatException e){
				return false;
			}
		}
		if (criteriaMap.containsKey(OvenCriteria.HEIGHT)){
			try{
				Double.parseDouble(criteriaMap.get(OvenCriteria.HEIGHT).toString());
			} catch (NumberFormatException e){
				return false;
			}
		}
		if (criteriaMap.containsKey(OvenCriteria.WIDTH)){
			try{
				Double.parseDouble(criteriaMap.get(OvenCriteria.WIDTH).toString());
			} catch (NumberFormatException e){
				return false;
			}
		}
		return true;
	}


	private static <E> boolean checkLaptop(Map<E, String> criteriaMap){
		if (criteriaMap.containsKey(LaptopCriteria.BATTERY_CAPACITY)){
			try{
				Double.parseDouble(criteriaMap.get(LaptopCriteria.BATTERY_CAPACITY).toString());
			} catch (NumberFormatException e){
				return false;
			}
		}
		if (criteriaMap.containsKey(LaptopCriteria.OS)){
			if (!(criteriaMap.get(LaptopCriteria.OS) instanceof String)){
				return false;
			}
		}
		if (criteriaMap.containsKey(LaptopCriteria.MEMORY_ROM)){
			try{
				Double.parseDouble(criteriaMap.get(LaptopCriteria.MEMORY_ROM).toString());
			} catch (NumberFormatException e){
				return false;
			}
		}
		if (criteriaMap.containsKey(LaptopCriteria.SYSTEM_MEMORY)){
			try{
				Double.parseDouble(criteriaMap.get(LaptopCriteria.SYSTEM_MEMORY).toString());
			} catch (NumberFormatException e){
				return false;
			}
		}
		if (criteriaMap.containsKey(LaptopCriteria.CPU)){
			try{
				Double.parseDouble(criteriaMap.get(LaptopCriteria.CPU).toString());
			} catch (NumberFormatException e){
				return false;
			}
		}
		if (criteriaMap.containsKey(LaptopCriteria.DISPLAY_INCHES)){
			try{
				Double.parseDouble(criteriaMap.get(LaptopCriteria.DISPLAY_INCHES).toString());
			} catch (NumberFormatException e){
				return false;
			}
		}
		return true;
	}

	private static <E> boolean checkRefrigerator(Map<E, String> criteriaMap){
		if (criteriaMap.containsKey(RefrigeratorCriteria.POWER_CONSUMPTION)){
			try{
				Double.parseDouble(criteriaMap.get(RefrigeratorCriteria.POWER_CONSUMPTION).toString());
			} catch (NumberFormatException e){
				return false;
			}
		}
		if (criteriaMap.containsKey(RefrigeratorCriteria.WEIGHT)){
			try{
				Double.parseDouble(criteriaMap.get(RefrigeratorCriteria.WEIGHT).toString());
			} catch (NumberFormatException e){
				return false;
			}
		}
		if (criteriaMap.containsKey(RefrigeratorCriteria.FREEZER_CAPACITY)){
			try{
				Double.parseDouble(criteriaMap.get(RefrigeratorCriteria.FREEZER_CAPACITY).toString());
			} catch (NumberFormatException e){
				return false;
			}
		}
		if (criteriaMap.containsKey(RefrigeratorCriteria.OVERALL_CAPACITY)){
			try{
				Double.parseDouble(criteriaMap.get(RefrigeratorCriteria.OVERALL_CAPACITY).toString());
			} catch (NumberFormatException e){
				return false;
			}
		}
		if (criteriaMap.containsKey(RefrigeratorCriteria.HEIGHT)){
			try{
				Double.parseDouble(criteriaMap.get(RefrigeratorCriteria.HEIGHT).toString());
			} catch (NumberFormatException e){
				return false;
			}
		}
		if (criteriaMap.containsKey(RefrigeratorCriteria.WIDTH)){
			try{
				Double.parseDouble(criteriaMap.get(RefrigeratorCriteria.WIDTH).toString());
			} catch (NumberFormatException e){
				return false;
			}
		}
		return true;
	}
}