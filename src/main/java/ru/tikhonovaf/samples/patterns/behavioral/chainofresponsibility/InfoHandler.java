package ru.tikhonovaf.samples.patterns.behavioral.chainofresponsibility;

interface Handler {
    void setNext(Handler next);
    void handle(String request);
}

// Базовый обработчик
abstract class AbstractHandler implements Handler {
    protected Handler next;

    @Override
    public void setNext(Handler next) {
        this.next = next;
    }

    protected void next(String request) {
        if (next != null) {
            next.handle(request);
        }
    }
}

// 1. Проверка авторизации
class AuthHandler extends AbstractHandler {
    @Override
    public void handle(String request) {
        if (!request.contains("token")) {
            System.out.println("AuthHandler: access denied.");
            return;
        }
        System.out.println("AuthHandler: OK");
        next(request);
    }
}

// 2. Проверка формата запроса
class ValidationHandler extends AbstractHandler {
    @Override
    public void handle(String request) {
        if (!request.contains("data=")) {
            System.out.println("ValidationHandler: invalid request.");
            return;
        }
        System.out.println("ValidationHandler: OK");
        next(request);
    }
}

// 3. Бизнес-логика
class BusinessLogicHandler extends AbstractHandler {
    @Override
    public void handle(String request) {
        System.out.println("BusinessLogicHandler: handling request: " + request);
        next(request);
    }
}

// MAIN
class Main {
    public static void main(String[] args) {

        // Строим цепочку
        Handler auth = new AuthHandler();
        Handler validation = new ValidationHandler();
        Handler logic = new BusinessLogicHandler();

        auth.setNext(validation);
        validation.setNext(logic);

        System.out.println("---- VALID REQUEST ----");
        auth.handle("token;data=123");

        System.out.println("\n---- INVALID REQUEST ----");
        auth.handle("data=123"); // не хватает token
    }
}
