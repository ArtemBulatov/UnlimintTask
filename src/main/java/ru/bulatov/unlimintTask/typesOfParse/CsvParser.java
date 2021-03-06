package ru.bulatov.unlimintTask.typesOfParse;
import ru.bulatov.unlimintTask.OutString;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class CsvParser {

    private String csvFileName;
    private final Map<Integer, OutString> outStringMap = new HashMap<>();

    public void setCsvFileName(String csvFileName) {
        this.csvFileName = csvFileName;
    }

    public Map<Integer, OutString> getOutStrings() {
        System.out.println("CsvParser. Начало парсинга файла " + csvFileName);
        int numLine = 1;    // переменная для подсчёта строк в файле

        try {
            BufferedReader reader = new BufferedReader(new FileReader(csvFileName));

            while (reader.ready()) {
                String[] s = reader.readLine().split(",");
                int id = Integer.parseInt(s[0]);
                outStringMap.put(id, new OutString(id, s[1], s[2], s[3], csvFileName, numLine));
                numLine++;
            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Парсинг файла " + csvFileName +  " завершён.");
        return outStringMap;
    }

}
