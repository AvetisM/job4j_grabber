package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        Predicate<Integer> predicate = p -> p > 0;
        return findMinMax(value, comparator, predicate);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        Predicate<Integer> predicate = p -> p < 0;
        return findMinMax(value, comparator, predicate);
    }

    public <T> T findMinMax(List<T> value, Comparator<T> comparator, Predicate predicate) {
        T result = null;
        if (value.size() != 0) {
            result = value.get(0);
            for (int i = 1; i < value.size(); i++) {
                T cur = value.get(i);
                if (predicate.test(comparator.compare(cur, result))) {
                    result = cur;
                }
            }
        }
        return result;
    }
}
