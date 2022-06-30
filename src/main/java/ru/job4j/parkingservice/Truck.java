package ru.job4j.parkingservice;

import java.util.Objects;

public class Truck implements Vehicle {

    private String name;
    private int size;

    public Truck(String name, int size) {
        this.name = name;
        setSize(size);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        if (size < 2) {
            throw new IllegalArgumentException("Truck size must be more than 1");
        }
        this.size = size;
    }

    public String getName() {
        return name;
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

    @Override
    public int getSize() {
        return this.size;
    }

}
