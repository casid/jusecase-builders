package org.jusecase.builders;

@Immutable
public interface Builder<T> {
    T build();
}
