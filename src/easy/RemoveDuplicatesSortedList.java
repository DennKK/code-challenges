package easy;

// 83. Remove Duplicates from Sorted List
public class RemoveDuplicatesSortedList {
    private static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = head, curr = head.next;
        while (curr != null) {
            if (prev.val == curr.val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}