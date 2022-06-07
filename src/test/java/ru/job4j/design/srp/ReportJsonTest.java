package ru.job4j.design.srp;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportJsonTest {

    @Test
    public void whenJsonGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss X");
        String dateString = formatter.format(now.getTime());
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report json = new ReportJson(store);
        String employeeJsonTemplate =
                "{\"name\":\"%s\",\"hired\":\"%s\",\"fired\":\"%s\",\"salary\":%.1f}";
        StringBuilder expect = new StringBuilder()
                .append("{\"employees\":[")
                .append(String.format(Locale.US, employeeJsonTemplate,
                        worker.getName(), dateString, dateString, worker.getSalary()))
                .append("]}");
        assertThat(json.generate(em -> true), is(expect.toString()));
    }
}