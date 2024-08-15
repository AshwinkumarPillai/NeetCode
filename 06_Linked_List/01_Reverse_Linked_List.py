class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        trav = head
        prev, nextN = None, None

        while trav != None:
            nextN = trav.next
            trav.next = prev
            prev = trav
            trav = nextN
        
        return prev