package ru.job4j.design.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Calendar;
import java.util.List;

public class ReportHRTest {

    @Test
    public void whenForHRGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 83);
        Employee worker1 = new Employee("Vasiliy", now, now, 75);
        Employee worker2 = new Employee("Fedor", now, now, 100);
        store.add(worker);
        store.add(worker1);
        store.add(worker2);
        List<Employee> employeeList = List.of(worker2, worker, worker1);
        Report report = new ReportHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : employeeList) {
            expect.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        assertThat(report.generate(em -> true), is(expect.toString()));
    }

}