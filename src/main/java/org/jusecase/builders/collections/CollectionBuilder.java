package org.jusecase.builders.collections;

import org.jusecase.builders.Builder;

import java.util.Collection;
import java.util.Collections;

public class CollectionBuilder<T, CollectionType extends Collection<T>> implements Builder<CollectionType> {
    private final CollectionType collection;

    public CollectionBuilder(CollectionType collection, T ... items) {
        this.collection = collection;
        Collections.addAll(this.collection, items);
    }

    @Override
    public CollectionType build() {
        return collection;
    }
}
