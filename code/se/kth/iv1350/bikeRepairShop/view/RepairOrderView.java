package se.kth.iv1350.bikeRepairShop.view;

import se.kth.iv1350.bikeRepairShop.model.dto.RepairOrderDTO;
import se.kth.iv1350.bikeRepairShop.model.observer.RepairOrderObserverTemplate;

/**
 * Prints repair order updates to System.out.
 */
public class RepairOrderView extends RepairOrderObserverTemplate{

    @Override
    protected void doHandleRepairOrderUpdate() throws Exception {
        RepairOrderDTO repairOrderDTO = getRepairOrderDTO();

        System.out.println();
        System.out.println("REPAIR ORDER UPDATE");
        System.out.println("Description: " + repairOrderDTO.getDescription());
        System.out.println("Date: " + repairOrderDTO.getDate());
        System.out.println("Repair Tasks: " + repairOrderDTO.getRepairTasksDescription());
        System.out.println("Total Cost: " + repairOrderDTO.getTotalCost());
        System.out.println("State: " + repairOrderDTO.getState());
        System.out.println("Estimated Completion: " + repairOrderDTO.getEstimatedCompletion());
        System.out.println();
    }

    @Override
    protected void handleErrors(Exception e) {
        System.out.println("View Error: Could not display repair order update. " + e.getMessage());
    }
}
