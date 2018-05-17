import sun.awt.image.ImageWatched;

import java.util.*;

public class TreeTraverse {
    public static List<Integer> preOrder(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null) {
            return res;
        }
        Stack<TreeNode> st = new Stack<>();
        st.add(root);
        while(!st.isEmpty()) {
            TreeNode top = st.pop();
            res.addLast(top.val);

            if(top.right != null) {
                st.add(top.right);
            }
            if(top.left != null) {
                st.add(top.left);
            }
        }
        return res;
    }

    public static List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        while(!st.isEmpty() || cur != null) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            TreeNode top = st.pop();
            res.add(top.val);
            cur = top.right;
//            TreeNode right = top.right;
//            while (right != null) {
//                st.push(right);
//                right = right.left;
//            }
        }
        return res;
    }

    public static List<Integer> postOrder(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null) {
            return res;
        }
        Stack<TreeNode> st = new Stack<>();
        st.add(root);
        while(!st.isEmpty()) {
            TreeNode top = st.pop();
            res.addFirst(top.val); //super easy just use Linkedlist

            if(top.left != null) {
                st.add(top.left);
            }
            if(top.right != null) {
                st.add(top.right);
            }

        }
        return res;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = q.size();
            for(int i = 0 ; i < size; i++) {
                TreeNode top = q.poll();
                if(i == size - 1) {
                    temp.add(top.val);
                }
                if (top.left != null) {
                    q.offer(top.left);
                }
                if (top.right != null) {
                    q.offer(top.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
    public static List<List<Integer>> tiltOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode top = q.poll();
                temp.add(top.val);
                TreeNode left = top.left;
                TreeNode right = top.right;
                while (left != null) {
                    temp.add(left.val);
                    if (left != null && left.right != null) {
                        q.offer(left.right);
                    }
                    left = left.left;
                }
                if (right != null) {
                    q.offer(right);
                }
            }
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.left.right.right.left = new TreeNode(8);
        root.left.right.right.right = new TreeNode(10);
        System.out.println("preorder:");
        for (Integer i : preOrder(root)) {
            System.out.println(i);
        }
        System.out.println("inorder:");
        for (Integer i : inOrder(root)) {
            System.out.println(i);
        }
        System.out.println("postorder:");
        for (Integer i : postOrder(root)) {
            System.out.println(i);
        }
        System.out.println("levelorder:");
        for (List<Integer> i : levelOrder(root)) {
            for(Integer j : i) {
                System.out.println((j));
            }
            System.out.println("next line:");
        }
        System.out.println("titleorder:");
        for (List<Integer> i : tiltOrder(root)) {
            for(Integer j : i) {
                System.out.println((j));
            }
            System.out.println("next line:");
        }
    }
}
