package ru.job4j.foodcontrol;

import java.time.LocalDate;
import java.util.List;

public interface Store {

    boolean add(Food food);

    List<Food> getGoods();

    boolean validate(Food food);

    default double getPercentLifeExpired(Food food) {
        double rls = 100;
        LocalDate currentDate = LocalDate.now();
        if (food.getExpiryDate().compareTo(currentDate) > 0) {
            double daysLeft = food.getExpiryDate().toEpochDay() - currentDate.toEpochDay();
            double daysAll = food.getExpiryDate().toEpochDay() - food.getCreateDate().toEpochDay();
            rls = daysLeft == daysAll ? 0 : (1 - daysLeft / daysAll) * 100;
        }
        return rls;
    }
}
