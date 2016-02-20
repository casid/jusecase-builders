package org.jusecase.builders.builders.collections;

import org.jusecase.builders.Builder;
import org.jusecase.builders.Immutable;
import org.jusecase.builders.Newable;

import java.util.Collection;

import static java.util.Objects.requireNonNull;

@Immutable
public class CopyCollectionBuilder<T, TCollectionType extends Collection<T>> implements Builder<TCollectionType> {

    protected final TCollectionType collection;
    protected final Newable<TCollectionType> newable;

    public CopyCollectionBuilder(final Newable<TCollectionType> newable) {
        this(newable, newable.newInstance(), newable.newInstance());
    }

    protected CopyCollectionBuilder(final Newable<TCollectionType> newable, final TCollectionType oldCollection, final TCollectionType newCollection) {
        requireNonNull(newable, "newable may not be null");
        this.newable = newable;
        this.collection = this.newable.newInstance();
        this.collection.addAll(oldCollection);
        this.collection.addAll(newCollection);
    }

    public CopyCollectionBuilder with(final TCollectionType collection){
        requireNonNull(collection, "collection may not be null");
        return new CopyCollectionBuilder(this.newable, this.collection, collection);
    }

    @Override
    public TCollectionType build() {
        TCollectionType result = this.newable.newInstance();
        result.addAll(this.collection);
        return result;
    }
}
