package ru.job4j.ood.ocp;

import java.util.ArrayList;

public class ElectronicDevice {
    private ArrayList<String> featureList;

    public ArrayList<String> getFeatureList() {
        return featureList;
    }

    public void charge() {
        System.out.println("Charging...");
    }

}
