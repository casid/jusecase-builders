package org.jusecase.builders.builders.collections;

import org.jusecase.builders.Builder;
import org.jusecase.builders.Immutable;
import org.jusecase.builders.Newable;

import java.util.Collection;

import static org.jusecase.builders.helpers.Preconditions.requireNonNull;

@Immutable
public class AggregateCollectionBuilder<T, TCollectionType extends Collection<T>> implements Builder<TCollectionType> {

    protected final TCollectionType collection;
    protected final Newable<TCollectionType> newable;

    public AggregateCollectionBuilder(final Newable<TCollectionType> newable) {
        this(newable, newable.newInstance(), newable.newInstance());
    }

    protected AggregateCollectionBuilder(final Newable<TCollectionType> newable, final TCollectionType oldCollection, final TCollectionType... newCollections) {
        requireNonNull(newable, "newable may not be null");
        requireNonNull(oldCollection, "oldCollection may not be null");
        requireNonNull(newCollections, "args may not be null");
        this.newable = newable;
        this.collection = this.newable.newInstance();
        this.collection.addAll(oldCollection);
        for (TCollectionType arg : newCollections) {
            this.collection.addAll(arg);
        }
    }

    public AggregateCollectionBuilder with(final TCollectionType... args) {
        requireNonNull(args, "args may not be null");
        return new AggregateCollectionBuilder(this.newable, this.collection, args);
    }

    @Override
    public TCollectionType build() {
        return (TCollectionType) new CopyCollectionBuilder<T, TCollectionType>(this.newable).with(this.collection).build();
    }
}