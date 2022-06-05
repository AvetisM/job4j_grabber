package ru.job4j.design.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportJsonTest {

    @Test
    public void whenJsonGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Gson gson = new GsonBuilder().create();
        Report json = new ReportJson(store);
        String expect = gson.toJson(List.of(worker));
        assertThat(json.generate(em -> true), is(expect));
    }
}