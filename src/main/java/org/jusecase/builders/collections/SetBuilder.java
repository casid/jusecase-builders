package org.jusecase.builders.collections;

import java.util.Set;

public class SetBuilder<T> extends CollectionBuilder<T, Set<T>> {
    public SetBuilder(Set<T> collection, T... items) {
        super(collection, items);
    }
}
