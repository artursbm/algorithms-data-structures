package problems.linkedlist;

import static org.junit.jupiter.api.Assertions.*;
import static problems.linkedlist.LinkedListUtils.createLinkedListFromList;

import java.util.List;
import org.junit.jupiter.api.Test;

class IsListPalindromeTest {

  IsListPalindrome isListPalindrome = new IsListPalindrome();

  @Test
  void testCountListSizeEven() {
    var ll = createLinkedListFromList(List.of(1,2,2,1));

    assertEquals(4, isListPalindrome.countListSize(ll));
    assertTrue(isListPalindrome.solution(ll));
  }

  @Test
  void testCountListSizeOdd() {
    var ll = createLinkedListFromList(List.of(1,2,3,2,1));

    assertEquals(5, isListPalindrome.countListSize(ll));
    assertTrue(isListPalindrome.solution(ll));
  }

  @Test
  void testNotAPalindrome() {
    var ll = createLinkedListFromList(List.of(1,3,5,2,1));

    assertEquals(5, isListPalindrome.countListSize(ll));
    assertFalse(isListPalindrome.solution(ll));
  }
}