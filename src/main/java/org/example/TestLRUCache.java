package org.example;

public class TestLRUCache {
    public static void main(String[] args) {
        LRUCache testCache = new LRUCache(1);
        System.out.println(testCache.get(2));
        testCache.put(2,1);
        testCache.get(2);
        testCache.showCacheContentInOrder();
        testCache.put(3,2);
        testCache.showCacheContentInOrder();
        System.out.println(testCache.get(2));
        testCache.showCacheContentInOrder();
        System.out.println(testCache.get(3));
        testCache.showCacheContentInOrder();
    }
}
