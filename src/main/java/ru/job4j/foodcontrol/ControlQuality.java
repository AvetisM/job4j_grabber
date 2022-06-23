package ru.job4j.foodcontrol;

import java.util.List;

public class ControlQuality {
    private List<Store> storeList;

    public ControlQuality(List<Store> storeList) {
        this.storeList = storeList;
    }

    public void sortGoods(List<Food> goods) {
        for (Food food : goods) {
            for (Store store : storeList) {
                if (store.validate(food)) {
                    store.add(food);
                    break;
                }
            }
        }
    }
}
