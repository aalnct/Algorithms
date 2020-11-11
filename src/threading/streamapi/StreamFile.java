package threading.streamapi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFile {

    public static void main(String[] args) {
        String path = "/Users/AmitAgarwal/Documents/Algorithms/src/threading/streamapi/names";
        try {
            Stream<String> namesOfStream = Files.lines(Paths.get(path));
            List<String> list = namesOfStream.collect(Collectors.toList());
            list.stream().filter(a -> !a.equals("Adam")).forEach(System.out::println);
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }

}
