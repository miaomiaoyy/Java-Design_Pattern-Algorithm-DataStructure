import apple.laf.JRSUIUtils;

import java.util.*;

public class Google_OA {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

//        int len = 0;
//        public int longestUnivaluePath(TreeNode root) {
//            if (root == null) return 0;
//            len = 0;
//            getLen(root, root.val);
//            return len;
//        }
//
//        private int getLen(TreeNode node, int val) {
//            if (node == null) return 0;
//            int left = getLen(node.left, node.val);
//            int right = getLen(node.right, node.val);
//            len = Math.max(len, left + right);
//            if (val == node.val)  return Math.max(left, right) + 1;
//            return 0;
//        }


    static class TreeNode{
            int val;
            List<TreeNode> children;
            boolean visited;
            TreeNode(int x) {
                this.val = x;
                children = new ArrayList<>();
                visited = false;
            }
     }

    int max = 0;


    public int findRes(int[] arr1, int[] arr2) {
        if(arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0) {
            return 0;
        }
        Map<Integer, TreeNode> map = new HashMap<>();
        for(int i = 0; i < arr1.length; i++) {
            map.put(i + 1, new TreeNode(arr1[i]));
        }

        for(int j = 0; j < arr2.length; j += 2) {
            map.get(arr2[j]).children.add(map.get(arr2[j + 1]));
            map.get(arr2[j + 1]).children.add(map.get(arr2[j]));
        }

        for(Map.Entry<Integer, TreeNode> entry : map.entrySet()) {
            TreeNode node = entry.getValue();
            if(node.visited){
                continue;
            }
            max = Math.max(max, getIndenticalVal(node, node.val));
        }

        return max;
    }

    private int getIndenticalVal(TreeNode node, int val) {
        if(node == null) {
            return 0;
        }
        if(node.visited){
            return 0;
        }

        node.visited = true;

        List<Integer> res = new ArrayList<>();
        for (TreeNode tn : node.children) {
            res.add(getIndenticalVal(tn, node.val));
        }
        Collections.sort(res);
        if(res.size() >= 2) {
            max = Math.max(max, res.get(res.size() - 1) + res.get(res.size() - 2));
            System.out.println(max);
            if (val == node.val) {
                return Math.max(res.get(res.size() - 1), res.get(res.size() - 2)) + 1;
            }
        } else {
            max = res.size() - 1;
            if (val == node.val) {
                return res.get(res.size() - 1) + 1;
            }
        }
        return 0;

    }
//
//    public int longestUnivaluePath2(TreeNode root) {
//        if (root == null) return 0;
//        getChild(root, root.val);
//        return max;
//    }
//
//    private int getChild(TreeNode node, int val) {
//        if (node == null) return 0;
//        List<Integer> res = new ArrayList<>();
//        for (TreeNode tn : node.children) {
//            res.add(getChild(tn, node.val));
//        }
//
////        Collections.sort(res);
////two for loop
//        max = Math.max(max, res.get(res.size() - 1) + res.get(res.size() - 2));
//        System.out.println(max);
//        if (val == node.val) {
//            return Math.max(res.get(res.size() - 1), res.get(res.size() - 2)) + 1;
//        }
//        return 0;
//    }
////        int left = getLen(node.left, node.val);
////        int right = getLen(node.right, node.val);
////        len = Math.max(len, left + right);
////        if (val == node.val)  return Math.max(left, right) + 1;
//

    public static void main(String[] args) {
        Google_OA oa = new Google_OA();
//        TreeNode root = new TreeNode(1);
//        root.children.add(new TreeNode(2));
//        root.children.add(new TreeNode(4));
//        root.children.add(new TreeNode(3));
//        root.children.add(new TreeNode(1));
//        root.children.get(3).children.add(new TreeNode(1));
//        root.children.get(3).children.add(new TreeNode(2));
//        root.children.get(3).children.add(new TreeNode(3));
        int[] a = new int[]{1,1,1,2,1};
        int[] b = new int[]{1,2,1,3,3,4,3,5};
        oa.findRes(a, b);
    }


}
