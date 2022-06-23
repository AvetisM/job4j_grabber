package ru.job4j.foodcontrol;

import java.time.LocalDate;

public class Bread extends Food {
    public Bread(String name, LocalDate createDate, LocalDate expiryDate, double price, double discount) {
        super(name, createDate, expiryDate, price, discount);
    }
}
