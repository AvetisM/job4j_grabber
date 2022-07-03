package ru.job4j.ood.isp.vehicles;

public class Excavator implements Vehicle {
    @Override
    public void move() {
        System.out.println("the excavator is moving");
    }

    @Override
    public void dig() {
        System.out.println("the excavator is digging");
    }
}
