package src.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SearchText {


    public SearchText() {

    }

    public static int count(String text){
        try {
            Path path = Paths.get("src/main/resources/input.txt");
            String filesContext = new String(Files.readAllBytes(path));

        } catch (IOException ioException){
            System.out.println("Error reading files");
            ioException.printStackTrace();
        }



        return 1;
    }
}
