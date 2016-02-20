package org.jusecase.builders.factories;

import org.jusecase.builders.builders.collections.AggregateCollectionBuilder;
import org.jusecase.builders.builders.collections.CollectionBuilder;
import org.jusecase.builders.builders.collections.CopyCollectionBuilder;
import org.jusecase.builders.newables.NewableLinkedList;

import java.util.List;

public class LinkedListBuilderFactory {
    public static <T> CollectionBuilder<T, List<T>> linkedList(final T... items){
        return new CollectionBuilder<T, List<T>>(new NewableLinkedList()).with(items);
    }

    public static <T> CopyCollectionBuilder<T, List<T>> copy(final List<T> linkedList){
        return new CopyCollectionBuilder<T, List<T>>(new NewableLinkedList()).with(linkedList);
    }

    public static <T> AggregateCollectionBuilder<T, List<T>> aggregate(final List<T>... linkedLists){
        return new AggregateCollectionBuilder<T, List<T>>(new NewableLinkedList()).with(linkedLists);
    }
}
