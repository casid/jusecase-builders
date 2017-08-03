package org.jusecase;

import org.jusecase.builders.Builder;
import org.jusecase.builders.collections.ListBuilder;
import org.jusecase.builders.collections.MapBuilder;
import org.jusecase.builders.collections.MapEntryBuilder;
import org.jusecase.builders.collections.SetBuilder;
import org.jusecase.builders.io.PathBuilder;
import org.jusecase.builders.streams.InputStreamBuilder;
import org.jusecase.builders.structures.ArrayBuilder;
import org.jusecase.builders.time.DateBuilder;

import java.util.*;

public class Builders {

    public static <T> T a(final Builder<T> builder) {
        return builder.build();
    }

    public static <T> T an(final Builder<T> builder) {
        return builder.build();
    }

    public static <T> T of(final T entity) {
        return entity;
    }

    @SafeVarargs
    public static <T> T[] of(final T... entities) {
        return entities;
    }

    @SafeVarargs
    public static <T> Builder<T[]> array(final T... items) {
        return new ArrayBuilder<T>(items);
    }

    @SafeVarargs
    public static <T> Builder<List<T>> list(final T... items) {
        return arrayList(items);
    }

    @SafeVarargs
    public static <T> Builder<List<T>> arrayList(final T... items) {
        return new ListBuilder<T>(new ArrayList<T>(), items);
    }

    @SafeVarargs
    public static <T> Builder<List<T>> linkedList(final T... items) {
        return new ListBuilder<T>(new LinkedList<T>(), items);
    }

    @SafeVarargs
    public static <T> Builder<Set<T>> set(final T... items) {
        return hashSet(items);
    }

    @SafeVarargs
    public static <T> Builder<Set<T>> hashSet(final T... items) {
        return new SetBuilder<T>(new HashSet<T>(), items);
    }

    @SafeVarargs
    public static <T> Builder<Set<T>> sortedSet(final T... items) {
        return new SetBuilder<T>(new TreeSet<T>(), items);
    }

    public static DateBuilder date() {
        return new DateBuilder();
    }

    public static DateBuilder date(String string) {
        return new DateBuilder().with(string);
    }

    public static InputStreamBuilder inputStream() {
        return new InputStreamBuilder();
    }

    public static PathBuilder path() {
        return new PathBuilder();
    }

    public static <K, V> Builder<Map.Entry<K, V>> entry(final K key, final V value) {
        return new MapEntryBuilder<K, V>(key, value);
    }

    @SafeVarargs
    public static <K, V> Builder<Map<K, V>> map(final Map.Entry<K, V>... entries) {
        return hashMap(entries);
    }

    @SafeVarargs
    public static <K, V> Builder<Map<K, V>> hashMap(final Map.Entry<K, V>... entries) {
        return new MapBuilder<K, V>(new HashMap<K, V>(), entries);
    }

    @SafeVarargs
    public static <K, V> Builder<Map<K, V>> linkedHashMap(final Map.Entry<K, V>... entries) {
        return new MapBuilder<K, V>(new LinkedHashMap<K, V>(), entries);
    }
}
