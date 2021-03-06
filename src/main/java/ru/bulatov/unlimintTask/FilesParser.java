package ru.bulatov.unlimintTask;

import ru.bulatov.unlimintTask.typesOfParse.CsvParser;
import ru.bulatov.unlimintTask.typesOfParse.JsonParser;


public class FilesParser extends Thread{

    private String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public synchronized void run() {
        String[] strArr = fileName.split("\\.");
        String fileType = strArr[strArr.length - 1];

        if (fileType.equals("json")) {
            JsonParser jsonParser = new JsonParser(fileName);
            jsonParser.parse();
        } else if (fileType.equals("csv")) {
            CsvParser csvParser = new CsvParser(fileName);
            csvParser.parse();
        } else {
            System.out.println(fileName + " - этот вид файла пока не поддерживается данной программой.");
        }
    }
}
