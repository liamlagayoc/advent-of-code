import main.java.day1.Inventory;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        String input = inventory.getInventory("src/main/resources/input_day1.txt");
        inventory.processInventory(input);
        System.out.println("Number of elves in inventory: " + inventory.getElfList());
        System.out.println(inventory.calculateHighestNumberOfCalories());
    }
}
