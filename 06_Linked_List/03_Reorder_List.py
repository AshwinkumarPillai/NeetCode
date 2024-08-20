class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head or not head.next:
            return

        fast, slow = head, head
        
        # find the middle element
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        trav = slow
        prev = None

        # Reverse the list
        while trav:
            nextN = trav.next
            trav.next = prev
            prev = trav
            trav = nextN

        # Merge the list
        first, second = head, prev
        while second.next:
            nextN = first.next
            first.next = second
            first = nextN

            nextN = second.next
            second.next = first
            second = nextN
            