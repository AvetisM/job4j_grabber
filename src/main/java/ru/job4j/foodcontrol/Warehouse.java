package ru.job4j.foodcontrol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Store {

    private final List<Food> goods = new ArrayList<>();

    @Override
    public void add(Food food) {
        goods.add(food);
    }

    @Override
    public boolean validate(Food food) {
        boolean rls = false;
        LocalDate currentDate = LocalDate.now();
        if (food.getExpiryDate().compareTo(currentDate) > 0) {
            long daysLeft = food.getExpiryDate().toEpochDay() - currentDate.toEpochDay();
            long daysAll = food.getExpiryDate().toEpochDay() - food.getCreateDate().toEpochDay();
            rls = daysLeft / daysAll * 100 < 25;
        }
        return rls;
    }

    @Override
    public List<Food> getGoods() {
        return goods;
    }
}
