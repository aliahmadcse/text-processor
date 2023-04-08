package src.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.stream.Stream;

public class FileMerger {

    public FileMerger(){

    }

    public static void mergeTwoFiles(){

        Path filePath1 = Paths.get("src/main/resources/input.txt");
        Path filePath2 = Paths.get("src/main/resources/input2.txt");
        Path outPutPath = Paths.get("src/main/resources/output.txt");
        Charset charset = StandardCharsets.UTF_8;

        try{
            Stream<String> lines1 = Files.lines(filePath1, charset);
            Stream<String> lines2 = Files.lines(filePath2, charset);
            Files.write(outPutPath, (Iterable<String>) lines1::iterator);
            Files.write(outPutPath, (Iterable<String>) lines2::iterator);
        }catch (IOException ioException){
            System.out.println("Issues reading a file");
            ioException.printStackTrace();
        }


    }
}
