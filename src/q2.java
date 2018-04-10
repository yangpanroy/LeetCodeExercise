/**
 * 给定两个非空链表来代表两个非负整数，位数按照逆序方式存储，它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。

 你可以假设除了数字 0 之外，这两个数字都不会以零开头。

 示例：

 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807

 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class q2 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //递归方法
        int carry = 0;  //进位
        int rmder = 0;  //余数
        if (l1 != null || l2 != null){
            if (l1 == null){
                l1 = new ListNode(0);
            }else if (l2 == null){
                l2 = new ListNode(0);
            }
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            rmder = sum % 10;
            ListNode l = new ListNode(rmder);
            l.next = SumNode(l1.next, l2.next, carry);  //递归调用累加节点
            return l;
        }else return null;
    }

    private static ListNode SumNode(ListNode l1, ListNode l2, int carry) {
        int rmder = 0;
        if (l1 != null || l2 != null || carry != 0){
            if (l1 == null){
                l1 = new ListNode(0);
            }
            if (l2 == null){
                l2 = new ListNode(0);
            }
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            rmder = sum % 10;
            ListNode l = new ListNode(rmder);
            l.next = SumNode(l1.next, l2.next, carry);  //递归调用累加节点
            return l;
        }else return null;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        //非递归方法(原文方法)
        ListNode p = new ListNode(0);
        ListNode preHead = p;
        int carry = 0;
        while (l1!=null || l2!=null || carry!=0) {
            int sum = (l1!=null ? l1.val : 0) + (l2!=null ? l2.val : 0) + carry;
            carry = sum / 10;
            p.next = new ListNode(sum % 10);
            p = p.next;
            l1 = (l1!=null ? l1.next : l1);
            l2 = (l2!=null ? l2.next : l2);
        }
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode l = addTwoNumbers2(l1, l2);
        while (l != null){
            System.out.print(l.val);
            l = l.next;
        }
    }

}
