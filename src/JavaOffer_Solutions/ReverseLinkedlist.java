//package JavaOffer_Solutions;
//
//public class ReverseLinkedlist {
//
//    public static class ListNode {
//       int val;
//          ListNode next;
//          ListNode(int x) { val = x; }
//    }
//    public ListNode deleteDuplicates(ListNode head) {
//        if(head == null) return head;
//        ListNode cur = head.next, pre = head;
//
//        while(cur != null) {
//            if(cur.val == pre.val) {
//                pre.next = cur.next;
//            }
//            else {
//                pre = pre.next;
//            }
//            cur = cur.next;
//        }
//        return head;
//    }
//
//
//    public class yang {
//
////    [2,4,1,5,3]. 3
////    [1,4,2]
////    [1,2,3, 4, 5]
//
//        public static int[] quickselect(int[] arr, int start, int end) {
//            if(start < end) return new int[] {};
//            int pivot = partition(arr, start ,end );
//            //int mid = (0 + arr.length)/2;
//            quickselect(arr, start, pivot);
//            quickselect(arr, pivot + 1, end);
//            return arr;
//        }
//        public static int partition(int[] arr, int start, int end) {
//            int pivot = arr[arr.length - 1];
//            int id = start - 1;
//            for(int i = start; i < end; i++) {
//                if(arr[i] < pivot) {
//                    swap(arr, id + 1, i);
//                }
//                id++;
//
//                swap(arr, id + 1, arr.length - 1);
//            }
//            return id + 1;
//        }
//
//        private static void swap(int[] arr, int i, int j) {
//            int temp = arr[i];
//            arr[i] = arr[j];
//            arr[j] = temp;
//        }
//
//        public static void main(String[] args) {
//            // write your code here
//            System.out.println("Hello World!");
//            int[] arr = new int[] {2,3,1,4,6};
//            quickselect(arr, 0, arr.length - 1);
//        }
//    }
//
//
//    public ListNode deleteDuplicates2(ListNode head) {
//        ListNode cur = head;
//        ListNode dummy = new ListNode(0);
//        ListNode pre = dummy;
//        dummy.next = head;
//        while(cur != null) {
//            //先把cur 指针指向最后一个相同的
//            while(cur.next != null && cur.val == cur.next.val) {
//                cur = cur.next;
//            }
//            //这里不是比较值而是pre.next 就是cur 指针
//            if(pre.next == cur) { //！pre.next.val == cur.val
//                pre = pre.next;
//            } else {
//                pre.next = cur.next;//
//            }
//            cur = cur.next;
//        }
//        return dummy.next;
//    }
//
//
//
//    public static void main(String[] args) {
//        ReverseLinkedlist rv =  new ReverseLinkedlist();
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(1);
//        head.next.next = new ListNode(2);
//        head = rv.deleteDuplicates(head);
//        head = rv.deleteDuplicates2(head);
//        while(head != null) {
//            System.out.print(head.val);
//            head = head.next;
//        }
//    }
//}
