package JavaOffer_Solutions;

public class MergeLinkedList {
    public static class ListNode {
        int value;
        ListNode next;
        public ListNode(int value) {
            this.value = value;
        }
    }

    public static ListNode merge(ListNode head1, ListNode head2) {
        // 如果第一个链表为空，返回第二个链表头结点
        if(head1 == null) {
            return head2;
        }
        if(head2 == null) {
            return head1;
        }
        ListNode newNode = new ListNode(-1);
        ListNode dummy = newNode;
        while(head1 != null && head2 != null) {
            if(head1.value < head2.value) {
                newNode.next = head1;
                head1 = head1.next;
            } else {
                newNode.next = head2;
                head2 = head2.next;
            }
            newNode = newNode.next;
        }
        if (head1 != null) {
            newNode.next = head1;
        }

        // 如果第二个链表的元素未处理完将其，接到合并链表的最后一个结点之后
        if (head2 != null) {
            newNode.next = head2;
        }
    return dummy.next;
    }

}
