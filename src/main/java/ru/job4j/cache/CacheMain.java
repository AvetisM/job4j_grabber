package ru.job4j.cache;

public class CacheMain {
    public static void main(String[] args) {
        DirFileCache dirFileCache = new DirFileCache("./data/files");
        String names = dirFileCache.get("Names.txt");
        System.out.println(names);
        String addresses = dirFileCache.get("Address.txt");
        System.out.println(addresses);

        Emulator emulator = new Emulator();
        String namesE = emulator.get("Names.txt");
        System.out.println(namesE);
        String addressesE = emulator.get("Address.txt");
        System.out.println(addressesE);
    }
}
