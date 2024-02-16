package org.example;

public class LRUCache {
    int capacity;
    int size = 0;
    PageNode head = null, tail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        PageNode itr = head;
        while(itr != null) {
            if( itr.key == key) {
                delinkPageAndPutOnTop(itr);
                return itr.val;
            }
            itr = itr.next;
        }
        return -1;
    }

    public void put(int key, int value) {
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
    }

    protected void evictAndInsertPage(int key, int value) {
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
