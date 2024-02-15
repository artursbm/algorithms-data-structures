package problems.linkedlist;

import static problems.linkedlist.LinkedListUtils.countListSize;

public class ReverseNodesInKGroups {

  ListNode<Integer> solution(ListNode<Integer> l, int k) {
    int listSize = countListSize(l);

    if (listSize % k == 0) {
      while (l != null) {
        var ki = 0;
        var prev = l;
        var next = l.next;
        while (ki < k) {
          l.next = prev;
          prev = next;
          curr
          ki++;
        }
        l = l.next;

      }
      return l;
    }
    return l;
  }
}
