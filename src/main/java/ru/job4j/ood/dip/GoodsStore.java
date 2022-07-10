package ru.job4j.ood.dip;

import java.util.HashMap;

public class GoodsStore {
    HashMap<Goods, Integer> store = new HashMap<>();

    public boolean add(String name, Integer price) {
        Goods goods = new Goods(name, price);
        store.put(goods, goods.getPriceWithVat());
        System.out.println("Добавлен товар " + name + " с ценой " + goods.getPriceWithVat());
        return true;
    }
}
