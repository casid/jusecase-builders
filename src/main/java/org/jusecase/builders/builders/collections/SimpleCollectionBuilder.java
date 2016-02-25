package org.jusecase.builders.builders.collections;

import org.jusecase.builders.Builder;
import org.jusecase.builders.Immutable;

import java.util.Collection;
import java.util.Collections;

@Immutable
public class SimpleCollectionBuilder<T, CollectionType extends Collection<T>> implements Builder<CollectionType> {
    private final CollectionType collection;

    public SimpleCollectionBuilder(CollectionType collection, T ... items) {
        this.collection = collection;
        Collections.addAll(this.collection, items);
    }

    @Override
    public CollectionType build() {
        return collection;
    }
}
