import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class EXAM {

    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 1) return nums[0];

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int pivotPos = partition(nums, left, right);
            if(pivotPos - left + 1 < k){
                k = k - (pivotPos - left + 1);//shrink k value
                left = pivotPos + 1;//move left to pivotPos + 1
            }else if(pivotPos - left + 1 > k){
                right = pivotPos - 1;//shrink right by 1 at least
            }else{
                return nums[pivotPos];
            }
        }
        return 0;
    }

    //make elements value between [0, leftBound] are all >= pivot
    private int partition(int[] array, int left, int right){
        int pivotIndex = left + (right - left)/2;
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, right);

        int leftBound = left;
        int rightBound = right - 1;
        while(leftBound <= rightBound){
            if(array[leftBound] >= pivot){
                leftBound++;
            }else if(array[rightBound] < pivot){
                rightBound--;
            }else{
                swap(array, leftBound++, rightBound--);
            }
        }
        swap(array, leftBound, right);
        return leftBound;
    }


    private void swap(int[] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }


    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int start, int end) {
        if(start > end) {
            return;
        }
        int pivot = partition2(nums, start, end);
        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    private int partition2(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start - 1;
        for(int j = start; j <= end; j++) {
            if (nums[j] < pivot) {
                swap(nums, i + 1, j);
                i++;
                System.out.print(Arrays.toString(nums));
            }
        }
        swap(nums, i + 1, end);

        return i + 1;
    }

    static int LPS(char A[]) {
        if(A.length == 0) {
            return 0;
        }
        int dp[][] = new int[A.length][A.length];
        for(int i = 0; i < A.length; i++){
            dp[i][i] = 1;
        }
        for(int len = 2; len <= A.length; len++) {
            for(int i = 0; i + len <= A.length; i++) {
                int j = i + len - 1;
                if(A[i] == A[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][A.length-1];
    }
    //we can transform string to char array to easy compute
    static int LCSubstring(char A[], char B[]) {
        if(A.length == 0 || B.length == 0) {
            return 0;
        }
        int[][] dp = new int[A.length + 1][B.length + 1];
        int max = 0;
        for(int i = 1 ; i <= A.length; i++) {
            for(int j = 1 ; j <= B.length; j++) {
                if(A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max =Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }

        int cost = Integer.MAX_VALUE;
     int woodCut(int start, int end, int k) {
       if(start == end) {
           return 1;
       }
       int[][] dp = new int[end - start][k];

        for(int i = start; i <= end; i++) {

            cost = Math.min(cost, i - start + Math.min(woodCut(0, i - 1, k - 1),
                    woodCut(i + 1, end, k - 1)));

        }
        return cost;
    }

    static int kthHead(int k, int n, int[] P) {
        int[][] dp = new int[k + 1][n + 1];
        dp[0][0] = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < k; j++) {
                dp[j][i] = dp[j][i - 1] * (1 -  P[i]) + dp[j - 1][i - 1]* P[i];
            }
        }
        return dp[k][n];
    }

    static boolean changCoinOnce(int[] coins, int v) {

        boolean[][] dp = new boolean[coins.length + 1][v + 1];
       // boolean[] used = new boolean[coins.length];
        for(int i = 0; i <= coins.length; i++) {
            dp[i][0] = true;
        }
        for(int j = 1; j <= coins.length; j++) {
            for(int i = 0; i <= v; i++) {
                //boolean[] used = new boolean[coins.length];
                if (i >= coins[j - 1]) {
                    dp[j][i] = dp[j][i] || dp[j - 1][i - coins[j - 1]];
                }
            }
        }
        return dp[coins.length][v];
    }

    public static double gameAwins(int n) {
        double[][] dp = new double[n + 1][n + 1];
        dp[0][0] = 1;

        double sum = 0;
        for(int i = 1; i <= n; i++) {
            dp[i][0] = 0.5 * dp[i - 1][0];
        }
        for(int i = 1; i <= n; i++) {
            dp[0][i] = 0.5 * dp[0][ i - 1];
        }
        for(int j = 1; j <= n; j++) {
            for(int i = 1; i <= n; i++) {
                dp[i][j - 1] =  dp[i - 1][j - 1] - dp[i - 1][j];
            }
            sum += dp[n][j];
        }

        return sum;
    }

    //can use multiple times
    static boolean changeCoinMultiple(int[] coins, int v) {
        if(v == 0) {
            return true;
        }
        boolean[] dp = new boolean[v + 1];
        dp[0] = true;
        for(int coin: coins) {
            for(int i = 1; i <= v; i++) {
                if(i >= coin)
                    dp[i] = dp[i - coin];
            }
        }
        return dp[v];
    }

    static boolean changeCoinK(int[] coins, int v, int k ) {

        boolean[][] dp = new boolean[v + 1][ k + 1];
        dp[0][0] = true;

        for(int coin: coins) {
            for(int i = 1; i <= v; i++) {
                for(int j = 1; j <= k; j++) {

                    if (i >= coin) {
                        dp[i][j] = dp[i - coin][j - 1];
                    }
                }
            }
        }
        return dp[v][k];
    }

    private void merge(int[] nums, int[] indices, int[] aux, int[] count, int start, int end) {
        if (start >= end) return;
        int mid = start+(end-start)/2;
        merge(nums, indices, aux, count, start, mid);
        merge(nums, indices, aux, count, mid+1, end);
        for (int i = start, j = mid + 1, k = start; k <= end; k++) {
            if (i == mid + 1) aux[k] = indices[j++];
            else if (j == end+1) {
                aux[k] = indices[i];
                count[indices[i++]] += j-mid-1;
            } else if (nums[indices[i]] <= nums[indices[j]]) {
                aux[k] = indices[i];
                count[indices[i++]] += j-mid-1;
            } else {
                aux[k] = indices[j++];
            }
        }
        for (int i = start; i <= end; i++) {
            indices[i] = aux[i];
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] aux = new int[n], indices = new int[n], count = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        merge(nums, indices, aux, count, 0, nums.length-1);
        LinkedList<Integer> result = new LinkedList<>();
        for (int c : count) result.add(c);
        return result;
    }
//Tree
    TreeNode buildTree(int[] preOrder, int[] inOrder) {
        return buildTree(preOrder, inOrder, 0, inOrder.length - 1, 0);
    }

    private TreeNode buildTree(int[] preOrder, int[] inOrder, int inStart, int inEnd, int preStart) {
        if(preStart > preOrder.length - 1 || inStart > inEnd) {
            return  null;
        }
        TreeNode root = new TreeNode(preOrder[preStart]);
        int id = 0;
        //count the number from left to root and from root to right
        for(int i = inStart; i <= inEnd; i++) {
            if(inOrder[i] == root.val) {
                id = i;
            }
        }
        root.left = buildTree(preOrder, inOrder, inStart, id - 1, preStart + 1);
        root.right = buildTree(preOrder, inOrder, id + 1, inEnd, preStart + id - inStart + 1);
        return root;
    }
    static boolean changeCoin(int[] coins, int v) {
        if(v == 0) {
            return true;
        }

        boolean[] dp = new boolean[v + 1];
        dp[0] = true;
        for (int j = 0; j <= v; j++) {
            for (int i = 0; i < coins.length; i++) {
                if (coins[i] <= j) {
                    dp[j] = dp[j] || dp[j - coins[i]];
                }
            }
        }
        return dp[v];
    }
    static boolean changeCoin1(int[] coins, int v) {
        if(v == 0) {
            return true;
        }

        boolean[] dp = new boolean[v + 1];
        dp[0] = true;

            for (int i = 0; i < coins.length; i++) {
                for (int j = 0; j <= v; j++) {
                    if (coins[i] <= j) {
                        dp[j] = dp[j] || dp[j - coins[i]];
                    }
                }
            }
        return dp[v];
    }

    public static void main(String[] args) {
        EXAM exam = new EXAM();
        int[] nums = new int[] {6,4,3,1,5,9};

        //exam.quickSort(nums);

        //woodCut(0, 10,2);
        int[] coins = {5,10};
       // System.out.print(changeCoin1(coins,40));
        System.out.print(changCoinOnce(coins, 20));
       // System.out.print(changeCoinMultiple(coins,14));
        // System.out.print(changeCoinK(coins,14, 3));
        //exam.countSmaller(new int[]{2,1,5,7,8});
        System.out.print( gameAwins(2));
    }
}

