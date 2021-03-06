package ru.bulatov.unlimintTask;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Map;
import java.util.TreeMap;

public class MainParse {

    public final static Map<Integer, OutString> resultStrings = new TreeMap<>();   // готовые выходные данные

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        String fileName1 = "src/main/java/ru/bulatov/unlimintTask/TestFile1.csv";
        String fileName2 = "src/main/java/ru/bulatov/unlimintTask/TestFile2.csv";
        String fileName3 = "src/main/java/ru/bulatov/unlimintTask/testFile1.json";
        String fileName4 = "src/main/java/ru/bulatov/unlimintTask/testFile2.json";

        String[] argsTest = {fileName1, fileName2, fileName3, fileName4};

        FilesParser parser = new FilesParser();
        parser.setFileNames(argsTest);
        parser.parse();

        for(int i : resultStrings.keySet()) {
            System.out.println(resultStrings.get(i));
        }

    }
}
