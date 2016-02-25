package org.jusecase.builders.factories;

import org.jusecase.builders.builders.collections.*;
import org.jusecase.builders.newables.NewableArrayList;

import java.util.List;

public class ArrayListBuilderFactory {

    public static <T> CollectionBuilder<T, List<T>> list(final T... items){
        return new CollectionBuilder<T, List<T>>(new NewableArrayList()).with(items);
    }

    public static <T> CopyCollectionBuilder<T, List<T>> copy(final List<T> list){
        return new CopyCollectionBuilder<T, List<T>>(new NewableArrayList()).with(list);
    }

    public static <T> AggregateCollectionBuilder<T, List<T>> aggregate(final List<T>... lists){
        return new AggregateCollectionBuilder<T, List<T>>(new NewableArrayList()).with(lists);
    }

    public static <T> UnmodifiableCollectionBuilder<T, List<T>> unmodifiable(final List<T> list){
        return new UnmodifiableCollectionBuilder<T, List<T>>(new NewableArrayList()).with(list);
    }

    public static <T> ImmutableCollectionBuilder<T, List<T>> immutable(final List<T> list){
        return new ImmutableCollectionBuilder<T, List<T>>(new NewableArrayList()).with(list);
    }
}
