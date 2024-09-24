package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

// 138. Copy List with Random Pointer
public class CopyListWithRandomPointer {
    private static class Node {
        private final int val;
        private Node next;
        private Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    private Node copyRandomList(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;
        Map<Node, Node> map = new HashMap<>();

        while (head != null) {
            Node node = new Node(head.val);
            map.put(head, node);
            head = head.next;
        }

        Node oldNode = dummy.next;
        while (oldNode != null) {
            Node newNode = map.get(oldNode);
            newNode.next = map.get(oldNode.next);
            newNode.random = map.get(oldNode.random);
            oldNode = oldNode.next;
        }

        return map.get(dummy.next);
    }
}