package ru.job4j.parkingservice;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CityParkingTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenTruckSizeEquals1() {
        Vehicle truck = new Truck("truck", 1);
    }

    @Test
    public void whenEnoughSpace() {
        VehicleStore vehicleStore = new CityParking(3, 5);
        Vehicle truck1 = new Truck("truck1", 3);
        Vehicle truck2 = new Truck("truck2", 3);
        Vehicle car1 = new Car("car");
        assertTrue(vehicleStore.add(truck1));
        assertTrue(vehicleStore.add(truck2));
        assertTrue(vehicleStore.add(car1));
        assertThat(vehicleStore.getVehicles(), is(List.of(truck1, truck2, car1)));
    }

    @Test
    public void whenNotEnoughSpace() {
        VehicleStore vehicleStore = new CityParking(3, 3);
        Vehicle truck1 = new Truck("truck1", 3);
        Vehicle truck2 = new Truck("truck2", 3);
        Vehicle car1 = new Car("car");
        vehicleStore.add(truck1);
        vehicleStore.add(truck2);
        assertFalse(vehicleStore.add(car1));
    }

    @Test
    public void whenNotEnoughSpaceForTruck() {
        VehicleStore vehicleStore = new CityParking(2, 0);
        Vehicle truck1 = new Truck("truck1", 3);
        assertFalse(vehicleStore.add(truck1));
    }

    @Test
    public void whenNotEnoughSpaceForCar() {
        VehicleStore vehicleStore = new CityParking(2, 3);
        Vehicle car1 = new Car("car1");
        Vehicle car2 = new Car("car2");
        Vehicle car3 = new Car("car3");
        vehicleStore.add(car1);
        vehicleStore.add(car2);
        assertFalse(vehicleStore.add(car3));
    }
}