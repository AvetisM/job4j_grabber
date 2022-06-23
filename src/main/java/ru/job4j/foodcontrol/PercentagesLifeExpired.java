package ru.job4j.foodcontrol;

public enum PercentagesLifeExpired {
    PERCENT_25(25),
    PERCENT_75(75),
    PERCENT_100(100);

    private final int percent;

    PercentagesLifeExpired(int percent) {
        this.percent = percent;
    }

    public int getPercent() {
        return percent;
    }
}
