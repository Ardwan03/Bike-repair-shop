package se.kth.iv1350.bikeRepairShop.integration;

import se.kth.iv1350.bikeRepairShop.model.dto.RepairOrderDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrinterTest {
    private Printer printer;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        printer = new Printer();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testPrintOrderContainsCorrectInformation() {
        RepairOrderDTO dto = new RepairOrderDTO("Brakes issue", "2026-05-24", 
                                                500.0, "ACCEPTED", "3h", "Add wires");
        printer.printOrder(dto);
        
        String output = outContent.toString();
        
        assertTrue(output.contains("Brakes issue"), "Printout does not contain description.");
        assertTrue(output.contains("2026-05-24"), "Printout does not contain date.");
        assertTrue(output.contains("Add wires"), "Printout does not contain repair tasks.");
        assertTrue(output.contains("500.0"), "Printout does not contain total cost.");
        assertTrue(output.contains("ACCEPTED"), "Printout does not contain state.");
        assertTrue(output.contains("3h"), "Printout does not contain estimated completion.");
    }
}