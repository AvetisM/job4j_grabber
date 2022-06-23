package ru.job4j.foodcontrol;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ControlQualityTest {

    private List<Store> storeList;
    private Trash trashStore;
    private Shop shopStore;
    private Warehouse warehouseStore;

    @Before
    public void initData() {
        trashStore = new Trash();
        shopStore = new Shop();
        warehouseStore = new Warehouse();

        storeList = new ArrayList<>();
        storeList.add(trashStore);
        storeList.add(shopStore);
        storeList.add(warehouseStore);
    }

    @Test
    public void whenTrash() {
        LocalDate now = LocalDate.now();
        LocalDate expiryDate = now.minusDays(1);
        Food food = new Food("food", now, expiryDate, 100, 0);
        List<Food> foodList = List.of(food);
        ControlQuality controlQuality = new ControlQuality(storeList);
        controlQuality.sortGoods(foodList);
        assertThat(trashStore.getGoods(), is(List.of(food)));
    }

    @Test
    public void whenWarehouse() {
        LocalDate now = LocalDate.now();
        LocalDate expiryDate = now.plusDays(30);
        Food food = new Food("food", now, expiryDate, 100, 0);
        List<Food> foodList = List.of(food);
        ControlQuality controlQuality = new ControlQuality(storeList);
        controlQuality.sortGoods(foodList);
        assertThat(warehouseStore.getGoods(), is(List.of(food)));
    }

    @Test
    public void whenShop() {
        LocalDate now = LocalDate.now();
        LocalDate createDate = now.minusDays(20);
        LocalDate expiryDate = now.plusDays(10);
        Food food = new Food("food", createDate, expiryDate, 100, 0);
        List<Food> foodList = List.of(food);
        ControlQuality controlQuality = new ControlQuality(storeList);
        controlQuality.sortGoods(foodList);
        assertThat(shopStore.getGoods(), is(List.of(food)));
    }

    @Test
    public void whenShopAndSetDiscount() {
        LocalDate now = LocalDate.now();
        LocalDate createDate = now.minusDays(20);
        LocalDate expiryDate = now.plusDays(5);
        Food food = new Food("food", createDate, expiryDate, 100, 0);
        List<Food> foodList = List.of(food);
        ControlQuality controlQuality = new ControlQuality(storeList);
        controlQuality.sortGoods(foodList);
        Assert.assertEquals(50.0, shopStore.getGoods().get(0).getDiscount(), 0.00);
    }

    @Test
    public void whenSeveralGoods() {
        LocalDate now = LocalDate.now();

        LocalDate createDate = now.minusDays(20);
        LocalDate expiryDate = now.plusDays(5);
        Food milk = new Milk("food", createDate, expiryDate, 100, 0);

        createDate = now;
        expiryDate = now.plusDays(30);
        Food bread = new Bread("food", createDate, expiryDate, 100, 0);

        createDate = now;
        expiryDate = now.minusDays(1);
        Food bread2 = new Bread("food", createDate, expiryDate, 100, 0);

        List<Food> foodList = List.of(milk, bread, bread2);
        ControlQuality controlQuality = new ControlQuality(storeList);
        controlQuality.sortGoods(foodList);

        assertThat(trashStore.getGoods(), is(List.of(bread2)));
        assertThat(warehouseStore.getGoods(), is(List.of(bread)));
        assertThat(shopStore.getGoods(), is(List.of(milk)));
    }
}