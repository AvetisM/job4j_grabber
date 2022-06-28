package ru.job4j.parkingservice;

import java.util.ArrayList;
import java.util.List;

public class CityParking implements VehicleStore {

    private int carSpaceNumber;
    private int truckSpaceNumber;

    private final List<Vehicle> vehicles = new ArrayList<>();

    public CityParking(int carSpaceNumber, int truckSpaceNumber) {
        this.carSpaceNumber = carSpaceNumber;
        this.truckSpaceNumber = truckSpaceNumber;
    }

    public int getCarSpaceNumber() {
        return carSpaceNumber;
    }

    public int getTruckSpaceNumber() {
        return truckSpaceNumber;
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
