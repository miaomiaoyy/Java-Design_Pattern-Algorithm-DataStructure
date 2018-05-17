public class SegementTree {
    public class NumArray {

        SegmentTreeNode root;
        public NumArray(int[] nums) {
            if (nums.length == 0) return;
            root = buildTree(nums, 0, nums.length - 1);
        }

        public int sumRange(int i, int j) {
            return query(root, i, j);
        }

        private int query(SegmentTreeNode node, int start, int end) {
            int mid = node.start + ((node.end - node.start) >> 1);
            if (start <= node.start && end >= node.end) {
                return node.sum;
            } else if (end <= mid) {
                return query(node.left, start, end);
            } else if (start > mid) {
                return query(node.right, start, end);
            } else if (start <= mid && end > mid) {
                return query(node.left, start, mid) + query(node.right, mid + 1, end);
            }
            return 0;
        }

        private SegmentTreeNode buildTree(int[] nums, int l, int r) {
            if (l == r) {
                return new SegmentTreeNode(l, r, nums[l]);
            }
            int mid = l + ((r - l) >> 1);
            SegmentTreeNode leftNode = buildTree(nums, l, mid);
            SegmentTreeNode rightNode = buildTree(nums, mid + 1, r);
            SegmentTreeNode node = new SegmentTreeNode(l, r, leftNode.sum + rightNode.sum);
            node.left = leftNode;
            node.right = rightNode;
            return node;
        }

        class SegmentTreeNode {
            int start, end, sum;
            SegmentTreeNode left, right;
            public SegmentTreeNode(int s, int e, int val) {
                start = s;
                end = e;
                sum = val;
            }
        }
    }
}
