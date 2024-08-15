class Solution
{
public:
    ListNode *reverseList(ListNode *head)
    {
        if (!head || !head->next)
            return head;

        ListNode *trav = head, *prev = NULL, *next = NULL;

        while (trav)
        {
            next = trav->next;
            trav->next = prev;
            prev = trav;
            trav = next;
        }

        return prev;
    }
};