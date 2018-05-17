import java.util.LinkedList;
import java.util.Queue;

public class Populating_nodes {
    static class TreeLinkNode {
        TreeLinkNode next, left, right;
        int val;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode populate(TreeLinkNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            TreeLinkNode pre = null;
            for (int i = 0; i < size; i++) {
                TreeLinkNode top = q.poll();
                if(top.left != null) {
                    q.offer(top.left);
                }
                if(top.right != null) {
                    q.offer(top.right);
                }

                if(pre != null) {
                    pre.next = top;
                }
                pre = top;
                top.next = null;
            }
        }
        return root;
    }

    public void connect(TreeLinkNode root) {
        TreeLinkNode dummy = new TreeLinkNode(0);
        TreeLinkNode pre = dummy;
        TreeLinkNode cur = root;
        while( cur != null ) {
            if(cur.left!= null) {
                pre.next = cur.left;
                pre = pre.next;
            }
            if(cur.right != null) {
                pre.next = cur.right;
                pre = pre.next;
            }
            cur = cur.next;
            if(cur == null) {
                cur = dummy.next;
                pre = dummy;
                pre.next = null;
            }
        }
    }
    public static void main(String[] args) {
        Populating_nodes nodes = new Populating_nodes();
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        System.out.println(nodes.populate(root));
    }
}
