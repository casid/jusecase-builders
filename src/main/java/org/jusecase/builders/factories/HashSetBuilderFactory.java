package org.jusecase.builders.factories;

import org.jusecase.builders.builders.collections.*;
import org.jusecase.builders.newables.NewableArrayList;
import org.jusecase.builders.newables.NewableHashSet;

import java.util.List;
import java.util.Set;

public class HashSetBuilderFactory {
    public static <T> CollectionBuilder<T, Set<T>> set(final T... items){
        return new CollectionBuilder<T, Set<T>>(new NewableHashSet()).with(items);
    }

    public static <T> CopyCollectionBuilder<T, Set<T>> copy(final Set<T> set){
        return new CopyCollectionBuilder<T, Set<T>>(new NewableHashSet()).with(set);
    }

    public static <T> AggregateCollectionBuilder<T, Set<T>> aggregate(final Set<T>... sets){
        return new AggregateCollectionBuilder<T, Set<T>>(new NewableHashSet()).with(sets);
    }

    public static <T> UnmodifiableCollectionBuilder<T, Set<T>> unmodifiable(final Set<T> set){
        return new UnmodifiableCollectionBuilder<T, Set<T>>(new NewableHashSet()).with(set);
    }

    public static <T> ImmutableCollectionBuilder<T, Set<T>> immutable(final Set<T> set){
        return new ImmutableCollectionBuilder<T, Set<T>>(new NewableHashSet<T>()).with(set);
    }
}
