package filereader;

import java.io.*;

public class FileReaderWriter {

    public static void main(String[] args) {
        String inputFile  ="/Users/amitagarwal/Documents/Cloud/test.txt";
        String outputFile = "/Users/amitagarwal/Documents/Cloud/test2.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            FileWriter fileWriter = new FileWriter(outputFile);
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line +  " " );
                fileWriter.write(line);
            }
            System.out.println("Successfully copied the content");
        } catch (FileNotFoundException e) {
            System.out.println("File Not found exception .... " + e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Runtime exception .... " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
