package stringpool;

import java.io.File;
import java.util.List;

/**
 * Created by AmitAgarwal on 11/12/19.
 */
public class BatchProcessor {

    private volatile int test = 0;
    private static volatile int test1 = 0;

    /**
     * factory design pattern
     * also know as virtual constructor
     */

    public void processBatch(String fileName){
        File file = openFile(fileName);
        TextParser parser = new TextParser(file);
        List<Record> records = parser.parse();
        processRecords(records);
        writeSummary();
        closeFile(file);
    }

    private File openFile(String fileName) {
        System.out.println("Opening file");
        return new File("File_Name");
    }

    private void processRecords(List<Record> records) {
        System.out.println("Processing each record");
    }

    private void writeSummary() {
        System.out.println("Wrote batch Summary....");
    }

    private void closeFile(File file) {
        System.out.println("CLosed File");
    }


}
