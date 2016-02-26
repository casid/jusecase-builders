package org.jusecase.builders.structures;

import org.jusecase.builders.Builder;

public class ArrayBuilder<T> implements Builder<T[]> {
    private final T[] array;

    public ArrayBuilder(final T[] array) {
        this.array = array;
    }

    public ArrayBuilder<T> copy(){
        return new ArrayBuilder<T>(array.clone());
    }

    public T[] build() {
        return this.array;
    }
}
