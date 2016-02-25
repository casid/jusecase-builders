package org.jusecase.builders;

import org.jusecase.builders.builders.collections.*;
import org.jusecase.builders.builders.collections.CollectionBuilder;
import org.jusecase.builders.builders.misc.DateBuilder;
import org.jusecase.builders.builders.streams.ResourceInputStreamBuilder;
import org.jusecase.builders.builders.streams.StringInputStreamBuilder;
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

    public static <T, TCollectionType extends Collection<T>> CollectionBuilder<T, TCollectionType> createCollectionBuilder(final Newable<TCollectionType> newable){
        return new CollectionBuilder<T, TCollectionType>(newable);
    }

    public static <T, TCollectionType extends Collection<T>> CopyCollectionBuilder<T, TCollectionType> createCopyCollectionBuilder(final Newable<TCollectionType> newable){
        return new CopyCollectionBuilder<T, TCollectionType>(newable);
    }

    public static <T, TCollectionType extends Collection<T>> AggregateCollectionBuilder<T, TCollectionType> createAggregateCollectionBuilder(final Newable<TCollectionType> newable){
        return new AggregateCollectionBuilder<T, TCollectionType>(newable);
    }

    public static <T, TCollectionType extends Collection<T>> UnmodifiableCollectionBuilder<T, TCollectionType> createUnmodifiableCollectionBuilder(final Newable<TCollectionType> newable){
        return new UnmodifiableCollectionBuilder<T, TCollectionType>(newable);
    }

    public static <T, TCollectionType extends Collection<T>> ImmutableCollectionBuilder<T, TCollectionType> createImmutableCollectionBuilder(final Newable<TCollectionType> newable){
        return new ImmutableCollectionBuilder<T, TCollectionType>(newable);
    }

    public static ResourceInputStreamBuilder createResourceInputStreamBuilder() {
        return new ResourceInputStreamBuilder();
    }

    public static StringInputStreamBuilder createStringInputStreamBuilder() {
        return new StringInputStreamBuilder();
    }

    public static DateBuilder createDateBuilder() {
        return new DateBuilder();
    }
}