package org.example;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int capacity;
    int size = 0;
    PageNode head = null, tail = null;
    Map<Integer, PageNode> keyNodeAddressMap = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        PageNode detachedNode = keyNodeAddressMap.get(key);
        if(detachedNode == null)
            return -1;
        else
            delinkPageAndPutOnTop(detachedNode);
        return detachedNode.val;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            PageNode itr = head;
            while(itr != null) {
                if( itr.key == key) {
                    itr.val = value;
                    delinkPageAndPutOnTop(itr);
                    return;
                }
                itr = itr.next;
            }
        }
        if (size < capacity) {
            size++;
            insertNewPageInCache(key, value);
        } else {
            evictAndInsertPage(key, value);
        }
    }

    protected void insertNewPageInCache(int key, int value) {
        PageNode pageNode = new PageNode(key, value);
        if (head == null)
            head = tail = pageNode;
        else {
            pageNode.next = head;
            head.prev = pageNode;
            head = pageNode;
        }
        keyNodeAddressMap.put(key, pageNode);
    }

    protected void evictAndInsertPage(int key, int value) {
        keyNodeAddressMap.remove(tail.key);
        if (size == 1) {
            head = tail = null;
            insertNewPageInCache(key, value);
            return;
        }
        tail = tail.prev;
        tail.next = null;
        insertNewPageInCache(key, value);
    }

    protected void delinkPageAndPutOnTop(PageNode page) {
        if (page == head)
            return;
        if (page == tail) {
            page.prev.next = null;
            tail = page.prev;
            page.prev = null;
            page.next = head;
            head.prev = page;
            head = page;
            return;
        }
        page.prev.next = page.next;
        page.next.prev = page.prev;
        page.prev = null;
        page.next = head;
        head.prev = page;
        head = page;
    }

    public void showCacheContentInOrder() {
        PageNode itr = head;
        System.out.println("****   Printing cache content     ****");
        while (itr != null) {
            System.out.print("("+itr.key + "," + itr.val +"), ");
            itr = itr.next;
        }
        System.out.println("\n");
    }

}


class PageNode {
    int key;
    int val;
    PageNode next;
    PageNode prev;
    PageNode() {}
    PageNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
    PageNode(int key, int val, PageNode next) {
        this.key = key;
        this.val = val;
        this.next = next;
        this.prev = null;
    }
    PageNode(int key, int val, PageNode next, PageNode prev) {
        this.key = key;
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

