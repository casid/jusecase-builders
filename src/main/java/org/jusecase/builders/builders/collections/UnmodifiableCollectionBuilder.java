package org.jusecase.builders.builders.collections;

import org.jusecase.builders.Builder;
import org.jusecase.builders.Immutable;
import org.jusecase.builders.Newable;

import java.util.Collection;
import java.util.Collections;

import static org.jusecase.builders.helpers.Preconditions.requireNonNull;

@Immutable
public class UnmodifiableCollectionBuilder<T, TCollectionType extends Collection<T>> implements Builder<Collection<T>> {

    protected final TCollectionType collection;
    protected final Newable<TCollectionType> newable;

    public UnmodifiableCollectionBuilder(final Newable<TCollectionType> newable) {
        requireNonNull(newable, "newable may not be null");
        this.newable = newable;
        this.collection = newable.newInstance();
    }

    protected UnmodifiableCollectionBuilder(final TCollectionType collection) {
        requireNonNull(collection, "collection may not be null");
        this.newable = null;
        this.collection = collection;
    }

    public UnmodifiableCollectionBuilder<T, TCollectionType> with(final TCollectionType collection){
        requireNonNull(collection, "collection may not be null");
        return new UnmodifiableCollectionBuilder<T, TCollectionType>(collection);
    }

    @Override
    public Collection build() {
        return Collections.unmodifiableCollection(this.collection);
    }
}