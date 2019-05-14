package readfile;

import java.io.File;

/**
 * Created by AmitAgarwal on 3/17/19.
 */
public class FileReader extends File implements AutoCloseable {

    public FileReader(String path){
        super(path);
    }

    @Override
    public void close() throws Exception {

    }
}
