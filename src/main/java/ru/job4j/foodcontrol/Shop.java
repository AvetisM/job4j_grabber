package ru.job4j.foodcontrol;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {

    private final List<Food> goods = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean validated = validate(food);
        if (validated) {
            if (getPercentLifeExpired(food) > 75) {
                food.setDiscount(50);
            }
            goods.add(food);
        }
        return validated;
    }

    @Override
    public boolean validate(Food food) {
        double percent = getPercentLifeExpired(food);
        return percent >= 25 && percent < 100;
    }

    @Override
    public List<Food> getGoods() {
        return new ArrayList<>(goods);
    }

}
