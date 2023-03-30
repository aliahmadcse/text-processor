package src.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SearchText {


    public SearchText() {

    }

    public static List<Integer> count(String text) {

        Path path = Paths.get("src/main/resources/input.txt");
        List<Integer> lineNumbers = new ArrayList<>();

        try {

            String filesContext = new String(Files.readAllBytes(path));
            String[] lines = filesContext.split("\\r?\\n");

            for (int i = 0; i < lines.length; i++) {
                if (lines[i].equals(text)) {
                    lineNumbers.add(i + 1);
                }
            }

        } catch (IOException ioException) {
            System.out.println("Error reading files");
            ioException.printStackTrace();
        }
        return lineNumbers;
    }
}
