package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Emulator extends AbstractCache<String, String> {

    private final String emulatorDir;

    public Emulator() {
        System.out.println("Укажите путь к файлам...");
        Scanner scanner = new Scanner(System.in);
        this.emulatorDir = scanner.nextLine();
    }

    public void put(String key) {
        super.put(key, load(key));
    }

    @Override
    public String get(String key) {
        String rls = super.get(key);
        if (rls == null) {
            put(key);
        }
        return super.get(key);
    }

    @Override
    protected String load(String key) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader rd = new BufferedReader(new FileReader(emulatorDir + "/" + key))) {
            for (String line = rd.readLine(); line != null; line = rd.readLine()) {
                stringBuilder.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
