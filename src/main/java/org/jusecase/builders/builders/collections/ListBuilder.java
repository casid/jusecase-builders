package org.jusecase.builders.builders.collections;

import java.util.List;

public class ListBuilder<T> extends SimpleCollectionBuilder<T, List<T>> {
    public ListBuilder(List<T> collection, T... items) {
        super(collection, items);
    }
}
