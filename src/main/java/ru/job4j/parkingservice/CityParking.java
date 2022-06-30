package ru.job4j.parkingservice;

import java.util.ArrayList;
import java.util.List;

public class CityParking implements VehicleStore {

    private final int carSpaceNumber;
    private final int truckSpaceNumber;
    private final List<Vehicle> vehicles;

    public CityParking(int carSpaceNumber, int truckSpaceNumber) {
        this.carSpaceNumber = carSpaceNumber;
        this.truckSpaceNumber = truckSpaceNumber;
        this.vehicles = new ArrayList<>(carSpaceNumber + truckSpaceNumber);
    }

    @Override
    public boolean add(Vehicle vehicles) {
        return false;
    }

    @Override
    public List<Vehicle> getVehicles() {
        return null;
    }
}
