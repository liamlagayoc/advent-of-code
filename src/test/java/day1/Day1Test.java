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
        assertEquals(dayOne.dataToProcess(filename), textOutput);
    }

    @Test
    void it_prints_out_an_error_if_file_is_not_found() {
        String filename = "src/test/resources/input_day2_test.txt";
        String output = dayOne.dataToProcess(filename);
        String outputLogs = outContent.toString();
        assertEquals("File not found: " + filename, outputLogs);
        assertEquals("", output);
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
    void it_returns_the_correct_number_of_calories_for_the_elf() {
        String input = "1000\n" +
                "2000\n" +
                "3000";

        dayOne.processInventory(input);
        assertEquals(dayOne.getCaloriesForElf(), 6000);
    }

    @Test
    void it_splits_the_data() {
        String textInput = "1000\n" +
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

        String[] calorieContents = new String[] {
                "1000",
                "2000","3000","","4000","","5000","6000","",
                "7000","8000","9000","","10000"
        };

        assertArrayEquals(dayOne.splitFileContent(textInput), calorieContents);
    }

    @Test
    void it_creates_an_elf() {
        assertNotNull(dayOne.createElf());
    }

    @Test
    void it_gets_the_elf_with_highest_number_of_calories() {
        assertEquals(dayOne.calculateHighestNumberOfCalories(), 0);
    }
}
