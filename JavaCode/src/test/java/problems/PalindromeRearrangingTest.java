package problems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PalindromeRearrangingTest {

  PalindromeRearranging pr = new PalindromeRearranging();

  @Test
  void testEvenPalindrome() {
    String evenPal = "baba";

    assertTrue(pr.solution(evenPal));
  }

  @Test
  void testOddPalindrome() {
    String oddPal = "bacba";

    assertTrue(pr.solution(oddPal));
  }

  @Test
  void testOneLetterWord() {
    String olw = "a";

    assertTrue(pr.solution(olw));
  }

  @Test
  void testNonPalindrome() {
    String nonPal = "asdfwe";
    assertFalse(pr.solution(nonPal));
  }

}