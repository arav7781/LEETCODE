#include <stdio.h>
#include <stdbool.h>

// Definition for singly-linked list.
struct ListNode {
    int val;
    struct ListNode *next;
};

bool hasCycle(struct ListNode *head) {
    if (head == NULL || head->next == NULL) {
        return false;
    }
    
    struct ListNode *slow = head;
    struct ListNode *fast = head->next;
    
    while (slow != fast) {
        if (fast == NULL || fast->next == NULL) {
            return false;
        }
        slow = slow->next;
        fast = fast->next->next;
    }
    
    return true;
}

int main() {
    // Example usage
    struct ListNode node3 = {3, NULL};
    struct ListNode node2 = {2, &node3};
    struct ListNode node1 = {1, &node2};
    node3.next = &node2;  // Create a cycle

    bool result = hasCycle(&node1);
    if (result) {
        printf("Cycle detected.\n");
    } else {
        printf("No cycle detected.\n");
    }

    return 0;
}
/*If there is a cycle, the fast pointer will eventually catch up to the slow pointer, meaning slow will equal fast, and the loop will exit.
When the loop exits, it indicates that slow equals fast, which means a cycle is detected. Therefore, the function returns true.
Why It Works
Fast and Slow Pointers:
The slow pointer moves one step at a time (slow = slow->next).
The fast pointer moves two steps at a time (fast = fast->next->next).
Cycle Presence:
If there's no cycle, the fast pointer will reach the end of the list (NULL), and the function returns false.
If there is a cycle, the fast pointer will eventually "lap" the slow pointer, causing them to meet within the cycle.*/