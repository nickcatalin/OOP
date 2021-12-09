import java.util.*;

abstract class AbstractMap<K,V> {
    abstract public String toString();
    abstract public V put(K key, V value);
    abstract public V get(Object o);
    abstract public Set<K> keySet();
    abstract public Collection<V> values();
    abstract public Set<Map.Entry<K, V>> entrySet(); // atentie! Se va defini o clasa interna pentru o intrare in dictionar - **//Map.Entry//**
}

public class ArrayMap<K,V> extends AbstractMap<K,V> {
    private Vector<K> keys;
    private Vector<V> values;

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < keys.size(); i++)
            result.append(keys.get(i).toString())
                    .append(' ')
                    .append(values.get(i).toString());
        return result.toString();
    }

    public V put(K key, V value) {
        for (int i = 0; i < keys.size(); i++)
            if (keys.get(i).equals(key)) {
                V old = values.get(i);
                values.set(i, value);
                return old;
            }
        keys.add(key);
        values.add(value);
        return null;
    }

    public V get(Object o) {
        if (o == null)
            return null;
        K key = (K) o;
        for (K k : keys)
            if (k.equals(key))
                return values.get(keys.indexOf(k));
        return null;
    }

    public Set<K> keySet() {
        return new TreeSet<>(keys);
    }

    public Collection<V> values() {
        return new TreeSet<>(values);
    }

    public Set<Map.Entry<K,V>> entrySet() {
        Set<Map.Entry<K,V>> result = new HashSet<>();
        for (int i = 0; i < keys.size(); ++i)
            result.add(new ArrayMapEntry<>(keys.get(i), values.get(i)));
        return result;
    }

    class ArrayMapEntry<K,V> implements Map.Entry<K,V>{
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
            V old = this.value;
            this.value = value;
            return old;
        }
    }
}
