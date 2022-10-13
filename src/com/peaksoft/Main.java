package com.peaksoft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main {
    public static final GsonBuilder GSON_BUILDER = new GsonBuilder();
    public static final Gson GSON = GSON_BUILDER.setPrettyPrinting().create();
    public static final Path URL_TRUCK = Paths.get("./trucks.json");
    public static final Path URL_DRIVER = Paths.get("./drivers.json");

    public static void main(String[] args) {
        // write your code here
        Truck[] trucks = {
                Truck.makeCar(1, "Renault", new Driver(), Status.BASE),
                Truck.makeCar(2, "Volvo", new Driver(), Status.BASE),
                Truck.makeCar(3, "DAF XT ", new Driver(), Status.BASE),
                Truck.makeCar(4, "Optimus Prime ", new Driver(), Status.BASE),
                Truck.makeCar(5, "Bumble Bee", new Driver(), Status.BASE),
        };
        //     Truck[] trucks2 = trucks;
        Driver[] drives = {
                Driver.createDriver(1, "Tilek ", ""),
                Driver.createDriver(2, "Marat", ""),
                Driver.createDriver(3, "Almaz ", ""),
                Driver.createDriver(4, "Muhammbet ", ""),
                Driver.createDriver(5, "Zhanarbek ", "")
        };

        System.out.println("   \n Info about Trucks     ");
        System.out.println("_________________________________________");
        System.out.printf("%-1s%-10s%-10s%-10s%n", "# |", " Truck         |", " Driver", "| Status ");
        System.out.println("_________________________________________");
        Truck[] trucks1 = GSON.fromJson(readFileTruckc(), Truck[].class);
        for (Truck t : trucks1) {
//            System.out.println(t.toString());
            System.out.printf("%-1s |", t.getId());
            System.out.printf("%-15s|", t.getName());
            System.out.printf("%-10s|", t.getDrive());
            System.out.printf("%-10s", t.getStatus());
            System.out.println();

        }
        System.out.println("  \n\nInfo about Drivers     ");
        System.out.println("___________________________");
        System.out.printf("%-1s%-10s%-10s%n", "# |", "name", "| truck ");
        System.out.println("___________________________");
        Driver[] drives1 = GSON.fromJson(readFileDriver(), Driver[].class);
        for (Driver drive : drives1) {
            System.out.printf("%-2s|", drive.getId());
            System.out.printf("%-10s|", drive.getName());
            System.out.printf("%-10s", drive.getTruck());
            System.out.println();

        }
//
//
//        String allCars = GSON.toJson(trucks);
//        String allDrive = GSON.toJson(drives);
//        System.out.println(allCars);
//        writeFileTruck(allCars);
//         writeFileDrive(allDrive);
        while (true) {
            System.out.println("Выберите truck: 1 2 3 4 5 \n 0 - exit");
            Scanner scanner = new Scanner(System.in);
            int truckId = scanner.nextInt();
            if (truckId == 0) {
                break;
            }
            Service.changeTruck(trucks1, truckId, drives1);
        }

    }

    private static void writeFileTruck(String object) {
        Path write = Paths.get(String.valueOf(URL_TRUCK));

        try {
            Files.writeString(write, object, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private static String readFileTruckc() {
        String json = "";
        try {
            FileReader reader = new FileReader(String.valueOf(URL_TRUCK));
            int a;
            while ((a = reader.read()) != -1) {
                json += (char) a;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return json;


    }

    private static void writeFileDrive(String object) {
        Path write = Paths.get(String.valueOf(URL_DRIVER));

        try {
            Files.writeString(write, object, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    static String readFileDriver() {
        String json = "";
        try {
            FileReader reader = new FileReader(String.valueOf(URL_DRIVER));
            int a;
            while ((a = reader.read()) != -1) {
                json += (char) a;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return json;


    }
}