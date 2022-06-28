package ru.job4j.parkingservice;

import java.util.Objects;

public class Truck implements Vehicle {

    private String name;
    private int parkingSpaceNumber;

    public Truck(String name, int parkingSpaceNumber) {
        this.name = name;
        this.parkingSpaceNumber = parkingSpaceNumber;
    }

    public String getName() {
        return name;
    }

    public int getParkingSpaceNumber() {
        return parkingSpaceNumber;
    }

    @Override
    public boolean isTruck() {
        return this.parkingSpaceNumber > 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Truck truck = (Truck) o;
        return Objects.equals(name, truck.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
