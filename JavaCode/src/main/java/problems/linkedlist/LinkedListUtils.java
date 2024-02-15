package problems.linkedlist;

import java.util.List;

public class LinkedListUtils {

  public static <T> ListNode<T> createLinkedListFromList(List<T> list) {
    var head = new ListNode<T>(null);
    for (final T elem : list) {
      head = addNode(head, elem);
    }

    return head.next;
  }

  public static <T> ListNode<T> addNode(ListNode<T> list, T elem) {
    var head = list;
    var elemToBeAdded = new ListNode<T>(elem);
    while (list.next != null) {
      list = list.next;
    }
    list.next = elemToBeAdded;
    return head;
  }

  public static int countListSize(ListNode<Integer> list) {
    var count = 0;
    while (list != null) {
      count++;
      list = list.next;
    }
    return count;
  }

  public static ListNode<Integer> invertList(ListNode<Integer> l) {

    ListNode<Integer> prev = null, next = null;
    var curr = l;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;

    }
    return prev;

  }

}
