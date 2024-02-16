package org.example;

public class TestLRUCache {
    public static void main(String[] args) {
        LRUCache testCache = new LRUCache(6);
        testCache.put(1,1);
        testCache.put(2,2);
        testCache.put(3,3);
        testCache.put(4,4);
        testCache.put(5,5);
        testCache.showCacheContentInOrder();
        testCache.put(6,6);
        testCache.showCacheContentInOrder();
        testCache.put(7,7);
        testCache.showCacheContentInOrder();
        testCache.put(8,8);
        testCache.showCacheContentInOrder();
        testCache.put(9,9);
        testCache.showCacheContentInOrder();
        testCache.get(4);
        testCache.showCacheContentInOrder();
        testCache.put(5,5555);
        testCache.showCacheContentInOrder();
        testCache.put(3,3);
        testCache.showCacheContentInOrder();
    }
}
