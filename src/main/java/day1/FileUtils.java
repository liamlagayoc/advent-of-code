package main.java.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileUtils {
    public static String getInventory(String filename) {
        try(Scanner scanner = new Scanner(new File(filename))) {
            StringBuilder builder = new StringBuilder();
            while(scanner.hasNextLine()) {
                builder.append(scanner.nextLine());
                if(scanner.hasNextLine()) {
                    builder.append("\n");
                }
            }
            return builder.toString();
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.print("File not found: " + filename);
            return "";
        }
    }

    public static String[] splitFileContent(String textInput) {
        return textInput.split("\n");
    }
}
