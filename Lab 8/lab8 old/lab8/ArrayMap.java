package lab08;

import java.util.*;

public class ArrayMap<K,V> extends AbstractMap<K, V> {
    private ArrayList<ArrayMapEntry<K, V>> arrayMap = new ArrayList<ArrayMapEntry<K, V>>();

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> ans = new HashSet<>();
        for (int i = 0; i < size(); i++) {
            ans.add(arrayMap.get(i));
        }
        return ans;
    }

    public int size() {
        return arrayMap.size();
    }

    public V put(K key, V value) {
        if(arrayMap.contains(new ArrayMapEntry<K,V>(key, value)))
            return null;
        arrayMap.add(new ArrayMapEntry<K,V>(key,value));
        return value;
    }

    public class ArrayMapEntry<K,V> implements Map.Entry<K,V>{
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

        @Override
        public String toString() {
            return "{" + key + value + "}\n";
        }

        @Override
        public boolean equals(Object o) {
            if (o == null)
                return false;
            Map.Entry<K,V> obj = (Map.Entry<K,V>) o;
            return  (this.getKey() == null ? obj.getKey() == null : this.getKey().equals(obj.getKey()))  &&
                    (this.getValue() == null ? obj.getValue() == null : this.getValue().equals(obj.getValue()));
        }

        @Override
        public int hashCode() {
            return (this.getKey() == null ? 0 : this.getKey().hashCode()) ^ (this.getValue() == null ? 0 : this.getValue().hashCode());
        }
    }

}
