package ru.job4j.ood.isp.menu;

import java.util.Scanner;

public class AddItemAction implements MenuAction {

    @Override
    public String name() {
        return "Добавить задание";
    }

    @Override
    public boolean execute(Menu menu, MenuPrinter menuPrinter,
                           ActionDelegate actionDelegate, Scanner scanner) {
        System.out.println("=== Добавление задания ===");
        System.out.println("Укажите группу задания или оставьте пустой: ");
        String parentName = scanner.nextLine();
       if (!parentName.isEmpty()) {
            menu.add(Menu.ROOT, parentName, actionDelegate);
            System.out.println("Группа " + parentName + " добавлена.");
        } else {
           System.out.println("Укажите имя задания: ");
           String itemName = scanner.nextLine();
           menu.add(parentName, itemName, actionDelegate);
           System.out.println("Задание " + itemName + " добавлено.");
       }
        return true;
    }
}
