package ru.bulatov.unlimintTask.typesOfParse;

import ru.bulatov.unlimintTask.OutString;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class CsvParser {    // класс для парсинга файлов типа scv

    private String csvFileName;
    private final Map<Integer, OutString> outStringMap = new HashMap<>(); // хранит данные из одного файла в готовом для вывода виде

    public void setCsvFileName(String csvFileName) {
        this.csvFileName = csvFileName;
    }

    // метод возвращает данные
    public Map<Integer, OutString> getOutStrings() {

        int numLine = 1;    // переменная для подсчёта строк в файле

        try {
            BufferedReader reader = new BufferedReader(new FileReader(csvFileName));

            while (reader.ready()) {
                String[] s = reader.readLine().split(",");
                int id = Integer.parseInt(s[0]);
                OutString outString = new OutString(id, s[1], s[2], s[3], csvFileName, numLine); // создание строки в формате готовом для вывода
                outStringMap.put(id, outString);
                numLine++;
            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return outStringMap;
    }

}
