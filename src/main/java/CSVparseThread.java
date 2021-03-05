import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVparseThread extends Thread {

    private String fileName;
    private int numLine = 1;

    @Override
    public synchronized void start() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            while (reader.ready()) {
                String[] s = reader.readLine().split(",");
                MainParse.outStringList.add(new OutString(s[0], s[1], s[2], s[3], fileName, numLine));
                numLine++;
            }
            reader.close();
        }
        catch (IOException e) {
            MainParse.outStringList.add(new OutString(fileName, numLine, e.toString()));
        }
    }

    public CSVparseThread(String fileName) {
        this.fileName = fileName;
    }
}
