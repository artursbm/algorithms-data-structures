package problems.linkedlist;

import static problems.linkedlist.LinkedListUtils.invertList;

public class MergeSortedLists {

  public ListNode<Integer> solution(ListNode<Integer> l1, ListNode<Integer> l2) {
    ListNode<Integer> head = null;

    var invertA = invertList(l1);
    var invertB = invertList(l2);

    while (invertA != null && invertB != null) {
      if (invertA.value >= invertB.value) {
        var temp = invertA.next;
        invertA.next = head;
        head = invertA;
        invertA = temp;
      } else {
        var temp = invertB.next;
        invertB.next = head;
        head = invertB;
        invertB = temp;
      }
    }

    while (invertA != null) {
      var temp = invertA.next;
      invertA.next = head;
      head = invertA;
      invertA = temp;
    }
    while (invertB != null) {
      var temp = invertB.next;
      invertB.next = head;
      head = invertB;
      invertB = temp;
    }

    return head;
  }

}
