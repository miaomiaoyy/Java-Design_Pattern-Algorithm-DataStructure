import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TestMAP {
//    public static int[] nextGreaterElements(int[] nums) {
//        int[] copy = new int[nums.length * 2];
//        int len = nums.length;
//        for(int i = 0 ; i < len* 2; i++) {
//            copy[i] = nums[i%len];
//        }
//        Map<Integer,Integer> map = new HashMap<>();
//        Stack<Integer> stack = new Stack<>();
//        for(int num : copy) {
//            while(!stack.isEmpty() && stack.peek() < num && !map.containsKey(stack.peek())) {
//                map.put(stack.pop(), num);
//            }
//            stack.push(num);
//        }
//        for(int i = 0 ; i < nums.length; i++) {
//            nums[i] = map.getOrDefault(nums[i], -1);
//        }
//        return nums;
//    }


    static int res;
    public static int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        res = 0;
        helper(root);
        return res;
    }

    public static int helper(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        res = left + right + root.val;
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {
        int[] num = {100,1,11,1,120,111,123,1,-1,-100};
        //nextGreaterElements(num);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(20);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        System.out.print(maxPathSum(root));
    }
}

