package com.leetcode;


public class RemoveLinkedListElements203 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead  = new ListNode(-1,head);
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }

    /**
     * 使用递归实现
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        head.next = removeElements2(head.next,val);
        return head.val == val ? head.next : head;
    }

    /**
     * [1,2,6,3,4,5,6]
     * @param args
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        System.out.println(removeElements(head,2));
    }
}
