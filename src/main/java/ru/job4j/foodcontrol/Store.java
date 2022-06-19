package ru.job4j.foodcontrol;

import java.util.List;

public interface Store {

    void add(Food food);

    boolean validate(Food food);

    List<Food> getGoods();
}
