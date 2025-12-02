package ru.tikhonovaf.samples.patterns.behavioral.state;

// --------- State ----------
interface State {
    void insertCoin();
    void selectProduct();
    void dispense();
}

// --------- Context ----------
class VendingMachine {
    private State state;

    public VendingMachine(State initialState) {
        this.state = initialState;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void insertCoin() {
        state.insertCoin();
    }

    public void selectProduct() {
        state.selectProduct();
    }

    public void dispense() {
        state.dispense();
    }
}

// --------- Concrete States ----------
class NoCoinState implements State {
    private final VendingMachine machine;

    public NoCoinState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin inserted");
        machine.setState(new HasCoinState(machine));
    }

    @Override
    public void selectProduct() {
        System.out.println("Insert coin first");
    }

    @Override
    public void dispense() {
        System.out.println("Insert coin first");
    }
}

class HasCoinState implements State {
    private final VendingMachine machine;

    public HasCoinState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin already inserted");
    }

    @Override
    public void selectProduct() {
        System.out.println("Product selected");
        machine.setState(new DispenseState(machine));
    }

    @Override
    public void dispense() {
        System.out.println("Select product first");
    }
}

class DispenseState implements State {
    private final VendingMachine machine;

    public DispenseState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Wait! Dispensing...");
    }

    @Override
    public void selectProduct() {
        System.out.println("Wait! Dispensing...");
    }

    @Override
    public void dispense() {
        System.out.println("Dispensing product...");
        machine.setState(new NoCoinState(machine));
    }
}

// --------- Main ----------
public class StateDemo {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine(new NoCoinState(null));
        // исправляем начальное состояние на корректный контекст
        machine.setState(new NoCoinState(machine));

        System.out.println("=== Test Vending Machine ===");
        machine.selectProduct(); // Ошибка
        machine.insertCoin();
        machine.insertCoin();    // Уже вставили
        machine.selectProduct();
        machine.dispense();
        machine.dispense();      // Без монеты
    }
}
