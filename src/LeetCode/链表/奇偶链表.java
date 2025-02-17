package LeetCode.链表;

public class 奇偶链表 {

    // 定义链表节点类
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 奇数链表的头节点
        ListNode odd = head;
        // 偶数链表的头节点
        ListNode even = head.next;
        // 保存偶数链表的头节点，用于后续连接
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            // 连接奇数节点
            odd.next = even.next;
            odd = odd.next;
            // 连接偶数节点
            even.next = odd.next;
            even = even.next;
        }
        // 将偶数链表连接到奇数链表的末尾
        odd.next = evenHead;
        return head;
    }
}
