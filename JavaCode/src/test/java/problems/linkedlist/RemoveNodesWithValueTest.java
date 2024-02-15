package problems.linkedlist;

import static org.junit.jupiter.api.Assertions.*;
import static problems.linkedlist.LinkedListUtils.createLinkedListFromList;

import java.util.List;
import org.junit.jupiter.api.Test;

class RemoveNodesWithValueTest {

  private final RemoveNodesWithValue removeNodesWithValue = new RemoveNodesWithValue();

  @Test
  void testSolution() {

    ListNode<Integer> l = createLinkedListFromList(List.of(3,1,2,3,4,5));

    ListNode<Integer> expected = createLinkedListFromList(List.of(1,2,4,5));

    var sol = removeNodesWithValue.solution(l, 3);

    while(expected.next != null) {
      assertEquals(expected.value, sol.value);
      expected = expected.next;
      sol = sol.next;

    }

  }



}