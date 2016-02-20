package org.jusecase.builders;

import org.jusecase.builders.builders.collections.*;
import org.jusecase.builders.builders.collections.CollectionBuilder;
import org.jusecase.builders.builders.misc.DateBuilder;
import org.jusecase.builders.builders.streams.InputStreamBuilder;
import org.jusecase.builders.newables.NewableArrayList;

import java.util.Collection;

public class BuilderFactory {

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

    public static <T, TCollectionType extends Collection<T>> org.jusecase.builders.builders.collections.CollectionBuilder<T, TCollectionType> createCollectionBuilder(){
        return new CollectionBuilder<T, TCollectionType>(new NewableArrayList());
    }

    public static <T, TCollectionType extends Collection<T>> CopyCollectionBuilder<T, TCollectionType> createCopyCollectionBuilder(){
        return new CopyCollectionBuilder<T, TCollectionType>(new NewableArrayList());
    }

    public static <T, TCollectionType extends Collection<T>> AggregateCollectionBuilder<T, TCollectionType> createAggregateCollectionBuilder(){
        return new AggregateCollectionBuilder<T, TCollectionType>(new NewableArrayList());
    }

    public static <T, TCollectionType extends Collection<T>> UnmodifiableCollectionBuilder<T, TCollectionType> createUnmodifiableCollectionBuilder(){
        return new UnmodifiableCollectionBuilder<T, TCollectionType>(new NewableArrayList());
    }

    public static <T, TCollectionType extends Collection<T>> ImmutableCollectionBuilder<T, TCollectionType> createImmutableCollectionBuilder(){
        return new ImmutableCollectionBuilder<T, TCollectionType>(new NewableArrayList());
    }

    public static InputStreamBuilder createInputStreamBuilder() {
        return new InputStreamBuilder();
    }

    public static DateBuilder createDateBuilder() {
        return new DateBuilder();
    }
}