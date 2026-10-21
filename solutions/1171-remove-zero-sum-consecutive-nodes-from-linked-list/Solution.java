import java.util.*;

class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer, ListNode> sumToNode = new HashMap<>();
        int sum = 0;
        for (ListNode cur = dummy; cur != null; cur = cur.next) {
            sum += cur.val;
            sumToNode.put(sum, cur);
        }
        sum = 0;
        for (ListNode cur = dummy; cur != null; cur = cur.next) {
            sum += cur.val;
            ListNode node = sumToNode.get(sum);
            if (node != cur) {
                cur.next = node.next;
            }
        }
        return dummy.next;
    }
}
