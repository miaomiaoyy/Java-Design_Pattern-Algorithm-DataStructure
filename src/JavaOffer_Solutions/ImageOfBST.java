package JavaOffer_Solutions;
//我们先前序遍历这棵树的每个结点，如果遍历到的结点有子结点，
// 就交换它的两个子结点。当交换完所有非叶子结点的左右子结点之后，就得到了树的镜像。
public class ImageOfBST {
    public static class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;
        public BinaryTreeNode(int val) {
            this.val = val;
        }
    }

    public static BinaryTreeNode getImage(BinaryTreeNode root) {
        if(root == null) {
            return root;
        }
        BinaryTreeNode left = getImage(root.right);
        BinaryTreeNode right = getImage(root.left);
        root.left = left;
        root.right = right;
        System.out.print(root.val);

        return root;
    }
    public static void main(String[] args) {
        BinaryTreeNode rootA1 = new BinaryTreeNode(1);
        BinaryTreeNode rootA2 = new BinaryTreeNode(2);
        BinaryTreeNode rootA3 = new BinaryTreeNode(3);
        BinaryTreeNode rootA4 = new BinaryTreeNode(4);
        BinaryTreeNode rootA5 = new BinaryTreeNode(5);
        rootA1.left = rootA2;
        rootA1.right = rootA3;
        rootA2.left = rootA4;
        rootA2.right = rootA5;
        getImage(rootA1);
    }


}
