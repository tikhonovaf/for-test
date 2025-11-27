package ru.tikhonovaf.samples.patterns.structural.proxy;

interface Service {
    void doWork();
}

class RealService implements Service {
    public void doWork() {
        System.out.println("Doing work in RealService");
    }
}

class ServiceProxy implements Service {
    private final Service real;

    public ServiceProxy(Service real) {
        this.real = real;
    }

    public void doWork() {
        System.out.println("Before work");
        real.doWork();
        System.out.println("After work");
    }
}

public class ProxyDemo {
    public static void main(String[] args) {
        Service service = new ServiceProxy(new RealService());
        service.doWork();
    }
}

