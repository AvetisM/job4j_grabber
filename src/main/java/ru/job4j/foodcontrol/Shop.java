package ru.job4j.foodcontrol;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {

    private final List<Food> goods = new ArrayList<>();

    @Override
    public void add(Food food) {
        goods.add(food);
    }

    @Override
    public boolean validate(Food food) {
        return false;
    }

    @Override
    public List<Food> getGoods() {
        return goods;
    }
}
