package com.Link;



public class Practice {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

class Solution2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode tmpNode = head.next;
            head.next = newHead;
            newHead = head;
            head = tmpNode;
        }

        return newHead;
    }

    public ListNode reverseList2(ListNode head) {

        if (head == null ||head.next == null) return head;
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
