package src.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReplaceText {

    public ReplaceText() {

    }

    public static boolean textReplace(String toBeReplacedText, String replacementText){
        Path path = Paths.get("src/main/resources/input.txt");
        Charset charset = StandardCharsets.UTF_8;
        try {
            String content = new String(Files.readAllBytes(path));
            content = content.replaceAll(toBeReplacedText, replacementText);
            Files.writeString(path, content, charset);
        } catch (IOException ioException) {
            System.out.println("Error reading files");
            ioException.printStackTrace();
        }
        return true;

    }
}
