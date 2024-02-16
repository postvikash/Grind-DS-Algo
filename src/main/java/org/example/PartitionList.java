package org.example;

public class PartitionList {
    public static ListNode partition(ListNode head, int x) {
        ListNode prev, curr, next, pivot = null;
        prev = curr = next = head;
        while (next != null) {
            if(curr.val == x) {
                pivot = curr;
                break;
            }
            prev = curr;
            curr = next;
            next = next.next;
        }
        if (next == null)
            return head;
        return shuffleListWithAPivotPoint(head, pivot, x);
    }

    public static ListNode shuffleListWithAPivotPoint(ListNode head, ListNode pivot, int key) {
        ListNode prev = null, curr = pivot;
        ListNode next = pivot.next;
        while (next != null) {
            prev = curr;
            curr = next;
            next = next.next;
            if(curr.val < key) {
                ListNode detachedNode = curr;
                prev.next = next;
                curr = next;
                next = next.next;
                insertDetachedNode(head, detachedNode, key);
            }
        }
        return head;
    }

    public static void insertDetachedNode(ListNode head, ListNode temp, int key) {
        ListNode prev = head, curr = head;
        ListNode next = head.next;
        while (next != null) {
            if(curr.val >= key) {
                temp.next = curr.next;
                prev.next = temp;
                break;
            }
            prev = curr;
            curr = next;
            next = next.next;
        }
    }
}
