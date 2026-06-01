package se.kth.iv1350.bikeRepairShop.adaption;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdaptionMainTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testMainPrintsExpectedOutput() {
        AdaptionMain.main(new String[]{});

        String output = outContent.toString();

        assertTrue(output.contains("--- Testing Inheritance Adapter ---"), "Missing inheritance adapter header.");
        assertTrue(output.contains("Random even number (0-20):"), "Missing random even number output.");
        assertTrue(output.contains("Original method nextBoolean():"), "Missing nextBoolean output.");
        assertTrue(output.contains("--- Testing Composition Adapter ---"), "Missing composition adapter header.");
        assertTrue(output.contains("Cannot access original Random methods directly."),
            "Missing composition adapter explanation.");
    }
}
