package test.java.day1;

import main.java.day1.Day1;
import main.java.day1.Elf;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class Day1Test {
    private Day1 dayOne;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        dayOne = new Day1();
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
        assertEquals(dayOne.getNumberOfElves(), 1);
    }

    @Test
    void the_inventory_contains_two_elves() {
        String input = "1000\n" +
                "2000\n" +
                "3000\n" +
                "\n" +
                "4000";

        dayOne.processInventory(input);
        assertEquals(dayOne.getNumberOfElves(), 2);
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
        assertEquals(dayOne.getNumberOfElves(), 3);
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
    void it_gets_the_elf_with_highest_number_of_calories() {
        assertEquals(dayOne.calculateHighestNumberOfCalories(), 0);
    }

    @Test
    void it_adds_an_elf_to_the_inventory_list() {
        Elf elf = new Elf(0);
        elf.addFood(5000);
        dayOne.addElfToInventoryList(elf);
        assertEquals(dayOne.getNumberOfElves(), 1);
    }
}
