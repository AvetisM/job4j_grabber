package ru.job4j.parkingservice;

public class ParkingService {

    public void parkVehicles(VehicleStore vehicleStore, Vehicle vehicle) {
        if (vehicleStore.checkParkingSpace(
                vehicle, vehicleStore.getCarSpaceNumber(), vehicleStore.getTruckSpaceNumber())) {
            vehicleStore.add(vehicle);
        }
    }

}
