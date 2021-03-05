
import java.util.ArrayList;
import java.util.List;

public class MainParse {


    public static volatile List<OutString> outStringList = new ArrayList<>();

    public static void main(String[] args)  {
        String fileName1 = "C:\\Users\\artem\\IdeaProjects\\UnlimintTask\\src\\main\\java\\TestFile1.csv";
        String fileName2 = "C:\\Users\\artem\\IdeaProjects\\UnlimintTask\\src\\main\\java\\TestFile2.csv";

        Thread thread1 = new CSVparseThread(fileName1);
        Thread thread2 = new CSVparseThread(fileName2);
        thread1.start();
        thread2.start();


        for(OutString string : outStringList) {
            System.out.println(string);
        }

    }
}
