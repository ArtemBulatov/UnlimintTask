package ru.bulatov.unlimintTask;

import ru.bulatov.unlimintTask.typesOfParse.CsvParser;
import ru.bulatov.unlimintTask.typesOfParse.JsonParser;

public class FilesParser extends Thread{

    private String fileName;
    private CsvParser csvParser;
    private JsonParser jsonParser;

    public FilesParser(CsvParser csvParser, JsonParser jsonParser) {
        this.csvParser = csvParser;
        this.jsonParser = jsonParser;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public synchronized void run() {
        String[] strArr = fileName.split("\\.");
        String fileType = strArr[strArr.length - 1];

        if (fileType.equals("json")) {
            jsonParser.setJsonFileName(fileName);
            ParseApp.resultStrings.putAll(jsonParser.getOutStrings());
        }
        else if (fileType.equals("csv")) {
            csvParser.setCsvFileName(fileName);
            ParseApp.resultStrings.putAll(csvParser.getOutStrings());
        }
        else {
            System.out.println(fileName + " - этот тип файлов пока не поддерживается данной программой.");
        }
    }
}
