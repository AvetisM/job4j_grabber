package ru.job4j.foodcontrol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {

    private final List<Food> goods = new ArrayList<>();

    @Override
    public void add(Food food) {
        goods.add(food);
    }

    @Override
    public boolean validate(Food food) {
        LocalDate currentDate = LocalDate.now();
        return food.getExpiryDate().compareTo(currentDate) <= 0;
    }

    @Override
    public List<Food> getGoods() {
        return goods;
    }
}
