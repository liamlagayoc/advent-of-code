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

    public int getNumberOfElves() {
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

    public int calculateNumberOfCaloriesForTopElves(int numberOfElves) {
        Collections.sort(this.elfList, Collections.reverseOrder());
        if(numberOfElves > getNumberOfElves())
            return sumNumberOfCaloriesForTopElves(this.elfList);
        else
            return sumNumberOfCaloriesForTopElves(this.elfList.subList(0, numberOfElves));
    }

    private int sumNumberOfCaloriesForTopElves(List<Elf> topElves) {
        return topElves.stream().mapToInt(Elf::getNumberOfCalories).sum();
    }
}
