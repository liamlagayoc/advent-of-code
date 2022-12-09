package test.java.day1;

import main.java.day1.Elf;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElfTest {
    private Elf elf;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        elf = new Elf(0);
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void it_gets_the_number_of_calories() {
        assertEquals(elf.getNumberOfCalories(), 0);
    }

    @Test
    void it_adds_a_number_of_calories_for_the_elf() {
        int numberOfCalories = 200;
        elf.addFood(numberOfCalories);
        assertEquals(elf.getNumberOfCalories(), 200);
    }

    @Test
    void it_gets_the_correct_calories_when_two_lots_of_food_are_added() {
        elf.addFood(150);
        elf.addFood(300);
        assertEquals(elf.getNumberOfCalories(), 450);
    }

    @Test
    void it_prints_an_error_if_a_negative_value_is_provided() {
        elf.addFood(-1);
        String outputLogs = outContent.toString();
        assertEquals("Negative number provided. Unable to add", outputLogs);
        assertEquals(elf.getNumberOfCalories(), 0);
    }

    @Test
    void it_gets_the_correct_number_of_calories_if_negative_value_provided_after_valid_value() {
        elf.addFood(1000);
        elf.addFood(275);
        elf.addFood(-1);
        String outputLogs = outContent.toString();
        assertEquals("Negative number provided. Unable to add", outputLogs);
        assertEquals(elf.getNumberOfCalories(), 1275);
    }

    @Test
    void it_returns_one_if_elf_has_higher_number_of_calories_than_another_elf() {
        elf.addFood(1250);
        Elf elfToCompare = new Elf(0);
        elfToCompare.addFood(1249);

        assertEquals(elf.compareTo(elfToCompare), 1);
    }

    @Test
    void it_returns_minus_one_if_elf_has_lower_number_of_calories_than_another_elf() {
        elf.addFood(1250);
        Elf elfToCompare = new Elf(0);
        elfToCompare.addFood(1252);

        assertEquals(elf.compareTo(elfToCompare), -1);
    }

    @Test
    void it_returns_zero_if_elf_has_same_number_of_calories_than_another_elf() {
        elf.addFood(1250);
        Elf elfToCompare = new Elf(0);
        elfToCompare.addFood(1250);

        assertEquals(elf.compareTo(elfToCompare), 0);
    }
}
