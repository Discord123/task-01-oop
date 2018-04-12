package com.epam.training.oop.service;

import com.epam.training.oop.entity.Device;

import java.util.List;

public class PrintDeviceInfo {
	public static void print(List<Device> appliances) {
		if (appliances != null && appliances.size() > 0) {
			for (Device device : appliances) {
				System.out.println(device);
			}
		} else {
			System.out.println("Device not found");
		}
	}
}
