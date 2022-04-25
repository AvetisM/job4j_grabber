package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    public void put(String key) {
        super.put(key, load(key));
    }

    @Override
    public String get(String key) {
        String rls = super.get(key);
        if (rls == null) {
            put(key);
        }
        return super.get(key);
    }

    @Override
    protected String load(String key) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader rd = new BufferedReader(new FileReader(cachingDir + "/" + key))) {
            for (String line = rd.readLine(); line != null; line = rd.readLine()) {
                stringBuilder.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
