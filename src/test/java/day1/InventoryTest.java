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
    private Inventory dayOne;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        dayOne = new Inventory();
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
        assertEquals(dayOne.getInventory(filename), textOutput);
    }

    @Test
    void the_inventory_contains_one_elf() {
        String input = "1000\n" +
                "2000\n" +
                "3000";

        dayOne.processInventory(input);
        assertEquals(dayOne.getElfList(), 1);
    }

    @Test
    void the_inventory_contains_two_elves() {
        String input = "1000\n" +
                "2000\n" +
                "3000\n" +
                "\n" +
                "4000";

        dayOne.processInventory(input);
        assertEquals(dayOne.getElfList(), 2);
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

        dayOne.processInventory(input);
        assertEquals(dayOne.getElfList(), 3);
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

        dayOne.processInventory(input);
        List<Elf> elves = dayOne.getElves();
        assertEquals(elves.get(0).getNumberOfCalories(), 6000);
        assertEquals(elves.get(1).getNumberOfCalories(), 4000);
        assertEquals(elves.get(2).getNumberOfCalories(), 11000);
    }

    @Test
    void the_inventory_returns_the_highest_number_of_calories_with_one_elf() {
        String input = "1000\n" +
                "2000\n" +
                "3000";

        dayOne.processInventory(input);
        assertEquals(dayOne.calculateHighestNumberOfCalories(), 6000);
    }

    @Test
    void the_inventory_returns_the_highest_number_of_calories_with_two_elves() {
        String input = "1000\n" +
                "2000\n" +
                "3000\n" +
                "\n" +
                "6001";

        dayOne.processInventory(input);
        assertEquals(dayOne.calculateHighestNumberOfCalories(), 6001);
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

        dayOne.processInventory(input);
        assertEquals(dayOne.calculateHighestNumberOfCalories(), 9500);
    }

    @Test
    void it_returns_zero_if_no_input_exists() {
        dayOne.processInventory("");
        assertEquals(dayOne.calculateHighestNumberOfCalories(), 0);
    }

    @Test
    void it_adds_an_elf_to_the_inventory_list() {
        Elf elf = new Elf(0);
        elf.addFood(5000);
        dayOne.addElfToInventoryList(elf);
        assertEquals(dayOne.getElfList(), 1);
    }
}
