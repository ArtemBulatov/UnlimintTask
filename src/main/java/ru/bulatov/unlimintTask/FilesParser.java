package ru.bulatov.unlimintTask;

import ru.bulatov.unlimintTask.typesOfParse.CsvParser;
import ru.bulatov.unlimintTask.typesOfParse.JsonParser;

import java.util.HashMap;
import java.util.Map;

public class FilesParser extends Thread{

    private String fileName;
    private CsvParser csvParser;
    private JsonParser jsonParser;
    private Map<Integer, OutString> outStringsFromFile = new HashMap<>();

    public FilesParser(CsvParser csvParser, JsonParser jsonParser) {
        this.csvParser = csvParser;
        this.jsonParser = jsonParser;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Map<Integer, OutString> getOutStringsFromFile() {
        return outStringsFromFile;
    }

    @Override
    public void run() {
        String[] strArr = fileName.split("\\.");
        String fileType = strArr[strArr.length - 1];

        switch (fileType) {
            case "json":
                jsonParser.setJsonFileName(fileName);
                outStringsFromFile.putAll(jsonParser.getOutStrings());
                break;

            case "csv":
                csvParser.setCsvFileName(fileName);
                outStringsFromFile.putAll(csvParser.getOutStrings());
                break;

            default:
                System.out.println(fileName + " - этот тип файлов пока не поддерживается данной программой.");
                break;
        }

    }
}
