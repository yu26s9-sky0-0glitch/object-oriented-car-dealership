package com.pluralsight.ui;

import com.pluralsight.entities.Dealership;
import com.pluralsight.entities.DealershipFileManager;
import com.pluralsight.entities.Vehicle;

import java.util.ArrayList;

public class UserInterface {
    private Dealership dealership;

    public UserInterface() {
    }
    public void display(){
        init();
        int command;
        do{
            System.out.println("\n--- Welcome to " + dealership.getName() + " ---");
            command = Console.promptForInt("""
                    1 - Find vehicles within a price range
                    2 - Find vehicles by make / model
                    3 - Find vehicles by year range
                    4 - Find vehicles by color
                    5 - Find vehicles by mileage range
                    6 - Find vehicles by type (car, truck, SUV, van)
                    7 - List ALL vehicles
                    8 - Add a vehicle
                    9 - Remove a vehicle
                    99 - Quit
                    -> """);
           switch (command){
            case 1:
               processGetByPriceRequest();
               break;
            case 2:
               proccessGetByMakeModelRequest();
               break;
            case 3:
               proccessGetByYearRequest();
               break;
            case 4:
                proccessGetByColorRequest();
                break;
            case 5:
                proccessGetByMileageRequest();
                break;
            case 6:
                proccessGetByVehicleTypeRequest();
                break;
            case 7:
                proccessGetByAllVehicleRequest();
                break;
            case 8:
                proccessGetByAddVehicleRequest();
                break;
            case 9:
                proccessGetByRemoveVehicleRequest();
                break;
            case 99:
                System.out.println("Goodbye!");
                break;
        }
        }while(command!=99);

    }

    private void processGetByPriceRequest() {
    }
    private void proccessGetByMakeModelRequest() {
    }
    private void proccessGetByYearRequest() {
    }
    private void proccessGetByColorRequest() {
    }
    private void proccessGetByMileageRequest() {
    }
    private void proccessGetByVehicleTypeRequest() {
    }
    private void proccessGetByAllVehicleRequest() {
        displayVehicleRequest(dealership.getAllVehicle());
    }
    private void proccessGetByAddVehicleRequest() {
    }
    private void proccessGetByRemoveVehicleRequest() {
    }
    private  void init(){
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();
    }
    private void displayVehicleRequest(ArrayList<Vehicle> vehicle){
        System.out.println("*----------------------------------------------------------------------------------------------------------------------------*");
        System.out.printf("|  %-10s ||   %-10s ||   %-10s ||   %-10s ||   %-10s ||   %-10s ||   %-10s ||   %-10s|\n",
                "VIN", "Year", "Make", "Model", "Type", "Color", "Odometer", "Price");
        System.out.println("|----------------------------------------------------------------------------------------------------------------------------|");
        for(Vehicle v:vehicle){
            System.out.printf("|  %-10d ||   %-10d ||   %-10s ||   %-10s ||   %-10s ||   %-10s ||   %-10d ||   %-10.2f|\n",
                    v.getVin(),v.getYear(),v.getMake(),v.getModel(),
                    v.getVehicleType(),v.getColor(),v.getOdometer(),v.getPrice());
        }

    }
}
