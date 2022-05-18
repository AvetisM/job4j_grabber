package ru.job4j.ood.srp;

import java.util.ArrayList;

public interface Calculate {
    int multiply(ArrayList<Integer> multipliers);
    ArrayList<Integer> getMultipliers(int first, int last);
}
