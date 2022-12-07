package test.java.day1;

import main.java.day1.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileUtilsTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void it_returns_an_inventory_to_process() {
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
        assertEquals(FileUtils.getInventory(filename), textOutput);
    }

    @Test
    void it_prints_out_an_error_if_file_is_not_found() {
        String filename = "src/test/resources/input_day2_test.txt";
        String output = FileUtils.getInventory(filename);
        String outputLogs = outContent.toString();
        assertEquals("File not found: " + filename, outputLogs);
        assertEquals("", output);
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

        assertArrayEquals(FileUtils.splitFileContent(textInput), calorieContents);
    }
}
