package com.peaksoft;

import java.util.Scanner;

public class Service {
    static String truckName;
    static String driveName = null;
    static Scanner scanner = new Scanner(System.in);
    static Driver drive = new Driver();
    static String vers;

    public static void changeTruck(Truck[] trucks, int truckId, Driver[] drivers) {
        for (int i = 0; i < trucks.length; i++) {
            if (trucks[i].getId() == truckId) {
                if (trucks[i].getDrive().getName() == null) {
                    vers = "";
                } else {
                    vers = trucks[i].getDrive().getName();
                }
                truckName = trucks[i].getName();
                System.out.println("ID - " + trucks[i].getId());
                System.out.println("TRUCK - " + trucks[i].getName());
                System.out.println("DRIVER - " + vers);
                System.out.println("STATUS - " + trucks[i].getStatus());
                if (trucks[i].getStatus().equals(Status.BASE)) {
                    System.out.println("еслт хотите отправить в путь нажмите -1");
                    System.out.println("если хотите отправить на ремонт нажмите -2");
                    System.out.println("Выбрать водителья -3");
                    int a = scanner.nextInt();
                    if (a == 3) {
                        cangeDriver(drivers, trucks[i]);
                        trucks[i].setDrive(drive);
                        System.out.println("отправить в путь? тогда нажмите -1 \n если хотите выйти тогда нажмите на -0");
                        a = scanner.nextInt();
                        if (a == 1) {
                            methodDraiving(truckName, driveName);
                            trucks[i].setStatus(Status.ROUTE);
                        } else if (a == 0) {
                            System.out.println("Грузовик остался на Базе");
                            break;
                        }

                    } else if (a == 1) {
                        System.out.println("сначала выберите водителья");
                        cangeDriver(drivers, trucks[i]);
                        trucks[i].setDrive(drive);
                        methodDraiving(truckName, driveName);
                        trucks[i].setStatus(Status.ROUTE);
                    } else if (a == 2) {
                        Repair(truckName);
                        trucks[i].setStatus(Status.REPAIR);
                    }
                } else if (trucks[i].getStatus().equals(Status.ROUTE)) {
                    System.out.println("Вы выбрали грузовика " + truckName + " он уже в пути");
                } else if (trucks[i].getStatus().equals(Status.REPAIR)) {
                    System.out.println("вы выбрали грузовика " + truckName + " он на ремонте ");
                }
            }

        }
        if (truckId > trucks.length) {
            throw new RuntimeException("выберите только один из 3");
        }
    }

    public static void cangeDriver(Driver[] drives, Truck truck) {
        for (int i = 0; i < drives.length; i++) {
            if (drives[i].getId() == truck.getId()) {
                driveName = drives[i].getName();
                drive = drives[i];
            }
        }
        System.out.println("теперь у грузовика - " + truckName + "  водитель - " + driveName);
    }
    public static void methodDraiving(String truck, String drive){
        System.out.println("теперь грузовик - "+ truck + " в пути за рулем - "+drive);
    }
    public static void Repair(String truck){
        System.out.println("грузовик - "+truck + " на ремонте");
    }
}

