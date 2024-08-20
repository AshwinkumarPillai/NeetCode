class Solution {
    public void reorderList(ListNode head) {
        ListNode fast = head, slow = head;

        // Find the middle of the linked list - slow will be middle Node
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Revese the second part - prev will the head of the reversed list
        ListNode trav = slow, prev = null, next = null;

        while (trav != null) {
            next = trav.next;
            trav.next = prev;
            prev = trav;
            trav = next;
        }

        // Merge the two lists
        ListNode first = head, second = prev;

        while (second.next != null) {
            next = first.next;
            first.next = second;
            first = next;

            next = second.next;
            second.next = first;
            second = next;
        }
    }
}