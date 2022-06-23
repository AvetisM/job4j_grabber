package ru.job4j.foodcontrol;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {

    private final List<Food> goods = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean validated = validate(food);
        if (validated) {
            if (getPercentLifeExpired(food) > PercentagesLifeExpired.PERCENT_75.getPercent()) {
                food.setDiscount(50);
            }
            goods.add(food);
        }
        return validated;
    }

    @Override
    public boolean validate(Food food) {
        double percent = getPercentLifeExpired(food);
        return percent >= PercentagesLifeExpired.PERCENT_25.getPercent()
                && percent < PercentagesLifeExpired.PERCENT_100.getPercent();
    }

    @Override
    public List<Food> getGoods() {
        return new ArrayList<>(goods);
    }

}
