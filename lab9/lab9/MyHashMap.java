package lab9;

import java.util.Iterator;
import java.util.Set;

/**
 *  A hash table-backed Map implementation. Provides amortized constant time
 *  access to elements via get(), remove(), and put() in the best case.
 *
 *  @author sjwang
 */
public class MyHashMap<K, V> implements Map61B<K, V> {

    private static final int DEFAULT_SIZE = 4;
    private static final double MAX_LF = 0.75;

    private ArrayMap<K, V>[] buckets;
    private int size;

    private double loadFactor() {
        return (double) size / buckets.length;
    }

    public MyHashMap() {
        buckets = new ArrayMap[DEFAULT_SIZE];
        this.clear();
    }

    /* Removes all of the mappings from this map. */
    @Override
    public void clear() {
        this.size = 0;
        for (int i = 0; i < this.buckets.length; i += 1) {
            this.buckets[i] = new ArrayMap<>();
        }
    }

    /** Computes the hash function of the given key. Consists of
     *  computing the hashcode, followed by modding by the number of buckets.
     *  To handle negative numbers properly, uses floorMod instead of %.
     */
    private int hash(K key) {
        if (key == null) {
            return 0;
        }
        int numBuckets = buckets.length;
        return Math.floorMod(key.hashCode(), numBuckets);
    }

    /** Returns the value to which the specified key is mapped, or null if this
     *  map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        if(key == null || buckets[hash(key)] == null) return null;
        return buckets[hash(key)].get(key);
    }

    /** Associates the specified value with the specified key in this map.
     *  Doubling the number of buckets anytime the load factor exceeds MAX_LF.
     */
    @Override
    public void put(K key, V value) {
        if(buckets[hash(key)] != null && buckets[hash(key)].containsKey(key)) {
            return;
        }
        double v = this.loadFactor();
        if(v > MAX_LF){
            int len = buckets.length * 2;
            ArrayMap<K, V>[] b = buckets;
            ArrayMap<K, V>[] temp = new ArrayMap[len];
            buckets = temp;
            this.clear();
            for(int i = 0; i < b.length; i++){
                for(K k : b[i].keySet()){
                    buckets[hash(k)].put(k, b[i].get(k));
                    size ++;
                }
            }
        }
        buckets[hash(key)].put(key, value);
        size ++;
    }

    /** Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return  size;
    }

    //////////////// EVERYTHING BELOW THIS LINE IS OPTIONAL ////////////////

    /* Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    /* Removes the mapping for the specified key from this map if exists.
     * Not required for this lab. If you don't implement this, throw an
     * UnsupportedOperationException. */
    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for this lab. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }

    public static void main(String args[]){
        MyHashMap<String, Integer> my = new MyHashMap<>();
        my.put("apple", 10);
        my.put("banana", 15);
        my.put("door", 5);
        my.put("dog", 6);
        my.put("sky", 6);
        System.out.println(my.size());
        System.out.println(my.get("dog"));
    }
}
