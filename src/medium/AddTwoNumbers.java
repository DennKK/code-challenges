package medium;

// 2. Add Two Numbers
public class AddTwoNumbers {
    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    // First Solution (best one)
    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;

            int val = v1 + v2 + carry;
            carry = val / 10;
            val = val % 10;
            curr.next = new ListNode(val);

            curr = curr.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        return dummy.next;
    }

    // Second Solution
    private ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode tempL1 = l1, tempL2 = l2;
        while (tempL1 != null && tempL2 != null) {
            tempL1 = tempL1.next;
            tempL2 = tempL2.next;
        }
        ListNode shorterList = tempL1 == null ? l1 : l2, longerList = tempL1 == null ? l2 : l1;
        ListNode dummy = new ListNode();
        dummy.next = shorterList;

        while (shorterList != null) {
            int sum = shorterList.val + longerList.val;
            if (sum >= 10) {
                if (longerList.next == null) {
                    longerList.next = new ListNode();
                }
                shorterList.val = sum % 10;
                longerList.next.val = 1 + longerList.next.val;
            } else {
                shorterList.val = sum;
            }

            longerList = longerList.next;
            if (shorterList.next == null) {
                break;
            }
            shorterList = shorterList.next;
        }

        while (longerList != null) {
            if (longerList.val >= 10) {
                shorterList.next = new ListNode(longerList.val % 10);
                if (longerList.next == null) {
                    longerList.next = new ListNode();
                }
                longerList.next.val = 1 + longerList.next.val;
            } else {
                shorterList.next = new ListNode(longerList.val);
            }
            longerList = longerList.next;
            shorterList = shorterList.next;
        }

        return dummy.next;
    }
}