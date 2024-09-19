/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode* prev {};
        ListNode* cur {};
        cur = head;
        while (cur != nullptr) {
            ListNode* temp = cur->next;
            cur->next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    ListNode* findMiddleNode(ListNode* head) {
        ListNode* slow {};
        ListNode* fast {};
        slow = head;
        fast = head->next;
        while (fast != nullptr && fast->next != nullptr) {
            slow = slow->next;
            fast = fast->next->next;
        }
        return slow;
    }

    bool isPalindrome(ListNode* head) {
        ListNode* middleNode = findMiddleNode(head);
        middleNode->next = reverseList(middleNode->next);
        ListNode* p { head };
        ListNode* q { middleNode->next };
        bool isPalindrome { true };
        while (q != nullptr) {
            if (p->val != q->val) {
                isPalindrome = false;
                break;
            }
            p = p->next;
            q = q->next;
        }
        middleNode->next = reverseList(middleNode->next);
        return isPalindrome;
    }
};