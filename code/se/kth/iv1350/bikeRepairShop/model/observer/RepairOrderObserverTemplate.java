package se.kth.iv1350.bikeRepairShop.model.observer;

import se.kth.iv1350.bikeRepairShop.model.dto.RepairOrderDTO;

/**
 * A template class that provides a try-catch block 
 * for handling repair order updates.
 */
public abstract class RepairOrderObserverTemplate implements RepairOrderObserver {
    private RepairOrderDTO repairOrderDTO;

    /**
     * The method that is defined in the observer interface.
     * @param repairOrderDTO the updated repair order information.
     */
    @Override
    public void newRepairOrderUpdate(RepairOrderDTO repairOrderDTO) {
        this.repairOrderDTO = repairOrderDTO;
        handleRepairOrderUpdate();
    }

    private void handleRepairOrderUpdate() {
        try {
            doHandleRepairOrderUpdate();
        } catch (Exception e) {
            handleErrors(e);
        }
    }

    /**
     * Retrieves the current repair order DTO to be used by subclasses.
     * @return the current RepairOrderDTO.
     */
    protected RepairOrderDTO getRepairOrderDTO() {
        return repairOrderDTO;
    }

    protected abstract void doHandleRepairOrderUpdate() throws Exception;
    
    protected abstract void handleErrors(Exception e);
}