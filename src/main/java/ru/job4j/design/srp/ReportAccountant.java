package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ReportAccountant implements Report {

    public static final double COEFFICIENT = 0.9;
    private Store store;

    public ReportAccountant(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        text.append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(calculateSalary(employee.getSalary())).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    private double calculateSalary(double salary) {
        return salary * COEFFICIENT;
    }
}
