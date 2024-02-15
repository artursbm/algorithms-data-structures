package problems.linkedlist;

public class RemoveNodesWithValue {

  public ListNode<Integer> solution(ListNode<Integer> l, int k) {
    var head = new ListNode<Integer>(null);
    head.next = l; // [null, l...]

    var current = l;
    var previous = head;

    while (current != null) {
      if (current.value == k) {
        previous.next = current.next;
      } else {
        previous = current;

      }
      current = current.next;
    }

    return head.next;

  }
}
