package ru.job4j.ood.isp.menu;

import java.util.Scanner;

public class ShowList implements MenuAction {
    @Override
    public String name() {
        return "Вывести список";
    }

    @Override
    public boolean execute(Menu menu, MenuPrinter menuPrinter,
                           ActionDelegate actionDelegate, Scanner scanner) {
        menuPrinter.print(menu);
        return true;
    }
}
