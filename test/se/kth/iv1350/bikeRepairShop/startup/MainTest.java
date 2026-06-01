package se.kth.iv1350.bikeRepairShop.startup;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class MainTest {
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
    public void testMainExecutesWithoutCrashing() {
        assertDoesNotThrow(() -> Main.main(new String[]{}), "Main method threw an unexpected exception.");
    }

    @Test
    public void testMainProducesExpectedOutput() {
        Main.main(new String[]{});
        
        String output = outContent.toString();
        
        assertTrue(output.contains("Morgan Falk"), "Main output should contain customer name.");
        assertTrue(output.contains("The brakes do not work"), "Main output should contain initial report.");
        assertTrue(output.contains("Add brake wires"), "Main output should contain repair task.");
        assertTrue(output.contains("REPAIR ORDER UPDATE"), "Observer update header is missing.");
    }
}