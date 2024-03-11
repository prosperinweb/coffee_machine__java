package hybridSolution.selection;

import hybridSolution.CoffeeType;

/**
 * The Selection interface defines the methods for handling the user's selection of coffee type.
 */
public interface Selection {
    /**
     * Converts the user's input to the corresponding CoffeeType.
     *
     * @param input The user's input
     * @return The corresponding CoffeeType, or null if the input is invalid
     * @throws IllegalArgumentException If the input is invalid
     */
    CoffeeType fromInput(String input) throws IllegalArgumentException;

    /**
     * Returns the prompt for the user to select a coffee type.
     *
     * @return The selection prompt
     */
    String getSelectionPrompt();
}
