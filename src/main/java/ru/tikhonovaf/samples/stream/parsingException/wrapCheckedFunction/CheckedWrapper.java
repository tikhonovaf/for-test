package ru.tikhonovaf.samples.stream.parsingException.wrapCheckedFunction;

import java.util.function.Function;
import java.util.Optional;

public class CheckedWrapper {
    @FunctionalInterface
    public interface CheckedFunction<T, R> {
        R apply(T t) throws Exception;
    }

    public static <T, R> Function<T, Optional<R>> wrapCheckedFunction(CheckedFunction<T, R> function) {
        return input -> {
            try {
                return Optional.ofNullable(function.apply(input));
            } catch (Exception e) {
                return Optional.empty(); // безопасно игнорируем ошибку
            }
        };
    }
}
