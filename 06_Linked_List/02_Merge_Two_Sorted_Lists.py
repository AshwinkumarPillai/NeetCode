class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        head = trav = ListNode()

        while list1 and list2:
            if list1.val < list2.val:
                trav.next = list1
                list1 = list1.next
            else:
                trav.next = list2
                list2 = list2.next
            trav = trav.next
        
        trav.next = list1 or list2
        
        return head.next
            