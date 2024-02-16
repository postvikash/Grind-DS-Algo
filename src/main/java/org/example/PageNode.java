package org.example;

public class PageNode {
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
