package ru.bulatov.unlimintTask.typesOfFiles;

import java.util.Map;

public class CSVfile implements File{
    String fileName;

    public CSVfile(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Map<Integer, String> fileStrings() {
        return null;
    }
}
