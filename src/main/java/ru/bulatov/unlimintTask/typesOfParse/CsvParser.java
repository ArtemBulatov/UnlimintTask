package ru.bulatov.unlimintTask.typesOfParse;
import ru.bulatov.unlimintTask.MainParse;
import ru.bulatov.unlimintTask.OutString;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class CsvParser {

    private String fileName;

    public CsvParser(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void parse() {
        System.out.println("CsvParser. Начало парсинга файла " + getFileName());
        int numLine = 1;    // переменная для подсчёта строк в файле

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            while (reader.ready()) {
                String[] s = reader.readLine().split(",");
                int id = Integer.parseInt(s[0]);
                MainParse.resultStrings.put(id, new OutString(id, s[1], s[2], s[3], getFileName(), numLine));
                numLine++;
            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Парсинг файла " + getFileName() +  " завершён.");
    }

}
