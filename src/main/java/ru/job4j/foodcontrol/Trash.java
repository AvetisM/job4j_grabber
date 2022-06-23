package ru.job4j.foodcontrol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {

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
        return getPercentLifeExpired(food) >= PercentagesLifeExpired.PERCENT_100.getPercent();
    }

    @Override
    public List<Food> getGoods() {
        return new ArrayList<>(goods);
    }
}
