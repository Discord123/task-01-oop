package com.epam.training.oop.main;

import com.epam.training.oop.entity.Device;
import com.epam.training.oop.entity.criteria.CriteriaMap;
import com.epam.training.oop.entity.criteria.LaptopCriteria;
import com.epam.training.oop.entity.criteria.OvenCriteria;
import com.epam.training.oop.entity.criteria.RefrigeratorCriteria;
import com.epam.training.oop.service.DeviceService;
import com.epam.training.oop.service.PrintDeviceInfo;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Device> devices;

		DeviceService service = new DeviceService();

		//////////////////////////////////////////////////////////////////

		CriteriaMap<OvenCriteria> criteriaOven = new CriteriaMap();
		criteriaOven.setDeviceType("Oven");
		criteriaOven.add(OvenCriteria.CAPACITY, 52);



		devices = service.readDevice(criteriaOven);

		PrintDeviceInfo.print(devices);

		//////////////////////////////////////////////////////////////////

		criteriaOven = new CriteriaMap();
		criteriaOven.setDeviceType("Oven");
		criteriaOven.add(OvenCriteria.HEIGHT, 45);
		criteriaOven.add(OvenCriteria.DEPTH, 60);

		devices = service.readDevice(criteriaOven);

		PrintDeviceInfo.print(devices);

		//////////////////////////////////////////////////////////////////

		criteriaOven = new CriteriaMap();
		criteriaOven.setDeviceType("Oven");
		criteriaOven.add(OvenCriteria.HEIGHT, 45.5);
		criteriaOven.add(OvenCriteria.DEPTH, 60);
		criteriaOven.add(OvenCriteria.CAPACITY, 32);

		devices = service.readDevice(criteriaOven);

		PrintDeviceInfo.print(devices);

		//////////////////////////////////////////////////////////////////

		CriteriaMap criteriaRefrigerator = new CriteriaMap();
		criteriaRefrigerator.setDeviceType("Refrigerator");
		criteriaRefrigerator.add(RefrigeratorCriteria.POWER_CONSUMPTION, "200");
		criteriaRefrigerator.add(RefrigeratorCriteria.WEIGHT, 30);
		criteriaRefrigerator.add(RefrigeratorCriteria.HEIGHT, 180);

		devices = service.readDevice(criteriaRefrigerator);

		PrintDeviceInfo.print(devices);

		//////////////////////////////////////////////////////////////////

		CriteriaMap criteriaLaptop = new CriteriaMap();
		criteriaLaptop.setDeviceType("Laptop");
		criteriaLaptop.add(null, null);
		criteriaLaptop.add(LaptopCriteria.CPU, 2.0);

		devices = service.readDevice(criteriaLaptop);

		PrintDeviceInfo.print(devices);

		//////////////////////////////////////////////////////////////////

		criteriaLaptop = new CriteriaMap();
		criteriaLaptop.setDeviceType("Laptop");
		criteriaLaptop.add(LaptopCriteria.CPU, 2.2);

		devices = service.readDevice(criteriaLaptop);

		PrintDeviceInfo.print(devices);
	}
}
