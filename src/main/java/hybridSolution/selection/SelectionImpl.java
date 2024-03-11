package hybridSolution.selection;

import hybridSolution.CoffeeType;

/**
 * The SelectionImpl class implements the Selection interface and handles the user's selection of coffee type.
 */
public class SelectionImpl implements Selection {
    @Override
    public CoffeeType fromInput(String input) throws IllegalArgumentException {
        try {
            int selectionIndex = Integer.parseInt(input);
            return switch (selectionIndex) {
                case 1 -> CoffeeType.ESPRESSO;
                case 2 -> CoffeeType.LATTE;
                case 3 -> CoffeeType.CAPPUCCINO;
                default -> throw new IllegalArgumentException("Invalid selection");
            };
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid selection");
        }
    }

    @Override
    public String getSelectionPrompt() {
        StringBuilder prompt = new StringBuilder("What do you want to buy? ");
        for (int i = 0; i < CoffeeType.values().length; i++) {
            CoffeeType coffeeType = CoffeeType.values()[i];
            prompt.append(i + 1).append(" - ").append(coffeeType.name().toLowerCase()).append(", ");
        }
        prompt.append("back - to main menu:");
        return prompt.toString();
    }
}
