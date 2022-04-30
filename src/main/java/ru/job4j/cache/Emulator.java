package ru.job4j.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Emulator extends AbstractCache<String, String> {

    public static void main(String[] args) {
        List<UserAction> actions = new ArrayList<>();
        actions.add(new LoadFileAction());
        actions.add(new GetFileAction());
        System.out.println("Укажите путь к файлам: ");
        Scanner scanner = new Scanner(System.in);
        String emulatorDir = scanner.nextLine();
        DirFileCache dirFileCache = new DirFileCache(emulatorDir);
        boolean run = true;
        while (run) {
            showMenu(actions);
            int itemNumber = scanner.nextInt();
            if (itemNumber < 0 || itemNumber >= actions.size()) {
                System.out.println("Вы ввели не правильную команду");
                continue;
            }
            run = actions.get(itemNumber).execute(dirFileCache, scanner);
        }
    }

    private static void showMenu(List<UserAction> actions) {
        System.out.println("Выбирите действие:");
        for (int i = 0; i < actions.size(); i++) {
            System.out.println(i + "." + actions.get(i).name());
        }
    }
}
