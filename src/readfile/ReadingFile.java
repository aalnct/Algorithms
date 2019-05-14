package readfile;

import java.io.LineNumberReader;

/**
 * Created by AmitAgarwal on 3/17/19.
 */
public class ReadingFile {

    public static void main(String [] args) throws Exception{
        String file_read = "Helloworld.txt";
        String readAll;
        LineNumberReader lineNumberReader;

            lineNumberReader = new LineNumberReader(new java.io.FileReader(file_read));
            while((readAll = lineNumberReader.readLine())!=null){
                System.out.println(lineNumberReader.getLineNumber() + " " + readAll);
            }
        }
    }

