class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode trav = head, prev = null, next = null;

        while (trav != null) {
            next = trav.next;
            trav.next = prev;
            prev = trav;
            trav = next;
        }
        return prev;
    }
}