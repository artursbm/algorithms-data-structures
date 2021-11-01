using System;

namespace AlgAndDsProblems.problems
{
    public class LinkedList
    {
        public static Node insert(Node head,int data)
        {
            var currNode = head;
            if (head == null)
            {
                return new Node(data);
            }
            while (currNode.next != null)
            {
                currNode = currNode.next;
            }
            var newNode = new Node(data);
            currNode.next = newNode; 
            return head;
        }
        
        public static void display(Node head)
        {
            Node start=head;
            while(start!=null)
            {
                Console.Write(start.data+" ");
                start=start.next;
            }
        }
    }

    public class Node
    {
        public int data;
        public Node next;

        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }
}