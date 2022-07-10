package ru.job4j.ood.isp.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TODOApp {

    public static final ActionDelegate STUB_ACTION = System.out::println;

    public static void main(String[] args) {
        List<MenuAction> actions = new ArrayList<>();
        actions.add(new AddItemAction());
        actions.add(new ShowList());
        Menu menu = new SimpleMenu();
        MenuPrinter menuPrinter = new MenuItemPrinter();

        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            showMenu(actions);
            int itemNumber = scanner.nextInt();
            if (itemNumber < 0 || itemNumber >= actions.size()) {
                System.out.println("Вы ввели не правильную команду");
                continue;
            }
            run = actions.get(itemNumber).execute(menu, menuPrinter, STUB_ACTION, scanner);
        }
    }

    private static void showMenu(List<MenuAction> actions) {
        System.out.println("Выберите действие:");
        for (int i = 0; i < actions.size(); i++) {
            System.out.println(i + "." + actions.get(i).name());
        }
    }
}
