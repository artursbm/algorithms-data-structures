package problems.leetcode;

import static problems.linkedlist.LinkedListUtils.createLinkedListFromList;

import java.util.List;
import org.junit.jupiter.api.Test;
import problems.linkedlist.ListNode;

class MergeInBetweenLinkedListsTest {

    private final MergeInBetweenLinkedLists mergeBranches = new MergeInBetweenLinkedLists();

    @Test
    void testSuccess() {
        ListNode<Integer> list1 = createLinkedListFromList(List.of(10,1,13,6,9,5));
        ListNode<Integer> list2 = createLinkedListFromList(List.of(1000000,1000001,1000002));

        var result = mergeBranches.mergeInBetween(list1, 3,4, list2);

    }

}