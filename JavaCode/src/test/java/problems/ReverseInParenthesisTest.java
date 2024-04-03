package problems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReverseInParenthesisTest {

  ReverseInParenthesis inst = new ReverseInParenthesis();

  @Test
  void testSimpleString() {
    String inputString = "(bar)";
    String out = "rab";

    assertEquals(out, inst.solution(inputString));
  }

  @Test
  void testComplexScenario1() {
    var inputString = "foo(bar(baz))blim";
    var expected = "foobazrabblim";
    assertEquals(expected, inst.solution(inputString));
  }

  @Test
  void testComplexScenario2() {
    var inputString = "foo(bar)baz(blim)";
    var expected = "foorabbazmilb";
    assertEquals(expected, inst.solution(inputString));
  }




}