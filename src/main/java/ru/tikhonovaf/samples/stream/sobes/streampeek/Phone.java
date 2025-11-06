package ru.tikhonovaf.samples.stream.sobes.streampeek;

public class Phone {
    private int code;
    private String number;

    public Phone(int code, String number) {
        this.code = code;
        this.number = number;
    }

    @Override
    public String toString() {
        return number;
    }
}
