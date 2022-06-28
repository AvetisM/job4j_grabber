package ru.job4j.parkingservice;

import java.util.List;

public interface VehicleStore {

    boolean add(Vehicle vehicle);

    List<Vehicle> getVehicles();

    int getCarSpaceNumber();

    int getTruckSpaceNumber();

    default boolean checkParkingSpace(Vehicle vehicle, int carSpaceNumber, int trucksSpaceNumber) {
        return false;
    }
}
