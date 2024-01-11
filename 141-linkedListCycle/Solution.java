
class Solution {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;

        ListNode s = head;
        ListNode t = head.next;

        while(t.next != null && t.next.next != null){
            if(s == t) return true;

            s = s.next;
            t = t.next.next;
        }


        return false;

    }
}