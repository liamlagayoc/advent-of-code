package test.java.day1;

import main.java.day1.Inventory;
import main.java.day1.Elf;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {
    private Inventory inventory;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void it_returns_a_string_of_data_to_be_returned() {
        String textOutput = "1000\n" +
                "2000\n" +
                "3000\n" +
                "\n" +
                "4000\n" +
                "\n" +
                "5000\n" +
                "6000\n" +
                "\n" +
                "7000\n" +
                "8000\n" +
                "9000\n" +
                "\n" +
                "10000";
        String filename = "src/test/resources/input_day1_test.txt";
        assertEquals(inventory.getInventory(filename), textOutput);
    }

    @Test
    void the_inventory_contains_one_elf() {
        String input = "1000\n" +
                "2000\n" +
                "3000";

        inventory.processInventory(input);
        assertEquals(inventory.getNumberOfElves(), 1);
    }

    @Test
    void the_inventory_contains_two_elves() {
        String input = "1000\n" +
                "2000\n" +
                "3000\n" +
                "\n" +
                "4000";

        inventory.processInventory(input);
        assertEquals(inventory.getNumberOfElves(), 2);
    }

    @Test
    void the_inventory_contains_three_elves() {
        String input = "1000\n" +
                "2000\n" +
                "3000\n" +
                "\n" +
                "4000\n" +
                "\n" +
                "5000\n" +
                "6000";

        inventory.processInventory(input);
        assertEquals(inventory.getNumberOfElves(), 3);
    }

    @Test
    void it_contains_the_correct_number_of_calories_per_elf() {
        String input = "1000\n" +
                "2000\n" +
                "3000\n" +
                "\n" +
                "4000\n" +
                "\n" +
                "5000\n" +
                "6000";

        inventory.processInventory(input);
        List<Elf> elves = inventory.getElves();
        assertEquals(elves.get(0).getNumberOfCalories(), 6000);
        assertEquals(elves.get(1).getNumberOfCalories(), 4000);
        assertEquals(elves.get(2).getNumberOfCalories(), 11000);
    }

    @Test
    void the_inventory_returns_the_highest_number_of_calories_with_one_elf() {
        String input = "1000\n" +
                "2000\n" +
                "3000";

        inventory.processInventory(input);
        assertEquals(inventory.calculateHighestNumberOfCalories(), 6000);
    }

    @Test
    void the_inventory_returns_the_highest_number_of_calories_with_two_elves() {
        String input = "1000\n" +
                "2000\n" +
                "3000\n" +
                "\n" +
                "6001";

        inventory.processInventory(input);
        assertEquals(inventory.calculateHighestNumberOfCalories(), 6001);
    }

    @Test
    void the_inventory_returns_the_highest_number_of_calories_with_four_elves() {
        String input = "1000\n" +
                "2000\n" +
                "3000\n" +
                "\n" +
                "6001\n" +
                "\n" +
                "2000\n" +
                "2000\n" +
                "500\n" +
                "\n" +
                "9500";

        inventory.processInventory(input);
        assertEquals(inventory.calculateHighestNumberOfCalories(), 9500);
    }

    @Test
    void it_returns_zero_if_no_input_exists() {
        inventory.processInventory("");
        assertEquals(inventory.calculateHighestNumberOfCalories(), 0);
    }

    @Test
    void it_adds_an_elf_to_the_inventory_list() {
        Elf elf = new Elf(0);
        elf.addFood(5000);
        inventory.addElfToInventoryList(elf);
        assertEquals(inventory.getNumberOfElves(), 1);
    }

    @Test
    void it_returns_zero_when_no_elves_exist() {
        assertEquals(inventory.calculateNumberOfCaloriesForTopElves(0), 0);
    }

    @Test
    void it_calculates_the_number_of_calories_for_the_top_elf() {
        String input = "1000\n" +
                "2000\n" +
                "3000";

        inventory.processInventory(input);
        assertEquals(inventory.calculateNumberOfCaloriesForTopElves(1), 6000);
    }

    @Test
    void it_calculates_the_number_of_calories_for_the_top_two_elves() {
        String input = "1000\n" +
                "2000\n" +
                "3000\n" +
                "\n" +
                "6001\n" +
                "\n" +
                "5000";

        inventory.processInventory(input);
        assertEquals(inventory.calculateNumberOfCaloriesForTopElves(2), 12001);
    }

    @Test
    void it_calculates_the_number_of_calories_for_the_top_three_elves_when_less_than_three_elves_exist() {
        String input = "1000\n" +
                "2000\n" +
                "3000\n" +
                "\n" +
                "1200";

        inventory.processInventory(input);
        assertEquals(inventory.calculateNumberOfCaloriesForTopElves(3), 7200);
    }

    @Test
    void it_calculates_the_number_of_calories_for_the_top_three_elves_when_three_elves_exist() {
        String input = "1000\n" +
                "2000\n" +
                "3000\n" +
                "\n" +
                "1200\n" +
                "\n" +
                "9000";

        inventory.processInventory(input);
        assertEquals(inventory.calculateNumberOfCaloriesForTopElves(3), 16200);
    }


    @Test
    void it_calculates_the_number_of_calories_for_the_top_three_elves_when_more_than_three_elves_exist() {
        String input = "1000\n" +
                "2000\n" +
                "3000\n" +
                "\n" +
                "6001\n" +
                "\n" +
                "15000\n" +
                "28000\n" +
                "\n" +
                "1200\n" +
                "\n" +
                "9000";

        inventory.processInventory(input);
        assertEquals(inventory.calculateNumberOfCaloriesForTopElves(3), 58001);
    }
}
