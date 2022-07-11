package ru.job4j.foodcontrol;

import java.util.ArrayList;
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

    public void resortGoods() {
        List<Food> sortedGoods = getGoodsFromStore();
        sortGoods(sortedGoods);
    }

    private List<Food> getGoodsFromStore() {
        List<Food> sortedGoods = new ArrayList<>();
        for (Store store: storeList) {
            sortedGoods.addAll(store.getGoods());
            store.removeAllGoods();
        }
        return sortedGoods;
    }
}
