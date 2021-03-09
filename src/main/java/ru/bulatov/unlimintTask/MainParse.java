package ru.bulatov.unlimintTask;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.bulatov.unlimintTask.config.SpringConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MainParse {

    public final static Map<Integer, OutString> resultStrings = new TreeMap<>();   // готовые выходные данные

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class
        );

        List<FilesParser> parsers = new ArrayList<>();
        for (String fileName : args) {
            FilesParser parser = context.getBean("filesParser", FilesParser.class);
            parser.setFileName(fileName);
            parsers.add(parser);
            parser.start();
        }

        try {
            for(FilesParser parser : parsers) {
                parser.join();
                resultStrings.putAll(parser.getOutStringsFromFile());
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i : resultStrings.keySet()) {
            System.out.println(resultStrings.get(i));
        }

    }
}
