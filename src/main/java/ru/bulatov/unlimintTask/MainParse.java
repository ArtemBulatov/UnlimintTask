package ru.bulatov.unlimintTask;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MainParse {

    public static volatile Map<Integer, OutString> resultStrings = new TreeMap<>();   // готовые выходные данные

    public static void main(String[] args) throws InterruptedException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        String fileName1 = "src/main/java/ru/bulatov/unlimintTask/TestFile1.csv";
        String fileName2 = "src/main/java/ru/bulatov/unlimintTask/TestFile2.csv";
        String fileName3 = "src/main/java/ru/bulatov/unlimintTask/testFile1.json";
        String fileName4 = "src/main/java/ru/bulatov/unlimintTask/testFile2.json";

        String[] argsTest = {fileName4, fileName3, fileName2, fileName1};

        List<FilesParser> parserList = new ArrayList<>();
        for (String fileName : argsTest) {
            FilesParser parser = new FilesParser();
            parser.setFileName(fileName);
            parserList.add(parser);
            parser.start();
        }

        for (FilesParser parser : parserList) {
            parser.join();
        }

        for(int i : resultStrings.keySet()) {
            System.out.println(resultStrings.get(i));
        }

    }
}
