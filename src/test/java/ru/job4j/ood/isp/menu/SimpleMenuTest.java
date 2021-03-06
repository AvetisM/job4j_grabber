package ru.job4j.ood.isp.menu;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;

public class SimpleMenuTest {

    public static final ActionDelegate STUB_ACTION = System.out::println;

    @Test
    public void whenAddThenReturnSame() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        assertEquals(
                new Menu.MenuItemInfo(
                        "Сходить в магазин", List.of("Купить продукты"), STUB_ACTION, "1."
                ),
                menu.select("Сходить в магазин").get()
        );
        assertEquals(
                new Menu.MenuItemInfo(
                        "Купить продукты", List.of("Купить хлеб", "Купить молоко"), STUB_ACTION, "1.1."
                ),
                menu.select("Купить продукты").get()
        );
        assertEquals(
                new Menu.MenuItemInfo(
                        "Покормить собаку", List.of(), STUB_ACTION, "2."
                ),
                menu.select("Покормить собаку").get()
        );
        menu.forEach(i -> System.out.println(i.getNumber() + i.getName()));
    }

    @Test
    public void whenAddThenSelect() {
        Menu menu = new SimpleMenu();
        assertTrue(menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION));
        assertFalse(menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION));
        assertTrue(menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION));
        assertEquals(
                new Menu.MenuItemInfo(
                        "Сходить в магазин", List.of("Купить продукты"), STUB_ACTION, "1."
                ),
                menu.select("Сходить в магазин").get()
        );
    }

    @Test
    public void whenMenuItemPrinterOutput() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        MenuPrinter menuPrinter = new MenuItemPrinter();
        StringBuilder expect = new StringBuilder()
                .append("  1.Сходить в магазин")
                .append(System.lineSeparator())
                .append("    1.1.Купить продукты")
                .append(System.lineSeparator())
                .append("      1.1.1.Купить хлеб")
                .append(System.lineSeparator())
                .append("      1.1.2.Купить молоко")
                .append(System.lineSeparator())
                .append("  2.Покормить собаку")
                .append(System.lineSeparator());
        assertThat(expect.toString(), is(menuPrinter.getMenuPrinterText(menu)));
    }
}