package se.kth.iv1350.bikeRepairShop.logging;

import se.kth.iv1350.bikeRepairShop.model.dto.RepairOrderDTO;
import se.kth.iv1350.bikeRepairShop.model.observer.RepairOrderObserverTemplate;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Writes repair order updates to a file using the Template Method pattern.
 */
public class RepairOrderLogger extends RepairOrderObserverTemplate {
    private PrintWriter logWriter;

    /**
     * Creates a new repair order logger.
     */
    public RepairOrderLogger() {
        try {
            logWriter = new PrintWriter(new FileWriter("repair-order-log.txt", true), true);
        } catch (IOException ioe) {
            System.out.println("Could not create repair order log file.");
            ioe.printStackTrace();
        }
    }

    @Override
    protected void doHandleRepairOrderUpdate() throws Exception {
        if (logWriter == null) {
            throw new IOException("Log writer is not initialized.");
        }
        
        RepairOrderDTO repairOrderDTO = getRepairOrderDTO();
        
        logWriter.println();
        logWriter.println("REPAIR ORDER UPDATE");
        logWriter.println("Description: " + repairOrderDTO.getDescription());
        logWriter.println("Date: " + repairOrderDTO.getDate());
        logWriter.println("Repair Tasks: " + repairOrderDTO.getRepairTasksDescription());
        logWriter.println("Total Cost: " + repairOrderDTO.getTotalCost());
        logWriter.println("State: " + repairOrderDTO.getState());
        logWriter.println("Estimated Completion: " + repairOrderDTO.getEstimatedCompletion());
        logWriter.println();
    }

    @Override
    protected void handleErrors(Exception e) {
        System.out.println("Logging Error: Failed to write repair order update to log. " + e.getMessage());
    }
}