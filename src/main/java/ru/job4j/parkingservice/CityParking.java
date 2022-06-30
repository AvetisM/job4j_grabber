package ru.job4j.parkingservice;

import java.util.ArrayList;
import java.util.List;

public class CityParking implements VehicleStore {

    private int carSpaceNumber;
    private int truckSpaceNumber;
    private final List<Vehicle> vehicles;

    public CityParking(int carSpaceNumber, int truckSpaceNumber) {
        this.carSpaceNumber = carSpaceNumber;
        this.truckSpaceNumber = truckSpaceNumber;
        this.vehicles = new ArrayList<>(carSpaceNumber + truckSpaceNumber);
    }

    @Override
    public boolean add(Vehicle vehicle) {
        boolean rls = false;
        if (vehicle.getSize() == Car.SIZE) {
            if (carSpaceNumber - Car.SIZE >= 0) {
                vehicles.add(vehicle);
                carSpaceNumber -= Car.SIZE;
                rls = true;
            }
        } else {
            int vehicleSize = vehicle.getSize();
            if (carSpaceNumber + truckSpaceNumber - vehicleSize >= 0) {
                vehicles.add(vehicle);
                int minSize = Math.min(truckSpaceNumber, vehicleSize);
                truckSpaceNumber -= minSize;
                vehicleSize -= minSize;
                if (vehicleSize > 0) {
                    carSpaceNumber -= vehicleSize;
                }
                rls = true;
            }
        }
        return rls;
    }

    @Override
    public List<Vehicle> getVehicles() {
        return new ArrayList<>(vehicles);
    }
}
