package org.jusecase.builders;

import org.jusecase.builders.builders.collections.*;

import java.util.Collection;

public class BuilderFactory {

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
}