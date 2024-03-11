package hybridSolution;

import hybridSolution.inventory.Inventory;
import hybridSolution.inventory.InventoryImpl;
import hybridSolution.selection.Selection;
import hybridSolution.selection.SelectionImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * The CoffeeMachine class represents the main entry point of the coffee machine application.
 */
public class CoffeeMachine {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Inventory inventory = new InventoryImpl();
    private static final Selection selection = new SelectionImpl();
    private static final Map<UserAction, Runnable> actionHandlers = new HashMap<>();

    /**
     * The main entry point of the application.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        setupActionHandlers();
        runApplication();
    }

    /**
     * Sets up the action handlers for the coffee machine.
     */
    private static void setupActionHandlers() {
        actionHandlers.put(UserAction.BUY, CoffeeMachine::handleBuyAction);
        actionHandlers.put(UserAction.FILL, inventory::fill);
        actionHandlers.put(UserAction.TAKE, inventory::takeMoney);
        actionHandlers.put(UserAction.REMAINING, inventory::displayResources);
        actionHandlers.put(UserAction.EXIT, CoffeeMachine::handleExitAction);
    }

    /**
     * Runs the coffee machine application.
     */
    private static void runApplication() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println(UserAction.getUserPrompt());
            UserAction action = UserAction.fromString(scanner.nextLine().trim().toUpperCase());

            if (action == null) {
                System.out.println("Invalid action");
                continue;
            }

            Runnable actionHandler = actionHandlers.get(action);
            if (actionHandler != null) {
                actionHandler.run();
            } else {
                System.out.println("Invalid action");
            }

            isRunning = action != UserAction.EXIT;
        }
    }

    /**
     * Handles the "buy" action for the coffee machine.
     */
    private static void handleBuyAction() {
        try {
            System.out.println(selection.getSelectionPrompt());
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("back")) {
                return;
            }
            CoffeeType coffeeType = selection.fromInput(input);

            if (coffeeType == null) {
                System.out.println("Invalid selection");
                return;
            }

            if (inventory.hasEnoughResources(coffeeType)) {
                inventory.deductResources(coffeeType);
                System.out.println("I have enough resources, making you a coffee!");
            } else {
                // TODO: Specify which resource/s is missing
                System.out.println("Sorry, not enough resources!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid selection");
        }
    }

    /**
     * Handles the "exit" action for the coffee machine.
     */
    private static void handleExitAction() {
        // No additional action needed
    }
}
