package problems.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class AddTwoHugeNumbersTest {

  @Test
  void testSuccess() {
    var a = LinkedListUtils.createLinkedListFromList(List.of(9876, 5432, 1999));
    var b = LinkedListUtils.createLinkedListFromList(List.of(1, 8001));

    var sol = LinkedListUtils.createLinkedListFromList(List.of(9876, 5434, 0));

    AddTwoHugeNumbers problem = new AddTwoHugeNumbers();
    var prob = problem.solution(b, a);

    while (sol.next != null) {
      assertEquals(sol.value, prob.value);
      sol = sol.next;
      prob = prob.next;
    }

  }

  @Test
  void testSuccess2() {
    var a = LinkedListUtils.createLinkedListFromList(List.of(123, 4, 5));
    var b = LinkedListUtils.createLinkedListFromList(List.of(100, 100, 100));

    var sol = LinkedListUtils.createLinkedListFromList(List.of(223, 104, 105));

    AddTwoHugeNumbers problem = new AddTwoHugeNumbers();
    var prob = problem.solution(b, a);

    while (sol.next != null) {
      assertEquals(sol.value, prob.value);
      sol = sol.next;
      prob = prob.next;
    }

  }

  @Test
  void testSuccess3() {
    var a = LinkedListUtils.createLinkedListFromList(List.of(1));
    var b = LinkedListUtils.createLinkedListFromList(List.of(9999, 9999, 9999, 9999, 9999, 9999));

    var sol = LinkedListUtils.createLinkedListFromList(List.of(1, 0, 0, 0, 0, 0, 0));

    AddTwoHugeNumbers problem = new AddTwoHugeNumbers();
    var prob = problem.solution(a, b);

    while (sol.next != null) {
      assertEquals(sol.value, prob.value);
      sol = sol.next;
      prob = prob.next;
    }

  }

}