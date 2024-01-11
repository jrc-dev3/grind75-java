
class Solution {

    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode middleNode(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        if (head.next != null && head.next.next == null)
            return head.next;

        ListNode tail = head;

        while (tail.next != null && tail.next.next != null) {
            head = head.next;
            tail = tail.next.next;
        }

        if (tail.next != null)
            return head.next;

        return head;
    }
}