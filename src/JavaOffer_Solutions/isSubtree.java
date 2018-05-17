package JavaOffer_Solutions;

public class isSubtree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }


//        if(a.value == b.value) {
//            return isSubtree(a.left, b)||isSubtree(a.right, b)||isSame(a, b);
//        } 这样写是错的因为 【1，1】【1】第一个node 也一样但是b应该和左子树匹配


    public boolean isSubtree(TreeNode a, TreeNode b) {
        if(a == null) {
            return b == null;
        }
        if(b == null) {
            return a == null;
        }
        if(isSame(a, b)) {
            return true;
        }else {
            return isSubtree(a.left, b)||isSubtree(a.right, b);
        }
    }

    private boolean isSame(TreeNode a, TreeNode b) {
        if(a == null) {
            return b == null;
        }
        if(b == null) {
            return a == null;
        }
        if(a.val == b.val) {
            return isSame(a.left, b.left) && isSame(a.right, b.right);
        }
        else return false;
    }
}
