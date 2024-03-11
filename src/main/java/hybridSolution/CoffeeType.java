package hybridSolution;

/**
 * The CoffeeType enum represents the different types of coffee that the coffee machine can make.
 */
public enum CoffeeType {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);

    private final int waterRequired;
    private final int milkRequired;
    private final int coffeeBeansRequired;
    private final int cost;

    CoffeeType(int waterRequired, int milkRequired, int coffeeBeansRequired, int cost) {
        this.waterRequired = waterRequired;
        this.milkRequired = milkRequired;
        this.coffeeBeansRequired = coffeeBeansRequired;
        this.cost = cost;
    }

    /**
     * Returns the amount of water required for this coffee type.
     *
     * @return The amount of water required
     */
    public int getWaterRequired() {
        return waterRequired;
    }

    /**
     * Returns the amount of milk required for this coffee type.
     *
     * @return The amount of milk required
     */
    public int getMilkRequired() {
        return milkRequired;
    }

    /**
     * Returns the amount of coffee beans required for this coffee type.
     *
     * @return The amount of coffee beans required
     */
    public int getCoffeeBeansRequired() {
        return coffeeBeansRequired;
    }

    /**
     * Returns the cost of this coffee type.
     *
     * @return The cost of the coffee type
     */
    public int getCost() {
        return cost;
    }
}
