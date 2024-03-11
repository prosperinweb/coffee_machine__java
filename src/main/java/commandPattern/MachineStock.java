package commandPattern;

public enum MachineStock {
    WATER("water", 400),
    MILK("milk", 540),
    COFFEE_BEANS("coffee beans", 120),
    CUPS("disposable cups", 9),
    MONEY("money", 550);

    private final String name;
    private int amount;

    MachineStock(String name, int initialAmount) {
        this.name = name;
        this.amount = initialAmount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int newAmount) {
        this.amount = newAmount;
    }

    public void addAmount(int inputAmount) {
        this.amount += inputAmount;
    }

    public void deductAmount(int inputAmount) {
        this.amount -= inputAmount;
    }
}
