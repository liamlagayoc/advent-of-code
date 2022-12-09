package main.java.day1;

public class Elf implements Comparable<Elf> {
    private int numberOfCalories;

    public Elf(int numberOfCalories) {
        this.numberOfCalories = numberOfCalories;
    }

    public int getNumberOfCalories() {
        return this.numberOfCalories;
    }

    public void addFood(int numberOfCalories) {
        if(numberOfCalories < 0) {
            System.out.print("Negative number provided. Unable to add");
            return;
        }
        this.numberOfCalories += numberOfCalories;
    }

    @Override
    public int compareTo(Elf elfToCompare) {
        if(numberOfCalories > elfToCompare.numberOfCalories)
            return 1;
        else if(numberOfCalories < elfToCompare.numberOfCalories)
            return -1;
        return 0;
    }
}
