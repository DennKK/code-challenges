package leetcode.medium;

// 143. Reorder List
public class ReorderList {
    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    private void reorderList(ListNode head) {
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // Reversing second part of list
        ListNode secondPart = slow.next, prev = null;
        slow.next = null;
        while (secondPart != null) {
            ListNode temp = secondPart.next;
            secondPart.next = prev;
            prev = secondPart;
            secondPart = temp;
        }

        ListNode start = head, end = prev;

        while (start != null && end != null) {
            ListNode startNxt = start.next, endNxt = end.next;
            start.next = end;
            end.next = startNxt;
            start = startNxt;
            end = endNxt;
        }
    }
}
