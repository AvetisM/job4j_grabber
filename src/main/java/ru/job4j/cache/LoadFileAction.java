package ru.job4j.cache;

import java.io.File;
import java.util.Scanner;

public class LoadFileAction implements UserAction {

    @Override
    public String name() {
        return "Загрузка файла";
    }

    @Override
    public boolean execute(DirFileCache dirFileCache, Scanner scanner) {
        System.out.println("=== Загрузка файла ===");
        System.out.println("Укажите имя файла: ");
        String fileName = scanner.next();
        if (dirFileCache.fileExists(fileName)) {
            dirFileCache.load(fileName);
            System.out.println("Файл " + fileName + " загружен.");
        } else {
            System.out.println("Файл " + fileName + " не найден!");
        }
        return true;
    }
}
