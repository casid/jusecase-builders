package org.jusecase.builders.builders.collections;

import org.jusecase.builders.Builder;
import org.jusecase.builders.Immutable;
import org.jusecase.builders.Newable;

import java.util.Collection;
import java.util.Collections;

import static org.jusecase.builders.helpers.Preconditions.requireNonNull;

@Immutable
public class ImmutableCollectionBuilder<T, TCollectionType extends Collection<T>> implements Builder<Collection<T>> {

    protected final Collection<T> collection;
    protected final Newable<TCollectionType> newable;

    public ImmutableCollectionBuilder(final Newable<TCollectionType> newable) {
        this(newable, newable.newInstance(), newable.newInstance());
    }

    protected ImmutableCollectionBuilder(final Newable<TCollectionType> newable, final Collection<T> oldCollection, final TCollectionType newCollection) {
        requireNonNull(newable, "newable may not be null");
        requireNonNull(newCollection, "collection may not be null");
        this.newable = newable;
        final TCollectionType aggregate = this.newable.newInstance();
        aggregate.addAll(oldCollection);
        aggregate.addAll(newCollection);
        this.collection = new UnmodifiableCollectionBuilder<T, TCollectionType>(this.newable).with(aggregate).build();
    }
    public ImmutableCollectionBuilder<T, TCollectionType> with(final TCollectionType collection){
        requireNonNull(collection, "collection may not be null");
        return new ImmutableCollectionBuilder<T, TCollectionType>(this.newable, this.collection, collection);
    }

    @Override
    public Collection build(){
        return this.collection;
    }
}
