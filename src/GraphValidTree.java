import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
class GraphValidTree {
   public boolean validTree(int n, int[][] edges) {
         UnionFind set = new UnionFind(n);
         for (int[] edge : edges) {
             if (set.find(edge[0], edge[1])) return false;    // cycle check
             set.union(edge[0], edge[1]);
         }
         return set.size() == 1;                             // single tree check
     }

     class UnionFind {
         private int[] id, size;
         private int count;

         public UnionFind(int len) {
             id = new int[len];
             size = new int[len];
             for (int i = 0; i < len; i++) {
                 id[i] = i;
                 size[i] = 1;
             }
             count = len;
         }

         public int size() {
             return count;
         }

         private int root(int i) {
             while (i != id[i]) {
                 id[i] = id[id[i]];
                 i = id[i];
             }
             return i;
         }

         public boolean find(int p, int q) {
             return root(p) == root(q);
         }

         public void union(int p, int q) {
             int pi = root(p), qi = root(q);
             if (size[pi] < size[qi]) {
                 id[pi] = qi;
                 size[qi] += size[pi];
             } else {
                 id[qi] = pi;
                 size[pi] += size[qi];
             }
             count--;
         }
     }


//buildTree preorder

     // 先建树，然后再找leaf O(n)

      public static int[] findNotMatching(int[] nums1,int[] nums2){
         TreeNode root1=contructTree(nums1);
         TreeNode root2=contructTree(nums2);
         int[] res=new int[2];
         List<Integer> res1=new ArrayList<>();//we use list to add leaf only
         List<Integer> res2=new ArrayList<>();

         // get leaf node values
         helper(root1,res1);
         helper(root2,res2);
         for(int i = 0;i < Math.min(res1.size(),res2.size());i++){
             if(res1.get(i)!=res2.get(i)){
                 res[0]=res1.get(i);
                 res[1]=res2.get(i);
                 break;
             }
         }
         return res;
      }

      private static TreeNode contructTree(int[] nums) {
         TreeNode root = new TreeNode(nums[0]);
         for (int i = 1; i<nums.length; i++) {
             construct(root, nums[i]);
         }
         return root;
      }
     private static void construct(TreeNode node, int val) {
         if(val < node .val) {
             if(node.left == null) {
                 node.left = new TreeNode(val);
             } else construct(node.left, val);
         }
         if (val > node.val) {
             if (node.right == null) {
                 node.right = new TreeNode(val);
             } else construct(node.right, val);
         }
     }

     public static void helper(TreeNode root,List<Integer> res){
         if(root==null) return;
         if(root.left==null&&root.right==null) res.add(root.val);//add leaf only
         helper(root.left,res);
         helper(root.right,res);
     }


     static class TreeNode {
         TreeNode left, right;
         int val;

         TreeNode(int val) {
             this.val = val;
         }
     }

     public static void main(String[] args) {
        int[] arr1 = {4,2,1,3};
        int[] arr2 = {4,2,3,1};
        for(int x : findFirstNonMatchingLeavesInBinaryTree(arr1,arr2)) {
            System.out.println(x);
        }
         for(int x : findFirstNonMatchingLeavesInBST1(arr1,arr2)) {
             System.out.println(x);
         }
         for(int x : findNotMatching(arr1,arr2)) {
             System.out.println(x);
         }
     }

     //buildTree using stack

     public static int[] findFirstNonMatchingLeavesInBinaryTree(int[] preorder1, int[] preorder2) {
         int m = preorder1.length, n = preorder2.length;
         int i = 0, j = 0;
         while(true) {
             while (i < m) {
                 if (i + 2 < m && preorder1[i + 1] == -1 && preorder1[i + 2] == -1) {
                     break;
                 }
                 if (i + 2 == m && preorder1[i + 1] == -1) {
                     break;
                 }
                 if (i + 1 == m) {
                     break;
                 }
                 i += 1;
             }
             while (j < n) {
                 if (j + 2 < n && preorder2[j + 1] == -1 && preorder2[j + 2] == -1) {
                     break;
                 }
                 if (j + 2 == n && preorder2[j + 1] == -1) {
                     break;
                 }
                 if (j + 1 == n) {
                     break;
                 }
                 j += 1;
             }
             if (i >= m || j >= n) {
                 return new int[]{-1, -1};
             }
             if (preorder1[i] != preorder2[j]) {
                 return new int[]{preorder1[i], preorder2[j]};
             }
             i += 1;
             j += 1;
         }
     }


        public static int[] findFirstNonMatchingLeavesInBST1(int[] preorder1, int[] preorder2) {
            Stack<Integer> s1 = new Stack<Integer>();
            Stack<Integer> s2 = new Stack<Integer>();
            int m = preorder1.length, n = preorder2.length;
            int i = 0, j = 0;
            int leaf1 = 0, leaf2 = 0;
            while(true) {
                while(i < m) {
                    int num = preorder1[i];
                    int num_pop = 0;
                    while(!s1.isEmpty() && num > s1.peek()) {
                        s1.pop();
                        num_pop += 1;
                    }
                    // 说明原栈顶元素是叶子，退出循环进行比较
                    if(num_pop >= 2) break;
                    s1.push(num);
                    leaf1 = num;
                    i += 1;
                }
                while(j < n) {
                    int num = preorder2[j];
                    int num_pop = 0;
                    while(!s2.isEmpty() && num > s2.peek()) {
                        s2.pop();
                        num_pop += 1;
                    }
                    // 说明原栈顶元素是叶子，退出循环进行比较
                    if(num_pop >= 2) break;
                    s2.push(num);
                    leaf2 = num;
                    j += 1;
                }
                if(leaf1 != leaf2) {
                    return new int[]{leaf1, leaf2};
                }
                if(i >= m || j >= n) {
                    return new int[]{-1, -1};
                }
            }
        }
    }

