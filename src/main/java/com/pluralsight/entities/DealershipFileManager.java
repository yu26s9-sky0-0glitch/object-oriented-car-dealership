package com.pluralsight.entities;
import java.io.BufferedReader;
import java.io.FileReader;

public class DealershipFileManager {
    public Dealership getDealership() {

        Dealership dealership = null;
        try {
            FileReader fr = new FileReader("data/inventory.csv");
            BufferedReader bf = new BufferedReader(fr);
            String headline = bf.readLine();
            String[] headParts = headline.split("\\|");
            dealership = new Dealership(headParts[0], headParts[1], headParts[2]);
            String line;
            while ((line = bf.readLine()) != null) {
                String[] parts = line.split("\\|");
                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String vehicleType = parts[4];
                String color = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);
                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                dealership.addVehicle(v);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dealership;
    }
    public void saveDealership(Dealership dealership){

    }
}
