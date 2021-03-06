package ru.bulatov.unlimintTask;

import ru.bulatov.unlimintTask.typesOfParse.CsvParser;
import ru.bulatov.unlimintTask.typesOfParse.JsonParser;
import java.util.ArrayList;
import java.util.List;


public class FilesParser {

    private String[] fileNames;

    // сохранямем сюда ссылки на треды, чтобы можно было подождать окончания их работы
    private final List<Thread> threadList = new ArrayList<>();

    public void setFileNames(String[] fileNames) {
        this.fileNames = fileNames;
    }

    public void parse() {

        for (String fileName : fileNames) {
            String[] strArr = fileName.split("\\.");
            String fileType = strArr[strArr.length-1];

            if (fileType.equals("json")) {
                JsonParser jsonParser = new JsonParser(fileName);
                threadList.add(jsonParser);
                jsonParser.start();
            }
            else if (fileType.equals("csv")) {
                CsvParser csvParser = new CsvParser(fileName);
                threadList.add(csvParser);
                csvParser.start();
            }
            else {
                System.out.println(fileName + " - этот вид файла пока не поддерживается данной программой.");
            }
        }

        // теперь ждём окончания работы всх тредов

        try {
            for(Thread thread : threadList) {
                thread.join();
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
