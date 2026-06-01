package se.kth.iv1350.bikeRepairShop.adaption;

/**
 * Starts the adaptation demonstration.
 *
 * Creates and tests the inheritance and composition adapters and
 * prints the results to the console.
 */
public class AdaptionMain {

    /**
     * Creates and tests the inheritance and composition adapters.
     * Prints example output showing the difference between the two approaches.
     *
     * @param args not used.
     */
    public static void main(String[] args) {
        System.out.println("--- Testing Inheritance Adapter ---");
        RandomInheritanceAdapter inheritanceAdapter = new RandomInheritanceAdapter();
        System.out.println("Random even number (0-20): " + inheritanceAdapter.nextEvenInt(20));
        System.out.println("Original method nextBoolean(): " + inheritanceAdapter.nextBoolean());

        System.out.println("\n--- Testing Composition Adapter ---");
        RandomCompositionAdapter compositionAdapter = new RandomCompositionAdapter();
        System.out.println("Random even number (0-20): " + compositionAdapter.nextEvenInt(20));
        System.out.println("Cannot access original Random methods directly.");
    }
}