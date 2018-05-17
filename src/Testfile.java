import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Testfile {

    public static int minMutation(String start, String end, String[] bank) {
        char[] dict = {'A','C','G','T'};
        int count = 0, min = Integer.MAX_VALUE;
        Set<String> set = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for(String s : bank) {
            set.add(s);
        }
        if(!set.contains(end)) return -1;
        Queue<String> q = new LinkedList<>(); //BFS
        q.offer(start);
        while(!q.isEmpty()) {
            String pre = q.poll();
            for(int i = 0; i<pre.length(); i++) {
                char[] prev = pre.toCharArray();
                for(char c1 : dict) {
                    if(c1 == prev[i]) continue;
                    else prev[i] = c1;
                    String temp = String.valueOf(prev);
                    if (!visited.contains(temp) && set.contains(temp)) {
                        q.offer(temp);
                        pre = temp;
                        count++;
                        System.out.print(count);
                    }
                    visited.add(temp);
                    if (temp.equals(end)) {
                        min = Math.min(min, count);
                    }
                    else {
                        pre = start;
                    }
                }
                //start = String.valueOf(pre);
            }
        }
        return min;
    }

    public static void setZeroes(int[][] matrix) {
        boolean fr = false,fc = false;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) fr = true;
                    if(j == 0) fc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(fr) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if(fc) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }




    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, base = 0, sum = 0;
        ListNode dummy = new ListNode(0), cur = dummy;

        while(l1 != null && l2 != null ) {
            base = l1.val + l2.val + carry;
            sum =  base%10;
            carry = base/10;
            l1 = l1.next;
            l2 = l2.next;
            cur.next = new ListNode(sum);
            cur = cur.next;
        }

        while(l1 != null) {
            base = l1.val + carry;
            sum = base%10;
            carry = sum/10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            l1 = l1.next;
        }
        while(l2 != null) {
            base = l2.val + carry;
            sum = base%10;
            carry = sum/10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            l2 = l2.next;
        }
        if(carry != 0) {
            cur.next = new ListNode(carry);
            cur = cur.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        int[][] matrix = {{1,2,4},{2,0,9},{3,2,3}};
        //setZeroes(matrix);
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(9);
        b.next = new ListNode(9);
       // System.out.print(addTwoNumbers(a,b));
        String[] dic = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        System.out.print(minMutation(start,end,dic));
    }
}
