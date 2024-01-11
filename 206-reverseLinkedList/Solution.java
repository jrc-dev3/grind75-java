
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

    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;

        ListNode prev = null;

        while(head.next != null){

            ListNode nxt = head.next;
            head.next = prev;
            prev = head;
            head = nxt;
        }

        head.next = prev;
        return head;
    }
}