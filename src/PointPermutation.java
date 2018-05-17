import java.util.Map;

public class PointPermutation {
    //public static boolean canRead(int x1, int y1, int x2, int y2) {

    private static boolean dfs(int x1, int y1, int x2, int y2) {
        if ((x1 + y1 == x2 && y1 == y2) || (x1 == x2 && x1 + y1 == y2)) {
            return true;
        }

        if (x1 + y1 <= x2 || x1 + y1 <= y2) {
            return dfs(x1, x1 + y1, x2, y2) || dfs(x1 + y1, y1, x2, y2);
        }

        return false;
    }

    static void foo(int value) {
        value = 100;
    }

    static void foo1(String text) {
        text = "windows";
    }

    static void foo2(StringBuilder builder) {
        builder.append("4");
    }

    static void foo3(StringBuilder builder) {
        builder = new StringBuilder("ipad");
    }
    static void print(Testfile.ListNode head) {
        for (Testfile.ListNode node = head; node != null; node = node.next) {
            System.out.print(node.val);
            System.out.print("->");

        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        Integer a = 0, b = 0;
        Testfile.ListNode node1 = new Testfile.ListNode(1);
        Testfile.ListNode node2 = new Testfile.ListNode(2);
        Testfile.ListNode node3 = new Testfile.ListNode(3);
        //Map.of(a, b);
        Testfile.ListNode head = node1;
        node1.next = node2;
        node2.next = node3;

        print(head);//语句1

        node1= node2;
        print(head);//语句2




        System.out.println(dfs(1,4,5,14));
        int num= 99;
        String str = "hello";
        foo(num); // num 没有被改变
        foo1(str); // str 也没有被改变
        StringBuilder sb = new StringBuilder("iphone");
        foo2(sb); // sb 被改变了，变成了"iphone4"。
        System.out.println(sb);
        foo3(sb); // sb 没有被改变，还是 "iphone"。
        System.out.println(num);
        System.out.println(str);
        System.out.println(sb);


    }
}
