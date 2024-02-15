package problems.linkedlist;

import static org.junit.jupiter.api.Assertions.*;
import static problems.linkedlist.LinkedListUtils.createLinkedListFromList;

import java.util.List;
import org.junit.jupiter.api.Test;

class ReverseNodesInKGroupsTest {

  ReverseNodesInKGroups reverseNodesInKGroups = new ReverseNodesInKGroups();

  @Test
  void testSuccess() {
    ListNode<Integer> l = createLinkedListFromList(List.of(1, 2, 3, 4));

    ListNode<Integer> expected = createLinkedListFromList(List.of(2,1,4,3));

    var sol = reverseNodesInKGroups.solution(l, 2);

    while(expected.next != null) {
      assertEquals(expected.value, sol.value);
      expected = expected.next;
      sol = sol.next;

    }
  }

}