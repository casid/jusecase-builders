package org.jusecase.builders.factories;

import org.jusecase.builders.builders.collections.*;
import org.jusecase.builders.newables.NewableArrayList;
import org.jusecase.builders.newables.NewableLinkedList;

import java.util.List;

public class LinkedListBuilderFactory {
    public static <T> CollectionBuilder<T, List<T>> list(final T... items){
        return new CollectionBuilder<T, List<T>>(new NewableLinkedList()).with(items);
    }

    public static <T> CopyCollectionBuilder<T, List<T>> copy(final List<T> linkedList){
        return new CopyCollectionBuilder<T, List<T>>(new NewableLinkedList()).with(linkedList);
    }

    public static <T> AggregateCollectionBuilder<T, List<T>> aggregate(final List<T>... linkedLists){
        return new AggregateCollectionBuilder<T, List<T>>(new NewableLinkedList()).with(linkedLists);
    }

    public static <T> UnmodifiableCollectionBuilder<T, List<T>> unmodifiable(final List<T> list){
        return new UnmodifiableCollectionBuilder<T, List<T>>(new NewableLinkedList()).with(list);
    }

    public static <T> ImmutableCollectionBuilder<T, List<T>> immutable(final List<T> list){
        return new ImmutableCollectionBuilder<T, List<T>>(new NewableLinkedList()).with(list);
    }
}
