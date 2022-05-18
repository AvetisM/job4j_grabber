package ru.job4j.ood.srp;

import java.nio.file.Path;
import java.util.ArrayList;

public interface ReadFile {
    void readJson(Path path);
    void readHtml(Path path);
    void saveFileData(ArrayList<String> data);
}
