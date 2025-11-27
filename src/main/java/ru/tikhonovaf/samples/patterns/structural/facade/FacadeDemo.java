package ru.tikhonovaf.samples.patterns.structural.facade;

class CPU {
    void freeze() { System.out.println("CPU freeze"); }
    void jump(long address) { System.out.println("CPU jump " + address); }
    void execute() { System.out.println("CPU execute"); }
}

class Memory {
    void load(long pos, byte[] data) {
        System.out.println("Memory load at " + pos);
    }
}

class HardDrive {
    byte[] read(long lba, int size) {
        System.out.println("HD read");
        return new byte[]{1,2,3};
    }
}

class ComputerFacade {
    private final CPU cpu = new CPU();
    private final Memory memory = new Memory();
    private final HardDrive hdd = new HardDrive();

    public void start() {
        cpu.freeze();
        memory.load(0, hdd.read(0, 1024));
        cpu.jump(0);
        cpu.execute();
    }
}

public class FacadeDemo {
    public static void main(String[] args) {
        new ComputerFacade().start();
    }
}
