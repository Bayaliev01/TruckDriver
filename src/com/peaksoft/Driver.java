package com.peaksoft;

public class Driver {
    private int id;
    private String name;
    private String truck;

    public Driver() {
    }

    public Driver(int id, String name, String truck) {
        this.id = id;
        this.name = name;
        this.truck = truck;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTruck() {
        return truck;
    }

    public void setTruck(String truck) {
        this.truck = truck;
    }

    public static Driver createDriver(int id, String name, String truck) {
        Driver drive = new Driver();
        drive.id = id;
        drive.name = name;
        drive.truck = truck;
        return drive;
    }

    public String infoDriver() {
        return id + "   | " + name + "| " + truck;
    }


    @Override
    public String toString() {
        return "";
    }
}

