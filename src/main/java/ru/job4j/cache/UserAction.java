package ru.job4j.cache;

import java.util.Scanner;

public interface UserAction {

    String name();

    boolean execute(DirFileCache dirFileCache, Scanner scanner);
}
