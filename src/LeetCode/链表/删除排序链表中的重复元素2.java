package LeetCode.链表;

public class 删除排序链表中的重复元素2 {
    // 定义链表节点类
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            boolean hasDuplicate = false;
            while (cur.next != null && cur.val == cur.next.val) {
                hasDuplicate = true;
                cur = cur.next;
            }
            if (hasDuplicate) {
                // 跳过重复节点
                pre.next = cur.next;
            } else {
                // 没有重复节点，移动 pre 指针
                pre = pre.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
