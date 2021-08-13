package com.pak.practice.algorithm.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyLinkedListWithArbitraryPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> origCloneMap = new HashMap<>();

        Node curr = head;

        while(curr != null){
            Node copy = new Node(curr.val);
            origCloneMap.put(curr, copy);
            curr = curr.next;
        }

        for(Map.Entry<Node, Node> entry : origCloneMap.entrySet()){
            entry.getValue().next = origCloneMap.get(entry.getKey().next);
            entry.getValue().random = origCloneMap.get(entry.getKey().random);
        }
        return origCloneMap.get(head);
    }

    public static void main(String[] args) {
        CopyLinkedListWithArbitraryPointer obj = new CopyLinkedListWithArbitraryPointer();

    }
}
