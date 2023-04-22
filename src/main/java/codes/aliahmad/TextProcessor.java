package codes.aliahmad;

import codes.aliahmad.logger.ConsoleLogger;
import codes.aliahmad.logger.Logger;
import codes.aliahmad.models.Arguments;
import codes.aliahmad.utils.ArgUtil;
import codes.aliahmad.utils.FileMerger;
import codes.aliahmad.utils.LineDuplicateRemover;
import codes.aliahmad.utils.ReplaceText;
import codes.aliahmad.utils.SearchText;
import codes.aliahmad.utils.SortLines;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class TextProcessor {

    private static final Logger logger = new ConsoleLogger();
    public static void main(String[] args) throws IOException
    {
        // parse the arguments
        Arguments arguments = new ArgUtil().parseArguments(args);
        System.out.println(arguments);

//        switch (arguments.getCommand())
//        {
//            case SORT ->
//            {
//
//            }
//            case SEARCH ->
//            {
//
//            }
//            case REPLACE ->
//            {
//
//            }
//            case MERGE ->
//            {
//
//            }
//            case DEDUP ->
//            {
//
//            }
//        }

        label:
        while (true) {
            System.out.println("Enter 1 - To sort lines in Ascending order");
            System.out.println("Enter 2 - To sort lines in Descending order");
            System.out.println("Enter 3 - To remove duplicates lines");
            System.out.println("Enter 4 - Search for a text and return the line number");
            System.out.println("Enter 5 - To replace a specific text");
            System.out.println("Enter 6 - Ability to merge two or more text files into a single file");

            System.out.println("Enter 7 - To exit");


            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();


            switch (option) {
                case 1:
                    SortLines.sortLinesInDescending();
                    break;

                case 2:
                    SortLines.sortLinesInAscending();
                    break;

                case 3:
                    LineDuplicateRemover.removeDuplicateLines();
                    break;

                case 4: {
                    System.out.println("Enter the word to be searched");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                    String searchText = bufferedReader.readLine();
                    List<Integer> number = SearchText.count(searchText);
                    System.out.println(number);
                    break;
                }
                case 5: {
                    System.out.println("Enter a text to be replaced");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                    String toBeReplacedText = bufferedReader.readLine();
                    System.out.println("Enter replacement text");
                    String replacementText = bufferedReader.readLine();
                    boolean result = ReplaceText.textReplace(toBeReplacedText, replacementText);
                    if (result) {
                        System.out.println("Text replace");
                    } else {
                        System.out.println("Text cannot be replaced");
                    }
                    break;
                }

                case 6: {
                    FileMerger.mergeTwoFiles();
                }
                case 7:
                    break label;
            }

        }
    }
}
