package src.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class LineDuplicateRemover {

    public LineDuplicateRemover(){

    }

    public static void removeDuplicateLines() {
        Path path = Paths.get("src/main/resources/input.txt");
        Set<String> uniqueLiens = new HashSet<>();
        Charset standardCharSet = StandardCharsets.UTF_8;

        try {
            Files.lines(path).forEach(uniqueLiens::add);
            Files.write(path, List.of(""), standardCharSet);
            Files.write(path, uniqueLiens, standardCharSet);
        } catch (IOException ioException){
            System.out.println("Having issues reading a file");
            ioException.printStackTrace();
        }
        uniqueLiens.forEach(System.out::println);



    }



}
