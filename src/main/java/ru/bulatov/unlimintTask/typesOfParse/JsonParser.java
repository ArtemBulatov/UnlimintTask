package ru.bulatov.unlimintTask.typesOfParse;

import com.google.gson.Gson;
import ru.bulatov.unlimintTask.MainParse;
import ru.bulatov.unlimintTask.OutString;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class JsonParser {

    private String fileName;

    public JsonParser(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void parse() {
        System.out.println("JsonParser. Начало парсинга файла " + getFileName());
        int numLine = 1; // переменная для подсчёта строк в файле

        Gson gson = new Gson();
        JsonString js;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while (reader.ready()) {
                js = gson.fromJson(reader.readLine(), JsonString.class);
                int id = Integer.parseInt(js.getOrderId());
                MainParse.resultStrings.put(id, new OutString(id, js.getAmount(), js.getCurrency(), js.getComment(), getFileName(), numLine));
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
