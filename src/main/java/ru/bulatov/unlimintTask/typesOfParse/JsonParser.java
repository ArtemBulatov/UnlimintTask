package ru.bulatov.unlimintTask.typesOfParse;

import com.google.gson.Gson;
import ru.bulatov.unlimintTask.OutString;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonParser { // класс для парсинга файлов типа json

    private String jsonFileName;
    private final Map<Integer, OutString> outStringMap = new HashMap<>();   // хранит данные из одного файла в готовом для вывода виде

    public void setJsonFileName(String jsonFileName) {
        this.jsonFileName = jsonFileName;
    }

    public Map<Integer, OutString> getOutStrings() {

        int numLine = 1; // переменная для подсчёта строк в файле

        Gson gson = new Gson();
        JsonString js;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(jsonFileName));
            while (reader.ready()) {
                js = gson.fromJson(reader.readLine(), JsonString.class);
                int id = Integer.parseInt(js.getOrderId());
                OutString outString = new OutString(id, js.getAmount(), js.getCurrency(), js.getComment(), jsonFileName, numLine); // создание строки в формате готовом для вывода
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

    class JsonString {      // класс для сохранения данных из строки файла типа json
        private String orderId;              // - идентификатор ордера
        private String amount;          // - сумма ордера
        private String currency;    // - валюта суммы ордера
        private String comment;     // - комментарий по ордеру

        public String getOrderId() {
            return orderId;
        }

        public String getAmount() {
            return amount;
        }

        public String getCurrency() {
            return currency;
        }

        public String getComment() {
            return comment;
        }
    }

}
