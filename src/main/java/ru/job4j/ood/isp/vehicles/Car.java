package ru.job4j.ood.isp.vehicles;

public class Car implements Vehicle {
    @Override
    public void move() {
        System.out.println("the car is moving");
    }

    @Override
    public void dig() {
        throw new UnsupportedOperationException();
    }
}
