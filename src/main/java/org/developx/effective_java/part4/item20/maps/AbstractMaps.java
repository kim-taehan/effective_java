package org.developx.effective_java.part4.item20.maps;

import java.util.WeakHashMap;

public class AbstractMaps<K, V> implements Maps<K, V> {

    private WeakHashMap<K, V> Map = new WeakHashMap<>();
    @Override
    public void put(K k, V v) {
        Map.put(k, v);
    }

    @Override
    public V get(K k) {
        return Map.get(k);
    }
}
