package problems.linkedlist;

public class IsListPalindrome {

  /**
   * For l = [0, 1, 0], the output should be
   * solution(l) = true;
   * <p>
   * For l = [1, 2, 2, 3], the output should be
   * solution(l) = false.

   * The solution below involves calculating the size of the list;
   * getting the "middle" of the list with size/2;
   * traversing the first half of the list and transforming elements into a number (leftSide)
   * if list is odd sized, ignore the middle element by doing l = l.next outside of the loop
   * if list is even, just go ahead
   * at last, traverse the "right half" of the list,
   * doing the same transformation of the elements, but putting them in the reverse order (rightSide)
   *
   * finally, check if leftSide == rightSide
   */
  public boolean solution(ListNode<Integer> l) {
    int leftNum = 0, rightNum = 0;
    var size = countListSize(l);

    var mid = size / 2;
    while (mid > 0) {
      leftNum += (int) (l.value * Math.pow(10, mid - 1));
      l = l.next;
      mid--;
    }

    if (size % 2 != 0) {
      l = l.next;
    }

    mid = 0;
    while (mid < size / 2) {
      rightNum += (int) (l.value * Math.pow(10, mid));
      l = l.next;
      mid++;
    }
    return leftNum == rightNum;
  }

  public int countListSize(ListNode<Integer> list) {
    var count = 0;
    while (list != null) {
      count++;
      list = list.next;
    }
    return count;
  }

}
