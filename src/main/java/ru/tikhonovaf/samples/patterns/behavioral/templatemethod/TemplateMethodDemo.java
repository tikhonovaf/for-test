package ru.tikhonovaf.samples.patterns.behavioral.templatemethod;

// --------- Abstract Class ----------
abstract class DataProcessor {
    // шаблонный метод — последовательность шагов
    public final void process() {
        readData();
        processData();
        saveData();
    }

    // шаги алгоритма
    protected abstract void readData();
    protected abstract void processData();
    protected void saveData() {
        System.out.println("Saving data to database...");
    }
}

// --------- Concrete Classes ----------
class CSVDataProcessor extends DataProcessor {
    @Override
    protected void readData() {
        System.out.println("Reading data from CSV file");
    }

    @Override
    protected void processData() {
        System.out.println("Processing CSV data");
    }
}

class JSONDataProcessor extends DataProcessor {
    @Override
    protected void readData() {
        System.out.println("Reading data from JSON file");
    }

    @Override
    protected void processData() {
        System.out.println("Processing JSON data");
    }
}

// --------- Main ----------
public class TemplateMethodDemo {
    public static void main(String[] args) {
        DataProcessor csvProcessor = new CSVDataProcessor();
        DataProcessor jsonProcessor = new JSONDataProcessor();

        System.out.println("---- CSV Processing ----");
        csvProcessor.process();

        System.out.println("\n---- JSON Processing ----");
        jsonProcessor.process();
    }
}
