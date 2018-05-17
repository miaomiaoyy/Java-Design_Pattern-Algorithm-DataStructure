import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class tree {

    public static TreeNode invertTree(TreeNode root) {
        if(null == root) return null;
        TreeNode left = root.left, right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }

    private static TreeNode buildTree(int[] nums) {
        TreeNode root = new TreeNode(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            build(root, nums[i]);
        }
        return root;
    }

    private static void build(TreeNode root, int val) {
        if(val > root.val) {
            if(root.right == null) {
                root.right = new TreeNode(val);
                System.out.println(root.val + "'s right is :" + val);
            } else {
                build(root.right, val);
            }
        } else {
            if(root.left == null) {
                root.left = new TreeNode(val);
                System.out.println(root.val +"'s left:" + val);
            } else {
                build(root.left, val);
            }
        }
    }

        public static void main(String[] agrs) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            //invertTree(root);
            //buildTree("(a(b(cd(d)(d))");
            //buildTree("(a(b(cd(d)(d))");
            buildTree(new int[]{10,2,1,4,3,8,6,9,12,11});
        }

    }

class TreeNode{
    TreeNode left,right;
    int val;
    TreeNode(int val) {
        this.val = val;
    }
}
