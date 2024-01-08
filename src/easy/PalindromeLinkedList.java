package easy;

import java.util.ArrayList;
import java.util.List;

// 234. Palindrome Linked List
public class PalindromeLinkedList {
    static private class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // *****Solution 1*****
    private boolean isPalindrome1(ListNode head) {
        ListNode slow = head, fast = head;

        // find middle (slow)
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse second half
        ListNode prev = null;
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        // check if palindrome
        ListNode left = head, right = prev;
        while (right != null) {
            if (right.val != left.val) {
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;
    }

    // *****Solution 2*****
    private boolean isPalindrome2(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }

        int l = 0, r = arr.size() - 1;
        while (l <= r) {
            if (arr.get(l) != arr.get(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    // *****Solution 3*****
    private boolean isPalindrome3(ListNode head) {
        ListNode prev = null;
        ListNode curr = copy(head);

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        while (prev != null && head != null) {
            if (prev.val != head.val) {
                return false;
            }
            prev = prev.next;
            head = head.next;
        }
        return true;
    }

    private ListNode copy(ListNode node) {
        ListNode newHead = new ListNode(node.val);
        ListNode current = newHead;
        node = node.next;

        while (node != null) {
            current.next = new ListNode(node.val);
            node = node.next;
            current = current.next;
        }

        return newHead;
    }
}