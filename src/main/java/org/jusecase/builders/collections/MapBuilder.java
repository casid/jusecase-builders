package org.jusecase.builders.collections;

import java.util.Map;

import org.jusecase.builders.Builder;

public class MapBuilder<K,V> implements Builder<Map<K,V>> {
    private final Map<K,V> map;

    public MapBuilder(final Map<K, V> map, Map.Entry<K,V>... entries) {
        this.map = map;
        for (Map.Entry<K, V> entry : entries)
            map.put(entry.getKey(), entry.getValue());
    }

    @Override
    public Map<K, V> build() {
        return map;
    }
}
