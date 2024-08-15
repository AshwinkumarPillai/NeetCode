class Solution
{
public:
    ListNode *mergeTwoLists(ListNode *list1, ListNode *list2)
    {
        if (!list1 && !list2)
            return list1;
        if (!list1)
            return list2;
        if (!list2)
            return list1;

        ListNode *head = new ListNode();
        ListNode *trav = head;

        while (list1 && list2)
        {
            if (list1->val < list2->val)
            {
                trav->next = list1;
                list1 = list1->next;
            }
            else
            {
                trav->next = list2;
                list2 = list2->next;
            }
            trav = trav->next;
        }

        if (!list1)
            trav->next = list2;
        else
            trav->next = list1;

        return head->next;
    }
};