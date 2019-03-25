/**
 * @author Li Gen
 * @date 2018-11-19 14:38
 */
public class LeetCode21 {
    /**
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * 示例：
     *
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     */

    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static  ListNode buildListNode(Long ret){
        ListNode result;
        if (ret>10) {
            int p = (int) (ret % 10);
            Long q = ret / 10;
            result = new ListNode(p);
            ListNode node = result;
            while (q>10){
                p = (int)(q % 10);
                q = q / 10;
                node.next = new ListNode(p);
                node = node.next;
            }
            node.next = new ListNode(q.intValue());
            return result;
        }else {
            return new ListNode(ret.intValue());
        }
    }

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        ListNode l1 = mergeTwoLists(buildListNode(421L),buildListNode(431L));
        while (l1 != null){
            String s = l1.next != null ? l1.val + " -> " : l1.val + "";
            System.out.printf(s);
            l1 = l1.next;
        }
        System.out.printf("\n");
        System.out.printf("花费时间：%d ms",System.currentTimeMillis()-time);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode r = result;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                r.next = new ListNode(l1.val);
                l1 = l1.next;
            }  else {
                r.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            r = r.next;
        }

        if (l1 == null){
            r.next = l2;
        }

        if (l2 == null){
            r.next = l1;
        }
        return result.next;
    }
}
