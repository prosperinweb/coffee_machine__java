package machine;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import machine.command.*;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MachineInventory machineInventory = new MachineInventory();

        Map<String, Command> commands = new HashMap<>();
        commands.put("buy", new BuyCommand(machineInventory));
        commands.put("fill", new FillCommand(machineInventory));
        commands.put("take", new TakeCommand(machineInventory));
        commands.put("remaining", new RemainingCommand(machineInventory));
        commands.put("exit", new ExitCommand(machineInventory));

        while (machineInventory.isRunning()) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();

            Command command = commands.get(action);
            if (command != null) {
                command.execute();
            }
        }
    }
}
