package org.jusecase.builders.collections;

import org.jusecase.builders.Builder;

import java.util.Map;

public class MapEntryBuilder<K,V> implements Builder<Map.Entry<K,V>> {
    private final Map.Entry<K,V> entry;

    public MapEntryBuilder(final K key, final V value) {
        this.entry = new Entry<K, V>(key, value);
    }

    @Override
    public Map.Entry<K, V> build() {
        return entry;
    }

    class Entry<K,V> implements Map.Entry<K,V>{
        private final K key;
        private V value;

        Entry(final K key, final V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(final V value) {
            return this.value = value;
        }
    }
}
