package se.kth.iv1350.bikeRepairShop.view;

import se.kth.iv1350.bikeRepairShop.model.dto.RepairOrderDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepairOrderViewTest {
    private RepairOrderView repairOrderView;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        repairOrderView = new RepairOrderView();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testNewRepairOrderUpdatePrintsCorrectly() {
        RepairOrderDTO dto = new RepairOrderDTO("Flat tire", "2026-05-24", 
                                                250.0, "READY_FOR_APPROVAL", "1h", "Change tube");
        
        repairOrderView.newRepairOrderUpdate(dto);
        
        String output = outContent.toString();
        
        assertTrue(output.contains("REPAIR ORDER UPDATE"), "Missing header.");
        assertTrue(output.contains("Flat tire"), "Missing description.");
        assertTrue(output.contains("2026-05-24"), "Missing date.");
        assertTrue(output.contains("Change tube"), "Missing repair tasks.");
        assertTrue(output.contains("250.0"), "Missing total cost.");
        assertTrue(output.contains("READY_FOR_APPROVAL"), "Missing state.");
        assertTrue(output.contains("Estimated Completion: 1h"), "Missing estimated completion.");
    }
}