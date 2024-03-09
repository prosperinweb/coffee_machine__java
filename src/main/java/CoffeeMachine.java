import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MachineInventory machineInventory = new MachineInventory();

        while (machineInventory.isRunning()) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();

            machineInventory.executeAction(action);
        }

    }
}

