package se.kth.iv1350.bikeRepairShop.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.bikeRepairShop.controller.Controller;
import se.kth.iv1350.bikeRepairShop.integration.CustomerRegistry;
import se.kth.iv1350.bikeRepairShop.integration.Printer;
import se.kth.iv1350.bikeRepairShop.integration.RepairOrderRegistry;
import se.kth.iv1350.bikeRepairShop.logging.FileLogger;
import se.kth.iv1350.bikeRepairShop.model.dto.CustomerDetailsDTO;
import se.kth.iv1350.bikeRepairShop.model.dto.RepairOrderDTO;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ViewTest {
    private View view;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        CustomerRegistry customerRegistry = CustomerRegistry.getInstance();
        RepairOrderRegistry repairOrderRegistry = new RepairOrderRegistry();
        Printer printer = new Printer();
        Controller controller = new Controller(repairOrderRegistry, customerRegistry, printer);
        
        view = new View(controller, new FileLogger());
        
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testShowCustomerDetailsPrintsCorrectly() {
        CustomerDetailsDTO dto = new CustomerDetailsDTO(
            "Test Name", "12345", "test@test.com", "BrandX", "ModelY", "S123");
        
        view.showCustomerDetails(dto);
        
        String output = outContent.toString();
        
        assertTrue(output.contains("Test Name"), "Output does not contain correct name.");
        assertTrue(output.contains("12345"), "Output does not contain correct phone number.");
        assertTrue(output.contains("test@test.com"), "Output does not contain correct email.");
        assertTrue(output.contains("BrandX"), "Output does not contain correct bike brand.");
        assertTrue(output.contains("ModelY"), "Output does not contain correct bike model.");
        assertTrue(output.contains("S123"), "Output does not contain correct serial number.");
    }

    @Test
    public void testShowRepairOrderPrintsCorrectly() {
        RepairOrderDTO dto = new RepairOrderDTO("Broken chain", "2026-05-24", 100.0, "NEWLY_CREATED", "1h", "Fix chain");
        
        view.showRepairOrder(dto);
        
        String output = outContent.toString();
        
        assertTrue(output.contains("Broken chain"), "Output does not contain description.");
        assertTrue(output.contains("NEWLY_CREATED"), "Output does not contain state.");
        assertTrue(output.contains("100.0"), "Output does not contain total cost.");
    }
}