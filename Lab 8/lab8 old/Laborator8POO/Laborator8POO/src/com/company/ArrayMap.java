package com.company;

import java.util.*;

public class ArrayMap<K,V> extends AbstractMap {
    private ArrayList<K> colectie=new ArrayList<>();
    private ArrayList<V> colectieValori=new ArrayList<>();
    @Override
    public Set entrySet() {
        Set<Map.Entry<K,V>> raspuns=new HashSet<>();
        for (int i = 0; i < colectieValori.size(); i++) {
            raspuns.add(Map.entry(colectie.get(i), colectieValori.get(i)));
        }
        return raspuns;
    }

    @Override
    public Object put(Object key, Object value) {
        if(colectieValori.contains(value))
            return null;
        colectie.add((K)key);
        colectieValori.add((V) value);
        return this;
    }
    public int size()
    {
        return colectie.size();
    }
    class ArrayMapEntry implements Map.Entry<K,V>
    {
        private K key;
        private V value;
        public ArrayMapEntry(K key, V value) {
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
        public V setValue(V value) {
           V trecut=this.value;
            if(!colectieValori.contains(value))
                this.value=value;
            return trecut;
        }
    }

    @Override
    public String toString() {
        return "ArrayMap{" +
                "colectie=" + colectie +
                ", colectieValori=" + colectieValori +
                '}';
    }
}
