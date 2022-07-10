package ru.job4j.ood.isp.menu;

import java.util.Scanner;

public interface MenuAction {

    String name();

    boolean execute(Menu menu, MenuPrinter menuPrinter, ActionDelegate actionDelegate, Scanner scanner);
}
