package main.java.day1;

import java.util.*;

public class Day1 {
    private List<Elf> numberOfElves;

    public Day1() {
        numberOfElves = new ArrayList<>();
    }

    public int calculateHighestNumberOfCalories() {
        if(numberOfElves.isEmpty()) {
            return 0;
        }

        Elf elfWithHighestCalories = Collections.max(numberOfElves, Comparator.comparingInt(Elf::getNumberOfCalories));
        return elfWithHighestCalories.getNumberOfCalories();
    }

    public String getInventory(String filename) {
        return FileUtils.getInventory(filename);
    }

    public void processInventory(String input) {
        Elf elf = createElf();
        for(Iterator<String> inventoryIterator = Arrays.stream(FileUtils.splitFileContent(input)).iterator(); inventoryIterator.hasNext();) {
            String inventoryItem = inventoryIterator.next();
            if(inventoryItem.isEmpty()) {
                addElfToInventoryList(elf);
                elf = createElf();
            } else {
                elf.addFood(Integer.valueOf(inventoryItem));
                if(!inventoryIterator.hasNext()) {
                   addElfToInventoryList(elf);
                }
            }
        }
    }

    public int getNumberOfElves() {
        return numberOfElves.size();
    }

    public void addElfToInventoryList(Elf elf) {
        numberOfElves.add(elf);
    }

    private Elf createElf() {
        return new Elf(0);
    }
}
