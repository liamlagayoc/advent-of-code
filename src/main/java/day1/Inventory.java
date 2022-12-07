package main.java.day1;

import java.util.*;

public class Inventory {
    private List<Elf> elfList;

    public Inventory() {
        elfList = new ArrayList<>();
    }

    public int calculateHighestNumberOfCalories() {
        if(elfList.isEmpty()) {
            return 0;
        }

        Elf elfWithHighestCalories = Collections.max(elfList, Comparator.comparingInt(Elf::getNumberOfCalories));
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

    public int getElfList() {
        return elfList.size();
    }

    public void addElfToInventoryList(Elf elf) {
        elfList.add(elf);
    }

    private Elf createElf() {
        return new Elf(0);
    }

    public List<Elf> getElves() {
        return this.elfList;
    }
}
