package main.java.day1;

public class Elf {
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
}
