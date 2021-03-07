package ru.bulatov.unlimintTask;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.bulatov.unlimintTask.config.SpringConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ParseApp {

    // готовые выходные данные сохраняются в TreeMap, чтобы быть отсортированными по id
    public final static Map<Integer, OutString> resultStrings = new TreeMap<>();

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class
        );

        List<FilesParser> parsers = new ArrayList<>();  // лист для сохранения ссылок на объекты парсинга.
                                                        // нужен, чтобы потом можно былоо подождать завершения парсинга
        for (String fileName : args) {
            FilesParser parser = context.getBean("filesParser", FilesParser.class);
            parser.setFileName(fileName);
            parser.start();
            parsers.add(parser);
        }

        try {
            for(FilesParser parser : parsers) {
                parser.join();                  // ожидаем завершения всех потоков парсинга
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        // вывод данных
        for(int i : resultStrings.keySet()) {
            System.out.println(resultStrings.get(i));
        }

    }
}
