package ru.bulatov.unlimintTask.typesOfFiles;

import java.util.Map;

public class JSONfile implements File {
    String name;

    public JSONfile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Map<Integer, String> fileStrings() {
        return null;
    }
}
