package ru.job4j.cache;

import java.util.Scanner;

public class GetFileAction implements UserAction {

    @Override
    public String name() {
        return "Получение файла";
    }

    @Override
    public boolean execute(DirFileCache dirFileCache, Scanner scanner) {
        System.out.println("=== Получение файла ===");
        System.out.println("Укажите имя файла: ");
        String fileName = scanner.next();
        if (dirFileCache.fileExists(fileName)) {
            String value = dirFileCache.get(fileName);
            System.out.println("Содержимое файла: ");
            System.out.println(value);
        } else {
            System.out.println("Файл не найден!");
        }
        return true;
    }
}
