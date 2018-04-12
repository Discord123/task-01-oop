package com.epam.training.oop.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Laptop implements Device {
    private static final String DEVICE_TYPE = "Laptop";
    private double batteryCapacity;
    private String os;
    private double memoryROM;
    private double systemMemory;
    private double cpu;
    private double displayInches;

    public Laptop(){
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DEVICE_TYPE + " : ");
        sb.append("BATTERY_CAPACITY=" + batteryCapacity + ", ");
        sb.append("OS=" + os + ", ");
        sb.append("MEMORY_ROM=" + memoryROM + ", ");
        sb.append("SYSTEM_MEMORY=" + systemMemory + ", ");
        sb.append("CPU=" + cpu + ", ");
        sb.append("DISPLAY_INCHES=" + displayInches + ";");
        return sb.toString();
    }

    @Override
    @Deprecated
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Laptop laptop = (Laptop) o;

        return new EqualsBuilder()
                .append(batteryCapacity, laptop.batteryCapacity)
                .append(memoryROM, laptop.memoryROM)
                .append(systemMemory, laptop.systemMemory)
                .append(cpu, laptop.cpu)
                .append(displayInches, laptop.displayInches)
                .append(os, laptop.os)
                .isEquals();
    }

    @Override
    @Deprecated
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(batteryCapacity)
                .append(os)
                .append(memoryROM)
                .append(systemMemory)
                .append(cpu)
                .append(displayInches)
                .toHashCode();
    }

    public static String getDeviceType() {
        return DEVICE_TYPE;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public double getMemoryROM() {
        return memoryROM;
    }

    public void setMemoryROM(double memoryROM) {
        this.memoryROM = memoryROM;
    }

    public double getSystemMemory() {
        return systemMemory;
    }

    public void setSystemMemory(double systemMemory) {
        this.systemMemory = systemMemory;
    }

    public double getCpu() {
        return cpu;
    }

    public void setCpu(double cpu) {
        this.cpu = cpu;
    }

    public double getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(double displayInches) {
        this.displayInches = displayInches;
    }
}
