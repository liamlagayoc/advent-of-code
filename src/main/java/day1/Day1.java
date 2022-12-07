package main.java.day1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1 {
    private List<Elf> numberOfElves;

    public Day1() {
        numberOfElves = new ArrayList<>();
    }

    public int calculateHighestNumberOfCalories() {
        return 0;
    }

    public String dataToProcess(String filename) {
        String data = readFile(filename);
        return data;
    }

    public Elf createElf() {
        return new Elf(0);
    }

    private String readFile(String filename) {
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

    public String[] splitFileContent(String textInput) {
        return textInput.split("\n");
    }

    public void processInventory(String input) {
        Elf elf = createElf();
        for(String inputText : splitFileContent(input)) {
            elf.addFood(Integer.valueOf(inputText));
        }
        numberOfElves.add(elf);
    }

    public int getNumberOfElves() {
        return numberOfElves.size();
    }

    public int getCaloriesForElf() {
        return numberOfElves.get(0).getNumberOfCalories();
    }
}
