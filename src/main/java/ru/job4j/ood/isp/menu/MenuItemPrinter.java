package ru.job4j.ood.isp.menu;


public class MenuItemPrinter implements MenuPrinter {

    private static final String INDENT = " ";

    @Override
    public void print(Menu menu) {
        System.out.println(getMenuPrinterText(menu));
    }

    @Override
    public String getMenuPrinterText(Menu menu) {
        StringBuilder text = new StringBuilder();
        for (Menu.MenuItemInfo itemInfo : menu) {
            text.append(getIndent(itemInfo) + itemInfo.getNumber() + itemInfo.getName())
                    .append(System.lineSeparator());
        }
        return text.toString();
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
