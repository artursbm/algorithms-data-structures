package problems.linkedlist;

public class ListNode<T> {

    public T value;
    public ListNode<T> next;

    public ListNode(T x) {
        this.value = x;
    }

    public ListNode(T val, ListNode next) {this.value = val; this.next = next;}

}
