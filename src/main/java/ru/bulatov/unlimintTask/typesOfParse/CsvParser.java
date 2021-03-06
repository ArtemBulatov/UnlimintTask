package ru.bulatov.unlimintTask.typesOfParse;
import org.springframework.stereotype.Component;
import ru.bulatov.unlimintTask.MainParse;
import ru.bulatov.unlimintTask.OutString;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
public class CsvParser extends Thread {

    private final String fileName;

    public CsvParser(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public synchronized void run() {
        System.out.println("CsvParser. Начало работы потока " + getName());
        int numLine = 1;    // переменная для подсчёта строк в файле

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            while (reader.ready()) {
                String[] s = reader.readLine().split(",");
                int id = Integer.parseInt(s[0]);
                MainParse.resultStrings.put(id, new OutString(id, s[1], s[2], s[3], fileName, numLine));
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
