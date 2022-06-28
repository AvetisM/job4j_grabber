package ru.job4j.parkingservice;

import java.util.Objects;

public class Car implements Vehicle {

    private String name;
    private int parkingSpaceNumber;

    public Car(String name) {
        this.name = name;
        this.parkingSpaceNumber = 1;
    }

    public String getName() {
        return name;
    }

    public int getParkingSpaceNumber() {
        return parkingSpaceNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean isTruck() {
        return this.parkingSpaceNumber > 1;
    }
}
