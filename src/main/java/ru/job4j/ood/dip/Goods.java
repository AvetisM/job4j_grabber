package ru.job4j.ood.dip;

public class Goods {
    private String name;
    private int price;
    public final int vat = 20;

    public Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPriceWithVat() {
        return price * vat / 100;
    }
}
