package org.jusecase.builders.builders.collections;

import java.util.Set;

public class SetBuilder<T> extends SimpleCollectionBuilder<T, Set<T>> {
    public SetBuilder(Set<T> collection, T... items) {
        super(collection, items);
    }
}
