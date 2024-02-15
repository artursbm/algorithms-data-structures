package problems.linkedlist;

import static problems.linkedlist.LinkedListUtils.addNode;
import static problems.linkedlist.LinkedListUtils.countListSize;
import static problems.linkedlist.LinkedListUtils.invertList;

public class AddTwoHugeNumbers {

  public ListNode<Integer> solution(ListNode<Integer> a, ListNode<Integer> b) {
    var invertedA = invertList(a);
    var invertedB = invertList(b);

    var carryOn = 0;
    var sum = new ListNode<>(0);

    if (countListSize(invertedA) > countListSize(invertedB)) {
      while (invertedB != null) {

        var currSum = invertedB.value + invertedA.value + carryOn;
        if (currSum > 9999) {
          currSum -= 10000;
          carryOn = 1;
        } else {
          carryOn = 0;
        }

        addNode(sum, currSum);

        invertedB = invertedB.next;
        invertedA = invertedA.next;
      }
      while(invertedA!= null) {
        var lastSum = invertedA.value + carryOn;
        if (lastSum > 9999) {
          lastSum -= 10000;
          carryOn = 1;
        } else {
          carryOn = 0;
        }
        addNode(sum, lastSum);
        invertedA = invertedA.next;
      }
      if (carryOn == 1) {
        var h = new ListNode<Integer>(carryOn);
        h.next = invertList(sum.next);
        return h;
      }
      return invertList(sum.next);

    } else if (countListSize(invertedA) < countListSize(invertedB)) {
      while (invertedA != null) {

        var currSum = invertedB.value + invertedA.value + carryOn;
        if (currSum > 9999) {
          currSum -= 10000;
          carryOn = 1;
        } else {
          carryOn = 0;
        }

        addNode(sum, currSum);

        invertedA = invertedA.next;
        invertedB = invertedB.next;
      }
      while (invertedB != null) {
        var lastSum = invertedB.value + carryOn;
        if (lastSum > 9999) {
          lastSum -= 10000;
          carryOn = 1;
        } else {
          carryOn = 0;
        }
        addNode(sum, lastSum);
        invertedB = invertedB.next;
      }
      if (carryOn == 1) {
        var h = new ListNode<Integer>(carryOn);
        h.next = invertList(sum.next);
        return h;
      }
      return invertList(sum.next);
    } else {
      while (invertedA != null) {

        var currSum = invertedB.value + invertedA.value + carryOn;
        if (currSum > 9999) {
          currSum -= 10000;
          carryOn = 1;
        } else {
          carryOn = 0;
        }

        addNode(sum, currSum);

        invertedA = invertedA.next;
        invertedB = invertedB.next;
      }

      if (carryOn == 1) {
        var h = new ListNode<Integer>(carryOn);
        h.next = invertList(sum.next);
        return h;
      }
      return invertList(sum.next);
    }

  }

}
