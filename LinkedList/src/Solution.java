// 删除链表中等于给定值 val 的所有节点

public class Solution {

    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }

        // 链表结点的构造函数
        // 使用arr为参数，创建一个链表，当前的ListNode为链表的头结点
        public ListNode(int[] arr) {
            if (arr == null || arr.length == 0)
                throw new IllegalArgumentException("arr can not be empty.");

            this.val = arr[0];
            ListNode cur = this;
            for (int i = 1; i < arr.length; i++) {
                cur.next = new ListNode(arr[i]);
                cur = cur.next;
            }
        }

        // 以当前结点为头结点的链表信息字符串
        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            ListNode cur = this;
            while (cur != null) {
                res.append(cur.val + "->");
                cur = cur.next;
            }
            res.append("NULL");
            return res.toString();
        }
    }

//     // 不带虚拟头结点的链表
//    public ListNode removeElements(ListNode head, int val) {
//        while (head != null && head.val == val) {
//            ListNode delNode = head;
//            head = head.next;
//            delNode.next = null;
//        }
//        if (head == null) return null;
//
//        ListNode prev = head;
//        while (prev.next != null) {
//            if (prev.next.val == val) {
////                ListNode delNode = prev.next;
////                prev.next = delNode.next;
////                delNode.next = null;
//                prev.next = prev.next.next;
//            }
//            else
//                prev = prev.next;
//        }
//        return head;
//    }

//    // 具有虚拟头结点的链表
//    public ListNode removeElements(ListNode head, int val) {
//        ListNode dummyHead = new ListNode(-1);
//        dummyHead.next = head;
//
//        ListNode prev = dummyHead;
//        while (prev.next != null) {
//            if (prev.next.val == val)
//                prev.next = prev.next.next;
//            else
//                prev = prev.next;
//        }
//        return dummyHead.next;
//    }

    // 递归
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

//        ListNode res = removeElements(head.next, val);
//        if (head.val == val)
//            return res;
//        else {
//            head.next = res;
//            return head;
//        }

        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution()).removeElements(head, 6);
        System.out.println(res);
    }

}
