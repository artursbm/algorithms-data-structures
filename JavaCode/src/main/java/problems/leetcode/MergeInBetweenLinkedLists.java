package problems.leetcode;

import problems.linkedlist.ListNode;

public class MergeInBetweenLinkedLists {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode<Integer> mergeInBetween(ListNode<Integer> list1, int a, int b, ListNode<Integer> list2) {
        int st = 0;
        var head = new ListNode<Integer>(null);
        var curr = head;
        while (st < a) {
            head.next = new ListNode<>(list1.value);
            list1 = list1.next;
            head = head.next;
            st++;
        }
        while(list2 != null) {
            head.next = new ListNode<>(list2.value, list2.next);
            head = head.next;
            list2 = list2.next;
        }
        while (st <= b) {
            list1 = list1.next;
            st++;
        }
        head.next = list1;
        return curr.next;
    }
}
