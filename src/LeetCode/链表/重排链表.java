package LeetCode.链表;

public class 重排链表 {
    public void reorderList(ListNode head) {
        if (head == null) return;
        // 找到中间转折的点
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("slow -> " + slow.val);
        // 翻转后边的列表
        ListNode nl = new ListNode();
        while (slow.next != null) {
            ListNode tmp = slow.next;
            // 移除主链表
            slow.next = slow.next.next;
            // 放入翻转链表
            tmp.next = nl.next;
            nl.next = tmp;
        }
        // 合并链表
        ListNode cur = head;
        while (nl.next != null) {
            ListNode tmp = nl.next;
            nl.next = nl.next.next;
            // 加入主链表
            tmp.next = cur.next;
            cur.next = tmp;
            cur = cur.next.next;
            System.out.print(".");
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode() {  }
    }
}
