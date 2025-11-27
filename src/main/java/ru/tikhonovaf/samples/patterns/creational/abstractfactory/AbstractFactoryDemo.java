package ru.tikhonovaf.samples.patterns.creational.abstractfactory;

// Продукты
interface Button {
    void paint();
}

interface Checkbox {
    void paint();
}

// Конкретные продукты для Windows
class WinButton implements Button {
    public void paint() {
        System.out.println("Painting Windows Button");
    }
}

class WinCheckbox implements Checkbox {
    public void paint() {
        System.out.println("Painting Windows Checkbox");
    }
}

// Конкретные продукты для Mac
class MacButton implements Button {
    public void paint() {
        System.out.println("Painting Mac Button");
    }
}

class MacCheckbox implements Checkbox {
    public void paint() {
        System.out.println("Painting Mac Checkbox");
    }
}

// Абстрактная фабрика
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Конкретные фабрики
class WinFactory implements GUIFactory {
    public Button createButton() { return new WinButton(); }
    public Checkbox createCheckbox() { return new WinCheckbox(); }
}

class MacFactory implements GUIFactory {
    public Button createButton() { return new MacButton(); }
    public Checkbox createCheckbox() { return new MacCheckbox(); }
}

// Клиентский код
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        GUIFactory factory;

        // Симулируем выбор платформы
        String os = "Windows"; // можно менять на "Mac"

        if (os.equals("Windows")) {
            factory = new WinFactory();
        } else {
            factory = new MacFactory();
        }

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.paint();
        checkbox.paint();
    }
}
