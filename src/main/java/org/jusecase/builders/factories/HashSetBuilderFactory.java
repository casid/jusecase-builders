package org.jusecase.builders.factories;

import org.jusecase.builders.builders.collections.AggregateCollectionBuilder;
import org.jusecase.builders.builders.collections.CollectionBuilder;
import org.jusecase.builders.builders.collections.CopyCollectionBuilder;
import org.jusecase.builders.builders.collections.UnmodifiableCollectionBuilder;
import org.jusecase.builders.newables.NewableHashSet;

import java.util.Set;

public class HashSetBuilderFactory {
    public static <T> CollectionBuilder<T, Set<T>> hashSet(final T... items){
        return new CollectionBuilder<T, Set<T>>(new NewableHashSet()).with(items);
    }

    public static <T> CopyCollectionBuilder<T, Set<T>> copy(final Set<T> set){
        return new CopyCollectionBuilder<T, Set<T>>(new NewableHashSet()).with(set);
    }

    public static <T> AggregateCollectionBuilder<T, Set<T>> aggregate(final Set<T>... sets){
        return new AggregateCollectionBuilder<T, Set<T>>(new NewableHashSet()).with(sets);
    }

    public static <T> UnmodifiableCollectionBuilder<T, Set<T>> unmodifiable(final Set<T> list){
        return new UnmodifiableCollectionBuilder<T, Set<T>>(new NewableHashSet()).with(list);
    }
}
