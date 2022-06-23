package ru.job4j.foodcontrol;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Store {

    private final List<Food> goods = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean validated = validate(food);
        if (validated) {
            goods.add(food);
        }
        return validated;
    }

    @Override
    public boolean validate(Food food) {
        return getPercentLifeExpired(food) < PercentagesLifeExpired.PERCENT_25.getPercent();
    }

    @Override
    public List<Food> getGoods() {
        return new ArrayList<>(goods);
    }
}
