package ru.job4j.parkingservice;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CityParkingTest {

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenTruckSizeEquals1() {
        Vehicle truck = new Truck("truck", 1);
    }

    @Ignore
    public void whenEnoughSpace() {
        VehicleStore vehicleStore = new CityParking(3, 5);
        Vehicle truck1 = new Truck("truck1", 3);
        Vehicle truck2 = new Truck("truck2", 3);
        Vehicle car1 = new Car("car");
        vehicleStore.add(truck1);
        vehicleStore.add(truck2);
        vehicleStore.add(car1);
        assertThat(vehicleStore.getVehicles(), is(List.of(truck1, truck2, car1)));
    }

    @Ignore
    public void whenNotEnoughSpace() {
        VehicleStore vehicleStore = new CityParking(3, 3);
        Vehicle truck1 = new Truck("truck1", 3);
        Vehicle truck2 = new Truck("truck2", 3);
        Vehicle car1 = new Car("car");
        vehicleStore.add(truck1);
        vehicleStore.add(truck2);
        vehicleStore.add(car1);
        assertThat(vehicleStore.add(car1), is(false));
    }
}