package ru.job4j.kiss;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MaxMinTest {

    List<Integer> list;
    Comparator comparator;

    @Before
    public void initData() {
        list = new ArrayList<>();
        list.add(12);
        list.add(127);
        list.add(87);
        list.add(1);
        list.add(100);
        comparator = Comparator.naturalOrder();
    }

    @Test
    public void whenFindMax() {
        MaxMin maxMin = new MaxMin();
        int rsl = maxMin.max(list, comparator);
        assertThat(rsl, is(127));
    }

    @Test
    public void whenFindMin() {
        MaxMin maxMin = new MaxMin();
        int rsl = maxMin.min(list, comparator);
        assertThat(rsl, is(1));
    }
}