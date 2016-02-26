package org.jusecase.builders.collections;

import java.util.List;

public class ListBuilder<T> extends CollectionBuilder<T, List<T>> {
    public ListBuilder(List<T> collection, T... items) {
        super(collection, items);
    }
}
