package org.jusecase.builders;

public class Builders {
    public static <T> T a(final Builder<T> builder) {
        return builder.build();
    }

    public static <T> T an(final Builder<T> builder) {
        return builder.build();
    }

    public static <T> T of(final T entity) {
        return entity;
    }

    public static <T> T[] of(final T... entities) {
        return entities;
    }
}
