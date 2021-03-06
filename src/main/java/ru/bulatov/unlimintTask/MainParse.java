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

        String fileName1 = "src/test/java/testFiles/TestFile1.csv";
        String fileName2 = "src/test/java/testFiles/testFile1.json";
        String fileName3 = "src/test/java/testFiles/TestFile2.csv";
        String fileName4 = "src/test/java/testFiles/testFile2.json";

        String[] argsTest = {fileName1, fileName3, fileName2, fileName4};

        List<FilesParser> parsers = new ArrayList<>();
        for (String fileName : argsTest) {
            FilesParser parser = context.getBean("filesParser", FilesParser.class);
            parser.setFileName(fileName);
            parser.start();
            parsers.add(parser);
        }

        try {
            for(FilesParser parser : parsers) {
                parser.join();
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("");
        for(int i : resultStrings.keySet()) {
            System.out.println(resultStrings.get(i));
        }

    }
}
