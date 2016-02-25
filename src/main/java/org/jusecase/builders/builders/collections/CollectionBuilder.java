package org.jusecase.builders.builders.collections;

import org.jusecase.builders.Builder;
import org.jusecase.builders.Immutable;
import org.jusecase.builders.Newable;

import java.util.Collection;
import java.util.Collections;

import static org.jusecase.builders.helpers.Preconditions.requireNonNull;

@Immutable
public class CollectionBuilder<T, TCollectionType extends Collection<T>> implements Builder<TCollectionType> {

    protected final TCollectionType collection;
    protected final Newable<TCollectionType> newable;

    public CollectionBuilder(final Newable<TCollectionType> newable) {
        this(newable, newable.newInstance(), newable.newInstance());
    }

    protected CollectionBuilder(final Newable<TCollectionType> newable, final TCollectionType oldCollection, final TCollectionType newCollection) {
        requireNonNull(newable, "newable may not be null");
        this.newable = newable;
        this.collection = (TCollectionType) new AggregateCollectionBuilder<T, TCollectionType>(this.newable).with(oldCollection, newCollection).build();
    }

    public CollectionBuilder with(final T ... args){
        requireNonNull(args, "args may not be null");
        final TCollectionType argsCollection = this.newable.newInstance();
        Collections.addAll(argsCollection, args);
        return new CollectionBuilder(this.newable, this.collection, argsCollection);
    }

    @Override
    public TCollectionType build() {
        return (TCollectionType) new CopyCollectionBuilder<T, TCollectionType>(this.newable).with(this.collection).build();
    }
}