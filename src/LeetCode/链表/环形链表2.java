package LeetCode.链表;

import java.util.HashSet;
import java.util.Set;

public class 环形链表2 {
    // 定义链表节点类
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode current = head;
        while (current != null) {
            if (nodeSet.contains(current)) {
                return current;
            }
            nodeSet.add(current);
            current = current.next;
        }
        return null;
    }
}
