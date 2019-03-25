/**
 * @author Li Gen
 * @date 2018-11-15 15:52
 */
public class LeetCode2 {
    /**
     * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */
   public static class ListNode{
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
       long time = System.currentTimeMillis();
        ListNode l1 = addTwoNumbers(buildListNode(334L),buildListNode(4656L));
        while (l1 != null){
            String s = l1.next != null ? l1.val + " -> " : l1.val + "";
            System.out.printf(s);
            l1 = l1.next;
        }
        System.out.printf("\n");
        System.out.printf("花费时间：%d ms",System.currentTimeMillis()-time);
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

    /**
     * 理解链表
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode result = new ListNode(0);
       ListNode p = l1,q = l2,c = result;
       int carry = 0;
       while (p != null || q != null){
           int x = p != null ? p.val : 0;
           int y = q != null ? q.val : 0;
           int sum = x + y + carry;
           if (sum >= 10){
               carry = 1;
               c.next = new ListNode(sum-10);
           }else {
               carry = 0;
               c.next = new ListNode(sum);
           }
           c = c.next;
           if (p != null){
               p = p.next;
           }
           if (q != null){
               q = q.next;
           }
       }

       if (carry>0){
           c.next = new ListNode(carry);
       }
        return result.next;
    }
}
