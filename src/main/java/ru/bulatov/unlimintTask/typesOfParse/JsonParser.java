package ru.bulatov.unlimintTask.typesOfParse;

import com.google.gson.Gson;
import ru.bulatov.unlimintTask.MainParse;
import ru.bulatov.unlimintTask.OutString;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class JsonParser extends Thread {

    private final String fileName;

    public JsonParser(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public synchronized void run() {
        System.out.println("JsonParser. Начало работы потока " + getName());
        int numLine = 1; // переменная для подсчёта строк в файле

        Gson gson = new Gson();
        JsonString js;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while (reader.ready()) {
                js = gson.fromJson(reader.readLine(), JsonString.class);
                int id = Integer.parseInt(js.getOrderId());
                MainParse.resultStrings.put(id, new OutString(id, js.getAmount(), js.getCurrency(), js.getComment(), fileName, numLine));
                numLine++;
            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Поток " + getName() +  " завершил работу.");
    }
}
