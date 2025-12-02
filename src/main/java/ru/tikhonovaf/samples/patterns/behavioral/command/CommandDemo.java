package ru.tikhonovaf.samples.patterns.behavioral.command;

// --------- Command интерфейс ----------
interface Command {
    void execute();
}

// --------- Receiver ----------
class Light {
    public void turnOn() {
        System.out.println("Light is ON");
    }
    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

// --------- Concrete Commands ----------
class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {
    private final Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// --------- Invoker ----------
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command != null) {
            command.execute();
        }
    }
}

// --------- Main ----------
public class CommandDemo {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();

        Command lightsOn = new LightOnCommand(livingRoomLight);
        Command lightsOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        System.out.println("Turning ON the light:");
        remote.setCommand(lightsOn);
        remote.pressButton();

        System.out.println("\nTurning OFF the light:");
        remote.setCommand(lightsOff);
        remote.pressButton();
    }
}
