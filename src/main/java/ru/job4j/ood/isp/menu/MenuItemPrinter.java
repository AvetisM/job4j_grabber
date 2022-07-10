package ru.job4j.ood.isp.menu;

public class MenuItemPrinter implements MenuPrinter {

    private static final String INDENT = " ";

    @Override
    public void print(Menu menu) {
        for (Menu.MenuItemInfo itemInfo : menu) {
            System.out.println(getIndent(itemInfo) + itemInfo.getNumber() + itemInfo.getName());
        }
    }

    String getIndent(Menu.MenuItemInfo itemInfo) {
        String currentIndent = "";
        int length = itemInfo.getNumber().length();
        for (int i = 0; i < length; i++) {
            currentIndent = currentIndent.concat(INDENT);
        }
        return currentIndent;
    }
}
