package org.jusecase.builders.builders.structures;

import org.jusecase.builders.Builder;
import org.jusecase.builders.Immutable;
import org.jusecase.builders.Newable;
import org.jusecase.builders.builders.collections.AggregateCollectionBuilder;
import org.jusecase.builders.builders.collections.UnmodifiableCollectionBuilder;
import org.jusecase.builders.newables.NewableArrayList;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static java.util.Objects.requireNonNull;

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
