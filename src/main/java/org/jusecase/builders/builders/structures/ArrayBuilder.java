package org.jusecase.builders.builders.structures;

import org.jusecase.builders.Builder;
import org.jusecase.builders.Immutable;

import static org.jusecase.builders.helpers.Preconditions.requireNonNull;

@Immutable
public class ArrayBuilder<T> implements Builder<T[]> {
    private final T[] array;

    public ArrayBuilder(final T[] array) {
        requireNonNull(array, "array may not be null");
        this.array = array.clone();
    }

    public ArrayBuilder<T> with(final T... args){
        requireNonNull(args, "args may not be null");
        return new ArrayBuilder(args);
    }

    public T[] build() {
        return this.array.clone();
    }
}
