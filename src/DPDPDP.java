import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DPDPDP {
    // class Solution {
//      //0 1 2 3 4 5  6 7 8
//     //[1,3,6,7,9,4,10,5,6]
//     dp[1] = dp[0] + 1 = 2; dp[2] = dp[1] + 1 = 3; dp[3] = 4, dp[4]=5; dp[6] = dp[5] + 1 = 2 !!!!会覆盖之前的dp[4] + 1
// public static int lengthOfLIS(int[] nums) {
// 		if(nums.length == 0 || nums == null){
//             return 0;
//         }
//         int []dp = new int[nums.length];
//         int max = Integer.MIN_VALUE;
//         for (int i = 0; i < nums.length; i++) {
//             dp[i] = 1;
//             for (int j = 0; j < i; j++) {
//                 if (nums[j] < nums[i]) { // num[j] is the number bf num[i]
//                    dp[i] = dp[j] + 1;
//                    // dp[i] = dp[i] > dp[j] + 1 ? dp[i] : dp[j] + 1;
//                 }
//             }
//             if (dp[i] > max) {
//                 max = dp[i];
//             }
//         }
//         return max;
//     }
// }

        public static int lengthOfLIS(int[] nums) {

            int n = nums.length;
            if (n == 0) {
                return 0;
            }
            int[] tails = new int[n];
            int end = 0;
            for (int i = 0; i < n; i++) {
                int pos = lowerBound(tails, nums[i], end);
                if (pos == end) {
                    tails[end++] = nums[i];
                } else {
                    tails[pos] = nums[i];
                }
            }
            return end;
        }


//         int[] tailTable   = new int[size];
//         int len; // always points empty slot

//         tailTable[0] = A[0];
//         len = 1;
//         for (int i = 1; i < size; i++)
//         {
//             if (A[i] < tailTable[0])
//                 // new smallest value
//                 tailTable[0] = A[i];

//             else if (A[i] > tailTable[len-1])
//                 // A[i] wants to extend largest subsequence
//                 tailTable[len++] = A[i];

//             else
//                 // A[i] wants to be current end candidate of an existing
//                 // subsequence. It will replace ceil value in tailTable
//             tailTable[CeilIndex(tailTable, -1, len-1, A[i])] = A[i];
//         }

//         return len;
//     }

        private static int lowerBound(int[] tails, int target, int end) {
            int start = 0;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (tails[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }

            return start;
        }



//    public static void main(String[] args) {
//        int[] nums = {2,4,1,6,8};
//        lengthOfLIS(nums);
//    }


    public static int countCornerRectangles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for(int i = 0; i < m; i++) {
            List<List<Integer>> temp = new ArrayList<>();
            dfs(temp, new ArrayList<>(), 0, grid[i]);
            for(List<Integer> pair : temp) {
                for(int j =  i + 1; j < m; j++) {
                    if(grid[j][pair.get(0)] == 1 && grid[j][pair.get(1)] == 1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void dfs(List<List<Integer>> res, List<Integer> cur, int index, int[] nums) {
//        if(index == nums.length) {
//            return;
//        }

        if(cur.size() == 2) {
            res.add(new ArrayList<>(cur));
        } else {
            for(int i = index; i < nums.length;i++) {
                if(nums[i] == 1) {
                    cur.add(i);
                    dfs(res, cur, i + 1, nums);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,0},{1,0,1},{1,0,1},{0,1,0}};
        System.out.print(countCornerRectangles(grid));
    }
}

