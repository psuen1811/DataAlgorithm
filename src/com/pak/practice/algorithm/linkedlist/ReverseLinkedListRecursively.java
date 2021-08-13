package com.pak.practice.algorithm.linkedlist;

public class ReverseLinkedListRecursively {
    Node head;

    static class Node {
        final int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    void push(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    Node reverseLinkedList(Node node) {
        /* We have two conditions in this if statement.
  This first condition immediately returns null
  when the list is null. The second condition returns
  the final node in the list. That final node is sent
  into the "remaining" Node below.
-----------------------------------------------------*/
        if (node == null || node.next == null)
            return node;

        /* When the recursion creates the stack for A -> B -> C
   (RevA(RevB(RevC()))) it will stop at the last node and
   the recursion will end, beginning the unraveling of the
   nested functions from the inside, out.
-----------------------------------------------------*/
        Node remaining = reverseLinkedList(node.next);

        /* Now we have the "remaining" node returned and accessible
   to the node prior. This remaining node will be returned
   by each function as the recursive stack unravels.

   Assigning head to head.next.next where A is the head
   and B is after A, (A -> B), would set B's pointer to A,
   reversing their direction to be A <- B.
-----------------------------------------------------*/
        node.next.next = node;

        /* Now that those two elements are reversed, we need to set
the pointer of the new tail-node to null.
-----------------------------------------------------*/
        node.next = null;

        /* Now we return remaining so that remaining is always
   reassigned to itself and is eventually returned by the
   first function call.
-----------------------------------------------------*/
        return remaining;
    }

    static void printList(Node n) {
        while (n != null) {
            System.out.println(n.value + " ");
            n = n.next;
        }
    }

    public static void main(String[] args) {
        ReverseLinkedListRecursively rl = new ReverseLinkedListRecursively();
        for (int i = 0; i < 10; i++)
            rl.push(i);
        Node reverse = rl.reverseLinkedList(rl.head);
        printList(reverse);
    }
}
