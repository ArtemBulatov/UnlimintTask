package ru.bulatov.unlimintTask.typesOfParse;

import com.google.gson.Gson;
import ru.bulatov.unlimintTask.MainParse;
import ru.bulatov.unlimintTask.OutString;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonParser {

    private String jsonFileName;
    private JsonString jsonString;

    public JsonParser(JsonString jsonString) {
        this.jsonString = jsonString;
    }

    public void setJsonFileName(String jsonFileName) {
        this.jsonFileName = jsonFileName;
    }

    public Map<Integer, OutString> getOutStrings() {
        Map<Integer, OutString> outStringMap = new HashMap<>();
        int numLine = 1; // переменная для подсчёта строк в файле

        try {
            BufferedReader reader = new BufferedReader(new FileReader(jsonFileName));
            while (reader.ready()) {
                Gson gson = new Gson();
                jsonString = gson.fromJson(reader.readLine(), JsonString.class);
                int id = Integer.parseInt(jsonString.getOrderId());
                outStringMap.put(id, new OutString(id, jsonString.getAmount(), jsonString.getCurrency(), jsonString.getComment(), jsonFileName, numLine));
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
