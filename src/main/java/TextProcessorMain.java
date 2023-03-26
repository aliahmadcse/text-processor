import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextProcessorMain {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello world");

        while (true) {
            System.out.println("Enter 1 - To sort lines in Ascending order");
            System.out.println("Enter 2 - To sort lines in Descending order");
            System.out.println("Enter 3 - To remove duplicates lines");
            System.out.println("Enter 4 - Search for a text and return the count");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int option = bufferedReader.read();

            switch (option) {
                case 4:
            }

        }
    }
}
