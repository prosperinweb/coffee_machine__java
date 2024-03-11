package hybridSolution.inventory;

import hybridSolution.CoffeeType;

/**
 * The Inventory interface defines the methods for managing the resources of the coffee machine.
 */
public interface Inventory {
    /**
     * Displays the current resources available in the coffee machine.
     */
    void displayResources();

    /**
     * Checks if the coffee machine has enough resources to make the specified coffee type.
     *
     * @param coffeeType The coffee type to check
     * @return true if there are enough resources, false otherwise
     */
    boolean hasEnoughResources(CoffeeType coffeeType);

    /**
     * Deducts the required resources from the coffee machine's inventory for the specified coffee type.
     *
     * @param coffeeType The coffee type for which resources need to be deducted
     */
    void deductResources(CoffeeType coffeeType);

    /**
     * Fills the coffee machine's inventory with the specified amounts of resources.
     */
    void fill();

    /**
     * Takes the money from the coffee machine's inventory.
     */
    void takeMoney();
}
