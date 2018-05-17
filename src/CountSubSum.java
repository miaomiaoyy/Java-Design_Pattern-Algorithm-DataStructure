public class CountSubSum {

    static int count = 0;
    static int lower;
    static int upper;

    public static int countRangeSum(int[] nums, int lo, int up) {
        long[] sum = new long[nums.length + 1];
        long[] temp = new long[nums.length + 1];
        sum[0] = 0;
        lower = lo;
        upper = up;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + (long) nums[i - 1];
        }

        mergesort(sum, 0, sum.length - 1, temp);
        return count;
    }

    private static void mergesort(long[] sum, int start, int end, long[] temp) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergesort(sum, start, mid, temp);
        mergesort(sum, mid + 1, end, temp);
        merge(sum, start, mid, end, temp);
    }

    private static void merge(long[] sum, int start, int mid, int end, long[] temp) {
        int right = mid + 1;
        int index = start;
        int low = mid + 1, high = mid + 1;
        for (int left = start; left <= mid; left++) {
            while (low <= end && sum[low] - sum[left] < lower) {
                low++;
            }
            while (high <= end && sum[high] - sum[left] <= upper) {
                high++;
            }
            while (right <= end && sum[right] < sum[left]) {
                temp[index++] = sum[right++];
            }
            temp[index++] = sum[left];
            count += high - low;
        }
        while (right <= end) {
            temp[index++] = sum[right++];
        }

        for (int i = start; i <= end; i++) {

            sum[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,-5,1};

        countRangeSum(nums, -2,2);
    }
}
