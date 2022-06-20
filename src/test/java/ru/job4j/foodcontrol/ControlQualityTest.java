package ru.job4j.foodcontrol;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControlQualityTest {

    private List<Store> storeList;

    @Before
    public void initData() {
        storeList = new ArrayList<>();
        storeList.add(new Trash());
        storeList.add(new Warehouse());
        storeList.add(new Shop());
    }

    @Test
    public void whenTrash() {
        LocalDate createDate = LocalDate.of(2022, 5, 5);
        LocalDate expiryDate = LocalDate.of(2022, 6, 17);
        Food food = new Food("food", createDate, expiryDate, 100, 0);
        List<Food> foodList = List.of(food);
        ControlQuality controlQuality = new ControlQuality(storeList);
        controlQuality.sortGoods(foodList);
        Store trash =  storeList.get(0);
        Food expected = trash.getGoods().get(0);
        Assert.assertEquals(expected, food);
    }

    @Test
    public void whenWarehouse() {
        LocalDate createDate = LocalDate.of(2022, 5, 5);
        LocalDate expiryDate = LocalDate.of(2022, 6, 30);
        Food food = new Food("food", createDate, expiryDate, 100, 0);
        List<Food> foodList = List.of(food);
        ControlQuality controlQuality = new ControlQuality(storeList);
        controlQuality.sortGoods(foodList);
       /* Store warehouse = storeList.get(0);
        Food expected = warehouse.getGoods().get(0);
        Assert.assertEquals(expected, food);*/
    }

}