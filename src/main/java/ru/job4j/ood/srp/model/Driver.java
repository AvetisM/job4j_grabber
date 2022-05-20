package ru.job4j.ood.srp.model;

public class Driver {

    private String name;
    private double salaryPerHour;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalaryPerHour(double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public double getSalaryPerHour() {
        return salaryPerHour;
    }

    public double getSalary(int hours) {
        return this.salaryPerHour * hours;
    }

}
