import main.java.day1.Day1;

public class Main {
    public static void main(String[] args) {
        Day1 day1 = new Day1();
        String input = day1.getInventory("src/main/resources/input_day1.txt");
        day1.processInventory(input);
        System.out.println("Number of elves in inventory: " + day1.getNumberOfElves());
        System.out.println(day1.calculateHighestNumberOfCalories());
    }
}
